package ch.itenengineering.converter.ejb;

import javax.ejb.Remote;

import ch.itenengineering.converter.domain.CurrencyType;

// TODO
public interface CurrencyConverter {

	/**
	 * convert the given CHF value to the desired currency
	 * 
	 * @param type
	 *            currency type
	 * @param value
	 *            CHF to convert
	 * @return converted value
	 */
	public Double convertCHF(Double value, CurrencyType type);

}
