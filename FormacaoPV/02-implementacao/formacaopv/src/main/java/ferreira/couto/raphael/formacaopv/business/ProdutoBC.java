package ferreira.couto.raphael.formacaopv.business;

import java.util.List;

import javax.inject.Inject;

import ferreira.couto.raphael.formacaopv.entity.Produto;
import ferreira.couto.raphael.formacaopv.enums.Funcionalidade;
import ferreira.couto.raphael.formacaopv.exception.FormacaoPVException;
import ferreira.couto.raphael.formacaopv.persistence.ProdutoDAO;

public class ProdutoBC {
	@Inject ProdutoDAO produtoDAO;
	
	public List<Produto> obterProdutos() {
		return produtoDAO.findAll();
	}
	
	public void adicionarProduto(Produto produto) throws FormacaoPVException{
		if(produto.getNome()==null 
				|| produto.getComissao() == null
				|| produto.getCusto() ==null
				|| produto.getLucro() == null){
			throw new FormacaoPVException(Funcionalidade.ADICAO_PRODUTO, "parametro_faltando");
		}
		produtoDAO.adicionar(produto);
	}

	public void excluirProduto(Produto produto) {
		produtoDAO.delete(produto);
	}

}
