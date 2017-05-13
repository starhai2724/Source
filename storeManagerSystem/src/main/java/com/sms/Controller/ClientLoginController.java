		
package com.sms.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sms.common.SystemCommon;
import com.sms.form.StoreOwnerForm;
import com.sms.impl.ClientLoginImpl;
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
		User response = loginImpl.checkLogin(req);
		if(null != response && !StringUtils.isEmpty(response.getUsername())){
			model.addAttribute(PAGE_ID, PAGE_INFO);
			User userlocal = response;
			// set session userlocal
			session.setAttribute("userLocal", userlocal);
			
			//role User
			if(SystemCommon.USER.equals(userlocal.getRole())){
				session.setAttribute("pathURL", userlocal.getURLStore());
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

