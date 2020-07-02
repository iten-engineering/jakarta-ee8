package ch.itenengineering.ticket.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ch.itenengineering.ticket.ejb.BookingException;

public class BookingRulesInterceptor {

	public static final int MAX_QUANTITY = 6;

	@PersistenceContext(unitName = "TestPU")
	private EntityManager em;

	@AroundInvoke
	public Object checkRules(InvocationContext invocation) throws Exception {

		Object result;


			// get book method params
			Object[] params = invocation.getParameters();

			String customer = (String) params[0];
			String event = (String) params[1];
			int quantity = (Integer) params[2];

			// TODO ticket - implement
			return null;

	}

	private void checkQuantity(int quantity) throws Exception {
		if (quantity > MAX_QUANTITY) {
			throw new BookingException(
					"booking failed, maximal allowed quantity exceeded");
		}
	}

	private void checkDoubleBookings(String event, String customer)
			throws Exception {

		Query query = em
				.createQuery("select count(r) as cnt from Reservation r where r.event=:pEvent and r.customer=:pCustomer");

		query.setParameter("pEvent", event);
		query.setParameter("pCustomer", customer);

		long cnt = (Long) query.getSingleResult();

		if (cnt > 1) {
			throw new BookingException(
					"booking failed, customer has already a reservation for this event");
		}

	}

} // end of class
