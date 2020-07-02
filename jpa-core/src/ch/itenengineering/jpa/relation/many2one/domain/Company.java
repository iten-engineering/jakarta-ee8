package ch.itenengineering.jpa.relation.many2one.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity(name = "m2oCompany")
@Table(name = "R_MANY2ONE_COMPANY")
public class Company implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;

	private String description;

	@Transient  // TODO Transient erstetzen mit entsprechendem Mapping
	private List<Address> addressList = new ArrayList<Address>();

	public Company() {
	}

	public Company(int id, String name, String description,
			List<Address> addressList) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.addressList = addressList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}

	public String toString() {
		StringBuilder buf = new StringBuilder();

		buf.append(toStringCompanyFieldsOnly());

		buf.append("\n  Address List:");
		if (addressList != null) {
			for (Iterator<Address> iterator = addressList.iterator(); iterator
					.hasNext();) {
				Address address = iterator.next();
				buf.append("\n    ");
				buf.append(address.toStringAddressFieldsOnly());
			}
		} else {
			buf.append("\n    Es sind keine Daten vorhanden.");
		}

		return buf.toString();
	}

	public String toStringCompanyFieldsOnly() {
		StringBuilder buf = new StringBuilder();

		buf.append(id);

		buf.append(", ");
		buf.append(name);

		buf.append(", ");
		buf.append(description);

		return buf.toString();
	}

} // end of class
