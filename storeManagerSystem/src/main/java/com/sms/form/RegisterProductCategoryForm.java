package com.sms.form;

import java.util.ArrayList;
import java.util.List;

import com.sms.formRows.RegisterProductCategoryFormRow;

public class RegisterProductCategoryForm extends AbstractForm {

	private String idProductCategory;

	private String nameProductCategory;
	
	private String flagUpdate;
	
	private List<RegisterProductCategoryFormRow> lst = new ArrayList<>();
	
	private List<RegisterProductCategoryFormRow> lstLSP = new ArrayList<>();

	private String checkShow = "";
	private String tenLoaiSP;
	private String idLoaiSP;

	private String flagUpdate_LSP;
	
	public String getIdLoaiSP() {
		return idLoaiSP;
	}

	public void setIdLoaiSP(String idLoaiSP) {
		this.idLoaiSP = idLoaiSP;
	}

	public String getFlagUpdate_LSP() {
		return flagUpdate_LSP;
	}

	public void setFlagUpdate_LSP(String flagUpdate_LSP) {
		this.flagUpdate_LSP = flagUpdate_LSP;
	}

	public String getTenLoaiSP() {
		return tenLoaiSP;
	}

	public void setTenLoaiSP(String tenLoaiSP) {
		this.tenLoaiSP = tenLoaiSP;
	}

	public String getCheckShow() {
		return checkShow;
	}

	public void setCheckShow(String checkShow) {
		this.checkShow = checkShow;
	}

	public List<RegisterProductCategoryFormRow> getLstLSP() {
		return lstLSP;
	}

	public void setLstLSP(List<RegisterProductCategoryFormRow> lstLSP) {
		this.lstLSP = lstLSP;
	}
	public String getFlagUpdate() {
		return flagUpdate;
	}

	public void setFlagUpdate(String flagUpdate) {
		this.flagUpdate = flagUpdate;
	}

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
