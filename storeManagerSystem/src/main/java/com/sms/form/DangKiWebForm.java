package com.sms.form;

import java.util.ArrayList;
import java.util.List;

public class DangKiWebForm extends AbstractForm {

	private String tenWebSite;

	private String idCuaHang;

	private String pathJSP;

	private String email;

	private String matKhau;

	private String quyen;

	private String sdt;

	private String diaChi;

	private String loaiKinhDoanh;

	private String maXacNhan;
	
	private List<LoaiKinhDoanhForm> lstLoaiKinhDoanh = new ArrayList<>();
	

	public List<LoaiKinhDoanhForm> getLstLoaiKinhDoanh() {
		return lstLoaiKinhDoanh;
	}

	public void setLstLoaiKinhDoanh(List<LoaiKinhDoanhForm> lstLoaiKinhDoanh) {
		this.lstLoaiKinhDoanh = lstLoaiKinhDoanh;
	}

	public String getTenWebSite() {
		return tenWebSite;
	}

	public void setTenWebSite(String tenWebSite) {
		this.tenWebSite = tenWebSite;
	}

	public String getIdCuaHang() {
		return idCuaHang;
	}

	public void setIdCuaHang(String idCuaHang) {
		this.idCuaHang = idCuaHang;
	}

	public String getPathJSP() {
		return pathJSP;
	}

	public void setPathJSP(String pathJSP) {
		this.pathJSP = pathJSP;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getQuyen() {
		return quyen;
	}

	public void setQuyen(String quyen) {
		this.quyen = quyen;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getLoaiKinhDoanh() {
		return loaiKinhDoanh;
	}

	public void setLoaiKinhDoanh(String loaiKinhDoanh) {
		this.loaiKinhDoanh = loaiKinhDoanh;
	}

	public String getMaXacNhan() {
		return maXacNhan;
	}

	public void setMaXacNhan(String maXacNhan) {
		this.maXacNhan = maXacNhan;
	}

}
