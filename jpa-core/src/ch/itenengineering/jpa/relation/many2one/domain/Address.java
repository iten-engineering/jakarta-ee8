package ch.itenengineering.jpa.relation.many2one.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "m2oAddress")
@Table(name = "R_MANY2ONE_ADDRESS")
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;

	private String street;

	private String streetNo;

	private String zipCode;

	private String city;

	private String country;

	private Company company;

	public Address() {
	}

	public Address(String street, String streetNo, String zipCode, String city,
			String country, Company company) {
		this.street = street;
		this.streetNo = streetNo;
		this.zipCode = zipCode;
		this.city = city;
		this.country = country;
		this.company = company;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreetNo() {
		return streetNo;
	}

	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getId() {
		return id;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String toString() {
		StringBuilder buf = new StringBuilder();

		buf.append(toStringAddressFieldsOnly());

		buf.append("\n  ");
		buf.append(company == null ? "Es ist keine Firma vorhanden" : company
				.toStringCompanyFieldsOnly());

		return buf.toString();
	}

	public String toStringAddressFieldsOnly() {
		StringBuilder buf = new StringBuilder();

		buf.append(id);

		buf.append(", ");
		buf.append(street);

		buf.append(" ");
		buf.append(streetNo);

		buf.append(", ");
		buf.append(zipCode);

		buf.append(" ");
		buf.append(city);

		buf.append(", ");
		buf.append(country);

		return buf.toString();
	}

} // end of class

