package com.sms.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;

import com.sms.common.SystemCommon;
import com.sms.dao.CreateTableProductDAO;
import com.sms.dao.NhomSanPhamDAO;
import com.sms.form.ProductForm;
import com.sms.form.RegisterProductCategoryForm;
import com.sms.formRows.RegisterProductCategoryFormRow;
import com.sms.input.LoaiSanPhamInputBean;
import com.sms.input.NhomSanPhamInputBean;
import com.sms.input.RegisterProductCategoryInputBean;
import com.sms.input.SanPhamInputBean;
import com.sms.output.LoaiSanPhamOutputBean;
import com.sms.output.NhomSanPhamOutputBean;

@Controller
@SessionAttributes(value ="RegisterProductCategory", types = {RegisterProductCategoryForm.class})
public class RegisterProductCategoryCtrl {
	RestTemplate restTemplate = new RestTemplate();
	public static final String  REGISTER_PRODUCT_CATEGORY = "registerProductCategory.jsp";
	
	
	@ModelAttribute("RegisterProductCategory")
	 public RegisterProductCategoryForm getRegisterProductCategoryForm() {
	   return new RegisterProductCategoryForm(); //or however you create a default
	 }
	
	/**
	 * Mean: init 
	 * 
	 */
	@RequestMapping(value="/registerProductCategory/init")
	public String init(@ModelAttribute("RegisterProductCategory") RegisterProductCategoryForm form, HttpSession session){
		String pathJSP = (String)session.getAttribute("pathURL");
		//reset form
		form.setNameProductCategory("");
		//reset message
		form.setMessage("");
		form.setMessageErr("");
		
		//init data
		initData(form, pathJSP);
		session.setAttribute("PAGEIDSTORE", REGISTER_PRODUCT_CATEGORY);
		return SystemCommon.ADMIN_STORE;
	}
	
	private void initData(RegisterProductCategoryForm form, String pathJSP){
		
		form.getLst().clear();
		NhomSanPhamInputBean loaiSanPhamInputBean = new NhomSanPhamInputBean();
		loaiSanPhamInputBean.setPathJSP(pathJSP);
		List<NhomSanPhamOutputBean> listLoaiSP = NhomSanPhamDAO.intances.getNhomSP(loaiSanPhamInputBean);
		RegisterProductCategoryFormRow formRow;
		int cnt = 1;
		for(NhomSanPhamOutputBean outputBean : listLoaiSP){
			formRow = new RegisterProductCategoryFormRow();
			formRow.setNo(String.valueOf(cnt++));
			formRow.setIdProductCategory(outputBean.getIdNhomSP());
			formRow.setNameProductCategory(outputBean.getTenNhomSP());
			form.getLst().add(formRow);
		}
		
	}
	
	/**
	 * Mean: insert 
	 * 
	 */
	@RequestMapping(value="/registerProductCategory/insert", method= RequestMethod.POST)
	public String insert(@ModelAttribute("RegisterProductCategory") RegisterProductCategoryForm form, HttpSession session ){
		String pathJSP = (String)session.getAttribute("pathURL");
		RegisterProductCategoryInputBean inputBean = new RegisterProductCategoryInputBean();
		inputBean.setIdNhomSP("");
		inputBean.setTenNhomSP(form.getNameProductCategory());
		inputBean.setPathJSP(pathJSP);
		
		int cnt = NhomSanPhamDAO.intances.insertNhomSP(inputBean);
		
		if(cnt == 1){
			form.setMessage("Xử lý đăng kí thành công.");
			form.setMessageErr("");
		}else {
			form.setMessageErr("Xử lý đăng kí không thành công.");
			form.setMessage("");
		}
		//init data
		initData(form, pathJSP);
		
		session.setAttribute("PAGEIDSTORE", REGISTER_PRODUCT_CATEGORY);
		return SystemCommon.ADMIN_STORE;
	}
	
	/**
	 * Mean: getById 
	 * 
	 */
	@RequestMapping(value="/registerProductCategory/getById/{id}", method= RequestMethod.POST)
	public String getById(@ModelAttribute("RegisterProductCategory") RegisterProductCategoryForm form, @PathVariable("id") String id, HttpSession session ){
		String pathJSP = (String)session.getAttribute("pathURL");
		NhomSanPhamInputBean inputBean = new NhomSanPhamInputBean();
		inputBean.setIdNhomSP(id);
		System.out.println("id: "+id);
		inputBean.setPathJSP(pathJSP);
		
		List<NhomSanPhamOutputBean> NhomSanPhamOutputBeans = NhomSanPhamDAO.intances.getNhomSPById(inputBean);
		System.out.println(NhomSanPhamOutputBeans.size());
		NhomSanPhamOutputBean NhomSanPhamOutputBean = NhomSanPhamOutputBeans.get(0);
		form.setIdProductCategory(NhomSanPhamOutputBean.getIdNhomSP());
		form.setNameProductCategory(NhomSanPhamOutputBean.getTenNhomSP());
		//set update 
		form.setFlagUpdate("1");
		//init data
		initData(form, pathJSP);
		
		session.setAttribute("PAGEIDSTORE", REGISTER_PRODUCT_CATEGORY);
		return SystemCommon.ADMIN_STORE;
	}
	
	
	@RequestMapping(value="/registerProductCategory/getByIdLSP/{id}", method= RequestMethod.POST)
	public String getByIdLSP(@ModelAttribute("RegisterProductCategory") RegisterProductCategoryForm form, @PathVariable("id") String id, HttpSession session ){
		String pathJSP = (String)session.getAttribute("pathURL");
		LoaiSanPhamInputBean inputBean = new LoaiSanPhamInputBean();
		inputBean.setIdLoaiSP(id);
		inputBean.setPathJSP(pathJSP);
		
		List<LoaiSanPhamOutputBean> loaiSPOutputBeans = NhomSanPhamDAO.intances.getLoaiSPById(inputBean);
		LoaiSanPhamOutputBean loaiSP = loaiSPOutputBeans.get(0);
		form.setTenLoaiSP(loaiSP.getTenLoaiSP());
		form.setIdLoaiSP(loaiSP.getIdLoaiSP());
		//set update 
		form.setFlagUpdate_LSP("1");
		//init data
		initData(form, pathJSP);
		
		session.setAttribute("PAGEIDSTORE", REGISTER_PRODUCT_CATEGORY);
		return SystemCommon.ADMIN_STORE;
	}
	
	private void initLSP(String pathJSP,String id,RegisterProductCategoryForm form){
		form.getLstLSP().clear();
		LoaiSanPhamInputBean inputBean = new LoaiSanPhamInputBean();
		inputBean.setIdNhomSP(id);
		inputBean.setPathJSP(pathJSP);
		
		List<LoaiSanPhamOutputBean> loaiSPOutputBeans = NhomSanPhamDAO.intances.getLoaiSPByIdNhomSP(inputBean);
		
		RegisterProductCategoryFormRow formRow;
		int cnt = 1;
		for(LoaiSanPhamOutputBean outputBean : loaiSPOutputBeans){
			formRow = new RegisterProductCategoryFormRow();
			formRow.setNo_LSP(String.valueOf(cnt++));
			formRow.setIdLSP(outputBean.getIdLoaiSP());
			formRow.setName_LSP(outputBean.getTenLoaiSP());
			form.getLstLSP().add(formRow);
		}
	}
	
	
	@RequestMapping(value="/registerProductCategory/showDetail/{id}", method= RequestMethod.POST)
	public String showDetail(@ModelAttribute("RegisterProductCategory") RegisterProductCategoryForm form, @PathVariable("id") String id, HttpSession session ){
		form.getLstLSP().clear();
		
		String pathJSP = (String)session.getAttribute("pathURL");
		LoaiSanPhamInputBean inputBean = new LoaiSanPhamInputBean();
		inputBean.setIdNhomSP(id);
		System.out.println("id nhom SP: "+id);
		inputBean.setPathJSP(pathJSP);
		
		List<LoaiSanPhamOutputBean> loaiSPOutputBeans = NhomSanPhamDAO.intances.getLoaiSPByIdNhomSP(inputBean);
		
		RegisterProductCategoryFormRow formRow;
		int cnt = 1;
		for(LoaiSanPhamOutputBean outputBean : loaiSPOutputBeans){
			formRow = new RegisterProductCategoryFormRow();
			formRow.setNo_LSP(String.valueOf(cnt++));
			formRow.setIdLSP(outputBean.getIdLoaiSP());
			formRow.setName_LSP(outputBean.getTenLoaiSP());
			form.getLstLSP().add(formRow);
		}
		
		form.setTenLoaiSP("");
		form.setCheckShow("1");
		//set update 
		form.setFlagUpdate_LSP("0");
		//init data
		initData(form, pathJSP);
		
		session.setAttribute("idNhomSP", id);
		session.setAttribute("PAGEIDSTORE", REGISTER_PRODUCT_CATEGORY);
		return SystemCommon.ADMIN_STORE;
	}
	
	
	@RequestMapping(value="/registerProductCategory/themDong", method= RequestMethod.POST)
	public String themDong(@ModelAttribute("RegisterProductCategory") RegisterProductCategoryForm form, HttpSession session ){
		String pathJSP = (String)session.getAttribute("pathURL");
	
		List<RegisterProductCategoryFormRow> lstLSP = form.getLstLSP();
		
		RegisterProductCategoryFormRow newRow = new RegisterProductCategoryFormRow();
		newRow.setNo_LSP((lstLSP.size()+1) + ""); 
		newRow.setName_LSP("");
		newRow.setIdLSP("");
		
		lstLSP.add(newRow);
		
		//init data
		initData(form, pathJSP);
		
		session.setAttribute("PAGEIDSTORE", REGISTER_PRODUCT_CATEGORY);
		return SystemCommon.ADMIN_STORE;
	}
	
	
	@RequestMapping(value="/registerProductCategory/deleteLSP/{no}", method= RequestMethod.POST)
	public String deleteLSP(@ModelAttribute("RegisterProductCategory") RegisterProductCategoryForm form, @PathVariable("no") String no, HttpSession session ){
		String pathJSP = (String)session.getAttribute("pathURL");
		
		List<RegisterProductCategoryFormRow> lstLSP = form.getLstLSP();
		RegisterProductCategoryFormRow newRow;
		RegisterProductCategoryInputBean inputBean;
		for(int i = 0; i < lstLSP.size() ; i++){
			newRow = lstLSP.get(i);
			if(newRow.getNo_LSP().equals(no)) {
					if(null != newRow.getIdLSP() && !newRow.getIdLSP().equals("")){
						inputBean = new RegisterProductCategoryInputBean();
						inputBean.setPathJSP(pathJSP);
						inputBean.setIdLoaiSP(newRow.getIdLSP());
						int cnt = NhomSanPhamDAO.intances.deleteLoaiSP(inputBean);
						if(cnt == 1){
							form.setMessage("Xử lý xóa thành công.");
							form.setMessageErr("");
						}else {
							form.setMessageErr("Xử lý xóa không thành công.");
							form.setMessage("");
							session.setAttribute("PAGEIDSTORE", REGISTER_PRODUCT_CATEGORY);
							return SystemCommon.ADMIN_STORE;
						}
					}
				lstLSP.remove(i);
			}
		}
		
		for(int i = 0; i < lstLSP.size() ; i++){
			newRow = lstLSP.get(i);
			newRow.setNo_LSP((i+1) + "");
		}
		
		//set update 
		form.setFlagUpdate("1");
		//init data
		initData(form, pathJSP);
		
		session.setAttribute("PAGEIDSTORE", REGISTER_PRODUCT_CATEGORY);
		return SystemCommon.ADMIN_STORE;
	}
	
	@RequestMapping(value="/registerProductCategory/dangKyLSP", method= RequestMethod.POST)
	public String dangKyLSP(@ModelAttribute("RegisterProductCategory") RegisterProductCategoryForm form, HttpSession session ){
		String pathJSP = (String)session.getAttribute("pathURL");
		String idNhomSP = (String)session.getAttribute("idNhomSP");
		
		int cnt = 0;
		RegisterProductCategoryInputBean inputBean = new RegisterProductCategoryInputBean();
			inputBean.setPathJSP(pathJSP);
			inputBean.setTenLoaiSP(form.getTenLoaiSP());
			inputBean.setIdNhomSP(idNhomSP);
			
			if(form.getFlagUpdate_LSP().equals("0")){
				// 0 -> insert
				inputBean.setIdLoaiSP("");
				cnt = NhomSanPhamDAO.intances.insertLoaiSP(inputBean);
				
			}else{
				// 1 --> update
				inputBean.setIdLoaiSP(form.getIdLoaiSP());
				inputBean.setTenLoaiSP(form.getTenLoaiSP());
				cnt = NhomSanPhamDAO.intances.updateLoaiSP(inputBean);
				
			}
			
			if(cnt == 1){
				form.setMessage("Xử lý đăng kí thành công.");
				form.setMessageErr("");
				initLSP(pathJSP, idNhomSP, form);
			}else {
				form.setMessageErr("Xử lý đăng kí không thành công.");
				form.setMessage("");
				session.setAttribute("PAGEIDSTORE", REGISTER_PRODUCT_CATEGORY);
				return SystemCommon.ADMIN_STORE;
			}
		
		//init data
		initData(form, pathJSP);
		
		session.setAttribute("PAGEIDSTORE", REGISTER_PRODUCT_CATEGORY);
		return SystemCommon.ADMIN_STORE;
	}
	
	/**
	 * Mean: update 
	 * 
	 */
	@RequestMapping(value="/registerProductCategory/update", method= RequestMethod.POST)
	public String update(@ModelAttribute("RegisterProductCategory") RegisterProductCategoryForm form, HttpSession session ){
		String pathJSP = (String)session.getAttribute("pathURL");
		RegisterProductCategoryInputBean inputBean = new RegisterProductCategoryInputBean();
		inputBean.setIdNhomSP(form.getIdProductCategory());
		inputBean.setTenNhomSP(form.getNameProductCategory());
		inputBean.setPathJSP(pathJSP);
		
		int cnt = NhomSanPhamDAO.intances.updateNhomSP(inputBean);
		
		if(cnt == 1){
			form.setMessage("Xử lý đăng kí thành công.");
			//set update done
			form.setFlagUpdate("0");
			form.setMessageErr("");
		}else {
			form.setMessageErr("Xử lý đăng kí không thành công.");
			form.setMessage("");
		}
		//init data
		initData(form, pathJSP);
		
		session.setAttribute("PAGEIDSTORE", REGISTER_PRODUCT_CATEGORY);
		return SystemCommon.ADMIN_STORE;
	}
	
	@RequestMapping(value="/registerProductCategory/delete/{id}")
	public String delete(@ModelAttribute("RegisterProductCategory") RegisterProductCategoryForm form, @PathVariable("id") String id, HttpSession session){
		//get domain
		String pathJSP = (String)session.getAttribute("pathURL"); 
		RegisterProductCategoryInputBean inputBean = new RegisterProductCategoryInputBean();
		inputBean.setPathJSP(pathJSP);
		inputBean.setIdNhomSP(id);
		
		//kiem tra da ton tai loaiSP cua nhom san pham nay chua
		boolean existLoaiSpByIdNhomSP = false;
		LoaiSanPhamInputBean loaiSanPhamInputBean = new LoaiSanPhamInputBean();
		loaiSanPhamInputBean.setPathJSP(pathJSP);
		loaiSanPhamInputBean.setIdNhomSP(id);
		List<LoaiSanPhamOutputBean> loaiSanPhamOutputBeans = NhomSanPhamDAO.intances.getLoaiSPByIdNhomSP(loaiSanPhamInputBean);
		if(loaiSanPhamOutputBeans != null && loaiSanPhamOutputBeans.size() > 0){
			existLoaiSpByIdNhomSP = true;
		}
		
		
		//insert
		int cnt = NhomSanPhamDAO.intances.delete(inputBean);
		if(existLoaiSpByIdNhomSP){
			cnt = NhomSanPhamDAO.intances.deleteLoaiSPByIdNhomSP(inputBean);
		}
		
		if(cnt == 1){
			form.setMessage("Xử lý xóa thành công.");
			form.setMessageErr("");
		}else {
			form.setMessageErr("Xử lý xóa không thành công.");
			form.setMessage("");
		}
		//init data
		initData(form, pathJSP);
		
		session.setAttribute("PAGEIDSTORE", REGISTER_PRODUCT_CATEGORY);
		return  SystemCommon.ADMIN_STORE;
	}
	
}