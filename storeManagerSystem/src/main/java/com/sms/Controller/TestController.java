package com.sms.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sms.common.SystemCommon;

@Controller
public class TestController {

	@RequestMapping(value ="/test", method = RequestMethod.GET)	
	public String home(){
		return "test";
	}
}
