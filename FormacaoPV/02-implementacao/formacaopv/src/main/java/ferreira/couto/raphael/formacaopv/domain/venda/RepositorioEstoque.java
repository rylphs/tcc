package ferreira.couto.raphael.formacaopv.domain.venda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import ferreira.couto.raphael.formacaopv.domain.preco.Produto;
import ferreira.couto.raphael.formacaopv.infra.venda.EstoqueDAO;
import ferreira.couto.raphael.formacaopv.infra.venda.LocalidadeDAO;

public class RepositorioEstoque {
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
	
	public Estoque findByProdutoLugar(Produto produto, Localidade localidade) {
		Map<String, Object> fields = new HashMap<>();
		fields.put("produto", produto);
		fields.put("localidade", localidade);
		List<Estoque> estoques = estoqueDAO.findByFields(fields);
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
