package com.sms.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sms.OutputRows.LoaiTheOutputRowBean;
import com.sms.OutputRows.SanPhamOutputRowBean;
import com.sms.common.SMSComons;
import com.sms.dao.ChiTietHoaDonDAO;
import com.sms.dao.CreateTableProductDAO;
import com.sms.dao.DangKiWebDAO;
import com.sms.dao.HoaDonDAO;
import com.sms.dao.KhachHangDAO;
import com.sms.dao.KhoHangDAO;
import com.sms.dao.LayoutDAO;
import com.sms.dao.LoaiTheDAO;
import com.sms.form.LayoutForm;
import com.sms.formRows.ProductFormRow;
import com.sms.input.ChiTietHoaDonInputBean;
import com.sms.input.HoaDonInputBean;
import com.sms.input.KhachHangInputBean;
import com.sms.input.LoaiTheInputBean;
import com.sms.input.SanPhamInputBean;
import com.sms.output.DangKiWebOutputBean;
import com.sms.output.KhoHangOutBean;
import com.sms.output.SanPhamOutputBean;
import com.sms.session.KhachHangSession;
@Controller
public class ThanhToanController {
	
	public static final String PAGE_CART = "gioHang";
	
	@RequestMapping(value = "/{path}/thanhToan/{list}")
	public String thanhToan(@ModelAttribute("LayoutForm") LayoutForm form, @PathVariable("path") String path,
			@PathVariable("list") String listId, HttpSession session) {
		// check pathJSP
		if (!LayoutDAO.intances.checkPathJSP(path)) {
			// quay ve trang login
			return "redirect:/";
		}
		giohang(form, path, listId);
		// 
		int cnt = 0;
		String[] parts = null;
		// remove ","
		if (!"".equals(listId)) {
			listId = listId.substring(1);
			parts = listId.split(",");
			listId = "";
			for (int i = 0; i < parts.length; i++) {
				if (i < parts.length - 1) {
					listId = listId + "'" + parts[i] + "',";
				} else {
					listId = listId + "'" + parts[i] + "'";
				}
			}
		}
		double totalMoney = 0;
		SanPhamOutputBean sanPhamOutputBean = CreateTableProductDAO.intances.getProductByList(path, listId);
		for (SanPhamOutputRowBean sanPhamOutputRowBean : sanPhamOutputBean.getLst()) {
			if (sanPhamOutputRowBean.getGiaBanKM() != null && !"".equals(sanPhamOutputRowBean.getGiaBanKM())) {
				totalMoney += Double.parseDouble(sanPhamOutputRowBean.getGiaBanKM())* getSoLuongSanPham(parts, sanPhamOutputRowBean.getSEQ());
			} else {
				totalMoney += Double.parseDouble(sanPhamOutputRowBean.getGiaBan())* getSoLuongSanPham(parts, sanPhamOutputRowBean.getSEQ());
			}
		}
		KhachHangSession khachHangSession = (KhachHangSession) session.getAttribute("KhachHangSession");
		HoaDonInputBean hoaDonInputBean = new HoaDonInputBean();
		hoaDonInputBean.setIdHoaDon("");
		if (khachHangSession != null) {
			hoaDonInputBean.setIdKhachHang(khachHangSession.getIdKhachHang());
		}else{
			hoaDonInputBean.setIdKhachHang(form.getSdtKhachHang());
		}
		hoaDonInputBean.setPathJSP(path);
		hoaDonInputBean.setSoLuongSP(String.valueOf(parts.length));
		hoaDonInputBean.setTienKhuyenMai("");
		// 10000 d set duoc tinh la 1 diem
		hoaDonInputBean.setTongDiemTichLuy(String.valueOf(totalMoney / 10000));
		hoaDonInputBean.setTongTien(String.valueOf(totalMoney));
		hoaDonInputBean.setNgayLap(SMSComons.getDate());
		cnt = HoaDonDAO.intances.insert(hoaDonInputBean);
		
		//update diem tich luy va loai the cho khach hang
		LoaiTheInputBean loaiTheInputBean = new LoaiTheInputBean();
		loaiTheInputBean.setPathJSP(path);
		loaiTheInputBean.setIdLoaiThe("2");
		List<LoaiTheOutputRowBean> loaiTheOutputRowBeans = LoaiTheDAO.intances.getById(loaiTheInputBean);
		double mucDiem = 0;
		if(loaiTheOutputRowBeans != null && loaiTheOutputRowBeans.size()> 0){
			mucDiem = Double.parseDouble(loaiTheOutputRowBeans.get(0).getDiem());
		}
		
		if (khachHangSession != null) {
			KhachHangInputBean khachHangInputBean = new KhachHangInputBean();
			khachHangInputBean.setIdKhachHang(khachHangSession.getIdKhachHang());
			khachHangInputBean.setPathJSP(path);
			khachHangInputBean.setSoDiem(SMSComons.cong(khachHangSession.getDiemTichLuy(), hoaDonInputBean.getDiemTichLuy()) +"");
			if(loaiTheOutputRowBeans != null && loaiTheOutputRowBeans.size()> 0){
				if(khachHangInputBean.getSoDiem().compareTo(mucDiem +"") > 0){
					khachHangInputBean.setLoaiThe("2");
				}
			}
			khachHangInputBean.setLoaiThe(khachHangSession.getLoaiThe());
			System.out.println("idkhach: "+khachHangInputBean.getIdKhachHang());
			cnt = KhachHangDAO.intances.updateDiemAndLoaiThe(khachHangInputBean);
		}
		
		if (cnt == 1) {
			String idHoaDon = HoaDonDAO.intances.getMaxId(path);
			SanPhamOutputRowBean sanPhamOutputRowBean;
			for (int i = 0; i < sanPhamOutputBean.getLst().size(); i++) {
				sanPhamOutputRowBean = sanPhamOutputBean.getLst().get(i);
				ChiTietHoaDonInputBean chiTietHoaDonInputBean = new ChiTietHoaDonInputBean();
				chiTietHoaDonInputBean.setPathJSP(path);
				chiTietHoaDonInputBean.setIdChiTietHoaDon("");
				chiTietHoaDonInputBean.setIdHoaDon(idHoaDon);
				chiTietHoaDonInputBean.setIdSanPham(sanPhamOutputRowBean.getIdSanPham());
				if (sanPhamOutputRowBean.getGiaBanKM() != null && !"".equals(sanPhamOutputRowBean.getGiaBanKM())) {
					chiTietHoaDonInputBean.setGiaMua(sanPhamOutputRowBean.getGiaBanKM());
				} else {
					chiTietHoaDonInputBean.setGiaMua(sanPhamOutputRowBean.getGiaBan());
				}
				chiTietHoaDonInputBean.setLoaiSanPham(sanPhamOutputRowBean.getTenLoaiSP());
				chiTietHoaDonInputBean.setSoLuongSP(String.valueOf(getSoLuongSanPham(parts, sanPhamOutputRowBean.getSEQ())));
				if (sanPhamOutputRowBean.getGiaBanKM() != null && !"".equals(sanPhamOutputRowBean.getGiaBanKM())) {
					chiTietHoaDonInputBean.setThanhTien(Double.parseDouble(sanPhamOutputRowBean.getGiaBanKM()) * getSoLuongSanPham(parts, sanPhamOutputRowBean.getSEQ())+"");
				} else {
					chiTietHoaDonInputBean.setThanhTien(Double.parseDouble(sanPhamOutputRowBean.getGiaBan()) * getSoLuongSanPham(parts, sanPhamOutputRowBean.getSEQ())+"");
				}
				cnt = ChiTietHoaDonDAO.intances.insert(chiTietHoaDonInputBean);
				// Cap nhat lai so luong san pham trong kho (S)
				KhoHangOutBean khoHangOutBean = KhoHangDAO.intances.getAllKhoHangByIdSanPham(path,chiTietHoaDonInputBean.getIdSanPham());
				if(khoHangOutBean != null){
					cnt = KhoHangDAO.intances.updateKhoHang(path, khoHangOutBean.getIdSanPham(), (Integer.parseInt(khoHangOutBean.getSoLuong()) -  Integer.parseInt(chiTietHoaDonInputBean.getSoLuongSP() ) )+"");
				}
				// Cap nhat lai so luong san pham trong kho (E)
				
				if(cnt != 1){
					form.setMessage("");
					form.setMessageErr("Thanh toán không thành công.");
					return PAGE_CART;
				}
			}
		}else{
			form.setMessage("");
			form.setMessageErr("Thanh toán không thành công.");
			return PAGE_CART;
		}
		// Thanh toan thanh cong
		if(cnt == 1){
			form.setMessage("Cảm ơn bạn đã mua hàng.");
			form.setMessageErr("");
		}
		
		DangKiWebOutputBean output = DangKiWebDAO.intances.getDataByPathJSP(path);
		form.setSoDienThoai(output.getSdt());
		form.setDiaChi(output.getDiaChi());
		form.setTenCuaHang(output.getTenWebSite());
		return PAGE_CART;
	}
	
	/**
	 * 
	 * @param form
	 * @param path
	 * @param listId
	 */
		private void giohang(LayoutForm form, String path, String listId){
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
				productFormRow.setSoLuong(getSoLuongSanPham(parts, sanPhamOutputRowBean.getSEQ()) + "");
				if (sanPhamOutputRowBean.getGiaBanKM() != null && !"".equals(sanPhamOutputRowBean.getGiaBanKM())) {
					productFormRow.setThanhTien( Double.parseDouble(sanPhamOutputRowBean.getGiaBanKM()) * getSoLuongSanPham(parts, sanPhamOutputRowBean.getSEQ()) +"");
					totalMoney += Double.parseDouble(sanPhamOutputRowBean.getGiaBanKM())* getSoLuongSanPham(parts, sanPhamOutputRowBean.getSEQ() );
				} else {
					productFormRow.setThanhTien( Double.parseDouble(sanPhamOutputRowBean.getGiaBan()) * getSoLuongSanPham(parts, sanPhamOutputRowBean.getSEQ()) +"");
					totalMoney += Double.parseDouble(sanPhamOutputRowBean.getGiaBan())* getSoLuongSanPham(parts, sanPhamOutputRowBean.getSEQ()  );
				}
				tongDonHang += Double.parseDouble(sanPhamOutputRowBean.getGiaBan())* getSoLuongSanPham(parts, sanPhamOutputRowBean.getSEQ()  );
				form.getProducts().add(productFormRow);
			}
				form.setTongDonHang(tongDonHang +"");
				form.setTongThanhTien(totalMoney +"");
				form.setTongTienGiamGia( tongDonHang - totalMoney +"");
				form.setPathJSP(path);
				form.setListId(listId);
		}
	
	
	/**
	 * 
	 * @param part
	 * @param SEQ
	 * @return
	 */
	private int getSoLuongSanPham(String part[], String SEQ){
		int cnt = 0;
		for(int i = 0; i < part.length;i++){
			if(part[i].trim().equals(SEQ)){
				cnt++;
			}
		}
		return cnt;
		
	}
}
