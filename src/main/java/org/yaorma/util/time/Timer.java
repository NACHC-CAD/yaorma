package org.yaorma.util.time;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
	
	public String getElapsedString() {
		long totalSecs = getElapsedInMilliseconds() / 1000;
		long hours = totalSecs / 3600;
		long minutes = (totalSecs % 3600) / 60;
		long seconds = totalSecs % 60;
		String rtn = String.format("%02d:%02d:%02d", hours, minutes, seconds);
		return rtn;
	}
	
	public long getStart() {
		return this.start;
	}
	
	public long getStop() {
		return this.stop;
	}
	
	public String getStartAsString() {
		return getAsString(this.start);
	}
	
	public String getStopAsString() {
		return getAsString(this.stop);
	}
	
	public static String getAsString(long time) {
		DateFormat df = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
		String rtn = df.format(new Date(time));
		return rtn;
	}
	
}
