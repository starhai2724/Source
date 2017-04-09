package com.sms.dao;

import com.sms.inputs.StoreOwnerInputBean;

public class RUN_DAO {

	
	public static void main(String[] args) {
	
		StoreOwnerInputBean  input = new StoreOwnerInputBean();
		input.setUsername("root");
		StoreOwnerDao.storeOwnerDao.getStoreOwnerBy(input);
		
	}
	
}
