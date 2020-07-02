package ch.itenengineering.timer.servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch.itenengineering.timer.ejb.TimerCtrl;

@WebServlet("/timer")
public class TimerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	TimerCtrl timerCtrl;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		StringBuilder html = new StringBuilder();

		try {
			// begin page
			html.append(this.renderHtmlBegin("Timer"));

			// execute action
			String action = request.getParameter("action");

			if (action != null) {
				// start new timer
				if (action.equals("start")) {
					String name = request.getParameter("name");
					String interval = request.getParameter("interval");
					timerCtrl.start(name, Long.valueOf(interval));

				// stop existing timer
				} else if (action.equals("stop")) {
					String name = request.getParameter("name");
					timerCtrl.stop(name);
				}
			}

			// add content
			List<String> names = timerCtrl.listNames();
			html.append(this.renderHtmlContent(names));

		} catch (Exception e) {
			// add error message
			html.append("<h2>Error</h2>");
			html.append(e.toString());

		} finally {
			// end page
			html.append(this.renderHtmlEnd());

			// return result
			response.setContentType("text/html");
			response.getWriter().write(html.toString());
		}
	}

	private String renderHtmlBegin(String title) {
		StringBuilder html = new StringBuilder();

		// begin
		html.append("<html>");

		// head
		html.append("<head><title>");
		html.append(title);
		html.append("</title></head>");

		// body start
		html.append("<body>");

		// title
		html.append("<h1>");
		html.append(title);
		html.append("</h1>");

		// return result
		return html.toString();
	}

	private String renderHtmlContent(List<String> names) {
		StringBuilder html = new StringBuilder();

		// start new timer
		html.append("<h2>Start new Timer</h2>");

		html.append("<form name='start' action='' methode='post'>");
		html.append("<table>");
		html.append("<tr><td>Name</td><td><input type='text' name='name' /></td></tr>");
		html.append("<tr><td>Interval [ms]</td><td><input type='text' name='interval' /></td></tr>");
		html.append("<tr><td colspan='2'>");
		html.append("</td></tr>");
		html.append("</table>");
		html.append("<input type='hidden' name='action' value='start' />");
		html.append("<input type='submit' value='Start' />");
		html.append("</form>");

		// stop existing timers
		html.append("<h2>Existing Timer</h2>");
		if (names.isEmpty()) {
			html.append("No timers available.");
			return html.toString();
		}

		int i = 0;
		html.append("<table>");
		for (String name : names) {
			String formName = "stop" + i++;
			html.append("<tr>");
			html.append("<form name='" + formName
					+ "' action='' methode='post'>");
			html.append("<td><input type='submit' value='Stop' /></td><td>"
					+ name + "</td>");
			html.append("<td>");
			html.append("<input type='hidden' name='action' value='stop' />");
			html.append("<input type='hidden' name='name' value='" + name
					+ "' />");
			html.append("</td>");
			html.append("</form>");
			html.append("</tr>");

		}
		html.append("</table>");

		return html.toString();
	}

	private String renderHtmlEnd() {
		StringBuilder html = new StringBuilder();

		html.append("</body>");
		html.append("</html>");

		return html.toString();
	}

} // end
