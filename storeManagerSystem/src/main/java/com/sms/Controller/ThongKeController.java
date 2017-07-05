package com.sms.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sms.OutputRows.HoaDonOutputRowBean;
import com.sms.OutputRows.KhachHangOutputRowBean;
import com.sms.OutputRows.SanPhamOutputRowBean;
import com.sms.common.SystemCommon;
import com.sms.dao.CreateTableProductDAO;
import com.sms.dao.HoaDonDAO;
import com.sms.dao.KhachHangDAO;
import com.sms.dao.NhomSanPhamDAO;
import com.sms.form.ThongKeForm;
import com.sms.input.HoaDonInputBean;
import com.sms.input.KhachHangInputBean;
import com.sms.input.LoaiSanPhamInputBean;
import com.sms.input.NhomSanPhamInputBean;
import com.sms.input.SanPhamInputBean;
import com.sms.output.LoaiSanPhamOutputBean;
import com.sms.output.NhomSanPhamOutputBean;

@Controller
public class ThongKeController {
	public static final String CHITIETDKM = "thongKe.jsp";
	
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
	
	@RequestMapping(value ="/thongKe/init", method = RequestMethod.GET)	
	public String thongKe(@ModelAttribute("ThongKeForm") ThongKeForm form, HttpSession session){
		 double tongDoanhThu_trongNgay = 0;
		 int tongGiaoDich_trongNgay = 0;
		 int tongSoThanhVienMoi_trongNgay = 0;
		 int sanPhamMoi_chiTiet = 0;
		 int tongSPBanRa = 0;
		
		
		String ngayHienHanh = "20170703";
		String pathJSP = (String)session.getAttribute("pathURL");
		HoaDonInputBean inputBean = new HoaDonInputBean();
		inputBean.setPathJSP(pathJSP);
		inputBean.setNgayLap(ngayHienHanh);
		
		List<HoaDonOutputRowBean> lstHD = HoaDonDAO.intances.getByNgayLapHD(inputBean);
		for (HoaDonOutputRowBean hoaDon : lstHD) {
			if(null!= hoaDon.getTongTien() && !"".equals(hoaDon.getTongTien())){
				tongDoanhThu_trongNgay += Integer.parseInt(hoaDon.getTongTien());
			}
			if(null!= hoaDon.getSoLuongSP() && !"".equals(hoaDon.getSoLuongSP())){
				tongSPBanRa += Integer.parseInt(hoaDon.getSoLuongSP());
			}
		}
		
		KhachHangInputBean inputBeanKH = new KhachHangInputBean();
		inputBeanKH.setPathJSP(pathJSP);
		inputBeanKH.setNgayTao(ngayHienHanh);
		List<KhachHangOutputRowBean> lstKH = KhachHangDAO.intances.getByNgayTao(inputBeanKH);
		tongSoThanhVienMoi_trongNgay = lstKH.size();
		tongGiaoDich_trongNgay = lstHD.size();
		
		SanPhamInputBean inputBeanSP = new SanPhamInputBean();
		inputBeanSP.setPathJSP(pathJSP);
		inputBeanSP.setNgayTao(ngayHienHanh);
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
		
		session.setAttribute("PAGEIDSTORE", CHITIETDKM);
		return  SystemCommon.ADMIN_STORE;
	}
	
	@RequestMapping(value ="/thongKe/thang", method = RequestMethod.GET)	
	public String thongKe_thang(@ModelAttribute("ThongKeForm") ThongKeForm form, HttpSession session){
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
		
		
		String ngayHienHanh = "20170703";
		String pathJSP = (String)session.getAttribute("pathURL");
		HoaDonInputBean inputBean = new HoaDonInputBean();
		inputBean.setPathJSP(pathJSP);
		inputBean.setNgayLap(ngayHienHanh);
		
		List<HoaDonOutputRowBean> lstHD = HoaDonDAO.intances.getByNgayLapHD(inputBean);
		for (HoaDonOutputRowBean hoaDon : lstHD) {
			if(null!= hoaDon.getTongTien() && !"".equals(hoaDon.getTongTien())){
				tongDoanhThu_trongNgay += Integer.parseInt(hoaDon.getTongTien());
			}
			if(null!= hoaDon.getSoLuongSP() && !"".equals(hoaDon.getSoLuongSP())){
				tongSPBanRa += Integer.parseInt(hoaDon.getSoLuongSP());
			}
		}
		
		List<HoaDonOutputRowBean> lstHD_thang = HoaDonDAO.intances.getAll(pathJSP);
		for (HoaDonOutputRowBean hoaDon : lstHD_thang) {
			if(null != hoaDon.getNgayLap() && !"".equals(hoaDon.getNgayLap()) && hoaDon.getNgayLap().trim().length() == 6){
				if(hoaDon.getNgayLap().substring(0, 7).equals(ngayHienHanh.substring(0, 7))){
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
		inputBeanKH.setNgayTao(ngayHienHanh);
		List<KhachHangOutputRowBean> lstKH = KhachHangDAO.intances.getByNgayTao(inputBeanKH);
		for (KhachHangOutputRowBean kh : lstKH) {
			if(kh.getNgayTao().substring(0, 7).equals(ngayHienHanh.substring(0, 7))){
				tongSoThanhVienMoi_thang ++;
			}
		}
		tongSoThanhVienMoi_trongNgay = lstKH.size();
		tongGiaoDich_trongNgay = lstHD.size();
		
		SanPhamInputBean inputBeanSP = new SanPhamInputBean();
		inputBeanSP.setPathJSP(pathJSP);
		inputBeanSP.setNgayTao(ngayHienHanh);
		List<SanPhamOutputRowBean> lstSP = CreateTableProductDAO.intances.getProductByNgayTao(inputBeanSP);
		for (SanPhamOutputRowBean sp : lstSP) {
			if(sp.getNgayTao().substring(0, 7).equals(ngayHienHanh.substring(0, 7))){
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
		
		session.setAttribute("PAGEIDSTORE", CHITIETDKM);
		return  SystemCommon.ADMIN_STORE;
	}
	
	@RequestMapping(value ="/thongKe/nam", method = RequestMethod.GET)	
	public String thongKe_nam(@ModelAttribute("ThongKeForm") ThongKeForm form, HttpSession session){		 double tongDoanhThu_trongNgay = 0;
	 int tongGiaoDich_trongNgay = 0;
	 int tongSoThanhVienMoi_trongNgay = 0;
	 int sanPhamMoi_chiTiet = 0;
	 int tongSPBanRa = 0;
	 int tongSPBanRa_thang = 0;
	 double tongDoanhThu_thang = 0;
	 int tongGiaoDich_nam = 0;
	 int tongSoThanhVienMoi_nam = 0;
	 int tongSPMoi_nam = 0;
	
	
	String ngayHienHanh = "20170703";
	String pathJSP = (String)session.getAttribute("pathURL");
	HoaDonInputBean inputBean = new HoaDonInputBean();
	inputBean.setPathJSP(pathJSP);
	inputBean.setNgayLap(ngayHienHanh);
	
	List<HoaDonOutputRowBean> lstHD = HoaDonDAO.intances.getByNgayLapHD(inputBean);
	for (HoaDonOutputRowBean hoaDon : lstHD) {
		if(null!= hoaDon.getTongTien() && !"".equals(hoaDon.getTongTien())){
			tongDoanhThu_trongNgay += Integer.parseInt(hoaDon.getTongTien());
		}
		if(null!= hoaDon.getSoLuongSP() && !"".equals(hoaDon.getSoLuongSP())){
			tongSPBanRa += Integer.parseInt(hoaDon.getSoLuongSP());
		}
	}
	
	List<HoaDonOutputRowBean> lstHD_thang = HoaDonDAO.intances.getAll(pathJSP);
	for (HoaDonOutputRowBean hoaDon : lstHD_thang) {
		if(null != hoaDon.getNgayLap() && !"".equals(hoaDon.getNgayLap()) && hoaDon.getNgayLap().trim().length() == 6){
			if(hoaDon.getNgayLap().substring(0, 5).equals(ngayHienHanh.substring(0, 5))){
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
	inputBeanKH.setNgayTao(ngayHienHanh);
	List<KhachHangOutputRowBean> lstKH = KhachHangDAO.intances.getByNgayTao(inputBeanKH);
	for (KhachHangOutputRowBean kh : lstKH) {
		if(kh.getNgayTao().substring(0,5).equals(ngayHienHanh.substring(0, 5))){
			tongSoThanhVienMoi_nam ++;
		}
	}
	tongSoThanhVienMoi_trongNgay = lstKH.size();
	tongGiaoDich_trongNgay = lstHD.size();
	
	SanPhamInputBean inputBeanSP = new SanPhamInputBean();
	inputBeanSP.setPathJSP(pathJSP);
	inputBeanSP.setNgayTao(ngayHienHanh);
	List<SanPhamOutputRowBean> lstSP = CreateTableProductDAO.intances.getProductByNgayTao(inputBeanSP);
	for (SanPhamOutputRowBean sp : lstSP) {
		if(sp.getNgayTao().substring(0, 5).equals(ngayHienHanh.substring(0, 5))){
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
	
	session.setAttribute("PAGEIDSTORE", CHITIETDKM);
	return  SystemCommon.ADMIN_STORE;}
	
}
