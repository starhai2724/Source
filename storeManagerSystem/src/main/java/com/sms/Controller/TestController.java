package com.sms.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
	
	
//	@RequestMapping(value ="/{path}", method = RequestMethod.GET)	
//	public String home(){
//		return "fashion";
//	}
	
	@RequestMapping(value ="/trangChuAdmin", method = RequestMethod.GET)	
	public String home1(){
		return "trangChuAdmin";
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
	
	@RequestMapping(value ="/testGioHang", method = RequestMethod.GET)	
	public String testGioHang(){
		return "gioHang";
	}
	@RequestMapping(value ="/dangky", method = RequestMethod.GET)	
	public String dangki(){
		return "dangKyTaiKhoan";
	}
	@RequestMapping(value ="/test_5", method = RequestMethod.GET)	
	public String test_2(HttpSession session){
		session.setAttribute("PAGECENTER", "dangky1.jsp");
		return "index";
	}
	@RequestMapping(value ="/test_6", method = RequestMethod.GET)	
	public String thongKe(){
		return "template_2/trang-chu";
	}
	
	@RequestMapping(value ="/test_7", method = RequestMethod.GET)	
	public String test_7(){
//		String req = "Hello";
//		System.out.println("req: "+req);
//		Map context = new HashMap();
////		MessageResponse response = conversationAPI(req, context);
//		BVTService bvtService = new BVTService();
//		MessageResponse response = bvtService.conversationAPI(req, context);
//		context = response.getContext();
//		System.out.println("Watson Response:" + response.getText().get(0));
//		context = response.getContext();
//		System.out.println("———–");
//		System.out.println(response.getText().get(0));
		return "conversation";
	}
	
}
