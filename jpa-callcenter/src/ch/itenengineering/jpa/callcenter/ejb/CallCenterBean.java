package ch.itenengineering.jpa.callcenter.ejb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ch.itenengineering.jpa.callcenter.domain.Customer;

@Stateless
public class CallCenterBean implements CallCenter {

	@PersistenceContext(unitName = "TestPU")
	private EntityManager em;

	public void clearAll() {
		em.createQuery("delete from Call").executeUpdate();
		em.createQuery("delete from Customer").executeUpdate();
		em.createQuery("delete from Address").executeUpdate();
	}

	public void addCustomer(Customer customer) {
		em.persist(customer);
	}

	public Customer getCustomer(int customerId) {
		// TODO jpa - call center
		return new Customer();
	}

	public Object getSingleResult(String qlString) {
		return em.createQuery(qlString).getSingleResult();
	}

	@SuppressWarnings("rawtypes")
	public List getResultList(String qlString) {
		return em.createQuery(qlString).getResultList();
	}

	@SuppressWarnings("rawtypes")
	public List getNamedQueryResultList(String name) {
		return em.createNamedQuery(name).getResultList();
	}

	@SuppressWarnings("rawtypes")
	public List getNamedQueryResultList(String name, Date date) {
		// TODO jpa - call center
		return new ArrayList();
	}

} // end of class
