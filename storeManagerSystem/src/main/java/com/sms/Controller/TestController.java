package com.sms.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
	
	
	
	
	@RequestMapping(value ="/test", method = RequestMethod.GET)	
	public String home(){
		return "test";
	}
	@RequestMapping(value ="/checkout", method = RequestMethod.GET)	
	public String checkout(){
		return "checkout";
	}
	@RequestMapping(value ="/dresses", method = RequestMethod.GET)	
	public String dresses(){
		return "dresses";
	}
}
