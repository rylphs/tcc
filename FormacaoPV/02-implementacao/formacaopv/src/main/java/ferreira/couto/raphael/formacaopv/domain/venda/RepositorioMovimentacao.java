package ferreira.couto.raphael.formacaopv.domain.venda;

import java.util.List;

import javax.inject.Inject;

import ferreira.couto.raphael.formacaopv.domain.comum.FormacaoPVException;
import ferreira.couto.raphael.formacaopv.domain.comum.Porcentagem;
import ferreira.couto.raphael.formacaopv.domain.comum.Real;
import ferreira.couto.raphael.formacaopv.domain.preco.Produto;
import ferreira.couto.raphael.formacaopv.infra.venda.MovimentacaoDAO;

public class RepositorioMovimentacao {
	@Inject MovimentacaoDAO movimentacaoDAO;
	@Inject RepositorioEstoque estoqueBC;
	
	public List<Movimentacao> obterMovimentacoes() {
		return movimentacaoDAO.findAll();
	}
	
	public void adicionarMovimentacao(Movimentacao movimentacao) 
			throws FormacaoPVException{
		if(movimentacao.isVenda()){
			Produto produto = movimentacao.getProduto();
			Localidade localidade = movimentacao.getLocalidade();
			Estoque estoque = estoqueBC.findByProdutoLugar(produto, localidade);
			int quantidadeVendida = movimentacao.getQuantidade();
			estoque.liberar(quantidadeVendida);
			estoqueBC.update(estoque);
		}
		movimentacaoDAO.add(movimentacao);
	}

	public void excluirProduto(Movimentacao movimentacao) {
		movimentacaoDAO.delete(movimentacao);
	}

	public void atualizarMovimentacao(Movimentacao movimentacao) {
		movimentacaoDAO.update(movimentacao);
		
	}
	
	public List<Localidade> getLocalidades(){
		return estoqueBC.getLocalidades();
	}

	public Porcentagem calcularPercentualDeCustosFixos() 
			throws FormacaoPVException{
		Real custosFixos = new Real(movimentacaoDAO.getCustosFixos());
		Real vendasMedias = new Real(movimentacaoDAO.getVendasMedias());
		return custosFixos.calcularPercentagem(vendasMedias);
	}

}
