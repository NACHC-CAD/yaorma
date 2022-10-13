package org.yaorma;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.yaorma.util.time.Timer;

import com.googlecode.junittoolbox.SuiteClasses;
import com.googlecode.junittoolbox.WildcardPatternSuite;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(WildcardPatternSuite.class)

@SuiteClasses({ "**/*GenerationTest.class" })

public class RunAllGenerationTests {

	private static Timer TIMER = new Timer();

	@BeforeClass
	public static void setup() {
		log.info("Starting setup...");
		log.info("Done with setup.");
	}

	@AfterClass
	public static void cleanup() {
		log.info("Starting cleanup...");
		log.info("Done with cleanup.");
	}

	public static void exec() {
		JUnitCore junit = new JUnitCore();
		Result result = junit.run(RunAllGenerationTests.class);
		System.out.println("Finished. Result: Failures: " +
				result.getFailureCount() + ". Ignored: " +
				result.getIgnoreCount() + ". Tests run: " +
				result.getRunCount() + ". Time: " +
				result.getRunTime() + "ms.");
	}

}
