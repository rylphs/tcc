package ferreira.couto.raphael.formacaopv.persistence;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
	
	public List<T> findByField(String field, Object value){
		String strQry = "select c from "+ baseClass.getSimpleName() +" c ";
		strQry += "where c." + field + "=:value";
		TypedQuery<T> query = em.createQuery(strQry, baseClass);
		query.setParameter("value", value);
		return query.getResultList();
	}
	
	public List<T> findByFields(Map<String, Object> mapPropertyValue){
		String strQry = "select c from "+ baseClass.getSimpleName() +" c where true ";
		List<Object> values = new ArrayList<>();
		int paramIndex = 1;
		for(Entry<String, Object> entry : mapPropertyValue.entrySet()){
			strQry += " and c." + entry.getKey() + "= ?" + paramIndex++;
			values.add(entry.getValue());
		}
		TypedQuery<T> query = em.createQuery(strQry, baseClass);
		for(paramIndex = 0; paramIndex < values.size() ; paramIndex++){
			query.setParameter(paramIndex+1, values.get(paramIndex));
		}
		return query.getResultList();
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