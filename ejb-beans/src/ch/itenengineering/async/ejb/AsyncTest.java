package ch.itenengineering.async.ejb;

import java.util.concurrent.Future;

import javax.ejb.Local;

@Local
public interface AsyncTest {

	public void saveMsgSync(String msg);

	public void saveMsgAsync(String msg);

	public Future<String> saveMsgAsyncFuture(String msg);

	public Future<String> saveMsgAsyncException(String msg)
			throws MyAsyncTestException;

} // end
