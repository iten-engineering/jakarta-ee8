package ch.itenengineering.mex.ejb;

import javax.ejb.Remote;

@Remote
public interface MoneyExchange {

	public double getRate(CurrencyType currency);
	
	public int getVIPBonus();

}
