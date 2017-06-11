package com.sms.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
	
	
//	@RequestMapping(value ="/{path}", method = RequestMethod.GET)	
//	public String home(){
//		return "fashion";
//	}
	
	@RequestMapping(value ="/index", method = RequestMethod.GET)	
	public String home1(){
		return "fashion/index";
	}
	@RequestMapping(value ="/checkout", method = RequestMethod.GET)	
	public String checkout(){
		return "template1/checkout";
	}
	@RequestMapping(value ="/dresses", method = RequestMethod.GET)	
	public String dresses(){
		return "template1/dresses";
	}
	@RequestMapping(value ="/index2", method = RequestMethod.GET)	
	public String home2(){
		return "template2/index2";
	}
	@RequestMapping(value ="/checkout2", method = RequestMethod.GET)	
	public String checkout2(){
		return "template2/checkout2";
	}
	@RequestMapping(value ="/testLayout", method = RequestMethod.GET)	
	public String testLayout(){
		return "product";
	}
	@RequestMapping(value ="/dotKhuyenMai", method = RequestMethod.GET)	
	public String dotKhuyenMai(){
		return "dotKhuyenMai";
	}
	@RequestMapping(value ="/hoaDon", method = RequestMethod.GET)	
	public String hoaDon(){
		return "hoaDon";
	}
	@RequestMapping(value ="/chiTietHoaDon", method = RequestMethod.GET)	
	public String chiTietHoaDon(){
		return "chiTietHoaDon";
	}
	@RequestMapping(value ="/dangky1", method = RequestMethod.GET)	
	public String dangky1(){
		return "dangky1";
	}
	@RequestMapping(value ="/dangky2", method = RequestMethod.GET)	
	public String dangky2(){
		return "dangky2";
	}
	@RequestMapping(value ="/dangky3", method = RequestMethod.GET)	
	public String dangky3(){
		return "dangky3";
	}
	@RequestMapping(value ="/dangky4", method = RequestMethod.GET)	
	public String dangky4(){
		return "dangky4";
	}
	
}
