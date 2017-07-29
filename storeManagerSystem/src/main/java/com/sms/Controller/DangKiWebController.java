package com.sms.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sms.common.MD5HashingExample;
import com.sms.common.SMSComons;
import com.sms.common.SystemCommon;
import com.sms.common.SystemURL;
import com.sms.dao.ChiTietHoaDonDAO;
import com.sms.dao.CreateTableProductDAO;
import com.sms.dao.DangKiWebDAO;
import com.sms.dao.DotKhuyenMaiDAO;
import com.sms.dao.HoaDonDAO;
import com.sms.dao.KhachHangDAO;
import com.sms.dao.KhoHangDAO;
import com.sms.dao.LoaiKinhDoanhDAO;
import com.sms.dao.LoaiTheDAO;
import com.sms.dao.NhomSanPhamDAO;
import com.sms.form.DangKiWebForm;
import com.sms.form.LoaiKinhDoanhForm;
import com.sms.input.DangKiWebInputBean;
import com.sms.input.LoaiKinhDoanhInputBean;
import com.sms.output.LoaiKinhDoanhOutputBean;

@Controller
@SessionAttributes(value ="DangKiWebForm", types = {DangKiWebForm.class})
public class DangKiWebController {
	public static final String PAGE_STEP1 = "dangky1.jsp";
	public static final String PAGE_STEP2 = "dangky2.jsp";
	public static final String PAGE_STEP3 = "dangky3.jsp";
	public static final String PAGE_STEP4 = "dangky4.jsp";
	public static final String PAGE = "index";
	//session
	public static final String PAGECENTER = "PAGECENTER";
	@ModelAttribute("DangKiWebForm")
	public DangKiWebForm getDangKiWebForm(){
		return new DangKiWebForm();
	}
	/**
	 * 
	 * @param form
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/buoc1")
	public String step1(@ModelAttribute("DangKiWebForm") DangKiWebForm form, HttpSession session){
		session.setAttribute(PAGECENTER, PAGE_STEP1);
		return PAGE;
	}
	/**
	 * 
	 * @param form
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/buoc2", method = RequestMethod.POST)
	public String step2(@ModelAttribute("DangKiWebForm") DangKiWebForm form, HttpSession session){
		//Email da dc dang ki
		String result = DangKiWebDAO.intances.getExistEmail(form.getEmail());
		if(result != null && !"".equals(result)){
			form.setMessage("");
			form.setMessageErr("Địa chỉ email đã được đăng kí.");
			session.setAttribute(PAGECENTER, PAGE_STEP1);
			return PAGE;
		}
		
		// get cac loai kinh doanh
		form.getLstLoaiKinhDoanh().clear();
		LoaiKinhDoanhForm loaiKinhDoanhForm;
		List<LoaiKinhDoanhOutputBean> loaiKinhDoanhOutputBeans = LoaiKinhDoanhDAO.intances.getALL();
		for(LoaiKinhDoanhOutputBean loaiKinhDoanhOutputBean : loaiKinhDoanhOutputBeans){
			loaiKinhDoanhForm = new LoaiKinhDoanhForm();
			loaiKinhDoanhForm.setIdTemplate(loaiKinhDoanhOutputBean.getIdLoaiKinhDoanh());
			loaiKinhDoanhForm.setTemplateName(loaiKinhDoanhOutputBean.getTenLoaiKinhDoanh());
			loaiKinhDoanhForm.setGia("300,000");
			form.getLstLoaiKinhDoanh().add(loaiKinhDoanhForm);
		}
		
		session.setAttribute(PAGECENTER, PAGE_STEP2);
		return PAGE;
	}
	
	/**
	 * 
	 * @param form
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/buoc3/{idTemplate}", method = RequestMethod.POST)
	public String step3(@ModelAttribute("DangKiWebForm") DangKiWebForm form, HttpSession session, @PathVariable("idTemplate") String idTemplate){
		
		// get cac loai kinh doanh
		form.getLstLoaiKinhDoanh().clear();
		LoaiKinhDoanhForm loaiKinhDoanhForm;
		List<LoaiKinhDoanhOutputBean> loaiKinhDoanhOutputBeans = LoaiKinhDoanhDAO.intances.getALL();
		for(LoaiKinhDoanhOutputBean loaiKinhDoanhOutputBean : loaiKinhDoanhOutputBeans){
			loaiKinhDoanhForm = new LoaiKinhDoanhForm();
			loaiKinhDoanhForm.setIdTemplate(loaiKinhDoanhOutputBean.getIdLoaiKinhDoanh());
			loaiKinhDoanhForm.setTemplateName(loaiKinhDoanhOutputBean.getTenLoaiKinhDoanh());
			loaiKinhDoanhForm.setGia("300,000");
			form.getLstLoaiKinhDoanh().add(loaiKinhDoanhForm);
		}
		form.setLoaiKinhDoanh(idTemplate);
		
		session.setAttribute(PAGECENTER, PAGE_STEP3);
		return PAGE;
	}
	
	/**
	 * 
	 * @param form
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/taoWeb", method = RequestMethod.POST)
	public String taoWeb(@ModelAttribute("DangKiWebForm") DangKiWebForm form, HttpSession session){
		
		
		//da ton tai dia chi website
		String result = DangKiWebDAO.intances.getExistPathJSP(form.getPathJSP());
		if(result != null && !"".equals(result)){
			form.setMessage("");
			form.setMessageErr("Địa chỉ website đã tồn tại.");
			session.setAttribute(PAGECENTER, PAGE_STEP3);
			return PAGE;
		}
		
		//Sdt da dc dang ki
		result = DangKiWebDAO.intances.getExistSDT(form.getSdt());
		if(result != null && !"".equals(result)){
			form.setMessage("");
			form.setMessageErr("Số điện thoại đã được đăng kí.");
			session.setAttribute(PAGECENTER, PAGE_STEP3);
			return PAGE;
		}
		
		//dang ki
		DangKiWebInputBean inputBean = new DangKiWebInputBean();
		inputBean.setEmail(form.getEmail());
		inputBean.setMatKhau(MD5HashingExample.MD5(form.getMatKhau()));
		inputBean.setQuyen("02");
		inputBean.setNgayTao(SMSComons.getDate());
		inputBean.setNgayChinhSua("");
		inputBean.setNguoiTao("HaiNT");
		inputBean.setDiaChi(form.getDiaChi());
		inputBean.setSdt(form.getSdt());
		inputBean.setLoaiKinhDoanh(form.getLoaiKinhDoanh());
		inputBean.setPathJSP(form.getPathJSP());
		inputBean.setTenWebSite(form.getTenWebSite());
		
		//insert
		int cnt = DangKiWebDAO.intances.insert(inputBean);
	
		cnt = DangKiWebDAO.intances.insertStoreInfo(inputBean);
		
		cnt = CreateTableProductDAO.intances.createTableProduct(inputBean.getPathJSP());
		
		cnt = KhachHangDAO.intances.createTable(inputBean.getPathJSP());
		
		cnt = DotKhuyenMaiDAO.intances.createTable(inputBean.getPathJSP());
		
		cnt = HoaDonDAO.intances.createTable(inputBean.getPathJSP());
		
		cnt = ChiTietHoaDonDAO.intances.createTable(inputBean.getPathJSP());
		
		cnt = NhomSanPhamDAO.intances.createTable_LSP(inputBean.getPathJSP());
		
		cnt = NhomSanPhamDAO.intances.createTable_NhomSP(inputBean.getPathJSP());
		
		cnt = LoaiTheDAO.intances.createTable(inputBean.getPathJSP()); 
		
		cnt = KhoHangDAO.intances.createTable(inputBean.getPathJSP());
		
		if(cnt == 0){
			return SystemCommon.PAGE_LOGIN;
		}else {
			session.setAttribute(PAGECENTER, PAGE_STEP3);
			form.setMessageErr("Xử lý đăng kí không thành công.");
			form.setMessage("");
		}
		
		return PAGE;
	}
	
	/**
	 * 
	 * @param response
	 * @param request
	 * @param id
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "/myImage/imageTemplateDisplay/{idTemplate}", method = RequestMethod.GET)
	public void getImage(HttpServletResponse response, HttpServletRequest request, @PathVariable("idTemplate") String idTemplate)
			throws ServletException, IOException {
		byte[] bFile = null;
		// get cac loai kinh doanh
		LoaiKinhDoanhInputBean inputBean = new LoaiKinhDoanhInputBean();
		inputBean.setIdLoaiKinhDoanh(idTemplate);
		List<LoaiKinhDoanhOutputBean> loaiKinhDoanhOutputBeans = LoaiKinhDoanhDAO.intances.getALLById(inputBean);
		for(LoaiKinhDoanhOutputBean loaiKinhDoanhOutputBean : loaiKinhDoanhOutputBeans){
			if(loaiKinhDoanhOutputBean.getIdLoaiKinhDoanh().equals(idTemplate)){
				 bFile = loaiKinhDoanhOutputBean.getHinh();
			}
		}
		// save image into database
		response.setContentType("image/jpeg, image/jpg, image/png,image/gif");
		response.getOutputStream().write(bFile);
		response.getOutputStream().close();
	}
	
}
