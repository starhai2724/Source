package com.sms.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sms.OutputRows.ChiTietHoaDonOutputRowBean;
import com.sms.OutputRows.HoaDonOutputRowBean;
import com.sms.common.SMSComons;
import com.sms.dao.common.HibernateUtil;
import com.sms.input.ChiTietHoaDonInputBean;
import com.sms.input.HoaDonInputBean;

public class ChiTietHoaDonDAO {
	
	public static ChiTietHoaDonDAO intances = new ChiTietHoaDonDAO();
	
	/**
	 * function mean create table product by pathJSP of store
	 * 
	 */
	public int createTable(String pathJSP){
		//session
		Session session = HibernateUtil.getSessionDAO();
		int cnt = 0; 
		Transaction tx = session.beginTransaction();
		//sql
		String hql = this.getSQLCreateTable(pathJSP);
		try {
			SQLQuery query = session.createSQLQuery(hql);
			cnt = query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			cnt = 1;
		} finally {
			session.close();
		}
		return cnt;
	}
	
	/**
	 * function mean detele table product by pathJSP of store
	 * 
	 */
	public int deleteTable(String pathJSP){
		//session
		Session session = HibernateUtil.getSessionDAO();
		int cnt = 0; 
		Transaction tx = session.beginTransaction();
		//sql
		String hql = this.getSQLDeleteTable(pathJSP);	
		try {
			SQLQuery query = session.createSQLQuery(hql);
			cnt = query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			cnt = 1;
		} finally {
			session.close();
		}
		return cnt;
	}
	
	
	/**
	 * function insert
	 * 
	 */
	public int insert(ChiTietHoaDonInputBean inputBean){
		//session
		Session session = HibernateUtil.getSessionDAO();
		int cnt = 0; 
		Transaction tx = session.beginTransaction();
		//id
		int id = SMSComons.convertInt(this.getMaxId(inputBean.getPathJSP()));
		//sql 
		String hql = getSQLInsert(inputBean.getPathJSP());
		try {
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, (id + 1));
			query.setParameter(1, inputBean.getIdHoaDon());
			query.setParameter(2, inputBean.getIdSanPham());
			query.setParameter(3, inputBean.getLoaiSanPham());
			query.setParameter(4, inputBean.getSoLuongSP());
			query.setParameter(5, inputBean.getGiaMua());
			query.setParameter(6, inputBean.getThanhTien());
			cnt = query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}
		return cnt;
	}
	
	/**
	 * function update 
	 * 
	 */
	public int update(ChiTietHoaDonInputBean inputBean){
		//session
		Session session = HibernateUtil.getSessionDAO();
		int cnt = 0; 
		Transaction tx = session.beginTransaction();
		//sql 
		String hql = getSQLUpdate(inputBean.getPathJSP());
		try {
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, inputBean.getIdSanPham());
			query.setParameter(1, inputBean.getLoaiSanPham());
			query.setParameter(2, inputBean.getSoLuongSP());
			query.setParameter(3, inputBean.getGiaMua());
			query.setParameter(4, inputBean.getThanhTien());
			query.setParameter(5, inputBean.getIdChiTietHoaDon());
			cnt = query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}
		return cnt;
	}
	
	
	/**
	 * function delete 
	 * 
	 */
	public int deleteById(ChiTietHoaDonInputBean inputBean){
		//session
		Session session = HibernateUtil.getSessionDAO();
		int cnt = 0; 
		Transaction tx = session.beginTransaction();
		//sql 
		String hql = getSQlDeleteById(inputBean.getPathJSP());
		try {
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, inputBean.getIdChiTietHoaDon());
			cnt = query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}
		return cnt;
	}
	
	
	/**
	 * 
	 * 
	 * @return
	 */
	private String getMaxId(String pathJSP) {
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQlMaxId(pathJSP);
		String result = "";
		try {
			Transaction tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(hql);
			List<Object> data = query.list();
			for (Object object : data) {
				result = SMSComons.convertString(object);
			}
			tx.commit();

		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
		}
		return result;
	}
	/**
	 * 
	 * 
	 * @return
	 * @throws IOException 
	 */
	public List<ChiTietHoaDonOutputRowBean> getById(ChiTietHoaDonInputBean inputBean){
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQLById(inputBean.getPathJSP());
		List<ChiTietHoaDonOutputRowBean> lst = new ArrayList<>();
		ChiTietHoaDonOutputRowBean outputRowBean;
		try {
			Transaction tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, inputBean.getIdHoaDon());
			List<Object[]> data = query.list();
			for (Object[] object : data) {
				outputRowBean = new ChiTietHoaDonOutputRowBean();
				outputRowBean.setIdChiTietHoaDon(SMSComons.convertString(object[0]));
				outputRowBean.setIdHoaDon(SMSComons.convertString(object[1]));
				outputRowBean.setIdSanPham(SMSComons.convertString(object[2]));
				outputRowBean.setLoaiSanPham(SMSComons.convertString(object[3]));
				outputRowBean.setSoLuongSP(SMSComons.convertString(object[4]));
				outputRowBean.setGiaMua(SMSComons.convertString(object[5]));
				outputRowBean.setThanhTien(SMSComons.convertString(object[6]));
				outputRowBean.setTenSanPham(SMSComons.convertString(object[7]));
				lst.add(outputRowBean);
			}
			tx.commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
		}
		return lst;
	}
	
	/**
	 * 
	 * 
	 * @return
	 * @throws IOException 
	 */
	public List<HoaDonOutputRowBean> getAll(String pathJSP) {
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQLAll(pathJSP);
		List<HoaDonOutputRowBean> lst = new ArrayList<>();
		HoaDonOutputRowBean outputRowBean;
		try {
			Transaction tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(hql);
			List<Object[]> data = query.list();
			for (Object[] object : data) {
				outputRowBean = new HoaDonOutputRowBean();
				outputRowBean.setIdHoaDon(SMSComons.convertString(object[0]));
				outputRowBean.setIdKhachHang(SMSComons.convertString(object[1]));
				outputRowBean.setNgayLap(SMSComons.convertString(object[2]));
				outputRowBean.setSoLuongSP(SMSComons.convertString(object[3]));
				outputRowBean.setDiemTichLuy(SMSComons.convertString(object[4]));
				outputRowBean.setTongDiemTichLuy(SMSComons.convertString(object[5]));
				outputRowBean.setTienKhuyenMai(SMSComons.convertString(object[6]));
				outputRowBean.setTongTien(SMSComons.convertString(object[7]));
				lst.add(outputRowBean);
			}
			tx.commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
		}
		return lst;
	}
	
	// ----------------------------------------------------------------------------------------------------------
	
	
	
	/**
	 * insert  product
	 * @return
	 */
	private String getSQLInsert(String pathJSP) {
		StringBuffer sb = new StringBuffer();
		String tableName = pathJSP+"_CHI_TIET_HOA_DON";
		sb.append("  INSERT INTO "+tableName+" (    ");
		sb.append("  		 ID_CTHD		       ");
		sb.append("  		,ID_HOADON 	           ");
		sb.append("  		,ID_SP         ");
		sb.append("  		,ID_LSP 	       ");
		sb.append("  		,SO_LUONG 	       ");
		sb.append("  		,GIA_MUA         ");
		sb.append("  		,THANH_TIEN         ");
		sb.append("  		)                  ");
		sb.append("  		VALUES (           ");
		sb.append("  		  ?                ");
		sb.append("  		 ,?                ");
		sb.append("  		 ,?                ");
		sb.append("  		 ,?                ");
		sb.append("  		 ,?                ");
		sb.append("  		 ,?                ");
		sb.append("  		 ,?                ");
		sb.append("  		)                  ");
		return sb.toString();
	}	
	
	/**
	 * update  product
	 * @return
	 */
	private String getSQLUpdate(String pathJSP) {
		StringBuffer sb = new StringBuffer();
		String tableName = pathJSP+"_CHI_TIET_HOA_DON";
		sb.append("  UPDATE  "+tableName+"     		");
		sb.append("  		SET ID_SP 	= ?	        ");
		sb.append("  		,ID_LSP 			= ?         			");
		sb.append("  		,SO_LUONG 			= ?       			");
		sb.append("  		,GIA_MUA 				= ?      	 			");
		sb.append("  		,THANH_TIEN       		= ?  			");
		sb.append("  		 WHERE ID_CTHD = ?        ");
		return sb.toString();
	}
	
	/**
	 * 
	 * @return
	 */
	private String getSQLAll(String pathJSP) {
		String tableName = pathJSP+"_CHI_TIET_HOA_DON";
		StringBuffer sb = new StringBuffer();
		sb.append("  SELECT                                 ");
		sb.append("   ID_HOADON		                            ");
		sb.append("  ,ID_KHACHHANG 	                            ");
		sb.append("  ,NGAY_LAP                            ");
		sb.append("  ,SO_LUONG_SP                            ");
		sb.append("  ,DIEM_TICH_LUY 	                            ");
		sb.append("  ,TONG_DIEM_TICH_LUY 	                            ");
		sb.append("  ,TIEN_KHUYEN_MAI                                  ");
		sb.append("  ,TONG_TIEN                                 ");
		sb.append("  FROM "+tableName+"          	");
		return sb.toString();
	}
	
	/**
	 * 
	 * @return
	 */
	private String getSQLById(String pathJSP) {
		String tableName = pathJSP+"_CHI_TIET_HOA_DON";
		String tableLoaiSanPham = pathJSP +"_LOAI_SP";
		String tableSanPham = pathJSP +"_PRODUCT";
		StringBuffer sb = new StringBuffer();
		sb.append("  SELECT                                								 ");
		sb.append("   ID_CTHD		                            							");
		sb.append("  ,ID_HOADON 	                            					");
		sb.append("  ,ID_SP                            							");
		sb.append("  ,LOAI_SP.TEN_LOAI_SP                           	 		");
		sb.append("  ,SO_LUONG 	                           					 ");
		sb.append("  ,GIA_MUA 	                            				");
		sb.append("  ,THANH_TIEN                                  			");
		sb.append("  ,SANPHAM.TEN_SP                                  			");
		sb.append("  FROM "+tableName+" CTHD         						");
		sb.append("  LEFT JOIN  "+tableLoaiSanPham+" LOAI_SP 				");
		sb.append("  ON LOAI_SP.ID_LOAI_SP = CTHD.ID_LSP          			");
		sb.append("  LEFT JOIN  "+tableSanPham+" SANPHAM 				");
		sb.append("  ON SANPHAM.ID_SP = CTHD.ID_SP          			");
		sb.append("  WHERE ID_HOADON = ?          								");
		sb.append("  GROUP BY  CTHD.ID_SP         								");
		
		return sb.toString();
	}
	
	
	/**
	 * 
	 * @return
	 */
	private String getSQlMaxId(String pathJSP) {
		String tableName = pathJSP+"_CHI_TIET_HOA_DON";
		StringBuffer sb = new StringBuffer();
		sb.append("  SELECT MAX(ID_CTHD) ");
		sb.append("  FROM "+tableName+"  ");
		return sb.toString();
	}
	
	/**
	 * getSQlDeleteById
	 * @return
	 */
	private String getSQlDeleteById(String pathJSP) {
		String tableName = pathJSP+"_CHI_TIET_HOA_DON";
		StringBuffer sb = new StringBuffer();
		sb.append("  DELETE  ");
		sb.append("  FROM "+tableName+"  ");
		sb.append("  WHERE ID_CTHD = ?  ");
		return sb.toString();
	}

	// ----------------------------------------------------------------------------------------------------------

	
	/**
	 * create table product 
	 * @return
	 */
	private String getSQLCreateTable(String pathJSP) {
		StringBuffer sb = new StringBuffer();
		String tableName = pathJSP+"_CHI_TIET_HOA_DON";
		sb.append(" CREATE TABLE "+tableName+ " (        ");
		sb.append("  ID_CTHD	INT (6)                   ");
		sb.append(" ,ID_HOADON	VARCHAR (6)               ");
		sb.append(" ,ID_SP	VARCHAR (6)                   ");
		sb.append(" ,ID_LSP	VARCHAR (6)                   ");
		sb.append(" ,SO_LUONG VARCHAR(12)                 ");
		sb.append(" ,GIA_MUA  VARCHAR(12)                    ");
		sb.append(" ,THANH_TIEN  VARCHAR(12)                    ");
		sb.append(" 	)                                ");
		return sb.toString();
	}
	
	/**
	 * delete table product
	 * @return
	 */
	private String getSQLDeleteTable(String pathJSP) {
		StringBuffer sb = new StringBuffer();
		String tableName = pathJSP+"_CHI_TIET_HOA_DON";
		sb.append("   DROP TABLE "+tableName+"            ");
		return sb.toString();
	}	
	public static void main(String[] args) {
		ChiTietHoaDonDAO cr = new ChiTietHoaDonDAO();
		cr.createTable("cuahangthoitrang");
	}
}
