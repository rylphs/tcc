package ferreira.couto.raphael.formacaopv.view;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ferreira.couto.raphael.formacaopv.business.EstoqueBC;
import ferreira.couto.raphael.formacaopv.business.MovimentacaoBC;
import ferreira.couto.raphael.formacaopv.business.ProdutoBC;
import ferreira.couto.raphael.formacaopv.entity.Localidade;
import ferreira.couto.raphael.formacaopv.entity.Movimentacao;
import ferreira.couto.raphael.formacaopv.entity.Produto;
import ferreira.couto.raphael.formacaopv.enums.Funcionalidade;
import ferreira.couto.raphael.formacaopv.exception.FormacaoPVException;

@ViewScoped
@ManagedBean
public class ListagemMovimentacoesMB extends TableEditMB<Movimentacao> implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject MovimentacaoBC movimentacaoBC;
	@Inject EstoqueBC estoqueBC;
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
	protected String getItemDescription(Movimentacao movimentacao){
		String descricao = "";
		if(movimentacao.isVenda()){
			descricao += "Venda \"";
		}
		else{
			descricao += "Despesa \"";
		}
		descricao+= movimentacao.getDescricao() + "\"";
		return descricao;
	}
	
	@Override
	protected void atualizarOnBC(Movimentacao movimentacao) throws FormacaoPVException {
		movimentacaoBC.atualizarMovimentacao(movimentacao);
	}
	
	@Override
	protected void removerOnBC(Movimentacao movimentacao) throws FormacaoPVException {
		movimentacaoBC.excluirProduto(movimentacao);
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
		Movimentacao movimentacao = getEditado();
		if(movimentacao.isVenda() && movimentacao.getLocalidade() != null){
			produtos = estoqueBC.findByLugar(movimentacao.getLocalidade());
		}
		else produtos = produtoBC.getProdutos();
		return produtos;
	}

	public List<Localidade> getLocalidades(){
		return movimentacaoBC.getLocalidades();
	}
	
	

	
}
