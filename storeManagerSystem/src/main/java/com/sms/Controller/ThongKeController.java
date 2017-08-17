package com.sms.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sms.OutputRows.HoaDonOutputRowBean;
import com.sms.OutputRows.KhachHangOutputRowBean;
import com.sms.OutputRows.SanPhamOutputRowBean;
import com.sms.common.SMSComons;
import com.sms.common.SystemCommon;
import com.sms.dao.CreateTableProductDAO;
import com.sms.dao.HoaDonDAO;
import com.sms.dao.KhachHangDAO;
import com.sms.dao.LayoutDAO;
import com.sms.dao.NhomSanPhamDAO;
import com.sms.form.KhachHangForm;
import com.sms.form.ThongKeForm;
import com.sms.form.ThongKeTheoQuyForm;
import com.sms.input.HoaDonInputBean;
import com.sms.input.KhachHangInputBean;
import com.sms.input.LoaiSanPhamInputBean;
import com.sms.input.NhomSanPhamInputBean;
import com.sms.input.SanPhamInputBean;
import com.sms.output.LoaiSanPhamOutputBean;
import com.sms.output.NhomSanPhamOutputBean;

@Controller
@SessionAttributes(value ="ThongKeForm", types = {ThongKeForm.class})
public class ThongKeController {
	public static final String THONGKE = "thongKe.jsp";
	public static final String NgayHienHanh = SMSComons.getDate();
	
	/*@RequestMapping(value  = "/chiTietDKM/init")
	public String init(@ModelAttribute("ProductForm3") ProductForm form, HttpSession session){
		String pathJSP = (String)session.getAttribute("pathURL"); 
		String idDKM = (String)session.getAttribute("idDKM");
		
		//reset message
		form.setMessage("");
		form.setMessageErr("");
		//init data
		
		session.setAttribute("PAGEIDSTORE", CHITIETDKM);
		return  SystemCommon.ADMIN_STORE;
	}*/
	
	@ModelAttribute("ThongKeForm")
	public ThongKeForm getThongKeForm() {
	  return new ThongKeForm(); //or however you create a default
	}
	
	@RequestMapping(value ="/thongKe/init", method = RequestMethod.GET)	
	public String thongKe(@ModelAttribute("ThongKeForm") ThongKeForm form, HttpSession session){
		String pathJSP = (String)session.getAttribute("pathURL"); 
		// check pathJSP
		if (!LayoutDAO.intances.checkPathJSP(pathJSP)) {
			// quay ve trang login
			return "redirect:/";
		}
		 double tongDoanhThu_trongNgay = 0;
		 int tongGiaoDich_trongNgay = 0;
		 int tongSoThanhVienMoi_trongNgay = 0;
		 int sanPhamMoi_chiTiet = 0;
		 int tongSPBanRa = 0;
		
		
		//String ngayHienHanh = "20170703";
		 
		HoaDonInputBean inputBean = new HoaDonInputBean();
		inputBean.setPathJSP(pathJSP);
		inputBean.setNgayLap(NgayHienHanh);
		
		List<HoaDonOutputRowBean> lstHD = HoaDonDAO.intances.getByNgayLapHD(inputBean);
		for (HoaDonOutputRowBean hoaDon : lstHD) {
			if(null!= hoaDon.getTongTien() && !"".equals(hoaDon.getTongTien())){
				tongDoanhThu_trongNgay += Double.parseDouble(hoaDon.getTongTien());
			}
			if(null!= hoaDon.getSoLuongSP() && !"".equals(hoaDon.getSoLuongSP())){
				tongSPBanRa += Integer.parseInt(hoaDon.getSoLuongSP());
			}
		}
		
		KhachHangInputBean inputBeanKH = new KhachHangInputBean();
		inputBeanKH.setPathJSP(pathJSP);
		inputBeanKH.setNgayTao(NgayHienHanh);
		List<KhachHangOutputRowBean> lstKH = KhachHangDAO.intances.getByNgayTao(inputBeanKH);
		tongSoThanhVienMoi_trongNgay = lstKH.size();
		tongGiaoDich_trongNgay = lstHD.size();
		
		SanPhamInputBean inputBeanSP = new SanPhamInputBean();
		inputBeanSP.setPathJSP(pathJSP);
		inputBeanSP.setNgayTao(NgayHienHanh);
		List<SanPhamOutputRowBean> lstSP = CreateTableProductDAO.intances.getProductByNgayTao(inputBeanSP);
		
		NhomSanPhamInputBean nhomSanPhamInputBean = new NhomSanPhamInputBean();
		nhomSanPhamInputBean.setPathJSP(pathJSP);
		List<NhomSanPhamOutputBean> listNhomSP = NhomSanPhamDAO.intances.getNhomSP(nhomSanPhamInputBean);
		
		LoaiSanPhamInputBean loaiSanPhamInputBean = new LoaiSanPhamInputBean();
		loaiSanPhamInputBean.setPathJSP(pathJSP);
		List<LoaiSanPhamOutputBean> listLoaiSP = NhomSanPhamDAO.intances.getLoaiSP(loaiSanPhamInputBean);
		
		
		// header
		form.setTongLuotTheoDoi_trongNgay("0");
		form.setTongDoanhThu_trongNgay(String.format("%,.2f",tongDoanhThu_trongNgay) + "");
		form.setTongGiaoDich_trongNgay(tongGiaoDich_trongNgay +"");
		form.setTongSoThanhVienMoi_trongNgay(tongSoThanhVienMoi_trongNgay + "");
		//Detail
		form.setLuotTheoDoi_chiTiet("0");
		form.setDoanhThu_chiTiet(String.format("%,.2f",tongDoanhThu_trongNgay) + "");
		form.setSanPhamDuocBanRa_chiTiet(tongSPBanRa + "");
		form.setGiaoDich_chiTiet(tongGiaoDich_trongNgay + "");
		form.setTongThanhVien_chiTiet(tongSoThanhVienMoi_trongNgay +"");
		form.setTongSPMoi_chiTiet(lstSP.size() + "");
		form.setTongNhomSP_chiTiet(listNhomSP.size() + "");
		form.setTongLoaiSP_chiTiet(listLoaiSP.size() + "");
		
		//thong ke bieu do
		int namBD = Integer.parseInt("2017");
		int namKT =Integer.parseInt("2017");
		String tong = "0";
		List<Quy> lst = listQuy(namBD, namKT);
		List<ThongKeTheoQuyForm> theoQuyForms = new ArrayList<>();
		ThongKeTheoQuyForm thongKeTheoQuyForm;
		for(Quy quy : lst){
			thongKeTheoQuyForm = new ThongKeTheoQuyForm();
			thongKeTheoQuyForm.setNam(quy.getNam()+" "+quy.getQuy());
			thongKeTheoQuyForm.setQuy(quy.getQuy());
			tong = HoaDonDAO.intances.getThongKeTheoQuy(pathJSP, quy.getNgayBD(), quy.getNgayKT());
			if(tong == null || "".equals(tong)){
				thongKeTheoQuyForm.setTongDoanhThu("0");
			}else {
				thongKeTheoQuyForm.setTongDoanhThu(tong);
			}
			theoQuyForms.add(thongKeTheoQuyForm);
		}
		
		session.setAttribute("ThongKeTheoQuyForm", theoQuyForms);
		session.setAttribute("PAGEIDSTORE", THONGKE);
		return  SystemCommon.ADMIN_STORE;
	}
	
	@RequestMapping(value ="/thongKe/ngay", method = RequestMethod.POST)	
	public String ngay(@ModelAttribute("ThongKeForm") ThongKeForm form, HttpSession session){
		String pathJSP = (String)session.getAttribute("pathURL"); 
		// check pathJSP
		if (!LayoutDAO.intances.checkPathJSP(pathJSP)) {
			// quay ve trang login
			return "redirect:/";
		}
		 double tongDoanhThu_trongNgay = 0;
		 int tongGiaoDich_trongNgay = 0;
		 int tongSoThanhVienMoi_trongNgay = 0;
		 int sanPhamMoi_chiTiet = 0;
		 int tongSPBanRa = 0;
		
		
		//String ngayHienHanh = "20170703";
		 
		HoaDonInputBean inputBean = new HoaDonInputBean();
		inputBean.setPathJSP(pathJSP);
		inputBean.setNgayLap(NgayHienHanh);
		
		List<HoaDonOutputRowBean> lstHD = HoaDonDAO.intances.getByNgayLapHD(inputBean);
		for (HoaDonOutputRowBean hoaDon : lstHD) {
			if(null!= hoaDon.getTongTien() && !"".equals(hoaDon.getTongTien())){
				tongDoanhThu_trongNgay += Double.parseDouble(hoaDon.getTongTien());
			}
			if(null!= hoaDon.getSoLuongSP() && !"".equals(hoaDon.getSoLuongSP())){
				tongSPBanRa += Integer.parseInt(hoaDon.getSoLuongSP());
			}
		}
		
		KhachHangInputBean inputBeanKH = new KhachHangInputBean();
		inputBeanKH.setPathJSP(pathJSP);
		inputBeanKH.setNgayTao(NgayHienHanh);
		List<KhachHangOutputRowBean> lstKH = KhachHangDAO.intances.getByNgayTao(inputBeanKH);
		tongSoThanhVienMoi_trongNgay = lstKH.size();
		tongGiaoDich_trongNgay = lstHD.size();
		
		SanPhamInputBean inputBeanSP = new SanPhamInputBean();
		inputBeanSP.setPathJSP(pathJSP);
		inputBeanSP.setNgayTao(NgayHienHanh);
		List<SanPhamOutputRowBean> lstSP = CreateTableProductDAO.intances.getProductByNgayTao(inputBeanSP);
		
		NhomSanPhamInputBean nhomSanPhamInputBean = new NhomSanPhamInputBean();
		nhomSanPhamInputBean.setPathJSP(pathJSP);
		List<NhomSanPhamOutputBean> listNhomSP = NhomSanPhamDAO.intances.getNhomSP(nhomSanPhamInputBean);
		
		LoaiSanPhamInputBean loaiSanPhamInputBean = new LoaiSanPhamInputBean();
		loaiSanPhamInputBean.setPathJSP(pathJSP);
		List<LoaiSanPhamOutputBean> listLoaiSP = NhomSanPhamDAO.intances.getLoaiSP(loaiSanPhamInputBean);
		
		
		// header
		form.setTongLuotTheoDoi_trongNgay("0");
		form.setTongDoanhThu_trongNgay(String.format("%,.2f",tongDoanhThu_trongNgay) + "");
		form.setTongGiaoDich_trongNgay(tongGiaoDich_trongNgay +"");
		form.setTongSoThanhVienMoi_trongNgay(tongSoThanhVienMoi_trongNgay + "");
		//Detail
		form.setLuotTheoDoi_chiTiet("0");
		form.setDoanhThu_chiTiet(String.format("%,.2f",tongDoanhThu_trongNgay) + "");
		form.setSanPhamDuocBanRa_chiTiet(tongSPBanRa + "");
		form.setGiaoDich_chiTiet(tongGiaoDich_trongNgay + "");
		form.setTongThanhVien_chiTiet(tongSoThanhVienMoi_trongNgay +"");
		form.setTongSPMoi_chiTiet(lstSP.size() + "");
		form.setTongNhomSP_chiTiet(listNhomSP.size() + "");
		form.setTongLoaiSP_chiTiet(listLoaiSP.size() + "");
		
		//thong ke bieu do
		int namBD = Integer.parseInt("2017");
		int namKT =Integer.parseInt("2017");
		String tong = "0";
		List<Quy> lst = listQuy(namBD, namKT);
		List<ThongKeTheoQuyForm> theoQuyForms = new ArrayList<>();
		ThongKeTheoQuyForm thongKeTheoQuyForm;
		for(Quy quy : lst){
			thongKeTheoQuyForm = new ThongKeTheoQuyForm();
			thongKeTheoQuyForm.setNam(quy.getNam()+" "+quy.getQuy());
			thongKeTheoQuyForm.setQuy(quy.getQuy());
			tong = HoaDonDAO.intances.getThongKeTheoQuy(pathJSP, quy.getNgayBD(), quy.getNgayKT());
			if(tong == null || "".equals(tong)){
				thongKeTheoQuyForm.setTongDoanhThu("0");
			}else {
				thongKeTheoQuyForm.setTongDoanhThu(tong);
			}
			theoQuyForms.add(thongKeTheoQuyForm);
		}
		
		session.setAttribute("ThongKeTheoQuyForm", theoQuyForms);
		session.setAttribute("PAGEIDSTORE", THONGKE);
		return  SystemCommon.ADMIN_STORE;
	}
	
	@RequestMapping(value ="/thongKe/thang", method = RequestMethod.POST)	
	public String thongKe_thang(@ModelAttribute("ThongKeForm") ThongKeForm form, HttpSession session){
		String pathJSP = (String)session.getAttribute("pathURL"); 
		// check pathJSP
		if (!LayoutDAO.intances.checkPathJSP(pathJSP)) {
			// quay ve trang login
			return "redirect:/";
		}
		 double tongDoanhThu_trongNgay = 0;
		 int tongGiaoDich_trongNgay = 0;
		 int tongSoThanhVienMoi_trongNgay = 0;
		 int sanPhamMoi_chiTiet = 0;
		 int tongSPBanRa = 0;
		 int tongSPBanRa_thang = 0;
		 double tongDoanhThu_thang = 0;
		 int tongGiaoDich_thang = 0;
		 int tongSoThanhVienMoi_thang = 0;
		 int tongSPMoi_thang = 0;
		
		
		//String ngayHienHanh = "20170703";
		HoaDonInputBean inputBean = new HoaDonInputBean();
		inputBean.setPathJSP(pathJSP);
		inputBean.setNgayLap(NgayHienHanh);
		
		List<HoaDonOutputRowBean> lstHD = HoaDonDAO.intances.getByNgayLapHD(inputBean);
		for (HoaDonOutputRowBean hoaDon : lstHD) {
			if(null!= hoaDon.getTongTien() && !"".equals(hoaDon.getTongTien())){
				tongDoanhThu_trongNgay += Double.parseDouble(hoaDon.getTongTien());
			}
			if(null!= hoaDon.getSoLuongSP() && !"".equals(hoaDon.getSoLuongSP())){
				tongSPBanRa += Integer.parseInt(hoaDon.getSoLuongSP());
			}
		}
		
		List<HoaDonOutputRowBean> lstHD_thang = HoaDonDAO.intances.getAll(pathJSP);
		for (HoaDonOutputRowBean hoaDon : lstHD_thang) {
			if(null != hoaDon.getNgayLap() && !"".equals(hoaDon.getNgayLap()) && hoaDon.getNgayLap().trim().length() == 8){
				if(hoaDon.getNgayLap().substring(0, 6).equals(NgayHienHanh.substring(0, 6))){
					if(null!= hoaDon.getTongTien() && !"".equals(hoaDon.getTongTien())){
						tongDoanhThu_thang += Double.parseDouble(hoaDon.getTongTien());
					}
					tongSPBanRa_thang += Integer.parseInt(hoaDon.getSoLuongSP());
					tongGiaoDich_thang ++;
				}
			}
		}
		
		KhachHangInputBean inputBeanKH = new KhachHangInputBean();
		inputBeanKH.setPathJSP(pathJSP);
		inputBeanKH.setNgayTao(NgayHienHanh);
		List<KhachHangOutputRowBean> lstKH = KhachHangDAO.intances.getAll(pathJSP);
		for (KhachHangOutputRowBean kh : lstKH) {
			if(kh.getNgayTao().substring(0, 6).equals(NgayHienHanh.substring(0, 6))){
				tongSoThanhVienMoi_thang ++;
			}
		}
		tongSoThanhVienMoi_trongNgay = lstKH.size();
		tongGiaoDich_trongNgay = lstHD.size();
		
		SanPhamInputBean inputBeanSP = new SanPhamInputBean();
		inputBeanSP.setPathJSP(pathJSP);
		inputBeanSP.setNgayTao(NgayHienHanh.substring(0, 4));
		List<SanPhamOutputRowBean> lstSP = CreateTableProductDAO.intances.getProductByNgayTao(inputBeanSP);
		for (SanPhamOutputRowBean sp : lstSP) {
			if(sp.getNgayTao().substring(0, 6).equals(NgayHienHanh.substring(0, 6))){
				tongSPMoi_thang ++;
			}
		}
		
		
		NhomSanPhamInputBean nhomSanPhamInputBean = new NhomSanPhamInputBean();
		nhomSanPhamInputBean.setPathJSP(pathJSP);
		List<NhomSanPhamOutputBean> listNhomSP = NhomSanPhamDAO.intances.getNhomSP(nhomSanPhamInputBean);
		
		LoaiSanPhamInputBean loaiSanPhamInputBean = new LoaiSanPhamInputBean();
		loaiSanPhamInputBean.setPathJSP(pathJSP);
		List<LoaiSanPhamOutputBean> listLoaiSP = NhomSanPhamDAO.intances.getLoaiSP(loaiSanPhamInputBean);
		
		
		// header
		form.setTongLuotTheoDoi_trongNgay("0");
		form.setTongDoanhThu_trongNgay(String.format("%,.2f",tongDoanhThu_trongNgay) + "");
		form.setTongGiaoDich_trongNgay(tongGiaoDich_trongNgay +"");
		form.setTongSoThanhVienMoi_trongNgay(tongSoThanhVienMoi_trongNgay + "");
		
		//Detail
		form.setLuotTheoDoi_chiTiet("0");
		form.setDoanhThu_chiTiet(String.format("%,.2f",tongDoanhThu_thang) + "");
		form.setSanPhamDuocBanRa_chiTiet(tongSPBanRa_thang + "");
		form.setGiaoDich_chiTiet(tongGiaoDich_thang + "");
		form.setTongThanhVien_chiTiet(tongSoThanhVienMoi_thang +"");
		form.setTongSPMoi_chiTiet(tongSPMoi_thang + "");
		form.setTongNhomSP_chiTiet(listNhomSP.size() + "");
		form.setTongLoaiSP_chiTiet(listLoaiSP.size() + "");
		
		session.setAttribute("PAGEIDSTORE", THONGKE);
		return  SystemCommon.ADMIN_STORE;
	}
	
	@RequestMapping(value ="/thongKe/nam", method = RequestMethod.POST)	
	public String thongKe_nam(@ModelAttribute("ThongKeForm") ThongKeForm form, HttpSession session){	
	String pathJSP = (String)session.getAttribute("pathURL"); 
	// check pathJSP
	if (!LayoutDAO.intances.checkPathJSP(pathJSP)) {
		// quay ve trang login
		return "redirect:/";
	}
	 double tongDoanhThu_trongNgay = 0;
	 int tongGiaoDich_trongNgay = 0;
	 int tongSoThanhVienMoi_trongNgay = 0;
	 int sanPhamMoi_chiTiet = 0;
	 int tongSPBanRa = 0;
	 int tongSPBanRa_thang = 0;
	 double tongDoanhThu_thang = 0;
	 int tongGiaoDich_nam = 0;
	 int tongSoThanhVienMoi_nam = 0;
	 int tongSPMoi_nam = 0;
	
	
	//String ngayHienHanh = "20170703";
	HoaDonInputBean inputBean = new HoaDonInputBean();
	inputBean.setPathJSP(pathJSP);
	inputBean.setNgayLap(NgayHienHanh);
	
	List<HoaDonOutputRowBean> lstHD = HoaDonDAO.intances.getByNgayLapHD(inputBean);
	for (HoaDonOutputRowBean hoaDon : lstHD) {
		if(null!= hoaDon.getTongTien() && !"".equals(hoaDon.getTongTien())){
			tongDoanhThu_trongNgay += Double.parseDouble(hoaDon.getTongTien());
		}
		if(null!= hoaDon.getSoLuongSP() && !"".equals(hoaDon.getSoLuongSP())){
			tongSPBanRa += Integer.parseInt(hoaDon.getSoLuongSP());
		}
	}
	
	List<HoaDonOutputRowBean> lstHD_thang = HoaDonDAO.intances.getAll(pathJSP);
	for (HoaDonOutputRowBean hoaDon : lstHD_thang) {
		if(null != hoaDon.getNgayLap() && !"".equals(hoaDon.getNgayLap()) && hoaDon.getNgayLap().trim().length() == 8){
			if(hoaDon.getNgayLap().substring(0, 4).equals(NgayHienHanh.substring(0, 4))){
				if(null!= hoaDon.getTongTien() && !"".equals(hoaDon.getTongTien())){
					tongDoanhThu_thang += Double.parseDouble(hoaDon.getTongTien());
				}
				tongSPBanRa_thang += Integer.parseInt(hoaDon.getSoLuongSP());
				tongGiaoDich_nam ++;
			}
		}
	}
	
	KhachHangInputBean inputBeanKH = new KhachHangInputBean();
	inputBeanKH.setPathJSP(pathJSP);
	inputBeanKH.setNgayTao(NgayHienHanh);
	List<KhachHangOutputRowBean> lstKH = KhachHangDAO.intances.getAll(pathJSP);
	for (KhachHangOutputRowBean kh : lstKH) {
		if(kh.getNgayTao().substring(0,5).equals(NgayHienHanh.substring(0, 5))){
			tongSoThanhVienMoi_nam ++;
		}
	}
	tongSoThanhVienMoi_trongNgay = lstKH.size();
	tongGiaoDich_trongNgay = lstHD.size();
	
	SanPhamInputBean inputBeanSP = new SanPhamInputBean();
	inputBeanSP.setPathJSP(pathJSP);
	inputBeanSP.setNgayTao(NgayHienHanh.substring(0, 4));
	List<SanPhamOutputRowBean> lstSP = CreateTableProductDAO.intances.getProductByNgayTao(inputBeanSP);
	for (SanPhamOutputRowBean sp : lstSP) {
		if(sp.getNgayTao().substring(0, 4).equals(NgayHienHanh.substring(0, 4))){
			tongSPMoi_nam ++;
		}
	}
	
	
	NhomSanPhamInputBean nhomSanPhamInputBean = new NhomSanPhamInputBean();
	nhomSanPhamInputBean.setPathJSP(pathJSP);
	List<NhomSanPhamOutputBean> listNhomSP = NhomSanPhamDAO.intances.getNhomSP(nhomSanPhamInputBean);
	
	LoaiSanPhamInputBean loaiSanPhamInputBean = new LoaiSanPhamInputBean();
	loaiSanPhamInputBean.setPathJSP(pathJSP);
	List<LoaiSanPhamOutputBean> listLoaiSP = NhomSanPhamDAO.intances.getLoaiSP(loaiSanPhamInputBean);
	
	
	// header
	form.setTongLuotTheoDoi_trongNgay("0");
	form.setTongDoanhThu_trongNgay(String.format("%,.2f",tongDoanhThu_trongNgay) + "");
	form.setTongGiaoDich_trongNgay(tongGiaoDich_trongNgay +"");
	form.setTongSoThanhVienMoi_trongNgay(tongSoThanhVienMoi_trongNgay + "");
	
	//Detail
	form.setLuotTheoDoi_chiTiet("0");
	form.setDoanhThu_chiTiet(String.format("%,.2f",tongDoanhThu_thang) + "");
	form.setSanPhamDuocBanRa_chiTiet(tongSPBanRa_thang + "");
	form.setGiaoDich_chiTiet(tongGiaoDich_nam + "");
	form.setTongThanhVien_chiTiet(tongSoThanhVienMoi_nam +"");
	form.setTongSPMoi_chiTiet(tongSPMoi_nam + "");
	form.setTongNhomSP_chiTiet(listNhomSP.size() + "");
	form.setTongLoaiSP_chiTiet(listLoaiSP.size() + "");
	
	session.setAttribute("PAGEIDSTORE", THONGKE);
	return  SystemCommon.ADMIN_STORE;
	}
	
	@RequestMapping(value ="/thongKe/thongKeBieuDo", method = RequestMethod.POST)	
	public String thongKeBieuDo(@ModelAttribute("ThongKeForm") ThongKeForm form, HttpSession session){
		String pathJSP = (String)session.getAttribute("pathURL"); 
		// check pathJSP
		if (!LayoutDAO.intances.checkPathJSP(pathJSP)) {
			// quay ve trang login
			return "redirect:/";
		}
		int namBD = Integer.parseInt(form.getNamBD());
		int namKT =Integer.parseInt(form.getNamKT());
		String tong = "0";
		List<Quy> lst = listQuy(namBD, namKT);
		List<ThongKeTheoQuyForm> theoQuyForms = new ArrayList<>();
		ThongKeTheoQuyForm thongKeTheoQuyForm;
		for(Quy quy : lst){
			thongKeTheoQuyForm = new ThongKeTheoQuyForm();
			thongKeTheoQuyForm.setNam(quy.getNam()+" "+quy.getQuy());
			thongKeTheoQuyForm.setQuy(quy.getQuy());
			tong = HoaDonDAO.intances.getThongKeTheoQuy(pathJSP, quy.getNgayBD(), quy.getNgayKT());
			if(tong == null || "".equals(tong)){
				thongKeTheoQuyForm.setTongDoanhThu("0");
			}else {
				thongKeTheoQuyForm.setTongDoanhThu(tong);
			}
			theoQuyForms.add(thongKeTheoQuyForm);
		}
		
		session.setAttribute("ThongKeTheoQuyForm", theoQuyForms);
		session.setAttribute("PAGEIDSTORE", THONGKE);
		return  SystemCommon.ADMIN_STORE;
	}
	
	private List<Quy> list(int quyBD, int quyKT, int namBD, int namKT){
		String result = "";
		List<Quy> lst = new ArrayList<>();
		Quy quy;
		int soNam = namKT - namBD;
		int thangBD = quyBD * 3;
		int soThang = soNam*12 + quyKT*3 + quyBD*3;
		for(int i = 0; i <= soNam; i++){
			
		}
		
		int i = 1;
		while(soThang > 0){
			quy = new Quy();
			if(i % 4 == 0 ){
				namBD = namBD + 1;
				quyBD = 1;
				i = 1;
			}
			quy.setQuy("Q"+String.valueOf(quyBD + i-1));
			quy.setNgayBD(namBD+"" + getNgayBD(String.valueOf(quyBD + i-1)));
			quy.setNgayKT(namBD+"" + getNgayKT(String.valueOf(quyBD + i-1)));
			quy.setNam(namBD+"");
			lst.add(quy);
			i++;
			soThang = soThang - 3;
		}
		return lst;
	}
	
	private List<Quy> listQuy(int namBD, int namKT){
		List<Quy> lst = new ArrayList<>();
		Quy quy;
		int soNam = namKT - namBD;
		int soQuy = soNam*4 + 4;
		int i = 1;
		while(soQuy > 0){
			quy = new Quy();
			quy.setQuy("Q"+String.valueOf(i));
			quy.setNgayBD(namBD+"" + getNgayBD(String.valueOf(i)));
			quy.setNgayKT(namBD+"" + getNgayKT(String.valueOf(i)));
			quy.setNam(namBD+"");
			lst.add(quy);
			if(i % 4 == 0 ){
				namBD = namBD + 1;
				i = 1;
			}else{
				i++;
			}
			soQuy--;
		}
		return lst;
	}
	/**
	 * 
	 * @param quy
	 * @return
	 */
	private String getNgayBD(String quy){
		if(quy.equals("1")){
			return "0101";
		}else if(quy.equals("2")){
			return "0401";
		}else if(quy.equals("3")){
			return "0701";
		}else if(quy.equals("4")){
			return "1001";
		}
		return "";
	}
	/**
	 * 
	 * @param quy
	 * @return
	 */
	private String getNgayKT(String quy){
		if(quy.equals("1")){
			return "0330";
		}else if(quy.equals("2")){
			return "0630";
		}else if(quy.equals("3")){
			return "0930";
		}else if(quy.equals("4")){
			return "1230";
		}
		return "";
	}
	
	
	
	/**
	 * 
	 * @author User
	 *
	 */
	private class Quy{
		private String ngayBD;
		
		private String ngayKT;
		
		private String nam;
		
		private String quy;

		public String getNgayBD() {
			return ngayBD;
		}

		public void setNgayBD(String ngayBD) {
			this.ngayBD = ngayBD;
		}

		public String getNgayKT() {
			return ngayKT;
		}

		public void setNgayKT(String ngayKT) {
			this.ngayKT = ngayKT;
		}

		public String getQuy() {
			return quy;
		}

		public void setQuy(String quy) {
			this.quy = quy;
		}

		public String getNam() {
			return nam;
		}

		public void setNam(String nam) {
			this.nam = nam;
		}
		
	}
	public static void main(String[] args) {
		int quyBD = Integer.parseInt("2");
		int quyKT = Integer.parseInt("3");
		int namBD = Integer.parseInt("2017");
		int namKT =Integer.parseInt("2017");
		String tong = "0";
		ThongKeController controller = new ThongKeController();
//		List<Quy> lst = controller.list(quyBD, quyKT, namBD, namKT);
		controller.listQuy(2017, 2018);
	}
	
}
