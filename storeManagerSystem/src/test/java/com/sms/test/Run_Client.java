package com.sms.test;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import com.sms.Controller.ClientLoginController;
import com.sms.Controller.ClientStoreOwnerController;

public class Run_Client {

	public static void main(String[] args) {
		String listId = ",AAA001,AAA002,AAA003,AAA004";
		
		if(!"".equals(listId)){
			listId = listId.substring(1);
			
			String[] parts = listId.split(",");
			listId = "";
			for(int i = 0;i<parts.length;i++){
				if(i < parts.length - 1 ){
					listId = listId + "'"+parts[i]+ "',";
				}else{
					listId = listId + "'"+parts[i]+ "'";
				}
			}
		}
		System.out.println(listId);
	}
}
