package com.sms.form;

import java.util.ArrayList;
import java.util.List;

import com.sms.formRows.HoaDonRowForm;

public class HoaDonForm extends AbstractForm{
	
	private String idHoaDon;
	
	private String idKhachHang;

	private String ngayLap;
	
	private String soLuongSP;

	private String diemTichLuy;

	private String tongDiemTichLuy;

	private String tienKhuyenMai;
	
	private String tongTien;
	
	private String flagUpdate;
	
	private List<HoaDonRowForm> lst = new ArrayList<>();

	public String getIdKhachHang() {
		return idKhachHang;
	}

	public void setIdKhachHang(String idKhachHang) {
		this.idKhachHang = idKhachHang;
	}

	public String getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(String ngayLap) {
		this.ngayLap = ngayLap;
	}

	public String getSoLuongSP() {
		return soLuongSP;
	}

	public void setSoLuongSP(String soLuongSP) {
		this.soLuongSP = soLuongSP;
	}

	public String getDiemTichLuy() {
		return diemTichLuy;
	}

	public void setDiemTichLuy(String diemTichLuy) {
		this.diemTichLuy = diemTichLuy;
	}


	public String getIdHoaDon() {
		return idHoaDon;
	}

	public void setIdHoaDon(String idHoaDon) {
		this.idHoaDon = idHoaDon;
	}

	public String getTongDiemTichLuy() {
		return tongDiemTichLuy;
	}

	public void setTongDiemTichLuy(String tongDiemTichLuy) {
		this.tongDiemTichLuy = tongDiemTichLuy;
	}

	public String getTienKhuyenMai() {
		return tienKhuyenMai;
	}

	public void setTienKhuyenMai(String tienKhuyenMai) {
		this.tienKhuyenMai = tienKhuyenMai;
	}

	public String getTongTien() {
		return tongTien;
	}

	public void setTongTien(String tongTien) {
		this.tongTien = tongTien;
	}

	public String getFlagUpdate() {
		return flagUpdate;
	}

	public void setFlagUpdate(String flagUpdate) {
		this.flagUpdate = flagUpdate;
	}

	public List<HoaDonRowForm> getLst() {
		return lst;
	}

	public void setLst(List<HoaDonRowForm> lst) {
		this.lst = lst;
	}

	
	
}
