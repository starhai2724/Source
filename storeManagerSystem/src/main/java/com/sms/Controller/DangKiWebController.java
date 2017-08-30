package com.sms.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

import com.sms.OutputRows.KhachHangOutputRowBean;
import com.sms.common.MD5HashingExample;
import com.sms.common.SMSComons;
import com.sms.dao.ChiTietHoaDonDAO;
import com.sms.dao.CreateTableProductDAO;
import com.sms.dao.DangKiWebDAO;
import com.sms.dao.DotKhuyenMaiDAO;
import com.sms.dao.HoaDonDAO;
import com.sms.dao.KhachHangDAO;
import com.sms.dao.KhoHangDAO;
import com.sms.dao.LienHeDAO;
import com.sms.dao.LoaiKinhDoanhDAO;
import com.sms.dao.LoaiTheDAO;
import com.sms.dao.NhomSanPhamDAO;
import com.sms.form.DangKiWebForm;
import com.sms.form.LoaiKinhDoanhForm;
import com.sms.formRows.ChiTietHoaDonRowForm;
import com.sms.input.ChiTietHoaDonInputBean;
import com.sms.input.DangKiWebInputBean;
import com.sms.input.HoaDonInputBean;
import com.sms.input.KhachHangInputBean;
import com.sms.input.LienHeInputBean;
import com.sms.input.LoaiKinhDoanhInputBean;
import com.sms.input.LoaiTheInputBean;
import com.sms.input.RegisterProductCategoryInputBean;
import com.sms.input.SanPhamInputBean;
import com.sms.output.LoaiKinhDoanhOutputBean;
import com.sms.session.KhachHangSession;

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
		form.setMessage("");
		form.setMessageErr("");
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
		
		cnt = LienHeDAO.intances.createTable(inputBean.getPathJSP());
		
		createDataNhomSanPham(form.getPathJSP());
		
		try {
			createDataSanPham(form.getPathJSP());
		} catch (FileNotFoundException e) {
			
		}
		
		createDataLoaiThe(form.getPathJSP());
		
		createDataKhachHang(form.getPathJSP());
		
		createDataLienHe(form.getPathJSP());
		
		if(cnt == 0){
			return "redirect:/";
		}else {
			session.setAttribute(PAGECENTER, PAGE_STEP3);
			form.setMessageErr("Xử lý đăng kí không thành công.");
			form.setMessage("");
		}
		return PAGE;
	}
	
	private void createDataNhomSanPham(String pathJSP){
		
		//Nhom san pham (S)
		RegisterProductCategoryInputBean inputBean = new RegisterProductCategoryInputBean();
		inputBean.setIdNhomSP("");
		inputBean.setTenNhomSP("Nhóm 1");
		inputBean.setPathJSP(pathJSP);
		int cnt = NhomSanPhamDAO.intances.insertNhomSP(inputBean);
		
		inputBean.setIdNhomSP("");
		inputBean.setTenNhomSP("Nhóm 2");
		inputBean.setPathJSP(pathJSP);
		cnt = NhomSanPhamDAO.intances.insertNhomSP(inputBean);
		
		// 1
		inputBean = new RegisterProductCategoryInputBean();
		inputBean.setPathJSP(pathJSP);
		inputBean.setTenLoaiSP("Loại 1");
		inputBean.setIdNhomSP("1");
		inputBean.setIdLoaiSP("");
		cnt = NhomSanPhamDAO.intances.insertLoaiSP(inputBean);
		
		inputBean = new RegisterProductCategoryInputBean();
		inputBean.setPathJSP(pathJSP);
		inputBean.setTenLoaiSP("Loại 2");
		inputBean.setIdNhomSP("1");
		inputBean.setIdLoaiSP("");
		cnt = NhomSanPhamDAO.intances.insertLoaiSP(inputBean);
		
		// 2
		inputBean = new RegisterProductCategoryInputBean();
		inputBean.setPathJSP(pathJSP);
		inputBean.setTenLoaiSP("Loại 1");
		inputBean.setIdNhomSP("2");
		inputBean.setIdLoaiSP("");
		cnt = NhomSanPhamDAO.intances.insertLoaiSP(inputBean);
		
		inputBean = new RegisterProductCategoryInputBean();
		inputBean.setPathJSP(pathJSP);
		inputBean.setTenLoaiSP("Loại 2");
		inputBean.setIdNhomSP("2");
		inputBean.setIdLoaiSP("");
		cnt = NhomSanPhamDAO.intances.insertLoaiSP(inputBean);
		//Nhom san pham (E)
		
	}
	
	private void createDataSanPham(String pathJSP) throws FileNotFoundException{
		int cnt;
		FileInputStream fileInputStream;
		SanPhamInputBean input;
		File file;
		byte[] bFile_1; 
		file = new File("D:/THISIS/images.jpg");
		fileInputStream = new FileInputStream(file);
		bFile_1 = new byte[(int) file.length()];
		try {
			fileInputStream.read(bFile_1);
		} catch (IOException e) {
		}
		
		for(int i = 1; i < 3; i++){
			input = new SanPhamInputBean();
			input.setSEQ("");
			input.setPathJSP(pathJSP);
			input.setIdSanPham("AAA00"+i);
			input.setTenSP("Sản phẩm "+i);
			input.setIdLoaiSP("1");
			input.setGiaMua("100000");
			input.setGiaBan("150000");
			input.setTrangThai("0");
			input.setMoTa("Sản phẩm mẫu AAA00"+i);
			input.setNgayTao(SMSComons.getDate());
			input.setHinh(bFile_1);
			cnt = CreateTableProductDAO.intances.insert(input);
			cnt = KhoHangDAO.intances.insertKhoHang(pathJSP, "0", input.getIdSanPham());
		}		
		
		for(int i = 4; i < 7; i++){
			input = new SanPhamInputBean();
			input.setSEQ("");
			input.setPathJSP(pathJSP);
			input.setIdSanPham("AAA00"+i);
			input.setTenSP("Sản phẩm "+i);
			input.setIdLoaiSP("4");
			input.setGiaMua("100000");
			input.setGiaBan("150000");
			input.setTrangThai("0");
			input.setMoTa("Sản phẩm mẫu AAA00"+i);
			input.setNgayTao(SMSComons.getDate());
			input.setHinh(bFile_1);
			cnt = CreateTableProductDAO.intances.insert(input);
			cnt = KhoHangDAO.intances.insertKhoHang(pathJSP, "0", input.getIdSanPham());
		}
		
		
	}
	
	private void createDataLoaiThe(String pathJSP){
		LoaiTheInputBean inputBean = new LoaiTheInputBean();
		inputBean.setPathJSP(pathJSP);
		inputBean.setIdLoaiThe("");
		inputBean.setTenLoaiThe("Thành viên");
		inputBean.setDiem("50");
		//insert
		int cnt = LoaiTheDAO.intances.insert(inputBean);
		
		inputBean = new LoaiTheInputBean();
		inputBean.setPathJSP(pathJSP);
		inputBean.setIdLoaiThe("");
		inputBean.setTenLoaiThe("VIP");
		inputBean.setDiem("10000");
		//insert
		cnt = LoaiTheDAO.intances.insert(inputBean);
	}
	
	private void createDataKhachHang(String pathJSP){
		KhachHangInputBean inputBean;
		int cnt; 
		//input
		for(int i = 1; i < 6;i++){
			inputBean = new KhachHangInputBean();
			inputBean.setPathJSP(pathJSP);
			inputBean.setIdKhachHang("");
			inputBean.setTenKhachHang("Khách hàng "+i);
			inputBean.setLoaiThe("1");
			inputBean.setGioiTinh("Nam");
			inputBean.setSoDienThoai("0163976451"+i);
			inputBean.setDiaChi("phường 16 quận Gò Vấp");
			inputBean.setSoDiem("300");
			inputBean.setNgaySinh("19940301");
			inputBean.setNgayTao(SMSComons.getDate());
			inputBean.setNgaySua("");
			//insert
			cnt = KhachHangDAO.intances.insert(inputBean);
		}
		
		for(int i = 6; i < 10;i++){
			inputBean = new KhachHangInputBean();
			inputBean.setPathJSP(pathJSP);
			inputBean.setIdKhachHang("");
			inputBean.setTenKhachHang("Khách hàng "+i);
			inputBean.setLoaiThe("2");
			inputBean.setGioiTinh("Nữ");
			inputBean.setSoDienThoai("0163976451"+i);
			inputBean.setDiaChi("phường 16 quận Gò Vấp");
			inputBean.setSoDiem("10000");
			inputBean.setNgaySinh("19940301");
			inputBean.setNgayTao(SMSComons.getDate());
			inputBean.setNgaySua("");
			//insert
			cnt = KhachHangDAO.intances.insert(inputBean);
		}
	}
	
	private void createDataLienHe(String pathJSP){
		LienHeInputBean inputBean;
		int cnt;
		
		inputBean = new LienHeInputBean();
		inputBean.setPathJSP(pathJSP);
		inputBean.setIdLienHe("");
		inputBean.setTenKH("Nguyễn Văn Huy");
		inputBean.setDiaChi("phường 16 quận Gò Vấp");
		inputBean.setEmail("star242704237@gmail.com");
		inputBean.setSdt("01639764514");
		inputBean.setTieuDe("Liên hệ 1");
		inputBean.setNoiDungNhan("Khách hàng liên hệ 1");
		inputBean.setNoiDungTraLoi("");
		inputBean.setTrangThai("0");
		inputBean.setNgayNhan(SMSComons.getDate());
		inputBean.setNgayTraLoi("");
		inputBean.setIdKH("");
		//insert
		cnt = LienHeDAO.intances.insert(inputBean);
		
		inputBean = new LienHeInputBean();
		inputBean.setPathJSP(pathJSP);
		inputBean.setIdLienHe("");
		inputBean.setTenKH("Nguyễn Văn Hà");
		inputBean.setDiaChi("phường 16 quận Gò Vấp");
		inputBean.setEmail("star242704237@gmail.com");
		inputBean.setSdt("0995773024");
		inputBean.setTieuDe("Liên hệ 1");
		inputBean.setNoiDungNhan("Khách hàng liên hệ 2");
		inputBean.setNoiDungTraLoi("");
		inputBean.setTrangThai("0");
		inputBean.setNgayNhan(SMSComons.getDate());
		inputBean.setNgayTraLoi("");
		inputBean.setIdKH("");
		//insert
		cnt = LienHeDAO.intances.insert(inputBean);
		
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
