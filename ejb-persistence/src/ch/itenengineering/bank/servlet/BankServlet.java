package ch.itenengineering.bank.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJBException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch.itenengineering.bank.ejb.AccountManager;

@WebServlet("/bank")
public class BankServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// init
		String title = "Bank Account";
		List<String> messages = new ArrayList<String>();

		// test
		try {
			messages.add("<b>Test</b>");
			this.testAccount(messages);


		} catch (Exception e) {
			messages.add("request failed with exception: " + e.toString());
		}

		// render response
		String html = this.renderHtml(title, messages);

		response.setContentType("text/html");
		response.getWriter().write(html);

	}

	/**
	 * Gets a new stateful account manager session.
	 */
	private AccountManager getAccountManager() throws NamingException {
		Context ctx = new InitialContext();
		return (AccountManager) ctx.lookup("java:global/ejb-persistence/AccountManagerBean");
	}

	private void testAccount(List<String> messages) throws Exception {

		// TODO bank - implement test calls
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
