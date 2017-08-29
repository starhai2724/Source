package com.sms.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sms.OutputRows.ThongkeTheoSanPhamOutputRowBean;
import com.sms.common.SMSComons;
import com.sms.common.SystemCommon;
import com.sms.dao.LayoutDAO;
import com.sms.dao.ThongKeDAO;
import com.sms.form.ThongkeTheoSanPhamForm;
import com.sms.formRows.ThongkeTheoSanPhamRowForm;
import com.sms.input.ThongkeTheoSanPhamInputBean;
import com.sms.output.ThongkeTheoSanPhamOutputBean;

@Controller
public class ThongKeTheoSanPham {

	public static final String PAGE = "thongKeTheoSanPham.jsp";
	
	
	@RequestMapping(value  = "/thongKe/sanPham/init")
	public String init(@ModelAttribute("ThongkeTheoSanPhamForm") ThongkeTheoSanPhamForm form, HttpSession session){
		String pathJSP = (String)session.getAttribute("pathURL");
		// check pathJSP
		if (!LayoutDAO.intances.checkPathJSP(pathJSP)) {
			// quay ve trang login
			return "redirect:/";
		}
		
		form.setNgayBatDau("");
		form.setNgayKetThuc("");
		
		initData(form, pathJSP);
		
		session.setAttribute("PAGEIDSTORE", PAGE);
		return  SystemCommon.ADMIN_STORE;
	}
	
	private void initData(ThongkeTheoSanPhamForm form, String pathJSP){
		ThongkeTheoSanPhamInputBean inputBean = new ThongkeTheoSanPhamInputBean();
		inputBean.setPathJSP(pathJSP);
		ThongkeTheoSanPhamOutputBean outputBean = ThongKeDAO.intances.getSanPham(inputBean);
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
	public String timKiem(@ModelAttribute("ThongkeTheoSanPhamForm") ThongkeTheoSanPhamForm form, HttpSession session){
		String pathJSP = (String)session.getAttribute("pathURL");
		// check pathJSP
		if (!LayoutDAO.intances.checkPathJSP(pathJSP)) {
			// quay ve trang login
			return "redirect:/";
		}
		ThongkeTheoSanPhamInputBean inputBean = new ThongkeTheoSanPhamInputBean();
		inputBean.setPathJSP(pathJSP);
		inputBean.setNgayBatDau(SMSComons.formatDateInput(form.getNgayBatDau()));
		inputBean.setNgayKetThuc(SMSComons.formatDateInput(form.getNgayKetThuc()));
		ThongkeTheoSanPhamOutputBean outputBean;
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
}
