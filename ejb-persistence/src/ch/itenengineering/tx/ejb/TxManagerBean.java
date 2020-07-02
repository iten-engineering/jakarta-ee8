package ch.itenengineering.tx.ejb;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ch.itenengineering.tx.domain.TxTest;

@Stateful
public class TxManagerBean implements TxManager {

	@PersistenceContext(unitName = "TestPU")
	private EntityManager em;

	public boolean isBeanAlive() {
		return true;
	}

	public void testAppException() throws Exception {
		em.persist(new TxTest("testAppException, commit expected"));
		throw new AppException();
	}


} // end of class
