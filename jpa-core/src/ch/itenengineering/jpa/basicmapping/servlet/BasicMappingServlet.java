package ch.itenengineering.jpa.basicmapping.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch.itenengineering.jpa.basicmapping.domain.Company;
import ch.itenengineering.jpa.basicmapping.ejb.Manager;

@WebServlet("/basicmapping")
public class BasicMappingServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	private Manager manager;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// init
		String title = "Basic Mapping";
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

		// init
		int companyId = 1;

		// delete existing data (if available)
		manager.remove(Company.class, companyId);

		// add company
		Company company = new Company(companyId);
		manager.persist(company);

		// find and show company
		company = (Company) manager.find(Company.class, companyId);

		messages.add("find and show company:");
		messages.add(company.toString());
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
