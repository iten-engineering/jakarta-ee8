package ch.itenengineering.bank.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BANK_ACCOUNT")
public class BankAccount implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ACCOUNT_NUMBER")
	private Integer number;

	@Column(name = "OWNER")
	private String owner;

	@Column(name = "BALANCE")
	private Double balance;

	public BankAccount() {
	}

	public BankAccount(Integer number) {
		this.number = number;
	}

	public void deposit(Double amount) {

		if (balance == null) {
			balance = amount;
		} else {
			balance += amount;
		}
	}

	public void withdraw(Double amount) throws Exception {
		balance -= amount;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Double getBalance() {
		return balance;
	}

	public int getNumber() {
		return number;
	}

	public String toString() {

		StringBuilder sb = new StringBuilder();

		sb.append("number=");
		sb.append(number);

		sb.append(", owner=");
		sb.append(owner);

		sb.append(", balance=");
		sb.append(balance);

		return sb.toString();
	}

} // end of class
