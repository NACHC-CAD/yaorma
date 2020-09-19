package org.yaorma.util.time;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeUtilIntegrationTest {

	@Test
	public void shouldGetTime() {
		log.info("Starting test...");
		String time = TimeUtil.getNowAsMySqlDateTime();
		log.info("Got time: " + time);
		log.info("Done.");
	}
	
}
