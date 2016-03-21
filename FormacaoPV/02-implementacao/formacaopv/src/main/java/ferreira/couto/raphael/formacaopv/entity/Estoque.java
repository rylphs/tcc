package ferreira.couto.raphael.formacaopv.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Estoque extends BaseEntity {
	private static final long serialVersionUID = 1L;

	private Produto produto;
	private Integer quantidade;
	@OneToOne
	private Localidade localidade;

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Localidade getLocalidade() {
		return localidade;
	}

	public void setLocalidade(Localidade localidade) {
		this.localidade = localidade;
	}


}
