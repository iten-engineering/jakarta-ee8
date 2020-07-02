package ch.itenengineering.cdi.rates;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class Home {

	List<Rate> rates;

	String reference;

	@Inject
	private RateDAO rateDAO;

	@PostConstruct
	public void init() {
		rates = rateDAO.read();
		reference = rateDAO.getReference();
	}

	public List<Rate> getRates() {
		return rates;
	}

	public String getReference() {
		return reference;
	}

}
