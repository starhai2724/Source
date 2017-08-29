package com.sms.dao;

import java.io.IOException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.sms.OutputRows.ThongkeTheoSanPhamOutputRowBean;
import com.sms.common.SMSComons;
import com.sms.dao.common.HibernateUtil;
import com.sms.input.ThongkeTheoSanPhamInputBean;
import com.sms.output.ThongkeTheoSanPhamOutputBean;

public class ThongKeDAO {

	public static ThongKeDAO intances = new ThongKeDAO();
	
	/**
	 * Thong ke theo san pham
	 * 
	 * @return
	 * @throws IOException 
	 */
	public ThongkeTheoSanPhamOutputBean getSanPhamByThoiGian(ThongkeTheoSanPhamInputBean inputBean) {
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQLSanPhamByThoiGian(inputBean.getPathJSP());
		ThongkeTheoSanPhamOutputBean outputBean = new ThongkeTheoSanPhamOutputBean();
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
	public ThongkeTheoSanPhamOutputBean getSanPham(ThongkeTheoSanPhamInputBean inputBean) {
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQLSanPham(inputBean.getPathJSP());
		ThongkeTheoSanPhamOutputBean outputBean = new ThongkeTheoSanPhamOutputBean();
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
	
}
