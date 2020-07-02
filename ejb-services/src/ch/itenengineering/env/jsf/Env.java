package ch.itenengineering.env.jsf;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import ch.itenengineering.env.ejb.EnvService;

@Named
@RequestScoped
public class Env implements Serializable {

	@EJB
	EnvService env;

	public Env() {
	}

	public String getMessages() {
		return env.getMessages();
	}

} // end
