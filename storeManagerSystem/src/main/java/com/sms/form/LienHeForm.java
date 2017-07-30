package com.sms.form;

import java.util.ArrayList;
import java.util.List;

import com.sms.formRows.LienHeRowForm;

public class LienHeForm extends AbstractForm{
	
	private String pathJSP;
	
	private String idLienHe;
	
	private String idKH;
	
	private String tenKH;
	
	private String diaChi;
	
	private String email;
	
	private String sdt;
	
	private String tieuDe;
	
	private String noiDungNhan;
	
	private String noiDungTraLoi;
	
	private String trangThai;
	
	private String ngayNhan;
	
	private String ngayTraLoi;
	
	private String flagUpdate;
	
	
	private List<LienHeRowForm> lst = new ArrayList<>();
	
	public List<LienHeRowForm> getLst() {
		return lst;
	}

	public void setLst(List<LienHeRowForm> lst) {
		this.lst = lst;
	}

	public String getFlagUpdate() {
		return flagUpdate;
	}

	public void setFlagUpdate(String flagUpdate) {
		this.flagUpdate = flagUpdate;
	}

	public String getPathJSP() {
		return pathJSP;
	}

	public void setPathJSP(String pathJSP) {
		this.pathJSP = pathJSP;
	}

	public String getIdLienHe() {
		return idLienHe;
	}

	public void setIdLienHe(String idLienHe) {
		this.idLienHe = idLienHe;
	}

	public String getIdKH() {
		return idKH;
	}

	public void setIdKH(String idKH) {
		this.idKH = idKH;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getTieuDe() {
		return tieuDe;
	}

	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}

	public String getNoiDungNhan() {
		return noiDungNhan;
	}

	public void setNoiDungNhan(String noiDungNhan) {
		this.noiDungNhan = noiDungNhan;
	}

	public String getNoiDungTraLoi() {
		return noiDungTraLoi;
	}

	public void setNoiDungTraLoi(String noiDungTraLoi) {
		this.noiDungTraLoi = noiDungTraLoi;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public String getNgayNhan() {
		return ngayNhan;
	}

	public void setNgayNhan(String ngayNhan) {
		this.ngayNhan = ngayNhan;
	}

	public String getNgayTraLoi() {
		return ngayTraLoi;
	}

	public void setNgayTraLoi(String ngayTraLoi) {
		this.ngayTraLoi = ngayTraLoi;
	}

}
