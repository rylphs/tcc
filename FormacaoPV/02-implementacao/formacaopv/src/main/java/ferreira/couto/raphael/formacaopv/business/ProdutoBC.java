package ferreira.couto.raphael.formacaopv.business;

import java.util.List;

import javax.inject.Inject;

import ferreira.couto.raphael.formacaopv.entity.Imposto;
import ferreira.couto.raphael.formacaopv.entity.Produto;
import ferreira.couto.raphael.formacaopv.exception.FormacaoPVException;
import ferreira.couto.raphael.formacaopv.persistence.ProdutoDAO;
import static ferreira.couto.raphael.formacaopv.utils.NumberUtils.toPrimitiveDouble;

public class ProdutoBC {
	@Inject ProdutoDAO produtoDAO;
	@Inject MovimentacaoBC movimentacaoBC;
	
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
		double descontoImposto = produto.getDescontoImposto();
		descontoImposto += produto.getCusto() * imposto.getPercentagem();
		produto.setDescontoImposto(descontoImposto);
	}

	public void recalcularPreco(Produto produto) throws FormacaoPVException {
		double cf = movimentacaoBC.getCF();
		double custo = toPrimitiveDouble(produto.getCusto());
		double imposto = toPrimitiveDouble(produto.getDescontoImposto());
		double comissao = toPrimitiveDouble(produto.getComissao());
		double lucro = toPrimitiveDouble(produto.getLucro());
		double somatorio = imposto + comissao + cf + lucro;
		somatorio = somatorio == 0 ? 1 : somatorio;
		double preco = custo / (1-somatorio);
		produto.setPrecoFinal(preco);
	}

}
