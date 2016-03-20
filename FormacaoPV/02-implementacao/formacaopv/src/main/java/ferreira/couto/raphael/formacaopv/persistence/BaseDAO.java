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

	public void delete(T item) {
		em.getTransaction().begin();
		item = em.merge(item);
		em.remove(item);
		em.getTransaction().commit();
	}

	public void add(T item) {
		em.getTransaction().begin();
		em.persist(item);
		em.getTransaction().commit();
	}
	
	public void update(T item){
		em.getTransaction().begin();
		em.merge(item);
		em.getTransaction().commit();
	}

}