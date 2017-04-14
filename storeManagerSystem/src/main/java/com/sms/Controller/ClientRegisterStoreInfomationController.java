package com.sms.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sms.form.RegisterStoreInfomationForm;

@Controller
public class ClientRegisterStoreInfomationController {
	
	public static final String REGISTER_STORE_INFOMATION = "registerStoreInfomation";
	
	/**
	 * Mean: init
	 * @param form
	 * @return
	 */
	@RequestMapping(value="/RegisterStoreInfomation/init", method=RequestMethod.GET)
	public String init(@ModelAttribute("registerStoreInfomation") RegisterStoreInfomationForm form){
		
		return REGISTER_STORE_INFOMATION;
	}
	
	
	/**
	 * Mean: insert
	 * @param form
	 * @return
	 */
	@RequestMapping(value="/RegisterStoreInfomation/insert", method=RequestMethod.POST)
	public String insert(@ModelAttribute("registerStoreInfomation") RegisterStoreInfomationForm form){
		
		
		
		return REGISTER_STORE_INFOMATION;
	}
	
	
	
}
