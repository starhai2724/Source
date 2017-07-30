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
import com.sms.input.LienHeInputBean;
import com.sms.output.LienHeOutputBean;

public class LienHeDAO {

public static LienHeDAO intances = new LienHeDAO();
	
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
		} finally {
			session.close();
		}
		return cnt;
	}
	
	/**
	 * function insert
	 * 
	 */
	public int insert(LienHeInputBean inputBean){
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
			query.setParameter(1, inputBean.getTenKH());
			query.setParameter(2, inputBean.getDiaChi());
			query.setParameter(3, inputBean.getEmail());
			query.setParameter(4, inputBean.getSdt());
			query.setParameter(5, inputBean.getTieuDe());
			query.setParameter(6, inputBean.getNoiDungNhan());
			query.setParameter(7, inputBean.getNoiDungTraLoi());
			query.setParameter(8, inputBean.getTrangThai());
			query.setParameter(9, inputBean.getNgayNhan());
			query.setParameter(10, inputBean.getNgayTraLoi());
			query.setParameter(11, inputBean.getIdKH());
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
	public List<LienHeOutputBean> getAll(String pathJSP) {
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQLAll(pathJSP);
		List<LienHeOutputBean> lst = new ArrayList<>();
		LienHeOutputBean outputRowBean;
		try {
			Transaction tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(hql);
			List<Object[]> data = query.list();
			for (Object[] object : data) {
				outputRowBean = new LienHeOutputBean();
				outputRowBean.setIdLienHe(SMSComons.convertString(object[0]));
				outputRowBean.setTenKH(SMSComons.convertString(object[1]));
				outputRowBean.setDiaChi(SMSComons.convertString(object[2]));
				outputRowBean.setEmail(SMSComons.convertString(object[3]));
				outputRowBean.setSdt(SMSComons.convertString(object[4]));
				outputRowBean.setTieuDe(SMSComons.convertString(object[5]));
				outputRowBean.setNoiDungNhan(SMSComons.convertString(object[6]));
				outputRowBean.setNoiDungTraLoi(SMSComons.convertString(object[7]));
				outputRowBean.setTrangThai(SMSComons.convertString(object[8]));
				outputRowBean.setNgayNhan(SMSComons.convertString(object[9]));
				outputRowBean.setNgayTraLoi(SMSComons.convertString(object[10]));
				outputRowBean.setIdKH(SMSComons.convertString(object[11]));
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
	public List<LienHeOutputBean> getAllByID(String pathJSP, String id) {
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQLByID(pathJSP);
		List<LienHeOutputBean> lst = new ArrayList<>();
		LienHeOutputBean outputRowBean;
		try {
			Transaction tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, id);
			List<Object[]> data = query.list();
			for (Object[] object : data) {
				outputRowBean = new LienHeOutputBean();
				outputRowBean.setIdLienHe(SMSComons.convertString(object[0]));
				outputRowBean.setTenKH(SMSComons.convertString(object[1]));
				outputRowBean.setDiaChi(SMSComons.convertString(object[2]));
				outputRowBean.setEmail(SMSComons.convertString(object[3]));
				outputRowBean.setSdt(SMSComons.convertString(object[4]));
				outputRowBean.setTieuDe(SMSComons.convertString(object[5]));
				outputRowBean.setNoiDungNhan(SMSComons.convertString(object[6]));
				outputRowBean.setNoiDungTraLoi(SMSComons.convertString(object[7]));
				outputRowBean.setTrangThai(SMSComons.convertString(object[8]));
				outputRowBean.setNgayNhan(SMSComons.convertString(object[9]));
				outputRowBean.setNgayTraLoi(SMSComons.convertString(object[10]));
				outputRowBean.setIdKH(SMSComons.convertString(object[11]));
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
	 * function update 
	 * 
	 */
	public int update(LienHeInputBean inputBean){
		//session
		Session session = HibernateUtil.getSessionDAO();
		int cnt = 0; 
		Transaction tx = session.beginTransaction();
		//sql 
		String hql = getSQLUpdate(inputBean.getPathJSP());
		try {
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, inputBean.getNoiDungTraLoi());
			query.setParameter(1, inputBean.getTrangThai());
			query.setParameter(2, inputBean.getNgayTraLoi());
			query.setParameter(3, inputBean.getIdLienHe());
			cnt = query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}
		return cnt;
	}
	
	
//-------------------------------------------------------------------------
	/**
	 * create table product 
	 * @return
	 */
	private String getSQLCreateTable(String pathJSP) {
		StringBuffer sb = new StringBuffer();
		String tableName = pathJSP+"_LIEN_HE";
		sb.append(" CREATE TABLE "+tableName+ " (        ");
		sb.append("  ID_LIEN_HE	INT (6)           ");
		sb.append(" ,TEN_KHACHHANG	VARCHAR (255)         ");
		sb.append(" ,DIA_CHI 		VARCHAR(255)                  ");
		sb.append(" ,EMAIL 			VARCHAR(255)                     ");
		sb.append(" ,SDT 			VARCHAR(12)                     ");
		sb.append(" ,TIEU_DE 		VARCHAR(255)                     ");
		sb.append(" ,NOI_DUNG_NHAN  		TEXT                  ");
		sb.append(" ,NOI_DUNG_TRA_LOI  		TEXT                  ");
		sb.append(" ,TRANG_THAI 	VARCHAR(1)             ");
		sb.append(" ,NGAY_NHAN 		VARCHAR(8)                  ");
		sb.append(" ,NGAY_TRA_LOI 	VARCHAR(8)                  ");
		sb.append(" ,ID_KHACH_HANG 	VARCHAR(8)             ");
		sb.append(" 	)                                ");
		return sb.toString();
	}
	
	/**
	 * delete table product
	 * @return
	 */
	private String getSQLDeleteTable(String pathJSP) {
		StringBuffer sb = new StringBuffer();
		String tableName = pathJSP+"_LIEN_HE";
		sb.append("   DROP TABLE "+tableName+"            ");
		return sb.toString();
	}	
	
	/**
	 * 
	 * @return
	 */
	private String getSQlMaxId(String pathJSP) {
		String tableName = pathJSP+"_LIEN_HE";
		StringBuffer sb = new StringBuffer();
		sb.append("  SELECT MAX(ID_LIEN_HE) ");
		sb.append("  FROM "+tableName+"  ");
		return sb.toString();
	}
	
	/**
	 * insert  product
	 * @return
	 */
	private String getSQLInsert(String pathJSP) {
		StringBuffer sb = new StringBuffer();
		String tableName = pathJSP+"_LIEN_HE";
		sb.append("  INSERT INTO "+tableName+" (    ");
		sb.append("  		 ID_LIEN_HE		       ");
		sb.append("  		,TEN_KHACHHANG 	           ");
		sb.append("  		,DIA_CHI         ");
		sb.append("  		,EMAIL 	       ");
		sb.append("  		,SDT 	       ");
		sb.append("  		,TIEU_DE         ");
		sb.append("  		,NOI_DUNG_NHAN         ");
		sb.append("  		,NOI_DUNG_TRA_LOI         ");
		sb.append("  		,TRANG_THAI 	       ");
		sb.append("  		,NGAY_NHAN     ");
		sb.append("  		,NGAY_TRA_LOI     ");
		sb.append("  		,ID_KHACH_HANG     ");
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
	 * getSQlMaxIdStoreOwner
	 * @return
	 */
	private String getSQLAll(String pathJSP) {
		String tableName = pathJSP+"_LIEN_HE";
		StringBuffer sb = new StringBuffer();
		sb.append("  SELECT                                 ");
		sb.append("   ID_LIEN_HE		                            ");
		sb.append("  ,TEN_KHACHHANG 	                            ");
		sb.append("  ,DIA_CHI                            ");
		sb.append("  ,EMAIL                            ");
		sb.append("  ,SDT 	                            ");
		sb.append("  ,TIEU_DE 	                            ");
		sb.append("  ,NOI_DUNG_NHAN                                  ");
		sb.append("  ,NOI_DUNG_TRA_LOI                                 ");
		sb.append("  ,TRANG_THAI                            ");
		sb.append("  ,NGAY_NHAN                        ");
		sb.append("  ,NGAY_TRA_LOI 	                            ");
		sb.append("  ,ID_KHACH_HANG 	                            ");
		sb.append("  FROM "+tableName+"          	");
		sb.append("  ORDER BY NGAY_NHAN, NGAY_TRA_LOI   DESC         	");
		return sb.toString();
	}
	
	/**
	 * getSQlMaxIdStoreOwner
	 * @return
	 */
	private String getSQLByID(String pathJSP) {
		String tableName = pathJSP+"_LIEN_HE";
		StringBuffer sb = new StringBuffer();
		sb.append("  SELECT                                 ");
		sb.append("   ID_LIEN_HE		                            ");
		sb.append("  ,TEN_KHACHHANG 	                            ");
		sb.append("  ,DIA_CHI                            ");
		sb.append("  ,EMAIL                            ");
		sb.append("  ,SDT 	                            ");
		sb.append("  ,TIEU_DE 	                            ");
		sb.append("  ,NOI_DUNG_NHAN                                  ");
		sb.append("  ,NOI_DUNG_TRA_LOI                                 ");
		sb.append("  ,TRANG_THAI                            ");
		sb.append("  ,NGAY_NHAN                        ");
		sb.append("  ,NGAY_TRA_LOI 	                            ");
		sb.append("  ,ID_KHACH_HANG 	                            ");
		sb.append("  FROM "+tableName+"          	");
		sb.append("  WHERE ID_LIEN_HE = ?          	");
		return sb.toString();
	}
	
	/**
	 * update  product
	 * @return
	 */
	private String getSQLUpdate(String pathJSP) {
		StringBuffer sb = new StringBuffer();
		String tableName = pathJSP+"_LIEN_HE";
		sb.append("  UPDATE  "+tableName+"     		");
		sb.append("  		SET NOI_DUNG_TRA_LOI 	= ?	        ");
		sb.append("  		,TRANG_THAI 			= ?         			");
		sb.append("  		,NGAY_TRA_LOI 			= ?       			");
		sb.append("  		 WHERE ID_LIEN_HE = ?        ");
		return sb.toString();
	}
	
	public static void main(String[] args) {
//		LienHeDAO.intances.createTable("cuahangthoitrang");
		
	}
}
