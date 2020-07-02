package ch.itenengineering.ticket.ejb;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ch.itenengineering.ticket.domain.Reservation;

@Stateless
public class TicketAgencyBean implements TicketAgency {

	@PersistenceContext(unitName = "TestPU")
	private EntityManager em;

	public void clear() {
		em.createQuery("delete from Reservation").executeUpdate();
	}

	public int book(String customer, String event, int quantity)
			throws Exception {

		Reservation reservation = new Reservation(customer, event, quantity);

		em.persist(reservation);

		return reservation.getId();

	}
} // end of class
