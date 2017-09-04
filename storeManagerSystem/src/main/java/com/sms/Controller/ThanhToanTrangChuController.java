package com.sms.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sms.OutputRows.LoaiTheOutputRowBean;
import com.sms.OutputRows.SanPhamOutputRowBean;
import com.sms.common.SMSComons;
import com.sms.dao.ChiTietHoaDonDAO;
import com.sms.dao.CreateTableProductDAO;
import com.sms.dao.DangKiWebDAO;
import com.sms.dao.HoaDonDAO;
import com.sms.dao.KhachHangDAO;
import com.sms.dao.KhoHangDAO;
import com.sms.dao.LayoutDAO;
import com.sms.dao.LoaiTheDAO;
import com.sms.dao.SystemProductDAO;
import com.sms.form.LayoutForm;
import com.sms.formRows.ProductFormRow;
import com.sms.input.ChiTietHoaDonInputBean;
import com.sms.input.HoaDonInputBean;
import com.sms.input.KhachHangInputBean;
import com.sms.input.LoaiTheInputBean;
import com.sms.input.SanPhamInputBean;
import com.sms.output.DangKiWebOutputBean;
import com.sms.output.KhoHangOutBean;
import com.sms.output.SanPhamOutputBean;
import com.sms.session.KhachHangSession;
@Controller
public class ThanhToanTrangChuController {
	
	public static final String PAGE_CART = "gioHangTrangChu";
	
	@RequestMapping(value = "/trangChu/thanhToan/{list}")
	public String thanhToan(@ModelAttribute("LayoutForm") LayoutForm form,
			@PathVariable("list") String listId, HttpSession session) {
		giohang(form, "", listId);
		// 
		int cnt = 0;
		String[] parts = null;
		// remove ","
		if (!"".equals(listId)) {
			listId = listId.substring(1);
			parts = listId.split(",");
			listId = "";
			for (int i = 0; i < parts.length; i++) {
				if (i < parts.length - 1) {
					listId = listId + "'" + parts[i].trim() + "',";
				} else {
					listId = listId + "'" + parts[i].trim() + "'";
				}
			}
		}
		SanPhamOutputBean sanPhamOutputBean = SystemProductDAO.intances.getProductByList("", listId);
		double totalMoney = 0;
		String message = "";
		boolean check = true;
		for (SanPhamOutputRowBean sanPhamOutputRowBean : sanPhamOutputBean.getLst()) {
			String[] result = null;
			if(sanPhamOutputRowBean.getIdSanPham() !=null){
				result = sanPhamOutputRowBean.getIdSanPham().split("_");
			}
			KhoHangOutBean khoHangOutBean = KhoHangDAO.intances.getAllKhoHangBySEQ(result[0],result[1]);			
			if(khoHangOutBean != null){
					int conHang = Integer.parseInt(khoHangOutBean.getSoLuong()) - getSoLuongSanPham(parts, sanPhamOutputRowBean.getSEQ()); 
					if(conHang < 0){
						message += "Sản phẩm "+sanPhamOutputRowBean.getTenSP()+" chỉ còn "+khoHangOutBean.getSoLuong()+" mặt hàng"+"\n";
						check = false; 
					}
			}

		}
		if(!check){
			form.setMessage("");
			form.setMessageErr(message);
			return PAGE_CART;
		}
		
		SanPhamOutputBean sanPhamOutputBean3;
		List<SanPhamOutputBean>  lstSanPhamOutputBean = new ArrayList<SanPhamOutputBean>();
		boolean phanLoai = false;
		for (SanPhamOutputRowBean sanPhamOutputRowBean : sanPhamOutputBean.getLst()) {
			String[] result = null;
			if(sanPhamOutputRowBean.getIdSanPham() != null){
				result = sanPhamOutputRowBean.getIdSanPham().split("_");
			}
			
			for (SanPhamOutputBean sanPhamOutputBean2 : lstSanPhamOutputBean) {
				if (sanPhamOutputBean2.getLst() != null && sanPhamOutputBean2.getLst().size() > 0) {
					
					String[] result_2 = null;
					if(sanPhamOutputBean2.getLst().get(0).getIdSanPham() != null){
						result_2 = sanPhamOutputBean2.getLst().get(0).getIdSanPham().split("_");
					}
					
					if (result_2[0].equals(result[0])) {
						sanPhamOutputBean2.getLst().add(sanPhamOutputRowBean);
						phanLoai = true;
					}
				}
			}
			//chua toi tai
			if(!phanLoai){
				sanPhamOutputBean3 = new SanPhamOutputBean();
				sanPhamOutputBean3.getLst().add(sanPhamOutputRowBean);
				lstSanPhamOutputBean.add(sanPhamOutputBean3);
			}
			
			phanLoai = false;	

		}
		// phan loai (E)
		
		
		// thanh toan (S)
		for(SanPhamOutputBean sanPhamOutputBean2 : lstSanPhamOutputBean){
			SanPhamOutputRowBean sanPhamOutputRowBean = sanPhamOutputBean2.getLst().get(0);
				String[] result = null;
				if(sanPhamOutputRowBean.getIdSanPham() !=null){
					result = sanPhamOutputRowBean.getIdSanPham().split("_");
			}
			String path = result[0];
			String seq = result[1];
			int soluongSP = 0;
			for(SanPhamOutputRowBean sanPhamOutputRowBean4: sanPhamOutputBean2.getLst()){
				
				if (sanPhamOutputRowBean.getGiaBanKM() != null && !"".equals(sanPhamOutputRowBean4.getGiaBanKM())) {
					totalMoney += Double.parseDouble(sanPhamOutputRowBean4.getGiaBanKM())* getSoLuongSanPham(parts, sanPhamOutputRowBean4.getSEQ());
				} else {
					totalMoney += Double.parseDouble(sanPhamOutputRowBean4.getGiaBan())* getSoLuongSanPham(parts, sanPhamOutputRowBean4.getSEQ());
				}	
				soluongSP += getSoLuongSanPham(parts, sanPhamOutputRowBean4.getSEQ());
			}
			
			HoaDonInputBean hoaDonInputBean = new HoaDonInputBean();
			hoaDonInputBean.setIdHoaDon("");
			hoaDonInputBean.setIdKhachHang(form.getSdtKhachHang());
			hoaDonInputBean.setPathJSP(path);
			hoaDonInputBean.setSoLuongSP(String.valueOf(soluongSP));
			// 10000 d set duoc tinh la 1 diem
			hoaDonInputBean.setTongDiemTichLuy(String.valueOf(totalMoney / 10000));
			hoaDonInputBean.setTongTien(String.valueOf(totalMoney));
			hoaDonInputBean.setNgayLap(SMSComons.getDate());
			cnt = HoaDonDAO.intances.insert(hoaDonInputBean);
			totalMoney = 0;
			//chi tiet (S)
			for(SanPhamOutputRowBean sanPhamOutputRowBean2: sanPhamOutputBean2.getLst()){
				result = null;
				if(sanPhamOutputRowBean2.getIdSanPham() !=null){
					result = sanPhamOutputRowBean2.getIdSanPham().split("_");
				}
				path = result[0];
				seq = result[1];
				SanPhamInputBean sanPhamInputBean = new SanPhamInputBean();
				sanPhamInputBean.setPathJSP(path);
				sanPhamInputBean.setSEQ(seq);
				SanPhamOutputBean sanPhamOutputBean4 = CreateTableProductDAO.intances.getProductBySEQ(sanPhamInputBean);
				SanPhamOutputRowBean sanPhamOutputRowBean3 = sanPhamOutputBean4.getLst().get(0);
					String idHoaDon = HoaDonDAO.intances.getMaxId(path);
					ChiTietHoaDonInputBean chiTietHoaDonInputBean = new ChiTietHoaDonInputBean();
					chiTietHoaDonInputBean.setPathJSP(path);
					chiTietHoaDonInputBean.setIdChiTietHoaDon("");
					chiTietHoaDonInputBean.setIdHoaDon(idHoaDon);
					chiTietHoaDonInputBean.setIdSanPham(sanPhamOutputRowBean3.getIdSanPham());//
					if (sanPhamOutputRowBean2.getGiaBanKM() != null
							&& !"".equals(sanPhamOutputRowBean2.getGiaBanKM())) {
						chiTietHoaDonInputBean.setGiaMua(sanPhamOutputRowBean2.getGiaBanKM());
					} else {
						chiTietHoaDonInputBean.setGiaMua(sanPhamOutputRowBean2.getGiaBan());
					}
					chiTietHoaDonInputBean.setLoaiSanPham(sanPhamOutputRowBean2.getTenLoaiSP());
					chiTietHoaDonInputBean
							.setSoLuongSP(String.valueOf(getSoLuongSanPham(parts, sanPhamOutputRowBean2.getSEQ())));
					if (sanPhamOutputRowBean2.getGiaBanKM() != null
							&& !"".equals(sanPhamOutputRowBean2.getGiaBanKM())) {
						chiTietHoaDonInputBean.setThanhTien(Double.parseDouble(sanPhamOutputRowBean2.getGiaBanKM())
								* getSoLuongSanPham(parts, sanPhamOutputRowBean2.getSEQ()) + "");
					} else {
						chiTietHoaDonInputBean.setThanhTien(Double.parseDouble(sanPhamOutputRowBean2.getGiaBan())
								* getSoLuongSanPham(parts, sanPhamOutputRowBean2.getSEQ()) + "");
					}
					cnt = ChiTietHoaDonDAO.intances.insert(chiTietHoaDonInputBean);
					// Cap nhat lai so luong san pham trong kho (S)
					KhoHangOutBean khoHangOutBean = KhoHangDAO.intances.getAllKhoHangByIdSanPham(path,
							sanPhamOutputRowBean3.getIdSanPham());
					if (khoHangOutBean != null) {
						cnt = KhoHangDAO.intances.updateKhoHang(path, khoHangOutBean.getIdSanPham(),
								(Integer.parseInt(khoHangOutBean.getSoLuong())
										- Integer.parseInt(chiTietHoaDonInputBean.getSoLuongSP())) + "");
					}
					// Cap nhat lai so luong san pham trong kho (E)
			}
			// chi tiet (S)
		}
		// thanh toan (E)
		
		// Thanh toan thanh cong
		if(cnt == 1){
			form.setMessage("Cảm ơn bạn đã mua hàng.");
			form.setMessageErr("");
		}
//		DangKiWebOutputBean output = DangKiWebDAO.intances.getDataByPathJSP(path);
		form.setSoDienThoai("01644123876");
		form.setDiaChi("120 Phạm  Văn Chiêu quận Gò Vấp");
		form.setTenCuaHang("Red shop");
		form.setPathJSP("cuahangthoitrang");
		return PAGE_CART;
	}
	
	/**
	 * 
	 * @param form
	 * @param path
	 * @param listId
	 */
		private void giohang(LayoutForm form, String path, String listId){
			//get san pham 
			String[] parts = null;
			//remove ","
			if(!"".equals(listId)){
				listId = listId.substring(1);
				parts = listId.split(",");
				listId = "";
				for(int i = 0;i<parts.length;i++){
					if(i < parts.length - 1 ){
						listId = listId + "'"+parts[i]+ "',";
					}else{
						listId = listId + "'"+parts[i]+ "'";
					}
				}
			}
			SanPhamOutputBean sanPhamOutputBean = SystemProductDAO.intances.getProductByList("", listId);
			ProductFormRow productFormRow;
			double totalMoney = 0;
			double tongDonHang = 0;
			for(SanPhamOutputRowBean sanPhamOutputRowBean : sanPhamOutputBean.getLst() ){
				productFormRow = new ProductFormRow();
				productFormRow.setSEQ(sanPhamOutputRowBean.getSEQ());
				productFormRow.setIdSanPham(sanPhamOutputRowBean.getIdSanPham());
				productFormRow.setTenSP(sanPhamOutputRowBean.getTenSP());
				productFormRow.setTenLoaiSP(sanPhamOutputRowBean.getTenLoaiSP());
				productFormRow.setGiaMua(sanPhamOutputRowBean.getGiaMua());
				productFormRow.setGiaBan(sanPhamOutputRowBean.getGiaBan());
				productFormRow.setGiaBanKM(sanPhamOutputRowBean.getGiaBanKM());
				productFormRow.setNgayTao(sanPhamOutputRowBean.getNgayTao());
				productFormRow.setNgayChinhSua(sanPhamOutputRowBean.getNgayChinhSua());
				productFormRow.setMoTa(sanPhamOutputRowBean.getMoTa());
				productFormRow.setSoLuong(getSoLuongSanPham(parts, sanPhamOutputRowBean.getSEQ()) + "");
				if (sanPhamOutputRowBean.getGiaBanKM() != null && !"".equals(sanPhamOutputRowBean.getGiaBanKM())) {
					productFormRow.setThanhTien( Double.parseDouble(sanPhamOutputRowBean.getGiaBanKM()) * getSoLuongSanPham(parts, sanPhamOutputRowBean.getSEQ()) +"");
					totalMoney += Double.parseDouble(sanPhamOutputRowBean.getGiaBanKM())* getSoLuongSanPham(parts, sanPhamOutputRowBean.getSEQ() );
				} else {
					productFormRow.setThanhTien( Double.parseDouble(sanPhamOutputRowBean.getGiaBan()) * getSoLuongSanPham(parts, sanPhamOutputRowBean.getSEQ()) +"");
					totalMoney += Double.parseDouble(sanPhamOutputRowBean.getGiaBan())* getSoLuongSanPham(parts, sanPhamOutputRowBean.getSEQ()  );
				}
				tongDonHang += Double.parseDouble(sanPhamOutputRowBean.getGiaBan())* getSoLuongSanPham(parts, sanPhamOutputRowBean.getSEQ()  );
				form.getProducts().add(productFormRow);
			}
				form.setTongDonHang(tongDonHang +"");
				form.setTongThanhTien(totalMoney +"");
				form.setTongTienGiamGia( tongDonHang - totalMoney +"");
//				form.setPathJSP(path);
				form.setListId(listId);
		}
	
	
	/**
	 * 
	 * @param part
	 * @param SEQ
	 * @return
	 */
	private int getSoLuongSanPham(String part[], String SEQ){
		int cnt = 0;
		for(int i = 0; i < part.length;i++){
			if(part[i].trim().equals(SEQ)){
				cnt++;
			}
		}
		return cnt;
		
	}
}
