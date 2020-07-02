package ch.itenengineering.jpa.inheritance.i2.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity(name = "EmployeeI2")
@Table(name = "I2_EMPLOYEE")
public class Employee extends Person {

	public enum EmployeeType {
		CLERK, MANAGER
	};

	private static final long serialVersionUID = 1L;

	private Integer number;

	private EmployeeType type;

	public Employee() {
		super();
	}

	public Employee(int personId, String firstname, String lastname,
			Integer number, EmployeeType type) {
		super(personId, firstname, lastname);
		this.number = number;
		this.type = type;
	}

	@Column(name = "NUMBER")
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "TYPE")
	public EmployeeType getType() {
		return type;
	}

	public void setType(EmployeeType type) {
		this.type = type;
	}

	public String toString() {
		StringBuilder buf = new StringBuilder();

		buf.append(super.toString());
		buf.append(", ");

		buf.append(number);
		buf.append(", ");

		// Workaround for Hibernate Bug# HHH-2920. 
		// Details siehe Kommentar in der Klasse InheritanceClientI2
		buf.append(type==null ? type : type.name());

		return buf.toString();
	}

} // end of class

