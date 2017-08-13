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
	
	
	
	//su dung cho phan trang (S)
	
	private String indexPage;
	
//	private String count;
	//su dung cho phan trang (E)
	
	private String limit;

	private List<RegisterProductCategoryFormRow> loaiSanPham = new ArrayList<>();
	

	private List<ProductFormRow> products = new ArrayList<>();
	
	private List<ProductFormRow> products_SearchByMenu = new ArrayList<>();
	
	private List<ProductFormRow> products_SearchByBtn = new ArrayList<>();
	
	private String idTenNhomSP_Search;
	
	private String checkSearchBtn;

	// Gio hang (S)
	private String cartPrice;

	private String cartQuantity;

	private String listId;
	
	private String tongDonHang;
	
	private String tongTienGiamGia;
	
	private String tongThanhTien;
	
	private String dkGiaoHangFree;
	
	// Gio hang (E)

	private String tenKhachHang;

	// T/h khach hang chua dang nhap thi dung sdt de tao hoa don sp (S)
	private String sdtKhachHang;
	
	private String checkDangNhap ;
	
	private String hoTenKhachHang;
	
	private String emailKhachHang;
	
	private String diaChiKhachHang;
	
	
	// T/h khach hang chua dang nhap thi dung sdt de tao hoa don sp (E)
	
	private byte[]  file_1;
	
	private byte[]  file_2;
	
	private byte[]  file_3;
	
	private byte[]  file_4;
	
	private byte[]  file_5;
	
	private String linkFanpage;
	
	//Lien He (S)
	private LienHeForm lienHeForm = new LienHeForm();
	
	//Lien He (E)
	
	
	
	public LienHeForm getLienHeForm() {
		return lienHeForm;
	}

	public String getIndexPage() {
		return indexPage;
	}

	public void setIndexPage(String indexPage) {
		this.indexPage = indexPage;
	}

	public String getLimit() {
		return limit;
	}

	public void setLimit(String limit) {
		this.limit = limit;
	}

	public void setLienHeForm(LienHeForm lienHeForm) {
		this.lienHeForm = lienHeForm;
	}

	public String getLinkFanpage() {
		return linkFanpage;
	}

	public void setLinkFanpage(String linkFanpage) {
		this.linkFanpage = linkFanpage;
	}

	public byte[] getFile_1() {
		return file_1;
	}

	public void setFile_1(byte[] file_1) {
		this.file_1 = file_1;
	}

	public String getCheckSearchBtn() {
		return checkSearchBtn;
	}

	public void setCheckSearchBtn(String checkSearchBtn) {
		this.checkSearchBtn = checkSearchBtn;
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

	public List<ProductFormRow> getProducts_SearchByMenu() {
		return products_SearchByMenu;
	}

	public void setProducts_SearchByMenu(List<ProductFormRow> products_SearchByMenu) {
		this.products_SearchByMenu = products_SearchByMenu;
	}

	public List<ProductFormRow> getProducts_SearchByBtn() {
		return products_SearchByBtn;
	}

	public void setProducts_SearchByBtn(List<ProductFormRow> products_SearchByBtn) {
		this.products_SearchByBtn = products_SearchByBtn;
	}

	public String getIdTenNhomSP_Search() {
		return idTenNhomSP_Search;
	}

	public void setIdTenNhomSP_Search(String idTenNhomSP_Search) {
		this.idTenNhomSP_Search = idTenNhomSP_Search;
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

	public String getDkGiaoHangFree() {
		return dkGiaoHangFree;
	}

	public void setDkGiaoHangFree(String dkGiaoHangFree) {
		this.dkGiaoHangFree = dkGiaoHangFree;
	}

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
