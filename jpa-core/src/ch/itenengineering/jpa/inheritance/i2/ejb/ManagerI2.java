package ch.itenengineering.jpa.inheritance.i2.ejb;

import java.util.List;

import javax.ejb.Local;

import ch.itenengineering.jpa.inheritance.i2.domain.Person;

@Local
public interface ManagerI2 {

	public Person add(Person person);

	public void deleteAll();

	public List findAll();

} // end of class
