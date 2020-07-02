package ch.itenengineering.jpa.inheritance.i3.ejb;

import java.util.List;

import javax.ejb.Local;

import ch.itenengineering.jpa.inheritance.i3.domain.Person;

@Local
public interface ManagerI3 {

	public Person add(Person person);

	public void deleteAll();

	public List findAll();

} // end of class
