package com.sms.form;

import java.util.ArrayList;
import java.util.List;

public class ThoiHanSuDungForm extends AbstractForm {

	private List<ThoiHanSuDungRowForm> lst = new ArrayList<ThoiHanSuDungRowForm>();

	public List<ThoiHanSuDungRowForm> getLst() {
		return lst;
	}

	public void setLst(List<ThoiHanSuDungRowForm> lst) {
		this.lst = lst;
	}
	
}
