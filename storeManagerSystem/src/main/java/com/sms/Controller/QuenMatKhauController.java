package com.sms.Controller;

import java.util.Random;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sms.common.MD5HashingExample;
import com.sms.common.MailUtilLocal;
import com.sms.dao.DangKiWebDAO;
import com.sms.form.QuenMatKhauForm;
import com.sms.input.QuenMatKhauInputBean;

@Controller
public class QuenMatKhauController {
	public static final String PAGE = "index";
	public static final String PAGE_QMK = "quenMatKhau.jsp";
	public static final String PAGE_DMK = "doiMatKhau.jsp";
	//session
	public static final String PAGECENTER = "PAGECENTER";
	/**
	 * 
	 * @param form
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/quenMatKhau/init")
	public String init(@ModelAttribute("QuenMatKhauForm") QuenMatKhauForm form, HttpSession session){
		form.setMessage("");
		form.setMessageErr("");
		session.setAttribute(PAGECENTER, PAGE_QMK);
		return PAGE;
	}
	
	/**
	 * 
	 * @param form
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/doiMatKhau/init")
	public String initDoiMatKhau(@ModelAttribute("QuenMatKhauForm") QuenMatKhauForm form, HttpSession session){
		form.setMessage("");
		form.setMessageErr("");
		session.setAttribute(PAGECENTER, PAGE_DMK);
		return PAGE;
	}
	
	/**
	 * 
	 * @param form
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/quenMatKhau", method = RequestMethod.POST)
	public String quenMatKhau(@ModelAttribute("QuenMatKhauForm") QuenMatKhauForm form, HttpSession session){
		form.setMessage("");
		form.setMessageErr("");
		
		Random rd = new Random();
		String num = "" + rd.nextInt(1000000);
		String thongBao = "<center>";
		thongBao += "<h3>"+"Hệ thống bán hàng"+"</h3><br>";
		thongBao += "<p>"
				+ " mật khẩu mới của bạn </p><br>";
		thongBao += "<p>" + num + "</p>";
		thongBao += "</center>";
		MailUtilLocal.guiMail(form.getEmail(), thongBao," Hệ thống bán hàng");
		
		QuenMatKhauInputBean inputBean = new QuenMatKhauInputBean();
		inputBean.setEmail(form.getEmail());
		inputBean.setPassword(MD5HashingExample.MD5(num));
		int  cnt = 0;
		cnt = DangKiWebDAO.intances.updatePassword(inputBean);
		if(cnt == 1){
//			form.setMessage("Xử lý đổi mật khẩu thành công.");
			form.setMessageErr("");
			return "redirect:/";
		}else{
			form.setMessage("");
			form.setMessageErr("Xử lý đổi mật khẩu không thành công.");
		}
		session.setAttribute(PAGECENTER, PAGE_QMK);
		return PAGE;
	}
	/**
	 * 
	 * @param form
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/doiMatKhau" ,method = RequestMethod.POST)
	public String doiMatKhau(@ModelAttribute("QuenMatKhauForm") QuenMatKhauForm form, HttpSession session){
		form.setMessage("");
		form.setMessageErr("");
		
		QuenMatKhauInputBean inputBean = new QuenMatKhauInputBean();
		inputBean.setEmail(form.getEmail());
		inputBean.setPassword(MD5HashingExample.MD5(form.getPassword()));
		int  cnt = 0;
		cnt = DangKiWebDAO.intances.updatePassword(inputBean);
		if(cnt == 1){
			form.setMessage("Xử lý đổi mật khẩu thành công.");
			form.setMessageErr("");
		}else{
			form.setMessage("");
			form.setMessageErr("Xử lý đổi mật khẩu không thành công.");
		}
		session.setAttribute(PAGECENTER, PAGE_QMK);
		return PAGE;
	}
}
