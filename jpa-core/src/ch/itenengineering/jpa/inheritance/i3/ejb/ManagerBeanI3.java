package ch.itenengineering.jpa.inheritance.i3.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ch.itenengineering.jpa.inheritance.i3.domain.Person;

@Stateless
public class ManagerBeanI3 implements ManagerI3 {

	@PersistenceContext(unitName = "TestPU")
	private EntityManager em;

	public Person add(Person person) {

		em.persist(person);

		return person;
	}

	public void deleteAll() {
		em.createQuery("delete from PersonI3").executeUpdate();
	}

	public List findAll() {
		return em.createQuery("select p from PersonI3 p").getResultList();
	}

} // end of class
