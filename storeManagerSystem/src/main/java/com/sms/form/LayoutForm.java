package com.sms.form;

import java.util.ArrayList;
import java.util.List;

import com.sms.formRows.ProductFormRow;
import com.sms.formRows.RegisterProductCategoryFormRow;

public class LayoutForm {

	private String pathJSP;

	private String tenCuaHang;
	
	private String soDienThoai;
	
	private String diaChi;
	
	private List<RegisterProductCategoryFormRow>  loaiSanPham = new ArrayList<>();

	private List<ProductFormRow> products = new ArrayList<>();
	
	//Gio hang (S)
	private String cartPrice;
	
	private String cartQuantity;
	
	private String listId;
	
	//Gio hang (E)
	
	
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
