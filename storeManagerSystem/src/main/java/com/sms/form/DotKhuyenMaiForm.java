package com.sms.form;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.sms.formRows.DotKhuyenMaiRowForm;

public class DotKhuyenMaiForm {

	private String maDKM;
	
	private String tenDKM = "";

	private String mucKM = "";

	private String ngayBD = "";

	private String ngayKT = "";
	
	private String donViKM = "";

	private String mucGiamGia = "";

	private String dk_loaiThe = "";
	
	private String loaiKM = "";

	private String dk_tongHD = "";

	private String dk_tongSL = "";
	
	// Disable item when mode update
	private String disabledFlag = "";

	private String flagUpdate = "";
	
	private String message = "";
	
	private String messageErr = "";
	
	private List<DotKhuyenMaiRowForm> lst = new ArrayList<>();
	
	private Map<String, String> lst_donViKM = new LinkedHashMap<String, String>(); 
	
	private Map<String, String> lst_dk_loaiThe = new LinkedHashMap<String, String>(); 
	
	private Map<String, String> lst_loaiKM = new LinkedHashMap<String, String>();
	
	public String getMaDKM() {
		return maDKM;
	}
	public void setMaDKM(String maDKM) {
		this.maDKM = maDKM;
	}
	public String getTenDKM() {
		return tenDKM;
	}
	public void setTenDKM(String tenDKM) {
		this.tenDKM = tenDKM;
	}
	public List<DotKhuyenMaiRowForm> getLst() {
		return lst;
	}
	public void setLst(List<DotKhuyenMaiRowForm> lst) {
		this.lst = lst;
	}
	public String getMucKM() {
		return mucKM;
	}
	public void setMucKM(String mucKM) {
		this.mucKM = mucKM;
	}
	public String getNgayBD() {
		return ngayBD;
	}
	public void setNgayBD(String ngayBD) {
		this.ngayBD = ngayBD;
	}
	public String getNgayKT() {
		return ngayKT;
	}
	public void setNgayKT(String ngayKT) {
		this.ngayKT = ngayKT;
	}
	public String getDonViKM() {
		return donViKM;
	}
	public void setDonViKM(String donViKM) {
		this.donViKM = donViKM;
	}
	public String getMucGiamGia() {
		return mucGiamGia;
	}
	public void setMucGiamGia(String mucGiamGia) {
		this.mucGiamGia = mucGiamGia;
	}
	public String getDk_loaiThe() {
		return dk_loaiThe;
	}
	public void setDk_loaiThe(String dk_loaiThe) {
		this.dk_loaiThe = dk_loaiThe;
	}
	public String getLoaiKM() {
		return loaiKM;
	}
	public void setLoaiKM(String loaiKM) {
		this.loaiKM = loaiKM;
	}
	public String getDk_tongHD() {
		return dk_tongHD;
	}
	public void setDk_tongHD(String dk_tongHD) {
		this.dk_tongHD = dk_tongHD;
	}
	public String getDk_tongSL() {
		return dk_tongSL;
	}
	public void setDk_tongSL(String dk_tongSL) {
		this.dk_tongSL = dk_tongSL;
	}
	public String getDisabledFlag() {
		return disabledFlag;
	}
	public void setDisabledFlag(String disabledFlag) {
		this.disabledFlag = disabledFlag;
	}
	public String getFlagUpdate() {
		return flagUpdate;
	}
	public void setFlagUpdate(String updateFlag) {
		this.flagUpdate = updateFlag;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessageErr() {
		return messageErr;
	}
	public void setMessageErr(String messageErr) {
		this.messageErr = messageErr;
	}
	public Map<String, String> getLst_donViKM() {
		return lst_donViKM;
	}
	public void setLst_donViKM(Map<String, String> lst_donViKM) {
		this.lst_donViKM = lst_donViKM;
	}
	public Map<String, String> getLst_dk_loaiThe() {
		return lst_dk_loaiThe;
	}
	public void setLst_dk_loaiThe(Map<String, String> lst_dk_loaiThe) {
		this.lst_dk_loaiThe = lst_dk_loaiThe;
	}
	public Map<String, String> getLst_loaiKM() {
		return lst_loaiKM;
	}
	public void setLst_loaiKM(Map<String, String> lst_loaiKM) {
		this.lst_loaiKM = lst_loaiKM;
	} 

	
}
