package com.sms.form;

import java.util.ArrayList;
import java.util.List;

import com.sms.formRows.ProductFormRow;
import com.sms.formRows.RegisterProductCategoryFormRow;

public class LayoutForm extends AbstractForm {

	private String pathJSP;

	private String tenCuaHang;

	private String soDienThoai;

	private String diaChi;
	
	private String timKiem_TenSP;

	private List<RegisterProductCategoryFormRow> loaiSanPham = new ArrayList<>();

	private List<ProductFormRow> products = new ArrayList<>();

	// Gio hang (S)
	private String cartPrice;

	private String cartQuantity;

	private String listId;
	
	private String tongDonHang;
	
	private String tongTienGiamGia;
	
	private String tongThanhTien;
	
	// Gio hang (E)

	private String tenKhachHang;

	// T/h khach hang chua dang nhap thi dung sdt de tao hoa don sp (S)
	private String sdtKhachHang;
	
	private String checkDangNhap ;
	
	private String hoTenKhachHang;
	
	private String emailKhachHang;
	
	private String diaChiKhachHang;
	
	
	// T/h khach hang chua dang nhap thi dung sdt de tao hoa don sp (E)

	
	public String getSdtKhachHang() {
		return sdtKhachHang;
	}

	public String getTimKiem_TenSP() {
		return timKiem_TenSP;
	}

	public void setTimKiem_TenSP(String timKiem_TenSP) {
		this.timKiem_TenSP = timKiem_TenSP;
	}

	public String getHoTenKhachHang() {
		return hoTenKhachHang;
	}

	public void setHoTenKhachHang(String hoTenKhachHang) {
		this.hoTenKhachHang = hoTenKhachHang;
	}

	public String getEmailKhachHang() {
		return emailKhachHang;
	}

	public void setEmailKhachHang(String emailKhachHang) {
		this.emailKhachHang = emailKhachHang;
	}

	public String getDiaChiKhachHang() {
		return diaChiKhachHang;
	}

	public void setDiaChiKhachHang(String diaChiKhachHang) {
		this.diaChiKhachHang = diaChiKhachHang;
	}

	public String getTongDonHang() {
		return tongDonHang;
	}

	public void setTongDonHang(String tongDonHang) {
		this.tongDonHang = tongDonHang;
	}

	public String getTongTienGiamGia() {
		return tongTienGiamGia;
	}

	public void setTongTienGiamGia(String tongTienGiamGia) {
		this.tongTienGiamGia = tongTienGiamGia;
	}

	public String getTongThanhTien() {
		return tongThanhTien;
	}

	public void setTongThanhTien(String tongThanhTien) {
		this.tongThanhTien = tongThanhTien;
	}

	public String getCheckDangNhap() {
		return checkDangNhap;
	}

	public void setCheckDangNhap(String checkDangNhap) {
		this.checkDangNhap = checkDangNhap;
	}

	public void setSdtKhachHang(String sdtKhachHang) {
		this.sdtKhachHang = sdtKhachHang;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public List<ProductFormRow> getProducts() {
		return products;
	}

	public String getCartPrice() {
		return cartPrice;
	}

	public void setCartPrice(String cartPrice) {
		this.cartPrice = cartPrice;
	}

	public String getCartQuantity() {
		return cartQuantity;
	}

	public void setCartQuantity(String cartQuantity) {
		this.cartQuantity = cartQuantity;
	}

	public String getListId() {
		return listId;
	}

	public void setListId(String listId) {
		this.listId = listId;
	}

	public void setProducts(List<ProductFormRow> products) {
		this.products = products;
	}

	public String getPathJSP() {
		return pathJSP;
	}

	public void setPathJSP(String pathJSP) {
		this.pathJSP = pathJSP;
	}

	public String getTenCuaHang() {
		return tenCuaHang;
	}

	public void setTenCuaHang(String tenCuaHang) {
		this.tenCuaHang = tenCuaHang;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public List<RegisterProductCategoryFormRow> getLoaiSanPham() {
		return loaiSanPham;
	}

	public void setLoaiSanPham(List<RegisterProductCategoryFormRow> loaiSanPham) {
		this.loaiSanPham = loaiSanPham;
	}

}
