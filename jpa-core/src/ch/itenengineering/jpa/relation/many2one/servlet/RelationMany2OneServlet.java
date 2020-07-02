package ch.itenengineering.jpa.relation.many2one.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch.itenengineering.jpa.relation.many2one.domain.Address;
import ch.itenengineering.jpa.relation.many2one.domain.Company;
import ch.itenengineering.jpa.relation.many2one.ejb.ManagerM2O;

@WebServlet("/relation/many2one")
public class RelationMany2OneServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	private ManagerM2O manager;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// init
		String title = "Relation Many2One/One2Many bidirectional";
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
		int companyId = 1;

		//
		// delete existing data
		//
		manager.remove(Company.class, companyId);

		//
		// create company with two addresses
		//
		List<Address> addressList = new ArrayList<Address>();
		Company company = new Company(companyId, "Intersport",
				"Sportartikel Wiederverkaeufer", addressList);
		addressList.add(new Address("Obere Zollgasse", "75", "3072",
				"Ostermundigen", "Schweiz", company));
		addressList.add(new Address("Postfach", null, "3072", "Ostermundigen",
				"Schweiz", company));

		manager.persist(company);

		messages.add("create company with two addresses:");
		messages.add(manager.find(Company.class, companyId).toString());

		//
		// add third address with relationship to the company
		//
		company = (Company) manager.find(Company.class, companyId);

		Address address = new Address("Obere Zollgasse", "75b", "3072",
				"Ostermundigen", "Schweiz", company);

		/*
		 * Bemerkung: Das folgende Statement : manager.persist(address) hat mit
		 * JBoss 5, Hibernate und HSQL DB funktioniert. Mit NetBeans 6,
		 * EclipseLink und Java DB wird die Adresse zwar auch korrekt (inkl.
		 * Foreign Key auf Company) eingefuegt, die Beziehung zu Company wird
		 * aber nicht aktualisiert. Daher wird die neue Adresse via
		 * manager.merge(company) dazugefuegt.
		 */
		company.getAddressList().add(address);
		manager.merge(company);

		messages.add("add third address with relationship to the company:");
		messages.add(manager.find(Company.class, companyId).toString());
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
