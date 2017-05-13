package com.sms.common;

public class Calculator {
	
	/**
	 * Cong 2 so Int 
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static String plusInt(String num1, String num2){
		String result ="";
		if(null != num1 && !"".equals(num1) && null != num2 && !"".equals(num2)){
			result = String.valueOf((Integer.parseInt(num1)+Integer.parseInt(num2)));
		}
		return result;
	}
	
	
}
