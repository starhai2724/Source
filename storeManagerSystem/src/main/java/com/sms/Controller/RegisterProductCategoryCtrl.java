package com.sms.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.sms.OutputRows.RegisterProductCategoryOutputRowBean;
import com.sms.common.Status;
import com.sms.common.SystemCommon;
import com.sms.common.SystemURL;
import com.sms.dao.LoaiSanPhamDAO;
import com.sms.form.RegisterProductCategoryForm;
import com.sms.formRows.RegisterProductCategoryFormRow;
import com.sms.input.LoaiSanPhamInputBean;
import com.sms.input.RegisterProductCategoryInputBean;
import com.sms.models.ResultObject;
import com.sms.models.User;
import com.sms.output.LoaiSanPhamOutputBean;
import com.sms.output.RegisterProductCategoryOutputBean;

@Controller
public class RegisterProductCategoryCtrl {
	RestTemplate restTemplate = new RestTemplate();
	public static final String  REGISTER_PRODUCT_CATEGORY = "registerProductCategory.jsp";
	
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
		LoaiSanPhamInputBean loaiSanPhamInputBean = new LoaiSanPhamInputBean();
		loaiSanPhamInputBean.setPathJSP(pathJSP);
		List<LoaiSanPhamOutputBean> listLoaiSP = LoaiSanPhamDAO.intances.getLoaiSP(loaiSanPhamInputBean);
		RegisterProductCategoryFormRow formRow;
		int cnt = 1;
		for(LoaiSanPhamOutputBean outputBean : listLoaiSP){
			formRow = new RegisterProductCategoryFormRow();
			formRow.setNo(String.valueOf(cnt++));
			formRow.setIdProductCategory(outputBean.getIdLoaiSP());
			formRow.setNameProductCategory(outputBean.getTenLoaiSP());
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
		inputBean.setIdProductCategory("");
		inputBean.setNameProductCategory(form.getNameProductCategory());
		inputBean.setPathJSP(pathJSP);
		
		int cnt = LoaiSanPhamDAO.intances.insert(inputBean);
		
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
		LoaiSanPhamInputBean inputBean = new LoaiSanPhamInputBean();
		inputBean.setIdLoaiSP(id);
		System.out.println("id: "+id);
		inputBean.setPathJSP(pathJSP);
		
		List<LoaiSanPhamOutputBean> loaiSanPhamOutputBeans = LoaiSanPhamDAO.intances.getLoaiSPById(inputBean);
		System.out.println(loaiSanPhamOutputBeans.size());
		LoaiSanPhamOutputBean loaiSanPhamOutputBean = loaiSanPhamOutputBeans.get(0);
		form.setIdProductCategory(loaiSanPhamOutputBean.getIdLoaiSP());
		form.setNameProductCategory(loaiSanPhamOutputBean.getTenLoaiSP());
		//set update 
		form.setFlagUpdate("1");
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
		inputBean.setIdProductCategory(form.getIdProductCategory());
		inputBean.setNameProductCategory(form.getNameProductCategory());
		inputBean.setPathJSP(pathJSP);
		
		int cnt = LoaiSanPhamDAO.intances.update(inputBean);
		
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
	
}