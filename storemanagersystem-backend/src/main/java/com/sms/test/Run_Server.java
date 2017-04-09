package com.sms.test;

import com.sms.Controller.StoreOwnerController;

public class Run_Server {

	
	public static void main(String[] args) {
	
		StoreOwnerController storeOwnerController = new StoreOwnerController();
		storeOwnerController.getStoreOwnerByUsername("abc");
	}
}
