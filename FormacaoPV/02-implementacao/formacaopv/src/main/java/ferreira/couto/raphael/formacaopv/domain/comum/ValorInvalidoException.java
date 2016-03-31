package ferreira.couto.raphael.formacaopv.domain.comum;

public class ValorInvalidoException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public Object valor;
	
	public ValorInvalidoException(Object valor){
		this.valor = valor;
	}
	
	public ValorInvalidoException(Object valor, String message){
		super(message);
		this.valor = valor;
	}

}
