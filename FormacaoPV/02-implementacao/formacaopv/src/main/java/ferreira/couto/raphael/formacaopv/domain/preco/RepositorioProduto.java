package ferreira.couto.raphael.formacaopv.domain.preco;

import static ferreira.couto.raphael.formacaopv.infra.utils.NumberUtils.toPrimitiveDouble;

import java.util.List;

import javax.inject.Inject;

import ferreira.couto.raphael.formacaopv.domain.comum.FormacaoPVException;
import ferreira.couto.raphael.formacaopv.domain.comum.Porcentagem;
import ferreira.couto.raphael.formacaopv.domain.comum.Real;
import ferreira.couto.raphael.formacaopv.domain.venda.RepositorioMovimentacao;
import ferreira.couto.raphael.formacaopv.infra.preco.ProdutoDAO;

public class RepositorioProduto {
	@Inject ProdutoDAO produtoDAO;
	@Inject RepositorioMovimentacao repositorioMovimentacao;
	
	public List<Produto> getProdutos() {
		return produtoDAO.findAll();
	}
	
	public void addProduto(Produto produto) throws FormacaoPVException{
		produtoDAO.adicionar(produto);
	}
	
	public void updateProduto(Produto produto) throws FormacaoPVException{
		produtoDAO.atualizar(produto);
	}

	public void deleteProduto(Produto produto) {
		produtoDAO.delete(produto);
	}
	
	public void adicionarImposto(Produto produto, Imposto imposto){
//		double descontoImposto = produto.getDescontoImposto();
//		descontoImposto += produto.getCusto() * imposto.getPercentagem();
//		produto.setDescontoImposto(descontoImposto);
	}

	public void recalcularPreco(Produto produto) 
			throws FormacaoPVException {
		Porcentagem percentualCustosFixos = 
				repositorioMovimentacao.calcularPercentualDeCustosFixos();
		produto.atualizarPreco(percentualCustosFixos);
	}

}
