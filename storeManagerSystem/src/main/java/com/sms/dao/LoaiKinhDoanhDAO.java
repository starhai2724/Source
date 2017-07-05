package com.sms.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sms.common.SMSComons;
import com.sms.dao.common.HibernateUtil;
import com.sms.input.LoaiKinhDoanhInputBean;
import com.sms.output.LoaiKinhDoanhOutputBean;

public class LoaiKinhDoanhDAO {

	public static final LoaiKinhDoanhDAO intances = new LoaiKinhDoanhDAO();
	
	/**
	 * 
	 * 
	 * @return
	 * @throws IOException 
	 */
	public List<LoaiKinhDoanhOutputBean> getALL(){
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQLALLLoaiKinhDoanh();
		List<LoaiKinhDoanhOutputBean> lst = new ArrayList<>();
		LoaiKinhDoanhOutputBean outputRowBean;
		try {
			Transaction tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(hql);
			List<Object[]> data = query.list();
			for (Object[] object : data) {
				outputRowBean = new LoaiKinhDoanhOutputBean();
				outputRowBean.setIdLoaiKinhDoanh(SMSComons.convertString(object[0]));
				outputRowBean.setTenLoaiKinhDoanh(SMSComons.convertString(object[1]));
				outputRowBean.setHinh((byte[]) object[2]);
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
	
	public List<LoaiKinhDoanhOutputBean> getALLById(LoaiKinhDoanhInputBean inputBean){
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQLLoaiKinhDoanhById();
		List<LoaiKinhDoanhOutputBean> lst = new ArrayList<>();
		LoaiKinhDoanhOutputBean outputRowBean;
		try {
			Transaction tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, inputBean.getIdLoaiKinhDoanh());
			List<Object[]> data = query.list();
			for (Object[] object : data) {
				outputRowBean = new LoaiKinhDoanhOutputBean();
				outputRowBean.setIdLoaiKinhDoanh(SMSComons.convertString(object[0]));
				outputRowBean.setTenLoaiKinhDoanh(SMSComons.convertString(object[1]));
				outputRowBean.setHinh((byte[]) object[2]);
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
	
	
	
	
	//-----------------------------------------------------------------------------
	/**
	 * 
	 * @return
	 */
	private String getSQLALLLoaiKinhDoanh(){
		StringBuffer sb = new StringBuffer();
		sb.append("     	SELECT                        ");
		sb.append("     	PARAMETER_ID,                 ");
		sb.append("     	PARAMETER_TXT,                ");
		sb.append("     	IMAGE                         ");
		sb.append("     FROM                              ");
		sb.append("     	SYSTEM_CONTROL SC             ");
		return sb.toString(); 
	}
	/**
	 * 
	 * @return
	 */
	private String getSQLLoaiKinhDoanhById(){
		StringBuffer sb = new StringBuffer();
		sb.append("     	SELECT                        ");
		sb.append("     	PARAMETER_ID,                 ");
		sb.append("     	PARAMETER_TXT,                ");
		sb.append("     	IMAGE                         ");
		sb.append("     FROM                              ");
		sb.append("     	SYSTEM_CONTROL SC             ");
		sb.append("     WHERE                             ");
		sb.append("     	SC.PARAMETER_ID = ?          ");
		
		return sb.toString(); 
	}
	
	
}
