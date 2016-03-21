package ferreira.couto.raphael.formacaopv.business;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import ferreira.couto.raphael.formacaopv.entity.Estoque;
import ferreira.couto.raphael.formacaopv.entity.Localidade;
import ferreira.couto.raphael.formacaopv.entity.Produto;
import ferreira.couto.raphael.formacaopv.persistence.EstoqueDAO;
import ferreira.couto.raphael.formacaopv.persistence.LocalidadeDAO;

public class EstoqueBC {
	@Inject private EstoqueDAO estoqueDAO;
	@Inject private LocalidadeDAO localidadeDAO;

	public List<Estoque> getEstoques() {
		return estoqueDAO.findAll();
	}

	public void add(Estoque estoque) {
		estoqueDAO.add(estoque);
	}
	
	public void add(Localidade localidade){
		localidadeDAO.add(localidade);
	}

	public void update(Estoque estoque) {
		estoqueDAO.update(estoque);
	}
	
	public void update(Localidade localidade){
		localidadeDAO.update(localidade);
	}

	public void delete(Estoque estoque) {
		estoqueDAO.delete(estoque);
	}
	
	public void delete(Localidade localidade){
		localidadeDAO.update(localidade);
	}
	
	public Estoque findByProdutoLugar(Produto produto) {
		List<Estoque> estoques = estoqueDAO.findByField("produto", produto);
		return estoques.isEmpty() ? null : estoques.get(0);
	}

	public List<Localidade> getLocalidades() {
		return localidadeDAO.findAll();
	}

	public List<Produto> findByLugar(Localidade localidade) {
		List<Produto> produtos = new ArrayList<>();
		List<Estoque> estoques = estoqueDAO.findByField("localidade", localidade);
		for(Estoque estoque : estoques){
			produtos.add(estoque.getProduto());
		}
		return produtos;
	}

}
