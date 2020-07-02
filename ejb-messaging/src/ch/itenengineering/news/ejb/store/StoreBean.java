package ch.itenengineering.news.ejb.store;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Singleton;

import ch.itenengineering.news.domain.NewsItem;
import ch.itenengineering.news.domain.NewsItems;


@Singleton
public class StoreBean {

	List<NewsItem> items = new ArrayList<NewsItem>();

	public void saveNewsItem(NewsItem item) {
		
		this.items.add(item);

	}

	public NewsItems getNewsItems() {
		return new NewsItems(this.items);
	}

} // end
