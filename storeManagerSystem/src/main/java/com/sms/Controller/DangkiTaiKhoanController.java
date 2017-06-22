package com.sms.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sms.common.SMSComons;
import com.sms.dao.KhachHangDAO;
import com.sms.dao.LayoutDAO;
import com.sms.form.DangKyTaiKhoanForm;
import com.sms.input.KhachHangInputBean;

@Controller
public class DangkiTaiKhoanController {
	public static final String PAGE_DANGKI = "dangKyTaiKhoan";
	
	
	@RequestMapping(value  = "/{path}/dangkitaikhoan")
	public String init(@ModelAttribute("dangKyTaiKhoanForm") DangKyTaiKhoanForm form, HttpSession session, @PathVariable("path") String path){
		//check pathJSP
		if(!LayoutDAO.intances.checkPathJSP(path)){
			//quay ve trang login
			return  "redirect:/";
		}
		//reset 
		form.setSoDienThoai("");
		form.setPassword("");
		form.setTenKhachHang("");
		form.setPathJSP(path);
		form.setDiaChi("");
		form.setNgaySinh("");
		return  PAGE_DANGKI;
	}
	
	/**
	 * 
	 * @param form
	 * @param session
	 * @return
	 */
	
	@RequestMapping(value ="/{path}/dangkitaikhoan/dangki", method = RequestMethod.POST)
	public String insert(@ModelAttribute("dangKyTaiKhoanForm") DangKyTaiKhoanForm form, HttpSession session, @PathVariable("path") String path) {
		//check pathJSP
		if(!LayoutDAO.intances.checkPathJSP(path)){
			//quay ve trang login
			return  "redirect:/";
		}
		
		//check exist SDT
		if(KhachHangDAO.intances.checkExistSDT(path, form.getSoDienThoai())){
			form.setMessageErr("Số điện thoại đã được đăng kí.");
			form.setMessage("");
			return  PAGE_DANGKI;
		}
		
		//input
		KhachHangInputBean inputBean = new KhachHangInputBean();
		inputBean.setPathJSP(path);
		inputBean.setIdKhachHang("");
		inputBean.setTenKhachHang(form.getTenKhachHang());
		inputBean.setLoaiThe("1");
		inputBean.setGioiTinh("");
		inputBean.setSoDienThoai(form.getSoDienThoai());
		inputBean.setDiaChi(form.getDiaChi());
		inputBean.setSoDiem("0");
		inputBean.setNgaySinh(form.getNgaySinh());
		inputBean.setNgayTao(SMSComons.getDate());
		inputBean.setNgaySua("");
		
		//insert
		int cnt = KhachHangDAO.intances.insert(inputBean);
		System.out.println("cnt: "+cnt);
		if(cnt == 1){
			form.setMessage("Xử lý đăng kí thành công.");
			form.setMessageErr("");
		}else {
			form.setMessageErr("Xử lý đăng kí không thành công.");
			form.setMessage("");
		}
		return  "login";
	}
}
