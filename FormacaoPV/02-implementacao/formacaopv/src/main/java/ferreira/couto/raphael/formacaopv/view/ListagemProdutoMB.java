package ferreira.couto.raphael.formacaopv.view;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import ferreira.couto.raphael.formacaopv.entity.Produto;

@RequestScoped
@ManagedBean
public class ListagemProdutoMB {
	private Produto criarProdutoMock(String nome){
		Produto produto = new Produto();
		produto.setNome(nome);
		produto.setComissao(0.5);
		produto.setCusto(100.0);
		produto.setLucro(.25);
		return produto;
	}
	
	public List<Produto> getProdutos(){
		List<Produto> produtos = new ArrayList<>();
		for(int i=0; i<10; i++){
			produtos.add(criarProdutoMock("Produto " + i));
		}
		return produtos;
	}
}
