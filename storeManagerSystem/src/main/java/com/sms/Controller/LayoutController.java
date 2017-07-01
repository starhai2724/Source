package com.sms.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sms.OutputRows.DotKhuyenMaiOutputRowBean;
import com.sms.OutputRows.SanPhamOutputRowBean;
import com.sms.common.SMSComons;
import com.sms.common.SystemCommon;
import com.sms.dao.CreateTableProductDAO;
import com.sms.dao.DotKhuyenMaiDAO;
import com.sms.dao.LayoutDAO;
import com.sms.dao.NhomSanPhamDAO;
import com.sms.form.LayoutForm;
import com.sms.formRows.ProductFormRow;
import com.sms.formRows.RegisterProductCategoryFormRow;
import com.sms.input.NhomSanPhamInputBean;
import com.sms.input.SanPhamInputBean;
import com.sms.output.NhomSanPhamOutputBean;
import com.sms.output.SanPhamOutputBean;
import com.sms.session.KhachHangSession;

@Controller
public class LayoutController {

	public static final String PAGE_FASHION = "fashion/fashion";
	public static final String PAGE_CART = "gioHang";
	
	@RequestMapping(value="/{path}")
	public String init(@ModelAttribute("LayoutForm") LayoutForm form, @PathVariable("path") String path, HttpSession session){
		ModelAndView modelAndView = new ModelAndView(PAGE_FASHION,"LayoutForm",form);
		//check pathJSP
		if(!LayoutDAO.intances.checkPathJSP(path)){
			//quay ve trang login
//			return new ModelAndView("redirect:/");
			return "redirect:/";
		}
		//set thong tin khach hang
		KhachHangSession khachHangSession = (KhachHangSession)session.getAttribute("KhachHangSession");
		if(khachHangSession != null){
			form.setTenKhachHang(khachHangSession.getTenKhachHang());
		}
		//get loai san pham
		NhomSanPhamInputBean loaiSanPhamInputBean = new NhomSanPhamInputBean();  
		loaiSanPhamInputBean.setPathJSP(path);
		List<NhomSanPhamOutputBean> loaiSanPhamOutputBeans = NhomSanPhamDAO.intances.getNhomSP(loaiSanPhamInputBean);
		RegisterProductCategoryFormRow productCategoryFormRow;
		for(NhomSanPhamOutputBean loaiSanPhamOutputBean : loaiSanPhamOutputBeans){
			productCategoryFormRow = new RegisterProductCategoryFormRow();
			productCategoryFormRow.setIdProductCategory(loaiSanPhamOutputBean.getIdNhomSP());
			productCategoryFormRow.setNameProductCategory(loaiSanPhamOutputBean.getTenNhomSP());
			form.getLoaiSanPham().add(productCategoryFormRow);
		}
		
		//get Dot KM
		List<DotKhuyenMaiOutputRowBean> listDKM = DotKhuyenMaiDAO.intances.getDotKMApDung(path, SMSComons.getDate());
//		DotKhuyenMaiOutputRowBean dotKhuyenMaiOutputRowBean= listDKM.get(0);
		
		//get san pham 
		SanPhamInputBean sanPhamInputBean = new SanPhamInputBean();
		sanPhamInputBean.setPathJSP(path);
		SanPhamOutputBean sanPhamOutputBean = CreateTableProductDAO.intances.getSanPhamApDung(path);
		ProductFormRow productFormRow;
		for(SanPhamOutputRowBean sanPhamOutputRowBean : sanPhamOutputBean.getLst()){
			productFormRow = new ProductFormRow();
			productFormRow.setSEQ(sanPhamOutputRowBean.getSEQ());
			productFormRow.setIdSanPham(sanPhamOutputRowBean.getIdSanPham());
			productFormRow.setTenSP(sanPhamOutputRowBean.getTenSP());
			productFormRow.setTenLoaiSP(sanPhamOutputRowBean.getTenLoaiSP());
			productFormRow.setGiaMua(sanPhamOutputRowBean.getGiaMua());
			productFormRow.setGiaBanKM(sanPhamOutputRowBean.getGiaBanKM());
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
	public String giohang(@ModelAttribute("LayoutForm") LayoutForm form, @PathVariable("path") String path, @PathVariable("list") String listId, HttpSession session){
		
		//get loai san pham
		NhomSanPhamInputBean loaiSanPhamInputBean = new NhomSanPhamInputBean();  
		loaiSanPhamInputBean.setPathJSP(path);
		List<NhomSanPhamOutputBean> loaiSanPhamOutputBeans = NhomSanPhamDAO.intances.getNhomSP(loaiSanPhamInputBean);
		RegisterProductCategoryFormRow productCategoryFormRow;
		for(NhomSanPhamOutputBean loaiSanPhamOutputBean : loaiSanPhamOutputBeans){
			productCategoryFormRow = new RegisterProductCategoryFormRow();
			productCategoryFormRow.setIdProductCategory(loaiSanPhamOutputBean.getIdNhomSP());
			productCategoryFormRow.setNameProductCategory(loaiSanPhamOutputBean.getTenNhomSP());
			form.getLoaiSanPham().add(productCategoryFormRow);
		}
		// T/h chua chon san pham de thanh toan
		if("0".equals(listId)){
			form.setMessage("");
			form.setMessageErr("Chưa có sản phẩm để thực hiện thanh toán.");
			return PAGE_CART;
		}
		
		KhachHangSession khachHangSession = (KhachHangSession) session.getAttribute("KhachHangSession");

		// T/h khach hang chua dang nhap tai khoan thi yeu cau cung cap sdt
		if (khachHangSession == null) {
			form.setCheckDangNhap("1"); // t/h chua dang nhap thi set bang 1
			form.setSdtKhachHang("");
		}
		//get san pham 
		SanPhamInputBean sanPhamInputBean = new SanPhamInputBean();
		sanPhamInputBean.setPathJSP(path);
		String[] parts = null;
		//remove ","
		if(!"".equals(listId)){
			listId = listId.substring(1);
			parts = listId.split(",");
			listId = "";
			for(int i = 0;i<parts.length;i++){
				if(i < parts.length - 1 ){
					listId = listId + "'"+parts[i]+ "',";
				}else{
					listId = listId + "'"+parts[i]+ "'";
				}
			}
		}
		
		SanPhamOutputBean sanPhamOutputBean = CreateTableProductDAO.intances.getProductByList(path, listId);
		ProductFormRow productFormRow;
		for(SanPhamOutputRowBean sanPhamOutputRowBean : sanPhamOutputBean.getLst() ){
			productFormRow = new ProductFormRow();
			productFormRow.setSEQ(sanPhamOutputRowBean.getSEQ());
			productFormRow.setIdSanPham(sanPhamOutputRowBean.getIdSanPham());
			productFormRow.setTenSP(sanPhamOutputRowBean.getTenSP());
			productFormRow.setTenLoaiSP(sanPhamOutputRowBean.getTenLoaiSP());
			productFormRow.setGiaMua(sanPhamOutputRowBean.getGiaMua());
			productFormRow.setGiaBan(sanPhamOutputRowBean.getGiaBan());
			productFormRow.setGiaBanKM(sanPhamOutputRowBean.getGiaBanKM());
			System.out.println(sanPhamOutputRowBean.getGiaBan());
			System.out.println(sanPhamOutputRowBean.getGiaBanKM());
			
			productFormRow.setNgayTao(sanPhamOutputRowBean.getNgayTao());
			productFormRow.setNgayChinhSua(sanPhamOutputRowBean.getNgayChinhSua());
			productFormRow.setMoTa(sanPhamOutputRowBean.getMoTa());
			productFormRow.setSoLuong(getSoLuongSanPham(parts, sanPhamOutputRowBean.getSEQ()));
			form.getProducts().add(productFormRow);
		}
			form.setPathJSP(path);
			form.setListId(listId);
		return PAGE_CART;
	}
	
	/**
	 * 
	 * @param part
	 * @param SEQ
	 * @return
	 */
	private String getSoLuongSanPham(String part[], String SEQ){
		int cnt = 0;
		for(int i = 0; i < part.length;i++){
			if(part[i].trim().equals(SEQ)){
				cnt = cnt + 1;
			}
		}
		return String.valueOf(cnt);
		
	}
	
}
