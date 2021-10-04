package org.yaorma.util.time;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

/***
 * 
 * Integration tests for TimeUtil: Most of these tests are just smoke tests
 * intended to check that the method executes with out error and to demonstrate
 * the functionality of the method
 *
 */
@Slf4j
public class TimeUtilIntegrationTest {

	@Test
	public void shouldGetNow() {
		Date now = TimeUtil.getNow();
		log.info("Now: " + now);
	}
	
	@Test 
	public void shouldReturnNow() {
		Date now = TimeUtil.now();
		log.info("Now: " + now);
	}
	
	@Test
	public void shouldGetNowAsMySqlDateTimeFormat() {
		String now = TimeUtil.getNowAsMySqlDateTime();
		log.info("Now in MySql format: " + now);
	}
	
	@Test
	public void shouldGetCurrentYear() {
		int year = TimeUtil.getCurrentYear();
		log.info("Current year: " + year);
	}
	
	
	@Test
	public void shouldGetCurrentYearAsString() {
		String year = TimeUtil.getCurrentYearAsString();
		log.info("Current year as string: " + year);
	}
	
	@Test
	public void shouldGetDateAsYyyMmDd( ) {
		String in = "2021-10-04";
		String out = TimeUtil.getDateAsYyyyMmDdFromYyyy_Mm_Dd(in);
		log.info("Date: " + out);
		assertTrue("20211004".equals(out));
	}
	
	@Test
	public void shouldGetFormattedDate() {
		Date date = TimeUtil.getDateForYyyy_Mm_Dd("2021-10-04");
		String str = TimeUtil.format(date, "yyyy/MM/dd");
		log.info("Got formatted date: " + str);
		assertTrue("2021/10/04".equals(str));
	}
	
	@Test
	public void shouldGetFormattedDateAsYyyMmDd() {
		Date date = TimeUtil.getDateForYyyy_Mm_Dd("2021-10-04");
		String str = TimeUtil.getDateAsYyyyMmDd(date);
		log.info(str);
		assertTrue("20211004".equals(str));
	}
	
	@Test
	public void shouldGetDateWithGivenSeparator() {
		Date date = TimeUtil.getDateForYyyy_Mm_Dd("2021-10-04");
		String str = TimeUtil.getDateAsYyyyMmDd(date, '*');
		log.info(str);
		assertTrue("2021*10*04".equals(str));
	}
	
	@Test
	public void shouldGetTime() {
		String time = TimeUtil.getNowAsMySqlDateTime();
		log.info("Got time: " + time);
	}

	@Test
	public void shouldGetTimeAsLong() {
		Date date = TimeUtil.getDateForYyyy_Mm_Dd("2021-10-04");
		long out = TimeUtil.getTime(date);
		log.info("Date as long: " + out);
		assertTrue(1633320000000L == out);
	}

	@Test
	public void shouldGetTimeStringFromLong() {
		String str = TimeUtil.getTimeString(1633320000000L);
		log.info("Timestamp String" + str);
		assertTrue("2021.10.04 at 00:00:00 EDT".equals(str));
	}
	
}
