package org.yaorma.util.string;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DbToJavaNamingConverterIntegrationTest {

	private static final String DB01 = "database_style_string_01";
	
	private static final String DB02 = "DATABASE     	STYLE STRING 02";
	
	private static final String DB02_CHECK = "database_style_string_02";
	
	private static final String JP01 = "DatabaseStyleString01";
	
	private static final String JP02 = "DatabaseStyleString02";
	
	private static final String JC01 = "databaseStyleString01";
	
	private static final String JC02 = "databaseStyleString02";
	
	@Test
	public void shouldGetJavaProper() {
		String str = DbToJavaNamingConverter.toProper(JC01);
		log.info(str);
		assertTrue(str.equals(JP01));
	}
	
	@Test
	public void shouldGetJavaCommon() {
		String str = DbToJavaNamingConverter.toCommon(JP01);
		log.info(str);
		assertTrue(str.equals(JC01));
	}
	
	@Test
	public void shouldRemoveTrailing() {
		String str = DbToJavaNamingConverter.removeTrailing(DB01, "_01");
		log.info(str);
		assertTrue("database_style_string".equals(str));
	}
	
	@Test
	public void shouldGetListOfJavaProper() {
		String[] in = {DB01, DB02};
		String[] out = DbToJavaNamingConverter.toJavaProperName(in);
		log.info(out[0]);
		log.info(out[1]);
		assertTrue(JP01.equals(out[0]));
		assertTrue(JP02.equals(out[1]));
	}
	
	@Test
	public void shouldGetJavaProperFromDbString() {
		String str = DbToJavaNamingConverter.toJavaProperName(DB01);
		log.info(str);
		assertTrue(JP01.equals(str));
	}
	
	@Test
	public void shouldGetListOfJavaCommon() {
		String[] in = {DB01, DB02};
		String[] out = DbToJavaNamingConverter.toJavaName(in);
		log.info("Common names:");
		log.info(out[0]);
		log.info(out[1]);
		assertTrue(JC01.equals(out[0]));
		assertTrue(JC02.equals(out[1]));
	}
	
	@Test
	public void shouldGetJavaCommonFromDbString() {
		String str = DbToJavaNamingConverter.toJavaName(DB01);
		log.info(str);
		assertTrue(JC01.equals(str));
	}
	
	@Test
	public void shouldGetDatabaseString() {
		String str;
		str = DbToJavaNamingConverter.toDatabaseName(JP01);
		log.info(str);
		assertTrue(DB01.equals(str));
		str = DbToJavaNamingConverter.toDatabaseName(JP02);
		log.info(str);
		assertTrue(DB02_CHECK.equals(str));
		str = DbToJavaNamingConverter.toDatabaseName(JC01);
		log.info(str);
		assertTrue(DB01.equals(str));
		str = DbToJavaNamingConverter.toDatabaseName(JC02);
		log.info(str);
		assertTrue(DB02_CHECK.equals(str));
	}
	
}


