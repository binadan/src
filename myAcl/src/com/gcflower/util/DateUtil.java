package com.gcflower.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	/**
	 * 字符串转Timestamp 对应日期开始
	 * @param timeStr
	 * @return
	 */
	public static Timestamp StringToDayBegin(String timeStr){
		timeStr =timeStr+" 00:00:00";
	 	return Timestamp.valueOf(timeStr);
	}
	
	/**
	 * 字符串转Imestamp 对应日期结束
	 * @param timeStr
	 * @return
	 */
	public static Timestamp StringToDayEnd(String timeStr){
		timeStr = timeStr+" 23:59:59";
	 	return Timestamp.valueOf(timeStr);
	}
	
	/**
	 * 获取当前日期 格式：yyyy-MM-dd
	 * 
	 * @return
	 */
	public static String getTodayString() {
		String temp_str = "";
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		temp_str = sdf.format(dt);
		return temp_str;
	}
	
	//1373948342302 
	//1373948354069

	public static void main(String[] args) throws InterruptedException {
		//Timestamp t=new Timestamp(new java.util.Date().getTime());
		System.out.println(new Date().getTime());
		System.out.println(new Date().getTime());
		System.out.println(new Date().getTime());
		System.out.println(new Date().getTime());
		System.out.println(new Date().getTime());
		System.out.println(new Date().getTime());
		System.out.println(new Date().getTime());
		System.out.println(new Date().getTime());
		System.out.println(new Date().getTime());
		System.out.println(new Date().getTime());
		
	
		
	}
	
}
