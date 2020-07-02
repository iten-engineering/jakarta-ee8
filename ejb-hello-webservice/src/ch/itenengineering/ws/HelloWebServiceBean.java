package ch.itenengineering.ws;

import javax.ejb.Stateless;
import javax.jws.WebService;

@Stateless
@WebService(serviceName = "HelloWebService", endpointInterface = "ch.itenengineering.ws.HelloWebService")
public class HelloWebServiceBean implements HelloWebService {

	public String echo(String message) {

		return "echo from HelloWebServiceBean - received message = " + message;
	}

}
