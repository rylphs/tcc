package ferreira.couto.raphael.formacaopv.entity;

import javax.persistence.Entity;

@Entity
public class Produto extends BaseEntity{
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private Double custo;
	private Double lucro;
	private Double comissao;
	private Double descontoImposto;
	private Double precoFinal;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getCusto() {
		return custo;
	}

	public void setCusto(Double custo) {
		this.custo = custo;
	}

	public Double getLucro() {
		return lucro;
	}

	public void setLucro(Double lucro) {
		this.lucro = lucro;
	}

	public Double getComissao() {
		return comissao;
	}

	public void setComissao(Double comissao) {
		this.comissao = comissao;
	}

	public Double getDescontoImposto() {
		return descontoImposto;
	}

	public void setDescontoImposto(Double descontoImposto) {
		this.descontoImposto = descontoImposto;
	}

	public Double getPrecoFinal() {
		return precoFinal;
	}

	public void setPrecoFinal(Double precoFinal) {
		this.precoFinal = precoFinal;
	}

}
