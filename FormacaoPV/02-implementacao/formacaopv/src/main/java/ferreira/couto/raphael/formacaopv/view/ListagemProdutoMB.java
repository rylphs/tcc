package ferreira.couto.raphael.formacaopv.view;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ferreira.couto.raphael.formacaopv.business.ProdutoBC;
import ferreira.couto.raphael.formacaopv.entity.Produto;
import ferreira.couto.raphael.formacaopv.enums.Funcionalidade;
import ferreira.couto.raphael.formacaopv.exception.FormacaoPVException;

@ViewScoped
@ManagedBean
public class ListagemProdutoMB extends TableEditMB<Produto> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject private ProdutoBC produtoBC;

	@Override
	protected List<Produto> getListaFromBC() {
		return produtoBC.obterProdutos();
	}

	@Override
	protected Funcionalidade getFuncionalidade() {
		return Funcionalidade.PRODUTO;
	}

	@Override
	protected void adicionarOnBC(Produto selecionado) throws FormacaoPVException {
		produtoBC.adicionarProduto(selecionado);
	}
	
	@Override
	protected void atualizarOnBC(Produto selecionado) throws FormacaoPVException {
		produtoBC.atualizarProduto(selecionado);
	}
	
	@Override
	protected void removerOnBC(Produto selecionado) throws FormacaoPVException {
		produtoBC.excluirProduto(selecionado);
	}

	@Override
	protected Produto createNew() {
		return new Produto();
	}
	
	@Override
	protected String getItemDescription(Produto produto){
		return produto.getNome();
	}
	
	public String getDialogHeader(){
		if(isEditando()) return "Atualizar Produto";
		else return "Novo Produto";
	}
}
