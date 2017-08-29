package com.sms.common;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class SMSComons {

	public static SMSComons functionCommons = new SMSComons();

	/**
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static double cong(String num1, String num2){
		double result = 0;
		try{
			if(num1 != null && !"".equals(num1) && num2 != null && !"".equals(num2)){
				result = Double.parseDouble(num1) + Double.parseDouble(num2);
			}
		}catch(Exception e){
			return result;
		}
		return result;
	}
	
	/**
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static double tru(String num1, String num2){
		double result = 0;
		try{
			if(num1 != null && !"".equals(num1) && num2 != null && !"".equals(num2)){
				result = Double.parseDouble(num1) - Double.parseDouble(num2);
			}
		}catch(Exception e){
			return result;
		}
		return result;
	}
	
	public static int compareDate(String ngayBD, String ngayKT){
		int result = -1;
		if(ngayBD.length() != 8 || ngayKT.length() != 8) return result;
		if(ngayBD.substring(0, 4).compareTo(ngayKT.substring(0, 4)) > 0){
			result = 1;
		}else if(ngayBD.substring(0, 4).compareTo(ngayKT.substring(0, 4)) == 0){
			if(ngayBD.substring(4, 6).compareTo(ngayKT.substring(4, 6)) > 0){
				result = 1;
			}else if(ngayBD.substring(4, 6).compareTo(ngayKT.substring(4, 6)) == 0){
				if(ngayBD.substring(6, 8).compareTo(ngayKT.substring(6, 8)) > 0){
					result = 1;
				}else if(ngayBD.substring(6, 8).compareTo(ngayKT.substring(6, 8)) == 0){
					result = 0;
				}
			}
		}
		return result;
	}
	
	/**
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static double nhan(String num1, String num2){
		double result = 0;
		try{
			if(num1 != null && !"".equals(num1) && num2 != null && !"".equals(num2)){
				result = Double.parseDouble(num1) * Double.parseDouble(num2);
			}
		}catch(Exception e){
			return result;
		}
		return result;
	}
	
	
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
	
	/**
	 * get date
	 * 
	 * @return
	 */
	//su dung khi dang ky ngay
	public static String formatDateInput(String date){
		String ngay = "";
		String thang = "";
		String nam = "";
		String result ="";
		if(date != null && date.trim().length() != 0){
			date = date.replaceAll("-", "");
			ngay = date.substring(6,date.length() );
			thang = date.substring(4,6 );
			nam = date.substring(0,4 );
			result = nam + "" + thang + "" + ngay;
		}
		return result;
	}
	
	/**
	 * get date
	 * 
	 * @return
	 */
	//su dung khi dang ky ngay
	public static String formatDateForm(String date){
		String ngay = "";
		String thang = "";
		String nam = "";
		String result ="";
		if(date != null && date.trim().length() != 0){
			ngay = date.substring(6,date.length() );
			thang = date.substring(4,6 );
			nam = date.substring(0,4 );
			result = nam + "-" + thang + "-" + ngay;
		}
		return result;
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
	
	public static String priceWithDecimal (Double price) {
	    DecimalFormat formatter = new DecimalFormat("###,###,###.00");
	    return formatter.format(price);
	}

	public static String priceWithoutDecimal (Double price) {
	    DecimalFormat formatter = new DecimalFormat("###,###,###.##");
	    return formatter.format(price);
	}

	public static String priceToString(Double price) {
	    String toShow = priceWithoutDecimal(price);
	    if (toShow.indexOf(".") > 0) {
	        return priceWithDecimal(price);
	    } else {
	        return priceWithoutDecimal(price);
	    }
	}
	/**
	 * 
	 * @param date
	 * @return
	 */
	public static String formatDate(String date){
		String ngay = "";
		String thang = "";
		String nam = "";
		String result ="";
		if(date != null && date.trim().length() != 0){
			ngay = date.substring(6,date.length() );
			thang = date.substring(4,6 );
			nam = date.substring(0,4 );
			result = ngay + "/" + thang + "/" + nam;
		}
		return result;
	}
	
	/**
	 * 
	 * @param money
	 * @return
	 */
	public static String formatMoney(String money){
		if(money != null && !"".equals(money)){
			return String.format("%,.2f",Double.parseDouble(money));
		}else{
			return "0";
		}
	}
	
}
