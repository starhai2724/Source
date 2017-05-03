package com.sms.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
	
	
	
	
	@RequestMapping(value ="/{path}", method = RequestMethod.GET)	
	public String home(){
		return "fashion";
	}
}
