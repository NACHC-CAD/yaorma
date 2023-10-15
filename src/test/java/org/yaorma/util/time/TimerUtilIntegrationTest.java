package org.yaorma.util.time;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimerUtilIntegrationTest {

	@Test
	public void shouldMeasureElapsedTime() {
		Timer timer = new Timer();
		timer.start();
		TimeUtil.sleep(2);
		timer.stop();
		long start = timer.getStart();
		long stop = timer.getStop();
		double elapsed = timer.getElapsed();
		long elapsedMs = timer.getElapsedInMilliseconds();
		String elapsedStr = timer.getStartAsString();
		log.info("start:      " + start);
		log.info("stop:       " + stop);
		log.info("elapsed:    " + elapsed);
		log.info("elapsedMs:  " + elapsedMs);
		log.info("elapsedStr: " + elapsedStr);
		assertTrue((stop - start) >= 2);
		assertTrue(elapsed >= 2);
		assertTrue(elapsedMs >= 2000);
		long time = TimeUtil.getTime("2021-10-04");
		String str = Timer.getAsString(time);
		log.info("time: " + time);
		assertTrue(1633320000000L == time);
	}
	
}
