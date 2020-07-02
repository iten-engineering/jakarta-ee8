package ch.itenengineering.converter.jsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import ch.itenengineering.converter.domain.CurrencyType;
import ch.itenengineering.converter.ejb.CurrencyConverter;

@Named
@RequestScoped
public class Converter implements Serializable {

	private static final long serialVersionUID = 1L;

	// TODO
	CurrencyConverter remote;

	Double valueCHF = 12.5;

	List<String> result = new ArrayList<String>();

	public Converter() {
		super();
	}

	public void convert() {
		result.clear();
		for (CurrencyType currency : CurrencyType.values()) {
			if (currency != CurrencyType.CHF) {
				Double value = remote.convertCHF(valueCHF, currency);
				result.add(valueCHF + " CHF = " + value + " " + currency);
			}
		}
	}

	public Double getValueCHF() {
		return valueCHF;
	}

	public void setValueCHF(Double valueCHF) {
		this.valueCHF = valueCHF;
	}

	public List<String> getResult() {
		return result;
	}

} // end
