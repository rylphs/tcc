package ferreira.couto.raphael.formacaopv.view;

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
public class ListagemProdutoMB extends TableEditMB<Produto>{
	@Inject private ProdutoBC produtoBC;

	@Override
	protected List<Produto> getListaFromBC() {
		return produtoBC.obterProdutos();
	}

	@Override
	protected Funcionalidade getFuncionalidadeAdicao() {
		return Funcionalidade.ADICAO_PRODUTO;
	}

	@Override
	protected void adicionarOnBC(Produto selecionado) throws FormacaoPVException {
		produtoBC.adicionarProduto(selecionado);
	}

	@Override
	protected Produto createNew() {
		return new Produto();
	}
}
