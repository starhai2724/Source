package com.sms.input;

public class RegisterProductCategoryInputBean {
	
	private String idStore;
	
	private String idNhomSP;

	private String tenNhomSP;
	
	private String idLoaiSP;

	private String tenLoaiSP;
	
	private String pathJSP;
	

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

	public String getPathJSP() {
		return pathJSP;
	}

	public void setPathJSP(String pathJSP) {
		this.pathJSP = pathJSP;
	}

	public String getIdNhomSP() {
		return idNhomSP;
	}

	public void setIdNhomSP(String idProductCategory) {
		this.idNhomSP = idProductCategory;
	}

	public String getTenNhomSP() {
		return tenNhomSP;
	}

	public void setTenNhomSP(String nameProductCategory) {
		this.tenNhomSP = nameProductCategory;
	}

	public String getIdStore() {
		return idStore;
	}

	public void setIdStore(String idStore) {
		this.idStore = idStore;
	}

}
