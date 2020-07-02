package ch.itenengineering.jpa.callcenter.ejb;

import java.util.List;

import javax.ejb.Local;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import ch.itenengineering.jpa.callcenter.domain.Customer;

@Local
public interface CriteriaQueries {

	public List<Customer> selectCustomers();
	
	public List<String> selectCustomerFirstNames();
	
	public List<String> selectCustomeFirstNamesOrdered();
	
	public Customer selectCustomerById(int id);
	
}
