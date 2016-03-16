package ferreira.couto.raphael.formacaopv.view;

import java.lang.reflect.Field;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="entity-converter")
public class EntityConverter implements Converter{
	@Override
	public Object getAsObject(FacesContext ctx, UIComponent component, String value) {  
        if (value != null) {  
            return this.getAttributesFrom(component).get(value);  
        }  
        return null;  
    }  
  
	@Override
    public String getAsString(FacesContext ctx, UIComponent component, Object value) {  
  
        if (value != null  
                && !"".equals(value)) {  
            Object entity = value;  
            this.addAttribute(component, entity);  
            Integer codigo = getId(entity);  
            if (codigo != null) {  
                return String.valueOf(codigo);  
            }  
        }  
  
        return (String) value;  
    }
	
	private Integer getId(Object o){
		try {
			Field id = o.getClass().getDeclaredField("id");
			id.setAccessible(true);
			return (Integer) id.get(o);
		} catch (NoSuchFieldException | SecurityException 
				| IllegalArgumentException | IllegalAccessException e) {
			return null;
		}
	}
  
    private void addAttribute(UIComponent component,Object o) {
    	Integer id = getId(o);
    	if(id == null) return;
        this.getAttributesFrom(component).put(id.toString(), o);  
    }  
  
    private Map<String, Object> getAttributesFrom(UIComponent component) {  
    	return component.getAttributes();  
    }  

}
