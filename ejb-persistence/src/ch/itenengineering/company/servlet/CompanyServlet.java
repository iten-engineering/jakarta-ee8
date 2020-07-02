package ch.itenengineering.company.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch.itenengineering.company.domain.Company;
import ch.itenengineering.company.ejb.CompanyManager;

@WebServlet("/company")
public class CompanyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// TODO company - inject ejb by the container
	CompanyManager companyManager;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// init
		String title = "Company";
		List<String> messages = new ArrayList<String>();

		// test order
		try {
			messages.add("<b>Test CRUD</b>");
			this.testCRUD(messages);

		} catch (Exception e) {
			e.printStackTrace();
			messages.add("request failed with exception: " + e.toString());
		}

		// render response
		String html = this.renderHtml(title, messages);

		response.setContentType("text/html");
		response.getWriter().write(html);

	}

	private void testCRUD(List<String> messages) throws Exception {

		// TODO company - add test methods (create, read, update, delete)
	}


	private void addCompanies(List list, List<String> messages) {
		if ((list == null) || (list.isEmpty())) {
			messages.add("no companies found (empty list)");
		} else {
			for (Iterator iter = list.iterator(); iter.hasNext();) {
				Company element = (Company) iter.next();
				messages.add(element.toString());
			}
		}
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
