package ch.itenengineering.cdi.rates;


public interface ThresholdReporter {

	public static final double MIN_THRESHOLD = -0.5;
	
	public static final double MAX_THRESHOLD = 1.0;

	void check(Rate rate);
	
}
