package com.sms.Controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sms.common.SystemCommon;
import com.sms.dao.DangKiWebDAO;
import com.sms.form.DangKiWebForm;
import com.sms.input.DangKiWebInputBean;
import com.sms.output.DangKiWebOutputBean;

@Controller
public class ThongTinCuaHangController {
	public static final String THONGTINCH = "thongTinCuaHang.jsp";
	
	@RequestMapping(value  = "/thongTinCuaHang/init")
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
		form.setHinh(output.getHinh());
		form.setFile_1(output.getHinh1());
		form.setFile_2(output.getHinh2());
		form.setFile_3(output.getHinh3());
		form.setFile_4(output.getHinh4());
		form.setFile_5(output.getHinh5());
		
		
		session.setAttribute("PAGEIDSTORE", THONGTINCH);
		return  SystemCommon.ADMIN_STORE;
	}
	
	
	@RequestMapping(value  = "/thongTinCuaHang/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("DangKiWebForm") DangKiWebForm form
			,@RequestParam("hinh1") MultipartFile hinhHeader1,
			@RequestParam("hinh2") MultipartFile hinhHeader2, @RequestParam("hinh3") MultipartFile hinhHeader3
			, @RequestParam("hinh4") MultipartFile hinhHeader4, @RequestParam("hinh5") MultipartFile hinhHeader5, 
			HttpSession session){
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
		//Image (S)
		byte[] bFile1 = null;
		byte[] bFile2 = null;
		byte[] bFile3 = null;
		byte[] bFile4 = null;
		byte[] bFile5 = null;
		session.setAttribute("PAGEIDSTORE", THONGTINCH);
		
		try {
			if(hinhHeader1.getBytes().length == 0){
				form.setMessageErr("Xin hãy chọn Hình ảnh header 1.");
				return  SystemCommon.ADMIN_STORE;
			}
			if(hinhHeader2.getBytes().length == 0){
				form.setMessageErr("Xin hãy chọn Hình ảnh header 2.");
				return  SystemCommon.ADMIN_STORE;
			}
			if(hinhHeader3.getBytes().length == 0){
				form.setMessageErr("Xin hãy chọn Hình ảnh header 3.");
				return  SystemCommon.ADMIN_STORE;
			}
			if(hinhHeader4.getBytes().length == 0){
				form.setMessageErr("Xin hãy chọn Hình ảnh header 4.");
				return  SystemCommon.ADMIN_STORE;
			}
			if(hinhHeader5.getBytes().length == 0){
				form.setMessageErr("Xin hãy chọn Hình ảnh header 5.");
				return  SystemCommon.ADMIN_STORE;
			}
			
				bFile1 = hinhHeader1.getBytes();
				bFile2 = hinhHeader2.getBytes();
				bFile3 = hinhHeader3.getBytes();
				bFile4 = hinhHeader4.getBytes();
				bFile5 = hinhHeader5.getBytes();
				
				input.setHinh1(bFile1);
				input.setHinh2(bFile2);
				input.setHinh3(bFile3);
				input.setHinh4(bFile4);
				input.setHinh5(bFile5);
				
				int cnt = DangKiWebDAO.intances.update(input);
				if(cnt == 1){
					form.setMessage("Xử lý cập nhật thành công.");
					form.setMessageErr("");
				}else {
					form.setMessageErr("Xử lý cập nhật không thành công.1");
					form.setMessage("");
				}
				
				return  SystemCommon.ADMIN_STORE;
				
		} catch (IOException e1) {
			form.setMessageErr("Xử lý cập nhật không thành công.2");
			session.setAttribute("PAGEIDSTORE", THONGTINCH);
			return  SystemCommon.ADMIN_STORE;
		}
	}
	
	
}
