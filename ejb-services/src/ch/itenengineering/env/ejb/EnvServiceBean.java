package ch.itenengineering.env.ejb;

import javax.annotation.Resource;
import javax.ejb.Stateless;

@Stateless
public class EnvServiceBean implements EnvService {

	private String messageA;

	private String messageB;

	public String getMessages() {
		return "TODO";
	}

} // end
