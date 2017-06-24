package com.sms.dao;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sms.dao.common.HibernateUtil;

public class DotKMDAO {
	
	public static DotKMDAO intances = new DotKMDAO();
	
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
	

	// ----------------------------------------------------------------------------------------------------------

	
	/**
	 * create table product 
	 * @return
	 */
	private String getSQLCreateTable(String pathJSP) {
		StringBuffer sb = new StringBuffer();
		String tableName = pathJSP+"_DOT_KM";
		sb.append(" CREATE TABLE "+tableName+ " (        ");
		sb.append("  ID_DKM	VARCHAR (6)                        ");
		sb.append(" ,ID_LOAI_KM		VARCHAR (6)                ");
		sb.append(" ,TEN_DKM 		VARCHAR(255)                  ");
		sb.append(" ,NGAY_BD 		VARCHAR(8)                    ");
		sb.append(" ,NGAY_KT 		VARCHAR(8)                    ");
		sb.append(" ,TRANG_THAI 	VARCHAR(1)                 ");
		sb.append(" 	)                                ");
		return sb.toString();
	}
	
	/**
	 * delete table product
	 * @return
	 */
	private String getSQLDeleteTable(String pathJSP) {
		StringBuffer sb = new StringBuffer();
		String tableName = pathJSP+"_DOT_KM";
		sb.append("   DROP TABLE "+tableName+"            ");
		return sb.toString();
	}	
	public static void main(String[] args) {
		DotKMDAO cr = new DotKMDAO();
	}
}
