package com.bookstore.data.tools;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormat {

	/**
	 * change date type from Date to String
	 * 
	 * @param date
	 * @param format
	 *            yyyy-MM-dd
	 */
	public static String dateChange(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		format = sdf.format(date);
		return format;
	}
	
	
	public static Date dateChange(String date) {
		Calendar instance = Calendar.getInstance();
		instance.set(1990, 12, 0);
		return instance.getTime();
	}

	/**
	 * calculate date the result is now add some days
	 * 
	 * @param days
	 * @return Date
	 */
	public static Date addDays(int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, days);
		return calendar.getTime();
	}

	/**
	 * calculate date the result is now add some seconds
	 * 
	 * @param seconds
	 * @return
	 */
	public static Date addSeconds(int seconds) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.SECOND, seconds);
		return calendar.getTime();
	}

}
