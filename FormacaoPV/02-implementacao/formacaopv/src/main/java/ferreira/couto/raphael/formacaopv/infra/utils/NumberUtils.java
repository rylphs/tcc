package ferreira.couto.raphael.formacaopv.infra.utils;

import ferreira.couto.raphael.formacaopv.domain.comum.Porcentagem;
import ferreira.couto.raphael.formacaopv.domain.comum.Real;

public class NumberUtils {
	public static double toPrimitiveDouble(Double value){
		return value == null ? 0:value;
	}
	
	public static double toPrimitiveDouble(Real value){
		return (double) (value == null ? 0:value.getValor());
	}
	
	public static double toPrimitiveDouble(Porcentagem value){
		return (double) (value == null ? 0:value.getValor());
	}
}
