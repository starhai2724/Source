		
package com.sms.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sms.common.Status;
import com.sms.impl.ClientLoginImpl;
import com.sms.models.ResultObject;
import com.sms.models.User;

@Controller
public class ClientLoginController {

	public static final String PAGE_LOGIN = "login";
	public static final String PAGE_HOME = "home";
	public static final String PAGE_INFO = "systemInfo";
	public static final String PAGE_ID = "PAGE_ID";
	
	
	@RequestMapping(value ="/", method = RequestMethod.GET)	
	public String home(){
		return PAGE_LOGIN;
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
//			model.addAttribute(PAGE_ID, PAGE_INFO);
			model.addAttribute(PAGE_ID, "function-system.jsp");
			session.setAttribute("userLocal", req);
			return PAGE_HOME;
		}else{
			return PAGE_LOGIN;
		}
		
	}
	
	//Test 
	@RequestMapping(value ="/test", method = RequestMethod.GET)	
	public String test(){
		return PAGE_HOME;sdfsadfas
	}
	
	
}

