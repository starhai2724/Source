package com.sms.form;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.sms.formRows.KhachHangRowForm;

public class KhachHangForm extends AbstractForm{

	private String idKhachHang;

	private String tenKhachHang;
	
	private String gioiTinh;

	private String soDienThoai;

	private String loaiThe;
	
	private String diaChi;
	
	private String soDiem;

	private String ngaySinh;

	private String ngayTao;

	private String ngaySua;

	private String trangThai;
	
	private String flagUpdate;
	
	private Map<String, String> lstGioiTinh = new LinkedHashMap<String, String>(); 
	
	private Map<String, String> lstCards = new LinkedHashMap<String, String>(); 
	
	private List<KhachHangRowForm> lst = new ArrayList<>();
	
	
	
	public Map<String, String> getLstGioiTinh() {
		return lstGioiTinh;
	}

	public void setLstGioiTinh(Map<String, String> lstGioiTinh) {
		this.lstGioiTinh = lstGioiTinh;
	}

	public Map<String, String> getLstCards() {
		return lstCards;
	}

	public void setLstCards(Map<String, String> lstCards) {
		this.lstCards = lstCards;
	}

	public String getFlagUpdate() {
		return flagUpdate;
	}

	public void setFlagUpdate(String flagUpdate) {
		this.flagUpdate = flagUpdate;
	}

	public List<KhachHangRowForm> getLst() {
		return lst;
	}

	public void setLst(List<KhachHangRowForm> lst) {
		this.lst = lst;
	}

	public String getIdKhachHang() {
		return idKhachHang;
	}

	public void setIdKhachHang(String idKhachHang) {
		this.idKhachHang = idKhachHang;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getLoaiThe() {
		return loaiThe;
	}

	public void setLoaiThe(String loaiThe) {
		this.loaiThe = loaiThe;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDiem() {
		return soDiem;
	}

	public void setSoDiem(String soDiem) {
		this.soDiem = soDiem;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getNgayTao() {
		return ngayTao;
	}

	public void setNgayTao(String ngayTao) {
		this.ngayTao = ngayTao;
	}

	public String getNgaySua() {
		return ngaySua;
	}

	public void setNgaySua(String ngaySua) {
		this.ngaySua = ngaySua;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	
	
	
}
