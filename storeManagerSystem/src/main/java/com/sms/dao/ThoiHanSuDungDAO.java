package com.sms.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sms.OutputRows.ThoiHanSuDungOutputRowBean;
import com.sms.common.SMSComons;
import com.sms.dao.common.HibernateUtil;
import com.sms.output.ThoiHanSuDungOutputBean;

public class ThoiHanSuDungDAO {

	public static ThoiHanSuDungDAO intances = new ThoiHanSuDungDAO();
	
	public ThoiHanSuDungOutputBean getAll(){
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQLByAll();
		ThoiHanSuDungOutputBean outputBean = new ThoiHanSuDungOutputBean();
		ThoiHanSuDungOutputRowBean outputRowBean;
		try {
			Transaction tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(hql);
			List<Object[]> data = query.list();
			for (Object[] object : data) {
				outputRowBean = new ThoiHanSuDungOutputRowBean();
				outputRowBean.setIdStoreOnwer(SMSComons.convertString(object[0]));
				outputRowBean.setTenCuaHang(SMSComons.convertString(object[1]));
				outputRowBean.setEmail(SMSComons.convertString(object[2]));
				outputRowBean.setSdt(SMSComons.convertString(object[3]));
				outputRowBean.setThoiGianSuDung(SMSComons.convertString(object[4]));
				outputRowBean.setPathJSP(SMSComons.convertString(object[5]));
				outputBean.getLst().add(outputRowBean);
			}
		}catch(HibernateException e){
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally{
			session.flush();
			session.clear();
			session.close();
		}
		return outputBean;
	}
	
	/**
	 * function update 
	 * 
	 */
	public int update(String id, String thoiGian){
		//session
		Session session = HibernateUtil.getSessionDAO();
		int cnt = 0; 
		Transaction tx = session.beginTransaction();
		//sql 
		String hql = getSQLUpdate();
		try {
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, thoiGian);
			query.setParameter(1, id);
			cnt = query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}
		return cnt;
	}
	
	//--------------------------------------------------------------------------
	/**
	 * getSQlMaxIdStoreOwner
	 * @return
	 */
	private String getSQLByAll() {
		StringBuffer sb = new StringBuffer();
		sb.append(" 	SELECT                ");
		sb.append(" 	si.ID_STORE,          ");
		sb.append(" 	si.STORENAME,         ");
		sb.append(" 	si.EMAIL,             ");
		sb.append(" 	si.TELEPHONE,         ");
		sb.append(" 	si.TIME_USE,          ");
		sb.append(" 	si.PATHJSP            ");
		sb.append(" FROM                      ");
		sb.append(" 	store_info si         ");
		return sb.toString();
	}
	
	/**
	 * update
	 * @return
	 */
	private String getSQLUpdate() {
		StringBuffer sb = new StringBuffer();
		sb.append("  UPDATE  store_info     		");
		sb.append("  		 SET TIME_USE 	= ?	        ");
		sb.append("  		 WHERE ID_STORE = ?        ");
		return sb.toString();
	}
}
