package ch.itenengineering.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface HelloWebService {

	/**
	 * Web Service Endpoint Interface.
	 */
	@WebMethod
	public String echo(String message);

}
