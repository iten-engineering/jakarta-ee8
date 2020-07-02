package ch.itenengineering.news.domain;

import java.io.Serializable;
import java.util.List;

public class NewsItems implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<NewsItem> newsItems;

	public NewsItems() {
		super();
	}

	public NewsItems(List<NewsItem> newsItems) {
		super();
		this.newsItems = newsItems;
	}

	public List<NewsItem> getNewsItems() {
		return newsItems;
	}

	public void setNewsItems(List<NewsItem> newsItems) {
		this.newsItems = newsItems;
	}

} // end
