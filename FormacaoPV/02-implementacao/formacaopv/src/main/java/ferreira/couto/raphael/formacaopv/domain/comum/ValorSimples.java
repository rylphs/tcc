package ferreira.couto.raphael.formacaopv.domain.comum;

import java.io.Serializable;

public interface ValorSimples<T> extends Serializable{
	public T getValor();
	public ValorSimples<T> fromString(String valor);
}
