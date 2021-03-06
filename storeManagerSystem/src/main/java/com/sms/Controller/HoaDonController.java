package com.sms.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sms.OutputRows.ChiTietHoaDonOutputRowBean;
import com.sms.OutputRows.HoaDonOutputRowBean;
import com.sms.OutputRows.SanPhamOutputRowBean;
import com.sms.common.SMSComons;
import com.sms.common.SystemCommon;
import com.sms.dao.ChiTietHoaDonDAO;
import com.sms.dao.CreateTableProductDAO;
import com.sms.dao.HoaDonDAO;
import com.sms.dao.LayoutDAO;
import com.sms.form.HoaDonForm;
import com.sms.formRows.ChiTietHoaDonRowForm;
import com.sms.formRows.HoaDonRowForm;
import com.sms.formRows.ProductFormRow;
import com.sms.input.ChiTietHoaDonInputBean;
import com.sms.input.HoaDonInputBean;
import com.sms.input.SanPhamInputBean;
import com.sms.output.SanPhamOutputBean;

@Controller
@SessionAttributes(value = {"HoaDonForm"}, types = {HoaDonForm.class})
public class HoaDonController {

	public static final String PAGE = "hoaDon.jsp";
	
	 @ModelAttribute("HoaDonForm")
	 public HoaDonForm getHoaDonForm() {
	   return new HoaDonForm(); //or however you create a default
	 }
	
	@RequestMapping(value  = "/bill/init")
	public String init(@ModelAttribute("HoaDonForm") HoaDonForm form, HttpSession session){
		String pathJSP = (String)session.getAttribute("pathURL"); 
		// check pathJSP
		if (!LayoutDAO.intances.checkPathJSP(pathJSP)) {
			// quay ve trang login
			return "redirect:/";
		}
		//reset
		form.setIdHoaDon("");
		form.setIdKhachHang("");
		form.setNgayLap("");
		form.setSoLuongSP("");
		form.setDiemTichLuy("");
		form.setTongDiemTichLuy("");
		form.setTienKhuyenMai("");
		form.setTongTien("");
		//Flag update
		form.setFlagUpdate("0");
		form.setFlagNew("0");
		
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
	
	private void initData(HoaDonForm form, String pathJSP){
		
		List<HoaDonOutputRowBean> lst = HoaDonDAO.intances.getAll(pathJSP);
		
		form.getChiTietHoaDonRowForms().clear();
		form.getLst().clear();
		HoaDonRowForm formRow; 
		int cnt = 1;
		if(lst != null && lst.size() > 0){
			for(int i = 0; lst.size() > i; i++){
				HoaDonOutputRowBean outputRowBean = lst.get(i);	
				formRow = new HoaDonRowForm();
				formRow.setNo(String.valueOf(cnt++));
				formRow.setIdHoaDon(outputRowBean.getIdHoaDon());
				formRow.setIdKhachHang(outputRowBean.getIdKhachHang());
				formRow.setNgayLap(SMSComons.formatDate(outputRowBean.getNgayLap()));
				formRow.setSoLuongSP(outputRowBean.getSoLuongSP());
				formRow.setDiemTichLuy(outputRowBean.getDiemTichLuy());
				formRow.setTongDiemTichLuy(outputRowBean.getTongDiemTichLuy());
				formRow.setTienKhuyenMai(SMSComons.formatMoney(outputRowBean.getTienKhuyenMai()));
				formRow.setTongTien(SMSComons.formatMoney(outputRowBean.getTongTien()));
				form.getLst().add(formRow);
			}
		}
		//Su dung de phan anh danh sach san pham (S)
		form.getLstSanPham().clear();
		SanPhamOutputBean outputBeanPhanAnh = CreateTableProductDAO.intances.getSanPhamApDung(pathJSP,"");
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
				formRowPhanAnh.setGiaMua(outputRowBean.getGiaMua());
				formRowPhanAnh.setGiaBan(outputRowBean.getGiaBan());
				form.getLstSanPham().add(formRowPhanAnh);
			}
		}
		//Su dung de phan anh danh sach san pham (E)
	}
	
	/**
	 * 
	 * @param form
	 * @param session
	 * @return
	 */
	
	@RequestMapping(value ="/bill/insert", method = RequestMethod.POST)
	public String insert(@ModelAttribute("HoaDonForm") HoaDonForm form, HttpSession session) {
		//get domain
		String pathJSP = (String)session.getAttribute("pathURL");
		// check pathJSP
		if (!LayoutDAO.intances.checkPathJSP(pathJSP)) {
			// quay ve trang login
			return "redirect:/";
		}
		
		double totalMoney = 0;
		int soLuong = 0;
		for(ChiTietHoaDonRowForm chiTietHoaDonRowForm : form.getChiTietHoaDonRowForms()){
			totalMoney += Integer.parseInt(chiTietHoaDonRowForm.getSoLuongSP())*Double.parseDouble(chiTietHoaDonRowForm.getGiaMua());
			soLuong += Integer.parseInt(chiTietHoaDonRowForm.getSoLuongSP());
		}
		
		//input
		HoaDonInputBean hoaDonInputBean = new HoaDonInputBean();
		hoaDonInputBean.setIdHoaDon("");
		hoaDonInputBean.setIdKhachHang(form.getIdKhachHang());
		hoaDonInputBean.setPathJSP(pathJSP);
		hoaDonInputBean.setSoLuongSP(String.valueOf(soLuong));
		hoaDonInputBean.setTienKhuyenMai("");
		// 10000 d set duoc tinh la 1 diem
		hoaDonInputBean.setTongDiemTichLuy(String.valueOf(totalMoney / 10000));
		hoaDonInputBean.setTongTien(String.valueOf(totalMoney));
		hoaDonInputBean.setNgayLap(SMSComons.getDate());
		//insert
		int cnt = HoaDonDAO.intances.insert(hoaDonInputBean);
		
		if (cnt == 1) {
			String idHoaDon = HoaDonDAO.intances.getMaxId(pathJSP);
			
			for(ChiTietHoaDonRowForm chiTietHoaDonRowForm : form.getChiTietHoaDonRowForms()){
				
				ChiTietHoaDonInputBean chiTietHoaDonInputBean = new ChiTietHoaDonInputBean();
				chiTietHoaDonInputBean.setPathJSP(pathJSP);
				chiTietHoaDonInputBean.setIdChiTietHoaDon("");
				chiTietHoaDonInputBean.setIdHoaDon(idHoaDon);
				chiTietHoaDonInputBean.setIdSanPham(chiTietHoaDonRowForm.getIdSanPham());
				chiTietHoaDonInputBean.setGiaMua(chiTietHoaDonRowForm.getGiaMua());
				chiTietHoaDonInputBean.setSoLuongSP(chiTietHoaDonRowForm.getSoLuongSP());
				chiTietHoaDonInputBean.setThanhTien(Integer.parseInt(chiTietHoaDonRowForm.getSoLuongSP())*Double.parseDouble(chiTietHoaDonRowForm.getGiaMua())+"");
				cnt = ChiTietHoaDonDAO.intances.insert(chiTietHoaDonInputBean);
			}
		}	
		
		
		form.setFlagNew("0");
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
	
	@RequestMapping(value ="/bill/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("HoaDonForm") HoaDonForm form, HttpSession session){
		//get domain
		String pathJSP = (String)session.getAttribute("pathURL");
		// check pathJSP
		if (!LayoutDAO.intances.checkPathJSP(pathJSP)) {
			// quay ve trang login
			return "redirect:/";
		}
		
		//input
		HoaDonInputBean inputBean = new HoaDonInputBean();
		inputBean.setPathJSP(pathJSP);
		inputBean.setIdHoaDon("");
		inputBean.setIdKhachHang(form.getIdKhachHang());
		inputBean.setNgayLap(SMSComons.getDate());
		inputBean.setSoLuongSP(form.getSoLuongSP());
		inputBean.setDiemTichLuy(form.getDiemTichLuy());
		inputBean.setTongDiemTichLuy(form.getTongDiemTichLuy());
		inputBean.setTienKhuyenMai(form.getTienKhuyenMai());
		inputBean.setTongTien(form.getTongTien());
		
		//insert
		int cnt = HoaDonDAO.intances.update(inputBean);
		
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
	@RequestMapping(value="/bill/getById/{id}", method = RequestMethod.POST)
	public String getProductById(@ModelAttribute("HoaDonForm") HoaDonForm form, @PathVariable("id") String id, HttpSession session){
		//get domain
		String pathJSP = (String)session.getAttribute("pathURL");
		// check pathJSP
		if (!LayoutDAO.intances.checkPathJSP(pathJSP)) {
			// quay ve trang login
			return "redirect:/";
		}
		
		form.getChiTietHoaDonRowForms().clear();

		HoaDonInputBean inputBean = new HoaDonInputBean();
		inputBean.setPathJSP(pathJSP);
		inputBean.setIdHoaDon(id);
		
		
		List<HoaDonOutputRowBean> lst = HoaDonDAO.intances.getById(inputBean);
		HoaDonOutputRowBean outputRowBean = lst.get(0);
		form.setIdHoaDon(outputRowBean.getIdHoaDon());
		form.setIdKhachHang(outputRowBean.getIdKhachHang());
//		form.setNgayLap(outputRowBean.getNgayLap());
//		form.setSoLuongSP(outputRowBean.getSoLuongSP());
//		form.setDiemTichLuy(outputRowBean.getDiemTichLuy());
//		form.setTongDiemTichLuy(outputRowBean.getTongDiemTichLuy());
//		form.setTienKhuyenMai(outputRowBean.getTienKhuyenMai());
//		form.setTongTien(outputRowBean.getTongTien());
		ChiTietHoaDonInputBean chiTietHoaDonInputBean = new ChiTietHoaDonInputBean();
		chiTietHoaDonInputBean.setPathJSP(pathJSP);
		chiTietHoaDonInputBean.setIdHoaDon(id);
		List<ChiTietHoaDonOutputRowBean>  chiTietHoaDonOutputRowBeans = ChiTietHoaDonDAO.intances.getById(chiTietHoaDonInputBean);
		ChiTietHoaDonRowForm chiTietHoaDonRowForm;
		int cnt = 1;
		for(ChiTietHoaDonOutputRowBean chiTietHoaDonOutputRowBean : chiTietHoaDonOutputRowBeans){
			chiTietHoaDonRowForm = new ChiTietHoaDonRowForm();
			chiTietHoaDonRowForm.setNo(String.valueOf(cnt++));
			chiTietHoaDonRowForm.setIdChiTietHoaDon(chiTietHoaDonOutputRowBean.getIdChiTietHoaDon());
			chiTietHoaDonRowForm.setIdSanPham(chiTietHoaDonOutputRowBean.getIdSanPham());
			chiTietHoaDonRowForm.setLoaiSanPham(chiTietHoaDonOutputRowBean.getLoaiSanPham());
			chiTietHoaDonRowForm.setTenSanPham(chiTietHoaDonOutputRowBean.getTenSanPham());
			chiTietHoaDonRowForm.setSoLuongSP(chiTietHoaDonOutputRowBean.getSoLuongSP());
			chiTietHoaDonRowForm.setGiaMua(chiTietHoaDonOutputRowBean.getGiaMua());
			chiTietHoaDonRowForm.setThanhTien(chiTietHoaDonOutputRowBean.getThanhTien());
			form.getChiTietHoaDonRowForms().add(chiTietHoaDonRowForm);
		}
		
		//Flag update
		form.setFlagUpdate("1");
		form.setFlagNew("1");
		//init data
//		initData(form, pathJSP);
		
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
	@RequestMapping(value="/bill/delete/{id}")
	public String delete(@ModelAttribute("HoaDonForm") HoaDonForm form, @PathVariable("id") String id, HttpSession session){
		//get domain
		String pathJSP = (String)session.getAttribute("pathURL");
		// check pathJSP
		if (!LayoutDAO.intances.checkPathJSP(pathJSP)) {
			// quay ve trang login
			return "redirect:/";
		}
		HoaDonInputBean input = new HoaDonInputBean();	
		input.setPathJSP(pathJSP);
		input.setIdHoaDon(id);
		
		//delete
		int cnt = HoaDonDAO.intances.deleteById(input);
		
		//delete chi tiet hoa don
		ChiTietHoaDonInputBean chiTietHoaDonInputBean = new ChiTietHoaDonInputBean();
		chiTietHoaDonInputBean.setPathJSP(pathJSP);
		chiTietHoaDonInputBean.setIdHoaDon(id);
		cnt = ChiTietHoaDonDAO.intances.deleteById(chiTietHoaDonInputBean);
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
	
	
	@RequestMapping(value="/bill/phanAnh/{listId}", method = RequestMethod.POST)
	public String phanAnh(@ModelAttribute("HoaDonForm") HoaDonForm form, HttpSession session,@PathVariable("listId") String listId){
		//get domain
		String pathJSP = (String)session.getAttribute("pathURL");
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
		SanPhamOutputBean outputBean;
		SanPhamOutputRowBean outputRowBean;
		SanPhamInputBean input;
		ChiTietHoaDonRowForm chiTietHoaDonRowForm;
		String idSP = "";
		int cnt = 1;
		boolean checkErr = false;
		for(int i = 0; i< lstPhanAnh.size() ; i++){
			
			input = new SanPhamInputBean();
			input.setPathJSP(pathJSP);
			input.setSEQ(lstPhanAnh.get(i).toString());
			SanPhamOutputBean sanPhamOutputBean = CreateTableProductDAO.intances.getProductById(input);
			if(sanPhamOutputBean != null && sanPhamOutputBean.getLst().size() > 0){
				idSP = sanPhamOutputBean.getLst().get(0).getIdSanPham();
			}
			for (ChiTietHoaDonRowForm chiTietHoaDonRowForm2 : form.getChiTietHoaDonRowForms()) {
				if(chiTietHoaDonRowForm2.getIdSanPham().equals(idSP)){
					checkErr = true;
					idSP = "";
				}
			}
			if(checkErr) {
				checkErr = false;
				continue;
			}
			
			input = new SanPhamInputBean();
			input.setPathJSP(pathJSP);
			input.setSEQ(lstPhanAnh.get(i).toString());
			//get data theo id va group theo id 
			outputBean = CreateTableProductDAO.intances.getProductById_GroupById(input);
			if(outputBean != null && outputBean.getLst().size() > 0){
				outputRowBean = outputBean.getLst().get(0);
				chiTietHoaDonRowForm = new ChiTietHoaDonRowForm();
				chiTietHoaDonRowForm.setNo(String.valueOf(cnt++));
				chiTietHoaDonRowForm.setIdChiTietHoaDon("");
				chiTietHoaDonRowForm.setIdSanPham(outputRowBean.getIdSanPham());
				chiTietHoaDonRowForm.setLoaiSanPham(outputRowBean.getTenLoaiSP());
				chiTietHoaDonRowForm.setTenSanPham(outputRowBean.getTenSP());
				chiTietHoaDonRowForm.setSoLuongSP("1");
				if(outputRowBean.getGiaBanKM() == null || "".equals(outputRowBean.getGiaBanKM())){
					chiTietHoaDonRowForm.setGiaMua(outputRowBean.getGiaBan());
				}else {
					chiTietHoaDonRowForm.setGiaMua(outputRowBean.getGiaBanKM());
				}
				chiTietHoaDonRowForm.setThanhTien("");
				form.getChiTietHoaDonRowForms().add(chiTietHoaDonRowForm);
			}
		}
		form.setFlagNew("1");
		session.setAttribute("PAGEIDSTORE", PAGE);
		return  SystemCommon.ADMIN_STORE;
	}
	
	@RequestMapping(value  = "/bill/xoaDong/{listId}", method = RequestMethod.POST)
	public String xoaDong(@ModelAttribute("HoaDonForm") HoaDonForm form, HttpSession session, @PathVariable("listId") String listId){
		List<ChiTietHoaDonRowForm> lst = form.getChiTietHoaDonRowForms();
		// remove ","
		if (!"".equals(listId)) {
			listId = listId.substring(1);
			String[] parts = listId.split(",");
			listId = "";
			for (int i = 0; i < parts.length; i++) {
				for(int k = 0; k < form.getLst().size();k++){
					//Delete cac san pham dc chon
					if(parts[i].equals(form.getLst().get(k).getNo())){
						lst.remove(form.getChiTietHoaDonRowForms().get(k));
					}
				}
			}
		}
		session.setAttribute("PAGEIDSTORE", PAGE);
		return  SystemCommon.ADMIN_STORE;
	}
	
}
