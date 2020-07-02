package ch.itenengineering.async.ejb;

import java.util.Date;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;

@Stateless
public class AsyncTestBean implements AsyncTest {

	@Override
	public void saveMsgSync(String msg) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ex) {
			Logger.getLogger(AsyncTestBean.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		System.out.println(new Date() + ": AsyncTestBean.saveMsgSync " + msg);
	}

	@Override
	public void saveMsgAsync(String msg) {
		// TODO async - implement
	}

	@Override
	public Future<String> saveMsgAsyncFuture(String msg) {
		// TODO async - implement
		return null;
	}

	@Override
	public Future<String> saveMsgAsyncException(String msg)
			throws MyAsyncTestException {
		// TODO async - implement
		return null;
	}

} // end
