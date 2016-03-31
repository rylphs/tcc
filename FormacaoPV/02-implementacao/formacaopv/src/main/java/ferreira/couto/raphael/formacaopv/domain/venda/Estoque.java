package ferreira.couto.raphael.formacaopv.domain.venda;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import ferreira.couto.raphael.formacaopv.domain.comum.BaseEntity;
import ferreira.couto.raphael.formacaopv.domain.preco.Produto;

@Entity
public class Estoque extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@OneToOne private Produto produto;
	private Integer quantidade;
	@OneToOne private Localidade localidade;

	public void liberar(int quantidade){
		this.quantidade -= quantidade;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Localidade getLocalidade() {
		return localidade;
	}

	public void setLocalidade(Localidade localidade) {
		this.localidade = localidade;
	}
}
