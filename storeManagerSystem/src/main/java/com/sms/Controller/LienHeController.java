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

import com.sms.common.SMSComons;
import com.sms.common.SendMail;
import com.sms.common.SystemCommon;
import com.sms.dao.DangKiWebDAO;
import com.sms.dao.LayoutDAO;
import com.sms.dao.LienHeDAO;
import com.sms.form.LayoutForm;
import com.sms.form.LienHeForm;
import com.sms.formRows.LienHeRowForm;
import com.sms.input.LienHeInputBean;
import com.sms.output.DangKiWebOutputBean;
import com.sms.output.LienHeOutputBean;
import com.sms.session.KhachHangSession;

@Controller
public class LienHeController {
	
	public static final String LIENHE = "KhachHangLienHe.jsp";
	
	public static final String LIENHE_1 = "fashion/lienhe";
	public static final String LIENHE_2 = "template_2/lienhe";
	
	@RequestMapping(value  = "/lienHe/init")
	public String init(@ModelAttribute("LienHeForm") LienHeForm form, HttpSession session, Model model, BindingResult result){
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
		form.setIdLienHe("");
		form.setTenKH("");
		form.setDiaChi("");
		form.setEmail("");
		form.setSdt("");
		form.setTieuDe("");
		form.setNoiDungNhan("");
		form.setNoiDungTraLoi("");
		form.setTrangThai("");
		form.setNgayNhan("");
		form.setNgayTraLoi("");
		form.setIdKH("");
		//Flag update
		form.setFlagUpdate("0");
		
		//reset message
		form.setMessage("");
		form.setMessageErr("");
		
		//init data
		initData(form, pathJSP);
		
		session.setAttribute("PAGEIDSTORE", LIENHE);
		return  SystemCommon.ADMIN_STORE;
	}
	
	/**
	 * 
	 * @param form
	 * @param pathJSP
	 */
	
	private void initData(LienHeForm form, String pathJSP){
		//reset detail
		form.getLst().clear();
		
		List<LienHeOutputBean> lst = LienHeDAO.intances.getAll(pathJSP);
		LienHeRowForm formRow; 
		int cnt = 1;
		if(lst != null && lst.size() > 0){
			for(int i = 0; lst.size() > i; i++){
				LienHeOutputBean outputRowBean = lst.get(i);	
				formRow = new LienHeRowForm();
				formRow.setNo(String.valueOf(cnt++));
				formRow.setIdLienHe(outputRowBean.getIdLienHe());
				formRow.setTenKH(outputRowBean.getTenKH());
				formRow.setDiaChi(outputRowBean.getDiaChi());
				formRow.setEmail(outputRowBean.getEmail());
				formRow.setSdt(outputRowBean.getSdt());
				formRow.setTieuDe(outputRowBean.getTieuDe());
				formRow.setNoiDungNhan(outputRowBean.getNoiDungNhan());
				formRow.setNoiDungTraLoi(outputRowBean.getNgayTraLoi());
				if("1".equals(outputRowBean.getTrangThai())){
					formRow.setTrangThai("Chưa trả lời");
				}else {
					formRow.setTrangThai("Đã trả lời");
				}
				formRow.setNgayNhan(outputRowBean.getNgayNhan());
				formRow.setNgayTraLoi(outputRowBean.getNgayTraLoi());
				formRow.setIdKH(outputRowBean.getIdKH());
				form.getLst().add(formRow);
			}
		}
	}
	
	/**
	 * 
	 * @param form
	 * @param id
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/lienHe/getById/{id}", method = RequestMethod.POST)
	public String getProductById(@ModelAttribute("LienHeForm") LienHeForm form, @PathVariable("id") String id, HttpSession session){
		//get domain
		String pathJSP = (String)session.getAttribute("pathURL");
		// check pathJSP
		if (!LayoutDAO.intances.checkPathJSP(pathJSP)) {
			// quay ve trang login
			return "redirect:/";
		}
		LienHeInputBean inputBean = new LienHeInputBean();
		inputBean.setPathJSP(pathJSP);
		inputBean.setIdLienHe(id);
		
		List<LienHeOutputBean> lst = LienHeDAO.intances.getAllByID(pathJSP, id);
		LienHeOutputBean outputRowBean = lst.get(0);

		form.setIdLienHe(outputRowBean.getIdLienHe());
		form.setTenKH(outputRowBean.getTenKH());
		form.setDiaChi(outputRowBean.getDiaChi());
		form.setEmail(outputRowBean.getEmail());
		form.setSdt(outputRowBean.getSdt());
		form.setTieuDe(outputRowBean.getTieuDe());
		form.setNoiDungNhan(outputRowBean.getNoiDungNhan());
		form.setNoiDungTraLoi(outputRowBean.getNgayTraLoi());
		if("1".equals(outputRowBean.getTrangThai())){
			form.setTrangThai("Chưa trả lời");
		}else {
			form.setTrangThai("Đã trả lời");
		}
		form.setNgayNhan(outputRowBean.getNgayNhan());
		form.setNgayTraLoi(outputRowBean.getNgayTraLoi());
		form.setIdKH(outputRowBean.getIdKH());
		
		//Flag update
		form.setFlagUpdate("1");
		
		//init data
		initData(form, pathJSP);
		
		session.setAttribute("PAGEIDSTORE",LIENHE);
		return  SystemCommon.ADMIN_STORE;
	}
	
	@RequestMapping(value="/lienHe/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("LienHeForm") LienHeForm form, HttpSession session){
		//get domain
		String pathJSP = (String)session.getAttribute("pathURL");
		// check pathJSP
		if (!LayoutDAO.intances.checkPathJSP(pathJSP)) {
			// quay ve trang login
			return "redirect:/";
		}
		
		LienHeInputBean inputBean = new LienHeInputBean();
		inputBean.setPathJSP(pathJSP);
		inputBean.setIdLienHe(form.getIdLienHe());
		inputBean.setNoiDungTraLoi(form.getNoiDungTraLoi());
		inputBean.setTrangThai("2");
		inputBean.setNgayTraLoi(SMSComons.getDate());
		
		//insert
		int cnt = LienHeDAO.intances.update(inputBean);
		
		SendMail sendMail = new SendMail();
		if(sendMail.send(form.getTieuDe(), form.getNgayTraLoi(), form.getTenKH(), form.getEmail())){
			cnt = 1;
		}else {
			cnt = 0;
		}
		
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
		
		session.setAttribute("PAGEIDSTORE",LIENHE);
		return  SystemCommon.ADMIN_STORE;
	}
	
	@RequestMapping(value="/{path}/lienHe/insert", method = RequestMethod.POST)
	public String insert(@ModelAttribute("LayoutForm") LayoutForm form, HttpSession session, @PathVariable("path") String path){
		// check pathJSP
		if (!LayoutDAO.intances.checkPathJSP(path)) {
			// quay ve trang login
			return "redirect:/";
		}
		
		LienHeForm lienHeForm = form.getLienHeForm();
		LienHeInputBean inputBean = new LienHeInputBean();
		inputBean.setPathJSP(path);
		inputBean.setIdLienHe("");
		inputBean.setTenKH(lienHeForm.getTenKH());
		inputBean.setDiaChi(lienHeForm.getDiaChi());
		inputBean.setEmail(lienHeForm.getEmail());
		inputBean.setSdt(lienHeForm.getSdt());
		inputBean.setTieuDe(lienHeForm.getTieuDe());
		inputBean.setNoiDungNhan(lienHeForm.getNoiDungNhan());
		inputBean.setNoiDungTraLoi("");
		inputBean.setTrangThai("0");
		inputBean.setNgayNhan(SMSComons.getDate());
		inputBean.setNgayTraLoi("");
		
		KhachHangSession khachHangSession = (KhachHangSession) session.getAttribute("KhachHangSession");
		if(khachHangSession != null){
			inputBean.setIdKH(khachHangSession.getIdKhachHang());
		}else {
			inputBean.setIdKH("");
		}
		
		//insert
		int cnt = LienHeDAO.intances.insert(inputBean);
		
		if(cnt == 1){
			form.setMessage("Xử lý đăng kí thành công.");
			form.setMessageErr("");
		}else {
			form.setMessageErr("Xử lý đăng kí không thành công.");
			form.setMessage("");
		}
		
		DangKiWebOutputBean output = DangKiWebDAO.intances.getDataByPathJSP(path);
		form.setSoDienThoai(output.getSdt());
		form.setDiaChi(output.getDiaChi());
		form.setTenCuaHang(output.getTenWebSite());
		form.setLinkFanpage(output.getLinkFanpage());
		
		form.setPathJSP(path);
		
		if("01".equals(output.getLoaiKinhDoanh().trim()))return LIENHE_1;
		
		if("02".equals(output.getLoaiKinhDoanh().trim()))return LIENHE_2;
		return "redirect:/";
	}
}
