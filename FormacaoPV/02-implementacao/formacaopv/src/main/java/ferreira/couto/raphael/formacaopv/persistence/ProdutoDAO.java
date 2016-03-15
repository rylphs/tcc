package ferreira.couto.raphael.formacaopv.persistence;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import ferreira.couto.raphael.formacaopv.entity.Produto;

public class ProdutoDAO {
	@Inject
	EntityManager em;

	public List<Produto> findAll() {
		String strQry = "select p from Produto p";
		TypedQuery<Produto> query = em.createQuery(strQry, Produto.class);
		return query.getResultList();
	}

	public void delete(Produto produto) {
		em.getTransaction().begin();
		em.remove(produto);
		em.getTransaction().commit();
	}
	
	public void adicionar(Produto produto){
		em.getTransaction().begin();
		em.persist(produto);
		em.getTransaction().commit();
	}
	
	
}
