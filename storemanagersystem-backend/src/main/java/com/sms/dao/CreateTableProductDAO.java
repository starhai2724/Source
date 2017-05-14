package com.sms.dao;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
		Transaction tx = HibernateUtil.getSessionDAO().beginTransaction();
		//sql
		String hql = this.getSQLCreateTableProduct(pathJSP);
		try {
			SQLQuery query = session.createSQLQuery(hql);
			cnt = query.executeUpdate();
			tx.commit();
		} catch (HibernateException e) {
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
		Transaction tx = HibernateUtil.getSessionDAO().beginTransaction();
		//sql
		String hql = this.getSQLDeleteTableProduct(pathJSP);
		try {
			SQLQuery query = session.createSQLQuery(hql);
			cnt = query.executeUpdate();
			tx.commit();
		} catch (HibernateException e) {
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
	private String getSQLCreateTableProduct(String pathJSP) {
		StringBuffer sb = new StringBuffer();
		String tableName = pathJSP+"_PRODUCT";
		sb.append("   CREATE TABLE "+tableName+" (             ");
		sb.append("   		  PRODUCT_ID VARCHAR(6),                      ");
		sb.append("   		  PRODUCT_NAME VARCHAR(6),                    ");
		sb.append("   			DATE_OF_APPLY VARCHAR(6),                 ");
		sb.append("   			DESCRIPTION VARCHAR(6),                   ");
		sb.append("   			WARRANTY_TIME VARCHAR(6),                 ");
		sb.append("   			IMAGE VARCHAR(6),                         ");
		sb.append("   			CATEGORY VARCHAR(6),                      ");
		sb.append("   			SALE_PRICE VARCHAR(6),                    ");
		sb.append("   			TAX_SALE_PRICE VARCHAR(6),                ");
		sb.append("   			SALE_PRICE_NOT_TAX VARCHAR(6),            ");
		sb.append("   			PURCHASE_PRICE VARCHAR(6),                ");
		sb.append("   			PURCHASE_PRICE_TAX VARCHAR(6),            ");
		sb.append("   			PURCHASE_PRICE_NOT_TAX VARCHAR(6),        ");
		sb.append("   			DELETE_FLAG VARCHAR(1)                    ");
		sb.append("   		)                                            ");
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
	public static void main(String[] args) {
		CreateTableProductDAO cr = new CreateTableProductDAO();
	}
}
