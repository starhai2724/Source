package com.sms.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public static final String TINTUC_1 = "fashion/tinTuc";
	public static final String LIENHE_1 = "fashion/lienhe";
	public static final String CHITIET_1 = "fashion/chiTietSP";
	public static final String GIOITHIEU_1 = "fashion/gioiThieu";
	public static final String HUONDAN_1 = "template_2/huongDanMuaHang";
	public static final String TINTUC_2 = "template_2/tinTuc";
	public static final String LIENHE_2 = "template_2/lienhe";
	public static final String GIOITHIEU_2 = "template_2/gioiThieu";
	public static final String CHITIET_2 = "template_2/chiTietSP";
	public static final String HUONDAN_2 = "template_2/huongDanMuaHang";
	
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
			}
			 form.getLoaiSanPham().add(productCategoryFormRow);
		}
		//get Dot KM
		List<DotKhuyenMaiOutputRowBean> listDKM = DotKhuyenMaiDAO.intances.getDotKMApDung(path, SMSComons.getDate());
		
		String limit="";
		//get san pham 
		SanPhamInputBean sanPhamInputBean = new SanPhamInputBean();
		sanPhamInputBean.setPathJSP(path);
		SanPhamOutputBean sanPhamOutputBean = CreateTableProductDAO.intances.getSanPhamApDung(path,limit);
		ProductFormRow productFormRow;
		for(SanPhamOutputRowBean sanPhamOutputRowBean : sanPhamOutputBean.getLst()){
			productFormRow = new ProductFormRow();
			productFormRow.setSEQ(sanPhamOutputRowBean.getSEQ());
			productFormRow.setIdSanPham(sanPhamOutputRowBean.getIdSanPham());
			productFormRow.setTenSP(sanPhamOutputRowBean.getTenSP());
			productFormRow.setTenLoaiSP(sanPhamOutputRowBean.getTenLoaiSP());
			productFormRow.setGiaMua(sanPhamOutputRowBean.getGiaMua());
			//get san pham KM
			if(listDKM != null && listDKM.size() > 0){
				List<SanPhamOutputRowBean> lstSPKM = DotKhuyenMaiDAO.intances.getSanPhamKM(path, listDKM.get(0).getMaDKM());
				for (SanPhamOutputRowBean spkm : lstSPKM) {
					if(spkm.getSEQ().equals(sanPhamOutputRowBean.getSEQ())){ // la sp dc KM
						System.out.println("sanr phaam KM : " + sanPhamOutputRowBean.getTenSP());
						productFormRow.setGiaBanKM(sanPhamOutputRowBean.getGiaBanKM());
					}
				}
			}
			productFormRow.setGiaBan(sanPhamOutputRowBean.getGiaBan());
			productFormRow.setNgayTao(sanPhamOutputRowBean.getNgayTao());
			productFormRow.setNgayChinhSua(sanPhamOutputRowBean.getNgayChinhSua());
			productFormRow.setMoTa(sanPhamOutputRowBean.getMoTa());
			form.getProducts().add(productFormRow);
			form.getProducts_SearchByMenu().add(productFormRow);
		}
			form.setPathJSP(path);
			form.setCartPrice("0");
			form.setCartQuantity("0");
			
			DangKiWebOutputBean output = DangKiWebDAO.intances.getDataByPathJSP(path);
			form.setSoDienThoai(output.getSdt());
			form.setDiaChi(output.getDiaChi());
			form.setTenCuaHang(output.getTenWebSite());
			form.setDkGiaoHangFree(output.getDkGiaoHangFree());
			form.setLinkFanpage(output.getLinkFanpage());
			
		return LayoutDAO.intances.getPageJSP(path);
	}
	
	@RequestMapping(value="/{path}/phanTrang/{index}")
	public String phanTrang(@ModelAttribute("LayoutForm") LayoutForm form, @PathVariable("path") String path, @PathVariable("index") String index, HttpSession session){
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
			}
			 form.getLoaiSanPham().add(productCategoryFormRow);
		}
		//get Dot KM
		List<DotKhuyenMaiOutputRowBean> listDKM = DotKhuyenMaiDAO.intances.getDotKMApDung(path, SMSComons.getDate());
//		DotKhuyenMaiOutputRowBean dotKhuyenMaiOutputRowBean= listDKM.get(0);
		
		String limit = "";
		if("1".equals(index)){
			limit = "0";
		}else {
			limit = String.valueOf(10 * (Integer.parseInt(index)-1) );
		}
		//get san pham 
		SanPhamInputBean sanPhamInputBean = new SanPhamInputBean();
		sanPhamInputBean.setPathJSP(path);
		SanPhamOutputBean sanPhamOutputBean = CreateTableProductDAO.intances.getSanPhamApDung(path,limit);
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
			form.getProducts_SearchByMenu().add(productFormRow);
		}
			form.setPathJSP(path);
			
			DangKiWebOutputBean output = DangKiWebDAO.intances.getDataByPathJSP(path);
			form.setSoDienThoai(output.getSdt());
			form.setDiaChi(output.getDiaChi());
			form.setTenCuaHang(output.getTenWebSite());
			form.setDkGiaoHangFree(output.getDkGiaoHangFree());
			form.setLinkFanpage(output.getLinkFanpage());
			
		return LayoutDAO.intances.getPageJSP(path);
	}
	
	
	@RequestMapping(value="/{path}/searchByMenu/{idLoaiSp}/{nameProductCategory}",method = RequestMethod.GET)
	public String searchByMenu(@ModelAttribute("LayoutForm") LayoutForm form, @PathVariable("path") String path, @PathVariable("idLoaiSp") String idLoaiSp,@PathVariable("nameProductCategory") String nameProductCategory, HttpSession session){
		//check pathJSP
		if(!LayoutDAO.intances.checkPathJSP(path)){
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
			}
			 form.getLoaiSanPham().add(productCategoryFormRow);
		}
		//get Dot KM
		List<DotKhuyenMaiOutputRowBean> listDKM = DotKhuyenMaiDAO.intances.getDotKMApDung(path, SMSComons.getDate());
		String limit="";
		//get san pham 
		SanPhamInputBean sanPhamInputBean = new SanPhamInputBean();
		sanPhamInputBean.setPathJSP(path);
		SanPhamOutputBean sanPhamOutputBean = CreateTableProductDAO.intances.getSanPhamApDung(path,limit);
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
			if(idLoaiSp.equals(sanPhamOutputRowBean.getIdLoaiSP())){
				form.getProducts_SearchByMenu().add(productFormRow);
			}
			form.getProducts().add(productFormRow);
		}
		
			form.setPathJSP(path);
			form.setCartPrice("0");
			form.setCartQuantity("0");
			form.setIdTenNhomSP_Search(nameProductCategory);
			
			DangKiWebOutputBean output = DangKiWebDAO.intances.getDataByPathJSP(path);
			form.setSoDienThoai(output.getSdt());
			form.setDiaChi(output.getDiaChi());
			form.setTenCuaHang(output.getTenWebSite());
			form.setDkGiaoHangFree(output.getDkGiaoHangFree());
			form.setLinkFanpage(output.getLinkFanpage());
			
		return LayoutDAO.intances.getPageJSP(path);
	}
	
	@RequestMapping(value="/{path}/gioHang/{list}")
	public String giohang(@ModelAttribute("LayoutForm") LayoutForm form, @PathVariable("path") String path, @PathVariable("list") String listId, HttpSession session){
		//check pathJSP
		if(!LayoutDAO.intances.checkPathJSP(path)){
			//quay ve trang login
//					return new ModelAndView("redirect:/");
			return "redirect:/";
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
			System.out.println("listId1: "+listId);
			listId = listId.substring(1);
			System.out.println("listId2: "+listId);
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
			DangKiWebOutputBean output = DangKiWebDAO.intances.getDataByPathJSP(path);
			form.setTenCuaHang(output.getTenWebSite());
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
		//check pathJSP
		if(!LayoutDAO.intances.checkPathJSP(path)){
			//quay ve trang login
//					return new ModelAndView("redirect:/");
			return "redirect:/";
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
		//String giaBan = String.format("%,.2f",Double.parseDouble(outputRowBean.getGiaBan()));
		rowBean.setGiaBan(outputRowBean.getGiaBan());
		form.getProducts().add(rowBean);
		
		form.setPathJSP(path);
		DangKiWebOutputBean output = DangKiWebDAO.intances.getDataByPathJSP(path);
		form.setSoDienThoai(output.getSdt());
		form.setDiaChi(output.getDiaChi());
		form.setTenCuaHang(output.getTenWebSite());
		form.setLinkFanpage(output.getLinkFanpage());
		
		if("01".equals(output.getLoaiKinhDoanh().trim()))return CHITIET_1;
		if("02".equals(output.getLoaiKinhDoanh().trim()))return CHITIET_2;
		
		return CHITIET_1;
	}
	
	@RequestMapping(value="/{path}/timKiem")
	public String timKiem(@ModelAttribute("LayoutForm") LayoutForm form, @PathVariable("path") String path, HttpSession session){
		//check pathJSP
		if(!LayoutDAO.intances.checkPathJSP(path)){
			//quay ve trang login
//					return new ModelAndView("redirect:/");
			return "redirect:/";
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
			}
			 form.getLoaiSanPham().add(productCategoryFormRow);
		}

		SanPhamOutputBean sanPhamOutputBean = CreateTableProductDAO.intances.getProductBysByNameProduct(path,form.getTimKiem_TenSP());

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
		 sanPhamOutputBean = CreateTableProductDAO.intances.getProductBysByNameProduct(path,form.getTimKiem_TenSP());
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
			form.getProducts_SearchByMenu().add(productFormRow);
		}
		
			form.setTimKiem_TenSP("");
			form.setCartPrice("0");
			form.setCartQuantity("0");
			form.setCheckSearchBtn("1");
		
		form.setPathJSP(path);
		return LayoutDAO.intances.getPageJSP(path);
	}
	
	@RequestMapping(value="/{path}/timKiemSanPham/{id}", method = RequestMethod.GET)
	public String timKiemSanPhamTheoMenu(@ModelAttribute("LayoutForm") LayoutForm form, @PathVariable("path") String path,
			@PathVariable("id") String id, HttpSession session){
		//check pathJSP
		if(!LayoutDAO.intances.checkPathJSP(path)){
			//quay ve trang login
//					return new ModelAndView("redirect:/");
			return "redirect:/";
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
			}
			 form.getLoaiSanPham().add(productCategoryFormRow);
		}

		SanPhamInputBean input = new SanPhamInputBean();
		SanPhamOutputBean sanPhamOutputBean = CreateTableProductDAO.intances.getSanPhamTimKiemTheoMenu(path, id);
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
		System.out.println("lst Tim kiem: "+form.getProducts().size());
//			form.setTimKiem_TenSP("");
//			form.setPathJSP(path);
//			form.setCartPrice("0");
//			form.setCartQuantity("0");
			form.setPathJSP(path);
		return LayoutDAO.intances.getPageJSP(path);
	}
	
	@RequestMapping(value="/{path}/lienHe", method = RequestMethod.POST)
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
			}
			 form.getLoaiSanPham().add(productCategoryFormRow);
		}
		//get Dot KM
		List<DotKhuyenMaiOutputRowBean> listDKM = DotKhuyenMaiDAO.intances.getDotKMApDung(path, SMSComons.getDate());
//		DotKhuyenMaiOutputRowBean dotKhuyenMaiOutputRowBean= listDKM.get(0);
		
		String limit ="";
		//get san pham 
		SanPhamInputBean sanPhamInputBean = new SanPhamInputBean();
		sanPhamInputBean.setPathJSP(path);
		SanPhamOutputBean sanPhamOutputBean = CreateTableProductDAO.intances.getSanPhamApDung(path, limit);
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
			form.setLinkFanpage(output.getLinkFanpage());
			
			form.setPathJSP(path);
			
			if("01".equals(output.getLoaiKinhDoanh().trim()))return LIENHE_1;
			if("02".equals(output.getLoaiKinhDoanh().trim()))return LIENHE_2;
			
			return LIENHE_1;
	}
	
	@RequestMapping(value="/{path}/gioiThieu")
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
			}
			 form.getLoaiSanPham().add(productCategoryFormRow);
		}
		//get Dot KM
		List<DotKhuyenMaiOutputRowBean> listDKM = DotKhuyenMaiDAO.intances.getDotKMApDung(path, SMSComons.getDate());
//		DotKhuyenMaiOutputRowBean dotKhuyenMaiOutputRowBean= listDKM.get(0);
		
		String limit ="";
		
		//get san pham 
		SanPhamInputBean sanPhamInputBean = new SanPhamInputBean();
		sanPhamInputBean.setPathJSP(path);
		SanPhamOutputBean sanPhamOutputBean = CreateTableProductDAO.intances.getSanPhamApDung(path,limit);
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
			form.setLinkFanpage(output.getLinkFanpage());
			
		form.setPathJSP(path);
		if("01".equals(output.getLoaiKinhDoanh().trim()))return GIOITHIEU_1;
		if("02".equals(output.getLoaiKinhDoanh().trim()))return GIOITHIEU_2;
		
		return GIOITHIEU_1;
	}
	
	@RequestMapping(value="/{path}/huongDan")
	public String huongDan(@ModelAttribute("LayoutForm") LayoutForm form, @PathVariable("path") String path, HttpSession session){
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
			}
			 form.getLoaiSanPham().add(productCategoryFormRow);
		}
			form.setPathJSP(path);
			form.setCartPrice("0");
			form.setCartQuantity("0");
			
			DangKiWebOutputBean output = DangKiWebDAO.intances.getDataByPathJSP(path);
			form.setSoDienThoai(output.getSdt());
			form.setDiaChi(output.getDiaChi());
			form.setTenCuaHang(output.getTenWebSite());
			form.setLinkFanpage(output.getLinkFanpage());
			
		form.setPathJSP(path);
		if("01".equals(output.getLoaiKinhDoanh().trim()))return HUONDAN_1;
		if("02".equals(output.getLoaiKinhDoanh().trim()))return HUONDAN_2;
		
		return HUONDAN_1;
	}
	
	@RequestMapping(value="/{path}/tinTuc")
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
		
		String limit ="";
		
		//get san pham 
		SanPhamInputBean sanPhamInputBean = new SanPhamInputBean();
		sanPhamInputBean.setPathJSP(path);
		SanPhamOutputBean sanPhamOutputBean = CreateTableProductDAO.intances.getSanPhamApDung(path,  limit);
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
			form.setLinkFanpage(output.getLinkFanpage());
			
		form.setPathJSP(path);
		System.out.println("VVVVVVVVVVVVVVVVVVVVVVVV   : " + output.getLoaiKinhDoanh().trim());
		if("01".equals(output.getLoaiKinhDoanh().trim()))return TINTUC_1;
		if("02".equals(output.getLoaiKinhDoanh().trim()))return TINTUC_2;
		return TINTUC_1;
	}
	
}
