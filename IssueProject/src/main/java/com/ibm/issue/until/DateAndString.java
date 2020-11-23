package com.ibm.issue.until;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAndString {
	private  static SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
	
	/**
	 * java.util.Date的日期转化
	 * @param date
	 * @return
	 */
	public static String dateToString(Date date) {
		return sm.format(date);
	}

	public static Date stringToDate(String str) throws ParseException {
		return sm.parse(str);
	}
	
	
	
	
	
	
	
	/**
	 * java.sql.Date的日期转化
	 * @param date
	 * @return
	 */
//	public static String dateToString(Date date) {
//		return sm.format(date);
//	}
//	
//	public static Date stringToDate(String str) throws ParseException {
//		return new Date(sm.parse(str).getTime());
//	}
}
