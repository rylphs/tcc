package ferreira.couto.raphael.formacaopv.view;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ferreira.couto.raphael.formacaopv.business.EstoqueBC;
import ferreira.couto.raphael.formacaopv.business.ProdutoBC;
import ferreira.couto.raphael.formacaopv.entity.Estoque;
import ferreira.couto.raphael.formacaopv.entity.Produto;
import ferreira.couto.raphael.formacaopv.enums.Funcionalidade;
import ferreira.couto.raphael.formacaopv.exception.FormacaoPVException;

@ViewScoped
@ManagedBean
public class ListagemEstoqueMB extends TableEditMB<Estoque> {
	@Inject private EstoqueBC estoqueBC;
	@Inject private ProdutoBC produtoBC;
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
