package ch.itenengineering.news.ejb;

import javax.ejb.Local;

import ch.itenengineering.news.domain.NewsItem;
import ch.itenengineering.news.domain.NewsItems;

@Local
public interface NewsService {

	/**
	 * Sends news to the queue.
	 * 
	 * @param newsItem
	 *            The news of an agency.
	 * @return The result of the send action.
	 */
	public String sendNews(NewsItem newsItem);

	/**
	 * Gets all news from the news store.
	 * 
	 * @return The news messages.
	 */
	public NewsItems requestNews();
	
} // end
