package com.sms.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sms.OutputRows.SanPhamOutputRowBean;
import com.sms.common.SMSComons;
import com.sms.common.SystemCommon;
import com.sms.dao.CreateTableProductDAO;
import com.sms.dao.KhoHangDAO;
import com.sms.dao.LayoutDAO;
import com.sms.dao.SystemProductDAO;
import com.sms.form.ProductForm;
import com.sms.formRows.ProductFormRow;
import com.sms.input.SanPhamInputBean;
import com.sms.output.SanPhamOutputBean;
@Controller
public class QuanLySanPhamTrangChuControler {
	public static final String PAGE = "quanLySanPhamTrangChu.jsp";
	
	@RequestMapping(value  = "/quanLySanPhamTrangChu/init")
	public String init(@ModelAttribute("ProductForm") ProductForm form, HttpSession session){
		//reset message
		form.setMessage("");
		form.setMessageErr("");
		//init data
		initData(form);
		
		session.setAttribute(SystemCommon.PAGE_ID, PAGE);
		return SystemCommon.PAGE_HOME;
	}
	
	private void initData(ProductForm form){
		SanPhamInputBean inputBean = new SanPhamInputBean();
		SanPhamOutputBean outputBean = SystemProductDAO.intances.getSanPhamApDung_3();
		ProductFormRow formRow; 
		int cnt = 1;
		for(SanPhamOutputRowBean sanPhamOutputRowBean : outputBean.getLst()){
				String[] result = null;
				result = sanPhamOutputRowBean.getIdSanPham().split("_");
				formRow = new ProductFormRow();
				formRow.setNo(String.valueOf(cnt++));
				formRow.setSEQ(sanPhamOutputRowBean.getSEQ());
				formRow.setIdSanPham(sanPhamOutputRowBean.getIdSanPham());
				
				formRow.setTenSP(sanPhamOutputRowBean.getTenSP());
				
				formRow.setTenLoaiSP(sanPhamOutputRowBean.getTenLoaiSP());/// nho sua
				formRow.setIdLoaiSP(result[0]);
				formRow.setGiaMua(SMSComons.formatMoney(sanPhamOutputRowBean.getGiaMua()));
		    	formRow.setGiaBanKM(sanPhamOutputRowBean.getGiaBanKM());
			    formRow.setGiaBan(SMSComons.formatMoney(sanPhamOutputRowBean.getGiaBan()));	
				form.getLst().add(formRow);
			}
	}
	
	@RequestMapping(value="/quanLySanPhamTrangChu/delete/{id}")
	public String delete(@ModelAttribute("ProductForm") ProductForm form, @PathVariable("id") String id, HttpSession session){

		//insert
		int cnt = SystemProductDAO.intances.deleteProductBySEQ(id);
		
		if(cnt == 1){
			form.setMessage("Xử lý xóa thành công.");
			form.setMessageErr("");
		}else {
			form.setMessageErr("Xử lý xóa không thành công.");
			form.setMessage("");
		}
		//init data
		initData(form);
		
		session.setAttribute(SystemCommon.PAGE_ID, PAGE);
		return SystemCommon.PAGE_HOME;
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
