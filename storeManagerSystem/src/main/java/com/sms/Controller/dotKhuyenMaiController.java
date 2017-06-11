package com.sms.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sms.form.DotKhuyenMaiForm;
@Controller
public class dotKhuyenMaiController {
	public static final String DOTKHUYENMAI_SYSTEM = "dotKhuyenMai";
	
	@RequestMapping(value  = "/dotKhuyenMai")
	public String dotKhuyenMai(@ModelAttribute("dotKhuyenMaiForm") DotKhuyenMaiForm dotKhuyenMaiForm ,ModelMap modelMap,  HttpSession session){
		return DOTKHUYENMAI_SYSTEM	;
	}
}
