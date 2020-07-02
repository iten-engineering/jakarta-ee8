package ch.itenengineering.jpa.inheritance.i2.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ch.itenengineering.jpa.inheritance.i2.domain.Person;

@Stateless
public class ManagerBeanI2 implements ManagerI2 {

	@PersistenceContext(unitName = "TestPU")
	private EntityManager em;

	public Person add(Person person) {

		em.persist(person);

		return person;
	}

	public void deleteAll() {
		em.createQuery("delete from PersonI2").executeUpdate();
	}

	public List findAll() {
		return em.createQuery("select p from PersonI2 p").getResultList();
	}

} // end of class
