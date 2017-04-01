package com.sms.impl;

import org.springframework.web.client.RestTemplate;

import com.sms.common.SystemURL;
import com.sms.models.ResultObject;
import com.sms.models.User;

public class ClientLoginImpl {

	public static ClientLoginImpl intances = new ClientLoginImpl();
	
	RestTemplate rest = new RestTemplate();
	String url = "http://localhost:3000/systembackend/get";
	
	public ResultObject checkLogin(User user){
		ResultObject result = rest.postForObject(SystemURL.CHECK_LOGIN, user, ResultObject.class);
		return result;
	}
	
	
	public String getData() {
		String st = "";
		st = rest.getForObject(url, String.class);
		return st;

	}
	
	public void sendData(){
		String st="Hello";
		String abc = rest.postForObject("http://localhost:3000/systembackend/getdata", st, String.class);
		
	}
	
	public String demo(){
		String st="Hello";
		String abc = rest.postForObject("http://localhost:3000/systembackend/get/data", st, String.class);
	
		return abc;
	}
	
	public User getObject(){
		User user = new User();
//		user.setId("1");
//		user.setName("Demo");
		// set headers
//	    HttpHeaders headers = new HttpHeaders();
//	     headers.setContentType(MediaType.APPLICATION_JSON);
//	    headers.set("Authorization", "Basic " + "xxxxxxxxxxxx");
//	    HttpEntity<User> entity = new HttpEntity<User>(user, headers);
//		
//	    ResponseEntity<User> response = rest
//	            .exchange("http://localhost:3000/systembackend/get/object", HttpMethod.POST, entity, User.class);
//	    System.out.println();
	    
		User u = rest.postForObject("http://localhost:3000/systembackend/get/object", user, User.class);
		return u;
	}
	

	public static void main(String[] args) {
		ClientLoginImpl loginImpl = new ClientLoginImpl();
		User user = new User();
		user.setUsername("asdasd");
		user.setPassword("asdasd");
		loginImpl.checkLogin(user);
	}

}
