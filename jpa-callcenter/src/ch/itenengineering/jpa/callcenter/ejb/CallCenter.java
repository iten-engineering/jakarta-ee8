package ch.itenengineering.jpa.callcenter.ejb;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import ch.itenengineering.jpa.callcenter.domain.Customer;

@Local
public interface CallCenter {

	public void clearAll();

	public void addCustomer(Customer customer);

	public Customer getCustomer(int customerId);

	public Object getSingleResult(String qlString);

	@SuppressWarnings("rawtypes")
	public List getResultList(String qlString);

	@SuppressWarnings("rawtypes")
	public List getNamedQueryResultList(String name);

	@SuppressWarnings("rawtypes")
	public List getNamedQueryResultList(String name, Date date);

}
