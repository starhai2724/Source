package com.sms.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sms.OutputRows.PathJSPOutputRowBean;
import com.sms.impl.ClientPathJSPImpl;
import com.sms.input.PathJSPInputBean;
import com.sms.models.User;
import com.sms.output.PathJSPOutputBean;

@Controller
public class SalePageCtrl {
	
	@RequestMapping(value ="/{path}", method = RequestMethod.GET)
	public String init(HttpSession session){
		String page = "login";
		//get userlocal
		User userLocal = (User) session.getAttribute("userLocal");
		
		//get path jsp 
		PathJSPInputBean pathJSPInputBean = new PathJSPInputBean();
		pathJSPInputBean.setIdStore(userLocal.getStore_cd());
		PathJSPOutputBean pathJSPOutputBean = ClientPathJSPImpl.intances.getPathJSPById(pathJSPInputBean);
		PathJSPOutputRowBean  pathJSPOutputRowBean;
		if(pathJSPOutputBean != null && pathJSPOutputBean.getLst().size() > 0){
			pathJSPOutputRowBean = pathJSPOutputBean.getLst().get(0);
			return pathJSPOutputRowBean.getPathJSP();
		}
		
		return page;
	}	
	
	
}
