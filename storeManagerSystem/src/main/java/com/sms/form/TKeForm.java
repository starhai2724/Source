package com.sms.form;

import java.util.ArrayList;
import java.util.List;

import com.sms.formRows.ThongKeTheoThangRowForm;
import com.sms.formRows.ThongkeTheoKhachHangRowForm;
import com.sms.formRows.ThongkeTheoSanPhamRowForm;

public class TKeForm extends AbstractForm{

	private String pathJSP;
	
	private String ngayBatDau;
	
	private String ngayKetThuc;
	
	private List<ThongkeTheoSanPhamRowForm> lst = new ArrayList<>();
	
	private List<ThongkeTheoKhachHangRowForm> khachHangRowForms = new  ArrayList<>(); 
	
	private List<ThongKeTheoThangRowForm> thongKeTheoThangRowForms = new  ArrayList<>(); 
	
	
	
	public List<ThongKeTheoThangRowForm> getThongKeTheoThangRowForms() {
		return thongKeTheoThangRowForms;
	}

	public void setThongKeTheoThangRowForms(List<ThongKeTheoThangRowForm> thongKeTheoThangRowForms) {
		this.thongKeTheoThangRowForms = thongKeTheoThangRowForms;
	}

	public String getPathJSP() {
		return pathJSP;
	}

	public void setPathJSP(String pathJSP) {
		this.pathJSP = pathJSP;
	}

	public String getNgayBatDau() {
		return ngayBatDau;
	}

	public void setNgayBatDau(String ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}

	public String getNgayKetThuc() {
		return ngayKetThuc;
	}

	public void setNgayKetThuc(String ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}

	public List<ThongkeTheoSanPhamRowForm> getLst() {
		return lst;
	}

	public void setLst(List<ThongkeTheoSanPhamRowForm> lst) {
		this.lst = lst;
	}

	public List<ThongkeTheoKhachHangRowForm> getKhachHangRowForms() {
		return khachHangRowForms;
	}

	public void setKhachHangRowForms(List<ThongkeTheoKhachHangRowForm> khachHangRowForms) {
		this.khachHangRowForms = khachHangRowForms;
	}
	
	
	
}
