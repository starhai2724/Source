package com.sms.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;

import com.sms.OutputRows.SanPhamOutputRowBean;
import com.sms.common.SMSComons;
import com.sms.common.SystemCommon;
import com.sms.dao.CreateTableProductDAO;
import com.sms.dao.LoaiSanPhamDAO;
import com.sms.form.ProductForm;
import com.sms.formRows.ProductFormRow;
import com.sms.input.LoaiSanPhamInputBean;
import com.sms.input.SanPhamInputBean;
import com.sms.output.LoaiSanPhamOutputBean;
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
		String pathJSP = "cuahangthoitrang";
		String idDKM = (String)session.getAttribute("idDKM");
		//init data
		initData(form, pathJSP,idDKM);
		session.setAttribute("PAGEIDSTORE", CHITIETDKM);
		return  SystemCommon.ADMIN_STORE;
	}
	
	@RequestMapping(value ="/chiTietDKM/initPhanAnh", method = RequestMethod.GET)
	public String initPhanAnh(@ModelAttribute("ProductForm3") ProductForm form, HttpSession session, Model model){
		 
		List<ProductFormRow> lstPhanAnh = (List<ProductFormRow>)session.getAttribute("lstPhanAnh");
		List<ProductFormRow> lst = form.getLst();
		//init data
		 ProductFormRow rowBean;
		 ArrayList<String> lstMaSPKM_old = new ArrayList<>();
		 if(lst != null && lst.size() > 0){
			 for(int i = 0; i< lst.size() ; i++){
				 lstMaSPKM_old.add(lst.get(i).getIdSanPham());
			 }
		 }
		 boolean checkErr = false;
		if(lstPhanAnh != null && lstPhanAnh.size() > 0){
			for(int i = 0; i< lstPhanAnh.size() ; i++){
				
				for (String str : lstMaSPKM_old) {
					if(str.equals(lstPhanAnh.get(i).getIdSanPham())){
						checkErr = true;
					}
				}
				if(checkErr) {
					continue;
				}
				rowBean = new ProductFormRow();
				rowBean.setIdSanPham(lstPhanAnh.get(i).getIdSanPham());
				rowBean.setTenSP(lstPhanAnh.get(i).getTenSP());
				rowBean.setTenLoaiSP(lstPhanAnh.get(i).getTenLoaiSP());
				rowBean.setIdLoaiSP(lstPhanAnh.get(i).getIdLoaiSP());
				rowBean.setGiaMua(lstPhanAnh.get(i).getGiaMua());
				rowBean.setGiaBan(lstPhanAnh.get(i).getGiaBan());
				rowBean.setGiaBanKM(lstPhanAnh.get(i).getGiaBanKM());
				form.getLst().add(rowBean);
			}
		}
		
		model.addAttribute("lst_dangKy", form);
		session.setAttribute("PAGEIDSTORE", CHITIETDKM);
		return  SystemCommon.ADMIN_STORE;
	}
	
	@RequestMapping(value  = "/chiTietDKM/dangKy", method = RequestMethod.POST)
	public String dangKy(@ModelAttribute("ProductForm3") ProductForm form, HttpSession session){
		String pathJSP = "cuahangthoitrang";
		String idDKM = (String)session.getAttribute("idDKM");
		List<ProductFormRow> lst = form.getLst();
		//init data
		ProductFormRow rowBean;
		SanPhamInputBean inputRowBean; 
		if(lst != null && form.getLst().size() > 0){
			for(int i = 0; lst.size() > i; i++){
				rowBean = lst.get(i);	
				inputRowBean = new SanPhamInputBean();
				inputRowBean.setPathJSP(pathJSP);
				inputRowBean.setIdSanPham("");
				inputRowBean.setTenSP(rowBean.getTenSP());
				inputRowBean.setIdLoaiSP(rowBean.getIdLoaiSP());
				inputRowBean.setGiaMua(rowBean.getGiaMua());
				inputRowBean.setGiaBan(rowBean.getGiaBan());
				inputRowBean.setTrangThai("0");
				inputRowBean.setMoTa(rowBean.getMoTa());
				inputRowBean.setGiaBanKM(rowBean.getGiaBanKM());
				inputRowBean.setId_DKM(idDKM);
				inputRowBean.setNgayTao(SMSComons.getDate());
				//insert
				int cnt = CreateTableProductDAO.intances.insertSPKM(inputRowBean);
				
				if(cnt == 1){
					form.setMessage("Xử lý đăng kí thành công.");
					form.setMessageErr("");
				}else {
					form.setMessageErr("Xử lý đăng kí không thành công.");
					form.setMessage("");
					initData(form, pathJSP, idDKM);
					session.setAttribute("PAGEIDSTORE", CHITIETDKM);
					return  SystemCommon.ADMIN_STORE;
				}
			}
		}
		
		session.setAttribute("PAGEIDSTORE", CHITIETDKM);
		return  SystemCommon.ADMIN_STORE;
	}
	
	/**
	 * 
	 * @param form
	 * @param pathJSP
	 */
	
	private void initData(ProductForm form, String pathJSP, String idDKM){
		
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
				formRow.setIdSanPham(outputRowBean.getIdSanPham());
				formRow.setTenSP(outputRowBean.getTenSP());
				formRow.setTenLoaiSP(outputRowBean.getTenLoaiSP());
				formRow.setIdLoaiSP(outputRowBean.getIdLoaiSP());
				formRow.setGiaMua(outputRowBean.getGiaMua());
				formRow.setGiaBan(outputRowBean.getGiaBan());
				formRow.setGiaBanKM(outputRowBean.getGiaBanKM());
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
	
	
	@RequestMapping(value  = "/chiTietDKM/xoaDong")
	public String xoaDong(@ModelAttribute("ProductForm3") ProductForm form, HttpSession session){
		
		session.setAttribute("PAGEIDSTORE", CHITIETDKM);
		return  SystemCommon.ADMIN_STORE;
	}
	
	
}
