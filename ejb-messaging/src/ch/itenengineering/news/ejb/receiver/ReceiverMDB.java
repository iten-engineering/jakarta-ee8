package ch.itenengineering.news.ejb.receiver;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import ch.itenengineering.news.domain.NewsItem;
import ch.itenengineering.news.ejb.Messaging;
import ch.itenengineering.news.ejb.store.StoreBean;

// TODO messaging - add MDB annotations
public class ReceiverMDB implements MessageListener {

	@Override
	public void onMessage(Message message) {

		// TODO messaging - implement onMessage()
//		try {
//
//
//		} catch (JMSException e) {
//			System.out.println("ReceiverMDB failed with exception: "
//					+ e.toString());
//		}
	}

} // end
