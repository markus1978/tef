package fri.util;

/**
	Stopwatch, for testing purposes. Provides suspend and resume methods.
*/

public class TimeStopper
{
	private long time1 = 0L, time2 = 0L;
	private long timeSum = 0L;
	private long lastIntervalStop = 0L;


	/** Catch current time. Timer is running. This is a call to resume(). */
	public TimeStopper()	{
		this(true);
	}

	/** If doStart is false, start() or resume() must be called explicitly. */
	public TimeStopper(boolean doStart)	{
		if (doStart)
			resume();
	}

	/** Returns true if the timer is running, else it has been stopped or suspended. */
	public boolean isRunning()	{
		return time1 > 0L;
	}
	
	/**
		Interrupt timer. Time gets saved. This method works if the timer
		was started or resumed before, else it does nothing.
	*/
	public void suspend()	{
		if (isRunning())	{
			time2 = System.currentTimeMillis();
			timeSum += time2 - time1;
			time1 = time2 = 0L;
		}
	}
	
	/**
		Start again after interruption. Pause time will not be added.
		This method works if the timer was suspended before, else it does nothing.
	*/
	public void resume()	{
		if (isRunning() == false)
			lastIntervalStop = time1 = time2 = System.currentTimeMillis();
	}
	
	/** Stop the timer and return current time sum. */
	public String stop()	{
		return getTime(true);
	}

	/** Start the timer after a stop(). The sum of time is forgotten. */
	public void start()	{
		resume();
		timeSum = 0L;
	}
	
	/**
		Returns current time representation "HH:MM:SS".
		The timer will be stopped for calculation of time and then be resumed.
	*/
	public String getTime()	{
		return getTime(false);
	}
	
	private String getTime(boolean doStop)	{
		suspend();
		long elapsed = timeSum / 1000L;
		long sec = elapsed % 60L;
		long min = elapsed / 60L;
		if (min > 60L)
			min = min % 60L;
		long hours = elapsed / 3600L;
		if (doStop == false)
			resume();
		return hours+":"+min+":"+sec;
	}
	
	/**
		Returns current time representation in millisconds.
		The timer will be stopped for calculation and then be resumed.
	*/
	public String getTimeMillis()	{
		suspend();
		resume();
		return new Long(timeSum).toString();
	}
	
	/**
		Stop the timer and return current time sum.
	*/
	public String stopMillis()	{
		suspend();
		return new Long(timeSum).toString();
	}
	
	/**
		Returns the time interval since start or the last getInterval() call.
	*/
	public String getInterval()	{
		long time = System.currentTimeMillis();
		long interval = time - lastIntervalStop;
		lastIntervalStop = time;
		return new Long(interval).toString();
	}
	
	
	
	// test main
	
	public static final void main(String [] args)	{
		TimeStopper timer = new TimeStopper();
		try	{ Thread.sleep(2000); } catch (Exception e)	{}
		System.err.println(timer.stop());
	}

}