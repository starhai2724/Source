package com.sms.test;

import com.sms.Controller.RegisterProductCategoryCtrl;
import com.sms.Controller.StoreOwnerController;
import com.sms.inputs.RegisterProductCategoryInputBean;

public class Run_Server {

	
	public static void main(String[] args) {
	
		
		RegisterProductCategoryCtrl categoryCtrl = new RegisterProductCategoryCtrl();
		RegisterProductCategoryInputBean inBean = new RegisterProductCategoryInputBean();
		
		inBean.setIdStore("123456");
		inBean.setNameProductCategory("abc");
		categoryCtrl.insertProductCategory(inBean);
	}
}
