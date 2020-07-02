package ch.itenengineering.jpa.basicmapping.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BASIC_MAPPING_COMPANY")
public class Company implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	protected int id;

	public Company() {
		super();
	}

	public Company(int id) {
		super();
		this.id = id;
	}

	public String toString() {
		StringBuilder buf = new StringBuilder();

		buf.append("\nCompany Id = ");
		buf.append(id);

		return buf.toString();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

} // end of class
