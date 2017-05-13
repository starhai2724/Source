package com.sms.impl;

import org.jboss.jandex.Main;

import com.sms.common.Calculator;
import com.sms.common.SMSComons;
import com.sms.dao.RegisterUserDAO;
import com.sms.domain.Store;
import com.sms.domain.StoreInformation;
import com.sms.domain.StoreOwner;
import com.sms.inputs.RegisterUserInputBean;

public class RegisterUserImpl {

	public static RegisterUserImpl registerUserImpl = new RegisterUserImpl();
	
	
	// insert
	public int insertRegisterUser(RegisterUserInputBean input){
		int result = 0;
		// bean storeOwner
		StoreOwner storeOwner = new StoreOwner();
		//get date
		String date = SMSComons.getDate();
		
		String idStoreOwner = RegisterUserDAO.intances.getMaxIdStoreOwner();

		storeOwner.setIdStoreOwner(Calculator.plusInt(idStoreOwner, "1"));
		storeOwner.setUsername(input.getUsername());
		storeOwner.setPassword(input.getPassword());
		storeOwner.setRole(input.getRole());
		storeOwner.setFullName(input.getFullName());
		storeOwner.setAddress(input.getAddressStoreOwner());
		storeOwner.setEmail(input.getEmailStoreOwner());
		storeOwner.setTelephone(input.getTelephoneStoreOwner());
		storeOwner.setDeleteFlag("0");
		storeOwner.setDateInsert(date);
		storeOwner.setDateUpdate(date);
		
		// bean Store
		String idStore = RegisterUserDAO.intances.getMaxIdStore();
		Store store = new Store();
		store.setIdStore(Calculator.plusInt(idStore, "1"));
		store.setIdStoreOwner(storeOwner.getIdStoreOwner());
		store.setDeleteFlag("0");
		store.setDateInsert(date);
		store.setDateUpdate(date);
		//bean Store infomation
		
		StoreInformation storeInformation = new StoreInformation();
		storeInformation.setIdStore(store.getIdStore());
		storeInformation.setCategory(input.getCategoryStore());
		storeInformation.setStoreName(input.getStoreName());
		storeInformation.setTelephone(input.getTelephoneStore());
		storeInformation.setAddress(input.getAddressStore());
		storeInformation.setPathJSP(input.getDomain());
		storeInformation.setEmail(input.getEmailStore());
		
		result = RegisterUserDAO.intances.insertRegisterUser(store, storeOwner, storeInformation);
		
		return result;
	}
	//------------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		RegisterUserInputBean input = new RegisterUserInputBean();
		input.setFullName("Nguyen Van B");
		input.setStoreName("Cua hang thoi trang");
		RegisterUserImpl.registerUserImpl.insertRegisterUser(input);
		
		
	}
	
}
