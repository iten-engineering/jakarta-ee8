package ch.itenengineering.news.ejb.sender;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import ch.itenengineering.news.domain.NewsItem;
import ch.itenengineering.news.ejb.Messaging;


@Stateless
public class SenderBean {

	// TODO messaging - define ConnectionFactory

	// TODO messaging - define Destination

	/**
	 * Sends the news to save in the store.
	 *
	 * @param newsItem
	 *            The news item to store.
	 * @return The message id set by the provider. This id is unique within all sent messages.
	 * @throws JMSException
	 *             The send failed.
	 */
	public String send(NewsItem newsItem) throws JMSException {

		Connection connection = null;

		try {

			// TODO messaging - implement send()
			return null;

		} finally {
			this.closeConnection(connection);
		}
	}

	/**
	 * Close the connection and all related JMS resources.
	 */
	private void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (JMSException e) {
				System.out.println("SenderBean failed to close the connection with exception: "
						+ e.toString());
			}
		}
	}

} // end

