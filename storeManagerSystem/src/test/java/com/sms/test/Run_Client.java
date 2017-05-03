package com.sms.test;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import com.sms.Controller.ClientLoginController;
import com.sms.Controller.ClientStoreOwnerController;

public class Run_Client {

	public static void main(String[] args) {
		
	
	ClientStoreOwnerController storeOwnerController = new ClientStoreOwnerController();
//		storeOwnerController.insert("Phạm Ngọc Hiếu", "", "123456789", "testUser", "hai@gmail.com", "123456", new ModelMap(), null);
//		storeOwnerController.getBy("", "root", "", "", new ModelMap(), null, new ModelAndView());
//		storeOwnerController.edit("001001", new ModelMap(), null);
	ClientLoginController clientLoginController = new ClientLoginController();
	clientLoginController.checkLogin("root", "123", new ModelMap(), null);
	}
}
