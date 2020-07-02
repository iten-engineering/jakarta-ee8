package ch.itenengineering.jpa.callcenter.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CC_CALL")
@NamedQueries( {
	@NamedQuery(name = "getCalls", query = "select c from Call c") })
public class Call implements Serializable {

	private static final long serialVersionUID = 1L;

	private int callId;

	private int customerId;

	private String request;

	private Date date;

	public Call() {
	}

	public Call(int customerId, String request, Date date) {
		this.customerId = customerId;
		this.date = date;
		this.request = request;
	}

	@Id
	@GeneratedValue
	@Column(name = "CALL_ID")
	public int getCallId() {
		return callId;
	}

	public void setCallId(int callId) {
		this.callId = callId;
	}

	@Column(name = "CUSTOMER_ID")
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Column(name = "REQUEST")
	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CALL_TS")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String toString() {
		StringBuilder buf = new StringBuilder();

		buf.append("- ");
		buf.append(request);

		buf.append(", ");
		buf.append(date);

		return buf.toString();
	}

} // end of class
