package ch.itenengineering.websocket.chat.monitor;

public interface Observer {

	public void notifyCreate(String id, String name, int count);

	public void notifyUpdate(String id, int count);

	public void notifyDelete(String id);

}
