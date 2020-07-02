package ch.itenengineering.ticket.ejb;

import javax.ejb.ApplicationException;

public class BookingException extends Exception {

	private static final long serialVersionUID = 1L;

	public BookingException() {
		super();
	}

	public BookingException(String message) {
		super(message);
	}

}
