package ferreira.couto.raphael.formacaopv.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ferreira.couto.raphael.formacaopv.business.ProdutoBC;
import ferreira.couto.raphael.formacaopv.entity.Produto;

@ViewScoped
@ManagedBean
public class ListagemProdutoMB {
	private enum Action{ EDIT, NEW} 
	
	@Inject private ProdutoBC produtoBC;
	private List<Produto> produtos;
	private Produto produtoSelecionado;
	private Action action;
	
	@PostConstruct
	public void onInit(){
		produtos = produtoBC.obterProdutos();
	}
	
	public boolean isEditing(){
		return action == Action.EDIT;
	}
	
	public void prepararAdicaoProduto(){
		action = Action.NEW;
		produtoSelecionado = new Produto();
	}
	
	public void adicionarProduto(){
		produtoBC.adicionarProduto(produtoSelecionado);
		produtos = produtoBC.obterProdutos();
		FacesContext.getCurrentInstance().addMessage("produto", new FacesMessage("Produto adicionado com sucesso!"));
	}
	
	public void excluirProduto(){
		produtoBC.excluirProduto(produtoSelecionado);
	}
	
	public List<Produto> getProdutos(){
		return produtos;
	}
	
	public Produto getProdutoSelecionado(){
		return produtoSelecionado;
	}
	
	public void setProdutoSelecionado(Produto produto){
		action = Action.EDIT;
		this.produtoSelecionado = produto;
	}
}
