package ch.itenengineering.cdi.rates;

public class Rate {

	private String currency;
	private double rate; // rate to CHF
	private double change; // change of the day in %

	public Rate(String currency, double rate, double change) {
		super();
		this.currency = currency;
		this.rate = rate;
		this.change = change;
	}

	@Override
	public String toString() {
		return String.format("%s = %2.4f (%+2.2f%%)", currency, rate, change);
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getChange() {
		return change;
	}

	public void setChange(double change) {
		this.change = change;
	}

}
