package ferreira.couto.raphael.formacaopv.view;

import static javax.faces.application.FacesMessage.SEVERITY_ERROR;
import static javax.faces.application.FacesMessage.SEVERITY_INFO;
import static javax.faces.application.FacesMessage.SEVERITY_WARN;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import ferreira.couto.raphael.formacaopv.domain.comum.FormacaoPVException;
import ferreira.couto.raphael.formacaopv.domain.comum.Funcionalidade;

public abstract class BaseMB { 
	private static ResourceBundle bundle;
	
	private ResourceBundle getBundle() {
        if (bundle == null) {
            FacesContext context = FacesContext.getCurrentInstance();
            bundle = context.getApplication().getResourceBundle(context, "msg");
        }
        return bundle;
    }
	
	private String getMessage(Funcionalidade feature, String action){
		String key = feature.toString() + "." + action;
		try{
			return getBundle().getString(key);
		}
		catch(MissingResourceException e){
			key = "geral." + action;
			return getBundle().getString(key);
		}
	}
	
	private String getMessage(Funcionalidade feature, String action, Object... args){
		String key = feature.toString() + "." + action;
		try{
			String msg = getBundle().getString(key);
			return MessageFormat.format(msg, args);
		}
		catch(MissingResourceException e){
			key = "geral." + action;
			return  MessageFormat.format(getBundle().getString(key), args);
		}
	}
	
	protected void info(Funcionalidade feature, String action){
		String message = getMessage(feature, action);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(SEVERITY_INFO, message, null));
	}
	
	protected void info(Funcionalidade feature, String action, Object... args){
		String message = getMessage(feature, action, args);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(SEVERITY_INFO, message, null));
	}
	
	protected void error(FormacaoPVException exception){
		error(exception.getFeature(), exception.getStatus());
	}
	
	protected void error(Funcionalidade feature, String action){
		String message = getMessage(feature, action);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(SEVERITY_ERROR, message, null));
	}
	
	protected void error(Funcionalidade feature, String action, Object... args){
		String message = getMessage(feature, action, args);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(SEVERITY_ERROR, message, null));
	}
	
	protected void warn(FormacaoPVException exception){
		warn(exception.getFeature(), exception.getStatus());
	}
	
	protected void warn(Funcionalidade feature, String action){
		String message = getMessage(feature, action);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(SEVERITY_WARN, message, null));
	}
	
	protected void warn(Funcionalidade feature, String action, Object... args){
		String message = getMessage(feature, action, args);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(SEVERITY_WARN, message, null));
	}
}
