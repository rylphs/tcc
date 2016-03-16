package ferreira.couto.raphael.formacaopv.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ferreira.couto.raphael.formacaopv.enums.Funcionalidade;

public class FormacaoPVException extends Exception{
	private static final long serialVersionUID = 1L;
	
	private Funcionalidade feature;
	private String status;
	private List<Object> parameters = new ArrayList<>();
	
	public FormacaoPVException(Funcionalidade feature, String status, Object... parameters){
		this.feature = feature;
		this.status = status;
		if(parameters != null){
			this.parameters.addAll(Arrays.asList(parameters));
		}
	}

	public Funcionalidade getFeature() {
		return feature;
	}

	public String getStatus() {
		return status;
	}
	
	public List<Object> getParameters(){
		return parameters;
	}
}
