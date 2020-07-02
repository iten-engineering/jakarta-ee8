package ch.itenengineering.timer.ejb;

import java.util.List;

import javax.ejb.Local;

@Local
public interface TimerCtrl {

	/**
	 * Start a periodic timer with the given interval in ms. Pass the name as
	 * info param of the create methode for later use.
	 */
	public void start(String name, long interval);

	/**
	 * Return a list of names from all registered timers. The names are from the
	 * timer info field, passed at creation time.
	 */
	public List<String> listNames();

	/**
	 * Stop (cancel) the timer with the given name. The name is from the timer
	 * info field, passed at creation time.
	 */
	public void stop(String name);

} // end
