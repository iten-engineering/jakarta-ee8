package ch.itenengineering.jpa.callcenter.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch.itenengineering.jpa.callcenter.domain.Address;
import ch.itenengineering.jpa.callcenter.domain.Call;
import ch.itenengineering.jpa.callcenter.domain.Customer;
import ch.itenengineering.jpa.callcenter.ejb.CallCenter;
import ch.itenengineering.jpa.callcenter.ejb.CriteriaQueries;

@WebServlet("/callcenter")
public class CallCenterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	List<String> messages;

	@EJB
	private CallCenter cc;

	@EJB
	private CriteriaQueries criteria;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// init
		String title = "JPA Call Center";
		messages = new ArrayList<String>();

		// test
		try {
			this.loadTestData();
			this.runQueries();
			// this.runCriteriaQueries();

		} catch (Exception e) {
			e.printStackTrace();
			messages.add("request failed with exception: " + e.toString());
		}

		// render response
		String html = this.renderHtml(title, messages);

		response.setContentType("text/html");
		response.getWriter().write(html);

	}

	public void loadTestData() throws Exception {
		int id;
		List<Call> calls;
		Address adr;
		Customer cust;

		// init
		cc.clearAll();

		// customer 1
		id = 1;

		calls = new ArrayList<Call>();
		calls.add(new Call(id, "Bildschirm flimmert", toDate("12.02.2007")));
		calls.add(new Call(id, "Maus defekt", toDate("25.03.2007")));
		calls.add(new Call(id, "Passwort vergessen", toDate("27.05.2007")));

		adr = new Address(id, "Gartenweg", "2a", "3007", "Bern", "Schweiz");

		cust = new Customer(1, "Peter", "Kohler", adr, calls);

		cc.addCustomer(cust);

		// customer 2
		id = 2;

		calls.clear();
		calls.add(new Call(id, "Bildschirm flimmert", toDate("02.07.2007")));

		adr = new Address(id, "Schlosshaldenstrasse", "75", "3005", "Bern", "Schweiz");

		cust = new Customer(id, "Sandra", "Schweizer", adr, calls);

		cc.addCustomer(cust);

		// customer 3
		id = 3;

		calls.clear();
		calls.add(new Call(id, "Harddisk defekt", toDate("05.01.2007")));
		calls.add(new Call(id, "Passwort vergessen", toDate("01.03.2007")));
		calls.add(new Call(id, "Zuwenig Berechtigungen", toDate("03.03.2007")));
		calls.add(new Call(id, "Bildschirm flimmert", toDate("02.07.2007")));

		adr = new Address(id, "Bernstrasse", "5", "3073", "Gümligen", "Schweiz");

		cust = new Customer(id, "Richard", "Gerber", adr, calls);

		cc.addCustomer(cust);
	}

	public void runQueries() throws Exception {

		// -----------------------------------------------------------------
		// get customer (for a given id)
		// -----------------------------------------------------------------

		messages.add(toString("getCustomer", "1"));

		Object result = cc.getCustomer(1);

		messages.add(toString(result));

		// -----------------------------------------------------------------
		// single results
		// -----------------------------------------------------------------

		// Liefert ein Customer Objekt
		getSingleResult("select c from Customer c where c.customerId = 2");

		// TODO jpa - call center - add single result queries

		// -----------------------------------------------------------------
		// result list
		// -----------------------------------------------------------------

		// Liefert eine List mit Customer Objekten
		getResultList("select c from Customer c");

		// TODO jpa - call center - add result list queries

		// -----------------------------------------------------------------
		// navigation
		// -----------------------------------------------------------------

		// TODO jpa - call center - add navigation query

		// -----------------------------------------------------------------
		// join
		// -----------------------------------------------------------------

		// TODO jpa - call center - add join query

		// -----------------------------------------------------------------
		// named queries
		// -----------------------------------------------------------------

		getNamedQueryResultList("getCalls");

		// TODO jpa - call center - add named query
		// getNamedQueryResultList("getCallsByDate", toDate("02.07.2007"));

	}

	public void runCriteriaQueries() throws Exception {

		messages.add(toString("criteria query", "selectCustomers"));
		messages.add(toString(this.criteria.selectCustomers()));

		messages.add(toString("criteria query", "selectCustomerFirstNames"));
		messages.add(toString(this.criteria.selectCustomerFirstNames()));

		messages.add(toString("criteria query", "selectCustomeFirstNamesOrdered"));
		messages.add(toString(this.criteria.selectCustomeFirstNamesOrdered()));

		messages.add(toString("criteria query", "selectCustomerById(1)"));
		messages.add(toString(this.criteria.selectCustomerById(1)));

	}

	private void getSingleResult(String ejbQuery) throws Exception {

		messages.add(toString("getSingleResult", ejbQuery));

		Object result = cc.getSingleResult(ejbQuery);

		messages.add(toString(result));
	}

	@SuppressWarnings("rawtypes")
	private void getResultList(String ejbQuery) throws Exception {

		messages.add(toString("getResultList", ejbQuery));

		List result = cc.getResultList(ejbQuery);

		messages.add(toString(result));
	}

	@SuppressWarnings("rawtypes")
	private void getNamedQueryResultList(String queryName) throws Exception {

		messages.add(toString("getNamedQueryResultList", queryName));

		List result = cc.getNamedQueryResultList(queryName);

		messages.add(toString(result));
	}

	@SuppressWarnings("rawtypes")
	private void getNamedQueryResultList(String queryName, Date date) throws Exception {
		messages.add(toString("getNamedQueryResultList", queryName));

		List result = cc.getNamedQueryResultList(queryName, date);

		messages.add(toString(result));
	}

	public String toString(String title, String value) {
		StringBuilder buf = new StringBuilder();

		buf.append("<br />");
		buf.append("#<br />");
		buf.append("#" + title + ": " + value + "<br />");
		buf.append("#");

		return buf.toString();
	}

	@SuppressWarnings("rawtypes")
	public String toString(Object object) {

		if (object == null) {
			return "empty result (objet is null)";

		} else if (object instanceof List) {
			return toString((List) object);

		} else if (object instanceof Object[]) {
			return toString((Object[]) object);

		} else {
			return object.toString();
		}
	}

	@SuppressWarnings("rawtypes")
	public String toString(List list) {
		StringBuilder buf = new StringBuilder();

		if (list == null || list.isEmpty()) {
			buf.append("empty list (result set)<br />");
		} else {
			for (Iterator iter = list.iterator(); iter.hasNext();) {
				buf.append(toString(iter.next()));
				buf.append("<br />");
			}
		}

		return buf.toString();
	}

	private String toString(Object[] objects) {
		StringBuilder buf = new StringBuilder();
		boolean first = true;

		for (Object object : objects) {
			if (first) {
				first = false;
			} else {
				buf.append(", ");
			}

			buf.append(object);
		}

		return buf.toString();
	}

	/**
	 * return date object for the given input string in the form "dd.MM.yyyy"
	 * 
	 * @param dateAsString
	 * @return converted String
	 * @throws ParseException
	 */
	private Date toDate(String dateAsString) throws ParseException {
		DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		Date convertedDate = null;

		// Invalid dates (e.g. 31.12.2007) must cause a ParseException
		format.setLenient(false);

		if (dateAsString != null && dateAsString.trim().length() > 0) {
			convertedDate = format.parse(dateAsString);
		}

		return convertedDate;
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
