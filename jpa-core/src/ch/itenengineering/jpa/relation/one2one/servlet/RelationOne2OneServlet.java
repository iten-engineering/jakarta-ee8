package ch.itenengineering.jpa.relation.one2one.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch.itenengineering.jpa.relation.one2one.domain.Address;
import ch.itenengineering.jpa.relation.one2one.domain.Company;
import ch.itenengineering.jpa.relation.one2one.ejb.ManagerO2O;

@WebServlet("/relation/one2one")
public class RelationOne2OneServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	private ManagerO2O manager;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// init
		String title = "Relation One2One unidirectional";
		List<String> messages = new ArrayList<String>();

		// test
		try {
			this.test(messages);

		} catch (Exception e) {
			e.printStackTrace();
			messages.add("request failed with exception: " + e.toString());
		}

		// render response
		String html = this.renderHtml(title, messages);

		response.setContentType("text/html");
		response.getWriter().write(html);

	}

	private void test(List<String> messages) throws Exception {

		//
		// init
		//
		int companyId1 = 1;
		int companyId2 = 2;
		int companyId3 = 3;

		// delete existing data (if available)
		manager.remove(Company.class, companyId1);
		manager.remove(Company.class, companyId2);
		manager.remove(Company.class, companyId3);

		//
		// add company with an address
		//
		Address a1 = new Address("Ryf", "89", "3280", "Murten", "Schweiz");
		Company c1 = new Company(companyId1, "BISE NOIRE", "Surfcenter Murten",
				a1);

		c1 = (Company) manager.persist(c1);

		messages.add("add company with an address:");
		messages.add(c1.toString());

		// modifiy address an save changes
		c1.getAddress().setStreetNo("98a");
		manager.merge(c1);

		messages.add("modify company's address (street no):");
		messages.add(manager.find(Company.class, companyId1).toString());

		//
		// add company without an address
		//
		Company c2 = new Company(companyId2, "Intersport",
				"Sportartikel Wiederverk�ufer", null);

		manager.persist(c2);

		messages.add("add company without an address:");
		messages.add(manager.find(Company.class, companyId2).toString());

		//
		// add company with an address and remove address
		//
		Address a3 = new Address("Markgasse", "50", "3000", "Bern", "Schweiz");
		Company c3 = new Company(companyId3, "Vaucher", "Vaucher Sports Bern",
				a3);

		c3 = (Company) manager.persist(c3);

		messages.add("add company with an address:");
		messages.add(c3.toString());

		// remove address an save changes
		c3.setAddress(null);
		manager.merge(c3);

		messages.add("remove company's address:");
		messages.add(manager.find(Company.class, companyId3).toString());

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
