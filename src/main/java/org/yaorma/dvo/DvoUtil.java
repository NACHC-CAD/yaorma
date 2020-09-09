package org.yaorma.dvo;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.yaorma.util.string.DbToJavaNamingConverter;
import org.yaorma.util.time.TimeUtil;

public class DvoUtil {

	public static String getValueString(Dvo dvo, String javaName) throws Exception {
		Method method = getGetterForName(dvo, javaName);
		Object[] args = {};
		Object obj = method.invoke(dvo, args);
		return (String) obj;
	}

	public static Object getValue(Dvo dvo, String javaName) throws Exception {
		Method method = getGetterForName(dvo, javaName);
		Object[] args = {};
		Object obj = method.invoke(dvo, args);
		return obj;
	}
	
	public static Method getGetterForName(Dvo dvo, String javaName)
			throws Exception {
		String methodName = "get" + DbToJavaNamingConverter.toProper(javaName);
		Class[] sig = {};
		Method method = dvo.getClass().getMethod(methodName, sig);
		return method;
	}
	
	public static String getDateAsString(Date date) {
		return TimeUtil.getDateAsYyyyMmDd(date);
	}
	
	public static List<Object> getParamValues(Dvo dvo) {
		try {
			ArrayList<Object> params = new ArrayList<Object>();
			String[] javaNames = dvo.getJavaNames();
			for (int i = 0; i < javaNames.length; i++) {
				String javaName = javaNames[i];
				Object obj = DvoUtil.getValue(dvo, javaName);
				params.add(obj);
			}
			return params;
		} catch(Exception exp) {
			throw new RuntimeException(exp);
		}
	}
	
}
