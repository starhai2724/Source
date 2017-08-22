package com.sms.form;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.sms.formRows.ProductFormRow;

public class ProductForm extends AbstractForm{

	private String pathJSP;
	
	private String SEQ;

	private String idSanPham;

	private String idLoaiSP;

	private String tenLoaiSP;

	private String tenSP;

	private String idCuaHang;

	private String giaMua;

	private String giaBan;
	
	private String giaBanKM;

	private File  hinh;
	
	private File  hinhChiTiet1;
	
	private File  hinhChiTiet2;
	
	private File  hinhChiTiet3;

	private String moTa;
	
	private String trangThai;

	private String ngayTao;

	private String ngayChinhSua;
	
	private String flagUpdate;
	
	private Map<String, String> lstCategory = new LinkedHashMap<String, String>();
	
	public File getHinhChiTiet1() {
		return hinhChiTiet1;
	}

	public void setHinhChiTiet1(File hinhChiTiet1) {
		this.hinhChiTiet1 = hinhChiTiet1;
	}

	public File getHinhChiTiet2() {
		return hinhChiTiet2;
	}

	public void setHinhChiTiet2(File hinhChiTiet2) {
		this.hinhChiTiet2 = hinhChiTiet2;
	}

	public File getHinhChiTiet3() {
		return hinhChiTiet3;
	}

	public void setHinhChiTiet3(File hinhChiTiet3) {
		this.hinhChiTiet3 = hinhChiTiet3;
	}

	public String getSEQ() {
		return SEQ;
	}

	public void setSEQ(String sEQ) {
		SEQ = sEQ;
	}

	public String getGiaBanKM() {
		return giaBanKM;
	}

	public void setGiaBanKM(String giaBanKM) {
		this.giaBanKM = giaBanKM;
	}

	public String getFlagUpdate() {
		return flagUpdate;
	}

	public void setFlagUpdate(String flagUpdate) {
		this.flagUpdate = flagUpdate;
	}

	
	
	public Map<String, String> getLstCategory() {
		return lstCategory;
	}

	public void setLstCategory(Map<String, String> lstCategory) {
		this.lstCategory = lstCategory;
	}

	public String getTenLoaiSP() {
		return tenLoaiSP;
	}

	public void setTenLoaiSP(String tenLoaiSP) {
		this.tenLoaiSP = tenLoaiSP;
	}

	private List<ProductFormRow> lst = new ArrayList<>();
	// su dung de phan anh san pham (S)
	private List<ProductFormRow> lstSanPham = new ArrayList<>();
	// su dung de phan anh san pham (E)

	public List<ProductFormRow> getLst() {
		return lst;
	}

	public List<ProductFormRow> getLstSanPham() {
		return lstSanPham;
	}

	public void setLstSanPham(List<ProductFormRow> lstSanPham) {
		this.lstSanPham = lstSanPham;
	}

	public void setLst(List<ProductFormRow> lst) {
		this.lst = lst;
	}

	public String getPathJSP() {
		return pathJSP;
	}

	public void setPathJSP(String pathJSP) {
		this.pathJSP = pathJSP;
	}

	public String getIdSanPham() {
		return idSanPham;
	}

	public void setIdSanPham(String idSanPham) {
		this.idSanPham = idSanPham;
	}

	public String getIdLoaiSP() {
		return idLoaiSP;
	}

	public void setIdLoaiSP(String idLoaiSP) {
		this.idLoaiSP = idLoaiSP;
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



	public File getHinh() {
		return hinh;
	}

	public void setHinh(File hinh) {
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

	public void setNgayChinhSua(String ngayChinhSua) {
		this.ngayChinhSua = ngayChinhSua;
	}

}
