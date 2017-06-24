package com.sms.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sms.common.SMSComons;
import com.sms.dao.common.HibernateUtil;

public class CreateTableProductDAO {
	
	public static CreateTableProductDAO intances = new CreateTableProductDAO();
	
	/**
	 * function mean create table product by pathJSP of store
	 * 
	 */
	public int createTableProduct(String pathJSP){
		//session
		Session session = HibernateUtil.getSessionDAO();
		int cnt = 0; 
		Transaction tx = session.beginTransaction();
		//sql
		String hql = this.getSQLCreateTableProduct(pathJSP);
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
	public int deleteTableProduct(String pathJSP){
		//session
		Session session = HibernateUtil.getSessionDAO();
		int cnt = 0; 
		Transaction tx = session.beginTransaction();
		//sql
		String hql = this.getSQLDeleteTableProduct(pathJSP);
		try {
			SQLQuery query = session.createSQLQuery(hql);
			cnt = query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			cnt = 0;
		} finally {
			session.close();
		}
		return cnt;
	}
	
	/**
	 * function insert
	 * 
	 */
	public int insert(String pathJSP){
		//session
		Session session = HibernateUtil.getSessionDAO();
		int cnt = 0; 
		Transaction tx = session.beginTransaction();
		//id
		int id_Sp = SMSComons.convertInt(this.getMaxId(pathJSP));
		//sql 
		String hql = getSQLInsert(pathJSP);
		
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

	// ----------------------------------------------------------------------------------------------------------
	
	/**
	 * create table product 
	 * @return
	 */
	private String getSQLCreateTableProduct(String pathJSP) {
		StringBuffer sb = new StringBuffer();
		String tableName = pathJSP+"_PRODUCT";
		sb.append("  CREATE TABLE "+tableName+" (          ");
		sb.append("  		 ID_SP	VARCHAR (6)            ");
		sb.append("  		,TEN_SP VARCHAR(255)           ");
		sb.append("  		,ID_CUAHANG VARCHAR(6)         ");
		sb.append("  		,ID_LOAI_SP VARCHAR(6)         ");
		sb.append("  		,GIA_MUA VARCHAR(12)           ");
		sb.append("  		,GIA_BAN VARCHAR(12)           ");
		sb.append("  		,TRANG_THAI VARCHAR(1)         ");
		sb.append("  		,NGAY_TAO VARCHAR(8)           ");
		sb.append("  		,NGAY_CHINH_SUA VARCHAR(8)     ");
		sb.append(")");
		return sb.toString();
	}
	
	/**
	 * delete table product
	 * @return
	 */
	private String getSQLDeleteTableProduct(String pathJSP) {
		StringBuffer sb = new StringBuffer();
		String tableName = pathJSP+"_PRODUCT";
		sb.append("   DROP TABLE "+tableName+"            ");
		return sb.toString();
	}	
	
	/**
	 * insert  product
	 * @return
	 */
	private String getSQLInsert(String pathJSP) {
		StringBuffer sb = new StringBuffer();
		String tableName = pathJSP+"_PRODUCT";
		sb.append("  INSERT INTO "+tableName+" (    ");
		sb.append("  		ID_SP		       ");
		sb.append("  		TEN_SP 	           ");
		sb.append("  		ID_CUAHANG         ");
		sb.append("  		ID_LOAI_SP         ");
		sb.append("  		GIA_MUA 	       ");
		sb.append("  		GIA_BAN 	       ");
		sb.append("  		TRANG_THAI         ");
		sb.append("  		NGAY_TAO 	       ");
		sb.append("  		NGAY_CHINH_SUA     ");
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
		sb.append("  		)                  ");
		return sb.toString();
	}	
	
	
	/**
	 * getSQlMaxIdStoreOwner
	 * @return
	 */
	private String getSQlMaxId(String pathJSP) {
		String tableName = pathJSP+"_PRODUCT";
		StringBuffer sb = new StringBuffer();
		sb.append("  SELECT MAX(ID_SP) ");
		sb.append("  FROM "+tableName+"  ");
		return sb.toString();
	}
	
	
	public static void main(String[] args) {
		CreateTableProductDAO cr = new CreateTableProductDAO();
	}
}
