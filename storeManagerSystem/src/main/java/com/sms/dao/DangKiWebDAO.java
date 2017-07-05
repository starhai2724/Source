package com.sms.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sms.common.SMSComons;
import com.sms.dao.common.HibernateUtil;
import com.sms.input.DangKiWebInputBean;

public class DangKiWebDAO {
	
	public static final DangKiWebDAO intances = new DangKiWebDAO();
	
	
	/**
	 * function insert
	 * 
	 */
	public int insert(DangKiWebInputBean inputBean){
		//session
		Session session = HibernateUtil.getSessionDAO();
		int cnt = 0; 
		Transaction tx = session.beginTransaction();
		//id
		int id = SMSComons.convertInt(this.getMaxId());
		//sql 
		String hql = getSQLInsert();
		try {
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, (id + 1));
			// Username se duoc gan bang gia tri cua email
			query.setParameter(1, inputBean.getEmail());
			query.setParameter(2, inputBean.getMatKhau());
			query.setParameter(3, inputBean.getQuyen());
			query.setParameter(4, inputBean.getNgayTao());
			query.setParameter(5, inputBean.getNgayChinhSua());
			query.setParameter(6, inputBean.getNguoiTao());
			query.setParameter(7, "");
			query.setParameter(8, "0");
			query.setParameter(9, inputBean.getDiaChi());
			query.setParameter(10, inputBean.getEmail());
			query.setParameter(11, "FULLNAME");
			query.setParameter(12, inputBean.getSdt());
			cnt = query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}
		return cnt;
	}
	
	
	/**
	 * function insertStoreInfo
	 * 
	 */
	public int insertStoreInfo(DangKiWebInputBean inputBean){
		//session
		Session session = HibernateUtil.getSessionDAO();
		int cnt = 0; 
		Transaction tx = session.beginTransaction();
		//id
		int id = SMSComons.convertInt(this.getMaxId());
		//sql 
		String hql = getSQLInsertStoreInfo();
		try {
			SQLQuery query = session.createSQLQuery(hql);
			//id cua hang va id nguoi dung cung mot gia tri
			query.setParameter(0, ("100124"));
			// Username se duoc gan bang gia tri cua email
			query.setParameter(1, "");
			query.setParameter(2, "");
			query.setParameter(3, inputBean.getDiaChi());
			query.setParameter(4, inputBean.getLoaiKinhDoanh());
			query.setParameter(5, inputBean.getEmail());
			query.setParameter(6, "");
			query.setParameter(7, inputBean.getPathJSP());
			query.setParameter(8, inputBean.getTenWebSite());
			query.setParameter(9, inputBean.getSdt());
			cnt = query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}
		return cnt;
	}
	
	/**
	 * 
	 * 
	 * @return
	 */
	private String getMaxId() {
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQlMaxId();
		String result = "";
		try {
			Transaction tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(hql);
			List<Object> data = query.list();
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
	
	/**
	 * 
	 * 
	 * @return
	 */
	public String getExistPathJSP(String pathJSP) {
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQlPathJSP();
		String result = "";
		try {
			Transaction tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, pathJSP);
			List<Object> data = query.list();
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
	
	/**
	 * 
	 * 
	 * @return
	 */
	public String getExistEmail(String email) {
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQlEmail();
		String result = "";
		try {
			Transaction tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, email);
			List<Object> data = query.list();
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
	
	
	/**
	 * 
	 * 
	 * @return
	 */
	public String getExistSDT(String sdt) {
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQlSDT();
		String result = "";
		try {
			Transaction tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, sdt);
			List<Object> data = query.list();
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
	
	
	//---------------------------------------------------------
	
	
	/**
	 * insert  
	 * @return
	 */
	private String getSQLInsert() {
		StringBuffer sb = new StringBuffer();
		sb.append("    INSERT INTO STORE_OWNER        ");
		sb.append("    (                ");
		sb.append("    ID_STORE_OWNER                ");
		sb.append("    ,USERNAME 	                  ");
		sb.append("    ,PASSWORD	                      ");
		sb.append("    ,ROLE 		                  ");
		sb.append("    ,DATEINSERT 	                  ");
		sb.append("    ,DATEUPDATE 	                  ");
		sb.append("    ,USERINSERT 	                  ");
		sb.append("    ,USERUPDATE 	                  ");
		sb.append("    ,DELETE_FLAG                    ");
		sb.append("    ,ADDRESS 	                      ");
		sb.append("    ,EMAIL 		                  ");
		sb.append("    ,FULLNAME 	                  ");
		sb.append("    ,TELEPHONE            		");
		sb.append("    ) VALUES                             ");
		sb.append("    (                              ");
		sb.append("           ?                        ");
		sb.append("          ,?                        ");
		sb.append("          ,?                        ");
		sb.append("          ,?                        ");
		sb.append("          ,?                        ");
		sb.append("          ,?                        ");
		sb.append("          ,?                        ");
		sb.append("          ,?                        ");
		sb.append("          ,?                        ");
		sb.append("          ,?                        ");
		sb.append("          ,?                        ");
		sb.append("          ,?                        ");
		sb.append("          ,?                        ");
		sb.append("    )                              ");
		return sb.toString();
	}
	
	/**
	 * insert  
	 * @return
	 */
	private String getSQLInsertStoreInfo() {
		StringBuffer sb = new StringBuffer();
		sb.append("   INSERT INTO STORE_INFO    ");
		sb.append("   (                         ");
		sb.append("    ID_STORE 	                ");
		sb.append("   ,IMAGEFOOTER               ");
		sb.append("   ,IMAGEHEADER               ");
		sb.append("   ,ADDRESS 	                ");
		sb.append("   ,CATEGORY 	                ");
		sb.append("   ,EMAIL 		            ");
		sb.append("   ,PATHIMAGE 	            ");
		sb.append("   ,PATHJSP 	                ");
		sb.append("   ,STORENAME 	            ");
		sb.append("   ,TELEPHONE                 ");
		sb.append("   )VALUES                   ");
		sb.append("   (                         ");
		sb.append("    ?                         ");
		sb.append("   ,?                         ");
		sb.append("   ,?                         ");
		sb.append("   ,?                         ");
		sb.append("   ,?                         ");
		sb.append("   ,?                         ");
		sb.append("   ,?                         ");
		sb.append("   ,?                         ");
		sb.append("   ,?                         ");
		sb.append("   ,?                         ");
		sb.append("   )                         ");
		
		return sb.toString();
	}
	
	
	/**
	 * 
	 * @return
	 */
	private String getSQlMaxId() {
		StringBuffer sb = new StringBuffer();
		sb.append("  SELECT MAX(ID_STORE_OWNER) ");
		sb.append("  FROM STORE_OWNER  ");
		return sb.toString();
	}
	
	
	/**
	 * 
	 * @return
	 */
	private String getSQlPathJSP() {
		StringBuffer sb = new StringBuffer();
		sb.append(" 	SELECT                  ");
		sb.append(" 	SI.PATHJSP              ");
		sb.append(" FROM                        ");
		sb.append(" 	STORE_INFO SI           ");
		sb.append(" WHERE                       ");
		sb.append(" 	SI.PATHJSP = ?         ");
		return sb.toString();
	}
	
	/**
	 * 
	 * @return
	 */
	private String getSQlEmail() {
		StringBuffer sb = new StringBuffer();
		sb.append(" 	SELECT                  ");
		sb.append(" 	SO.EMAIL              ");
		sb.append(" FROM                        ");
		sb.append(" 	STORE_OWNER SO           ");
		sb.append(" WHERE                       ");
		sb.append(" 	SO.EMAIL = ?         ");
		
		return sb.toString();
	}
	
	/**
	 * 
	 * @return
	 */
	private String getSQlSDT() {
		StringBuffer sb = new StringBuffer();
		sb.append(" 	SELECT                  ");
		sb.append(" 	SO.TELEPHONE              ");
		sb.append(" FROM                        ");
		sb.append(" 	STORE_OWNER SO           ");
		sb.append(" WHERE                       ");
		sb.append(" 	SO.TELEPHONE = ?         ");
		
		return sb.toString();
	}
	public static void main(String[] args) {
		DangKiWebInputBean inputBean = new DangKiWebInputBean();
		
		DangKiWebDAO.intances.insertStoreInfo(inputBean);
	
		
	}
	
}
