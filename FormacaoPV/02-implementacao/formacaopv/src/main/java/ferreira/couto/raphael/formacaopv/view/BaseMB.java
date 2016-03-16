package ferreira.couto.raphael.formacaopv.view;

import static javax.faces.application.FacesMessage.SEVERITY_ERROR;
import static javax.faces.application.FacesMessage.SEVERITY_INFO;
import static javax.faces.application.FacesMessage.SEVERITY_WARN;

import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import ferreira.couto.raphael.formacaopv.enums.Funcionalidade;

public abstract class BaseMB { 
	private static ResourceBundle bundle;
	
	private ResourceBundle getBundle() {
        if (bundle == null) {
            FacesContext context = FacesContext.getCurrentInstance();
            bundle = context.getApplication().getResourceBundle(context, "msg");
        }
        return bundle;
    }
	
	private String getMessage(Funcionalidade feature, String status){
		String key = feature.toString() + "." + status;
		return getBundle().getString(key);
	}
	
	protected void info(Funcionalidade feature, String status){
		String message = getMessage(feature, status);
		FacesContext.getCurrentInstance().addMessage("", new FacesMessage(SEVERITY_INFO, message, null));
	}
	
	protected void error(Funcionalidade feature, String status){
		String message = getMessage(feature, status);
		FacesContext.getCurrentInstance().addMessage("", new FacesMessage(SEVERITY_ERROR, message, null));
	}
	
	protected void warn(Funcionalidade feature, String status){
		String message = getMessage(feature, status);
		FacesContext.getCurrentInstance().addMessage("", new FacesMessage(SEVERITY_WARN, message, null));
	}
}
