package com.sms.output;

import java.util.ArrayList;
import java.util.List;

import com.sms.OutputRows.SanPhamOutputRowBean;


public class SanPhamOutputBean {

	List<SanPhamOutputRowBean> lst = new ArrayList<>();

	public List<SanPhamOutputRowBean> getLst() {
		return lst;
	}

	public void setLst(List<SanPhamOutputRowBean> lst) {
		this.lst = lst;
	}
	
}
