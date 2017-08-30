package com.sms.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sms.OutputRows.ThongkeTheoKhachHangOutputRowBean;
import com.sms.OutputRows.ThongkeTheoSanPhamOutputRowBean;
import com.sms.common.SMSComons;
import com.sms.common.SystemCommon;
import com.sms.dao.LayoutDAO;
import com.sms.dao.ThongKeDAO;
import com.sms.form.TKeForm;
import com.sms.formRows.ThongkeTheoKhachHangRowForm;
import com.sms.formRows.ThongkeTheoSanPhamRowForm;
import com.sms.input.ThongKeInputBean;
import com.sms.output.ThongkeOutputBean;

@Controller
public class ThongKeCtrl {

	public static final String PAGE = "thongKeTheoSanPham.jsp";
	
	public static final String PAGE_KH = "thongKeTheoKhachHang.jsp";
	
	@RequestMapping(value  = "/thongKe/sanPham/init")
	public String initSanPham(@ModelAttribute("TKeForm") TKeForm form, HttpSession session){
		String pathJSP = (String)session.getAttribute("pathURL");
		// check pathJSP
		if (!LayoutDAO.intances.checkPathJSP(pathJSP)) {
			// quay ve trang login
			return "redirect:/";
		}
		
		form.setNgayBatDau("");
		form.setNgayKetThuc("");
		
		initDataSanPham(form, pathJSP);
		
		session.setAttribute("PAGEIDSTORE", PAGE);
		return  SystemCommon.ADMIN_STORE;
	}
	
	private void initDataSanPham(TKeForm form, String pathJSP){
		ThongKeInputBean inputBean = new ThongKeInputBean();
		inputBean.setPathJSP(pathJSP);
		ThongkeOutputBean outputBean = ThongKeDAO.intances.getSanPham(inputBean);
		ThongkeTheoSanPhamRowForm rowForm;
		for(ThongkeTheoSanPhamOutputRowBean outputRowBean: outputBean.getLst()){
			rowForm = new ThongkeTheoSanPhamRowForm();
			rowForm.setSEQ(outputRowBean.getSEQ());
			rowForm.setIdSanPham(outputRowBean.getIdSanPham());
			rowForm.setTenSP(outputRowBean.getTenSP());
			rowForm.setTenLoaiSP(outputRowBean.getTenLoaiSP());
			rowForm.setSoLuong(outputRowBean.getSoLuong());
			rowForm.setGiaMua(outputRowBean.getGiaMua());
			rowForm.setGiaBan(outputRowBean.getGiaBan());
			rowForm.setThanhTien(outputRowBean.getThanhTien());
			rowForm.setTienLoi(SMSComons.tru(outputRowBean.getThanhTien(), SMSComons.nhan(outputRowBean.getGiaBan(), outputRowBean.getSoLuong())+"")+"");
			form.getLst().add(rowForm);
		}
	}
	
	@RequestMapping(value  = "/thongKe/sanPham/timKiem", method=RequestMethod.POST)
	public String timKiem(@ModelAttribute("TKeForm") TKeForm form, HttpSession session){
		String pathJSP = (String)session.getAttribute("pathURL");
		// check pathJSP
		if (!LayoutDAO.intances.checkPathJSP(pathJSP)) {
			// quay ve trang login
			return "redirect:/";
		}
		ThongKeInputBean inputBean = new ThongKeInputBean();
		inputBean.setPathJSP(pathJSP);
		inputBean.setNgayBatDau(SMSComons.formatDateInput(form.getNgayBatDau()));
		inputBean.setNgayKetThuc(SMSComons.formatDateInput(form.getNgayKetThuc()));
		ThongkeOutputBean outputBean;
		if(form.getNgayBatDau() == null || "".equals(form.getNgayBatDau()) || form.getNgayKetThuc() == null || "".equals(form.getNgayKetThuc())){
			outputBean = ThongKeDAO.intances.getSanPham(inputBean);
		}else{
			outputBean = ThongKeDAO.intances.getSanPhamByThoiGian(inputBean);
		}
		ThongkeTheoSanPhamRowForm rowForm;
		for(ThongkeTheoSanPhamOutputRowBean outputRowBean: outputBean.getLst()){
			rowForm = new ThongkeTheoSanPhamRowForm();
			rowForm.setSEQ(outputRowBean.getSEQ());
			rowForm.setIdSanPham(outputRowBean.getIdSanPham());
			rowForm.setTenSP(outputRowBean.getTenSP());
			rowForm.setTenLoaiSP(outputRowBean.getTenLoaiSP());
			rowForm.setSoLuong(outputRowBean.getSoLuong());
			rowForm.setGiaMua(outputRowBean.getGiaMua());
			rowForm.setGiaBan(outputRowBean.getGiaBan());
			rowForm.setThanhTien(outputRowBean.getThanhTien());
			rowForm.setTienLoi(SMSComons.tru(outputRowBean.getThanhTien(), SMSComons.nhan(outputRowBean.getGiaBan(), outputRowBean.getSoLuong())+"")+"");
			form.getLst().add(rowForm);
		}
		session.setAttribute("PAGEIDSTORE", PAGE);
		return  SystemCommon.ADMIN_STORE;
	}
	
	@RequestMapping(value  = "/thongKe/khachHang/init")
	public String initKhachHang(@ModelAttribute("TKeForm") TKeForm form, HttpSession session){
		String pathJSP = (String)session.getAttribute("pathURL");
		// check pathJSP
		if (!LayoutDAO.intances.checkPathJSP(pathJSP)) {
			// quay ve trang login
			return "redirect:/";
		}
		
		form.setNgayBatDau("");
		form.setNgayKetThuc("");
		
		initDataKhachHang(form, pathJSP);
		
		session.setAttribute("PAGEIDSTORE", PAGE_KH);
		return  SystemCommon.ADMIN_STORE;
	}
	
	private void initDataKhachHang(TKeForm form, String pathJSP){
		ThongKeInputBean inputBean = new ThongKeInputBean();
		inputBean.setPathJSP(pathJSP);
		ThongkeOutputBean outputBean = ThongKeDAO.intances.getKhachHang(inputBean);
		ThongkeTheoKhachHangRowForm rowForm;
		for(ThongkeTheoKhachHangOutputRowBean outputRowBean: outputBean.getThongkeTheoKhachHangOutputRowBeans()){
			rowForm = new ThongkeTheoKhachHangRowForm();
			rowForm.setIdKhachHang(outputRowBean.getIdKhachHang());
			rowForm.setTenKhachHang(": "+outputRowBean.getTenKhachHang());
			rowForm.setSDT(outputRowBean.getSDT());
			rowForm.setDiaChi(outputRowBean.getDiaChi());
			rowForm.setSL(outputRowBean.getSL());
			rowForm.setDiemTichLuy(outputRowBean.getDiemTichLuy());
			rowForm.setTongTien(outputRowBean.getTongTien());
			form.getKhachHangRowForms().add(rowForm);
		}
	}
	
	@RequestMapping(value  = "/thongKe/khachHang/timKiem", method=RequestMethod.POST)
	public String timKiemKhachHang(@ModelAttribute("TKeForm") TKeForm form, HttpSession session){
		String pathJSP = (String)session.getAttribute("pathURL");
		// check pathJSP
		if (!LayoutDAO.intances.checkPathJSP(pathJSP)) {
			// quay ve trang login
			return "redirect:/";
		}
		ThongKeInputBean inputBean = new ThongKeInputBean();
		inputBean.setPathJSP(pathJSP);
		inputBean.setNgayBatDau(SMSComons.formatDateInput(form.getNgayBatDau()));
		inputBean.setNgayKetThuc(SMSComons.formatDateInput(form.getNgayKetThuc()));
		ThongkeOutputBean outputBean;
		if(form.getNgayBatDau() == null || "".equals(form.getNgayBatDau()) || form.getNgayKetThuc() == null || "".equals(form.getNgayKetThuc())){
			outputBean = ThongKeDAO.intances.getKhachHang(inputBean);
		}else{
			outputBean = ThongKeDAO.intances.getKhachHangTheoThoiGian(inputBean);
		}
		ThongkeTheoKhachHangRowForm rowForm;
		for(ThongkeTheoKhachHangOutputRowBean outputRowBean: outputBean.getThongkeTheoKhachHangOutputRowBeans()){
			rowForm = new ThongkeTheoKhachHangRowForm();
			rowForm.setIdKhachHang(outputRowBean.getIdKhachHang());
			rowForm.setTenKhachHang(": "+outputRowBean.getTenKhachHang());
			rowForm.setSDT(outputRowBean.getSDT());
			rowForm.setDiaChi(outputRowBean.getDiaChi());
			rowForm.setSL(outputRowBean.getSL());
			rowForm.setDiemTichLuy(outputRowBean.getDiemTichLuy());
			rowForm.setTongTien(outputRowBean.getTongTien());
			form.getKhachHangRowForms().add(rowForm);
		}
		session.setAttribute("PAGEIDSTORE", PAGE);
		return  SystemCommon.ADMIN_STORE;
	}
	
}
