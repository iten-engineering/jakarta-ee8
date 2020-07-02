package ch.itenengineering.jpa.relation.many2many.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch.itenengineering.jpa.relation.many2many.domain.Course;
import ch.itenengineering.jpa.relation.many2many.domain.Student;
import ch.itenengineering.jpa.relation.many2many.ejb.ManagerM2M;


@WebServlet("/relation/many2many")
public class RelationMany2ManyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	private ManagerM2M manager;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// init
		String title = "Relation Many2Many unidirectional";
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
		Course c1 = new Course(1, "Mathematik");
		Course c2 = new Course(2, "Englisch");
		Course c3 = new Course(3, "Sport");

		Student s1 = new Student(1, "Michael Reber");
		Student s2 = new Student(2, "Claudia Nacht");
		Student s3 = new Student(3, "Jaqueline M�ller");

		manager.clear();

		//
		// add courses, students and do bookings
		//
		manager.persist(c1);
		manager.persist(c2);
		manager.persist(c3);

		manager.persist(s1);
		manager.persist(s2);
		manager.persist(s3);

		// book one course for student 1
		manager.book(s1.getId(), c3.getId());

		messages.add("book one course for student 1:");
		messages.add(manager.find(Student.class, s1.getId()).toString());

		// book two course for student 2
		manager.book(s2.getId(), c1.getId());
		manager.book(s2.getId(), c2.getId());

		messages.add("book two course for student 2:");
		messages.add(manager.find(Student.class, s2.getId()).toString());

		// book three courses for student 3
		manager.book(s3.getId(), c1.getId());
		manager.book(s3.getId(), c2.getId());
		manager.book(s3.getId(), c3.getId());

		messages.add("book three courses for student 3:");
		messages.add(manager.find(Student.class, s3.getId()).toString());

		// cancel course two for student 3
		manager.cancel(s3.getId(), c2.getId());

		messages.add("cancel course two for student 3:");
		messages.add(manager.find(Student.class, s3.getId()).toString());
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
