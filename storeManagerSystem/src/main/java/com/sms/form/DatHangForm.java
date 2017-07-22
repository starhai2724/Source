package com.sms.form;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.sms.formRows.ChiTietDatHangRowForm;
import com.sms.formRows.DatHangRowForm;

public class DatHangForm extends AbstractForm{
	
	private String flagUpdate;
	
	private String idDatHang;
	
	//dung cho quan ly dat hang o he thong (S)
	private String cuaHang;
	
	private String trangThai;
	
	private Map<String, String> loaiTrangThai = new LinkedHashMap<String, String>();
	
	private Map<String, String> danhSachCuaHang = new LinkedHashMap<String, String>();
	//dung cho quan ly dat hang o he thong (E)

	private List<DatHangRowForm> datHangRowForms = new ArrayList<>();
	
	private List<ChiTietDatHangRowForm> chiTietDatHangRowForms = new ArrayList<>();

	
	
	public Map<String, String> getLoaiTrangThai() {
		return loaiTrangThai;
	}

	public void setLoaiTrangThai(Map<String, String> loaiTrangThai) {
		this.loaiTrangThai = loaiTrangThai;
	}

	public Map<String, String> getDanhSachCuaHang() {
		return danhSachCuaHang;
	}

	public void setDanhSachCuaHang(Map<String, String> danhSachCuaHang) {
		this.danhSachCuaHang = danhSachCuaHang;
	}

	public String getCuaHang() {
		return cuaHang;
	}

	public void setCuaHang(String cuaHang) {
		this.cuaHang = cuaHang;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public List<DatHangRowForm> getDatHangRowForms() {
		return datHangRowForms;
	}

	public void setDatHangRowForms(List<DatHangRowForm> datHangRowForms) {
		this.datHangRowForms = datHangRowForms;
	}

	public List<ChiTietDatHangRowForm> getChiTietDatHangRowForms() {
		return chiTietDatHangRowForms;
	}

	public void setChiTietDatHangRowForms(List<ChiTietDatHangRowForm> chiTietDatHangRowForms) {
		this.chiTietDatHangRowForms = chiTietDatHangRowForms;
	}

	public String getFlagUpdate() {
		return flagUpdate;
	}

	public void setFlagUpdate(String flagUpdate) {
		this.flagUpdate = flagUpdate;
	}

	public String getIdDatHang() {
		return idDatHang;
	}

	public void setIdDatHang(String idDatHang) {
		this.idDatHang = idDatHang;
	}
	
	
}
