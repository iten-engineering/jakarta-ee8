package ch.itenengineering.tx.ejb;

import javax.ejb.Remote;

@Remote
public interface TxManager {

	public boolean isBeanAlive();

	public void testAppException() throws Exception;
}
