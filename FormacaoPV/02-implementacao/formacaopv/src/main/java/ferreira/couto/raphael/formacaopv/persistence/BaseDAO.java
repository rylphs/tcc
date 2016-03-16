package ferreira.couto.raphael.formacaopv.persistence;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public abstract class BaseDAO<T> {
	@Inject
	EntityManager em;
	private Class<T> baseClass;

	@SuppressWarnings("unchecked")
	public BaseDAO() {
		this.baseClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public List<T> findAll() {
		String strQry = "select c from "+ baseClass.getSimpleName() +" c";
		TypedQuery<T> query = em.createQuery(strQry, baseClass);
		return query.getResultList();
	}

	public void delete(T movimentacao) {
		em.getTransaction().begin();
		em.remove(movimentacao);
		em.getTransaction().commit();
	}

	public void adicionar(T movimentacao) {
		em.getTransaction().begin();
		em.persist(movimentacao);
		em.getTransaction().commit();
	}

}