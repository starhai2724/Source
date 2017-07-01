package com.sms.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sms.OutputRows.KhachHangOutputRowBean;
import com.sms.OutputRows.LoaiTheOutputRowBean;
import com.sms.common.SMSComons;
import com.sms.common.SystemCommon;
import com.sms.dao.KhachHangDAO;
import com.sms.dao.LayoutDAO;
import com.sms.dao.LoaiTheDAO;
import com.sms.form.KhachHangForm;
import com.sms.form.LoaiTheForm;
import com.sms.formRows.KhachHangRowForm;
import com.sms.formRows.LoaiTheRowForm;
import com.sms.input.KhachHangInputBean;
import com.sms.input.LoaiTheInputBean;

@Controller
public class LoaiTheController {

	public static final String PAGE = "cardType.jsp";
	
	@RequestMapping(value  = "/cardType/init")
	public String init(@ModelAttribute("LoaiTheForm") LoaiTheForm form, HttpSession session){
		String pathJSP = (String)session.getAttribute("pathURL"); 
		// check pathJSP
		if (!LayoutDAO.intances.checkPathJSP(pathJSP)) {
			// quay ve trang login
			return "redirect:/";
		}
		//reset
		form.setIdLoaiThe("");
		form.setTenLoaiThe("");
		form.setDiem("");
		
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
	
	private void initData(LoaiTheForm form, String pathJSP){
		
		List<LoaiTheOutputRowBean> lst = LoaiTheDAO.intances.getAll(pathJSP);
		LoaiTheRowForm formRow; 
		int cnt = 1;
		if(lst != null && lst.size() > 0){
			for(int i = 0; lst.size() > i; i++){
				LoaiTheOutputRowBean outputRowBean = lst.get(i);	
				formRow = new LoaiTheRowForm();
				formRow.setNo(String.valueOf(cnt++));
				formRow.setIdLoaiThe(outputRowBean.getIdLoaiThe());
				formRow.setTenLoaiThe(outputRowBean.getTenLoaiThe());
				formRow.setDiem(outputRowBean.getDiem());
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
	
	@RequestMapping(value ="/cardType/insert", method = RequestMethod.POST)
	public String insert(@ModelAttribute("LoaiTheForm") LoaiTheForm form, HttpSession session) {
		//get domain
		String pathJSP = (String)session.getAttribute("pathURL");
		// check pathJSP
		if (!LayoutDAO.intances.checkPathJSP(pathJSP)) {
			// quay ve trang login
			return "redirect:/";
		}
		//input
		LoaiTheInputBean inputBean = new LoaiTheInputBean();
		inputBean.setPathJSP(pathJSP);
		inputBean.setIdLoaiThe("");
		inputBean.setTenLoaiThe(form.getTenLoaiThe());
		inputBean.setDiem(form.getDiem());
		
		//insert
		int cnt = LoaiTheDAO.intances.insert(inputBean);
		
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
	
	@RequestMapping(value ="/cardType/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("LoaiTheForm") LoaiTheForm form, HttpSession session){
		//get domain
		String pathJSP = (String)session.getAttribute("pathURL");
		// check pathJSP
		if (!LayoutDAO.intances.checkPathJSP(pathJSP)) {
			// quay ve trang login
			return "redirect:/";
		}
		
		//input
		LoaiTheInputBean inputBean = new LoaiTheInputBean();
		inputBean.setPathJSP(pathJSP);
		inputBean.setIdLoaiThe(form.getIdLoaiThe());
		inputBean.setTenLoaiThe(form.getTenLoaiThe());
		inputBean.setDiem(form.getDiem());
		
		//insert
		int cnt = LoaiTheDAO.intances.update(inputBean);
		
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
	@RequestMapping(value="/cardType/getById/{id}", method = RequestMethod.POST)
	public String getProductById(@ModelAttribute("LoaiTheForm") LoaiTheForm form, @PathVariable("id") String id, HttpSession session){
		//get domain
		String pathJSP = (String)session.getAttribute("pathURL");
		// check pathJSP
		if (!LayoutDAO.intances.checkPathJSP(pathJSP)) {
			// quay ve trang login
			return "redirect:/";
		}
		LoaiTheInputBean inputBean = new LoaiTheInputBean();
		inputBean.setPathJSP(pathJSP);
		inputBean.setIdLoaiThe(id);
		
		List<LoaiTheOutputRowBean> lst = LoaiTheDAO.intances.getById(inputBean);
		LoaiTheOutputRowBean loaiTheOutputRowBean = lst.get(0);
		form.setIdLoaiThe(loaiTheOutputRowBean.getIdLoaiThe());
		form.setTenLoaiThe(loaiTheOutputRowBean.getTenLoaiThe());
		form.setDiem(loaiTheOutputRowBean.getDiem());
		
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
	@RequestMapping(value="/cardType/delete/{id}")
	public String delete(@ModelAttribute("LoaiTheForm") LoaiTheForm form, @PathVariable("id") String id, HttpSession session){
		//get domain
		String pathJSP = (String)session.getAttribute("pathURL");
		// check pathJSP
		if (!LayoutDAO.intances.checkPathJSP(pathJSP)) {
			// quay ve trang login
			return "redirect:/";
		}
		//input
		LoaiTheInputBean inputBean = new LoaiTheInputBean();
		inputBean.setPathJSP(pathJSP);
		inputBean.setIdLoaiThe(id);
		
		//delete
		int cnt = LoaiTheDAO.intances.deleteById(inputBean);
		
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
