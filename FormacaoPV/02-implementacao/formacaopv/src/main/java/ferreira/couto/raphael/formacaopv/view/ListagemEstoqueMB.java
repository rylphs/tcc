package ferreira.couto.raphael.formacaopv.view;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ferreira.couto.raphael.formacaopv.domain.comum.FormacaoPVException;
import ferreira.couto.raphael.formacaopv.domain.comum.Funcionalidade;
import ferreira.couto.raphael.formacaopv.domain.preco.Produto;
import ferreira.couto.raphael.formacaopv.domain.preco.RepositorioProduto;
import ferreira.couto.raphael.formacaopv.domain.venda.Estoque;
import ferreira.couto.raphael.formacaopv.domain.venda.RepositorioEstoque;

@ViewScoped
@ManagedBean
public class ListagemEstoqueMB extends TableEditMB<Estoque> {
	@Inject private RepositorioEstoque estoqueBC;
	@Inject private RepositorioProduto produtoBC;
	private List<Produto> produtos;
	
	@Override
	protected void onInit() {
		produtos = produtoBC.getProdutos();
		super.onInit();
	}
	
	@Override
	protected List<Estoque> getListaFromBC() {
		return estoqueBC.getEstoques();
	}

	@Override
	protected Funcionalidade getFuncionalidade() {
		return Funcionalidade.ESTOQUE;
	}

	@Override
	protected void adicionarOnBC(Estoque estoque) throws FormacaoPVException {
		estoqueBC.add(estoque);
	}

	@Override
	protected void atualizarOnBC(Estoque estoque) throws FormacaoPVException {
		estoqueBC.update(estoque);
	}

	@Override
	protected void removerOnBC(Estoque estoque) throws FormacaoPVException {
		estoqueBC.delete(estoque);
	}

	@Override
	protected Estoque createNew() {
		return new Estoque();
	}
	
	@Override
	protected String getItemDescription(Estoque item) {
		return "Estoque do \"" + item.getProduto().getNome() + "\"";
	}
	
	public List<Produto> getProdutos(){
		return produtos;
	}

}
