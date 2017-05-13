package com.sms.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sms.common.ClientSMSCommons;
import com.sms.common.Status;
import com.sms.form.RegisterUserForm;
import com.sms.impl.ClientStoreOwnerImpl;
import com.sms.models.ResultObject;

@Controller
public class ClientRegisterUserController {
	public static final String REGISTER_USER = "registerUser";
	
	
	/**
	 * Mean: init
	 * @param form
	 * @return
	 */
	@RequestMapping(value="/registerUser/init",  method = RequestMethod.POST )
	public String registerUserInit(@ModelAttribute("registerUserForm") RegisterUserForm form, HttpSession session){
		
		// Di chuyen tu dang ki thong tin
		RegisterUserForm registerUserForm = (RegisterUserForm) session.getAttribute("registerUserForm");
		if(!ClientSMSCommons.isNull(registerUserForm)){
			//set tri MH
			System.out.println(registerUserForm.getFullName());
			form = registerUserForm; 
			form.setFullName(registerUserForm.getFullName());
			System.out.println("abc: "+form.getFullName());
		}
		return REGISTER_USER;
	}
	
	
	
	/**
	 * Mean: dang ki tai khoan sau do se chuyen qua man hinh dk thong tin
	 * @param form
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/registerUser/insert", method = RequestMethod.POST)
	public String  insert(@ModelAttribute ("registerUserForm") RegisterUserForm form, HttpSession session){
			
			ResultObject isNotExistUsername = ClientStoreOwnerImpl.intances.getStoreownerByUsername(form.getUsername());
			
			if(isNotExistUsername.getStatus() == Status.CANCEL){
				
				form.setMessageErr("Tên đăng nhập đã tồn tại.");
				return REGISTER_USER;
			}else if(isNotExistUsername.getStatus() == Status.ERROR){
				
				form.setMessageErr("Đã xảy ra lỗi.");
				return REGISTER_USER;
			}else{
				//session RegisterUserForm
				session.setAttribute("registerUserForm", form);
			}
		return "redirect:/RegisterStoreInfomation/init";
		
	}
	
	
}
