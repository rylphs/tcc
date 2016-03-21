package ferreira.couto.raphael.formacaopv.entity;

import javax.persistence.Entity;

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
