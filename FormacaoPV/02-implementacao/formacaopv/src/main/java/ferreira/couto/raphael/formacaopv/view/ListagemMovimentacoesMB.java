package ferreira.couto.raphael.formacaopv.view;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ferreira.couto.raphael.formacaopv.business.MovimentacaoBC;
import ferreira.couto.raphael.formacaopv.business.ProdutoBC;
import ferreira.couto.raphael.formacaopv.entity.Movimentacao;
import ferreira.couto.raphael.formacaopv.entity.Produto;
import ferreira.couto.raphael.formacaopv.enums.Funcionalidade;
import ferreira.couto.raphael.formacaopv.exception.FormacaoPVException;

@ViewScoped
@ManagedBean
public class ListagemMovimentacoesMB extends TableEditMB<Movimentacao>{
	@Inject MovimentacaoBC movimentacaoBC;
	@Inject ProdutoBC produtoBC;
	private boolean isDespesa;
	private List<Produto> produtos;
	
	@Override
	protected List<Movimentacao> getListaFromBC() {
		return movimentacaoBC.obterMovimentacoes();
	}

	@Override
	protected Funcionalidade getFuncionalidade() {
		return Funcionalidade.MOVIMENTACAO;
	}

	@Override
	protected void adicionarOnBC(Movimentacao movimentacao) throws FormacaoPVException {
		movimentacaoBC.adicionarMovimentacao(movimentacao);
	}
	
	@Override
	protected String getItemDescription(){
		return getSelecionado().getDescricao();
	}
	
	@Override
	protected void atualizarOnBC(Movimentacao movimentacao) throws FormacaoPVException {
	//	movimentacaoBC.adicionarMovimentacao(movimentacao);
	}
	
	@Override
	protected void removerOnBC(Movimentacao selecionado) throws FormacaoPVException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	protected Movimentacao createNew(){
		return new Movimentacao();
	}

	public boolean isDespesa() {
		return isDespesa;
	}

	public void setDespesa(boolean isDespesa) {
		this.isDespesa = isDespesa;
	}
	
	public List<Produto> getProdutos(){
		if(produtos==null) produtos = produtoBC.obterProdutos();
		return produtos;
	}

	

	
}
