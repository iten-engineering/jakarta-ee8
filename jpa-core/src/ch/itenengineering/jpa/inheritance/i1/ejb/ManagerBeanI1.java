package ch.itenengineering.jpa.inheritance.i1.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ch.itenengineering.jpa.inheritance.i1.domain.Person;

@Stateless
public class ManagerBeanI1 implements ManagerI1 {

	@PersistenceContext(unitName = "TestPU")
	private EntityManager em;

	public Person add(Person person) {

		em.persist(person);

		return person;
	}

	public void deleteAll() {
		em.createQuery("delete from PersonI1").executeUpdate();
	}

	@SuppressWarnings("rawtypes")
	public List findAll() {
		return em.createQuery("select p from PersonI1 p").getResultList();
	}

} // end of class
