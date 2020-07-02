package ch.itenengineering.ticket.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Reservation {

	private int id;

	private String customer;

	private String event;

	private int quantity;

	public Reservation() {
	}

	public Reservation(String customer, String event, int quantity) {
		this.customer = customer;
		this.event = event;
		this.quantity = quantity;
	}

	@Id
	@GeneratedValue
	@Column(name = "RESERVATION_ID")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "CUSTOMER")
	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	@Column(name = "EVENT")
	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	@Column(name = "QTY")
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

} // end of class
