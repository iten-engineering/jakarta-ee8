package ch.itenengineering.ticket.ejb;

import javax.ejb.Local;

@Local
public interface TicketAgency {

	public void clear();

	public int book(String customer, String event, int quantity)
			throws Exception;

}
