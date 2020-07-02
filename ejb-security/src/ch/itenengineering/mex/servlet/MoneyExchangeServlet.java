package ch.itenengineering.mex.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.ejb.EJBAccessException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch.itenengineering.mex.ejb.CurrencyType;
import ch.itenengineering.mex.ejb.MoneyExchange;

public class MoneyExchangeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	MoneyExchange mex;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = null;

		try {

			// init
			response.setContentType("text/html;charset=UTF-8");
			out = response.getWriter();

			out.println("<h1>Money Exchange Sample</h1>");

			// get rates
			out.println("Rates for user " + request.getRemoteUser() + ": <br />");
			out.println("- 1 CHF = " + mex.getRate(CurrencyType.EUR) + " EUR <br />");
			out.println("- 1 CHF = " + mex.getRate(CurrencyType.USD) + " USD <br />");

			// get bonus
			out.println("<p>");
			try {
				out.println("with bonus of " + mex.getVIPBonus() + " percent");
			} catch (EJBAccessException e) {
				out.println("with no bonus, access denied with exception " + e.toString());
			}
			out.println("</p>");

			// show logout button
			out.println("<br />");
			out.println("<form method='post' action='mex/logout' name='logout'>");
			out.println("Click this button to logout:<br />");
			out.println("<input type='submit' name='logout' value='Logout' />");
			out.println("</form>");

		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

}
