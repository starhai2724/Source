package com.sms.common;

public class StringUtils {

	
	/**
	 * check null an blank
	 * 
	 */
	public static boolean isEmpty(String st){
		if(st != null && st.trim().length()> 0){
			return false;
		}
		return true;
	}
	
	
	/**
	 * check null an blank
	 * 
	 */
	public static boolean isNotEmpty(String st){
		if(st != null && st.trim().length()> 0){
			return true;
		}
		return false;
	}
	
	
}
