package ferreira.couto.raphael.formacaopv.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ferreira.couto.raphael.formacaopv.business.ProdutoBC;
import ferreira.couto.raphael.formacaopv.entity.Produto;
import ferreira.couto.raphael.formacaopv.enums.Funcionalidade;
import ferreira.couto.raphael.formacaopv.exception.FormacaoPVException;

@ViewScoped
@ManagedBean
public class ListagemProdutoMB extends BaseMB{
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
		try {
			produtoBC.adicionarProduto(produtoSelecionado);
			produtos = produtoBC.obterProdutos();
			info(Funcionalidade.ADICAO_PRODUTO,"sucesso");
		} catch (FormacaoPVException e) {
			error(e.getFeature(), e.getStatus());
		}
		
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
