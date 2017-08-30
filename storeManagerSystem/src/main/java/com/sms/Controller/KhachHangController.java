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
import org.springframework.web.servlet.ModelAndView;

import com.sms.OutputRows.KhachHangOutputRowBean;
import com.sms.common.SMSComons;
import com.sms.common.SystemCommon;
import com.sms.dao.KhachHangDAO;
import com.sms.dao.LayoutDAO;
import com.sms.form.KhachHangForm;
import com.sms.formRows.KhachHangRowForm;
import com.sms.input.KhachHangInputBean;

@Controller
@SessionAttributes(value ="KhachHangForm", types = {KhachHangForm.class})
public class KhachHangController {

	public static final String CUSTOMER = "customer.jsp";
	
	@ModelAttribute("KhachHangForm")
	public KhachHangForm getKhachHangForm() {
	  return new KhachHangForm(); //or however you create a default
	}
	
	
	@RequestMapping(value  = "/customer/init")
	public String init(@ModelAttribute("KhachHangForm") KhachHangForm form, HttpSession session, Model model, BindingResult result){
		String pathJSP = (String)session.getAttribute("pathURL");
		// check pathJSP
		if (!LayoutDAO.intances.checkPathJSP(pathJSP)) {
			// quay ve trang login
			return "redirect:/";
		}
		if (result.hasErrors()) {
			return SystemCommon.PAGE_LOGIN;
	    }
		
		//reset
		form.setIdKhachHang("");
		form.setTenKhachHang("");
		form.setLoaiThe("");
		form.setGioiTinh("");
		form.setDiaChi("");
		form.setNgaySinh("");
		form.setSoDienThoai("");
		form.setSoDiem("");
		//Flag update
		form.setFlagUpdate("0");
		
		//reset message
		form.setMessage("");
		form.setMessageErr("");
		
		//init data
		initData(form, pathJSP);
		
		session.setAttribute("PAGEIDSTORE", CUSTOMER);
		return  SystemCommon.ADMIN_STORE;
	}
	
	/**
	 * 
	 * @param form
	 * @param pathJSP
	 */
	
	private void initData(KhachHangForm form, String pathJSP){
		//Loai the
		form.getLstCards().put("01", "Thành viên");
		form.getLstCards().put("02", "Vip");
		
		//Gioi tinh
		form.getLstGioiTinh().put("Nam", "Nam");
		form.getLstGioiTinh().put("Nữ", "Nữ");
		
		//reset detail
		form.getLst().clear();
		
		List<KhachHangOutputRowBean> lst = KhachHangDAO.intances.getAll(pathJSP);
		KhachHangRowForm formRow; 
		int cnt = 1;
		if(lst != null && lst.size() > 0){
			for(int i = 0; lst.size() > i; i++){
				KhachHangOutputRowBean outputRowBean = lst.get(i);	
				formRow = new KhachHangRowForm();
				formRow.setNo(String.valueOf(cnt++));
				formRow.setIdKhachHang(outputRowBean.getIdKhachHang());
				formRow.setTenKhachHang(outputRowBean.getTenKhachHang());
				if("01".equals(outputRowBean.getLoaiThe())){
					formRow.setLoaiThe("Thành viên");
				}else {
					formRow.setLoaiThe("Vip");
				}
				formRow.setGioiTinh(outputRowBean.getGioiTinh());
				formRow.setSoDienThoai(outputRowBean.getSoDienThoai());
				formRow.setDiaChi(outputRowBean.getDiaChi());
				formRow.setSoDiem(outputRowBean.getSoDiem());
				formRow.setNgaySinh(SMSComons.formatDate(outputRowBean.getNgaySinh()));
				formRow.setNgayTao(SMSComons.formatDate(outputRowBean.getNgayTao()));
				formRow.setNgaySua(SMSComons.formatDate(outputRowBean.getNgaySua()));
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
	
	@RequestMapping(value ="/customer/insert", method = RequestMethod.POST)
	public String insert(@ModelAttribute("KhachHangForm") KhachHangForm form, HttpSession session) {
		//get domain
		String pathJSP = (String)session.getAttribute("pathURL");
		// check pathJSP
		if (!LayoutDAO.intances.checkPathJSP(pathJSP)) {
			// quay ve trang login
			return "redirect:/";
		}
		//input
		KhachHangInputBean inputBean = new KhachHangInputBean();
		inputBean.setPathJSP(pathJSP);
		inputBean.setIdKhachHang("");
		inputBean.setTenKhachHang(form.getTenKhachHang());
		inputBean.setLoaiThe(form.getLoaiThe());
		inputBean.setGioiTinh(form.getGioiTinh());
		inputBean.setSoDienThoai(form.getSoDienThoai());
		inputBean.setDiaChi(form.getDiaChi());
		inputBean.setSoDiem(form.getSoDiem());
		inputBean.setNgaySinh(SMSComons.formatDateInput(form.getNgaySinh()));
		inputBean.setNgayTao(SMSComons.getDate());
		inputBean.setNgaySua("");
		
		//insert
		int cnt = KhachHangDAO.intances.insert(inputBean);
		
		if(cnt == 1){
			form.setMessage("Xử lý đăng kí thành công.");
			form.setMessageErr("");
		}else {
			form.setMessageErr("Xử lý đăng kí không thành công.");
			form.setMessage("");
		}
		
		//reset
		form.setIdKhachHang("");
		form.setTenKhachHang("");
		form.setLoaiThe("");
		form.setGioiTinh("");
		form.setDiaChi("");
		form.setNgaySinh("");
		form.setSoDienThoai("");
		form.setSoDiem("");
		//Flag update
		form.setFlagUpdate("0");
		
		//init data
		initData(form, pathJSP);
		
		session.setAttribute("PAGEIDSTORE", CUSTOMER);
		return  SystemCommon.ADMIN_STORE;
	}
	/**
	 * 
	 * @param form
	 * @param session
	 * @return
	 */
	
	@RequestMapping(value ="/customer/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("KhachHangForm") KhachHangForm form, HttpSession session){
		//get domain
		String pathJSP = (String)session.getAttribute("pathURL");
		// check pathJSP
		if (!LayoutDAO.intances.checkPathJSP(pathJSP)) {
			// quay ve trang login
			return "redirect:/";
		}
		
		//input
		KhachHangInputBean inputBean = new KhachHangInputBean();
		inputBean.setPathJSP(pathJSP);
		inputBean.setIdKhachHang(form.getIdKhachHang());
		inputBean.setTenKhachHang(form.getTenKhachHang());
		inputBean.setLoaiThe(form.getLoaiThe());
		inputBean.setGioiTinh(form.getGioiTinh());
		inputBean.setSoDienThoai(form.getSoDienThoai());
		inputBean.setDiaChi(form.getDiaChi());
		inputBean.setSoDiem(form.getSoDiem());
		inputBean.setNgaySinh(SMSComons.formatDateInput(form.getNgaySinh()));
		inputBean.setNgayTao(SMSComons.getDate());
		inputBean.setNgaySua("");
		
		//insert
		int cnt = KhachHangDAO.intances.update(inputBean);
		
		if(cnt == 1){
			form.setMessage("Xử lý đăng kí thành công.");
			form.setMessageErr("");
			//Flag update
			form.setFlagUpdate("0");
		}else {
			form.setMessageErr("Xử lý đăng kí không thành công.");
			form.setMessage("");
		}
		
		//reset
		form.setIdKhachHang("");
		form.setTenKhachHang("");
		form.setLoaiThe("");
		form.setGioiTinh("");
		form.setDiaChi("");
		form.setNgaySinh("");
		form.setSoDienThoai("");
		form.setSoDiem("");
		//Flag update
		form.setFlagUpdate("0");
		
		//init data
		initData(form, pathJSP);
		
		session.setAttribute("PAGEIDSTORE", CUSTOMER);
		return  SystemCommon.ADMIN_STORE;
	}
	
	/**
	 * 
	 * @param form
	 * @param id
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/customer/getById/{id}", method = RequestMethod.POST)
	public String getProductById(@ModelAttribute("KhachHangForm") KhachHangForm form, @PathVariable("id") String id, HttpSession session){
		
		//get domain
		String pathJSP = (String)session.getAttribute("pathURL");
		// check pathJSP
		if (!LayoutDAO.intances.checkPathJSP(pathJSP)) {
			// quay ve trang login
			return "redirect:/";
		}
		KhachHangInputBean inputBean = new KhachHangInputBean();
		inputBean.setPathJSP(pathJSP);
		inputBean.setIdKhachHang(id);
		
		List<KhachHangOutputRowBean> lst = KhachHangDAO.intances.getById(inputBean);
		KhachHangOutputRowBean khachHangOutputRowBean = lst.get(0);
		form.setIdKhachHang(khachHangOutputRowBean.getIdKhachHang());
		form.setTenKhachHang(khachHangOutputRowBean.getTenKhachHang());
		form.setLoaiThe(khachHangOutputRowBean.getLoaiThe());
		form.setGioiTinh(khachHangOutputRowBean.getGioiTinh());
		form.setDiaChi(khachHangOutputRowBean.getDiaChi());
		form.setNgaySinh(SMSComons.formatDateForm(khachHangOutputRowBean.getNgaySinh()) );
		form.setSoDienThoai(khachHangOutputRowBean.getSoDienThoai());
		form.setSoDiem(khachHangOutputRowBean.getSoDiem());
		
		//Flag update
		form.setFlagUpdate("1");
		
		//init data
		initData(form, pathJSP);
		
		session.setAttribute("PAGEIDSTORE",CUSTOMER);
		return  SystemCommon.ADMIN_STORE;
	}
	
	/**
	 * 
	 * @param form
	 * @param id
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/customer/delete/{id}")
	public String delete(@ModelAttribute("KhachHangForm") KhachHangForm form, @PathVariable("id") String id, HttpSession session){
		//get domain
		String pathJSP = (String)session.getAttribute("pathURL");
		// check pathJSP
		if (!LayoutDAO.intances.checkPathJSP(pathJSP)) {
			// quay ve trang login
			return "redirect:/";
		}
		KhachHangInputBean input = new KhachHangInputBean();
		input.setPathJSP(pathJSP);
		input.setIdKhachHang(id);
		
		//delete
		int cnt = KhachHangDAO.intances.deleteById(input);
		
		if(cnt == 1){
			form.setMessage("Xử lý xóa thành công.");
			form.setMessageErr("");
		}else {
			form.setMessageErr("Xử lý xóa không thành công.");
			form.setMessage("");
		}
		
		//reset
		form.setIdKhachHang("");
		form.setTenKhachHang("");
		form.setLoaiThe("");
		form.setGioiTinh("");
		form.setDiaChi("");
		form.setNgaySinh("");
		form.setSoDienThoai("");
		form.setSoDiem("");
		//Flag update
		form.setFlagUpdate("0");
		
		//init data
		initData(form, pathJSP);
		
		session.setAttribute("PAGEIDSTORE", CUSTOMER);
		return  SystemCommon.ADMIN_STORE;
	}
	
}
