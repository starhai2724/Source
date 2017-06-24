package com.sms.formRows;

public class ProductFormRow {
	
	private String no;
	
	private String idSanPham;

	private String idLoaiSP;
	
	private String tenLoaiSP;

	private String tenSP;

	private String idCuaHang;

	private String giaMua= "";

	private String giaBan= "";

	private String moTa;

	private String trangThai;

	private String ngayTao;

	private String ngayChinhSua;
	
	private String giaBanKM = "";
	
	private int checked;
	
	private int index;

	public String getGiaBanKM() {
		return giaBanKM;
	}




	public int getIndex() {
		return index;
	}




	public void setIndex(int index) {
		this.index = index;
	}




	


	public int getChecked() {
		return checked;
	}




	public void setChecked(int checked) {
		this.checked = checked;
	}




	public void setGiaBanKM(String giaBanKM) {
		this.giaBanKM = giaBanKM;
	}


	public String getIdSanPham() {
		return idSanPham;
	}
	

	public String getNo() {
		return no;
	}


	@Override
	public String toString() {
		return "ProductFormRow [no=" + no + ", idSanPham=" + idSanPham + ", idLoaiSP=" + idLoaiSP + ", tenLoaiSP="
				+ tenLoaiSP + ", tenSP=" + tenSP + ", idCuaHang=" + idCuaHang + ", giaMua=" + giaMua + ", giaBan="
				+ giaBan + ", moTa=" + moTa + ", trangThai=" + trangThai + ", ngayTao=" + ngayTao + ", ngayChinhSua="
				+ ngayChinhSua + ", giaBanKM=" + giaBanKM + "]";
	}


	public void setNo(String no) {
		this.no = no;
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

	public String getTenLoaiSP() {
		return tenLoaiSP;
	}

	public void setTenLoaiSP(String tenLoaiSP) {
		this.tenLoaiSP = tenLoaiSP;
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
