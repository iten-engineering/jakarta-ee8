package ch.itenengineering.cdi.rates;

import java.util.List;

public interface RateDAO {

	public List<Rate> read();
	
	public String getReference();

}
