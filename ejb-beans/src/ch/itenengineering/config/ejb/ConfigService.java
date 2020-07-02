package ch.itenengineering.config.ejb;

import java.util.List;
import javax.ejb.Local;

@Local
public interface ConfigService {

	public String getConfig(String key);

	public void setConfig(String key, String value);

	public List<String> listConfig();
}
