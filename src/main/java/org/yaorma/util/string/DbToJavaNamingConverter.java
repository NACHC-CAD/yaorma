package org.yaorma.util.string;

import java.util.StringTokenizer;

public class DbToJavaNamingConverter {

	public static String toProper(String str) {
		Character ch = new Character(str.charAt(0));
		Character upperCh = Character.toUpperCase(ch);
		str = str.replaceFirst(ch.toString(), upperCh.toString());
		str = str.replace("-", "_");
		str = str.replace("/", "_SLASH_");
		str = str.replace(" ", "_SPACE_");
		return str;
	}

	public static String toCommon(String str) {
		Character ch = new Character(str.charAt(0));
		Character upperCh = Character.toLowerCase(ch);
		str = str.replaceFirst(ch.toString(), upperCh.toString());
		str = str.replace("-", "_");
		str = str.replace("/", "_SLASH_");
		str = str.replace(" ", "_SPACE_");
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

	public static String[] toJavaProperName(String[] dbNames) {
		String[] rtn = new String[dbNames.length];
		for(int i=0;i<dbNames.length;i++) {
			rtn[i] = toJavaProperName(dbNames[i]);
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
//		rtn = fixWhiteSpaces(rtn);
//		rtn = rtn.replaceAll("\\s{2,}", " ").trim();
		rtn = rtn.replace("-", "_");
		rtn = rtn.replace("/", "_SLASH_");
		rtn = rtn.replace(" ", "_SPACE_");
		return rtn;
	}

	private static String fixWhiteSpaces(String src) {
		if(src == null) {
			return null;
		} else {
			src = src.replaceAll("\\s{2,}", " ").trim();
			StringTokenizer toke = new StringTokenizer(src, " ");
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
	}
	
	public static String[] toJavaName(String[] dbNames) {
		String[] rtn = new String[dbNames.length];
		for(int i=0;i<dbNames.length;i++) {
			rtn[i] = toJavaName(dbNames[i]);
		}
		return rtn;
	}
	
	public static String toJavaName(String src) {
		String rtn = toJavaProperName(src);
		Character ch = new Character(rtn.charAt(0));
		Character lowerCh = Character.toLowerCase(ch);
		rtn = rtn.replaceFirst(ch.toString(), lowerCh.toString());
		rtn = rtn.replace("-", "_");
		rtn = rtn.replace("/", "_SLASH_");
		rtn = rtn.replace(" ", "_SPACE_");
		return rtn;
	}

	public static String toDatabaseName(String src) {
		src = src.replace("_SLASH_", "/");
		src = src.replace("_SPACE_", " ");
		src = src.replace("_", "-");
		String rtn = "";
		if(src.toUpperCase().equals(src)) {
			return src.toLowerCase();
		}
		Character ch = new Character(src.charAt(0));
		boolean prevIsUpper = false;
		boolean prevIsSpace = false;
		for (int i = 0; i < src.length(); i++) {
			ch = new Character(src.charAt(i));
			boolean isUpper = (Character.isUpperCase(ch) || Character.isDigit(ch));
			if (isUpper && prevIsSpace == false && prevIsUpper == false && i != 0) {
				rtn += "_";
			}
			rtn += ch;
			prevIsUpper = isUpper;
			prevIsSpace = " ".equals(ch + "");
		}
		rtn = rtn.toLowerCase();
		rtn = rtn.trim();
		return rtn;
	}

}
