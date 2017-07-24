package com.sms.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sms.common.SystemCommon;
import com.sms.dao.KhoHangDAO;
import com.sms.dao.LayoutDAO;
import com.sms.form.KhoHangForm;
import com.sms.formRows.KhoHangRowForm;
import com.sms.output.KhoHangOutBean;
@Controller
public class KhoHangController {
	public static final String KHO_HANG = "khoHang.jsp";
	
	@RequestMapping(value  = "/khoHang/init")
	public String init(@ModelAttribute("KhoHangForm") KhoHangForm form, HttpSession session){
		String pathJSP = (String)session.getAttribute("pathURL");
		// check pathJSP
		if (!LayoutDAO.intances.checkPathJSP(pathJSP)) {
			// quay ve trang login
			return "redirect:/";
		}

		List<KhoHangOutBean> lst = KhoHangDAO.intances.getAllKhoHang(pathJSP);
		KhoHangRowForm rowForm;
		
		for(KhoHangOutBean outBean : lst){
			rowForm = new KhoHangRowForm();
			rowForm.setIdSanPham(outBean.getIdSanPham());
			rowForm.setSoLuong(outBean.getSoLuong());
			rowForm.setTenSp(outBean.getIdSanPham()+": "+outBean.getTenSp());
			if(!"".equals(outBean.getSoLuong()) && !"0".equals(outBean.getSoLuong())) {
				rowForm.setTrangThai("Còn hàng");
			}else {
				rowForm.setTrangThai("Hết hàng");
			}
			form.getLst().add(rowForm);
		}
		session.setAttribute("PAGEIDSTORE", KHO_HANG);
		return  SystemCommon.ADMIN_STORE;
	}
	
}
