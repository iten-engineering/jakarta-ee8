package ch.itenengineering.jpa.relation.one2one.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ManagerO2OBean implements ManagerO2O {

	@PersistenceContext(unitName = "TestPU")
	private EntityManager em;

	public Object persist(Object entity) {
		em.persist(entity);
		return entity;
	}

	public Object merge(Object entity) {
		return em.merge(entity);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object find(Class clazz, Object primaryKey) {
		return em.find(clazz, primaryKey);
	}

	@SuppressWarnings("rawtypes")
	public void remove(Class clazz, Object primaryKey) {
		Object obj = find(clazz, primaryKey);
		if (obj != null) {
			em.remove(obj);
		}
	}

} // end of class
