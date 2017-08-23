package com.sms.output;

import java.util.ArrayList;
import java.util.List;
import com.sms.OutputRows.ThoiHanSuDungOutputRowBean;

public class ThoiHanSuDungOutputBean {
	
	private List<ThoiHanSuDungOutputRowBean> lst = new ArrayList<>();

	public List<ThoiHanSuDungOutputRowBean> getLst() {
		return lst;
	}

	public void setLst(List<ThoiHanSuDungOutputRowBean> lst) {
		this.lst = lst;
	}
	
}
