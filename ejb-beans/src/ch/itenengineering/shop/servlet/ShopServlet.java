package ch.itenengineering.shop.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.NoSuchEJBException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch.itenengineering.shop.domain.Item;
import ch.itenengineering.shop.ejb.Basket;

@WebServlet("/shop")
public class ShopServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// init
		String title = "Booshop";
		List<String> messages = new ArrayList<String>();

		// test order
		try {
		    this.testOrder(messages);

		} catch (Exception e) {
		    e.printStackTrace();
		    messages.add("request failed with exception: " + e.toString());
		}

		// render response
		String html = this.renderHtml(title, messages);

		response.setContentType("text/html");
		response.getWriter().write(html);

	}

	/**
	 * Gets a new stateful basket.
	 */
	private Basket getBasket() throws NamingException {
		Context ctx = new InitialContext();
		return (Basket) ctx.lookup("java:global/ejb-beans/BasketBean");
	}

	private void testOrder(List<String> messages) throws Exception {

		// init
		Basket basketA = this.getBasket();
		Basket basketB = this.getBasket();


		// add items
		// TODO shop - implement


		// show items
		// TODO shop - implement



		// close baskets
		// TODO shop - implement


	}

	private void addBasket(List<String> messages, Map<String, Item> basket) {
		for (Iterator<String> iter = basket.keySet().iterator(); iter.hasNext();) {
			String key = (String) iter.next();
			Item item = basket.get(key);
			messages.add("-" + item.toString());
		}
		messages.add("<br />");
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
