package com.sms.session;

public class KhachHangSession {

	private String pathJSP;
	
	private String idKhachHang;

	private String tenKhachHang;

	private String sdt;
	
	private String diemTichLuy;
	
	private String loaiThe;
	
	
	
	public String getDiemTichLuy() {
		return diemTichLuy;
	}

	public String getLoaiThe() {
		return loaiThe;
	}

	public void setLoaiThe(String loaiThe) {
		this.loaiThe = loaiThe;
	}

	public void setDiemTichLuy(String diemTichLuy) {
		this.diemTichLuy = diemTichLuy;
	}

	public String getPathJSP() {
		return pathJSP;
	}

	public void setPathJSP(String pathJSP) {
		this.pathJSP = pathJSP;
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

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

}
