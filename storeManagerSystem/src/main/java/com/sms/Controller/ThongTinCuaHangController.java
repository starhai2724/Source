package com.sms.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.sms.common.SystemCommon;
import com.sms.dao.DangKiWebDAO;
import com.sms.form.DangKiWebForm;
import com.sms.input.DangKiWebInputBean;
import com.sms.output.DangKiWebOutputBean;

@Controller
public class ThongTinCuaHangController {
	RestTemplate restTemplate = new RestTemplate();
	public static final String THONGTINCH = "thongTinCuaHang.jsp";
	
	@RequestMapping(value  = "/thongTinChuaHang/init")
	public String init(@ModelAttribute("DangKiWebForm") DangKiWebForm form, HttpSession session){
		String pathJSP = (String)session.getAttribute("pathURL");

		//reset message
		form.setMessage("");
		form.setMessageErr("");
		
		/* Check validation */
		
		//Sdt da dc dang ki
		String result  = DangKiWebDAO.intances.getExistSDT(form.getSdt());
		if(result != null && !"".equals(result)){
			form.setMessage("");
			form.setMessageErr("Số điện thoại đã được đăng kí.");
			session.setAttribute("PAGEIDSTORE", THONGTINCH);
			return  SystemCommon.ADMIN_STORE;
		}
		
		//da ton tai dia chi website
		 result = DangKiWebDAO.intances.getExistPathJSP(form.getPathJSP());
		if(result != null && !"".equals(result)){
			form.setMessage("");
			form.setMessageErr("Địa chỉ website đã tồn tại.");
			session.setAttribute("PAGEIDSTORE", THONGTINCH);
			return  SystemCommon.ADMIN_STORE;
		}
			
		// init data
		DangKiWebOutputBean output = DangKiWebDAO.intances.getDataByPathJSP(pathJSP);
		form.setDiaChi(output.getDiaChi());
		form.setSdt(output.getSdt());	
		form.setTenWebSite(output.getTenWebSite());	
		form.setEmail(output.getEmail());
		form.setDkGiaoHangFree(output.getDkGiaoHangFree());
		form.setHinhHeader(output.getHinhHeader());
		form.setHinhHeader1(output.getHinhHeader1());
		form.setHinhHeader2(output.getHinhHeader2());
		form.setHinhHeader3(output.getHinhHeader3());
		form.setHinhHeader4(output.getHinhHeader4());
		form.setHinhHeader5(output.getHinhHeader5());
		
		
		session.setAttribute("PAGEIDSTORE", THONGTINCH);
		return  SystemCommon.ADMIN_STORE;
	}
	
	
	@RequestMapping(value  = "/thongTinChuaHang/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("DangKiWebForm") DangKiWebForm form, HttpSession session){
		String pathJSP = (String)session.getAttribute("pathURL");

		//reset message
		form.setMessage("");
		form.setMessageErr("");
		
		/* Check validation */
		
		//Sdt da dc dang ki
		String result  = DangKiWebDAO.intances.getExistSDT(form.getSdt());
		if(result != null && !"".equals(result)){
			form.setMessage("");
			form.setMessageErr("Số điện thoại đã được đăng kí.");
			session.setAttribute("PAGEIDSTORE", THONGTINCH);
			return  SystemCommon.ADMIN_STORE;
		}
		
		//da ton tai dia chi website
		 result = DangKiWebDAO.intances.getExistPathJSP(form.getPathJSP());
		if(result != null && !"".equals(result)){
			form.setMessage("");
			form.setMessageErr("Địa chỉ website đã tồn tại.");
			session.setAttribute("PAGEIDSTORE", THONGTINCH);
			return  SystemCommon.ADMIN_STORE;
		}
			
		// init data
		DangKiWebInputBean input  =  new DangKiWebInputBean();
		input.setPathJSP(pathJSP);
		input.setDiaChi(form.getDiaChi());
		input.setSdt(form.getSdt());	
		input.setTenWebSite(form.getTenWebSite());	
		input.setEmail(form.getEmail());
		input.setDkGiaoHangFree(form.getDkGiaoHangFree());
		input.setHinhHeader(form.getHinhHeader());
		input.setHinhHeader1(form.getHinhHeader1());
		input.setHinhHeader2(form.getHinhHeader2());
		input.setHinhHeader3(form.getHinhHeader3());
		input.setHinhHeader4(form.getHinhHeader4());
		input.setHinhHeader5(form.getHinhHeader5());
		
		int cnt = DangKiWebDAO.intances.update(input);
		if(cnt == 1){
			form.setMessage("Xử lý cập nhật thành công.");
			form.setMessageErr("");
		}else {
			form.setMessageErr("Xử lý cập nhật không thành công.");
			form.setMessage("");
		}
		
		session.setAttribute("PAGEIDSTORE", THONGTINCH);
		return  SystemCommon.ADMIN_STORE;
	}
	
	
}
