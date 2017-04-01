package com.sms.impl;

import com.sms.dao.StoreOwnerDao;
import com.sms.models.User;

public class LoginImpl {
	
	public static LoginImpl loginImpl = new LoginImpl();
	
	public User checkLoginIml(User user) {
		if(null != user){
			return StoreOwnerDao.storeOwnerDao.getUser(user);
		}
		return null;
	}
}
