package com.sms.input;

import java.util.ArrayList;
import java.util.List;

public class DatHangInputBean {

	private String pathJSP;
	
	private String idDonHang;
	
	private String soLuong;
	
	private String trangThai;
	
	private String thanhTien;
	
	private String ngayDatHang;
	
	private String ngayNhanHang;
	
	List<ChiTietDatHangInputBean> chiTietDatHangInputBeans = new ArrayList<>();

	public String getPathJSP() {
		return pathJSP;
	}

	public void setPathJSP(String pathJSP) {
		this.pathJSP = pathJSP;
	}

	public String getIdDonHang() {
		return idDonHang;
	}

	public void setIdDonHang(String idDonHang) {
		this.idDonHang = idDonHang;
	}

	public String getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(String soLuong) {
		this.soLuong = soLuong;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public String getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(String thanhTien) {
		this.thanhTien = thanhTien;
	}

	public String getNgayDatHang() {
		return ngayDatHang;
	}

	public void setNgayDatHang(String ngayDatHang) {
		this.ngayDatHang = ngayDatHang;
	}

	public String getNgayNhanHang() {
		return ngayNhanHang;
	}

	public void setNgayNhanHang(String ngayNhanHang) {
		this.ngayNhanHang = ngayNhanHang;
	}

	public List<ChiTietDatHangInputBean> getChiTietDatHangInputBeans() {
		return chiTietDatHangInputBeans;
	}

	public void setChiTietDatHangInputBeans(List<ChiTietDatHangInputBean> chiTietDatHangInputBeans) {
		this.chiTietDatHangInputBeans = chiTietDatHangInputBeans;
	}
	
	
	
}
