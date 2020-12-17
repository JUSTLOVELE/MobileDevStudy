package com.dateutil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	public final static String YMD = "yyyy-MM-dd";
	public final static String YMDH = "yyyy-MM-dd HH";
	public final static String YMDHM = "yyyy-MM-dd HH:mm";
	public final static String YMDHMS = "yyyy-MM-dd HH:mm:ss";
	public final static String DATETIME_YMDHMSS_S = "yyyy-MM-dd HH:mm:ss.S";
	public final static String TIMESTAMP = "yyyyMMddHHmmssSSS";
	public final static String TIMESTAMP_YMDHMS = "yyyyMMddHHmmss";
	public final static String TIMESTAMP_YMDH = "yyyyMMddhh";
	public final static String TIMESTAMP_YMD = "yyyyMMdd";
	public final static String HMS = "HH:mm:ss";
	private static SimpleDateFormat SDF = new SimpleDateFormat();
	
	/**
	 * 字符串转字符串(增加天数)
	 * @param date
	 * @param format1:转为date的模板
	 * @param format2:转为string的模板
	 * @param addDays
	 * @return
	 */
	public static String stringToStringAddDay(String date, String format1, String format2, int addDays){
		
		Date d = stringToDate(date, format1);
		if(d != null){
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(d);
			calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + 1);
			return dateToString(calendar.getTime(), format2);
		}
		return null;
	}
	
	/**
	 * 字符串时间转字符串时间
	 * @param date
	 * @param format1:转为date的模板
	 * @param format2:转为string的模板
	 * @return
	 */
	public static String stringToString(String date, String format1, String format2){
		
		Date d = stringToDate(date, format1);
		if(d != null){
			return dateToString(d, format2);
		}
		return null;
	}
	
	/**
	 * 字符串转时间(date)
	 * @param date
	 * @param format
	 * @return
	 */
	public static Date stringToDate(String date, String format){
		SDF.applyPattern(format);
		Date d = null;
		try {
			d = SDF.parse(date);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return d;
	}
	
	/**
	 * 时间转字符串
	 * @param date
	 * @param format
	 * @return
	 */
	public static String dateToString(Date date, String format){
		SDF.applyPattern(format);
		return SDF.format(date);
	}
}
