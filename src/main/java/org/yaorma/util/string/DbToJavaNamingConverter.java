package org.yaorma.util.string;

import java.util.StringTokenizer;

public class DbToJavaNamingConverter {

	public static String toProper(String str) {
		Character ch = new Character(str.charAt(0));
		Character upperCh = Character.toUpperCase(ch);
		str = str.replaceFirst(ch.toString(), upperCh.toString());
		return str;
	}

	public static String toCommon(String str) {
		Character ch = new Character(str.charAt(0));
		Character upperCh = Character.toLowerCase(ch);
		str = str.replaceFirst(ch.toString(), upperCh.toString());
		return str;
	}

	public static String removeTrailing(String str, String tail) {
		String rtn = str;
		if (str != null && tail != null && str.endsWith(tail)) {
			int end = str.lastIndexOf(tail);
			rtn = str.substring(0, end);
		}
		return rtn;
	}

	public static String toJavaProperName(String src) {
		src = src.toLowerCase();
		StringTokenizer toke = new StringTokenizer(src, "_");
		String rtn = "";
		while (toke.hasMoreTokens()) {
			String str = toke.nextToken();
			Character ch = new Character(str.charAt(0));
			Character upperCh = Character.toUpperCase(ch);
			str = str.replaceFirst(ch.toString(), upperCh.toString());
			rtn += str;
		}
		return rtn;
	}

	public static String toJavaName(String src) {
		String rtn = toJavaProperName(src);
		Character ch = new Character(rtn.charAt(0));
		Character lowerCh = Character.toLowerCase(ch);
		rtn = rtn.replaceFirst(ch.toString(), lowerCh.toString());
		return rtn;
	}

	public static String toDatabaseName(String src) {
		String rtn = "";
		for (int i = 0; i < src.length(); i++) {
			Character ch = new Character(src.charAt(i));
			if (Character.isUpperCase(ch) && i != 0) {
				rtn += "_";
			}
			rtn += ch;
		}
		rtn = rtn.toLowerCase();
		rtn = rtn.trim();
		return rtn;
	}

}
