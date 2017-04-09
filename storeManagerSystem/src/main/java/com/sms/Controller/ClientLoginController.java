		
package com.sms.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sms.common.Status;
import com.sms.common.SystemCommon;
import com.sms.impl.ClientLoginImpl;
import com.sms.models.ResultObject;
import com.sms.models.User;

@Controller
public class ClientLoginController {

	public static final String PAGE_INFO = "systemInfo.jsp";
	public static final String PAGE_ID = "PAGE_ID";
	
	
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
//		ResultObject response = loginImpl.checkLogin(req);
		ResultObject response = new ResultObject(Status.SUCCESS);
		if(response.getStatus()== Status.SUCCESS){
			model.addAttribute(PAGE_ID, PAGE_INFO);
			session.setAttribute("userLocal", req);
			return SystemCommon.PAGE_HOME;
		}else{
			return SystemCommon.PAGE_LOGIN;
		}
		
	}
	
}

