package ch.itenengineering.converter.ejb;

import javax.ejb.Local;

import ch.itenengineering.converter.domain.CurrencyType;

// TODO
public interface RateService {

	/**
	 * get the CHF conversion rate for the given currency type
	 * 
	 * @param type
	 *            currency type
	 * @return conversion rate CHF to currency type
	 */
	public double getRateCHF(CurrencyType type);

}
