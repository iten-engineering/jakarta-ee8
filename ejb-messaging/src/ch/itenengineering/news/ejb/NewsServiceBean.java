package ch.itenengineering.news.ejb;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.jms.JMSException;

import ch.itenengineering.news.domain.NewsItem;
import ch.itenengineering.news.domain.NewsItems;
import ch.itenengineering.news.ejb.NewsService;
import ch.itenengineering.news.ejb.sender.RequesterBean;
import ch.itenengineering.news.ejb.sender.SenderBean;

@Stateless
public class NewsServiceBean implements NewsService {

	@EJB
	SenderBean sender;

	@EJB
	RequesterBean requester;

	@Override
	public String sendNews(NewsItem newsItem) throws EJBException {
		try {
			String jmsMessageId = this.sender.send(newsItem);
			return "Sending news successfully done with " + jmsMessageId;

		} catch (JMSException e) {
			throw new EJBException("Sending news failed with exception: " + e.toString());
		}
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public NewsItems requestNews() throws EJBException {

		try {
			return this.requester.request();

		} catch (JMSException e) {
			throw new EJBException("Requesting news failed with exception: " + e.toString());
		}
	}

} // end
