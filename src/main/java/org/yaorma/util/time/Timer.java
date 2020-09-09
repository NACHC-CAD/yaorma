package org.yaorma.util.time;

import java.util.Calendar;
import java.util.Date;

public class Timer {

	private long start;
	
	private long stop;
	
	public void start() {
		this.start = Calendar.getInstance().getTimeInMillis();
	}
	
	public void stop() {
		this.stop = Calendar.getInstance().getTimeInMillis();
	}
	
	public long getElapsedInMilliseconds() {
		return stop - start;
	}
	
	public double getElapsed() {
		double elapsed = ((double)getElapsedInMilliseconds()) / 1000L;
		return elapsed;
	}
	
	public long getStart() {
		return this.start;
	}
	
	public long getStop() {
		return this.stop;
	}
	
}
