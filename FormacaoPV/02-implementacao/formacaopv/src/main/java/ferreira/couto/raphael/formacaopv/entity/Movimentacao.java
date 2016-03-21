package ferreira.couto.raphael.formacaopv.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Movimentacao extends BaseEntity{
	private static final long serialVersionUID = 1L;
	
	private String descricao;
	private Date data = new Date();
	private double valor;
	private boolean venda;
	@ManyToOne
	private Produto produto;
	@ManyToOne
	private Localidade localidade;
	private Integer quantidade;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public boolean isVenda() {
		return venda;
	}

	public void setVenda(boolean venda) {
		this.venda = venda;
	}

	public Localidade getLocalidade() {
		return localidade;
	}

	public void setLocalidade(Localidade localidade) {
		this.localidade = localidade;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
}
