package ch.itenengineering.jpa.relation.one2one.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity(name = "o2oCompany")
//@Table(name = "R_ONE2ONE_COMPANY")
public class Company implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;

	private String name;

	private String description;

	private Address address;

	public Company() {
	}

	public Company(int id, String name, String description, Address address) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setCompanyId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String toString() {
		StringBuilder buf = new StringBuilder();

		buf.append(id);
		buf.append(", ");

		buf.append(name);
		buf.append(", ");

		buf.append(description);
		buf.append(", ");

		buf.append("\n  ");
		buf.append(address == null ? "Es ist keine Adresse vorhanden" : address
				.toString());

		return buf.toString();
	}

} // end of class
