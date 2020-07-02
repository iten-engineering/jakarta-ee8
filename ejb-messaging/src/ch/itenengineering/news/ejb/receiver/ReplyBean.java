package ch.itenengineering.news.ejb.receiver;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import ch.itenengineering.news.domain.NewsItems;
import ch.itenengineering.news.ejb.Messaging;


@Stateless
public class ReplyBean {

	@Resource(name = "java:/jms/TestConnectionFactory")
	private ConnectionFactory connectionFactory;


	public void send(String correlationID, Destination replyDestination, NewsItems newsItems)
			throws JMSException {

		Connection connection = null;

		try {
			connection = this.connectionFactory.createConnection();
			Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);

			ObjectMessage om = session.createObjectMessage(newsItems);
			om.setJMSCorrelationID(correlationID);
			
			MessageProducer sender = session.createProducer(replyDestination);
			sender.setTimeToLive(Messaging.TIME_TO_LIVE);

			sender.send(om);

		} finally {
			this.closeConnection(connection);
		}
	}

	private void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (JMSException e) {
				System.out.println("NewsService failed to close connection with exception: " + e.toString());
			}
		}
	}

} // end
