package com.sms.Controller;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;

import com.sms.OutputRows.SanPhamOutputRowBean;
import com.sms.common.SMSComons;
import com.sms.common.SystemCommon;
import com.sms.dao.CreateTableProductDAO;
import com.sms.dao.LayoutDAO;
import com.sms.dao.SystemProductDAO;
import com.sms.form.ProductForm;
import com.sms.formRows.ProductFormRow;
import com.sms.input.SanPhamInputBean;
import com.sms.output.SanPhamOutputBean;

@Controller
@SessionAttributes(value = {"lst_dangKy","ProductForm3"}, types = {ProductForm.class,ProductForm.class})
public class SanPhamTrangChuController {

	RestTemplate restTemplate = new RestTemplate();
	public static final String PAGE = "sanPhamTrangChu.jsp";
	@ModelAttribute("ProductForm3")
	 public ProductForm getProductForm() {
	   return new ProductForm(); //or however you create a default
	 }
	
	@ModelAttribute("lst_dangKy")
	 public ProductForm getLst_dangKy() {
	   return new ProductForm(); //or however you create a default
	 }
	
	@RequestMapping(value  = "/sanPhamTrangChu/init")
	public String init(@ModelAttribute("ProductForm3") ProductForm form, HttpSession session){
		String pathJSP = (String)session.getAttribute("pathURL");
		// check pathJSP
		if (!LayoutDAO.intances.checkPathJSP(pathJSP)) {
			// quay ve trang login
			return "redirect:/";
		}
		//reset message
		form.setMessage("");
		form.setMessageErr("");
		//init data
		initData(form, pathJSP);
		
		session.setAttribute("PAGEIDSTORE", PAGE);
		return  SystemCommon.ADMIN_STORE;
	}
	
	@RequestMapping(value ="/sanPhamTrangChu/initPhanAnh", method = RequestMethod.GET)
	public String initPhanAnh(@ModelAttribute("ProductForm3") ProductForm form, HttpSession session, Model model){
		String pathJSP = (String)session.getAttribute("pathURL"); 
		List<String> lst_idSP = (List<String>)session.getAttribute("lstPhanAnh");
		List<ProductFormRow> lst = form.getLst();
		//init data
		 ArrayList<String> lstMaSPKM_old = new ArrayList<>();
		 if(lst != null && lst.size() > 0){
			 for(int i = 0; i< lst.size() ; i++){
				 lstMaSPKM_old.add(pathJSP+"_"+lst.get(i).getSEQ());
			 }
		}
		boolean checkErr = false;
		String idSP = "";
		ProductFormRow formRow; 
		SanPhamOutputBean outputBean;
		SanPhamInputBean input;
		SanPhamOutputRowBean outputRowBean;
		int cnt = 1;
		for(int i = 0; i< lst_idSP.size() ; i++){
			input = new SanPhamInputBean();
			input.setPathJSP(pathJSP);
			input.setSEQ(lst_idSP.get(i));
			SanPhamOutputBean sanPhamOutputBean = CreateTableProductDAO.intances.getProductById(input);
			if(sanPhamOutputBean != null && sanPhamOutputBean.getLst().size() > 0){
				idSP = pathJSP+"_"+sanPhamOutputBean.getLst().get(0).getSEQ();
			}
			for (String str : lstMaSPKM_old) {
				if(str.equals(idSP)){
					checkErr = true;
				}
			}
			if(checkErr) {
				checkErr = false;
				continue;
			}
			input = new SanPhamInputBean();
			input.setPathJSP(pathJSP);
			input.setIdSanPham(idSP);
			input.setSEQ(lst_idSP.get(i));
			//get data theo id va group theo id 
			outputBean = CreateTableProductDAO.intances.getProductById_GroupById(input);
			if(outputBean != null && outputBean.getLst().size() > 0){
				outputRowBean = outputBean.getLst().get(0);
				// set data
				formRow =  new ProductFormRow();
				formRow.setNo(String.valueOf(cnt++));
				formRow.setSEQ(outputRowBean.getSEQ());
				formRow.setIdSanPham(outputRowBean.getIdSanPham());
				formRow.setTenSP(outputRowBean.getTenSP());
				formRow.setTenLoaiSP(outputRowBean.getTenLoaiSP());
				formRow.setIdLoaiSP(outputRowBean.getIdLoaiSP());
				if(!"".equals(outputRowBean.getGiaMua()) && 0 != outputRowBean.getGiaMua().trim().length()){
			    	formRow.setGiaMua(SMSComons.formatMoney(outputRowBean.getGiaMua()));
			    }
				if(null != outputRowBean.getGiaBanKM() && !"".equals(outputRowBean.getGiaBanKM()) && 0 != outputRowBean.getGiaBanKM().length()){
			    	formRow.setGiaBan(SMSComons.formatMoney(outputRowBean.getGiaBanKM()));
			    }
				if(!"".equals(outputRowBean.getGiaBan()) && 0 != outputRowBean.getGiaBan().trim().length() ){
			    	formRow.setGiaBan(SMSComons.formatMoney(outputRowBean.getGiaBan()));
			    }
				formRow.setIndex(i);
				formRow.setChecked(1);
				form.getLst().add(formRow);
			}
		}
		model.addAttribute("lst_dangKy", form);
		session.setAttribute("PAGEIDSTORE", PAGE);
		return  SystemCommon.ADMIN_STORE;
	}
	 
	/**
	 * 
	 * @param money
	 * @return
	 */
	private String removeFomart(String money){
		//8,800.00    -> 8
		String result = "";
		if(money.length()> 0) {
			result = money.substring(0, money.length()-3);
			result = result.replace(",", "");
		}else{
			result = "0";
		}
		return result;
	}
	
	
	@RequestMapping(value  = "/sanPhamTrangChu/dangKy", method = RequestMethod.POST)
	public String dangKy(@ModelAttribute("ProductForm3") ProductForm form, HttpSession session){
		String pathJSP = (String)session.getAttribute("pathURL");
		// check pathJSP
		if (!LayoutDAO.intances.checkPathJSP(pathJSP)) {
			// quay ve trang login
			return "redirect:/";
		}
		List<ProductFormRow> lst = form.getLst();
		//init data
		ProductFormRow formRow;
		SanPhamInputBean inputRowBean;
		SanPhamOutputBean outputBean;
		SanPhamInputBean input;
		SanPhamOutputRowBean outputRowBean;
		int cnt = 0;
		if(lst != null && form.getLst().size() > 0){
			for(int i = 0;  i < form.getLst().size() ; i++){
				formRow = lst.get(i);	
				input = new SanPhamInputBean();
				input.setPathJSP(pathJSP);
				input.setIdSanPham(formRow.getIdSanPham());
				input.setSEQ(formRow.getSEQ());
				outputBean = SystemProductDAO.intances.getProductById_2(input);
				// check ton tai
				if(null != outputBean && outputBean.getLst().size() > 0){
				}else{
					outputBean = CreateTableProductDAO.intances.getProductById(input);
					if(outputBean != null && outputBean.getLst().size() > 0){
						outputRowBean = outputBean.getLst().get(0);
						input.setSEQ("");
						input.setIdSanPham(pathJSP+"_"+formRow.getSEQ());
						input.setTenSP(outputRowBean.getTenSP());
						input.setIdCuaHang(outputRowBean.getIdCuaHang());
						input.setIdLoaiSP(formRow.getIdLoaiSP());
						input.setGiaMua(outputRowBean.getGiaMua());
						input.setGiaBan(outputRowBean.getGiaBan());
						input.setHinh(outputRowBean.getHinh());
						input.setMoTa(outputRowBean.getMoTa());
						input.setTrangThai("0");
						input.setNgayTao(SMSComons.getDate());
						cnt = SystemProductDAO.intances.insertSPKM(input);
					}
				}
			}
		}
		
		if(cnt != 1){
			form.setMessage("Xử lý đăng kí thành công.");
			form.setMessageErr("");
			initData(form, pathJSP);
			session.setAttribute("PAGEIDSTORE", PAGE);
			return  SystemCommon.ADMIN_STORE;
		}else {
			form.setMessage("Xử lý đăng kí thành công.");
			form.setMessageErr("");
			initData(form, pathJSP);
		}
		
		session.setAttribute("PAGEIDSTORE", PAGE);
		return  SystemCommon.ADMIN_STORE;
	}
	
	
	/**
	 * 
	 * @param form
	 * @param pathJSP
	 */
	
	private void initData(ProductForm form, String pathJSP){
		
		form.getLstCategory().put("01", "Thời trang");
		form.getLstCategory().put("02", "Mỹ phẩm");
		form.getLstCategory().put("03", "Nội thất");
		
		//reset datail
		form.getLst().clear();
		SanPhamInputBean inputBean = new SanPhamInputBean();
		inputBean.setPathJSP(pathJSP);
		SanPhamOutputBean outputBean = SystemProductDAO.intances.getSanPhamApDung(inputBean.getPathJSP(), "");
		ProductFormRow formRow; 
		int cnt = 1;
		for(SanPhamOutputRowBean sanPhamOutputRowBean : outputBean.getLst()){
			String seq = getSEQ(sanPhamOutputRowBean.getIdSanPham(), pathJSP);
			if(!"".equals(seq)){
				formRow = new ProductFormRow();
				formRow.setNo(String.valueOf(cnt++));
				formRow.setSEQ(seq);
				formRow.setIdSanPham(sanPhamOutputRowBean.getIdSanPham());
				formRow.setTenSP(sanPhamOutputRowBean.getTenSP());
				formRow.setTenLoaiSP(sanPhamOutputRowBean.getTenLoaiSP());
				formRow.setIdLoaiSP(sanPhamOutputRowBean.getIdLoaiSP());
				formRow.setGiaMua(SMSComons.formatMoney(sanPhamOutputRowBean.getGiaMua()));
		    	formRow.setGiaBanKM(sanPhamOutputRowBean.getGiaBanKM());
			    formRow.setGiaBan(SMSComons.formatMoney(sanPhamOutputRowBean.getGiaBan()));	
				form.getLst().add(formRow);
			}
		}
		//Su dung de phan anh danh sach san pham (S)
		form.getLstSanPham().clear();
		SanPhamOutputBean outputBeanPhanAnh = CreateTableProductDAO.intances.getProducts(pathJSP);
		ProductFormRow formRowPhanAnh; 
		int cntPhanAnh = 1;
		if(outputBeanPhanAnh != null && outputBeanPhanAnh.getLst().size() > 0){
			for(int i = 0; i <  outputBeanPhanAnh.getLst().size() ; i++){
				SanPhamOutputRowBean outputRowBean = outputBeanPhanAnh.getLst().get(i);	
				formRowPhanAnh = new ProductFormRow();
				formRowPhanAnh.setNo(String.valueOf(cntPhanAnh++));
				formRowPhanAnh.setSEQ(outputRowBean.getSEQ());
				formRowPhanAnh.setIdSanPham(outputRowBean.getIdSanPham());
				formRowPhanAnh.setTenSP(outputRowBean.getTenSP());
				formRowPhanAnh.setTenLoaiSP(outputRowBean.getTenLoaiSP());
				formRowPhanAnh.setGiaMua(SMSComons.formatMoney(outputRowBean.getGiaMua()));
				formRowPhanAnh.setGiaBan(SMSComons.formatMoney(outputRowBean.getGiaBan()));
				form.getLstSanPham().add(formRowPhanAnh);
			}
		}
		//Su dung de phan anh danh sach san pham (E)
	}
	
	
	@RequestMapping(value  = "/sanPhamTrangChu/xoaDong/{listId}", method = RequestMethod.POST)
	public String xoaDong(@ModelAttribute("ProductForm3") ProductForm form, HttpSession session, @PathVariable("listId") String listId){
		String pathJSP = (String)session.getAttribute("pathURL");
		// check pathJSP
		if (!LayoutDAO.intances.checkPathJSP(pathJSP)) {
			// quay ve trang login
			return "redirect:/";
		}
		List<ProductFormRow> lst = form.getLst();
		// remove ","
		if (!"".equals(listId)) {
			listId = listId.substring(1);
			String[] parts = listId.split(",");
			listId = "";
			for (int i = 0; i < parts.length; i++) {
				for(int k = 0; k < form.getLst().size();k++){
					//Delete cac san pham dc chon
					if(parts[i].equals(form.getLst().get(k).getSEQ())){
						SystemProductDAO.intances.deleteProductById(pathJSP+"_"+form.getLst().get(k).getSEQ());
						lst.remove(form.getLst().get(k));
					}
				}
			}
		}
		session.setAttribute("PAGEIDSTORE", PAGE);
		return  SystemCommon.ADMIN_STORE;
	}
	
	@RequestMapping(value="sanPhamTrangChu/phanAnh/{listId}", method = RequestMethod.POST)
	public String phanAnh(@ModelAttribute("ProductForm3") ProductForm form, HttpSession session,@PathVariable("listId") String listId){
		List lstPhanAnh = new ArrayList<String>();
		// remove ","
		if (!"".equals(listId) && !"0".equals(listId)) {
			listId = listId.substring(1);
			String[] parts = listId.split(",");
			listId = "";
			for (int i = 0; i < parts.length; i++) {
				lstPhanAnh.add(parts[i]);
			}
		}
		session.setAttribute("lstPhanAnh", lstPhanAnh);
		return  "redirect:/sanPhamTrangChu/initPhanAnh";
	}
	
	private String getSEQ(String idSanPham, String pathJSP){
		String[] result = null;
		if(idSanPham !=null){
			result = idSanPham.split("_");
			if(pathJSP.equals(result[0])){
				return result[1];
			}
		}
		return "";
	}
}

