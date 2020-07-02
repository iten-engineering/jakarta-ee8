package ch.itenengineering.websocket.chat.monitor;

public interface Observable {

	public void attach(Observer observer);

	public void detach(Observer observer);

} // end
