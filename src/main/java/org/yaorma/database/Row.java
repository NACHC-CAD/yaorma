package org.yaorma.database;

import java.util.HashMap;
import java.util.Map;

public class Row extends HashMap<String, String> implements Map<String, String> {

	public Integer getInt(String key) {
		if(key == null) {
			return null;
		}
		if(this.get(key) == null) {
			return null;
		} else {
			return Integer.parseInt(this.get(key));
		}
	}
	
}
