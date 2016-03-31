package ferreira.couto.raphael.formacaopv.domain.comum;

import java.math.BigDecimal;

import javax.persistence.Embeddable;

@Embeddable
public class Porcentagem implements ValorSimples<BigDecimal>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal valor;
	
	Porcentagem(){}
	
	public Porcentagem(BigDecimal valor){
		if(!ehValido(valor)){
			throw new ValorInvalidoException(valor, 
					"Valor deve ser número maior do que zero");
		}
		this.valor = valor;
	}
	
	public Porcentagem(double valor){
		this(new BigDecimal(valor));
	}
	
	public Porcentagem(int valor){
		this(new BigDecimal(valor).divide(new BigDecimal(100)));
	}
	
	public static Porcentagem somatorio(Porcentagem... porcentagens){
		BigDecimal somatorio = BigDecimal.ZERO;
		for(Porcentagem p : porcentagens){
			somatorio = somatorio.add(p.valor);
		}
		return new Porcentagem(somatorio);
	}
	
	private boolean ehValido(BigDecimal value){
		return value == null? false : value.compareTo(BigDecimal.ONE) >= 0;
	}
	
	public BigDecimal getValue(){
		return valor;
	}
	
	public String toString(){
		return valor.multiply(new BigDecimal(100)) + "%";
	}

	@Override
	public BigDecimal getValor() {
		return valor;
	}

	@Override
	public ValorSimples<BigDecimal> fromString(String valor) {
		valor = valor.replaceAll("% *$", "");
		return new Real(new BigDecimal(valor));
	}
}
