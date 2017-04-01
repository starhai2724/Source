package com.sms.test;

import com.sms.Controller.StoreOwnerController;
import com.sms.dao.StoreOwnerDao;
import com.sms.models.StoreOwnerModel;

public class Run_Server {

	
	public static void main(String[] args) {
		
		StoreOwnerController storeOwerController = new StoreOwnerController();
		StoreOwnerModel request = new StoreOwnerModel();
//		request.setIdStoreOwner(idStoreOwner);
		request.setFullName("Nguyễn Trung Hải");
		request.setPassword("123456");
		request.setUsername("testUser");
		request.setEmail("hai@gmail.com");
		request.setTelephone("123456789");
		
//		storeOwnerController.insert("Phạm Ngọc Hiếu", "", "123456789", "testUser", "hai@gmail.com", "123456", new ModelMap(), null);
		
		
		
		
//		storeOwerController.insert(request);
		
//		storeOwerController.getStoreOwnserBy(request);
		
		
		StoreOwnerDao storeOwnerDao = new StoreOwnerDao();
		storeOwnerDao.getStoreOwnerBy(request);
		
	}
}
