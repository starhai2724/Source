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
import com.sms.form.ProductForm;
import com.sms.formRows.ProductFormRow;
import com.sms.input.SanPhamInputBean;
import com.sms.output.SanPhamOutputBean;

@Controller
@SessionAttributes(value = {"lst_dangKy","ProductForm3"}, types = {ProductForm.class,ProductForm.class})
public class ChiTietDKMController {
	RestTemplate restTemplate = new RestTemplate();
	public static final String CHITIETDKM = "chiTietDKM.jsp";
	
	@ModelAttribute("ProductForm3")
	 public ProductForm getProductForm() {
	   return new ProductForm(); //or however you create a default
	 }
	
	@ModelAttribute("lst_dangKy")
	 public ProductForm getLst_dangKy() {
	   return new ProductForm(); //or however you create a default
	 }
	
	@RequestMapping(value  = "/chiTietDKM/init")
	public String init(@ModelAttribute("ProductForm3") ProductForm form, HttpSession session){
		String pathJSP = (String)session.getAttribute("pathURL");
		// check pathJSP
		if (!LayoutDAO.intances.checkPathJSP(pathJSP)) {
			// quay ve trang login
			return "redirect:/";
		}
		String idDKM = (String)session.getAttribute("idDKM");
		
		//reset message
		form.setMessage("");
		form.setMessageErr("");
		//init data
		initData(form, pathJSP,idDKM);
		
		session.setAttribute("PAGEIDSTORE", CHITIETDKM);
		return  SystemCommon.ADMIN_STORE;
	}
	
	@RequestMapping(value ="/chiTietDKM/initPhanAnh", method = RequestMethod.GET)
	public String initPhanAnh(@ModelAttribute("ProductForm3") ProductForm form, HttpSession session, Model model){
		String pathJSP = (String)session.getAttribute("pathURL"); 
		List<String> lst_idSP = (List<String>)session.getAttribute("lstPhanAnh");
		List<ProductFormRow> lst = form.getLst();
		//init data
		 
		 ArrayList<String> lstMaSPKM_old = new ArrayList<>();
		 if(lst != null && lst.size() > 0){
			 for(int i = 0; i< lst.size() ; i++){
				 lstMaSPKM_old.add(lst.get(i).getIdSanPham());
			 }
		 }
		 
		boolean checkErr = false;
		String idSP = "";
		ProductFormRow formRow; 
		SanPhamOutputBean outputBean;
		SanPhamInputBean input;
		SanPhamOutputRowBean outputRowBean;
		int cnt = 1;
		if(lst_idSP != null && lst_idSP.size() > 0){
			for(int i = 0; i< lst_idSP.size() ; i++){
				idSP = lst_idSP.get(i);
				for (String str : lstMaSPKM_old) {
					if(str.equals(idSP)){
						checkErr = true;
					}
				}
				if(checkErr) {
					continue;
				}
				
				input = new SanPhamInputBean();
				input.setPathJSP(pathJSP);
				input.setIdSanPham(idSP);
				
				//get data theo id va group theo id 
				outputBean = CreateTableProductDAO.intances.getProductById_GroupById(input);
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
			    	formRow.setGiaMua(SMSComons.formatMoney(outputRowBean.getGiaBanKM()));
			    }
				if(!"".equals(outputRowBean.getGiaBan()) && 0 != outputRowBean.getGiaBan().trim().length() ){
			    	formRow.setGiaMua(SMSComons.formatMoney(outputRowBean.getGiaBan()));
			    }
				formRow.setIndex(i);
				formRow.setChecked(1);
				form.getLst().add(formRow);
			}
		}
		
		model.addAttribute("lst_dangKy", form);
		session.setAttribute("PAGEIDSTORE", CHITIETDKM);
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
		System.out.println("result: " + result);
		return result;
	}
	
	
	@RequestMapping(value  = "/chiTietDKM/dangKy", method = RequestMethod.POST)
	public String dangKy(@ModelAttribute("ProductForm3") ProductForm form, HttpSession session){
		String pathJSP = (String)session.getAttribute("pathURL");
		// check pathJSP
		if (!LayoutDAO.intances.checkPathJSP(pathJSP)) {
			// quay ve trang login
			return "redirect:/";
		}
		String idDKM = (String)session.getAttribute("idDKM");
		List<ProductFormRow> lst = form.getLst();
		//init data
		ProductFormRow formRow;
		SanPhamInputBean inputRowBean;
		SanPhamOutputBean outputBean;
		SanPhamInputBean input;
		SanPhamOutputRowBean outputRowBean;
		int cnt = 0;
		if(lst != null && form.getLst().size() > 0){
			for(int i = 0; lst.size() > i; i++){
				formRow = lst.get(i);	

				input = new SanPhamInputBean();
				input.setPathJSP(pathJSP);
				input.setIdSanPham(formRow.getIdSanPham());
				outputBean = CreateTableProductDAO.intances.getProductById(input);
				outputRowBean = outputBean.getLst().get(0);
				// check ton tai
				if(null != outputRowBean.getId_DKM() && 0 != outputRowBean.getId_DKM().trim().length() ){
					// la san pham da KM -> update
					input.setId_DKM(outputRowBean.getId_DKM());
					input.setNgayChinhSua(SMSComons.getDate());
					input.setGiaBanKM(formRow.getGiaBanKM());
					input.setSEQ(formRow.getSEQ());
					cnt = CreateTableProductDAO.intances.update_SPKM(input);
					
				}else{
					// la san pham chua KM -> insert
					input.setSEQ("");
					input.setIdSanPham(formRow.getIdSanPham());
					input.setTenSP(outputRowBean.getTenSP());
					input.setIdCuaHang(outputRowBean.getIdCuaHang());
					input.setIdLoaiSP(outputRowBean.getIdLoaiSP());
					input.setGiaMua(outputRowBean.getGiaMua());
					input.setGiaBan(outputRowBean.getGiaBan());
					input.setHinh(outputRowBean.getHinh());
					input.setMoTa(outputRowBean.getMoTa());
					input.setTrangThai("0");
					input.setNgayTao(SMSComons.getDate());
					input.setNgayChinhSua(outputRowBean.getNgayChinhSua());
					input.setGiaBanKM(form.getLst().get(i).getGiaBanKM());
					input.setId_DKM(idDKM);
					input.setIndex(1);
					
					 cnt = CreateTableProductDAO.intances.insertSPKM(input);
				}
					
				if(cnt != 1){
					form.setMessageErr("Xử lý đăng kí không thành công.");
					form.setMessage("");
					initData(form, pathJSP, idDKM);
					session.setAttribute("PAGEIDSTORE", CHITIETDKM);
					return  SystemCommon.ADMIN_STORE;
				}else {
					form.setMessage("Xử lý đăng kí thành công.");
					form.setMessageErr("");
				}
			}
		}
		
		session.setAttribute("PAGEIDSTORE", CHITIETDKM);
		return  SystemCommon.ADMIN_STORE;
	}
	
	
/*	
	@RequestMapping(value  = "/chiTietDKM/chinhSua", method = RequestMethod.POST)
	public String chinhSua(@ModelAttribute("ProductForm3") ProductForm form, HttpSession session){
		String pathJSP = "cuahangthoitrang";
		String idDKM = (String)session.getAttribute("idDKM");
		List<ProductFormRow> lst = form.getLst();
		//init data
		ProductFormRow formRow;
		SanPhamOutputBean outputBean;
		SanPhamInputBean input;
		SanPhamOutputRowBean outputRowBean;
		int cnt = 0;
		if(lst != null && form.getLst().size() > 0){
			for(int i = 0; lst.size() > i; i++){
				formRow = lst.get(i);	

				input = new SanPhamInputBean();
				input.setPathJSP(pathJSP);
				input.setIdSanPham(formRow.getIdSanPham());
				outputBean = CreateTableProductDAO.intances.getProductById(input);
				outputRowBean = outputBean.getLst().get(0);
				System.out.println("id_DKM : " + outputRowBean.getId_DKM());
				// check ton tai
				if(outputRowBean.getId_DKM().trim().length() != 0 &&  null != outputRowBean.getId_DKM()){
					System.out.println("aaaaaaaa");
					// la san pham da KM -> update
					input.setId_DKM(outputRowBean.getId_DKM());
					input.setNgayChinhSua(SMSComons.getDate());
					input.setGiaBanKM(formRow.getGiaBanKM());
					cnt = CreateTableProductDAO.intances.update_SPKM(input);
					
				}else{
					System.out.println("bbbbbbb");
					// la san pham chua KM -> insert
					input.setIdSanPham("");
					input.setTenSP(outputRowBean.getTenSP());
					input.setIdCuaHang(outputRowBean.getIdCuaHang());
					input.setIdLoaiSP(outputRowBean.getIdLoaiSP());
					input.setGiaMua(outputRowBean.getGiaMua());
					input.setGiaBan(outputRowBean.getGiaBan());
					input.setHinh(outputRowBean.getHinh());
					input.setMoTa(outputRowBean.getMoTa());
					input.setTrangThai("0");
					input.setNgayTao(SMSComons.getDate());
					input.setNgayChinhSua(outputRowBean.getNgayChinhSua());
					input.setGiaBanKM(formRow.getGiaBanKM());
					input.setId_DKM(idDKM);
					input.setIndex(1);
					
					 cnt = CreateTableProductDAO.intances.insertSPKM(input);
				}
					
				if(cnt != 1){
					form.setMessageErr("Xử lý đăng kí không thành công.");
					form.setMessage("");
					initData(form, pathJSP, idDKM);
					session.setAttribute("PAGEIDSTORE", CHITIETDKM);
					return  SystemCommon.ADMIN_STORE;
				}else {
					form.setMessage("Xử lý đăng kí thành công.");
					form.setMessageErr("");
				}
			}
		}
		
		session.setAttribute("PAGEIDSTORE", CHITIETDKM);
		return  SystemCommon.ADMIN_STORE;
	}
	*/
	/**
	 * 
	 * @param form
	 * @param pathJSP
	 */
	
	private void initData(ProductForm form, String pathJSP, String idDKM){
		
		//reset datail
		form.getLst().clear();
		
		SanPhamInputBean inputBean = new SanPhamInputBean();
		inputBean.setPathJSP(pathJSP);
		inputBean.setId_DKM(idDKM);
		SanPhamOutputBean outputBean = CreateTableProductDAO.intances.getProductByIdDKM(inputBean);

		ProductFormRow formRow; 
		int cnt = 1;
		if(outputBean != null && outputBean.getLst().size() > 0){
			for(int i = 0; outputBean.getLst().size() > i; i++){
				SanPhamOutputRowBean outputRowBean = outputBean.getLst().get(i);	
				formRow = new ProductFormRow();
				formRow.setNo(String.valueOf(cnt++));
				formRow.setSEQ(outputRowBean.getSEQ());
				formRow.setIdSanPham(outputRowBean.getIdSanPham());
				formRow.setTenSP(outputRowBean.getTenSP());
				formRow.setTenLoaiSP(outputRowBean.getTenLoaiSP());
				formRow.setIdLoaiSP(outputRowBean.getIdLoaiSP());
				formRow.setGiaMua(SMSComons.formatMoney(outputRowBean.getGiaMua()));
		    	formRow.setGiaBanKM(SMSComons.formatMoney(outputRowBean.getGiaBanKM()));
			    formRow.setGiaBan(SMSComons.formatMoney(outputRowBean.getGiaBan()));	
				form.getLst().add(formRow);
			}
		}
	}
	
	@RequestMapping(value  = "/chiTietDKM/chonSPKM")
	public String chonSPKMd(@ModelAttribute("ProductForm3") ProductForm form, HttpSession session){
		List<ProductFormRow> lst = form.getLst();
		session.setAttribute("lstOld", lst);
		
		
		return  "redirect:/product/init";
	}
	
	@RequestMapping(value  = "/chiTietDKM/themDong")
	public String themDong(@ModelAttribute("ProductForm3") ProductForm form, HttpSession session){
		
		session.setAttribute("PAGEIDSTORE", CHITIETDKM);
		return  SystemCommon.ADMIN_STORE;
	}
	
	
	@RequestMapping(value  = "/chiTietDKM/xoaDong/{listId}", method = RequestMethod.POST)
	public String xoaDong(@ModelAttribute("ProductForm3") ProductForm form, HttpSession session, @PathVariable("listId") String listId){
		List<ProductFormRow> lst = form.getLst();
		ProductFormRow rowBean;
		
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
				for(int k = 0; k < form.getLst().size();k++){
					//Delete cac san pham dc chon
					if(parts[i].equals(form.getLst().get(k).getIdSanPham())){
						lst.remove(form.getLst().get(k));
					}
				}
			}
		}
		
		session.setAttribute("PAGEIDSTORE", CHITIETDKM);
		return  SystemCommon.ADMIN_STORE;
	}
	
	
}
