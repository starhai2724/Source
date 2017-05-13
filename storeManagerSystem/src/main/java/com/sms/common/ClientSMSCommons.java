package com.sms.common;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

public class ClientSMSCommons {

	
	//Insert Zero
	public static String insertZeroIdStoreOwner(String idStoreOwner){
		
		if(null != idStoreOwner){
			for(int i = idStoreOwner.length(); i < 6 ;i ++){
				idStoreOwner = "0"+idStoreOwner;
			}
		}
		return idStoreOwner;
	}
	
	public static Object getAttribute(HttpSession ses, String name){
		Object result = ses.getAttribute(name);
		ses.removeAttribute(name);
		return result;
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
	 * 
	 * @param obj
	 * @return true = null
	 * 		   false <> null
	 */
	public static boolean isNull(Object obj){
		if(null != obj){
			return false;
		}
		return true;
	}
	
	/**
	 * 
	 * @param obj
	 * @return true = null
	 * 		   false <> null
	 */
	public static boolean isNullList(ArrayList<Object> arr){
		if(null != arr && arr.size() > 0 ){
			return false;
		}
		return true;
	}
	
	
	
	public static void main(String[] args) {
		ClientSMSCommons.insertZeroIdStoreOwner("001001");
	}
	
	
	
}
