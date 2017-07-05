package com.sms.output;

public class LoaiKinhDoanhOutputBean {

	private String pathJSP;
	
	private String idLoaiKinhDoanh;
	
	private String tenLoaiKinhDoanh;
	
	private byte[] hinh;
	

	public byte[] getHinh() {
		return hinh;
	}

	public void setHinh(byte[] hinh) {
		this.hinh = hinh;
	}

	public String getPathJSP() {
		return pathJSP;
	}

	public void setPathJSP(String pathJSP) {
		this.pathJSP = pathJSP;
	}

	public String getIdLoaiKinhDoanh() {
		return idLoaiKinhDoanh;
	}

	public void setIdLoaiKinhDoanh(String idLoaiKinhDoanh) {
		this.idLoaiKinhDoanh = idLoaiKinhDoanh;
	}

	public String getTenLoaiKinhDoanh() {
		return tenLoaiKinhDoanh;
	}

	public void setTenLoaiKinhDoanh(String tenLoaiKinhDoanh) {
		this.tenLoaiKinhDoanh = tenLoaiKinhDoanh;
	}
	
	
}
