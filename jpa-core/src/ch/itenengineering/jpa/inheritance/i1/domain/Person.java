package ch.itenengineering.jpa.inheritance.i1.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "PersonI1")
@Table(name = "I1_PERSON")
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	private int personId;

	private String firstname;

	private String lastname;

	public Person() {
	}

	public Person(int personId, String firstname, String lastname) {
		this.personId = personId;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	@Id
	@Column(name = "PERSON_ID")
	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	@Column(name = "FIRSTNAME")
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Column(name = "LASTNAME")
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String toString() {
		StringBuilder buf = new StringBuilder();

		buf.append(personId);
		buf.append(", ");

		buf.append(firstname);
		buf.append(", ");

		buf.append(lastname);

		return buf.toString();
	}

} // end of class
