package ferreira.couto.raphael.formacaopv.domain.comum;

import java.math.BigDecimal;

import javax.persistence.Embeddable;

@Embeddable
public class Real implements ValorSimples<BigDecimal>{
	private static final long serialVersionUID = 1L;
	private BigDecimal valor;
	
	public Real(){}
	
	public Real(double valor) throws ValorInvalidoException{
		this(new BigDecimal(valor));
	}
	
	public Real(BigDecimal valor) throws ValorInvalidoException{
		this.setValor(valor);
	}
	
	private void setValor(BigDecimal valor) {
		if(!ehValido(valor)){
			throw new ValorInvalidoException(valor, 
					"Valor deve ser número maior do que zero");
		}
		this.valor = valor;
	}
	
	public Real dividirPor(BigDecimal divisor){
		return new Real(valor.divide(divisor));
	}
	
	public Porcentagem calcularPercentagem(Real divisor){
		if(divisor.valor.compareTo(BigDecimal.ZERO)==0) return new Porcentagem(0);
		BigDecimal razao = valor.divide(divisor.valor);
		return new Porcentagem(razao);
	} 
	
	public boolean ehValido(BigDecimal valor){
		return valor == null? true : valor.compareTo(BigDecimal.ZERO) >= 0;
	}
	
	@Override
	public String toString(){
		return "R$ " + getValor();
	}

	@Override
	public Real fromString(String valor) {
		valor = valor.replaceAll("^R\\$ *", "");
		return new Real(new BigDecimal(valor));
	}

	@Override
	public BigDecimal getValor() {
		return valor;
	}
}
