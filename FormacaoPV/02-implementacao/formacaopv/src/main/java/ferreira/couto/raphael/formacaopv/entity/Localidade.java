package ferreira.couto.raphael.formacaopv.entity;

import javax.persistence.Entity;

@Entity
public class Localidade extends BaseEntity{
	private static final long serialVersionUID = 1L;
	
	private String nome;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
