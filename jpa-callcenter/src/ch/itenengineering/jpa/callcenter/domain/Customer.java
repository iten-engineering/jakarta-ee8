package ch.itenengineering.jpa.callcenter.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "CC_CUSTOMER")
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	private int customerId;

	private String firstName;

	private String lastName;

	private Address address;

	private List<Call> calls = new ArrayList<Call>();

	public Customer() {
	}

	public Customer(int customerId, String firstName, String lastName) {
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Customer(int customerId, String firstName, String lastName,
			Address address) {
		this(customerId, firstName, lastName);
		this.address = address;
	}

	public Customer(int customerId, String firstName, String lastName,
			List<Call> calls) {
		this(customerId, firstName, lastName);
		this.calls = calls;
	}

	public Customer(int customerId, String firstName, String lastName,
			Address address, List<Call> calls) {
		this(customerId, firstName, lastName, address);
		this.calls = calls;
	}

	@Id
	@Column(name = "CUSTOMER_ID")
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Column(name = "FIRSTNAME")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "LASTNAME")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@OneToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@PrimaryKeyJoinColumn()
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinColumn(name = "CUSTOMER_ID")
	public List<Call> getCalls() {
		return calls;
	}

	public void setCalls(List<Call> calls) {
		this.calls = calls;
	}

	@SuppressWarnings("rawtypes")
	public String toString() {
		StringBuilder buf = new StringBuilder();

		buf.append(firstName);
		buf.append(" ");
		buf.append(lastName);

		if (address != null) {
			buf.append(", ");
			buf.append(address.toString());
		}

		if (!calls.isEmpty()) {
			for (Iterator iter = calls.iterator(); iter.hasNext();) {
				Call call = (Call) iter.next();
				buf.append("<br />");
				buf.append(call.toString());
			}
		}

		return buf.toString();
	}

} // end of class
