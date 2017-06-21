package com.sms.form;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.sms.formRows.ProductFormRow;

public class SanPhamKMForm extends AbstractForm{

	private String pathJSP;

	private String idSanPham;

	private String idLoaiSP;

	private String tenLoaiSP;

	private String tenSP;

	private String idCuaHang;

	private String giaMua;

	private String giaBan;

	private File  hinh;

	private String moTa;

	private String trangThai;

	private String ngayTao;

	private String ngayChinhSua;
	
	private String flagUpdate;
	
	


	public String getFlagUpdate() {
		return flagUpdate;
	}

	public void setFlagUpdate(String flagUpdate) {
		this.flagUpdate = flagUpdate;
	}

	private Map<String, String> lstCategory = new LinkedHashMap<String, String>();
	
	
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

	public List<ProductFormRow> getLst() {
		return lst;
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
