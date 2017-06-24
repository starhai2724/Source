package com.sms.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sms.OutputRows.KhachHangOutputRowBean;
import com.sms.common.SMSComons;
import com.sms.dao.common.HibernateUtil;
import com.sms.input.KhachHangInputBean;
import com.sms.output.TaiKhoanKhachHangOutputBean;

public class KhachHangDAO {
	
	public static KhachHangDAO intances = new KhachHangDAO();
	
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
		} finally {
			session.close();
		}
		return cnt;
	}
	
	/**
	 * function insert
	 * 
	 */
	public int insert(KhachHangInputBean inputBean){
		//session
		Session session = HibernateUtil.getSessionDAO();
		int cnt = 0; 
		Transaction tx = session.beginTransaction();
		//id
		int idKhachHang = SMSComons.convertInt(this.getMaxId(inputBean.getPathJSP()));
		//sql 
		String hql = getSQLInsert(inputBean.getPathJSP());
		try {
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, (idKhachHang + 1));
			query.setParameter(1, inputBean.getTenKhachHang());
			query.setParameter(2, inputBean.getLoaiThe());
			query.setParameter(3, inputBean.getGioiTinh());
			query.setParameter(4, inputBean.getSoDienThoai());
			query.setParameter(5, inputBean.getDiaChi());
			query.setParameter(6, inputBean.getSoDiem());
			query.setParameter(7, inputBean.getNgaySinh());
			query.setParameter(8, inputBean.getNgayTao());
			query.setParameter(9, inputBean.getNgaySua());
			query.setParameter(10, '0');
			query.setParameter(11, "1234");
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
	public int update(KhachHangInputBean inputBean){
		//session
		Session session = HibernateUtil.getSessionDAO();
		int cnt = 0; 
		Transaction tx = session.beginTransaction();
		//sql 
		String hql = getSQLUpdate(inputBean.getPathJSP());
		try {
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, inputBean.getTenKhachHang());
			query.setParameter(1, inputBean.getLoaiThe());
			query.setParameter(2, inputBean.getGioiTinh());
			query.setParameter(3, inputBean.getSoDienThoai());
			query.setParameter(4, inputBean.getDiaChi());
			query.setParameter(5, inputBean.getSoDiem());
			query.setParameter(6, inputBean.getNgaySinh());
			query.setParameter(7, inputBean.getNgaySua());
			query.setParameter(8, inputBean.getIdKhachHang());
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
	public int deleteById(KhachHangInputBean inputBean){
		//session
		Session session = HibernateUtil.getSessionDAO();
		int cnt = 0; 
		Transaction tx = session.beginTransaction();
		//sql 
		String hql = getSQlDeleteById(inputBean.getPathJSP());
		try {
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, inputBean.getIdKhachHang());
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
	public List<KhachHangOutputRowBean> getById(KhachHangInputBean inputBean){
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQLById(inputBean.getPathJSP());
		List<KhachHangOutputRowBean> lst = new ArrayList<>();
		KhachHangOutputRowBean outputRowBean;
		try {
			Transaction tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, inputBean.getIdKhachHang());
			List<Object[]> data = query.list();
			for (Object[] object : data) {
				outputRowBean = new KhachHangOutputRowBean();
				outputRowBean.setIdKhachHang(SMSComons.convertString(object[0]));
				outputRowBean.setTenKhachHang(SMSComons.convertString(object[1]));
				outputRowBean.setLoaiThe(SMSComons.convertString(object[2]));
				outputRowBean.setGioiTinh(SMSComons.convertString(object[3]));
				outputRowBean.setSoDienThoai(SMSComons.convertString(object[4]));
				outputRowBean.setDiaChi(SMSComons.convertString(object[5]));
				outputRowBean.setSoDiem(SMSComons.convertString(object[6]));
				outputRowBean.setNgaySinh(SMSComons.convertString(object[7]));
				outputRowBean.setNgayTao(SMSComons.convertString(object[8]));
				outputRowBean.setNgaySua(SMSComons.convertString(object[9]));
				outputRowBean.setTrangThai(SMSComons.convertString(object[10]));
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
	public List<KhachHangOutputRowBean> getAll(String pathJSP) {
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQLAll(pathJSP);
		List<KhachHangOutputRowBean> lst = new ArrayList<>();
		KhachHangOutputRowBean outputRowBean;
		try {
			Transaction tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(hql);
			List<Object[]> data = query.list();
			for (Object[] object : data) {
				outputRowBean = new KhachHangOutputRowBean();
				outputRowBean.setIdKhachHang(SMSComons.convertString(object[0]));
				outputRowBean.setTenKhachHang(SMSComons.convertString(object[1]));
				outputRowBean.setLoaiThe(SMSComons.convertString(object[2]));
				outputRowBean.setGioiTinh(SMSComons.convertString(object[3]));
				outputRowBean.setSoDienThoai(SMSComons.convertString(object[4]));
				outputRowBean.setDiaChi(SMSComons.convertString(object[5]));
				outputRowBean.setSoDiem(SMSComons.convertString(object[6]));
				outputRowBean.setNgaySinh(SMSComons.convertString(object[7]));
				outputRowBean.setNgayTao(SMSComons.convertString(object[8]));
				outputRowBean.setNgaySua(SMSComons.convertString(object[9]));
				outputRowBean.setTrangThai(SMSComons.convertString(object[10]));
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
	 * @param pathJSP
	 * @param sdt
	 * @return
	 */
	public boolean checkExistSDT(String pathJSP, String sdt){
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQLCheckExistSDT(pathJSP);
		boolean result = false;
		try {
			Transaction tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, sdt);
			List<Object[]> data = query.list();
			for (Object object : data) {
				if(!SMSComons.isNull(object)){
					result = true;
				}
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
	 * @param pathJSP
	 * @param sdt
	 * @return
	 */
	public TaiKhoanKhachHangOutputBean checkLogin(String pathJSP, String sdt, String matKhau){
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQLCheckLogin(pathJSP);
		TaiKhoanKhachHangOutputBean outputBean = null;
		Transaction tx = session.beginTransaction();
		try {
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, sdt);
			query.setParameter(1, matKhau);
			List<Object[]> data = query.list();
			for (Object[] object : data) {
				outputBean = new TaiKhoanKhachHangOutputBean();
				outputBean.setIdKhachHang(SMSComons.convertString(object[0]));
				outputBean.setTenKhachHang(SMSComons.convertString(object[1]));
				outputBean.setSdt(SMSComons.convertString(object[2]));
			}
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
		} finally {
			session.flush();
			session.clear();
			session.close();
		}
		return outputBean;
	}
	// ----------------------------------------------------------------------------------------------------------
	
	
	
	/**
	 * insert  product
	 * @return
	 */
	private String getSQLInsert(String pathJSP) {
		StringBuffer sb = new StringBuffer();
		String tableName = pathJSP+"_KHACH_HANG";
		sb.append("  INSERT INTO "+tableName+" (    ");
		sb.append("  		 ID_KHACHHANG		       ");
		sb.append("  		,TEN_KHACHHANG 	           ");
		sb.append("  		,LOAI_THE         ");
		sb.append("  		,GIOI_TINH 	       ");
		sb.append("  		,SDT 	       ");
		sb.append("  		,DIA_CHI         ");
		sb.append("  		,DIEM_TICH_LUY         ");
		sb.append("  		,NGAY_SINH         ");
		sb.append("  		,NGAY_TAO 	       ");
		sb.append("  		,NGAY_CHINHSUA     ");
		sb.append("  		,TRANG_THAI     ");
		sb.append("  		,MAT_KHAU     ");
		sb.append("  		)                  ");
		sb.append("  		VALUES (           ");
		sb.append("  		  ?                ");
		sb.append("  		 ,?                ");
		sb.append("  		 ,?                ");
		sb.append("  		 ,?                ");
		sb.append("  		 ,?                ");
		sb.append("  		 ,?                ");
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
		String tableName = pathJSP+"_KHACH_HANG";
		sb.append("  UPDATE  "+tableName+"     		");
		sb.append("  		SET TEN_KHACHHANG 	= ?	        ");
		sb.append("  		,LOAI_THE 			= ?         			");
		sb.append("  		,GIOI_TINH 			= ?       			");
		sb.append("  		,SDT 				= ?      	 			");
		sb.append("  		,DIA_CHI       		= ?  			");
		sb.append("  		,DIEM_TICH_LUY      = ?   		");
		sb.append("  		,NGAY_SINH  		= ?   				");
		sb.append("  		,NGAY_CHINHSUA  	= ?   	");
		sb.append("  		 WHERE ID_KHACHHANG = ?        ");
		sb.append("  		 AND TRANG_THAI 	= '0'   ");
		return sb.toString();
	}
	
	/**
	 * getSQlMaxIdStoreOwner
	 * @return
	 */
	private String getSQLAll(String pathJSP) {
		String tableName = pathJSP+"_KHACH_HANG";
		StringBuffer sb = new StringBuffer();
		sb.append("  SELECT                                 ");
		sb.append("   ID_KHACHHANG		                            ");
		sb.append("  ,TEN_KHACHHANG 	                            ");
		sb.append("  ,LOAI_THE                            ");
		sb.append("  ,GIOI_TINH                            ");
		sb.append("  ,SDT 	                            ");
		sb.append("  ,DIA_CHI 	                            ");
		sb.append("  ,DIEM_TICH_LUY                                  ");
		sb.append("  ,NGAY_SINH                                 ");
		sb.append("  ,NGAY_TAO                            ");
		sb.append("  ,NGAY_CHINHSUA 	                            ");
		sb.append("  ,TRANG_THAI                        ");
		sb.append("  FROM "+tableName+"          	");
		return sb.toString();
	}
	
	/**
	 * getSQlMaxIdStoreOwner
	 * @return
	 */
	private String getSQLById(String pathJSP) {
		String tableName = pathJSP+"_KHACH_HANG";
		StringBuffer sb = new StringBuffer();
		sb.append("  SELECT                                 ");
		sb.append("   ID_KHACHHANG		                            ");
		sb.append("  ,TEN_KHACHHANG 	                            ");
		sb.append("  ,LOAI_THE                            ");
		sb.append("  ,GIOI_TINH                            ");
		sb.append("  ,SDT 	                            ");
		sb.append("  ,DIA_CHI 	                            ");
		sb.append("  ,DIEM_TICH_LUY                                  ");
		sb.append("  ,NGAY_SINH                                 ");
		sb.append("  ,NGAY_TAO                            ");
		sb.append("  ,NGAY_CHINHSUA 	                            ");
		sb.append("  ,TRANG_THAI                        ");
		sb.append("  FROM "+tableName+"          			");
		sb.append("  WHERE ID_KHACHHANG = ?          			");
		return sb.toString();
	}
	
	
	/**
	 * 
	 * @return
	 */
	private String getSQlMaxId(String pathJSP) {
		String tableName = pathJSP+"_KHACH_HANG";
		StringBuffer sb = new StringBuffer();
		sb.append("  SELECT MAX(ID_KHACHHANG) ");
		sb.append("  FROM "+tableName+"  ");
		return sb.toString();
	}
	
	/**
	 * getSQlDeleteById
	 * @return
	 */
	private String getSQlDeleteById(String pathJSP) {
		String tableName = pathJSP+"_KHACH_HANG";
		StringBuffer sb = new StringBuffer();
		sb.append("  DELETE  ");
		sb.append("  FROM "+tableName+"  ");
		sb.append("  WHERE ID_KHACHHANG = ?  ");
		return sb.toString();
	}
	
	/**
	 * getSQLCheckExistSDT
	 * @return
	 */
	private String getSQLCheckExistSDT(String pathJSP) {
		String tableName = pathJSP+"_KHACH_HANG";
		StringBuffer sb = new StringBuffer();
		sb.append("  SELECT  SDT ");
		sb.append("  FROM "+tableName+"  ");
		sb.append("  WHERE SDT = ?  ");
		return sb.toString();
	}
	
	/**
	 * getSQLCheckExistSDT
	 * @return
	 */
	private String getSQLCheckLogin(String pathJSP) {
		String tableName = pathJSP+"_KHACH_HANG";
		StringBuffer sb = new StringBuffer();
		sb.append("  SELECT  ID_KHACHHANG ");
		sb.append("    		,TEN_KHACHHANG");
		sb.append("    		,SDT ");
		sb.append("  FROM "+tableName+"  ");
		sb.append("  WHERE SDT = ?  ");
		sb.append("  AND MAT_KHAU = ?  ");
		return sb.toString();
	}
	
	// ----------------------------------------------------------------------------------------------------------

	
	/**
	 * create table product 
	 * @return
	 */
	private String getSQLCreateTable(String pathJSP) {
		StringBuffer sb = new StringBuffer();
		String tableName = pathJSP+"_KHACH_HANG";
		sb.append(" CREATE TABLE "+tableName+ " (        ");
		sb.append("  ID_KHACHHANG	VARCHAR (6)           ");
		sb.append(" ,TEN_KHACHHANG	VARCHAR (255)         ");
		sb.append(" ,LOAI_THE 		VARCHAR(6)                  ");
		sb.append(" ,GIOI_TINH 		VARCHAR(12)                     ");
		sb.append(" ,SDT 			VARCHAR(12)                     ");
		sb.append(" ,MAT_KHAU 		VARCHAR(12)                     ");
		sb.append(" ,DIA_CHI  		VARCHAR(255)                  ");
		sb.append(" ,DIEM_TICH_LUY 	VARCHAR(8)             ");
		sb.append(" ,NAM_SINH 		VARCHAR(8)                  ");
		sb.append(" ,NGAY_TAO 		VARCHAR(8)                  ");
		sb.append(" ,NGAY_CHINHSUA 	VARCHAR(8)             ");
		sb.append(" ,TRANG_THAI 	VARCHAR(1)                ");
		sb.append(" 	)                                ");
		return sb.toString();
	}
	
	/**
	 * delete table product
	 * @return
	 */
	private String getSQLDeleteTable(String pathJSP) {
		StringBuffer sb = new StringBuffer();
		String tableName = pathJSP+"_KHACH_HANG";
		sb.append("   DROP TABLE "+tableName+"            ");
		return sb.toString();
	}	
	public static void main(String[] args) {
		KhachHangDAO cr = new KhachHangDAO();
		KhachHangInputBean inputBean = new KhachHangInputBean();
		inputBean.setIdKhachHang("100017");
		inputBean.setPathJSP("cuahangthoitrang");
		cr.deleteById(inputBean);
	}
}
