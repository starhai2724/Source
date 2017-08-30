package com.sms.dao;

import java.io.IOException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.sms.OutputRows.ThongkeTheoKhachHangOutputRowBean;
import com.sms.OutputRows.ThongkeTheoSanPhamOutputRowBean;
import com.sms.common.SMSComons;
import com.sms.dao.common.HibernateUtil;
import com.sms.input.ThongKeInputBean;
import com.sms.output.ThongkeOutputBean;

public class ThongKeDAO {

	public static ThongKeDAO intances = new ThongKeDAO();
	
	/**
	 * Thong ke theo san pham
	 * 
	 * @return
	 * @throws IOException 
	 */
	public ThongkeOutputBean getSanPhamByThoiGian(ThongKeInputBean inputBean) {
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQLSanPhamByThoiGian(inputBean.getPathJSP());
		ThongkeOutputBean outputBean = new ThongkeOutputBean();
		ThongkeTheoSanPhamOutputRowBean outputRowBean = null;
		try {
			session.getTransaction().begin();
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, inputBean.getNgayBatDau());
			query.setParameter(1, inputBean.getNgayKetThuc());
			List<Object[]> data = query.list();
			for (Object[] object : data) {
				outputRowBean = new ThongkeTheoSanPhamOutputRowBean();
				outputRowBean.setSEQ(SMSComons.convertString(object[0]));
				outputRowBean.setIdSanPham(SMSComons.convertString(object[1]));
				outputRowBean.setTenSP(SMSComons.convertString(object[2]));
				outputRowBean.setTenLoaiSP(SMSComons.convertString(object[3]));
				outputRowBean.setGiaMua(SMSComons.convertString(object[4]));
				outputRowBean.setSoLuong(SMSComons.convertString(object[5]));
				outputRowBean.setGiaMua(SMSComons.convertString(object[6]));
				outputRowBean.setThanhTien(SMSComons.convertString(object[7]));
				outputBean.getLst().add(outputRowBean);
			}
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
		}
		return outputBean;
	}
	
	/**
	 * Thong ke theo san pham
	 * 
	 * @return
	 * @throws IOException 
	 */
	public ThongkeOutputBean getSanPham(ThongKeInputBean inputBean) {
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQLSanPham(inputBean.getPathJSP());
		ThongkeOutputBean outputBean = new ThongkeOutputBean();
		ThongkeTheoSanPhamOutputRowBean outputRowBean = null;
		try {
			session.getTransaction().begin();
			SQLQuery query = session.createSQLQuery(hql);
			List<Object[]> data = query.list();
			for (Object[] object : data) {
				outputRowBean = new ThongkeTheoSanPhamOutputRowBean();
				outputRowBean.setSEQ(SMSComons.convertString(object[0]));
				outputRowBean.setIdSanPham(SMSComons.convertString(object[1]));
				outputRowBean.setTenSP(SMSComons.convertString(object[2]));
				outputRowBean.setTenLoaiSP(SMSComons.convertString(object[3]));
				outputRowBean.setGiaMua(SMSComons.convertString(object[4]));
				outputRowBean.setSoLuong(SMSComons.convertString(object[5]));
				outputRowBean.setGiaMua(SMSComons.convertString(object[6]));
				outputRowBean.setThanhTien(SMSComons.convertString(object[7]));
				outputBean.getLst().add(outputRowBean);
			}
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
		}
		return outputBean;
	}
	
	
	/**
	 * Thong ke theo khach hang
	 * 
	 * @return
	 * @throws IOException 
	 */
	public ThongkeOutputBean getKhachHang(ThongKeInputBean inputBean) {
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQLKhachHang(inputBean);
		ThongkeOutputBean outputBean = new ThongkeOutputBean();
		ThongkeTheoKhachHangOutputRowBean outputRowBean = null;
		try {
			session.getTransaction().begin();
			SQLQuery query = session.createSQLQuery(hql);
			List<Object[]> data = query.list();
			for (Object[] object : data) {
				outputRowBean = new ThongkeTheoKhachHangOutputRowBean();
				outputRowBean.setIdKhachHang(SMSComons.convertString(object[0]));
				outputRowBean.setTenKhachHang(SMSComons.convertString(object[1]));
				outputRowBean.setDiemTichLuy(SMSComons.convertString(object[2]));
				outputRowBean.setSDT(SMSComons.convertString(object[3]));
				outputRowBean.setDiaChi(SMSComons.convertString(object[4]));
				outputRowBean.setSL(SMSComons.convertString(object[5]));
				outputRowBean.setTongTien(SMSComons.convertString(object[6]));
				outputBean.getThongkeTheoKhachHangOutputRowBeans().add(outputRowBean);
			}
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
		}
		return outputBean;
	}
	/**
	 * Thong ke theo khach hang
	 * 
	 * @return
	 * @throws IOException 
	 */
	public ThongkeOutputBean getKhachHangTheoThoiGian(ThongKeInputBean inputBean) {
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQLKhachHang(inputBean);
		ThongkeOutputBean outputBean = new ThongkeOutputBean();
		ThongkeTheoKhachHangOutputRowBean outputRowBean = null;
		try {
			session.getTransaction().begin();
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, inputBean.getNgayBatDau());
			query.setParameter(1, inputBean.getNgayKetThuc());
			List<Object[]> data = query.list();
			for (Object[] object : data) {
				outputRowBean = new ThongkeTheoKhachHangOutputRowBean();
				outputRowBean.setIdKhachHang(SMSComons.convertString(object[0]));
				outputRowBean.setTenKhachHang(SMSComons.convertString(object[1]));
				outputRowBean.setDiemTichLuy(SMSComons.convertString(object[2]));
				outputRowBean.setSDT(SMSComons.convertString(object[3]));
				outputRowBean.setDiaChi(SMSComons.convertString(object[4]));
				outputRowBean.setSL(SMSComons.convertString(object[5]));
				outputRowBean.setTongTien(SMSComons.convertString(object[6]));
				outputBean.getThongkeTheoKhachHangOutputRowBeans().add(outputRowBean);
			}
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
		}
		return outputBean;
	}
	
	/**
	 * getSQlMaxIdStoreOwner
	 * @return
	 */
	private String getSQLSanPhamByThoiGian(String pathJSP) {
		String tableName = pathJSP+"_chi_tiet_hoa_don";
		StringBuffer sb = new StringBuffer();                                   
		sb.append(" 		SELECT                                                                          ");
		sb.append(" 		product.SEQ,                                                                    ");
		sb.append(" 		product.ID_SP,                                                                  ");
		sb.append(" 		product.TEN_SP,                                                                 ");
		sb.append(" 		lsp.TEN_LOAI_SP,                                                                ");
		sb.append(" 		product.GIA_MUA,                                                                ");
		sb.append(" 		SUM(CTHD.SO_LUONG) AS SL,                                                        ");
		sb.append(" 		CTHD.GIA_MUA AS GIA_BAN,                                                        ");
		sb.append(" 		SUM(THANH_TIEN) AS THANH_TIEN                                                        ");
		sb.append(" 	FROM                                                                                ");
		sb.append(" 		"+tableName+" CTHD                                          ");
		sb.append(" 	INNER JOIN "+pathJSP+"_hoadon HD ON CTHD.ID_HOADON = HD.ID_HOADON              ");
		sb.append(" 	LEFT JOIN "+pathJSP+"_product product ON product.ID_SP = CTHD.ID_SP            ");
		sb.append(" 	LEFT JOIN "+pathJSP+"_loai_sp lsp ON lsp.ID_LOAI_SP = product.ID_LOAI_SP       ");
		sb.append(" 	WHERE                                                                               ");
		sb.append(" 		HD.NGAY_LAP >= ?                                                       ");
		sb.append(" 	AND HD.NGAY_LAP <= ?                                                       ");
		sb.append(" 	GROUP BY                                                                            ");
		sb.append(" 		CTHD.ID_SP                                                                      ");
		sb.append(" 	ORDER BY                                                                            ");
		sb.append(" 		SL DESC							 ");
		return sb.toString();
	}
	/**
	 * getSQlMaxIdStoreOwner
	 * @return
	 */
	private String getSQLSanPham(String pathJSP) {
		String tableName = pathJSP+"_chi_tiet_hoa_don";
		StringBuffer sb = new StringBuffer();                                   
		sb.append(" 		SELECT                                                                          ");
		sb.append(" 		product.SEQ,                                                                    ");
		sb.append(" 		product.ID_SP,                                                                  ");
		sb.append(" 		product.TEN_SP,                                                                 ");
		sb.append(" 		lsp.TEN_LOAI_SP,                                                                ");
		sb.append(" 		product.GIA_MUA,                                                                ");
		sb.append(" 		SUM(CTHD.SO_LUONG) AS SL,                                                       ");
		sb.append(" 		CTHD.GIA_MUA AS GIA_BAN ,                                                       ");
		sb.append(" 		SUM(THANH_TIEN) AS THANH_TIEN                                                        ");
		sb.append(" 	FROM                                                                                ");
		sb.append(" 		"+tableName+" CTHD                                          ");
		sb.append(" 	INNER JOIN "+pathJSP+"_hoadon HD ON CTHD.ID_HOADON = HD.ID_HOADON              ");
		sb.append(" 	LEFT JOIN "+pathJSP+"_product product ON product.ID_SP = CTHD.ID_SP            ");
		sb.append(" 	LEFT JOIN "+pathJSP+"_loai_sp lsp ON lsp.ID_LOAI_SP = product.ID_LOAI_SP       ");
		sb.append(" 	GROUP BY                                                                            ");
		sb.append(" 		CTHD.ID_SP                                                                      ");
		sb.append(" 	ORDER BY                                                                            ");
		sb.append(" 		SL DESC							 ");
		return sb.toString();
	}
	
	
	private String getSQLKhachHang(ThongKeInputBean inputBean){
		String tableName = inputBean.getPathJSP()+"_hoadon";
		StringBuffer sb = new StringBuffer();  
		sb.append(" 		SELECT                                                       ");
		sb.append(" 		IFNULL(KHACH_HANG.ID_KHACHHANG, HD.ID_KHACHHANG) AS ID,      ");
		sb.append(" 		KHACH_HANG.TEN_KHACHHANG,                                    ");
		sb.append(" 		KHACH_HANG.DIEM_TICH_LUY,                                    ");
		sb.append(" 		KHACH_HANG.SDT,                                              ");
		sb.append(" 		KHACH_HANG.DIA_CHI,                                          ");
		sb.append(" 		SUM(HD.SO_LUONG_SP) AS SO_LUONG,                             ");
		sb.append(" 		SUM(HD.TONG_TIEN) AS TONG_TIEN                               ");
		sb.append(" 	FROM                                                             ");
		sb.append(" 		"+tableName+" HD                                   ");
		sb.append(" 	LEFT JOIN "+inputBean.getPathJSP()+"_khach_hang KHACH_HANG                    ");
		sb.append(" 	ON KHACH_HANG.ID_KHACHHANG = HD.ID_KHACHHANG                     ");
		sb.append(" 	OR KHACH_HANG.SDT = HD.ID_KHACHHANG                              ");
		sb.append(" 	GROUP BY                                                         ");
		sb.append(" 		HD.ID_KHACHHANG                                              ");
		sb.append(" 	ORDER BY                                                         ");
		sb.append(" 		TONG_TIEN DESC                                               ");
		return sb.toString();
	}
	
	private String getSQLKhachHangTheoThoiGian(ThongKeInputBean inputBean){
		String tableName = inputBean.getPathJSP()+"_hoadon";
		StringBuffer sb = new StringBuffer();  
		sb.append(" 		SELECT                                                       ");
		sb.append(" 		IFNULL(KHACH_HANG.ID_KHACHHANG, HD.ID_KHACHHANG) AS ID,      ");
		sb.append(" 		KHACH_HANG.TEN_KHACHHANG,                                    ");
		sb.append(" 		KHACH_HANG.DIEM_TICH_LUY,                                    ");
		sb.append(" 		KHACH_HANG.SDT,                                              ");
		sb.append(" 		KHACH_HANG.DIA_CHI,                                          ");
		sb.append(" 		SUM(HD.SO_LUONG_SP) AS SO_LUONG,                             ");
		sb.append(" 		SUM(HD.TONG_TIEN) AS TONG_TIEN                               ");
		sb.append(" 	FROM                                                             ");
		sb.append(" 		"+tableName+" HD                                   ");
		sb.append(" 	LEFT JOIN "+inputBean.getPathJSP()+"_khach_hang KHACH_HANG                    ");
		sb.append(" 	ON KHACH_HANG.ID_KHACHHANG = HD.ID_KHACHHANG                     ");
		sb.append(" 	OR KHACH_HANG.SDT = HD.ID_KHACHHANG                              ");
		sb.append(" 	WHERE                                                            ");
		sb.append(" 		HD.NGAY_LAP >= ?                                    ");
		sb.append(" 	AND HD.NGAY_LAP <= ?                                    ");
		sb.append(" 	GROUP BY                                                         ");
		sb.append(" 		HD.ID_KHACHHANG                                              ");
		sb.append(" 	ORDER BY                                                         ");
		sb.append(" 		TONG_TIEN DESC                                               ");
		return sb.toString();
	}
}
