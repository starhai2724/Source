package com.sms.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.sms.common.SMSComons;
import com.sms.dao.common.HibernateUtil;
import com.sms.domain.Store;
import com.sms.domain.StoreInformation;
import com.sms.domain.StoreOwner;

@SuppressWarnings("unchecked")
public class RegisterUserDAO {

	public static RegisterUserDAO intances = new RegisterUserDAO();

	// Excute insert
	public int insertRegisterUser(Store store, StoreOwner storeOwner, StoreInformation storeInformation){
		int result = 0;
		
		//insert store Owner
		result = HibernateUtil.insert(storeOwner);
		if(result != 0){
			return result;
		}
		
		//insert store 
		result = HibernateUtil.insert(store);
		if(result != 0){
			return result;
		}
		
		//insert storeInformation
		result = HibernateUtil.insert(storeInformation);
		if(result != 0){
			return result;
		}
		
		return result;
	}
	
	
	/**
	 * 
	 * 
	 * @return
	 */
	
	public String getMaxIdStoreOwner() {
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQlMaxIdStoreOwner();
		String result = "";
		try {
			session.getTransaction().begin();
			SQLQuery query = session.createSQLQuery(hql);
			List<Object> data = query.list();
			for (Object object : data) {
				result = SMSComons.convertString(object);
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
	
	/**
	 * 
	 * 
	 * @return
	 */
	
	public String getMaxIdStore() {
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQlMaxIdStore();
		String result = "";
		try {
			session.getTransaction().begin();
			SQLQuery query = session.createSQLQuery(hql);
			List<Object> data = query.list();
			for (Object object : data) {
				result = SMSComons.convertString(object);
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
	/**
	 * checkExistDomain
	 * @return
	 */
	
	public boolean checkExistDomain(String domain) {
		Session session = HibernateUtil.getSessionDAO();
		String hql = getDomain();
		boolean result = true;
		try {
			session.getTransaction().begin();
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, domain);
			List<Object> data = query.list();
			for (Object object : data) {
				result = SMSComons.isNull(object);
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
	
	// SQL ------------------------------------------------------------------------------

	/**
	 * getSQlMaxIdStoreOwner
	 * @return
	 */
	private String getSQlMaxIdStoreOwner() {
		StringBuffer sb = new StringBuffer();
		sb.append("  SELECT MAX(SO.ID_STORE_OWNER) ");
		sb.append("  FROM STORE_OWNER SO           ");
		return sb.toString();
	}
	
	/**
	 * getSQlMaxIdStoreOwner
	 * @return
	 */
	private String getSQlMaxIdStore() {
		StringBuffer sb = new StringBuffer();
		sb.append("  SELECT MAX(STORE.ID_STORE) ");
		sb.append("  FROM STORE            ");
		return sb.toString();
	}
	
	/**
	 * get domain
	 * @return
	 */
	private String getDomain() {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT COUNT(*) FROM store_info si where si.PATHJSP = ?");
		return sb.toString();
	}
	
	
	
}
