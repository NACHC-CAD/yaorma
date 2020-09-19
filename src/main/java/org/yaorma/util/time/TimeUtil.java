package org.yaorma.util.time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtil {

	//
	// get now functionality
	//
	
	public static Date now() {
		return getNow();
	}
	
	public static Date getNow() {
		return Calendar.getInstance().getTime();
	}
	
	public static String getNowAsMySqlDateTime() {
		Date date = getNow();
		String formatString = "yyyy-MM-dd HH:mm:ss";
		return format(date, formatString);
	}

	//
	// get part of date
	//
	
	public static int getCurrentYear() {
		return Calendar.getInstance().get(Calendar.YEAR);
	}
	
	public static String getCurrentYearAsString() {
		return Calendar.getInstance().get(Calendar.YEAR) + "";
	}

	//
	// get date from a string
	//
	
	public static Date getDateForYyyy_Mm_Dd(String str) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
			Date rtn = format.parse(str);
			return rtn;
		} catch(Exception exp) {
			throw new RuntimeException(exp);
		}
	}

	public static String getDateAsYyyyMmDdFromYyyy_Mm_Dd(String str) {
		Date date = getDateForYyyy_Mm_Dd(str);
		String rtn = getDateAsYyyyMmDd(date);
		return rtn;
	}

	//
	// get date as a formatted string
	//
	
	public static String format(Date date, String formatString) {
		SimpleDateFormat format = new SimpleDateFormat(formatString);
		String rtn = format.format(date);
		return rtn;
	}
	
	public static String getDateAsYyyyMmDd(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String rtn = format.format(date);
		return rtn;
	}

	//
	// get time as a string from a time stamp long
	//
	
	public static Date getTime(long timeStamp) {
		Date date = new Date(timeStamp);
		return date;
	}
	
	public static String getTimeString(long timeStamp) {
		Date date = new Date(timeStamp);
		SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd 'at' HH:mm:ss z");
		String rtn = format.format(date);
		return rtn;
	}
	
}
