package com.sms.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sms.OutputRows.SanPhamOutputRowBean;
import com.sms.common.SMSComons;
import com.sms.dao.ChiTietHoaDonDAO;
import com.sms.dao.CreateTableProductDAO;
import com.sms.dao.HoaDonDAO;
import com.sms.dao.LayoutDAO;
import com.sms.form.LayoutForm;
import com.sms.formRows.ProductFormRow;
import com.sms.input.ChiTietHoaDonInputBean;
import com.sms.input.HoaDonInputBean;
import com.sms.output.SanPhamOutputBean;
import com.sms.session.KhachHangSession;
@Controller
public class ThanhToanController {

	@RequestMapping(value = "/{path}/thanhToan/{list}")
	public String thanhToan(@ModelAttribute("LayoutForm") LayoutForm form, @PathVariable("path") String path,
			@PathVariable("list") String listId, HttpSession session) {
		// check pathJSP
		if (!LayoutDAO.intances.checkPathJSP(path)) {
			// quay ve trang login
			return "redirect:/";
		}

		// remove ","
		if (!"".equals(listId)) {
			listId = listId.substring(1);
			String[] parts = listId.split(",");
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
		ProductFormRow productFormRow;
		for (SanPhamOutputRowBean sanPhamOutputRowBean : sanPhamOutputBean.getLst()) {
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
			form.getProducts().add(productFormRow);
			if (sanPhamOutputRowBean.getGiaBanKM() != null && "".equals(sanPhamOutputRowBean.getGiaBanKM())) {
				totalMoney += Double.parseDouble(sanPhamOutputRowBean.getGiaBanKM());
			} else {
				totalMoney += Double.parseDouble(sanPhamOutputRowBean.getGiaBan());
			}

		}

		KhachHangSession khachHangSession = (KhachHangSession) session.getAttribute("KhachHangSession");

		if (khachHangSession != null) {
			HoaDonInputBean hoaDonInputBean = new HoaDonInputBean();
			hoaDonInputBean.setIdHoaDon("");
			hoaDonInputBean.setIdKhachHang(khachHangSession.getIdKhachHang());
			hoaDonInputBean.setPathJSP(path);
			hoaDonInputBean.setSoLuongSP(String.valueOf(sanPhamOutputBean.getLst().size()));
			hoaDonInputBean.setTienKhuyenMai("");
			// 10000 d set duoc tinh la 1 diem
			hoaDonInputBean.setTongDiemTichLuy(String.valueOf(totalMoney / 10000));
			hoaDonInputBean.setTongTien(String.valueOf(totalMoney));
			hoaDonInputBean.setNgayLap(SMSComons.getDate());
			int cnt = HoaDonDAO.intances.insert(hoaDonInputBean);
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
					if (sanPhamOutputRowBean.getGiaBanKM() != null && "".equals(sanPhamOutputRowBean.getGiaBanKM())) {
						chiTietHoaDonInputBean.setGiaMua(sanPhamOutputRowBean.getGiaBanKM());
					} else {
						chiTietHoaDonInputBean.setGiaMua(sanPhamOutputRowBean.getGiaBan());
					}
					chiTietHoaDonInputBean.setLoaiSanPham(sanPhamOutputRowBean.getTenLoaiSP());
					chiTietHoaDonInputBean.setSoLuongSP("1");
					chiTietHoaDonInputBean.setThanhTien(chiTietHoaDonInputBean.getGiaMua());
					cnt = ChiTietHoaDonDAO.intances.insert(chiTietHoaDonInputBean);
					if(cnt != 1){
						return "redirect:/"+path;
					}
				}
			}else{
				return "redirect:/"+path;
			}
		}
		return "";
	}
}
