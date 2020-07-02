package ch.itenengineering.news.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch.itenengineering.news.domain.NewsItem;
import ch.itenengineering.news.domain.NewsItems;
import ch.itenengineering.news.ejb.NewsService;


@WebServlet("/news")
public class NewsServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String TITLE = "News Broker";
	private static final String DEFAULT_AGENCY = "AFP";
	private static final String DEFAULT_NEWS = "Today the weather is fine!";

	@EJB
	private NewsService newsService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {

		String html = this.renderHtml(DEFAULT_AGENCY, DEFAULT_NEWS, null);

		response.setContentType("text/html");
		response.getWriter().write(html);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {

		List<String> results = new ArrayList<String>();

		// get request params
		boolean runSend = request.getParameter("send") != null;
		boolean runRequest = request.getParameter("request") != null;

		String agency = request.getParameter("agency");
		String news = request.getParameter("news");

		// run request
		if (runSend) {

			try {
				String result = this.newsService.sendNews(new NewsItem(agency, news));
				results.add(result);
			} catch (EJBException e) {
				results.add(e.toString());
			}

		} else if (runRequest) {

			try {
				NewsItems newsItems = this.newsService.requestNews();

				
				if (newsItems == null) {
					results.add("The request failed with an expired timeout while waiting for the reply");
					
				} else	if (newsItems.getNewsItems().isEmpty()) {
					results.add("The news store is empty. Please send first some agency news.");

				} else {
					results.add("Received #" + newsItems.getNewsItems().size() + " records at " + new Date() + ":");
					for (NewsItem newsItem : newsItems.getNewsItems()) {
						results.add(newsItem.toString());
					}
				}

			} catch (Exception e) {
				results.add(e.toString());
			}

		} else {
			results.add("Received unknown request");
		}

		// render response
		String html = this.renderHtml(agency, news, results);

		response.setContentType("text/html");
		response.getWriter().write(html);
	}

	private String renderHtml(String agency, String news, List<String> results) {
		StringBuilder html = new StringBuilder();

		// begin
		html.append("<html>");

		// head
		html.append("<head><title>");
		html.append(TITLE);
		html.append("</title></head>");

		// body
		html.append("<body>");

		html.append("<h1>");
		html.append(TITLE);
		html.append("</h1>");

		html.append("<form name='news' method='post'>");

		html.append("Agency <input type='text' name='agency' value='" + agency + "' size='1' />&nbsp;&nbsp;");
		html.append("News   <input type='text' name='news'   value='" + news + "' size='50' /><br /><br />");

		html.append("<input type='submit' name='send'    value='Send news' />&nbsp;");
		html.append("<input type='submit' name='request' value='Request all news' />&nbsp;");
		html.append("</form>");

		if (results != null) {
			for (String result : results) {
				html.append(result);
				html.append("<br />");
			}
		}

		html.append("</body>");

		// end
		html.append("</html>");

		return html.toString();
	}

} // end
