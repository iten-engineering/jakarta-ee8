package ch.itenengineering.async.jsf;

import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import ch.itenengineering.async.ejb.AsyncTest;
import ch.itenengineering.async.ejb.MyAsyncTestException;

@Named
@SessionScoped
public class Async implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	AsyncTest test;

	String message = "My Message";

	String result;

	public Async() {
	}

	public void saveSync() {
		System.out.println(new Date() + ": saveSync start");

		test.saveMsgSync(this.message);
		this.result = "saveSync done";

		System.out.println(new Date() + ": saveSync end");
	}

	public void saveAsync() {
		System.out.println(new Date() + ": saveAsync start");

		test.saveMsgAsync(this.message);
		this.result = "saveAsync done";

		System.out.println(new Date() + ": saveAsync end");
	}

	public void saveAsyncFuture() {
		System.out.println(new Date() + ": saveAsyncFuture start");

		Future<String> future = test.saveMsgAsyncFuture(this.message);
		System.out.println(new Date() + ": saveAsyncFuture method call done");

		try {
			this.result = future.get();
		} catch (InterruptedException ie) {
			this.result = "saveAsyncFuture failed with InterruptedException " + ie.toString();
		} catch (ExecutionException ex) {
			this.result = "saveAsyncFuture failed with ExecutionException " + ex.toString();
		}

		System.out.println(new Date() + ": saveAsyncFuture end");
	}

	public void saveAsyncException() {
		System.out.println(new Date() + ": saveAsyncException start");

		try {
			Future<String> future = test.saveMsgAsyncException(this.message);
			System.out.println(new Date() + ": saveAsyncException method call done");

			this.result = future.get();

		} catch (MyAsyncTestException te) {
			this.result = "saveAsyncFuture failed with MyAsyncTestException " + te.toString();
		} catch (InterruptedException ie) {
			this.result = "saveAsyncFuture failed with InterruptedException " + ie.toString();
		} catch (ExecutionException ex) {
			this.result = "saveAsyncFuture failed with ExecutionException " + ex.toString();
		}

		System.out.println(new Date() + ": saveAsyncException end");
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getResult() {
		return result;
	}

} // end
