package ch.itenengineering.jpa.inheritance.i1.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "CustomerI1")
public class Customer extends Person {

	private static final long serialVersionUID = 1L;

	private String companyName;

	public Customer() {
		super();
	}

	public Customer(int personId, String firstname, String lastname,
			String companyName) {
		super(personId, firstname, lastname);
		this.companyName = companyName;
	}

	@Column(name = "COMPANY_NAME")
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String toString() {
		StringBuilder buf = new StringBuilder();

		buf.append(super.toString());
		buf.append(", ");

		buf.append(companyName);

		return buf.toString();
	}

} // end of class
