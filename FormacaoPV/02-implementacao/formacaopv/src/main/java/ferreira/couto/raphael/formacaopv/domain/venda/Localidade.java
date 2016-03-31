package ferreira.couto.raphael.formacaopv.domain.venda;

import javax.persistence.Entity;

import ferreira.couto.raphael.formacaopv.domain.comum.BaseEntity;

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
