package ferreira.couto.raphael.formacaopv.business;

import java.util.List;

import javax.inject.Inject;

import ferreira.couto.raphael.formacaopv.entity.Estoque;
import ferreira.couto.raphael.formacaopv.entity.Localidade;
import ferreira.couto.raphael.formacaopv.entity.Movimentacao;
import ferreira.couto.raphael.formacaopv.entity.Produto;
import ferreira.couto.raphael.formacaopv.enums.Funcionalidade;
import ferreira.couto.raphael.formacaopv.exception.FormacaoPVException;
import ferreira.couto.raphael.formacaopv.persistence.MovimentacaoDAO;
import ferreira.couto.raphael.formacaopv.utils.NumberUtils;

public class MovimentacaoBC {
	@Inject MovimentacaoDAO movimentacaoDAO;
	@Inject EstoqueBC estoqueBC;
	
	public List<Movimentacao> obterMovimentacoes() {
		return movimentacaoDAO.findAll();
	}
	
	public void adicionarMovimentacao(Movimentacao movimentacao) throws FormacaoPVException{
		if(movimentacao.isVenda()){
			Produto produto = movimentacao.getProduto();
			Localidade localidade = movimentacao.getLocalidade();
			Estoque estoque = estoqueBC.findByProdutoLugar(produto, localidade);
			int qtde = estoque.getQuantidade();
			qtde -= movimentacao.getQuantidade();
			estoque.setQuantidade(qtde);
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

	public double getCF() throws FormacaoPVException {
		double custosFixos = NumberUtils.toPrimitiveDouble(movimentacaoDAO.getCustosFixos());
		double vendasMedias = NumberUtils.toPrimitiveDouble(movimentacaoDAO.getVendasMedias());
		if(vendasMedias==0) throw new FormacaoPVException(Funcionalidade.PRODUTO, "calculo-pv.sem-vendas");
		return custosFixos / vendasMedias;
	}

}
