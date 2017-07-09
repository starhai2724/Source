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
	
	private String dkGiaoHangFree;
	
	private byte[]  hinhHeader;
	private byte[]  hinhHeader1;
	private byte[]  hinhHeader2;
	private byte[]  hinhHeader3;
	private byte[]  hinhHeader4;
	private byte[]  hinhHeader5;
	
	private List<LoaiKinhDoanhForm> lstLoaiKinhDoanh = new ArrayList<>();

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

	public String getDkGiaoHangFree() {
		return dkGiaoHangFree;
	}

	public void setDkGiaoHangFree(String dkGiaoHangFree) {
		this.dkGiaoHangFree = dkGiaoHangFree;
	}

	public byte[] getHinhHeader() {
		return hinhHeader;
	}

	public void setHinhHeader(byte[] hinhHeader) {
		this.hinhHeader = hinhHeader;
	}

	public byte[] getHinhHeader1() {
		return hinhHeader1;
	}

	public void setHinhHeader1(byte[] hinhHeader1) {
		this.hinhHeader1 = hinhHeader1;
	}

	public byte[] getHinhHeader2() {
		return hinhHeader2;
	}

	public void setHinhHeader2(byte[] hinhHeader2) {
		this.hinhHeader2 = hinhHeader2;
	}

	public byte[] getHinhHeader3() {
		return hinhHeader3;
	}

	public void setHinhHeader3(byte[] hinhHeader3) {
		this.hinhHeader3 = hinhHeader3;
	}

	public byte[] getHinhHeader4() {
		return hinhHeader4;
	}

	public void setHinhHeader4(byte[] hinhHeader4) {
		this.hinhHeader4 = hinhHeader4;
	}

	public byte[] getHinhHeader5() {
		return hinhHeader5;
	}

	public void setHinhHeader5(byte[] hinhHeader5) {
		this.hinhHeader5 = hinhHeader5;
	}

	public List<LoaiKinhDoanhForm> getLstLoaiKinhDoanh() {
		return lstLoaiKinhDoanh;
	}

	public void setLstLoaiKinhDoanh(List<LoaiKinhDoanhForm> lstLoaiKinhDoanh) {
		this.lstLoaiKinhDoanh = lstLoaiKinhDoanh;
	}
	

	
}
