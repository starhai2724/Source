package com.sms.Controller;

import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.swing.plaf.synth.SynthSeparatorUI;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sms.common.ClientSMSCommons;
import com.sms.common.Status;
import com.sms.common.SystemCommon;
import com.sms.form.StoreOwnerForm;
import com.sms.impl.ClientStoreOwnerImpl;
import com.sms.input.StoreOwnerInputBean;
import com.sms.models.ResultObject;
import com.sms.models.User;
import com.sms.output.StoreOwnerOutputBean;

@Controller
public class ClientStoreOwnerController {

	
	public static final String CUSTOMER_SYSTEMLIST = "customerSystemList.jsp";
	public static final String CUSTOMER_SYSTEM_ENTITY = "customerSystemEntity.jsp";
	
	@RequestMapping(value  = "/storeOwnerList")
	public String getCustomerSystemList(ModelMap modelMap, @ModelAttribute("storeOwnerListForm") StoreOwnerForm storeOwnerForm, HttpSession session){
		//set lai gia tri
		storeOwnerForm.setUsername("");
		storeOwnerForm.setTelephone("");
		storeOwnerForm.setAddress("");
		storeOwnerForm.setEmail("");
		User user = (User) session.getAttribute("userLocal");
		System.out.println("Username: "+ user.getUsername());
		modelMap.addAttribute(SystemCommon.PAGE_ID, CUSTOMER_SYSTEMLIST);
		return SystemCommon.PAGE_HOME;
	}
	
	@RequestMapping(value  = "/storeOwnerEnty" )
	public String getCustomerSystenEntry(ModelMap modelMap, @ModelAttribute("storeOwnerForm") StoreOwnerForm storeOwnerForm, HttpSession session){
		session.setAttribute("storeOwnerForm", storeOwnerForm);
		//set lai gia tri
		storeOwnerForm.setUsername("");
		storeOwnerForm.setTelephone("");
		storeOwnerForm.setFullName("");
		storeOwnerForm.setEmail("");
		modelMap.addAttribute(SystemCommon.PAGE_ID, CUSTOMER_SYSTEM_ENTITY);
		return SystemCommon.PAGE_HOME;
	}
	
	@RequestMapping(value = "/storeOwnerInsert", method = RequestMethod.POST)
	public String  insert(@ModelAttribute ("storeOwnerForm") StoreOwnerForm storeOwnerForm
			,ModelMap model, HttpSession session){
			
			StoreOwnerInputBean  storeOwnerInputBean = new StoreOwnerInputBean();
			
			storeOwnerInputBean.setFullName(storeOwnerForm.getFullName());
			storeOwnerInputBean.setAddress(storeOwnerForm.getAddress());
			storeOwnerInputBean.setEmail(storeOwnerForm.getEmail());
			storeOwnerInputBean.setTelephone(storeOwnerForm.getTelephone());
			storeOwnerInputBean.setPassword(storeOwnerForm.getPassword());
			storeOwnerInputBean.setUsername(storeOwnerForm.getUsername());
			
			ResultObject isNotExistUsername = ClientStoreOwnerImpl.intances.getStoreownerByUsername(storeOwnerForm.getUsername());
			
			if(isNotExistUsername.getStatus() == Status.CANCEL){
				
				storeOwnerForm.setMessageErr("Tên đăng nhập đã tồn tại.");
			}else if(isNotExistUsername.getStatus() == Status.ERROR){
				
				storeOwnerForm.setMessageErr("Đã xảy ra lỗi.");
			}else{
				
				ResultObject response = ClientStoreOwnerImpl.intances.insert(storeOwnerInputBean);
				if(response.getStatus() != Status.SUCCESS){
					
					storeOwnerForm.setMessageErr("Xử lý đăng kí không thành công.");
				}else{
					//set lai messager errors
					storeOwnerForm.setMessageErr("");
					storeOwnerForm.setMessage("Xử lý đăng kí thành công.");
				}
			}
			model.addAttribute(SystemCommon.PAGE_ID, CUSTOMER_SYSTEM_ENTITY);
		return SystemCommon.PAGE_HOME;
		
	}

	@RequestMapping(value="/storeOwnerSearch", method=RequestMethod.POST)
	public String getBy( @ModelAttribute("storeOwnerListForm") StoreOwnerForm storeOwnerListForm,
			ModelMap modelMap, HttpSession session){
		
		//set session
		StoreOwnerForm sessionStoreOwnerForm = (StoreOwnerForm) ClientSMSCommons.getAttribute(session, "storeOwnerForm");
		if(sessionStoreOwnerForm !=null){
			storeOwnerListForm.setUsername(sessionStoreOwnerForm.getUsername());
			storeOwnerListForm.setFullName(sessionStoreOwnerForm.getFullName());
			storeOwnerListForm.setEmail(sessionStoreOwnerForm.getEmail());
			storeOwnerListForm.setTelephone(sessionStoreOwnerForm.getTelephone());
		}
		
		StoreOwnerInputBean storeOwnerInputBean = new StoreOwnerInputBean();
		storeOwnerInputBean.setFullName(storeOwnerListForm.getFullName());
		storeOwnerInputBean.setUsername(storeOwnerListForm.getUsername());
		storeOwnerInputBean.setEmail(storeOwnerListForm.getEmail());
		storeOwnerInputBean.setTelephone(storeOwnerInputBean.getTelephone());
		
		ResultObject resultObject = ClientStoreOwnerImpl.intances.getBy(storeOwnerInputBean);
		List<StoreOwnerOutputBean> outputBean = (List<StoreOwnerOutputBean>) resultObject.getObj();
		
		if(resultObject.getStatus() == Status.SUCCESS){
			modelMap.addAttribute("storeOwners", outputBean);
			modelMap.addAttribute(SystemCommon.PAGE_ID, CUSTOMER_SYSTEMLIST);
		}else{
			modelMap.addAttribute(SystemCommon.PAGE_ID, CUSTOMER_SYSTEMLIST);
			storeOwnerListForm.setMessageErr("Không có dữ liệu. Vui lòng thay đổi điều kiện tìm kiếm.");
		}
		return SystemCommon.PAGE_HOME;
	}
	/**
	 * 
	 * Mean: get idStoreOwner for update 
	 * @param id
	 * @param model
	 * @param session
	 * @param storeOwnerForm
	 * @return
	 */
	@RequestMapping(value="/getStoreOwnerListById/{id}", method=RequestMethod.POST)
	public String getStoreOwnerById(@PathVariable("id") String id, ModelMap model, HttpSession session, @ModelAttribute("storeOwnerListForm") StoreOwnerForm storeOwnerForm){
		session.setAttribute("id",id);
		session.setAttribute("storeOwnerForm", storeOwnerForm);
		model.addAttribute(SystemCommon.PAGE_ID, CUSTOMER_SYSTEM_ENTITY);
		return "redirect:/storeOwnerEntity";
	}
	/**
	 * Mean init update
	 * 
	 * @param model
	 * @param ses
	 * @param storeOwnerForm
	 * @return
	 */
	@RequestMapping(value  = "/storeOwnerEntity")
	public String getCustomerSystenEntryTest(ModelMap model, HttpSession ses, @ModelAttribute("storeOwnerForm") StoreOwnerForm storeOwnerForm){
		String id = (String)ClientSMSCommons.getAttribute(ses, "id");
		//insert zero idStoreOwner 
		id = ClientSMSCommons.insertZeroIdStoreOwner(id);
		ResultObject response = ClientStoreOwnerImpl.intances.getStoreOwnerById(id);
		if(response.getStatus() == Status.SUCCESS){
			LinkedHashMap< String, String>  linkedHashMap= (LinkedHashMap<String, String>) response.getObj();
			storeOwnerForm.setIdStoreOwner(linkedHashMap.get("idStoreOwner"));
			storeOwnerForm.setFullName(linkedHashMap.get("fullName"));
			storeOwnerForm.setAddress(linkedHashMap.get("address"));
			storeOwnerForm.setTelephone(linkedHashMap.get("telephone"));
			storeOwnerForm.setUsername(linkedHashMap.get("username"));
			storeOwnerForm.setEmail(linkedHashMap.get("email"));
			storeOwnerForm.setDisabledFlag("true");
			/**storeOwnerForm.setUpdateFlag("1") mean when update*/
			storeOwnerForm.setUpdateFlag("1");
			model.addAttribute(SystemCommon.PAGE_ID, CUSTOMER_SYSTEM_ENTITY);

		}
		return SystemCommon.PAGE_HOME;
	}
	
	//Excuse update
	@RequestMapping(value  = "/updateStoreOwner", method=RequestMethod.POST)
	public String updateStoreOwner(@ModelAttribute("storeOwnerForm") StoreOwnerForm storeOwnerForm, ModelMap model){
		
		ResultObject  response = ClientStoreOwnerImpl.intances.updateStoreOwnerById(storeOwnerForm);
		
		if(response.getStatus() != Status.SUCCESS){
			
			storeOwnerForm.setMessageErr("Xư lý đăng kí không thành công dữ liệu đã được cập nhật bởi người khác!");
			model.addAttribute(SystemCommon.PAGE_ID, CUSTOMER_SYSTEM_ENTITY);
			return SystemCommon.PAGE_HOME;
		}else{
			storeOwnerForm.setMessage("Xư lý đăng kí thành công!");
			model.addAttribute(SystemCommon.PAGE_ID, CUSTOMER_SYSTEM_ENTITY);
			
		}
		
		return SystemCommon.PAGE_HOME;
	}
	
	
	//Mean: get idStoreOwner for delete
	@RequestMapping(value  = "/getIdStoreOwnerForDelete/{id}", method=RequestMethod.POST)
	public String getIdStoreOwnerForDelete( @PathVariable("id") String id , HttpSession session){
		session.setAttribute("id", id);
		return "redirect:/deleteStoreOwnerById";
	}
	
	//Mean: Excuse delete then search
	@RequestMapping(value  = "/deleteStoreOwnerById", method=RequestMethod.GET)
	public String deleteStoreOwnerById( @ModelAttribute("storeOwnerListForm") StoreOwnerForm storeOwnerListForm,
			ModelMap modelMap, HttpSession session){
		String id =(String) ClientSMSCommons.getAttribute(session, "id");
		//insert zero idStoreOwner 
		id = ClientSMSCommons.insertZeroIdStoreOwner(id);
		ResultObject response = ClientStoreOwnerImpl.intances.deleteStoreownerById(id);
		
		if(response.getStatus() != Status.SUCCESS){
			
			storeOwnerListForm.setMessageErr("Xử lý xóa không thành công!");
			modelMap.addAttribute(SystemCommon.PAGE_ID, CUSTOMER_SYSTEMLIST);
		}else{
			storeOwnerListForm.setMessage("Xử lý xóa thành công!");
			getBy(storeOwnerListForm, modelMap, session);
		}
		
		return SystemCommon.PAGE_HOME;
	}
	
	
}
