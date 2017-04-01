package com.sms.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sms.dao.common.HibernateUtil;
import com.sms.dao.common.InterfaceDAO;
import com.sms.domain.StoreOwner;
import com.sms.models.StoreOwnerModel;
import com.sms.models.User;

public class StoreOwnerDao implements InterfaceDAO {

	public static StoreOwnerDao storeOwnerDao = new StoreOwnerDao();

	@Override
	public Object getObject() {

		return null;
	}

	@Override
	public List getObjects() {
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQLSelect();
		List results = new ArrayList<>();
		Transaction tx = session.beginTransaction();
		try {
			SQLQuery query = session.createSQLQuery(hql);
			List<Object[]> data = query.list();
			StoreOwner storeOwner;
			for (Object[] object : data) {
				storeOwner = new StoreOwner();
				storeOwner.setIdStoreOwner(object[0].toString());
				storeOwner.setUsername(object[1].toString());
				storeOwner.setPassword(object[2].toString());
				results.add(storeOwner);
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return results;
	}

	/**
	 * 
	 * @param user
	 * @return
	 */

	public User getUser(User user) {
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQLUser(user);
		User u = null;
		try {
			session.getTransaction().begin();
			SQLQuery query = session.createSQLQuery(hql);
			List<Object[]> data = query.list();
			for (Object[] object : data) {
				u = new User();
				u.setStore_cd(object[0].toString());
				u.setUsername(object[1].toString());
				u.setPassword(object[2].toString());
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
		return u;
	}

	public String getMaxIdStoreOwner() {
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQlMaxIdStoreOwner();
		String result = "";
		try {
			session.getTransaction().begin();
			SQLQuery query = session.createSQLQuery(hql);
			List<Object> data = query.list();
			for (Object object : data) {
				result = object.toString();
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
	 * Insert storeOwner
	 * 
	 */

	public StoreOwner insertStoreOwner(StoreOwner storeOwner) {
		return HibernateUtil.insertObject(storeOwner);
	}

	/**
	 * function storeOwner
	 * 
	 * @param storeOwner
	 * @return
	 */

	public StoreOwner updateStoreOwner(StoreOwner storeOwner) {
		return HibernateUtil.updateObject(storeOwner);
	}

	public List getStoreOwners() {
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQLStoreOwners();
		List results = new ArrayList<StoreOwner>();
		Transaction tx = session.beginTransaction();
		try {
			SQLQuery query = session.createSQLQuery(hql);
			List<Object[]> data = query.list();
			StoreOwnerModel storeOwnerModel;
			for (Object[] object : data) {
				storeOwnerModel = new StoreOwnerModel();
				storeOwnerModel.setIdStoreOwner(setData(object[0]));
				storeOwnerModel.setUsername(setData(object[1]));
				storeOwnerModel.setFullName(setData(object[2]));
				storeOwnerModel.setTelephone(setData(object[3]));
				storeOwnerModel.setEmail(setData(object[4]));
				storeOwnerModel.setAddress(setData(object[5]));
				storeOwnerModel.setUserInsert(setData(object[6]));
				storeOwnerModel.setDateInsert(setData(object[7]));
				storeOwnerModel.setUserUpdate(setData(object[8]));
				storeOwnerModel.setDateUpdate(setData(object[9]));

				results.add(storeOwnerModel);
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return results;
	}

	
	public List getStoreOwnerBy(StoreOwnerModel req) {
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQLStoreOwnersBy(req);
		List results = new ArrayList<StoreOwnerModel>();
		Transaction tx = session.beginTransaction();
		try {
			SQLQuery query = session.createSQLQuery(hql);
			List<Object[]> data = query.list();
			StoreOwnerModel storeOwnerModel;
			for (Object[] object : data) {
				storeOwnerModel = new StoreOwnerModel();
				storeOwnerModel.setIdStoreOwner(setData(object[0]));
				storeOwnerModel.setUsername(setData(object[1]));
				storeOwnerModel.setFullName(setData(object[2]));
				storeOwnerModel.setTelephone(setData(object[3]));
				storeOwnerModel.setEmail(setData(object[4]));
				storeOwnerModel.setAddress(setData(object[5]));
				storeOwnerModel.setUserInsert(setData(object[6]));
				storeOwnerModel.setDateInsert(setData(object[7]));
				storeOwnerModel.setUserUpdate(setData(object[8]));
				storeOwnerModel.setDateUpdate(setData(object[9]));

				results.add(storeOwnerModel);
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return results;
	}
	
	
	
	@Override
	public int addObject() {
		return 0;
	}

	@Override
	public int updateObject() {
		return 0;
	}

	private String getSQLSelect() {
		StringBuffer sb = new StringBuffer();
		sb.append("Select SO.ID_STORE_OWNER , SO.USERNAME, SO.PASSWORD from ");
		sb.append("STORE_OWNER SO");
		sb.append(" Where SO.DELETE_FLAG = 0");
		return sb.toString();
	}

	private String getSQLStoreOwners() {
		StringBuffer sb = new StringBuffer();
		sb.append("   	SELECT                           ");
		sb.append("       SO.ID_STORE_OWNER,             ");
		sb.append("       SO.USERNAME,                   ");
		sb.append("       SO.FULLNAME,                   ");
		sb.append("       SO.TELEPHONE,                  ");
		sb.append("       SO.EMAIL,                      ");
		sb.append("       SO.ADDRESS,                    ");
		sb.append("       SO.USERINSERT,                 ");
		sb.append("       SO.DATEINSERT,                 ");
		sb.append("       SO.USERUPDATE,                 ");
		sb.append("       SO.DATEUPDATE                  ");
		sb.append("   FROM                               ");
		sb.append("       STORE_OWNER SO                 ");
		sb.append("       WHERE SO.DELETE_FLAG    = '0'  ");

		return sb.toString();
	}
	
	
	
	private String getSQLStoreOwnersBy(StoreOwnerModel req) {
		StringBuffer sb = new StringBuffer();
		sb.append("   	SELECT                           ");
		sb.append("       SO.ID_STORE_OWNER,             ");
		sb.append("       SO.USERNAME,                   ");
		sb.append("       SO.FULLNAME,                   ");
		sb.append("       SO.TELEPHONE,                  ");
		sb.append("       SO.EMAIL,                      ");
		sb.append("       SO.ADDRESS,                    ");
		sb.append("       SO.USERINSERT,                 ");
		sb.append("       SO.DATEINSERT,                 ");
		sb.append("       SO.USERUPDATE,                 ");
		sb.append("       SO.DATEUPDATE                  ");
		sb.append("   FROM                               ");
		sb.append("       STORE_OWNER SO                  ");
		sb.append("       WHERE                   ");
		sb.append("       SO.USERNAME  LIKE '%"+req.getUsername()+"%'");
		sb.append("       OR SO.TELEPHONE LIKE '%"+req.getTelephone()+"%'");
		sb.append("       OR SO.EMAIL LIKE '%"+req.getEmail()+"%' ");
		sb.append("       OR SO.FULLNAME LIKE '%"+req.getFullName()+"%'      ");
		sb.append("       AND SO.DELETE_FLAG = '0' ");
		
		return sb.toString();
	}

	private String getSQLUser(User user) {
		StringBuffer sb = new StringBuffer();
		sb.append("Select SO.ID_STORE_OWNER , SO.USERNAME, SO.PASSWORD from ");
		sb.append("STORE_OWNER SO");
		sb.append(" Where SO.DELETE_FLAG = 0");
		sb.append(" AND SO.USERNAME = '" + user.getUsername() + "'");
		sb.append(" AND SO.PASSWORD = '" + user.getPassword() + "'");
		return sb.toString();
	}

	private String getSQLInsertStoreOwner() {
		StringBuffer sb = new StringBuffer();
		sb.append("   INSERT INTO storesystemmanager.STORE_OWNER     ");
		sb.append("   (ID_STORE_OWNER,                               ");
		sb.append("   USERNAME,                                      ");
		sb.append("   PASSWORD,                                      ");
		sb.append("   ROLE,                                          ");
		sb.append("   ADDRESS,                                       ");
		sb.append("   EMAIL,                                         ");
		sb.append("   FULLNAME,                                      ");
		sb.append("   TELEPHONE,                                     ");
		sb.append("   DATEINSERT,                                    ");
		sb.append("   USERINSERT,                                    ");
		sb.append("   DATEUPDATE,                                    ");
		sb.append("   USERUPDATE,                                    ");
		sb.append("   DELETE_FLAG )                                  ");
		sb.append("   VALUES(                                        ");
		sb.append("   ?,                                             ");
		sb.append("   ?,                                             ");
		sb.append("   ?,                                             ");
		sb.append("   ?,                                             ");
		sb.append("   ?,                                             ");
		sb.append("   ?,                                             ");
		sb.append("   ?,                                             ");
		sb.append("   ?,                                             ");
		sb.append("   ?,                                             ");
		sb.append("   ?,                                             ");
		sb.append("   ?,                                             ");
		sb.append("   ?                                              ");
		sb.append("   )                                              ");

		return sb.toString();

	}

	private String getSQlMaxIdStoreOwner() {
		StringBuffer sb = new StringBuffer();
		sb.append("  SELECT MAX(SO.ID_STORE_OWNER) ");
		sb.append("  FROM STORE_OWNER SO           ");
		return sb.toString();
	}

	private String setData(Object obj) {
		String result = "";
		if (obj == null) {
			return result;
		} else {
			return obj.toString();
		}

	}

	public static void main(String[] args) {
		StoreOwnerDao ownerDao = new StoreOwnerDao();
		// User user = new User();
		// user.setUsername("root");
		// user.setPassword("1234");
		// ownerDao.getUser(user);
		// ownerDao.getUser(user);
		//
		StoreOwner storeOwner = new StoreOwner();
		storeOwner.setIdStoreOwner("100111");
		storeOwner.setUsername("store");
		storeOwner.setPassword("123456");
		storeOwner.setFullName("Nguyen Trung Hai");

		// ownerDao.getMaxIdStoreOwner();
		System.out.println(ownerDao.getStoreOwners().toString());
		// System.out.println(ownerDao.insertStoreOwner(storeOwner).getIdStoreOwner());
		// System.out.println(ownerDao.updateStoreOwner(storeOwner).getIdStoreOwner());

	}

}
