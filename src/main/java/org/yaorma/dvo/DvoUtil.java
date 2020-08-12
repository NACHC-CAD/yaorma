package org.yaorma.dvo;

import java.lang.reflect.Method;

import org.yaorma.util.string.DbToJavaNamingConverter;

public class DvoUtil {

	public static String getValue(Dvo dvo, String javaName) throws Exception {
		Method method = getGetterForName(dvo, javaName);
		Object[] args = {};
		Object obj = method.invoke(dvo, args);
		return (String) obj;
	}

	public static Method getGetterForName(Dvo dvo, String javaName)
			throws Exception {
		String methodName = "get" + DbToJavaNamingConverter.toProper(javaName);
		Class[] sig = {};
		Method method = dvo.getClass().getMethod(methodName, sig);
		return method;
	}
	
}
