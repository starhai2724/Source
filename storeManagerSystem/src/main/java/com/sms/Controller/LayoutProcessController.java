package com.sms.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sms.form.LayoutProcessForm;

@Controller
public class LayoutProcessController {
	public static final String CUSTOMER_SYSTEMLIST = "fashion/index";
	
	@RequestMapping(value ="/fashion/index", method = RequestMethod.GET)
	public String init(@ModelAttribute("layoutProcessForm") LayoutProcessForm form, HttpSession session){
		//set lai gia tri
		/*	*/
		return CUSTOMER_SYSTEMLIST;
	}
}
