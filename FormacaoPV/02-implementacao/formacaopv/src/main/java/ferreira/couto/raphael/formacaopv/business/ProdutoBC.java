package ferreira.couto.raphael.formacaopv.business;

import java.util.List;

import javax.inject.Inject;

import ferreira.couto.raphael.formacaopv.entity.Produto;
import ferreira.couto.raphael.formacaopv.exception.FormacaoPVException;
import ferreira.couto.raphael.formacaopv.persistence.ProdutoDAO;

public class ProdutoBC {
	@Inject ProdutoDAO produtoDAO;
	
	public List<Produto> obterProdutos() {
		return produtoDAO.findAll();
	}
	
	public void adicionarProduto(Produto produto) throws FormacaoPVException{
		produtoDAO.adicionar(produto);
	}
	
	public void atualizarProduto(Produto produto) throws FormacaoPVException{
		produtoDAO.atualizar(produto);
	}

	public void excluirProduto(Produto produto) {
		produtoDAO.delete(produto);
	}

}
