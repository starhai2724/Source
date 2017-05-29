package com.sms.form;

import java.util.ArrayList;
import java.util.List;

import com.sms.formRows.LoaiTheRowForm;

public class LoaiTheForm  extends AbstractForm{
	
	private String idLoaiThe;
	
	private String tenLoaiThe;
	
	private String diem;
	
	private String flagUpdate;
	
	private List<LoaiTheRowForm>  lst= new ArrayList<>();

	public String getIdLoaiThe() {
		return idLoaiThe;
	}

	public void setIdLoaiThe(String idLoaiThe) {
		this.idLoaiThe = idLoaiThe;
	}

	public String getTenLoaiThe() {
		return tenLoaiThe;
	}

	public void setTenLoaiThe(String tenLoaiThe) {
		this.tenLoaiThe = tenLoaiThe;
	}

	public String getDiem() {
		return diem;
	}

	public void setDiem(String diem) {
		this.diem = diem;
	}

	public String getFlagUpdate() {
		return flagUpdate;
	}

	public void setFlagUpdate(String flagUpdate) {
		this.flagUpdate = flagUpdate;
	}

	public List<LoaiTheRowForm> getLst() {
		return lst;
	}

	public void setLst(List<LoaiTheRowForm> lst) {
		this.lst = lst;
	}
	
	
	
}
