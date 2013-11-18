package com.lan.utils;

import java.io.IOException;
import java.util.Properties;

import com.gargoylesoftware.htmlunit.html.Util;

public class JavaUtils {

	public static String getValfromTestDataBundle(String key) {
		Properties p = new Properties();
		try {
			p.load(Util.class.getResourceAsStream("/testdata.properties"));
		} catch (IOException e) {
			System.err.println("Error in laoding the test data bundle: "
					+ e.getMessage());
			e.printStackTrace();
		}
		return p.getProperty(key);
	}
}
