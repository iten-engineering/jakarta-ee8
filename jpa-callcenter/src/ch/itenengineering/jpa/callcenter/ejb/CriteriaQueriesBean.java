package ch.itenengineering.jpa.callcenter.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ch.itenengineering.jpa.callcenter.domain.Customer;

@Stateless
public class CriteriaQueriesBean implements CriteriaQueries {

	@PersistenceContext(unitName = "TestPU")
	private EntityManager em;

	@Override
	public List<Customer> selectCustomers() {
		// TODO
		return null;
	}

	@Override
	public List<String> selectCustomerFirstNames() {
		// TODO
		return null;
	}

	@Override
	public List<String> selectCustomeFirstNamesOrdered() {
		// TODO
		return null;
	}

	@Override
	public Customer selectCustomerById(int id) {
		// TODO
		return null;
	}

}
