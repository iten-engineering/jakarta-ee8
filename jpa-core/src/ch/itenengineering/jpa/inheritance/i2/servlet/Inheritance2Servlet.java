package ch.itenengineering.jpa.inheritance.i2.servlet;

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

import ch.itenengineering.jpa.inheritance.i2.domain.Customer;
import ch.itenengineering.jpa.inheritance.i2.domain.Employee;
import ch.itenengineering.jpa.inheritance.i2.domain.Person;
import ch.itenengineering.jpa.inheritance.i2.domain.Employee.EmployeeType;
import ch.itenengineering.jpa.inheritance.i2.ejb.ManagerI2;

/**
 * @see InheritanceClientI1
 */
@WebServlet("/inheritance/i2")
public class Inheritance2Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	private ManagerI2 manager;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// init
		String title = "Inheritance 2 single table per concrete entity class";
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
		// delete existing data
		manager.deleteAll();

		// insert test data
		manager.add(new Person(20, "Thomas", "Iten"));
		manager.add(new Customer(21, "Daniel", "Schmutz", "ZFI"));
		manager.add(new Employee(22, "Willy", "Vollenweider", 1,
				EmployeeType.MANAGER));

		List list = manager.findAll();
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			Person p = (Person) iter.next();
			messages.add(p.toString());
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
