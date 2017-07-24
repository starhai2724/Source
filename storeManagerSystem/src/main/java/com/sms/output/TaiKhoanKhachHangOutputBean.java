package com.sms.output;

public class TaiKhoanKhachHangOutputBean {
	private String idKhachHang;

	private String tenKhachHang;

	private String sdt;

	private String diemTichLuy;
	
	private String loaiThe;
	
	
	public String getLoaiThe() {
		return loaiThe;
	}

	public void setLoaiThe(String loaiThe) {
		this.loaiThe = loaiThe;
	}

	public String getDiemTichLuy() {
		return diemTichLuy;
	}

	public void setDiemTichLuy(String diemTichLuy) {
		this.diemTichLuy = diemTichLuy;
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
