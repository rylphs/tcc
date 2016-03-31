package ferreira.couto.raphael.formacaopv.domain.preco;

import javax.persistence.Entity;

import ferreira.couto.raphael.formacaopv.domain.comum.BaseEntity;

@Entity
public class Imposto extends BaseEntity {
	private static final long serialVersionUID = 1L;

	private String nome;
	private double percentagem;

	public double getPercentagem() {
		return percentagem;
	}

	public void setPercentagem(double percentagem) {
		this.percentagem = percentagem;
	}
	
	public String getNome(){
		return nome;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}

}
