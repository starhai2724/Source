package com.sms.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.sms.OutputRows.SanPhamOutputRowBean;
import com.sms.common.SMSComons;
import com.sms.common.SystemCommon;
import com.sms.dao.CreateTableProductDAO;
import com.sms.dao.NhomSanPhamDAO;
import com.sms.form.ProductForm;
import com.sms.formRows.ProductFormRow;
import com.sms.input.LoaiSanPhamInputBean;
import com.sms.input.NhomSanPhamInputBean;
import com.sms.input.SanPhamInputBean;
import com.sms.output.LoaiSanPhamOutputBean;
import com.sms.output.NhomSanPhamOutputBean;
import com.sms.output.SanPhamOutputBean;

@Controller
@SessionAttributes(value ="ProductForm", types = {ProductForm.class})
public class ProductController {
	RestTemplate restTemplate = new RestTemplate();
	public static final String PRODUCT = "product.jsp";
	
	@ModelAttribute("ProductForm")
	 public ProductForm getProductForm() {
	   return new ProductForm(); //or however you create a default
	 }
	
	@RequestMapping(value  = "/product/init")
	public String init(@ModelAttribute("ProductForm") ProductForm form, HttpSession session){
		String pathJSP = (String)session.getAttribute("pathURL"); 
		
		//reset
		form.setIdSanPham("");
		form.setSEQ("");
		form.setTenSP("");
		form.setGiaMua("");
		form.setGiaBan("");
		form.setMoTa("");
		form.setIdLoaiSP("");
		//Flag update
		form.setFlagUpdate("0");
		//reset message
		form.setMessage("");
		form.setMessageErr("");
		//init data
		initData(form, pathJSP);
		
		session.setAttribute("PAGEIDSTORE", PRODUCT);
		return  SystemCommon.ADMIN_STORE;
	}
	
	/**
	 * 
	 * @param form
	 * @param pathJSP
	 */
	
	private void initData(ProductForm form, String pathJSP){
		//reset form
		form.getLst().clear();
		
		LoaiSanPhamInputBean loaiSanPhamInputBean = new LoaiSanPhamInputBean();
		loaiSanPhamInputBean.setPathJSP(pathJSP);
		List<LoaiSanPhamOutputBean> listLoaiSP = NhomSanPhamDAO.intances.getNhomSPAndLoaiSP(loaiSanPhamInputBean);
		for(LoaiSanPhamOutputBean outputBean : listLoaiSP){
			form.getLstCategory().put(outputBean.getIdLoaiSP(), outputBean.getTenLoaiSP());
		}
		
		SanPhamOutputBean outputBean = CreateTableProductDAO.intances.getProducts(pathJSP);
		ProductFormRow formRow; 
		int cnt = 1;
		if(outputBean != null && outputBean.getLst().size() > 0){
			for(int i = 0; i <  outputBean.getLst().size() ; i++){
				SanPhamOutputRowBean outputRowBean = outputBean.getLst().get(i);	
				formRow = new ProductFormRow();
				formRow.setNo(String.valueOf(cnt++));
				formRow.setSEQ(outputRowBean.getSEQ());
				formRow.setIdSanPham(outputRowBean.getIdSanPham());
				formRow.setTenSP(outputRowBean.getTenSP());
				formRow.setTenLoaiSP(outputRowBean.getTenLoaiSP());
				formRow.setGiaMua(outputRowBean.getGiaMua());
				formRow.setGiaBan(outputRowBean.getGiaBan());
				formRow.setNgayTao(outputRowBean.getNgayTao());
				formRow.setNgayChinhSua(outputRowBean.getNgayChinhSua());
				formRow.setMoTa(outputRowBean.getMoTa());
				form.getLst().add(formRow);
			}
		}

	}
	
	
	@RequestMapping(value ="/product/insert", method = RequestMethod.POST)
	public String insert(@ModelAttribute("ProductForm") ProductForm form, @RequestParam("file") MultipartFile file, HttpSession session) {
		//get domain
		String pathJSP = (String)session.getAttribute("pathURL"); 
		
		SanPhamInputBean input = new SanPhamInputBean();
		input.setSEQ("");
		input.setPathJSP(pathJSP);
		input.setIdSanPham(form.getIdSanPham());
		input.setTenSP(form.getTenSP());
		input.setIdLoaiSP(form.getIdLoaiSP());
		input.setGiaMua(form.getGiaMua());
		input.setGiaBan(form.getGiaBan());
		input.setTrangThai("0");
		input.setMoTa(form.getMoTa());
		//Image
		byte[] bFile = null;
		try {
			bFile = file.getBytes();
		} catch (IOException e) {
		
		}
		input.setHinh(bFile); 
		input.setNgayTao(SMSComons.getDate());
		//insert
		int cnt = CreateTableProductDAO.intances.insert(input);
		
		if(cnt == 1){
			form.setMessage("Xử lý đăng kí thành công.");
			form.setMessageErr("");
		}else {
			form.setMessageErr("Xử lý đăng kí không thành công.");
			form.setMessage("");
		}
		
		//init data
		initData(form, pathJSP);
		
		session.setAttribute("PAGEIDSTORE", PRODUCT);
		return  SystemCommon.ADMIN_STORE;
	}
	
	@RequestMapping(value ="/product/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("ProductForm") ProductForm form, @RequestParam("file") MultipartFile file , HttpSession session){
		//get domain
		String pathJSP = (String)session.getAttribute("pathURL"); 
		
		SanPhamInputBean input = new SanPhamInputBean();
		input.setPathJSP(pathJSP);
		input.setSEQ(form.getSEQ());
		input.setIdSanPham(form.getIdSanPham());
		input.setTenSP(form.getTenSP());
		input.setIdLoaiSP(form.getIdLoaiSP());
		input.setGiaMua(form.getGiaMua());
		input.setGiaBan(form.getGiaBan());
		input.setTrangThai("0");
		input.setMoTa(form.getMoTa());
		//Image
		byte[] bFile = null;
		try {
			bFile = file.getBytes();
		} catch (IOException e) {
		
		}
		input.setHinh(bFile); 
		input.setNgayChinhSua(SMSComons.getDate());
		
		//insert
		int cnt = CreateTableProductDAO.intances.update(input);
		
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
		
		session.setAttribute("PAGEIDSTORE", PRODUCT);
		return  SystemCommon.ADMIN_STORE;
	}
	
	@RequestMapping(value="product/getProductById/{SEQ}", method = RequestMethod.POST)
	public String getProductById(@ModelAttribute("ProductForm") ProductForm form, @PathVariable("SEQ") String SEQ, HttpSession session){
		//get domain
		String pathJSP = (String)session.getAttribute("pathURL"); 
		
		SanPhamInputBean input = new SanPhamInputBean();
		input.setPathJSP(pathJSP);
		input.setSEQ(SEQ);
		
		SanPhamOutputBean outputBean = CreateTableProductDAO.intances.getProductById(input);
		SanPhamOutputRowBean outputRowBean = outputBean.getLst().get(0);
		form.setSEQ(outputRowBean.getSEQ());
		form.setIdSanPham(outputRowBean.getIdSanPham());
		form.setTenSP(outputRowBean.getTenSP());
		form.setGiaMua(outputRowBean.getGiaMua());
		form.setGiaBan(outputRowBean.getGiaBan());
		form.setMoTa(outputRowBean.getMoTa());
		form.setIdLoaiSP(outputRowBean.getIdLoaiSP());
		//Flag update
		form.setFlagUpdate("1");
		
		//init data
		LoaiSanPhamInputBean loaiSanPhamInputBean = new LoaiSanPhamInputBean();
		loaiSanPhamInputBean.setPathJSP(pathJSP);
		List<LoaiSanPhamOutputBean> listLoaiSP = NhomSanPhamDAO.intances.getNhomSPAndLoaiSP(loaiSanPhamInputBean);
		for(LoaiSanPhamOutputBean outputBean_2 : listLoaiSP){
			form.getLstCategory().put(outputBean_2.getIdLoaiSP(), outputBean_2.getTenLoaiSP());
		}
		// reset detail
		form.getLst().clear();
		
		SanPhamOutputBean sanPhamOutputBean = CreateTableProductDAO.intances.getProducts(pathJSP);
		ProductFormRow formRow; 
		int cnt = 1;
		if(outputBean != null && sanPhamOutputBean.getLst().size() > 0){
			for(int i = 0; sanPhamOutputBean.getLst().size() > i; i++){
				SanPhamOutputRowBean sanPhamoutputRowBean = sanPhamOutputBean.getLst().get(i);	
				formRow = new ProductFormRow();
				formRow.setNo(String.valueOf(cnt++));
				formRow.setSEQ(sanPhamoutputRowBean.getSEQ());
				formRow.setIdSanPham(sanPhamoutputRowBean.getIdSanPham());
				formRow.setTenSP(sanPhamoutputRowBean.getTenSP());
				formRow.setTenLoaiSP(sanPhamoutputRowBean.getTenLoaiSP());
				formRow.setGiaMua(sanPhamoutputRowBean.getGiaMua());
				formRow.setGiaBan(sanPhamoutputRowBean.getGiaBan());
				formRow.setNgayTao(sanPhamoutputRowBean.getNgayTao());
				formRow.setNgayChinhSua(sanPhamoutputRowBean.getNgayChinhSua());
				formRow.setMoTa(sanPhamoutputRowBean.getMoTa());
				form.getLst().add(formRow);
			}
		}
		
		session.setAttribute("PAGEIDSTORE", PRODUCT);
		return  SystemCommon.ADMIN_STORE;
	}
	
	@RequestMapping(value="/product/delete/{id}")
	public String delete(@ModelAttribute("ProductForm") ProductForm form, @PathVariable("id") String id, HttpSession session){
		//get domain
		String pathJSP = (String)session.getAttribute("pathURL"); 
		SanPhamInputBean inputBean = new SanPhamInputBean();
		inputBean.setPathJSP(pathJSP);
		inputBean.setIdSanPham(id);
		//insert
		int cnt = CreateTableProductDAO.intances.deleteProductById(inputBean);
		
		if(cnt == 1){
			form.setMessage("Xử lý xóa thành công.");
			form.setMessageErr("");
		}else {
			form.setMessageErr("Xử lý xóa không thành công.");
			form.setMessage("");
		}
		//init data
		initData(form, pathJSP);
		
		session.setAttribute("PAGEIDSTORE", PRODUCT);
		return  SystemCommon.ADMIN_STORE;
	}
	
	@RequestMapping(value="product/phanAnh/{listId}", method = RequestMethod.POST)
	public String phanAnh(@ModelAttribute("ProductForm") ProductForm form, HttpSession session,@PathVariable("listId") String listId){
		
		List lstPhanAnh = new ArrayList<String>();
		// remove ","
		if (!"".equals(listId) || !"0".equals(listId)) {
			listId = listId.substring(1);
			String[] parts = listId.split(",");
			listId = "";
			for (int i = 0; i < parts.length; i++) {
				lstPhanAnh.add(parts[i]);
			}
		}
		session.setAttribute("lstPhanAnh", lstPhanAnh);
		return  "redirect:/chiTietDKM/initPhanAnh";
	}
	
	public static void main(String[] args) {
		ProductController controller = new ProductController();
		controller.init(new ProductForm(), null);
	}
}
