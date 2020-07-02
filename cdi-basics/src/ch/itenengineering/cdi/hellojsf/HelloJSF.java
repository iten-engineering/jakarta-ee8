package ch.itenengineering.cdi.hellojsf;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class HelloJSF {

	@Inject
	GreetingService service;

	String name;
	String greeting;

	public void sayHello() {
		this.greeting = service.createGreeting(this.name);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGreeting() {
		return this.greeting;
	}

}
