package ch.itenengineering.websocket.chat.monitor;

import ch.itenengineering.websocket.chat.msg.Message;

public interface Monitor {

	public void start(String sessionId);

	public void message(String sessionId, Message message);

	public void stop(String sessionId);

} // end
