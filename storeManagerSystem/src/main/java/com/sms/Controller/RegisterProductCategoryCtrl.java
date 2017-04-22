package com.sms.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.sms.OutputRows.RegisterProductCategoryOutputRowBean;
import com.sms.common.Status;
import com.sms.common.SystemCommon;
import com.sms.common.SystemURL;
import com.sms.form.RegisterProductCategoryForm;
import com.sms.formRows.RegisterProductCategoryFormRow;
import com.sms.input.RegisterProductCategoryInputBean;
import com.sms.models.ResultObject;
import com.sms.models.User;
import com.sms.output.RegisterProductCategoryOutputBean;

@Controller
public class RegisterProductCategoryCtrl {
	RestTemplate restTemplate = new RestTemplate();
	public static final String  REGISTER_PRODUCT_CATEGORY = "registerProductCategory.jsp";
	
	/**
	 * Mean: init MST01001
	 * 
	 */
	@RequestMapping(value="/registerProductCategory/init")
	public String init(@ModelAttribute("RegisterProductCategory") RegisterProductCategoryForm form, HttpSession session){
		User userlocal = (User) session.getAttribute("userlocal");
		
		RegisterProductCategoryInputBean inputBean = new RegisterProductCategoryInputBean();
		inputBean.setIdStore(userlocal.getStore_cd());
		RegisterProductCategoryOutputBean outputBean = restTemplate.postForObject(SystemURL.REGISTER_PRODUCT_CATEGORY_INIT, inputBean, RegisterProductCategoryOutputBean.class);
		int cnt = 1;
		if(null != outputBean && outputBean.getLst().size()>0){
			RegisterProductCategoryFormRow formRow;
			for(RegisterProductCategoryOutputRowBean outputRow : outputBean.getLst()){
				formRow = new RegisterProductCategoryFormRow();
				formRow.setNo(String.valueOf(cnt++));
				formRow.setIdProductCategory(outputRow.getIdProductCategory());
				formRow.setNameProductCategory(outputRow.getNameProductCategory());
				System.out.println("abc: "+formRow.getIdProductCategory());
				form.getLst().add(formRow);
			}
		}
		session.setAttribute("PAGEIDSTORE", REGISTER_PRODUCT_CATEGORY);
		
		return SystemCommon.ADMIN_STORE;
	}
	
	/**
	 * Mean: insert MST01001
	 * 
	 */
	@RequestMapping(value="/registerProductCategory/insert", method= RequestMethod.POST)
	public String insert(@ModelAttribute("RegisterProductCategory") RegisterProductCategoryForm form, HttpSession session ){
		User userlocal = (User) session.getAttribute("userlocal");
		
		RegisterProductCategoryInputBean inputBean = new RegisterProductCategoryInputBean();
		inputBean.setIdStore(userlocal.getStore_cd());
		inputBean.setNameProductCategory(form.getNameProductCategory());
		
		ResultObject response = restTemplate.postForObject(SystemURL.REGISTER_PRODUCT_CATEGORY_INSERT, inputBean, ResultObject.class);
		
		if(response.getStatus() == Status.SUCCESS){
			RegisterProductCategoryOutputBean outputBean = restTemplate.postForObject(SystemURL.REGISTER_PRODUCT_CATEGORY_INIT, inputBean, RegisterProductCategoryOutputBean.class);
			int cnt = 1;
			
			if(outputBean != null && outputBean.getLst().size()>0){
				RegisterProductCategoryFormRow formRow;
				for(RegisterProductCategoryOutputRowBean outputRow : outputBean.getLst()){
					formRow = new RegisterProductCategoryFormRow();
					formRow.setNo(String.valueOf(cnt++));
					formRow.setIdProductCategory(outputRow.getIdProductCategory());
					formRow.setNameProductCategory(outputRow.getNameProductCategory());
					form.getLst().add(formRow);
				}
			}
			form.setMessage("Đăng kí nhóm sản phẩm thành công!");
			form.setMessageErr("");
		}else{
			form.setMessageErr("Đăng kí nhóm sản phẩm không thành công!");
			form.setMessage("");
		}
		session.setAttribute("PAGEIDSTORE", REGISTER_PRODUCT_CATEGORY);
		return SystemCommon.ADMIN_STORE;
	}
}