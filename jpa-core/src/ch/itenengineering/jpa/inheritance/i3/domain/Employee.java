package ch.itenengineering.jpa.inheritance.i3.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity(name = "EmployeeI3")
@Table(name = "I3_EMPLOYEE")
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

		buf.append(type.name());

		return buf.toString();
	}

} // end of class

