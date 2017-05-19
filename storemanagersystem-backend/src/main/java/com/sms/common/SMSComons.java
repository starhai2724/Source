package com.sms.common;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class SMSComons {

	public static SMSComons functionCommons = new SMSComons();

	/**
	 * Check null
	 * @param obj
	 * @return
	 */
	
	public static boolean isNull(Object obj) {
		if (null != obj) {
			return false;
		}

		return true;
	}

	/**
	 * get date
	 * 
	 * @return
	 */
	
	public static String getDate(){
		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		String year  = String.valueOf(localDate.getYear());
		String month = (localDate.getMonthValue() < 10 ? String.valueOf("0"+localDate.getMonthValue()) : String.valueOf(localDate.getMonthValue()));
		String day   = (localDate.getDayOfMonth() < 10 ? String.valueOf("0"+localDate.getDayOfMonth()) : String.valueOf(localDate.getDayOfMonth()));
		
		return String.valueOf(year+""+month+""+day);
	}
	
	
	public static String convertString(Object obj){
		if(obj != null){
			return obj.toString();
		}
		return "";
		
	}
	
	/**
	 * 
	 * @param obj
	 * @return
	 */
	public static int convertInt(String obj){
		if(!"".equals(obj)){
			return Integer.parseInt(obj);
		}
		return 0;
		
	}
	
	
}
