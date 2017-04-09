package com.sms.impl;

import org.springframework.web.client.RestTemplate;

import com.sms.common.ClientSMSCommons;
import com.sms.common.SystemURL;
import com.sms.form.StoreOwnerForm;
import com.sms.input.StoreOwnerInputBean;
import com.sms.models.ResultObject;

public class ClientStoreOwnerImpl {
	RestTemplate rest = new RestTemplate();
	public static ClientStoreOwnerImpl intances = new ClientStoreOwnerImpl();

	public ResultObject insert(StoreOwnerInputBean inputBean) {
		ResultObject result = rest.postForObject(SystemURL.STOREOWNER_INSERT, inputBean, ResultObject.class);
		return result;
	}

	public ResultObject get(StoreOwnerInputBean storeOwnerModel) {
		ResultObject result = rest.getForObject(SystemURL.STOREOWNER_LIST, ResultObject.class);
		return result;
	}

	public ResultObject getBy(StoreOwnerInputBean storeOwnerInputBean) {
		ResultObject result = rest.postForObject(SystemURL.STOREOWNER_LIST_BY, storeOwnerInputBean, ResultObject.class);
		return result;
	}

	public ResultObject getStoreOwnerById(String id) {
		ResultObject result = rest.postForObject(SystemURL.STOREOWNER_BY_ID, id, ResultObject.class);
		return result;
	}

	// Excuse update
	public ResultObject updateStoreOwnerById(StoreOwnerForm storeOwnerForm) {
		StoreOwnerInputBean inputBean = new StoreOwnerInputBean();
		
		inputBean.setIdStoreOwner(storeOwnerForm.getIdStoreOwner());
		inputBean.setFullName(storeOwnerForm.getFullName());
		inputBean.setTelephone(storeOwnerForm.getTelephone());
		inputBean.setAddress(storeOwnerForm.getAddress());
		inputBean.setEmail(storeOwnerForm.getEmail());
		inputBean.setDateUpdate(ClientSMSCommons.getDate());
		inputBean.setUserUpdate("Hai.NT");
		
		ResultObject result = rest.postForObject(SystemURL.UPDATE_STOREOWNER_BY_ID, inputBean, ResultObject.class);
		return result;
	}
	// Excuse delete
	public ResultObject deleteStoreownerById(String idStoreOwner) {
		StoreOwnerForm storeOwnerForm = new StoreOwnerForm();
		StoreOwnerInputBean inputBean = new StoreOwnerInputBean();
		inputBean.setIdStoreOwner(idStoreOwner);
		inputBean.setDateUpdate(ClientSMSCommons.getDate());
		inputBean.setUserUpdate("Hai.NT");
		
		ResultObject result = rest.postForObject(SystemURL.DELETE_STOREOWNER_BY_ID, inputBean, ResultObject.class);
		return result;
	}
	
	//Check username exist
	public ResultObject getStoreownerByUsername(String username){
		ResultObject response = rest.postForObject(SystemURL.GET_STOREOWNER_BY_USERNAME, username, ResultObject.class);
	return response;
	}
	

}
