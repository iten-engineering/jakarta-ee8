package ch.itenengineering.ws.client;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import ch.itenengineering.ws.HelloWebService;

public class ApacheCFXClient {

	/**
	 * JBoss AS 7 ships with Apache CXF web services implementation.
	 * 
	 * Apache CXF is an open source services framework. CXF helps you build and
	 * develop services using frontend programming APIs, like JAX-WS and JAX-RS.
	 * These services can speak a variety of protocols such as SOAP, XML/HTTP,
	 * RESTful HTTP, or CORBA and work over a variety of transports such as
	 * HTTP, JMS or JBI.
	 * 
	 * Quelle:
	 * http://www.mastertheboss.com/web-interfaces/328-developing-web-services
	 * -on-jboss-as-7.html
	 */
	public static void main(String args[]) throws Exception {

		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();

		factory.getInInterceptors().add(new LoggingInInterceptor());
		factory.getOutInterceptors().add(new LoggingOutInterceptor());
		factory.setServiceClass(HelloWebService.class);
		factory.setAddress("http://localhost:8080/ejb-hello-webservice/HelloWebService/HelloWebServiceBean");

		HelloWebService client = (HelloWebService) factory.create();
		System.out.println(client.echo("hello web service"));
	}

}
