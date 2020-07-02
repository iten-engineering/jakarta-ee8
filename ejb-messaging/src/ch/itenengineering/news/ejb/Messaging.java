package ch.itenengineering.news.ejb;

/**
 * Defines some common messaging settings.
 */
public class Messaging {

	public static final String ACTION_KEY = "action";
	
	public static final String ACTION_SEND = "send";

	public static final String ACTION_REQUEST = "request";
	
	public static final int TIME_TO_LIVE = 500;
	
	public static final int TIME_TO_WAIT = 3 * TIME_TO_LIVE; // 2 x message ttl + work time of the reply bean
	
	/**
	 * Hide creation for "static" class
	 */
	private Messaging() {
		super();
	}
	
} // end
