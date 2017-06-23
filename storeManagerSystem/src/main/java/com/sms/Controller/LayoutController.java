package com.sms.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sms.OutputRows.SanPhamOutputRowBean;
import com.sms.common.SystemCommon;
import com.sms.dao.CreateTableProductDAO;
import com.sms.dao.LayoutDAO;
import com.sms.dao.LoaiSanPhamDAO;
import com.sms.form.LayoutForm;
import com.sms.formRows.ProductFormRow;
import com.sms.formRows.RegisterProductCategoryFormRow;
import com.sms.input.LoaiSanPhamInputBean;
import com.sms.input.SanPhamInputBean;
import com.sms.output.LoaiSanPhamOutputBean;
import com.sms.output.SanPhamOutputBean;

@Controller
public class LayoutController {

	public static final String PAGE_FASHION = "fashion/fashion";
	public static final String PAGE_CART = "gioHang";
	
	@RequestMapping(value="/{path}")
	public String init(@ModelAttribute("LayoutForm") LayoutForm form, @PathVariable("path") String path){
		//check pathJSP
		if(!LayoutDAO.intances.checkPathJSP(path)){
			//quay ve trang login
			return  "redirect:/";
		}
		//get loai san pham
		LoaiSanPhamInputBean loaiSanPhamInputBean = new LoaiSanPhamInputBean();  
		loaiSanPhamInputBean.setPathJSP(path);
		List<LoaiSanPhamOutputBean> loaiSanPhamOutputBeans = LoaiSanPhamDAO.intances.getLoaiSP(loaiSanPhamInputBean);
		RegisterProductCategoryFormRow productCategoryFormRow;
		for(LoaiSanPhamOutputBean loaiSanPhamOutputBean : loaiSanPhamOutputBeans){
			productCategoryFormRow = new RegisterProductCategoryFormRow();
			productCategoryFormRow.setIdProductCategory(loaiSanPhamOutputBean.getIdLoaiSP());
			productCategoryFormRow.setNameProductCategory(loaiSanPhamOutputBean.getTenLoaiSP());
			form.getLoaiSanPham().add(productCategoryFormRow);
		}
		
		//get san pham 
		SanPhamInputBean sanPhamInputBean = new SanPhamInputBean();
		sanPhamInputBean.setPathJSP(path);
		SanPhamOutputBean sanPhamOutputBean = CreateTableProductDAO.intances.getProducts(path);
		ProductFormRow productFormRow;
		for(SanPhamOutputRowBean sanPhamOutputRowBean : sanPhamOutputBean.getLst() ){
			productFormRow = new ProductFormRow();
			productFormRow.setIdSanPham(sanPhamOutputRowBean.getIdSanPham());
			productFormRow.setTenSP(sanPhamOutputRowBean.getTenSP());
			productFormRow.setTenLoaiSP(sanPhamOutputRowBean.getTenLoaiSP());
			productFormRow.setGiaMua(sanPhamOutputRowBean.getGiaMua());
			productFormRow.setGiaBan(sanPhamOutputRowBean.getGiaBan());
			productFormRow.setNgayTao(sanPhamOutputRowBean.getNgayTao());
			productFormRow.setNgayChinhSua(sanPhamOutputRowBean.getNgayChinhSua());
			productFormRow.setMoTa(sanPhamOutputRowBean.getMoTa());
			form.getProducts().add(productFormRow);
		}
			form.setPathJSP(path);
			form.setCartPrice("0");
			form.setCartQuantity("0");
		return PAGE_FASHION;
	}
	
	@RequestMapping(value="/{path}/gioHang/{list}")
	public String giohang(@ModelAttribute("LayoutForm") LayoutForm form, @PathVariable("path") String path, @PathVariable("list") String listId){
		
		//get loai san pham
		LoaiSanPhamInputBean loaiSanPhamInputBean = new LoaiSanPhamInputBean();  
		loaiSanPhamInputBean.setPathJSP(path);
		List<LoaiSanPhamOutputBean> loaiSanPhamOutputBeans = LoaiSanPhamDAO.intances.getLoaiSP(loaiSanPhamInputBean);
		RegisterProductCategoryFormRow productCategoryFormRow;
		for(LoaiSanPhamOutputBean loaiSanPhamOutputBean : loaiSanPhamOutputBeans){
			productCategoryFormRow = new RegisterProductCategoryFormRow();
			productCategoryFormRow.setIdProductCategory(loaiSanPhamOutputBean.getIdLoaiSP());
			productCategoryFormRow.setNameProductCategory(loaiSanPhamOutputBean.getTenLoaiSP());
			form.getLoaiSanPham().add(productCategoryFormRow);
		}
		
		//get san pham 
		SanPhamInputBean sanPhamInputBean = new SanPhamInputBean();
		sanPhamInputBean.setPathJSP(path);
		
		//remove ","
		if(!"".equals(listId)){
			listId = listId.substring(1);
		}
		
		SanPhamOutputBean sanPhamOutputBean = CreateTableProductDAO.intances.getProductByList(path, listId);
		ProductFormRow productFormRow;
		for(SanPhamOutputRowBean sanPhamOutputRowBean : sanPhamOutputBean.getLst() ){
			productFormRow = new ProductFormRow();
			productFormRow.setIdSanPham(sanPhamOutputRowBean.getIdSanPham());
			productFormRow.setTenSP(sanPhamOutputRowBean.getTenSP());
			productFormRow.setTenLoaiSP(sanPhamOutputRowBean.getTenLoaiSP());
			productFormRow.setGiaMua(sanPhamOutputRowBean.getGiaMua());
			productFormRow.setGiaBan(sanPhamOutputRowBean.getGiaBan());
			productFormRow.setNgayTao(sanPhamOutputRowBean.getNgayTao());
			productFormRow.setNgayChinhSua(sanPhamOutputRowBean.getNgayChinhSua());
			productFormRow.setMoTa(sanPhamOutputRowBean.getMoTa());
			form.getProducts().add(productFormRow);
		}
			form.setPathJSP(path);
			form.setListId(listId);
		return PAGE_CART;
	}
}
