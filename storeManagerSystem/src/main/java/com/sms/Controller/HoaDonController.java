package com.sms.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sms.OutputRows.ChiTietHoaDonOutputRowBean;
import com.sms.OutputRows.HoaDonOutputRowBean;
import com.sms.OutputRows.KhachHangOutputRowBean;
import com.sms.common.SMSComons;
import com.sms.common.SystemCommon;
import com.sms.dao.ChiTietHoaDonDAO;
import com.sms.dao.HoaDonDAO;
import com.sms.dao.KhachHangDAO;
import com.sms.dao.LayoutDAO;
import com.sms.form.HoaDonForm;
import com.sms.form.KhachHangForm;
import com.sms.formRows.ChiTietHoaDonRowForm;
import com.sms.formRows.HoaDonRowForm;
import com.sms.formRows.KhachHangRowForm;
import com.sms.input.ChiTietHoaDonInputBean;
import com.sms.input.HoaDonInputBean;
import com.sms.input.KhachHangInputBean;

@Controller
public class HoaDonController {

	public static final String PAGE = "hoaDon.jsp";
	
	@RequestMapping(value  = "/bill/init")
	public String init(@ModelAttribute("HoaDonForm") HoaDonForm form, HttpSession session){
		String pathJSP = (String)session.getAttribute("pathURL"); 
		// check pathJSP
		if (!LayoutDAO.intances.checkPathJSP(pathJSP)) {
			// quay ve trang login
			return "redirect:/";
		}
		//reset
		form.setIdHoaDon("");
		form.setIdKhachHang("");
		form.setNgayLap("");
		form.setSoLuongSP("");
		form.setDiemTichLuy("");
		form.setTongDiemTichLuy("");
		form.setTienKhuyenMai("");
		form.setTongTien("");
		//Flag update
		form.setFlagUpdate("0");
		
		//reset message
		form.setMessage("");
		form.setMessageErr("");
		
		//init data
		initData(form, pathJSP);
		session.setAttribute("PAGEIDSTORE", PAGE);
		return  SystemCommon.ADMIN_STORE;
	}
		
	/**
	 * 
	 * @param form
	 * @param pathJSP
	 */
	
	private void initData(HoaDonForm form, String pathJSP){
		
		List<HoaDonOutputRowBean> lst = HoaDonDAO.intances.getAll(pathJSP);
		
		HoaDonRowForm formRow; 
		int cnt = 1;
		if(lst != null && lst.size() > 0){
			for(int i = 0; lst.size() > i; i++){
				HoaDonOutputRowBean outputRowBean = lst.get(i);	
				formRow = new HoaDonRowForm();
				formRow.setNo(String.valueOf(cnt++));
				formRow.setIdHoaDon(outputRowBean.getIdHoaDon());
				formRow.setIdKhachHang(outputRowBean.getIdKhachHang());
				formRow.setNgayLap(SMSComons.formatDate(outputRowBean.getNgayLap()));
				formRow.setSoLuongSP(outputRowBean.getSoLuongSP());
				formRow.setDiemTichLuy(outputRowBean.getDiemTichLuy());
				formRow.setTongDiemTichLuy(outputRowBean.getTongDiemTichLuy());
				formRow.setTienKhuyenMai(SMSComons.formatMoney(outputRowBean.getTienKhuyenMai()));
				formRow.setTongTien(SMSComons.formatMoney(outputRowBean.getTongTien()));
				form.getLst().add(formRow);
			}
		}
		
	}
	
	/**
	 * 
	 * @param form
	 * @param session
	 * @return
	 */
	
	@RequestMapping(value ="/bill/insert", method = RequestMethod.POST)
	public String insert(@ModelAttribute("HoaDonForm") HoaDonForm form, HttpSession session) {
		//get domain
		String pathJSP = (String)session.getAttribute("pathURL");
		// check pathJSP
		if (!LayoutDAO.intances.checkPathJSP(pathJSP)) {
			// quay ve trang login
			return "redirect:/";
		}
		//input
		HoaDonInputBean inputBean = new HoaDonInputBean();
		inputBean.setPathJSP(pathJSP);
		inputBean.setIdHoaDon("");
		inputBean.setIdKhachHang(form.getIdKhachHang());
		inputBean.setNgayLap(SMSComons.getDate());
		inputBean.setSoLuongSP(form.getSoLuongSP());
		inputBean.setDiemTichLuy(form.getDiemTichLuy());
		inputBean.setTongDiemTichLuy(form.getTongDiemTichLuy());
		inputBean.setTienKhuyenMai(form.getTienKhuyenMai());
		inputBean.setTongTien(form.getTongTien());
		//insert
		int cnt = HoaDonDAO.intances.insert(inputBean);
		
		if(cnt == 1){
			form.setMessage("Xử lý đăng kí thành công.");
			form.setMessageErr("");
		}else {
			form.setMessageErr("Xử lý đăng kí không thành công.");
			form.setMessage("");
		}
		
		//init data
		initData(form, pathJSP);
		
		session.setAttribute("PAGEIDSTORE", PAGE);
		return  SystemCommon.ADMIN_STORE;
	}
	/**
	 * 
	 * @param form
	 * @param session
	 * @return
	 */
	
	@RequestMapping(value ="/bill/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("HoaDonForm") HoaDonForm form, HttpSession session){
		//get domain
		String pathJSP = (String)session.getAttribute("pathURL");
		// check pathJSP
		if (!LayoutDAO.intances.checkPathJSP(pathJSP)) {
			// quay ve trang login
			return "redirect:/";
		}
		
		//input
		HoaDonInputBean inputBean = new HoaDonInputBean();
		inputBean.setPathJSP(pathJSP);
		inputBean.setIdHoaDon("");
		inputBean.setIdKhachHang(form.getIdKhachHang());
		inputBean.setNgayLap(SMSComons.getDate());
		inputBean.setSoLuongSP(form.getSoLuongSP());
		inputBean.setDiemTichLuy(form.getDiemTichLuy());
		inputBean.setTongDiemTichLuy(form.getTongDiemTichLuy());
		inputBean.setTienKhuyenMai(form.getTienKhuyenMai());
		inputBean.setTongTien(form.getTongTien());
		
		//insert
		int cnt = HoaDonDAO.intances.update(inputBean);
		
		if(cnt == 1){
			form.setMessage("Xử lý đăng kí thành công.");
			form.setMessageErr("");
			//Flag update
			form.setFlagUpdate("0");
		}else {
			form.setMessageErr("Xử lý đăng kí không thành công.");
			form.setMessage("");
		}
		//init data
		initData(form, pathJSP);
		
		session.setAttribute("PAGEIDSTORE", PAGE);
		return  SystemCommon.ADMIN_STORE;
	}
	
	/**
	 * 
	 * @param form
	 * @param id
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/bill/getById/{id}", method = RequestMethod.POST)
	public String getProductById(@ModelAttribute("HoaDonForm") HoaDonForm form, @PathVariable("id") String id, HttpSession session){
		//get domain
		String pathJSP = (String)session.getAttribute("pathURL");
		// check pathJSP
		if (!LayoutDAO.intances.checkPathJSP(pathJSP)) {
			// quay ve trang login
			return "redirect:/";
		}
		HoaDonInputBean inputBean = new HoaDonInputBean();
		inputBean.setPathJSP(pathJSP);
		inputBean.setIdHoaDon(id);
		
		
		List<HoaDonOutputRowBean> lst = HoaDonDAO.intances.getById(inputBean);
		HoaDonOutputRowBean outputRowBean = lst.get(0);
		form.setIdHoaDon(outputRowBean.getIdHoaDon());
		form.setIdKhachHang(outputRowBean.getIdKhachHang());
//		form.setNgayLap(outputRowBean.getNgayLap());
//		form.setSoLuongSP(outputRowBean.getSoLuongSP());
//		form.setDiemTichLuy(outputRowBean.getDiemTichLuy());
//		form.setTongDiemTichLuy(outputRowBean.getTongDiemTichLuy());
//		form.setTienKhuyenMai(outputRowBean.getTienKhuyenMai());
//		form.setTongTien(outputRowBean.getTongTien());
		ChiTietHoaDonInputBean chiTietHoaDonInputBean = new ChiTietHoaDonInputBean();
		chiTietHoaDonInputBean.setPathJSP(pathJSP);
		chiTietHoaDonInputBean.setIdHoaDon(id);
		List<ChiTietHoaDonOutputRowBean>  chiTietHoaDonOutputRowBeans = ChiTietHoaDonDAO.intances.getById(chiTietHoaDonInputBean);
		ChiTietHoaDonRowForm chiTietHoaDonRowForm;
		int cnt = 1;
		for(ChiTietHoaDonOutputRowBean chiTietHoaDonOutputRowBean : chiTietHoaDonOutputRowBeans){
			chiTietHoaDonRowForm = new ChiTietHoaDonRowForm();
			chiTietHoaDonRowForm.setNo(String.valueOf(cnt++));
			chiTietHoaDonRowForm.setIdChiTietHoaDon(chiTietHoaDonOutputRowBean.getIdChiTietHoaDon());
			chiTietHoaDonRowForm.setIdSanPham(chiTietHoaDonOutputRowBean.getIdSanPham());
			chiTietHoaDonRowForm.setLoaiSanPham(chiTietHoaDonOutputRowBean.getLoaiSanPham());
			chiTietHoaDonRowForm.setTenSanPham(chiTietHoaDonOutputRowBean.getTenSanPham());
			chiTietHoaDonRowForm.setSoLuongSP(chiTietHoaDonOutputRowBean.getSoLuongSP());
			chiTietHoaDonRowForm.setGiaMua(SMSComons.formatMoney(chiTietHoaDonOutputRowBean.getGiaMua()));
			chiTietHoaDonRowForm.setThanhTien(SMSComons.formatMoney(chiTietHoaDonOutputRowBean.getThanhTien()));
			form.getChiTietHoaDonRowForms().add(chiTietHoaDonRowForm);
		}
		
		
		//Flag update
		form.setFlagUpdate("1");
		
		//init data
		initData(form, pathJSP);
		
		session.setAttribute("PAGEIDSTORE",PAGE);
		return  SystemCommon.ADMIN_STORE;
	}
	
	/**
	 * 
	 * @param form
	 * @param id
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/bill/delete/{id}")
	public String delete(@ModelAttribute("HoaDonForm") HoaDonForm form, @PathVariable("id") String id, HttpSession session){
		//get domain
		String pathJSP = (String)session.getAttribute("pathURL");
		// check pathJSP
		if (!LayoutDAO.intances.checkPathJSP(pathJSP)) {
			// quay ve trang login
			return "redirect:/";
		}
		HoaDonInputBean input = new HoaDonInputBean();	
		input.setPathJSP(pathJSP);
		input.setIdHoaDon(id);
		
		//delete
		int cnt = HoaDonDAO.intances.deleteById(input);
		
		//delete chi tiet hoa don
		ChiTietHoaDonInputBean chiTietHoaDonInputBean = new ChiTietHoaDonInputBean();
		chiTietHoaDonInputBean.setPathJSP(pathJSP);
		chiTietHoaDonInputBean.setIdHoaDon(id);
		cnt = ChiTietHoaDonDAO.intances.deleteById(chiTietHoaDonInputBean);
		if(cnt == 1){
			form.setMessage("Xử lý xóa thành công.");
			form.setMessageErr("");
		}else {
			form.setMessageErr("Xử lý xóa không thành công.");
			form.setMessage("");
		}
		//init data
		initData(form, pathJSP);
		
		session.setAttribute("PAGEIDSTORE", PAGE);
		return  SystemCommon.ADMIN_STORE;
	}
	
}
