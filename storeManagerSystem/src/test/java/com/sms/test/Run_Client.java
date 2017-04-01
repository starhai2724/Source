package com.sms.test;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import com.sms.Controller.ClientStoreOwnerController;

public class Run_Client {

	public static void main(String[] args) {
		
	
	ClientStoreOwnerController storeOwnerController = new ClientStoreOwnerController();
//		storeOwnerController.insert("Phạm Ngọc Hiếu", "", "123456789", "testUser", "hai@gmail.com", "123456", new ModelMap(), null);
		storeOwnerController.getBy("", "testuser", "", "", new ModelMap(), null, new ModelAndView());
	
	}
}
