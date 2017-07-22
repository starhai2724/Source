package com.sms.formRows;

import java.util.ArrayList;
import java.util.List;

public class RegisterProductCategoryFormRow {
	private String no;
	private String idProductCategory;
	private String nameProductCategory;
	
	private String no_LSP;
	private String idLSP;
	private String name_LSP;
	
	//su dung cho menu man hinh (S)
	
	private List<MenuRowForm> menuRowForms = new ArrayList<>(); 
	
	//su dung cho menu man hinh (E)
	
	

	public String getNo_LSP() {
		return no_LSP;
	}

	public List<MenuRowForm> getMenuRowForms() {
		return menuRowForms;
	}

	public void setMenuRowForms(List<MenuRowForm> menuRowForms) {
		this.menuRowForms = menuRowForms;
	}

	public void setNo_LSP(String no_LSP) {
		this.no_LSP = no_LSP;
	}

	public String getIdLSP() {
		return idLSP;
	}

	public void setIdLSP(String idLSP) {
		this.idLSP = idLSP;
	}

	public String getName_LSP() {
		return name_LSP;
	}

	public void setName_LSP(String name_LSP) {
		this.name_LSP = name_LSP;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getNameProductCategory() {
		return nameProductCategory;
	}

	public void setNameProductCategory(String nameProductCategory) {
		this.nameProductCategory = nameProductCategory;
	}

	public String getIdProductCategory() {
		return idProductCategory;
	}

	public void setIdProductCategory(String idProductCategory) {
		this.idProductCategory = idProductCategory;
	}

}
