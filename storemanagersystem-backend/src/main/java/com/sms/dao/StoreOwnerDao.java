package com.sms.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sms.common.Contants;
import com.sms.common.SMSComons;
import com.sms.common.StringUtils;
import com.sms.dao.common.HibernateUtil;
import com.sms.dao.common.InterfaceDAO;
import com.sms.domain.StoreOwner;
import com.sms.inputs.StoreOwnerInputBean;
import com.sms.models.User;
import com.sms.outputs.StoreOwnerOutputBean;

@SuppressWarnings("unchecked")
public class StoreOwnerDao implements InterfaceDAO {

	public static StoreOwnerDao storeOwnerDao = new StoreOwnerDao();

	@Override
	public Object getObject() {

		return null;
	}

	@Override
	public List<StoreOwner> getObjects() {
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQLSelect();
		List<StoreOwner> results = new ArrayList<>();
		Transaction tx = session.beginTransaction();
		try {
			SQLQuery query = session.createSQLQuery(hql);
			List<Object[]> data = query.list();
			StoreOwner storeOwner;
			for (Object[] object : data) {
				storeOwner = new StoreOwner();
				storeOwner.setIdStoreOwner(SMSComons.convertString(object[0]));
				storeOwner.setUsername(SMSComons.convertString(object[1]));
				storeOwner.setPassword(SMSComons.convertString(object[2]));
				results.add(storeOwner);
			}
			tx.commit();

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
		String hql = getSQLUser();
		User u = null;
		try {
			session.getTransaction().begin();
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, user.getUsername());
			query.setParameter(1, user.getPassword());
			List<Object[]> data = query.list();
			for (Object[] object : data) {
				u = new User();
				u.setStore_cd(SMSComons.convertString(object[0]));
				u.setUsername(SMSComons.convertString(object[1]));
				u.setPassword(SMSComons.convertString(object[2]));
				u.setRole(SMSComons.convertString(object[3]));
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
	 * @param username
	 * @return
	 */
	
	public String getStoreOwnerByUsername(String username) {
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQLStoreOwnerByUsername();
		String cnt = "";
		try {
			session.getTransaction().begin();
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, username);
			List<Object> data = query.list();
			for (Object object : data) {
				cnt = SMSComons.convertString(object);
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
		return cnt;
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

	public List<StoreOwnerOutputBean> getStoreOwners() {
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQLStoreOwners();
		List<StoreOwnerOutputBean> results = new ArrayList<StoreOwnerOutputBean>();
		Transaction tx = session.beginTransaction();
		try {
			SQLQuery query = session.createSQLQuery(hql);
			List<Object[]> data = query.list();
			StoreOwnerOutputBean storeOwnerModel;
			for (Object[] object : data) {
				storeOwnerModel = new StoreOwnerOutputBean();
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

	public List<StoreOwnerOutputBean> getStoreOwnerBy(StoreOwnerInputBean req) {
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQLStoreOwnersBy(req);
		List<StoreOwnerOutputBean> results = new ArrayList<StoreOwnerOutputBean>();
		int cnt = 0;
		try {
			SQLQuery query = session.createSQLQuery(hql);
			if(StringUtils.isNotEmpty(req.getUsername())){
				query.setParameter(cnt++, req.getUsername());
			}
			if(StringUtils.isNotEmpty(req.getTelephone())){
				query.setParameter(cnt++, req.getTelephone());
			}
			if(StringUtils.isNotEmpty(req.getEmail())){
				query.setParameter(cnt++, req.getEmail());
			}
			if(StringUtils.isNotEmpty(req.getFullName())){
				query.setParameter(cnt++, req.getFullName());
			}
			List<Object[]> data = query.list();
			int count = 1;
			StoreOwnerOutputBean storeOwnerModel;
			for (Object[] object : data) {
				storeOwnerModel = new StoreOwnerOutputBean();
				storeOwnerModel.setNo(String.valueOf(count++));
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

	/**
	 * Function Delete
	 * 
	 * @param id
	 * @return
	 */
	public int deleleStoreOwner(StoreOwnerInputBean storeOwnerInputBean) {

		Session session = HibernateUtil.getSessionDAO();
		Transaction tx = session.beginTransaction();
		String hql = getSQlDelete(storeOwnerInputBean);
		int cnt = 0;
		try {
			SQLQuery query = session.createSQLQuery(hql);
			cnt = query.executeUpdate();
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
		}

		return cnt;

	}
	/**
	 * Function update
	 * 
	 * @param id
	 * @return
	 */
	public int updateStoreOwnerById(StoreOwner storeOwner) {
		
		Session session = HibernateUtil.getSessionDAO();
		Transaction tx = session.beginTransaction();
		String hql = getSQlUpdate(storeOwner);
		int cnt = 0;
		try {
			SQLQuery query = session.createSQLQuery(hql);
			cnt = query.executeUpdate();
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
		}
		return cnt;
		
	}
	
	public StoreOwnerOutputBean getStoreOwnerById(String id) {
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQLStoreOwnersById(id);
		StoreOwnerOutputBean storeOwnerModel = null;
		try {
			session.getTransaction().begin();
			SQLQuery query = session.createSQLQuery(hql);
			List<Object[]> data = query.list();
			storeOwnerModel = new StoreOwnerOutputBean();
			for (Object[] object : data) {
				storeOwnerModel.setIdStoreOwner(SMSComons.convertString(object[0]));
				storeOwnerModel.setUsername(SMSComons.convertString(object[1]));
				storeOwnerModel.setFullName(SMSComons.convertString(object[2]));
				storeOwnerModel.setTelephone(SMSComons.convertString(object[3]));
				storeOwnerModel.setEmail(SMSComons.convertString(object[4]));
				storeOwnerModel.setAddress(SMSComons.convertString(object[5]));
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
		return storeOwnerModel;
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

	private String getSQLStoreOwnersBy(StoreOwnerInputBean req) {
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
		sb.append("       1 = 1                    ");
		if (StringUtils.isNotEmpty(req.getUsername())) {
			sb.append("  AND   SO.USERNAME  LIKE ?");
		}
		if (StringUtils.isNotEmpty(req.getTelephone())) {
			sb.append("  AND SO.TELEPHONE LIKE ?");
		}
		if (StringUtils.isNotEmpty(req.getEmail())) {
			sb.append("       AND SO.EMAIL LIKE ? ");
		}
		if (StringUtils.isNotEmpty(req.getFullName())) {
			sb.append("       AND SO.FULLNAME LIKE ?   ");
		}
		sb.append("       AND SO.DELETE_FLAG = '" + Contants.DELETE_FLAG + "' ");
		return sb.toString();
	}
	
	private String getSQLStoreOwnersById(String  id) {
		StringBuffer sb = new StringBuffer();
		sb.append("   	SELECT                           ");
		sb.append("       SO.ID_STORE_OWNER,             ");
		sb.append("       SO.USERNAME,                   ");
		sb.append("       SO.FULLNAME,                   ");
		sb.append("       SO.TELEPHONE,                  ");
		sb.append("       SO.EMAIL,                      ");
		sb.append("       SO.ADDRESS                    ");
		sb.append("   FROM                               ");
		sb.append("       STORE_OWNER SO                  ");
		sb.append("       WHERE                   ");
		sb.append("       SO.ID_STORE_OWNER = '"+id+"'    ");
		sb.append("       AND SO.DELETE_FLAG = '" + Contants.DELETE_FLAG + "' ");
		return sb.toString();
	}
	
	

	private String getSQLStoreOwnerByUsername() {
		StringBuffer sb = new StringBuffer();
		sb.append("   	SELECT                                   ");
		sb.append("       COUNT(1)   AS cnt                      ");
		sb.append("   FROM                                       ");
		sb.append("       STORE_OWNER SO      						");
		sb.append("   WHERE                                      ");
		sb.append("       SO.USERNAME = ?          ");

		return sb.toString();

	}

	private String getSQLUser() {
		StringBuffer sb = new StringBuffer();
		sb.append(" 	SELECT                                                 ");
		sb.append("    STORE.ID_STORE, SO.USERNAME, SO.PASSWORD, SO.ROLE       ");
		sb.append(" FROM                                                        ");
		sb.append("    STORE_OWNER SO                                          ");
		sb.append("        INNER JOIN                                          ");
		sb.append("    STORE ON STORE.ID_STORE_OWNER = SO.ID_STORE_OWNER       ");
		sb.append("        AND STORE.DELETE_FLAG = '"+Contants.DELETE_FLAG+"'  ");
		sb.append(" WHERE                                                       ");
		sb.append("    SO.DELETE_FLAG = '"+Contants.DELETE_FLAG+"'             ");
		sb.append("        AND SO.USERNAME = ?                            ");
		sb.append("        AND SO.PASSWORD = ?                             ");
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

	private String getSQlDelete(StoreOwnerInputBean inputBean) {
		StringBuffer sb = new StringBuffer();
		sb.append("     UPDATE STORE_OWNER SO    ");
		sb.append("     SET                                         ");
		sb.append("         SO.DELETE_FLAG = '"+Contants.DELETE_FLAG_DEACTIVE+"'                   ");
	    sb.append("     ,SO.DATEUPDATE  = '"+inputBean.getDateUpdate()+"'                                 ");
	    sb.append("     ,SO.USERUPDATE  = '"+inputBean.getUserUpdate()+"'                                 ");
		sb.append("     WHERE                                       ");
		sb.append("         SO.ID_STORE_OWNER = '" + inputBean.getIdStoreOwner() + "'            ");

		return sb.toString();
	}
	
	private String getSQlUpdate(StoreOwner storeOwner) {
		StringBuffer sb = new StringBuffer();
		sb.append("     UPDATE STORE_OWNER SO    ");
		sb.append("     SET                                         ");
		sb.append("      SO.FULLNAME = '"+storeOwner.getFullName()+"'                                ");
	    sb.append("     ,SO.TELEPHONE = '"+storeOwner.getTelephone()+"'                              ");
	    sb.append("     ,SO.EMAIL	= '"+storeOwner.getEmail()+"'                                   ");
	    sb.append("     ,SO.ADDRESS  = '"+storeOwner.getAddress()+"'                                 ");
	    sb.append("     ,SO.DATEUPDATE  = '"+storeOwner.getDateUpdate()+"'                                 ");
	    sb.append("     ,SO.USERUPDATE  = '"+storeOwner.getUserUpdate()+"'                                 ");
		sb.append("     WHERE                                       								");
		sb.append("         SO.ID_STORE_OWNER = '" + storeOwner.getIdStoreOwner() + "'            	");

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

}
