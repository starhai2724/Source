package com.sms.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sms.common.MD5HashingExample;
import com.sms.dao.KhachHangDAO;
import com.sms.dao.LayoutDAO;
import com.sms.form.KhachHangDangNhapForm;
import com.sms.output.TaiKhoanKhachHangOutputBean;
import com.sms.session.KhachHangSession;

@Controller
public class KhachHangDangNhapController {

	public static final String PAGE_LOGIN = "loginKhachHang";
	
	@RequestMapping(value="/{path}/dangNhap")
	public ModelAndView login(@ModelAttribute("KhachHangDangNhapForm") KhachHangDangNhapForm form, @PathVariable("path") String path){
		//check pathJSP
		if(!LayoutDAO.intances.checkPathJSP(path)){
			//quay ve trang login
			return  new ModelAndView("redirect:/");
		}
		//reset
		form.setPathJSP(path);
		form.setSdt("");
		form.setMatKhau("");
		
		return new ModelAndView(PAGE_LOGIN, "KhachHangDangNhapForm", form);
	}
	
	@RequestMapping(value="/{path}/dangNhap/kiemTra",  method = RequestMethod.POST)
	public ModelAndView checkLogin(@ModelAttribute("KhachHangDangNhapForm") KhachHangDangNhapForm form, @PathVariable("path") String path, HttpSession session){
		//check pathJSP
		if(!LayoutDAO.intances.checkPathJSP(path)){
			//quay ve trang login
			return  new ModelAndView("redirect:/");
		}
		TaiKhoanKhachHangOutputBean outputBean = KhachHangDAO.intances.checkLogin(path, form.getSdt(), MD5HashingExample.MD5(form.getMatKhau()));
		if(outputBean != null){
			KhachHangSession khachHangSession = new KhachHangSession();
			khachHangSession.setPathJSP(path);
			khachHangSession.setIdKhachHang(outputBean.getIdKhachHang());
			khachHangSession.setSdt(outputBean.getSdt());
			khachHangSession.setTenKhachHang(outputBean.getTenKhachHang());
			khachHangSession.setDiemTichLuy(outputBean.getDiemTichLuy());
			khachHangSession.setLoaiThe(outputBean.getLoaiThe());
			session.setAttribute("KhachHangSession", khachHangSession);
			//quay ve trang login
			return  new ModelAndView(String.valueOf("redirect:/"+path));
		}else{
			//set page
			form.setPathJSP(path);
			form.setMessageErr("Sai Số điện thoại hoặc mật khẩu");
			form.setMatKhau("");
			return new ModelAndView(PAGE_LOGIN, "KhachHangDangNhapForm", form);
		}
	}
	
	@RequestMapping(value="/{path}/dangNhap/dangXuat",  method = RequestMethod.POST)
	public String dangXuat(@ModelAttribute("KhachHangDangNhapForm") KhachHangDangNhapForm form, @PathVariable("path") String path, HttpSession session){
		//check pathJSP
		if(!LayoutDAO.intances.checkPathJSP(path)){
			//quay ve trang login
			return "redirect:/";
		}
		return LayoutDAO.intances.getPageJSP(path);
	}
}
