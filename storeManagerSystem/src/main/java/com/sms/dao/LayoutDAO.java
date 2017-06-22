package com.sms.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.sms.common.SMSComons;
import com.sms.dao.common.HibernateUtil;

public class LayoutDAO {

	public static LayoutDAO intances = new LayoutDAO();
	
	public boolean checkPathJSP(String pathJSP){
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQLCheckPathJSP();
		boolean result = false;
		try {
			session.getTransaction().begin();
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, pathJSP);
			List<Object[]> data = query.list();
			for (Object object : data) {
				if(!SMSComons.isNull(object)){
					result = true;
				}
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
	
	public static void main(String[] args) {
		LayoutDAO.intances.checkPathJSP("cuahangthoitrang");
	}
}
