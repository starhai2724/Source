		
package com.sms.Controller;

import java.util.LinkedHashMap;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sms.common.Status;
import com.sms.common.SystemCommon;
import com.sms.form.StoreOwnerForm;
import com.sms.impl.ClientLoginImpl;
import com.sms.models.ResultObject;
import com.sms.models.User;

@Controller
public class ClientLoginController {

	public static final String PAGE_INFO = "systemInfo.jsp";
	public static final String PAGE_ID = "PAGE_ID";
	public static final String PAGE_REGISTER = "registerUser";
	
	
	
	@RequestMapping(value ="/", method = RequestMethod.GET)	
	public String home(){
		return SystemCommon.PAGE_LOGIN;
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String checkLogin(@RequestParam("username") String username, @RequestParam("password") String password, ModelMap model, HttpSession session){
		model.addAttribute("username", username);
		model.addAttribute("password", password);
		model.addAttribute("message", "Sai tên hoặc mật khẩu");
		User req = new User();
		req.setUsername(username);
		req.setPassword(password);
		ClientLoginImpl loginImpl = new ClientLoginImpl();
		ResultObject response = loginImpl.checkLogin(req);
		if(response.getStatus()== Status.SUCCESS){
			model.addAttribute(PAGE_ID, PAGE_INFO);
			LinkedHashMap< String, String> linkedHashMap = (LinkedHashMap<String, String>) response.getObj();
			User userlocal = new User();
			userlocal.setStore_cd(linkedHashMap.get("store_cd"));
			userlocal.setUsername(linkedHashMap.get("username"));
			userlocal.setRole(linkedHashMap.get("role"));
			// set session userlocal
			session.setAttribute("userlocal", userlocal);
			
			//role User
			if(SystemCommon.USER.equals(userlocal.getRole())){
				return SystemCommon.ADMIN_STORE;
				
			//role Root
			}else if(SystemCommon.ROOT.equals(userlocal.getRole())){
				return SystemCommon.PAGE_HOME;
			}
		}
		return SystemCommon.PAGE_LOGIN;
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute("storeOwnerForm") StoreOwnerForm storeOwnerForm){
		return PAGE_REGISTER;
	}
	
	
}

