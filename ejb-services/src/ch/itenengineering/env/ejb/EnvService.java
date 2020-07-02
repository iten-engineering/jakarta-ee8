package ch.itenengineering.env.ejb;

import javax.ejb.Local;

@Local
public interface EnvService {

	public String getMessages();

} // end
