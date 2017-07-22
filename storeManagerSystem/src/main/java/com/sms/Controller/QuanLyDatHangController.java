package com.sms.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sms.common.SMSComons;
import com.sms.common.SystemCommon;
import com.sms.dao.KhoHangDAO;
import com.sms.dao.LayoutDAO;
import com.sms.form.DatHangForm;
import com.sms.formRows.ChiTietDatHangRowForm;
import com.sms.formRows.DatHangRowForm;
import com.sms.input.DatHangInputBean;
import com.sms.output.ChiTietDatHangOutputBean;
import com.sms.output.DanhSachCuaHangOuputBean;
import com.sms.output.DatHangOutputBean;
import com.sms.output.DatHangOutputRowBean;
import com.sms.output.KhoHangOutBean;

@Controller
@SessionAttributes(value ="DatHangForm", types = {DatHangForm.class})
public class QuanLyDatHangController {
	
	public static final String QUAN_LY_DH = "xacNhanDatHang.jsp";
	
	@ModelAttribute("DatHangForm")
	public DatHangForm getDatHangForm() {
	  return new DatHangForm(); //or however you create a default
	}
	
	@RequestMapping(value  = "/quanLyDatHang/init")
	public String init(@ModelAttribute("DatHangForm") DatHangForm form, HttpSession session, Model model){
		
		List<DanhSachCuaHangOuputBean> DanhSachCuaHangOuputBean = KhoHangDAO.intances.getDanhSachCuaHang();
		
		for(DanhSachCuaHangOuputBean outputBean : DanhSachCuaHangOuputBean){
			form.getDanhSachCuaHang().put(outputBean.getPathJSP(), outputBean.getIdStore()+":"+outputBean.getTenCuaHang() );
		}
		
		form.getLoaiTrangThai().put("0", "Đặt hàng");
		form.getLoaiTrangThai().put("1", "Xác nhận");
		form.getLoaiTrangThai().put("2", "Hoàn thành");
		//reset message
		form.setMessage("");
		form.setMessageErr("");
		//reset
		form.getDatHangRowForms().clear();
		form.getChiTietDatHangRowForms().clear();
		session.setAttribute(SystemCommon.PAGE_ID, QUAN_LY_DH);
		return SystemCommon.PAGE_HOME;
	}
	
	@RequestMapping(value  = "/quanLyDatHang/timkiem")
	public String timKiem(@ModelAttribute("DatHangForm") DatHangForm form, HttpSession session, Model model){
			
		//reset detail
		form.getDatHangRowForms().clear();
		form.getChiTietDatHangRowForms().clear();
		//reset message
		form.setMessage("");
		form.setMessageErr("");
		
		// check pathJSP
		if (!LayoutDAO.intances.checkPathJSP(form.getCuaHang())) {
			// quay ve trang login
			form.setMessage("");
			form.setMessageErr("Cửa hàng không tồn tại.");
			session.setAttribute(SystemCommon.PAGE_ID, QUAN_LY_DH);
			return SystemCommon.PAGE_HOME;
		}
		
		DatHangOutputBean outputBean = KhoHangDAO.intances.getAllByPathJSPAndTrangThai(form.getCuaHang(), form.getTrangThai());
		DatHangRowForm formRow; 
		int cnt = 1;
		if(outputBean != null && outputBean.getDatHangOutputRowBeans().size() > 0){
			for(int i = 0; outputBean.getDatHangOutputRowBeans().size() > i; i++){
				DatHangOutputRowBean outputRowBean = outputBean.getDatHangOutputRowBeans().get(i);	
				formRow = new DatHangRowForm();
				formRow.setNo(String.valueOf(cnt++));
				formRow.setIdDonHang(outputRowBean.getIdDonHang());
				formRow.setSoLuong(outputRowBean.getSoLuong());
				formRow.setThanhTien(outputRowBean.getThanhTien());
				formRow.setNgayDatHang(SMSComons.formatDate(outputRowBean.getNgayDatHang()));
				formRow.setNgayNhanHang(SMSComons.formatDate(outputRowBean.getNgayNhanHang()));
				formRow.setTenCuaHang(outputRowBean.getTenCuaHang());
				formRow.setDiaChiCuaHang(outputRowBean.getDiaChiCH());
				if("0".equals(outputRowBean.getTrangThai())  ){
					formRow.setTrangThai("Đặt hàng");
				}else if("1".equals(outputRowBean.getTrangThai())  ) {
					formRow.setTrangThai("Xác nhận");
				}else if("2".equals(outputRowBean.getTrangThai())  ) {
					formRow.setTrangThai("Hoàn thành");
				}
				form.getDatHangRowForms().add(formRow);
			}
		}
		
		session.setAttribute(SystemCommon.PAGE_ID, QUAN_LY_DH);
		return SystemCommon.PAGE_HOME;
	}
	
	@RequestMapping(value="/quanLyDatHang/getById/{id}", method = RequestMethod.POST)
	public String getProductById(@ModelAttribute("DatHangForm") DatHangForm form, HttpSession session, @PathVariable("id") String id){
		//reset message
		form.setMessage("");
		form.setMessageErr("");
		// check pathJSP
		if (!LayoutDAO.intances.checkPathJSP(form.getCuaHang())) {
			// quay ve trang login
			return "redirect:/";
		}
		
		List<ChiTietDatHangOutputBean> lst = KhoHangDAO.intances.getChiTietHDonHangByIdDonHang(form.getCuaHang(), id);
		ChiTietDatHangRowForm chiTietDatHangRowForm;
		form.getChiTietDatHangRowForms().clear();
		for(ChiTietDatHangOutputBean outputRowBean : lst){
			 chiTietDatHangRowForm = new ChiTietDatHangRowForm();
			 chiTietDatHangRowForm.setIdDatHang(outputRowBean.getIdDotHang());
			 //su dung luc update;
			 form.setIdDatHang(outputRowBean.getIdDotHang());
			 chiTietDatHangRowForm.setSEQ(outputRowBean.getSEQ());
			 chiTietDatHangRowForm.setIdSanPham(outputRowBean.getIdSanPham());
			 chiTietDatHangRowForm.setTenSanPham(outputRowBean.getIdSanPham() +": "+outputRowBean.getTenSanPham() );
			 chiTietDatHangRowForm.setSoLuongNhap(outputRowBean.getSoLuongNhap());
			 chiTietDatHangRowForm.setGiaNhap(outputRowBean.getGiaNhap());
			 chiTietDatHangRowForm.setThanhTien(Double.parseDouble(outputRowBean.getGiaNhap()) * Integer.parseInt(outputRowBean.getSoLuongNhap()) +"");
			 chiTietDatHangRowForm.setDiaChi(outputRowBean.getDiaChi());
			 form.getChiTietDatHangRowForms().add(chiTietDatHangRowForm);
		}
		
		session.setAttribute(SystemCommon.PAGE_ID, QUAN_LY_DH);
		return SystemCommon.PAGE_HOME;
	}
	
	@RequestMapping(value="/quanLyDatHang/xacNhan/{id}", method = RequestMethod.POST)
	public String xacNhan(@ModelAttribute("DatHangForm") DatHangForm form, HttpSession session, @PathVariable("id") String id){
		// check pathJSP
		if (!LayoutDAO.intances.checkPathJSP(form.getCuaHang())) {
			// quay ve trang login
			return "redirect:/";
		}
		
		DatHangInputBean inputBean = new DatHangInputBean();
		inputBean.setIdDonHang(id);
		inputBean.setPathJSP(form.getCuaHang());
		inputBean.setTrangThai("1");
		
		int cnt = 0;
		cnt = KhoHangDAO.intances.updateDonHang_XacNhan(inputBean);
		
		List<ChiTietDatHangOutputBean> chiTietDatHangOutputBeans= KhoHangDAO.intances.getChiTietHDonHangByIdDonHang(form.getCuaHang(), id);
		
		for(ChiTietDatHangOutputBean bean : chiTietDatHangOutputBeans){
			KhoHangOutBean khoHangOutBean = KhoHangDAO.intances.getAllKhoHangByIdSanPham(form.getCuaHang(),bean.getIdSanPham());
			if(khoHangOutBean != null){
				cnt = KhoHangDAO.intances.updateKhoHang(form.getCuaHang(), khoHangOutBean.getIdSanPham(), (Integer.parseInt(khoHangOutBean.getSoLuong()) + Integer.parseInt(bean.getSoLuongNhap() ) )+"");
			}
		}
		
		if(cnt == 1){
			form.setMessage("Xử lý xác nhận thành công.");
			form.setMessageErr("");
		}else {
			form.setMessageErr("Xử lý xác nhận không thành công.");
			form.setMessage("");
		}
		
		session.setAttribute(SystemCommon.PAGE_ID, QUAN_LY_DH);
		return SystemCommon.PAGE_HOME;
	}
}
