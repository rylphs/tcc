package ferreira.couto.raphael.formacaopv.view;

import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import ferreira.couto.raphael.formacaopv.entity.BaseEntity;

@FacesConverter(value="entity-converter", forClass=BaseEntity.class)
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
		if(!(value instanceof BaseEntity)) return (String) value;
		
        if (value != null  
                && !"".equals(value)) {  
            BaseEntity entity = (BaseEntity) value;  
            this.addAttribute(component, entity);  
            Long codigo = entity.getId();  
            if (codigo != null) {  
                return String.valueOf(codigo);  
            }  
        }  
  
        return (String) value;  
    }
  
    private void addAttribute(UIComponent component, BaseEntity entity) {
    	Long id = entity.getId();
    	if(id == null) return;
        this.getAttributesFrom(component).put(id.toString(), entity);  
    }  
  
    private Map<String, Object> getAttributesFrom(UIComponent component) {  
    	return component.getAttributes();  
    }  

}
