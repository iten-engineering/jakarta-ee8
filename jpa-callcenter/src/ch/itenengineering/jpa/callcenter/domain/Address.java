package ch.itenengineering.jpa.callcenter.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CC_ADDRESS")
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	private int customerId;

	private String street;

	private String streetNo;

	private String zipCode;

	private String city;

	private String country;

	public Address() {
	}

	public Address(int customerId, String street, String streetNo,
			String zipCode, String city, String country) {
		this.customerId = customerId;
		this.street = street;
		this.streetNo = streetNo;
		this.zipCode = zipCode;
		this.city = city;
		this.country = country;
	}

	@Id
	@Column(name = "CUSTOMER_ID")
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Column(name = "STREET")
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Column(name = "STREET_NO")
	public String getStreetNo() {
		return streetNo;
	}

	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}

	@Column(name = "ZIP_CODE")
	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Column(name = "CITY")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "COUNTRY")
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String toString() {
		StringBuilder buf = new StringBuilder();

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

