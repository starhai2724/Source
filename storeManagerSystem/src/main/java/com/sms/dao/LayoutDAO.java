package com.sms.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sms.common.SMSComons;
import com.sms.dao.common.HibernateUtil;

public class LayoutDAO {

	public static LayoutDAO intances = new LayoutDAO();
	/**
	 * 
	 * @param pathJSP
	 * @return
	 */
	public boolean checkPathJSP(String pathJSP){
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQLCheckPathJSP();
		boolean result = false;
		try {
			Transaction tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, pathJSP);
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
	 * @return
	 */
	public String getPageJSP(String pathJSP){
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQLCategory();
		String result = "";
		try {
			Transaction tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, pathJSP);
			List<Object[]> data = query.list();
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
	
	private String getSQLCheckPathJSP(){
		StringBuffer sb = new StringBuffer();
			sb.append("   SELECT                  ");
			sb.append("   SI.PATHJSP              ");
			sb.append("   FROM                    ");
			sb.append("   store_info SI           ");
			sb.append("   WHERE                   ");
			sb.append("   SI.PATHJSP =  ?         ");
		return sb.toString();
	}
	
	private String getSQLCategory(){
		StringBuffer sb = new StringBuffer();                                        
		sb.append(" 	SELECT                                                            ");
		sb.append("     SC.PARAMETER_TXT                                                    ");
		sb.append(" FROM                                                                  ");
		sb.append(" 	store_info SI                                                     ");
		sb.append(" INNER JOIN system_control SC ON SC.PARAMETER_ID = SI.CATEGORY         ");
		sb.append(" WHERE                                                                 ");
		sb.append(" 	SI.PATHJSP = ?                                   ");
		return sb.toString();
	}
	
	public static void main(String[] args) {
		LayoutDAO.intances.checkPathJSP("cuahangthoitrang");
	}
}
