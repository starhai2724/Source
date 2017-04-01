package com.sms.impl;

import org.springframework.web.client.RestTemplate;

import com.sms.common.SystemURL;
import com.sms.models.ResultObject;
import com.sms.models.StoreOwnerModel;

public class ClientStoreOwnerImpl {
	RestTemplate rest = new RestTemplate();
	public static ClientStoreOwnerImpl intances = new ClientStoreOwnerImpl();

	public ResultObject insert(StoreOwnerModel storeOwnerModel) {
		ResultObject result = rest.postForObject(SystemURL.STOREOWNER_INSERT, storeOwnerModel, ResultObject.class);
		return result;
	}
	public ResultObject get(StoreOwnerModel storeOwnerModel) {
		ResultObject result = rest.getForObject(SystemURL.STOREOWNER_LIST, ResultObject.class);
		return result;
	}
	
	public ResultObject getBy(StoreOwnerModel storeOwnerModel) {
		ResultObject result = rest.postForObject(SystemURL.STOREOWNER_LIST_BY, storeOwnerModel, ResultObject.class);
		return result;
	}

}
