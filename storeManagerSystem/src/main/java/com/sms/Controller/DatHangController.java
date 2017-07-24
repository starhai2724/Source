package com.sms.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sms.OutputRows.SanPhamOutputRowBean;
import com.sms.common.SMSComons;
import com.sms.common.SystemCommon;
import com.sms.dao.CreateTableProductDAO;
import com.sms.dao.KhoHangDAO;
import com.sms.dao.LayoutDAO;
import com.sms.form.DatHangForm;
import com.sms.form.KhachHangForm;
import com.sms.formRows.ChiTietDatHangRowForm;
import com.sms.formRows.DatHangRowForm;
import com.sms.input.ChiTietDatHangInputBean;
import com.sms.input.DatHangInputBean;
import com.sms.input.SanPhamInputBean;
import com.sms.output.ChiTietDatHangOutputBean;
import com.sms.output.DatHangOutputBean;
import com.sms.output.DatHangOutputRowBean;
import com.sms.output.SanPhamOutputBean;

@Controller
@SessionAttributes(value ="DatHangForm", types = {DatHangForm.class})
public class DatHangController {

	public static final String DAT_HANG = "datHang.jsp";
	
	@ModelAttribute("DatHangForm")
	public DatHangForm getDatHangForm() {
	  return new DatHangForm(); //or however you create a default
	}
	
	@RequestMapping(value  = "/datHang/init")
	public String init(@ModelAttribute("DatHangForm") DatHangForm form, HttpSession session, Model model, BindingResult result){
		String pathJSP = (String)session.getAttribute("pathURL");
		// check pathJSP
		if (!LayoutDAO.intances.checkPathJSP(pathJSP)) {
			// quay ve trang login
			return "redirect:/";
		}
		//reset
		
		//Flag update
		form.setFlagUpdate("0");
		
		//reset message
		form.setMessage("");
		form.setMessageErr("");
		
		//init data
		initData(form, pathJSP);
		
		session.setAttribute("PAGEIDSTORE", DAT_HANG);
		return  SystemCommon.ADMIN_STORE;
	}
	
	@RequestMapping(value  = "/datHang/xoa/{id}", method = RequestMethod.POST)
	public String delete(@ModelAttribute("DatHangForm") DatHangForm form, HttpSession session, @PathVariable("id") String id){
		String pathJSP = (String)session.getAttribute("pathURL");
		// check pathJSP
		if (!LayoutDAO.intances.checkPathJSP(pathJSP)) {
			// quay ve trang login
			return "redirect:/";
		}
		//reset
		
		int cnt =0;
		DatHangOutputBean outputBean = KhoHangDAO.intances.getAll(pathJSP);
		
		for(DatHangOutputRowBean outputRowBean : outputBean.getDatHangOutputRowBeans()){
			if(outputRowBean.getIdDonHang().equals(id) && "1".equals(outputRowBean.getTrangThai()) ){
				form.setMessageErr("Không thể xóa đơn hàng đã hoàn thành.");
				session.setAttribute("PAGEIDSTORE", DAT_HANG);
				return  SystemCommon.ADMIN_STORE;
			}
		}
		
		cnt = KhoHangDAO.intances.deleteByIdDonHang(pathJSP, id);
		
		cnt = KhoHangDAO.intances.deleteChiTietDonHangByIdDonHang(pathJSP, id);
		
		//init data
		initData(form, pathJSP);
		
		if(cnt == 1){
			form.setMessage("Xử lý đăng kí thành công.");
			form.setMessageErr("");
		}else {
			form.setMessageErr("Xử lý đăng kí không thành công.");
			form.setMessage("");
		}
		
		session.setAttribute("PAGEIDSTORE", DAT_HANG);
		return  SystemCommon.ADMIN_STORE;
	}
	
	/**
	 * 
	 * @param form
	 * @param pathJSP
	 */
	
	private void initData(DatHangForm form, String pathJSP){
		
		//reset detail
		form.getDatHangRowForms().clear();
		form.getChiTietDatHangRowForms().clear();
		
		DatHangOutputBean outputBean = KhoHangDAO.intances.getAll(pathJSP);
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
	}
	
	@RequestMapping(value  = "/datHang/chonSanPham" , method = RequestMethod.POST)
	public String chonSanPham(@ModelAttribute("DatHangForm") DatHangForm form, HttpSession session, Model model){
		String pathJSP = (String)session.getAttribute("pathURL");
		// check pathJSP
		if (!LayoutDAO.intances.checkPathJSP(pathJSP)) {
			// quay ve trang login
			return "redirect:/";
		}
		
		session.setAttribute("LINK", "/datHang/initPhanAnh");
		session.setAttribute("PAGEIDSTORE", "/product/init");
		return  "redirect:/product/init";
	}
	
	/**
	 * 
	 * @param form
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value  = "/datHang/initPhanAnh", method = RequestMethod.GET)
	public String initPhanAnh(@ModelAttribute("DatHangForm") DatHangForm form, HttpSession session, Model model){
		String pathJSP = (String)session.getAttribute("pathURL");
		// check pathJSP
		if (!LayoutDAO.intances.checkPathJSP(pathJSP)) {
			// quay ve trang login
			return "redirect:/";
		}
		List<String> lst_id = (List<String>)session.getAttribute("lstPhanAnh");
		//th khong co san phan nao dc phan Anh.
		if(lst_id == null || lst_id.size() <= 0){
			session.setAttribute("PAGEIDSTORE", DAT_HANG);
			return  SystemCommon.ADMIN_STORE;
		}
		
		List<ChiTietDatHangRowForm> chiTietDatHangRowForms = form.getChiTietDatHangRowForms();
		boolean checkExist = false;
		SanPhamOutputBean outputBean;
		SanPhamInputBean input;
		SanPhamOutputRowBean outputRowBean;
		ChiTietDatHangRowForm chiTietDatHangRowForm;
		
		int cnt = 1;
		for (String id : lst_id){
			for(ChiTietDatHangRowForm rowForm : chiTietDatHangRowForms){
				if( id.equals(rowForm.getSEQ()) ){
					checkExist = true;
				}
			}
			// bang true t/h da ton tai
			if(checkExist)
				continue;
			
			input = new SanPhamInputBean();
			input.setPathJSP(pathJSP);
			input.setIdSanPham(id);
			input.setSEQ(id);
			//get data theo id va group theo id 
			chiTietDatHangRowForm = new ChiTietDatHangRowForm();
			outputBean = CreateTableProductDAO.intances.getProductById_GroupById(input);
			outputRowBean = outputBean.getLst().get(0);
			chiTietDatHangRowForm.setNo(String.valueOf(cnt++) );
			chiTietDatHangRowForm.setSEQ(outputRowBean.getSEQ());
			chiTietDatHangRowForm.setIdSanPham(outputRowBean.getIdSanPham());
			chiTietDatHangRowForm.setTenSanPham( outputRowBean.getIdSanPham() + ": " + outputRowBean.getTenSP());
			chiTietDatHangRowForm.setSoLuongNhap("1");
			chiTietDatHangRowForm.setGiaNhap("0");
			chiTietDatHangRowForm.setDiaChi("");
			chiTietDatHangRowForms.add(chiTietDatHangRowForm);
		}
		session.setAttribute("PAGEIDSTORE", DAT_HANG);
		return  SystemCommon.ADMIN_STORE;
	}
	
	@RequestMapping(value  = "/datHang/xoaDong/{listId}", method = RequestMethod.POST)
	public String xoaDong(@ModelAttribute("DatHangForm") DatHangForm form, HttpSession session, Model model, @PathVariable("listId") String listId){
		List<ChiTietDatHangRowForm> lst = form.getChiTietDatHangRowForms();
		
//		if(lst != null && form.getLst().size() > 0){
//			for(int i = 0; lst.size() > i; i++){
//				rowBean = lst.get(i);	
//		
//				System.out.println("checked: " + "i: "+ rowBean.getChecked());
//			}
//		}
		// remove ","
		if (!"".equals(listId)) {
			listId = listId.substring(1);
			String[] parts = listId.split(",");
			listId = "";
			for (int i = 0; i < parts.length; i++) {
				for(int k = 0; k < lst.size();k++){
					//Delete cac san pham dc chon
					if(parts[i].trim().equals(lst.get(k).getSEQ())){
						lst.remove(lst.get(k));
						System.out.println("size: "+ lst.size());
					}
				}
			}
		}
		session.setAttribute("PAGEIDSTORE", DAT_HANG);
		return  SystemCommon.ADMIN_STORE;
	}
	
	@RequestMapping(value ="/datHang/dangKy", method = RequestMethod.POST)
	public String insert(@ModelAttribute("DatHangForm") DatHangForm form, HttpSession session) {
		//get domain
		String pathJSP = (String)session.getAttribute("pathURL"); 
		// check pathJSP
		if (!LayoutDAO.intances.checkPathJSP(pathJSP)) {
			// quay ve trang login
			return "redirect:/";
		}
		
		DatHangInputBean inputBean = new DatHangInputBean();
		ChiTietDatHangInputBean chiTietDatHangInputBean;
		
		int soLuong = 0;
		double thanhTien = 0;
		for(ChiTietDatHangRowForm rowForm : form.getChiTietDatHangRowForms()){
			chiTietDatHangInputBean = new ChiTietDatHangInputBean();
			
			chiTietDatHangInputBean.setIdDotHang("");
			chiTietDatHangInputBean.setPathJSP(pathJSP);
			chiTietDatHangInputBean.setIdSanPham(rowForm.getIdSanPham());
			chiTietDatHangInputBean.setSoLuongNhap(rowForm.getSoLuongNhap());
			chiTietDatHangInputBean.setGiaNhap(rowForm.getGiaNhap());
			chiTietDatHangInputBean.setThanhTien(Double.parseDouble(rowForm.getGiaNhap()) * Integer.parseInt(rowForm.getSoLuongNhap()) + "");
			chiTietDatHangInputBean.setDiaChi(rowForm.getDiaChi());
			
			soLuong = soLuong + Integer.parseInt(rowForm.getSoLuongNhap()); 
			thanhTien = thanhTien + Double.parseDouble(rowForm.getGiaNhap()) * Integer.parseInt(rowForm.getSoLuongNhap()); 
			inputBean.getChiTietDatHangInputBeans().add(chiTietDatHangInputBean);
		}
		
		
		inputBean.setIdDonHang("");
		inputBean.setPathJSP(pathJSP);
		inputBean.setSoLuong(soLuong + "");
		inputBean.setThanhTien(thanhTien + "");
		inputBean.setNgayDatHang(SMSComons.getDate());
		inputBean.setNgayNhanHang("");
		inputBean.setTrangThai("0");
		
		int cnt = 0;
		
		cnt = KhoHangDAO.intances.insertDonHang(inputBean);
		if(cnt != 1){
			form.setMessageErr("Xử lý đăng kí không thành công.");
			form.setMessage("");
			session.setAttribute("PAGEIDSTORE", DAT_HANG);
			return  SystemCommon.ADMIN_STORE;
		}
		
		int idDonHang = SMSComons.convertInt(KhoHangDAO.intances.getMaxIdDonHang(inputBean.getPathJSP()));
		
		for (ChiTietDatHangInputBean bean : inputBean.getChiTietDatHangInputBeans()){
			bean.setIdDotHang(idDonHang +"");
			cnt = KhoHangDAO.intances.insertChiTietDonHang(bean);
			if(cnt != 1){
				form.setMessageErr("Xử lý đăng kí không thành công.");
				form.setMessage("");
				session.setAttribute("PAGEIDSTORE", DAT_HANG);
				return  SystemCommon.ADMIN_STORE;
			}
		}

		if(cnt == 1){
			form.setMessage("Xử lý đăng kí thành công.");
			form.setMessageErr("");
		}else {
			form.setMessageErr("Xử lý đăng kí không thành công.");
			form.setMessage("");
		}
		
		//init data
		initData(form, pathJSP);
		
		session.setAttribute("PAGEIDSTORE", DAT_HANG);
		return  SystemCommon.ADMIN_STORE;
	}
	
	@RequestMapping(value="/datHang/getById/{id}", method = RequestMethod.POST)
	public String getProductById(@ModelAttribute("DatHangForm") DatHangForm form, HttpSession session, @PathVariable("id") String id){
		//get domain
		String pathJSP = (String)session.getAttribute("pathURL"); 
		// check pathJSP
		if (!LayoutDAO.intances.checkPathJSP(pathJSP)) {
			// quay ve trang login
			return "redirect:/";
		}
		
		List<ChiTietDatHangOutputBean> lst = KhoHangDAO.intances.getChiTietHDonHangByIdDonHang(pathJSP, id);
		System.out.println("size: "+lst.size());
		ChiTietDatHangRowForm chiTietDatHangRowForm;
		form.getChiTietDatHangRowForms().clear();
		for(ChiTietDatHangOutputBean outputRowBean : lst){
			 System.out.println("id: "+outputRowBean.getIdSanPham());
			 
			 chiTietDatHangRowForm = new ChiTietDatHangRowForm();
			 chiTietDatHangRowForm.setIdDatHang(outputRowBean.getIdDotHang());
			 //su dung luc update;
			 form.setIdDatHang(outputRowBean.getIdDotHang());
			 chiTietDatHangRowForm.setSEQ(outputRowBean.getSEQ());
			 chiTietDatHangRowForm.setIdSanPham(outputRowBean.getIdSanPham());
			 chiTietDatHangRowForm.setTenSanPham(outputRowBean.getIdSanPham() +": "+outputRowBean.getTenSanPham() );
			 chiTietDatHangRowForm.setSoLuongNhap(outputRowBean.getSoLuongNhap());
			 chiTietDatHangRowForm.setGiaNhap(outputRowBean.getGiaNhap());
			 chiTietDatHangRowForm.setThanhTien(outputRowBean.getThanhTien());
			 chiTietDatHangRowForm.setDiaChi(outputRowBean.getDiaChi());
			 form.getChiTietDatHangRowForms().add(chiTietDatHangRowForm);
		}
		
		//Flag update
		form.setFlagUpdate("1");
		//init data
		
		session.setAttribute("PAGEIDSTORE", DAT_HANG);
		return  SystemCommon.ADMIN_STORE;
	}
	
	@RequestMapping(value="datHang/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("DatHangForm") DatHangForm form, HttpSession session){
		//get domain
		String pathJSP = (String)session.getAttribute("pathURL"); 
		// check pathJSP
		if (!LayoutDAO.intances.checkPathJSP(pathJSP)) {
			// quay ve trang login
			return "redirect:/";
		}
		int cnt = 0 ;
		
		DatHangInputBean inputBean = new DatHangInputBean();
		ChiTietDatHangInputBean chiTietDatHangInputBean;
		
		int soLuong = 0;
		double thanhTien = 0;
		for(ChiTietDatHangRowForm rowForm : form.getChiTietDatHangRowForms()){
			chiTietDatHangInputBean = new ChiTietDatHangInputBean();
			
			chiTietDatHangInputBean.setIdDotHang(rowForm.getIdDatHang());
			chiTietDatHangInputBean.setPathJSP(pathJSP);
			chiTietDatHangInputBean.setIdSanPham(rowForm.getIdSanPham());
			chiTietDatHangInputBean.setSoLuongNhap(rowForm.getSoLuongNhap());
			chiTietDatHangInputBean.setThanhTien(Double.parseDouble(rowForm.getGiaNhap()) * Integer.parseInt(rowForm.getSoLuongNhap()) + "");
			chiTietDatHangInputBean.setDiaChi(rowForm.getDiaChi());
			chiTietDatHangInputBean.setGiaNhap(rowForm.getGiaNhap());
			
			soLuong = soLuong + Integer.parseInt(rowForm.getSoLuongNhap()); 
			thanhTien = thanhTien + Double.parseDouble(rowForm.getGiaNhap()) * Integer.parseInt(rowForm.getSoLuongNhap()); 
			inputBean.getChiTietDatHangInputBeans().add(chiTietDatHangInputBean);
		}
		
		
		inputBean.setIdDonHang(form.getIdDatHang());
		inputBean.setPathJSP(pathJSP);
		inputBean.setSoLuong(soLuong + "");
		inputBean.setThanhTien(thanhTien + "");
		inputBean.setNgayDatHang(SMSComons.getDate());
		inputBean.setNgayNhanHang("");
		inputBean.setTrangThai("0");
		
		
		cnt = KhoHangDAO.intances.updateDonHang(inputBean);
		if(cnt != 1){
			form.setMessageErr("Xử lý đăng kí không thành công.");
			form.setMessage("");
			session.setAttribute("PAGEIDSTORE", DAT_HANG);
			return  SystemCommon.ADMIN_STORE;
		}
		
		for (ChiTietDatHangInputBean bean : inputBean.getChiTietDatHangInputBeans()){
			List<ChiTietDatHangOutputBean> lst = KhoHangDAO.intances.getChiTietHDonHangByIdDonHangAndIdSanPham(pathJSP, bean.getIdDotHang(), bean.getIdSanPham());
			if(lst != null && lst.size() > 0){
				cnt = KhoHangDAO.intances.updateChiTietDonHang(bean);
			}else {
				bean.setIdDotHang(inputBean.getIdDonHang());
				cnt = KhoHangDAO.intances.insertChiTietDonHang(bean);
			}
			if(cnt != 1){
				form.setMessageErr("Xử lý đăng kí không thành công.");
				form.setMessage("");
				session.setAttribute("PAGEIDSTORE", DAT_HANG);
				return  SystemCommon.ADMIN_STORE;
			}
		}
		
		if(cnt == 1){
			form.setMessage("Xử lý đăng kí thành công.");
			form.setMessageErr("");
		}else {
			form.setMessageErr("Xử lý đăng kí không thành công.");
			form.setMessage("");
		}
		
		//init data
		initData(form, pathJSP);
		
		session.setAttribute("PAGEIDSTORE", DAT_HANG);
		return  SystemCommon.ADMIN_STORE;
		
	}
	
	
}
