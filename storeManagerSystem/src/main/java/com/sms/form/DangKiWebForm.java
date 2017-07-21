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
	
	private byte[]  hinh;
	private byte[]  file_1;
	private byte[]  file_2;
	private byte[]  file_3;
	private byte[]  file_4;
	private byte[]  file_5;
	
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

	public byte[] getHinh() {
		return hinh;
	}

	public void setHinh(byte[] hinh) {
		this.hinh = hinh;
	}

	

	public byte[] getFile_1() {
		return file_1;
	}

	public void setFile_1(byte[] file_1) {
		this.file_1 = file_1;
	}

	public byte[] getFile_2() {
		return file_2;
	}

	public void setFile_2(byte[] file_2) {
		this.file_2 = file_2;
	}

	public byte[] getFile_3() {
		return file_3;
	}

	public void setFile_3(byte[] file_3) {
		this.file_3 = file_3;
	}

	public byte[] getFile_4() {
		return file_4;
	}

	public void setFile_4(byte[] file_4) {
		this.file_4 = file_4;
	}

	public byte[] getFile_5() {
		return file_5;
	}

	public void setFile_5(byte[] file_5) {
		this.file_5 = file_5;
	}

	public List<LoaiKinhDoanhForm> getLstLoaiKinhDoanh() {
		return lstLoaiKinhDoanh;
	}

	public void setLstLoaiKinhDoanh(List<LoaiKinhDoanhForm> lstLoaiKinhDoanh) {
		this.lstLoaiKinhDoanh = lstLoaiKinhDoanh;
	}
	

	
}
