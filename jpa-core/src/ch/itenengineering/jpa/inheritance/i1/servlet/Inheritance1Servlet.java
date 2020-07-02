package ch.itenengineering.jpa.inheritance.i1.servlet;

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

import ch.itenengineering.jpa.inheritance.i1.domain.Customer;
import ch.itenengineering.jpa.inheritance.i1.domain.Employee;
import ch.itenengineering.jpa.inheritance.i1.domain.Person;
import ch.itenengineering.jpa.inheritance.i1.domain.Employee.EmployeeType;
import ch.itenengineering.jpa.inheritance.i1.ejb.ManagerI1;

/**
 * JPA Sample - Inheritance
 *
 * Samples:
 * I1 - single table per class hierarchy
 * I2 - single table per concrete entity class
 * I3 - single table per subclass / joined strategy
 *
 * Entity names:
 * All entities have a unique name within the inheritance project.
 * The name is defined by the @Entity annotation.
 *   Samples:
 *
 *   Entity Name		Entity Class
 *     PersonI1		...inheritance.i1.domain.Person
 *     PersonI2		...inheritance.i2.domain.Person
 *
 * Table names:
 * Also all tables have a unique name, starting with the relationship
 * sample number (i.e. I1_PERSON, I3_PERSON, etc).
 */
@WebServlet("/inheritance/i1")
public class Inheritance1Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	private ManagerI1 manager;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// init
		String title = "Inheritance 1 single table per class hierarchy";
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
		manager.add(new Person(10, "Thomas", "Iten"));
		manager.add(new Customer(11, "Daniel", "Schmutz", "ZFI"));
		manager.add(new Employee(12, "Willy", "Vollenweider", 1,
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
