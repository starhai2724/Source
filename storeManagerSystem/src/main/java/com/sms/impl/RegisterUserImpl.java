package com.sms.impl;

import org.springframework.web.client.RestTemplate;

import com.sms.common.SystemCommon;
import com.sms.common.SystemURL;
import com.sms.input.RegisterUserInputBean;
import com.sms.models.ResultObject;

public class RegisterUserImpl {

	RestTemplate restTemplate = new RestTemplate();	
	public static RegisterUserImpl intances = new RegisterUserImpl();
	
	
	public ResultObject insertRegisterUser(RegisterUserInputBean request){
			
		ResultObject result = restTemplate.postForObject(SystemURL.REGISTERUSER_INSERT, request, ResultObject.class);
		
		return result;
		
	}
	
	
}
