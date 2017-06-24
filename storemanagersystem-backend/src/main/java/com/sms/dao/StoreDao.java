package com.sms.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sms.dao.common.HibernateUtil;
import com.sms.dao.common.InterfaceDAO;

public class StoreDao implements InterfaceDAO {

	@Override
	public Object getObject() {

		return null;
	}

	public Object getStore() {
		Session session = HibernateUtil.getSessionDAO();
		Transaction tx = session.getTransaction();
		String hql = getSQLObject();
		// List
		try {
			SQLQuery sqlQuery = session.createSQLQuery(hql);
			sqlQuery.setParameter("idStoreOwner", "");

		} catch (HibernateException e) {
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List getObjects() {
		Session session = HibernateUtil.getSessionDAO();
		Transaction tx = session.getTransaction();
		String hql = getSQLObjects();
		// List
		try {
			SQLQuery sqlQuery = session.createSQLQuery(hql);

		} catch (HibernateException e) {
		} finally {
			session.close();
		}

		return null;
	}

	@Override
	public int addObject() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateObject() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 
	 * @return
	 */

	public String getSQLObjects() {
		StringBuffer sb = new StringBuffer();
		sb.append("  SELECT ST.ID_STORE AS ID_STORE,          ");
		sb.append("  ST.ID_GROUP_STORE  AS ID_GROUP_STORE,    ");
		sb.append("  ST.ID_STORE_OWNER  AS ID_STORE_OWNER,    ");
		sb.append("  ST.ID_TYPE_STORE   AS ID_TYPE_STORE      ");
		sb.append("  FROM                                     ");
		sb.append("  storesystemmanager.STORE ST              ");
		sb.append("  WHERE ST.DELETE_FLAG = '0';              ");

		return sb.toString();
	}

	public String getSQLObject() {

		StringBuffer sb = new StringBuffer();
		sb.append("  SELECT ST.ID_STORE AS ID_STORE,          ");
		sb.append("  ST.ID_GROUP_STORE  AS ID_GROUP_STORE,    ");
		sb.append("  ST.ID_STORE_OWNER  AS ID_STORE_OWNER,    ");
		sb.append("  ST.ID_TYPE_STORE   AS ID_TYPE_STORE      ");
		sb.append("  FROM                                     ");
		sb.append("  storesystemmanager.STORE ST              ");
		sb.append("  WHERE ST.DELETE_FLAG = '0'               ");
		sb.append("  AND ST.ID_STORE_OWNER =:idStoreOwner                  ");

		return sb.toString();

	}

}
