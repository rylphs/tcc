package ferreira.couto.raphael.formacaopv.business;

import java.util.List;

import javax.inject.Inject;

import ferreira.couto.raphael.formacaopv.entity.Movimentacao;
import ferreira.couto.raphael.formacaopv.exception.FormacaoPVException;
import ferreira.couto.raphael.formacaopv.persistence.MovimentacaoDAO;

public class MovimentacaoBC {
	@Inject MovimentacaoDAO movimentacaoDAO;
	
	public List<Movimentacao> obterMovimentacoes() {
		return movimentacaoDAO.findAll();
	}
	
	public void adicionarMovimentacao(Movimentacao movimentacao) throws FormacaoPVException{
		movimentacaoDAO.adicionar(movimentacao);
	}

	public void excluirProduto(Movimentacao movimentacao) {
		movimentacaoDAO.delete(movimentacao);
	}

}
