package ch.itenengineering.news.domain;

import java.io.Serializable;
import java.util.Date;

public class NewsItem implements Serializable {

	private static final long serialVersionUID = 1L;

	private Date createdAt = new Date();
	private String agency;
	private String news;

	public NewsItem() {
		super();
	}

	public NewsItem(String agency, String news) {
		this.agency = agency;
		this.news = news;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(this.createdAt);
		sb.append(": agency=");
		sb.append(this.agency);
		sb.append(", news=");
		sb.append(this.news);

		return sb.toString();
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

	public String getNews() {
		return news;
	}

	public void setNews(String news) {
		this.news = news;
	}

} // end
