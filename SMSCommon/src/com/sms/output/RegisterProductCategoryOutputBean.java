package com.sms.output;

import java.util.ArrayList;
import java.util.List;

import com.sms.OutputRows.RegisterProductCategoryOutputRowBean;

public class RegisterProductCategoryOutputBean {
	
	List<RegisterProductCategoryOutputRowBean> lst = new ArrayList<>();

	public List<RegisterProductCategoryOutputRowBean> getLst() {
		return lst;
	}

	public void setLst(List<RegisterProductCategoryOutputRowBean> lst) {
		this.lst = lst;
	}
	
}
