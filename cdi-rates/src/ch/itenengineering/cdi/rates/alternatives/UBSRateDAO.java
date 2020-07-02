package ch.itenengineering.cdi.rates.alternatives;

import java.util.ArrayList;
import java.util.List;

import ch.itenengineering.cdi.rates.Rate;
import ch.itenengineering.cdi.rates.RateDAO;


public class UBSRateDAO implements RateDAO {

	@Override
	public List<Rate> read() {
		List<Rate> rates = new ArrayList<Rate>();
		
		rates.add(new Rate("USD", 0.9148, -0.66));
		rates.add(new Rate("EUR", 1.2018, +0.02));
		rates.add(new Rate("JPY", 0.0113, +1.17));
		rates.add(new Rate("GBP", 1.4732, 0));
		rates.add(new Rate("CAD", 0.9178, -1.25));
		rates.add(new Rate("AUD", 0.9411, +1.55));
		rates.add(new Rate("HKD", 0.1179, +5.02));
		
		return rates;
	}

	@Override
	public String getReference() {
		return "UBS";
	}

}
