package ch.itenengineering.ticket.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch.itenengineering.ticket.ejb.TicketAgency;

@WebServlet("/ticket")
public class AgencyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	TicketAgency agency;
	
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// init
		String title = "Ticket Agency";
		List<String> messages = new ArrayList<String>();

		// tests
		try {
			this.reserve(messages);

		} catch (Exception e) {
			e.printStackTrace();
			messages.add("request failed with exception: " + e.toString());
		}

		// render response
		String html = this.renderHtml(title, messages);

		response.setContentType("text/html");
		response.getWriter().write(html);

	}

	public void reserve(List<String> messages) throws Exception {

		// init test database
		agency.clear();

		// reserve some events
		book("Wild Markus", "Rolling Stones, Zuerich", 2, messages);
		book("Rouvinez Jean Claude", "Hochzeitsnacht im Paradies, Leipzig", 2, messages);
		book("Bolzli Patrick", "YB - Sion, Bern", 4, messages);

		// maximal allowed quantity exceeded
		try {
			book("Nydegger Stefan", "Deep Purple, Lausanne", 10, messages);
		} catch (Exception e) {
			messages.add(e.toString());
		}

		// double booking
		try {
			book("Rouvinez Jean Claude", "Hochzeitsnacht im Paradies, Leipzig",
					2, messages);
		} catch (Exception e) {
			messages.add(e.toString());
		}

	}

	private void book(String customer, String event, int quantity, List<String> messages)
			throws Exception {

		int reservationId = agency.book(customer, event, quantity);

		messages.add(quantity + " Tickets for " + event + " reserved by "
				+ customer + " with id #" + reservationId);

	}
	
	private String renderHtml(String title, List<String> messages) {
		StringBuilder html = new StringBuilder();

		// begin
		html.append("<html>");

		// head
		html.append("<head><title>");
		html.append(title);
		html.append("</title></head>");

		// body
		html.append("<body>");

		html.append("<h1>");
		html.append(title);
		html.append("</h1>");

		for (String message : messages) {
			html.append(message);
			html.append("<br />");
		}

		html.append("</body>");

		// end
		html.append("</html>");

		return html.toString();
	}

} // end
