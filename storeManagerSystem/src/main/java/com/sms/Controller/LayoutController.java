package com.sms.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sms.OutputRows.DotKhuyenMaiOutputRowBean;
import com.sms.OutputRows.SanPhamOutputRowBean;
import com.sms.common.SMSComons;
import com.sms.dao.CreateTableProductDAO;
import com.sms.dao.DangKiWebDAO;
import com.sms.dao.DotKhuyenMaiDAO;
import com.sms.dao.LayoutDAO;
import com.sms.dao.NhomSanPhamDAO;
import com.sms.form.LayoutForm;
import com.sms.formRows.MenuRowForm;
import com.sms.formRows.ProductFormRow;
import com.sms.formRows.RegisterProductCategoryFormRow;
import com.sms.input.LoaiSanPhamInputBean;
import com.sms.input.NhomSanPhamInputBean;
import com.sms.input.SanPhamInputBean;
import com.sms.output.DangKiWebOutputBean;
import com.sms.output.LoaiSanPhamOutputBean;
import com.sms.output.NhomSanPhamOutputBean;
import com.sms.output.SanPhamOutputBean;
import com.sms.session.KhachHangSession;

@Controller
public class LayoutController {

	public static final String PAGE_CART = "gioHang";
	public static final String LIENHE = "template_2/lienhe";
	public static final String TINTUC = "template_2/tinTuc";
	public static final String GIOITHIEU = "template_2/gioiThieu";
	
	@RequestMapping(value="/{path}")
	public String init(@ModelAttribute("LayoutForm") LayoutForm form, @PathVariable("path") String path, HttpSession session){
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
		NhomSanPhamInputBean nhomSanPhamInputBean = new NhomSanPhamInputBean();  
		nhomSanPhamInputBean.setPathJSP(path);
		List<NhomSanPhamOutputBean> loaiSanPhamOutputBeans = NhomSanPhamDAO.intances.getNhomSP(nhomSanPhamInputBean);
		RegisterProductCategoryFormRow productCategoryFormRow;
		for(NhomSanPhamOutputBean loaiSanPhamOutputBean : loaiSanPhamOutputBeans){
			productCategoryFormRow = new RegisterProductCategoryFormRow();
			productCategoryFormRow.setIdProductCategory(loaiSanPhamOutputBean.getIdNhomSP());
			productCategoryFormRow.setNameProductCategory(loaiSanPhamOutputBean.getTenNhomSP());
			//get loai san pham
			LoaiSanPhamInputBean loaiSanPhamInputBean = new LoaiSanPhamInputBean();
			loaiSanPhamInputBean.setPathJSP(path);
			loaiSanPhamInputBean.setIdNhomSP(loaiSanPhamOutputBean.getIdNhomSP());
			List<LoaiSanPhamOutputBean> loaiSanPhamOutputBeans2 =  NhomSanPhamDAO.intances.getLoaiSPByIdNhomSP(loaiSanPhamInputBean);
			MenuRowForm menuRowForm;
			for(LoaiSanPhamOutputBean outputBean : loaiSanPhamOutputBeans2){
				menuRowForm = new MenuRowForm();
				menuRowForm.setIdLoaiSp(outputBean.getIdLoaiSP());
				menuRowForm.setTenLoaiSp(outputBean.getTenLoaiSP());
				menuRowForm.setIdNhomSP(outputBean.getIdNhomSP());
				productCategoryFormRow.getMenuRowForms().add(menuRowForm);
				System.out.println(productCategoryFormRow.getMenuRowForms().size());
			}
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
			
			DangKiWebOutputBean output = DangKiWebDAO.intances.getDataByPathJSP(path);
			form.setSoDienThoai(output.getSdt());
			form.setDiaChi(output.getDiaChi());
			form.setTenCuaHang(output.getTenWebSite());
			
		return LayoutDAO.intances.getPageJSP(path);
	}
	
	@RequestMapping(value="/{path}/gioHang/{list}")
	public String giohang(@ModelAttribute("LayoutForm") LayoutForm form, @PathVariable("path") String path, @PathVariable("list") String listId, HttpSession session){
		
		//get loai san pham
		NhomSanPhamInputBean nhomSanPhamInputBean = new NhomSanPhamInputBean();  
		nhomSanPhamInputBean.setPathJSP(path);
		List<NhomSanPhamOutputBean> loaiSanPhamOutputBeans = NhomSanPhamDAO.intances.getNhomSP(nhomSanPhamInputBean);
		RegisterProductCategoryFormRow productCategoryFormRow;
		for(NhomSanPhamOutputBean loaiSanPhamOutputBean : loaiSanPhamOutputBeans){
			productCategoryFormRow = new RegisterProductCategoryFormRow();
			productCategoryFormRow.setIdProductCategory(loaiSanPhamOutputBean.getIdNhomSP());
			productCategoryFormRow.setNameProductCategory(loaiSanPhamOutputBean.getTenNhomSP());
			//get loai san pham
			LoaiSanPhamInputBean loaiSanPhamInputBean = new LoaiSanPhamInputBean();
			loaiSanPhamInputBean.setPathJSP(path);
			loaiSanPhamInputBean.setIdNhomSP(loaiSanPhamOutputBean.getIdNhomSP());
			List<LoaiSanPhamOutputBean> loaiSanPhamOutputBeans2 =  NhomSanPhamDAO.intances.getLoaiSPByIdNhomSP(loaiSanPhamInputBean);
			MenuRowForm menuRowForm;
			for(LoaiSanPhamOutputBean outputBean : loaiSanPhamOutputBeans2){
				menuRowForm = new MenuRowForm();
				menuRowForm.setIdLoaiSp(outputBean.getIdLoaiSP());
				menuRowForm.setTenLoaiSp(outputBean.getTenLoaiSP());
				menuRowForm.setIdNhomSP(outputBean.getIdNhomSP());
				productCategoryFormRow.getMenuRowForms().add(menuRowForm);
				System.out.println(productCategoryFormRow.getMenuRowForms().size());
			}
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
		}else{
			form.setHoTenKhachHang(khachHangSession.getTenKhachHang());
			form.setSdtKhachHang(khachHangSession.getSdt());
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
		double totalMoney = 0;
		double tongDonHang = 0;
		for(SanPhamOutputRowBean sanPhamOutputRowBean : sanPhamOutputBean.getLst() ){
			productFormRow = new ProductFormRow();
			productFormRow.setSEQ(sanPhamOutputRowBean.getSEQ());
			productFormRow.setIdSanPham(sanPhamOutputRowBean.getIdSanPham());
			productFormRow.setTenSP(sanPhamOutputRowBean.getTenSP());
			productFormRow.setTenLoaiSP(sanPhamOutputRowBean.getTenLoaiSP());
			productFormRow.setGiaMua(sanPhamOutputRowBean.getGiaMua());
			productFormRow.setGiaBan(sanPhamOutputRowBean.getGiaBan());
			productFormRow.setGiaBanKM(sanPhamOutputRowBean.getGiaBanKM());
			
			productFormRow.setNgayTao(sanPhamOutputRowBean.getNgayTao());
			productFormRow.setNgayChinhSua(sanPhamOutputRowBean.getNgayChinhSua());
			productFormRow.setMoTa(sanPhamOutputRowBean.getMoTa());
			productFormRow.setSoLuong(getSoLuongSanPham(parts, sanPhamOutputRowBean.getSEQ()));
			if (sanPhamOutputRowBean.getGiaBanKM() != null && !"".equals(sanPhamOutputRowBean.getGiaBanKM())) {
				productFormRow.setThanhTien( Double.parseDouble(sanPhamOutputRowBean.getGiaBanKM()) * Double.parseDouble(getSoLuongSanPham(parts, sanPhamOutputRowBean.getSEQ())) +"");
				totalMoney += Double.parseDouble(sanPhamOutputRowBean.getGiaBanKM())* Double.parseDouble(getSoLuongSanPham(parts, sanPhamOutputRowBean.getSEQ()) );
			} else {
				productFormRow.setThanhTien( Double.parseDouble(sanPhamOutputRowBean.getGiaBan()) * Double.parseDouble(getSoLuongSanPham(parts, sanPhamOutputRowBean.getSEQ())) +"");
				totalMoney += Double.parseDouble(sanPhamOutputRowBean.getGiaBan())* Double.parseDouble(getSoLuongSanPham(parts, sanPhamOutputRowBean.getSEQ())  );
			}
			tongDonHang += Double.parseDouble(sanPhamOutputRowBean.getGiaBan())* Double.parseDouble(getSoLuongSanPham(parts, sanPhamOutputRowBean.getSEQ())  );
			form.getProducts().add(productFormRow);
		}
			form.setTongDonHang(tongDonHang +"");
			form.setTongThanhTien(totalMoney +"");
			
			form.setTongTienGiamGia( tongDonHang - totalMoney +"");
			
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
	
	@RequestMapping(value="/{path}/chiTietSP/{idSanPham}")
	public String chiTietSP(@ModelAttribute("LayoutForm") LayoutForm form, @PathVariable("path") String path, @PathVariable("idSanPham") String idSanPham, HttpSession session){
		
		//get loai san pham
		NhomSanPhamInputBean nhomSanPhamInputBean = new NhomSanPhamInputBean();  
		nhomSanPhamInputBean.setPathJSP(path);
		List<NhomSanPhamOutputBean> loaiSanPhamOutputBeans = NhomSanPhamDAO.intances.getNhomSP(nhomSanPhamInputBean);
		RegisterProductCategoryFormRow productCategoryFormRow;
		for(NhomSanPhamOutputBean loaiSanPhamOutputBean : loaiSanPhamOutputBeans){
			productCategoryFormRow = new RegisterProductCategoryFormRow();
			productCategoryFormRow.setIdProductCategory(loaiSanPhamOutputBean.getIdNhomSP());
			productCategoryFormRow.setNameProductCategory(loaiSanPhamOutputBean.getTenNhomSP());
			//get loai san pham
			LoaiSanPhamInputBean loaiSanPhamInputBean = new LoaiSanPhamInputBean();
			loaiSanPhamInputBean.setPathJSP(path);
			loaiSanPhamInputBean.setIdNhomSP(loaiSanPhamOutputBean.getIdNhomSP());
			List<LoaiSanPhamOutputBean> loaiSanPhamOutputBeans2 =  NhomSanPhamDAO.intances.getLoaiSPByIdNhomSP(loaiSanPhamInputBean);
			MenuRowForm menuRowForm;
			for(LoaiSanPhamOutputBean outputBean : loaiSanPhamOutputBeans2){
				menuRowForm = new MenuRowForm();
				menuRowForm.setIdLoaiSp(outputBean.getIdLoaiSP());
				menuRowForm.setTenLoaiSp(outputBean.getTenLoaiSP());
				menuRowForm.setIdNhomSP(outputBean.getIdNhomSP());
				productCategoryFormRow.getMenuRowForms().add(menuRowForm);
				System.out.println(productCategoryFormRow.getMenuRowForms().size());
			}
			 form.getLoaiSanPham().add(productCategoryFormRow);
		}

		SanPhamInputBean input = new SanPhamInputBean();
		input.setPathJSP(path);
		input.setSEQ(idSanPham);
		SanPhamOutputBean sanPhamOutputBean = CreateTableProductDAO.intances.getProductById(input);
		SanPhamOutputRowBean outputRowBean = sanPhamOutputBean.getLst().get(0);
		
		ProductFormRow rowBean = new ProductFormRow();
		rowBean.setTenSP(outputRowBean.getTenSP());
		rowBean.setSEQ(idSanPham);
		rowBean.setMoTa(outputRowBean.getMoTa());
		String giaBan = String.format("%,.2f",Double.parseDouble(outputRowBean.getGiaBan()));
		rowBean.setGiaBan(giaBan);
		form.getProducts().add(rowBean);
		
		form.setPathJSP(path);
		
		return "fashion/chiTietSP";
	}
	
	@RequestMapping(value="/{path}/timKiem")
	public String timKiem(@ModelAttribute("LayoutForm") LayoutForm form, @PathVariable("path") String path, HttpSession session){
		
		//get loai san pham
		NhomSanPhamInputBean nhomSanPhamInputBean = new NhomSanPhamInputBean();  
		nhomSanPhamInputBean.setPathJSP(path);
		List<NhomSanPhamOutputBean> loaiSanPhamOutputBeans = NhomSanPhamDAO.intances.getNhomSP(nhomSanPhamInputBean);
		RegisterProductCategoryFormRow productCategoryFormRow;
		for(NhomSanPhamOutputBean loaiSanPhamOutputBean : loaiSanPhamOutputBeans){
			productCategoryFormRow = new RegisterProductCategoryFormRow();
			productCategoryFormRow.setIdProductCategory(loaiSanPhamOutputBean.getIdNhomSP());
			productCategoryFormRow.setNameProductCategory(loaiSanPhamOutputBean.getTenNhomSP());
			//get loai san pham
			LoaiSanPhamInputBean loaiSanPhamInputBean = new LoaiSanPhamInputBean();
			loaiSanPhamInputBean.setPathJSP(path);
			loaiSanPhamInputBean.setIdNhomSP(loaiSanPhamOutputBean.getIdNhomSP());
			List<LoaiSanPhamOutputBean> loaiSanPhamOutputBeans2 =  NhomSanPhamDAO.intances.getLoaiSPByIdNhomSP(loaiSanPhamInputBean);
			MenuRowForm menuRowForm;
			for(LoaiSanPhamOutputBean outputBean : loaiSanPhamOutputBeans2){
				menuRowForm = new MenuRowForm();
				menuRowForm.setIdLoaiSp(outputBean.getIdLoaiSP());
				menuRowForm.setTenLoaiSp(outputBean.getTenLoaiSP());
				menuRowForm.setIdNhomSP(outputBean.getIdNhomSP());
				productCategoryFormRow.getMenuRowForms().add(menuRowForm);
				System.out.println(productCategoryFormRow.getMenuRowForms().size());
			}
			 form.getLoaiSanPham().add(productCategoryFormRow);
		}

		SanPhamInputBean input = new SanPhamInputBean();
		System.out.println("data tim kiem: " + form.getTimKiem_TenSP());
		SanPhamOutputBean sanPhamOutputBean = CreateTableProductDAO.intances.getProductBysByNameProduct(path,form.getTimKiem_TenSP());
		System.out.println("data tim kiem size : " + sanPhamOutputBean.getLst().size());
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
		
			form.setTimKiem_TenSP("");
			form.setPathJSP(path);
			form.setCartPrice("0");
			form.setCartQuantity("0");
		
		form.setPathJSP(path);
		return PAGE_CART;
	}
	
	@RequestMapping(value="/{path}/lienHe")
	public String lienHe(@ModelAttribute("LayoutForm") LayoutForm form, @PathVariable("path") String path, HttpSession session){
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
		NhomSanPhamInputBean nhomSanPhamInputBean = new NhomSanPhamInputBean();  
		nhomSanPhamInputBean.setPathJSP(path);
		List<NhomSanPhamOutputBean> loaiSanPhamOutputBeans = NhomSanPhamDAO.intances.getNhomSP(nhomSanPhamInputBean);
		RegisterProductCategoryFormRow productCategoryFormRow;
		for(NhomSanPhamOutputBean loaiSanPhamOutputBean : loaiSanPhamOutputBeans){
			productCategoryFormRow = new RegisterProductCategoryFormRow();
			productCategoryFormRow.setIdProductCategory(loaiSanPhamOutputBean.getIdNhomSP());
			productCategoryFormRow.setNameProductCategory(loaiSanPhamOutputBean.getTenNhomSP());
			//get loai san pham
			LoaiSanPhamInputBean loaiSanPhamInputBean = new LoaiSanPhamInputBean();
			loaiSanPhamInputBean.setPathJSP(path);
			loaiSanPhamInputBean.setIdNhomSP(loaiSanPhamOutputBean.getIdNhomSP());
			List<LoaiSanPhamOutputBean> loaiSanPhamOutputBeans2 =  NhomSanPhamDAO.intances.getLoaiSPByIdNhomSP(loaiSanPhamInputBean);
			MenuRowForm menuRowForm;
			for(LoaiSanPhamOutputBean outputBean : loaiSanPhamOutputBeans2){
				menuRowForm = new MenuRowForm();
				menuRowForm.setIdLoaiSp(outputBean.getIdLoaiSP());
				menuRowForm.setTenLoaiSp(outputBean.getTenLoaiSP());
				menuRowForm.setIdNhomSP(outputBean.getIdNhomSP());
				productCategoryFormRow.getMenuRowForms().add(menuRowForm);
				System.out.println(productCategoryFormRow.getMenuRowForms().size());
			}
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
			
			DangKiWebOutputBean output = DangKiWebDAO.intances.getDataByPathJSP(path);
			form.setSoDienThoai(output.getSdt());
			form.setDiaChi(output.getDiaChi());
			form.setTenCuaHang(output.getTenWebSite());
			
		form.setPathJSP(path);
		return LIENHE;
	}
	
	@RequestMapping(value="/{path}/gioiThieu")
	public String tinTuc(@ModelAttribute("LayoutForm") LayoutForm form, @PathVariable("path") String path, HttpSession session){
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
		NhomSanPhamInputBean nhomSanPhamInputBean = new NhomSanPhamInputBean();  
		nhomSanPhamInputBean.setPathJSP(path);
		List<NhomSanPhamOutputBean> loaiSanPhamOutputBeans = NhomSanPhamDAO.intances.getNhomSP(nhomSanPhamInputBean);
		RegisterProductCategoryFormRow productCategoryFormRow;
		for(NhomSanPhamOutputBean loaiSanPhamOutputBean : loaiSanPhamOutputBeans){
			productCategoryFormRow = new RegisterProductCategoryFormRow();
			productCategoryFormRow.setIdProductCategory(loaiSanPhamOutputBean.getIdNhomSP());
			productCategoryFormRow.setNameProductCategory(loaiSanPhamOutputBean.getTenNhomSP());
			//get loai san pham
			LoaiSanPhamInputBean loaiSanPhamInputBean = new LoaiSanPhamInputBean();
			loaiSanPhamInputBean.setPathJSP(path);
			loaiSanPhamInputBean.setIdNhomSP(loaiSanPhamOutputBean.getIdNhomSP());
			List<LoaiSanPhamOutputBean> loaiSanPhamOutputBeans2 =  NhomSanPhamDAO.intances.getLoaiSPByIdNhomSP(loaiSanPhamInputBean);
			MenuRowForm menuRowForm;
			for(LoaiSanPhamOutputBean outputBean : loaiSanPhamOutputBeans2){
				menuRowForm = new MenuRowForm();
				menuRowForm.setIdLoaiSp(outputBean.getIdLoaiSP());
				menuRowForm.setTenLoaiSp(outputBean.getTenLoaiSP());
				menuRowForm.setIdNhomSP(outputBean.getIdNhomSP());
				productCategoryFormRow.getMenuRowForms().add(menuRowForm);
				System.out.println(productCategoryFormRow.getMenuRowForms().size());
			}
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
			
			DangKiWebOutputBean output = DangKiWebDAO.intances.getDataByPathJSP(path);
			form.setSoDienThoai(output.getSdt());
			form.setDiaChi(output.getDiaChi());
			form.setTenCuaHang(output.getTenWebSite());
			
		form.setPathJSP(path);
		return TINTUC;
	}
	
	@RequestMapping(value="/{path}/tinTuc")
	public String gioiThieu(@ModelAttribute("LayoutForm") LayoutForm form, @PathVariable("path") String path, HttpSession session){
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
		NhomSanPhamInputBean nhomSanPhamInputBean = new NhomSanPhamInputBean();  
		nhomSanPhamInputBean.setPathJSP(path);
		List<NhomSanPhamOutputBean> loaiSanPhamOutputBeans = NhomSanPhamDAO.intances.getNhomSP(nhomSanPhamInputBean);
		RegisterProductCategoryFormRow productCategoryFormRow;
		for(NhomSanPhamOutputBean loaiSanPhamOutputBean : loaiSanPhamOutputBeans){
			productCategoryFormRow = new RegisterProductCategoryFormRow();
			productCategoryFormRow.setIdProductCategory(loaiSanPhamOutputBean.getIdNhomSP());
			productCategoryFormRow.setNameProductCategory(loaiSanPhamOutputBean.getTenNhomSP());
			//get loai san pham
			LoaiSanPhamInputBean loaiSanPhamInputBean = new LoaiSanPhamInputBean();
			loaiSanPhamInputBean.setPathJSP(path);
			loaiSanPhamInputBean.setIdNhomSP(loaiSanPhamOutputBean.getIdNhomSP());
			List<LoaiSanPhamOutputBean> loaiSanPhamOutputBeans2 =  NhomSanPhamDAO.intances.getLoaiSPByIdNhomSP(loaiSanPhamInputBean);
			MenuRowForm menuRowForm;
			for(LoaiSanPhamOutputBean outputBean : loaiSanPhamOutputBeans2){
				menuRowForm = new MenuRowForm();
				menuRowForm.setIdLoaiSp(outputBean.getIdLoaiSP());
				menuRowForm.setTenLoaiSp(outputBean.getTenLoaiSP());
				menuRowForm.setIdNhomSP(outputBean.getIdNhomSP());
				productCategoryFormRow.getMenuRowForms().add(menuRowForm);
				System.out.println(productCategoryFormRow.getMenuRowForms().size());
			}
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
			
			DangKiWebOutputBean output = DangKiWebDAO.intances.getDataByPathJSP(path);
			form.setSoDienThoai(output.getSdt());
			form.setDiaChi(output.getDiaChi());
			form.setTenCuaHang(output.getTenWebSite());
			
		form.setPathJSP(path);
		return GIOITHIEU;
	}
	
}
