package com.sms.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sms.common.Status;
import com.sms.impl.ClientStoreOwnerImpl;
import com.sms.models.ResultObject;
import com.sms.models.StoreOwnerModel;

@Controller
public class ClientStoreOwnerController {


	public static final String PAGE_LOGIN = "login";
	public static final String PAGE_HOME = "home";
	public static final String PAGE_INFO = "systemInfo";
	public static final String PAGE_ID = "PAGE_ID";
	
	
	@RequestMapping(value = "/storeOwnerInsert", method = RequestMethod.POST)
	public String  insert(@RequestParam("fullname") String fullname 
			,@RequestParam("address") String address
			,@RequestParam("telephone") String telephone
			,@RequestParam("username") String username
			,@RequestParam("email") String email
			,@RequestParam("password") String password
			,ModelMap model, HttpSession session){
			
			model.addAttribute("fullname", fullname);
			model.addAttribute("address", address);
			model.addAttribute("telephone", telephone);
			model.addAttribute("username", username);
			model.addAttribute("email", email);
			model.addAttribute("password", password);
			
			StoreOwnerModel  storeOwnerModel = new StoreOwnerModel();
			
			storeOwnerModel.setFullName(fullname);
			storeOwnerModel.setAddress(address);
			storeOwnerModel.setEmail(email);
			storeOwnerModel.setTelephone(telephone);
			storeOwnerModel.setPassword(password);
			storeOwnerModel.setUsername(username);
			
			
			ResultObject result = ClientStoreOwnerImpl.intances.insert(storeOwnerModel);
		
		return PAGE_HOME;
		
	}

	@RequestMapping(value="/storeOwnerSearch", method=RequestMethod.POST)
	public String getBy( @RequestParam("fullname") String fullname, @RequestParam("username") String username, @RequestParam("telephone") String telephone, @RequestParam("email") String email,
			ModelMap modelMap, HttpSession session, ModelAndView modelAndView){
		modelMap.addAttribute("fullname", fullname);
		modelMap.addAttribute("username", username);
		modelMap.addAttribute("telephone",telephone );
		modelMap.addAttribute("email",email );
		StoreOwnerModel storeOwnerModel = new StoreOwnerModel();
		storeOwnerModel.setFullName(fullname);
		storeOwnerModel.setUsername(username);
		storeOwnerModel.setEmail(email);
		storeOwnerModel.setTelephone(telephone);
		
		ResultObject resultObject = ClientStoreOwnerImpl.intances.getBy(storeOwnerModel);
		List<StoreOwnerModel> liStoreOwnerModels = (List<StoreOwnerModel>) resultObject.getObj();
		
		if(resultObject.getStatus() == Status.SUCCESS){
			modelMap.addAttribute("storeOwners", liStoreOwnerModels);
//			modelAndView.addObject("storeOwners", liStoreOwnerModels);
		}else{
			modelMap.addAttribute("message_err", "Loi");
		}
		return PAGE_HOME;
	}
}
