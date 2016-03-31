package ferreira.couto.raphael.formacaopv.view;

import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import ferreira.couto.raphael.formacaopv.domain.comum.ValorSimples;

@FacesConverter(forClass=ValorSimples.class)
public class ValorSimplesConverter implements Converter{
	private void addAttribute(UIComponent component, String key, Object value){
		Map<String, Object> attributes = component.getAttributes();
		attributes.put(key, value);
	}
	
	private Object getAttribute(UIComponent component, String key){
		return component.getAttributes().get(key);
	}
	
	@Override
	public Object getAsObject(FacesContext ctx, UIComponent component, String value) {
        if (value != null && !"".equals(value)) {
        	ValorSimples valorSimples = (ValorSimples) getAttribute(component, "baseValue");
        	return valorSimples.fromString(value);
        }  
        return null;  
    }  
  
	@Override
    public String getAsString(FacesContext ctx, UIComponent component, Object value) { 
		if(!(value instanceof ValorSimples)) return (String) value;
        if (value != null  
                && !"".equals(value)) {  
            this.addAttribute(component, "baseValue", value);
            
            return value.toString();
        }  
  
        return (String) value;  
    }
}
