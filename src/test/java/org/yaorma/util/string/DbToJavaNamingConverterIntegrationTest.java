package org.yaorma.util.string;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DbToJavaNamingConverterIntegrationTest {

	private static final String DB01 = "database_style_string_01";
	
	private static final String DB02 = "DATABASE  STYLE STRING 02";
	
	private static final String JP01 = "DatabaseStyleString01";
	
	private static final String JP02 = "Database_SPACE__SPACE_style_SPACE_string_SPACE_02";
	
	private static final String JC01 = "databaseStyleString01";
	
	private static final String JC02 = "database_SPACE__SPACE_style_SPACE_string_SPACE_02";

	//
	// java to java conversions
	//
	

	@Test
	public void shouldGetJavaProper() {
		// java common to java proper
		log.info("--- Test 01: JC to JP");
		String str = DbToJavaNamingConverter.toProper(JC01);
		log.info("JC in:  " + JC01);
		log.info("JP out: " + str);
		assertTrue(str.equals(JP01));
	}
	
	@Test
	public void shouldGetJavaCommon() {
		// java proper to java common
		log.info("--- Test 02: JP to JC");
		String str = DbToJavaNamingConverter.toCommon(JP01);
		log.info("JP in:  " + JP01);
		log.info("JC out: " + str);
		assertTrue(str.equals(JC01));
	}
	
	//
	// database to java 
	//
	
	@Test
	public void shouldGetListOfJavaProper() {
		// database to java proper
		log.info("--- Test 03: DB to JP");
		String[] in = {DB01, DB02};
		String[] out = DbToJavaNamingConverter.toJavaProperName(in);
		log.info("DB in:  " + DB01);
		log.info("JP out: " + out[0]);
		assertTrue(JP01.equals(out[0]));
		log.info("DB in:  " + DB02);
		log.info("JP out: " + out[1]);
		assertTrue(JP02.equals(out[1]));
		log.info("Done with list test.");
	}

	@Test
	public void shouldGetJavaProperFromDbString() {
		// DB to JP
		log.info("--- Test 04: DB to JP");
		String str = DbToJavaNamingConverter.toJavaProperName(DB01);
		log.info("DB to JP");
		log.info("DB in:  " + DB01);
		log.info("JP out: " + str);
		assertTrue(JP01.equals(str));
	}

	@Test
	public void shouldGetListOfJavaCommon() {
		log.info("--- Test 05: DB to JC");
		String[] in = {DB01, DB02};
		String[] out = DbToJavaNamingConverter.toJavaName(in);
		log.info("DB in:  " + DB01);
		log.info("JC out: " + out[0]);
		log.info("DB in:  " + DB02);
		log.info("JC out: " + out[1]);
		assertTrue(JC01.equals(out[0]));
		assertTrue(JC02.equals(out[1]));
	}
	
	@Test
	public void shouldGetJavaCommonFromDbString() {
		log.info("--- Test 06: DB to JC");
		String str = DbToJavaNamingConverter.toJavaName(DB01);
		log.info("DB in:  " + DB01);
		log.info("JC out: " + str);
		assertTrue(JC01.equals(str));
	}
	
	@Test
	public void shouldGetDatabaseString() {
		log.info("--- Test 06: JP to DB");
		String str;
		// JP01
		str = DbToJavaNamingConverter.toDatabaseName(JP01);
		log.info("JP in:  " + JP01);
		log.info("DB out: " + str);
		assertTrue(DB01.equals(str));
		// JP02
		str = DbToJavaNamingConverter.toDatabaseName(JP02);
		log.info("JP in:  " + JP02);
		log.info("DB out: " + str);
		assertTrue(DB02.equalsIgnoreCase(str));
		// JC01
		str = DbToJavaNamingConverter.toDatabaseName(JC01);
		log.info("JC in:  " + JC01);
		log.info("DB out: " + str);
		assertTrue(DB01.equals(str));
		// JC02
		str = DbToJavaNamingConverter.toDatabaseName(JC02);
		log.info("JC in:  " + JC02);
		log.info("DB out: " + str);
		assertTrue(DB02.equalsIgnoreCase(str));
	}
	
	@Test
	public void shouldRemoveTrailing() {
		log.info("--- Test 07: Remove trailing");
		String str = DbToJavaNamingConverter.removeTrailing(DB01, "_01");
		log.info(str);
		assertTrue("database_style_string".equals(str));
	}

}


