package ferreira.couto.raphael.formacaopv.business;

import java.util.List;

import javax.inject.Inject;

import ferreira.couto.raphael.formacaopv.entity.Estoque;
import ferreira.couto.raphael.formacaopv.entity.Localidade;
import ferreira.couto.raphael.formacaopv.entity.Movimentacao;
import ferreira.couto.raphael.formacaopv.entity.Produto;
import ferreira.couto.raphael.formacaopv.exception.FormacaoPVException;
import ferreira.couto.raphael.formacaopv.persistence.MovimentacaoDAO;

public class MovimentacaoBC {
	@Inject MovimentacaoDAO movimentacaoDAO;
	@Inject EstoqueBC estoqueBC;
	
	public List<Movimentacao> obterMovimentacoes() {
		return movimentacaoDAO.findAll();
	}
	
	public void adicionarMovimentacao(Movimentacao movimentacao) throws FormacaoPVException{
		if(movimentacao.isVenda()){
			Produto produto = movimentacao.getProduto();
			Estoque estoque = estoqueBC.findByProdutoLugar(produto);
			int valor = estoque.getQuantidade();
			valor--;
			estoque.setQuantidade(valor);
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

}
