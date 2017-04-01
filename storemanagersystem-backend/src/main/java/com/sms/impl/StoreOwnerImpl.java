package com.sms.impl;

import java.util.List;

import com.sms.dao.StoreOwnerDao;
import com.sms.domain.StoreOwner;
import com.sms.models.StoreOwnerModel;

public class StoreOwnerImpl {

	public static StoreOwnerImpl storeOwnerIml = new StoreOwnerImpl();

	public StoreOwner insertStoreOwner(StoreOwnerModel storeOwnerModel) {
		StoreOwnerDao storeOwnerDao = new StoreOwnerDao();
		StoreOwner storeOwner = new StoreOwner();
		String idStoreOwner = storeOwnerDao.getMaxIdStoreOwner();

		storeOwner.setIdStoreOwner(String.valueOf(Integer.parseInt(idStoreOwner) + 1));
		storeOwner.setUsername(storeOwnerModel.getUsername());
		storeOwner.setPassword(storeOwnerModel.getPassword());
		storeOwner.setRole("");
		storeOwner.setFullName(storeOwnerModel.getFullName());
		storeOwner.setAddress(storeOwnerModel.getAddress());
		storeOwner.setEmail(storeOwnerModel.getEmail());
		storeOwner.setTelephone(storeOwnerModel.getTelephone());
		storeOwner.setUserInsert(storeOwnerModel.getUserInsert());
		storeOwner.setUserUpdate(storeOwnerModel.getUserUpdate());
		storeOwner.setDeleteFlag("0");
		storeOwner.setDateInsert("");
		storeOwner.setDateUpdate("");

		return storeOwnerDao.insertStoreOwner(storeOwner);
	}

	public List getStoreOwners() {
		StoreOwnerDao storeOwnerDao = new StoreOwnerDao();

		return storeOwnerDao.getStoreOwners();
	}
	
	public List getStoreOwnerBy(StoreOwnerModel storeOwnerModel) {
		StoreOwnerDao storeOwnerDao = new StoreOwnerDao();
		
		return storeOwnerDao.getStoreOwnerBy(storeOwnerModel);
	}

}
