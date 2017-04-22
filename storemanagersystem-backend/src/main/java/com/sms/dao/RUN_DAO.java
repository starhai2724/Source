package com.sms.dao;

import com.sms.inputs.StoreOwnerInputBean;
import com.sms.models.User;

public class RUN_DAO {

	
	public static void main(String[] args) {
	
//		StoreOwnerInputBean  input = new StoreOwnerInputBean();
//		input.setUsername("root");
//		StoreOwnerDao.storeOwnerDao.getStoreOwnerBy(input);
		User u = new User();
		u.setUsername("user");
		u.setPassword("123");
		
		StoreOwnerDao.storeOwnerDao.getUser(u);
		
		
	}
	
}
