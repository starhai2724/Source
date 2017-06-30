package com.sms.OutputRows;

import java.util.Arrays;

public class SanPhamOutputRowBean {

	private String no;
	
	private String SEQ;
	
	private String pathJSP;

	private String idSanPham;

	private String idLoaiSP;
	
	private String tenLoaiSP;
	
	private String tenSP;

	private String idCuaHang;

	private String giaMua;

	private String giaBan;

	private byte[] hinh;

	private String moTa;

	private String trangThai;

	private String ngayTao;

	private String ngayChinhSua;
	
	private String id_DKM;
	
	private String giaBanKM;
	
	
	public String getSEQ() {
		return SEQ;
	}

	public void setSEQ(String sEQ) {
		SEQ = sEQ;
	}

	public String getId_DKM() {
		return id_DKM;
	}

	public void setId_DKM(String id_DKM) {
		this.id_DKM = id_DKM;
	}

	public String getGiaBanKM() {
		return giaBanKM;
	}

	public void setGiaBanKM(String giaBanKM) {
		this.giaBanKM = giaBanKM;
	}

	public String getIdSanPham() {
		return idSanPham;
	}

	public void setIdSanPham(String idSanPham) {
		this.idSanPham = idSanPham;
	}

	@Override
	public String toString() {
		return "SanPhamOutputRowBean [no=" + no + ", pathJSP=" + pathJSP + ", idSanPham=" + idSanPham + ", idLoaiSP="
				+ idLoaiSP + ", tenLoaiSP=" + tenLoaiSP + ", tenSP=" + tenSP + ", idCuaHang=" + idCuaHang + ", giaMua="
				+ giaMua + ", giaBan=" + giaBan + ", hinh=" + Arrays.toString(hinh) + ", moTa=" + moTa + ", trangThai="
				+ trangThai + ", ngayTao=" + ngayTao + ", ngayChinhSua=" + ngayChinhSua + ", id_DKM=" + id_DKM
				+ ", giaBanKM=" + giaBanKM + "]";
	}

	public String getTenSP() {
		return tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public String getIdCuaHang() {
		return idCuaHang;
	}

	public void setIdCuaHang(String idCuaHang) {
		this.idCuaHang = idCuaHang;
	}

	public String getGiaMua() {
		return giaMua;
	}

	public void setGiaMua(String giaMua) {
		this.giaMua = giaMua;
	}

	public String getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(String giaBan) {
		this.giaBan = giaBan;
	}

	public byte[] getHinh() {
		return hinh;
	}

	public void setHinh(byte[] hinh) {
		this.hinh = hinh;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public String getNgayTao() {
		return ngayTao;
	}

	public void setNgayTao(String ngayTao) {
		this.ngayTao = ngayTao;
	}

	public String getNgayChinhSua() {
		return ngayChinhSua;
	}
	

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public void setNgayChinhSua(String ngayChinhSua) {
		this.ngayChinhSua = ngayChinhSua;
	}

	public String getPathJSP() {
		return pathJSP;
	}

	public void setPathJSP(String pathJSP) {
		this.pathJSP = pathJSP;
	}

	public String getIdLoaiSP() {
		return idLoaiSP;
	}

	public void setIdLoaiSP(String idLoaiSP) {
		this.idLoaiSP = idLoaiSP;
	}

	public String getTenLoaiSP() {
		return tenLoaiSP;
	}

	public void setTenLoaiSP(String tenLoaiSP) {
		this.tenLoaiSP = tenLoaiSP;
	}

}
