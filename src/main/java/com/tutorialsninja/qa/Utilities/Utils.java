package com.tutorialsninja.qa.Utilities;

import java.util.Date;

public class Utils {
	
	
	public static String emailWithDateTimeStamp() {
		Date date = new Date();
		String emailTimeStamp = date.toString().replace(" ", "_").replace(":", "_");
		return "seleniumpanda" + emailTimeStamp + "@gmail.com";	
	}
	
	public static final int IMPLICIT_WAIT = 10;
	public static final int PAGELOAD_TIMEOUT = 100;
	public static final int SCRIPT_TIMEOUT = 2000;
}
