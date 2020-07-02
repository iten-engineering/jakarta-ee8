package ch.itenengineering.websocket.chat;

import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/monitor")
public class MonitorEndpoint {

	private String createJson(String action, String id, String name, Integer count) {
		// "{"action": "create", "id": "1234", "name": "Tom", "count": 1}"
		StringBuilder buf = new StringBuilder();

		buf.append("{");
		buf.append("\"action\": \"").append(action).append("\"");
		buf.append(",\"id\": \"").append(id).append("\"");
		if (name != null) {
			buf.append(",\"name\": \"").append(name).append("\"");
		}
		if (count != null) {
			buf.append(",\"count\": \"").append(count).append("\"");
		}
		buf.append("}");

		return buf.toString();
	}

} // end
