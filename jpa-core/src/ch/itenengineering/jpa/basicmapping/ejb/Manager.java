package ch.itenengineering.jpa.basicmapping.ejb;

import javax.ejb.Local;

@Local
public interface Manager {

	public Object persist(Object entity);

	public Object merge(Object entity);

	@SuppressWarnings("rawtypes")
	public Object find(Class clazz, Object primaryKey);

	@SuppressWarnings("rawtypes")
	public void remove(Class clazz, Object primaryKey);

} // end
