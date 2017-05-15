package com.sms.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.sms.OutputRows.PathJSPOutputRowBean;
import com.sms.common.ClientSMSCommons;
import com.sms.common.Status;
import com.sms.common.SystemCommon;
import com.sms.common.SystemURL;
import com.sms.form.RegisterStoreInfomationForm;
import com.sms.form.RegisterUserForm;
import com.sms.impl.ClientPathJSPImpl;
import com.sms.input.RegisterUserInputBean;
import com.sms.models.ResultObject;
import com.sms.output.PathJSPOutputBean;

@Controller
public class ClientRegisterStoreInfomationController {
	
	public static final String REGISTER_STORE_INFOMATION = "registerStoreInfomation";
	
	/**
	 * Mean: init
	 * @param form
	 * @return
	 */
	@RequestMapping(value="/RegisterStoreInfomation/init", method=RequestMethod.GET)
	public String init(@ModelAttribute("registerStoreInfomation") RegisterStoreInfomationForm form, ModelMap modelMap, Model model){
		
		//get category 
		PathJSPOutputBean pathJSPOutputBean = ClientPathJSPImpl.intances.getPathJSP();
		for(PathJSPOutputRowBean rowBean: pathJSPOutputBean.getLst()){
			form.getLstCategory().put(rowBean.getIdPathJSP(), rowBean.getName());
		}
		model.addAttribute("registerStoreInfomation", form);
		return REGISTER_STORE_INFOMATION;
	}
	
	
	/**
	 * Mean: insert
	 * @param form
	 * @return
	 */
	@RequestMapping(value="/RegisterStoreInfomation/insert", method=RequestMethod.POST)
	public String insert(@ModelAttribute("registerStoreInfomation") RegisterStoreInfomationForm form,HttpSession session, Model model){
		
		RestTemplate restTemplate = new RestTemplate();
		String page = "";
		//get category 
		PathJSPOutputBean pathJSPOutputBean = ClientPathJSPImpl.intances.getPathJSP();
		for(PathJSPOutputRowBean rowBean: pathJSPOutputBean.getLst()){
			form.getLstCategory().put(rowBean.getIdPathJSP(), rowBean.getName());
		}
		System.out.println("catergory: "+ form.getLstCategory().get("01"));
		
		RegisterUserForm registerUserForm = (RegisterUserForm) session.getAttribute("registerUserForm");
		// check validation (true mean exist)
		boolean validDomain = restTemplate.postForObject(SystemURL.CHECK_EXIST_DOMAIN, form.getDomain(), boolean.class);
		if(validDomain){
			form.setMessage("");
			form.setMessageErr("Địa chỉ gian hàng đã tồn tại!");
			page = REGISTER_STORE_INFOMATION;
		}else{
		
		
			RegisterUserInputBean  registerUserInputBean = new RegisterUserInputBean();
			//StoreOwner
			registerUserInputBean.setFullName(registerUserForm.getFullName());
			registerUserInputBean.setPassword(registerUserForm.getPassword());
			registerUserInputBean.setUsername(registerUserForm.getUsername());
			registerUserInputBean.setTelephoneStoreOwner(registerUserForm.getTelephone());
			registerUserInputBean.setAddressStoreOwner(registerUserForm.getAddress());
			registerUserInputBean.setEmailStoreOwner(registerUserForm.getEmail());
			registerUserInputBean.setRole(SystemCommon.USER);
			//Store xu ly o server
			//Store infomation
			registerUserInputBean.setAddressStore(form.getAddress());
			registerUserInputBean.setCategoryStore(form.getCategoryed());
			registerUserInputBean.setStoreName(form.getStoreName());
			registerUserInputBean.setTelephoneStoreOwner(form.getTelephone());
			registerUserInputBean.setEmailStore(form.getEmail());
			//Dia chi gian hang
			registerUserInputBean.setDomain(form.getDomain());
			
			// excute
			ResultObject result = restTemplate.postForObject(SystemURL.REGISTERUSER_INSERT, registerUserInputBean, ResultObject.class);
			
			
			if(result.getStatus() == Status.ERROR){
				form.setMessage("");
				form.setMessageErr("Xử lý đăng kí không thành công!");
				
			}else if(result.getStatus() == Status.SUCCESS){
				form.setMessage("Xử lý đăng kí thành công!");
			}
			page = REGISTER_STORE_INFOMATION;
		}
		model.addAttribute("registerStoreInfomation", form);
		return page;
	}
	
	
}
