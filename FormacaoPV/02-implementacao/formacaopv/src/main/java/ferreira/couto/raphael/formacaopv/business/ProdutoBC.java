package ferreira.couto.raphael.formacaopv.business;

import java.util.List;

import javax.inject.Inject;

import ferreira.couto.raphael.formacaopv.entity.Imposto;
import ferreira.couto.raphael.formacaopv.entity.Produto;
import ferreira.couto.raphael.formacaopv.exception.FormacaoPVException;
import ferreira.couto.raphael.formacaopv.persistence.ProdutoDAO;

public class ProdutoBC {
	@Inject ProdutoDAO produtoDAO;
	
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

}
