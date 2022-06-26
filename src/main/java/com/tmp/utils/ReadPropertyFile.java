package com.tmp.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Properties;

import com.tmb.constants.FrameworkConstants;

public final class ReadPropertyFile {

	private ReadPropertyFile() {

	}

	// part 9 >> eager initialization
	private static Properties property = new Properties();
	private static final Map<String, String> CONFIGMAP = new HashMap<String, String>(); // Hashmap

	static {
		try {
			FileInputStream file = new FileInputStream(FrameworkConstants.getConfigfilepath());
			property.load(file);

			// using hashMap
			// for (Object key : property.keySet()) {
			// CONFIGMAP.put(String.valueOf(key), String.valueOf(property.keySet()));
			// }
			// =========OR=========================

			for (Entry<Object, Object> entry : property.entrySet()) {
				CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
			}

			// =========OR=====lAMDA====================

			// property.entrySet().forEach(entry ->
			// CONFIGMAP.put(String.valueOf(entry.getKey()),
			// String.valueOf(entry.getValue())));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// Hasmap -- if multiple iterations are used
	public static String get(String key) throws Exception {
		if (Objects.isNull(key) || (Objects.isNull(CONFIGMAP.get(key)))) {
			throw new Exception("Property Name " + key + " is not found. Please check config.properties");
		}
		return CONFIGMAP.get(key);

	}

	// Hashtable - little slow, thread safe
	// converting a property to hashmap needs some time

	// public static String getValue(String key) throws Exception {
	// // String value=""; direct passing
	// // value = property.getProperty(key); direct passing
	//
	// // null check
	// if(Objects.isNull(property.getProperty(key)) || (Objects.isNull(key))) {
	// throw new Exception("Property Name " + key + " is not found. Please check
	// config.properties");
	// }
	// return property.getProperty(key);
	//
	// }

	// lazy initialization
	/*
	 * public static String getValue(String key) throws Exception { String value="";
	 * Properties property = new Properties(); FileInputStream file = new
	 * FileInputStream(System.getProperty("user.dir") +
	 * "\\src\\test\\resources\\config\\config.properties"); property.load(file);
	 * value = property.getProperty(key); if(Objects.isNull(value)) { throw new
	 * Exception("Property Name " + key +
	 * " is not found. Please check config.properties"); } return value;
	 */

}
