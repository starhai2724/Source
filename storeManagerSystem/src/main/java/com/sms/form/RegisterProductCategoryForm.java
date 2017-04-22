package com.sms.form;

import java.util.ArrayList;
import java.util.List;

import com.sms.formRows.RegisterProductCategoryFormRow;

public class RegisterProductCategoryForm extends AbstractForm {

	private String idProductCategory;

	private String nameProductCategory;

	private List<RegisterProductCategoryFormRow> lst = new ArrayList<>();

	public String getIdProductCategory() {
		return idProductCategory;
	}

	public void setIdProductCategory(String idProductCategory) {
		this.idProductCategory = idProductCategory;
	}

	public String getNameProductCategory() {
		return nameProductCategory;
	}

	public void setNameProductCategory(String nameProductCategory) {
		this.nameProductCategory = nameProductCategory;
	}

	public List<RegisterProductCategoryFormRow> getLst() {
		return lst;
	}

	public void setLst(List<RegisterProductCategoryFormRow> lst) {
		this.lst = lst;
	}

}
