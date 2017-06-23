package com.sms.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sms.OutputRows.SanPhamOutputRowBean;
import com.sms.dao.CreateTableProductDAO;
import com.sms.dao.LayoutDAO;
import com.sms.form.LayoutForm;
import com.sms.formRows.ProductFormRow;
import com.sms.output.SanPhamOutputBean;

public class ThanhToanController {

	
	@RequestMapping(value="/{path}/thanhToan/{list}")
	public String thanhToan(@ModelAttribute("LayoutForm") LayoutForm form, @PathVariable("path") String path, @PathVariable("list") String listId){
		//check pathJSP
		if(!LayoutDAO.intances.checkPathJSP(path)){
			//quay ve trang login
			return  "redirect:/";
		}
		
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
		
		
		return "";
	}
}
