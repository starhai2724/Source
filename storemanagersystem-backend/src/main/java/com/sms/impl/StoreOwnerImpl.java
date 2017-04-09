package com.sms.impl;

import java.util.List;

import com.sms.common.SMSComons;
import com.sms.dao.StoreOwnerDao;
import com.sms.domain.StoreOwner;
import com.sms.inputs.StoreOwnerInputBean;
import com.sms.outputs.StoreOwnerOutputBean;

public class StoreOwnerImpl {

	public static StoreOwnerImpl storeOwnerIml = new StoreOwnerImpl();
	/**
	 * 
	 * 
	 * @param storeOwnerModel
	 * @return
	 */
	public StoreOwner insertStoreOwner(StoreOwnerInputBean storeOwnerModel) {
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
	/**
	 * 
	 * 
	 * @return
	 */
	public List<StoreOwnerOutputBean> getStoreOwners() {
		StoreOwnerDao storeOwnerDao = new StoreOwnerDao();

		return storeOwnerDao.getStoreOwners();
	}
	/**
	 * 
	 * 
	 * @param storeOwnerModel
	 * @return
	 */
	public List<StoreOwnerOutputBean> getStoreOwnerBy(StoreOwnerInputBean storeOwnerInputBean) {
		StoreOwnerDao storeOwnerDao = new StoreOwnerDao();
		
		return storeOwnerDao.getStoreOwnerBy(storeOwnerInputBean);
	}
	/**
	 * get StoreOwner by id 
	 * Mean : get data edit
	 * @param id
	 * @return
	 */
	public StoreOwnerOutputBean getStoreOwnerById(String id){
		StoreOwnerOutputBean result = StoreOwnerDao.storeOwnerDao.getStoreOwnerById(id);
		return result;
	}
	
	/**
	 * update 
	 * @param storeOwner
	 * @return
	 */
	
	public int editStoreOwner(StoreOwnerInputBean storeOwnerModel){
		
		StoreOwner storeOwner = new StoreOwner();
		
		storeOwner.setIdStoreOwner(storeOwnerModel.getIdStoreOwner());
		storeOwner.setFullName(storeOwnerModel.getFullName());
		storeOwner.setEmail(storeOwnerModel.getEmail());
		storeOwner.setTelephone(storeOwnerModel.getTelephone());
		storeOwner.setAddress(storeOwnerModel.getAddress());
		storeOwner.setUserUpdate(storeOwnerModel.getUserUpdate());
		storeOwner.setDateUpdate(storeOwnerModel.getDateUpdate());
		
		return StoreOwnerDao.storeOwnerDao.updateStoreOwnerById(storeOwner);
		
	}
	
	/**
	 * check username exist
	 * 
	 * @param username
	 * @return
	 */
	
	public String getStoreOwnerByUsername(String username){
		String result =  StoreOwnerDao.storeOwnerDao.getStoreOwnerByUsername(username);
		return result;
	}
	/**
	 * Mean delete storeOwner by id
	 * 
	 * @param idStoreOwner
	 * @return
	 */
	
	public int deteleStoreOwnerById(StoreOwnerInputBean storeOwnerInputBean){
		int result =  StoreOwnerDao.storeOwnerDao.deleleStoreOwner(storeOwnerInputBean);
		return result;
	}

}
