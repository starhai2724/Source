package com.sms.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sms.OutputRows.KhachHangOutputRowBean;
import com.sms.OutputRows.LoaiTheOutputRowBean;
import com.sms.common.SMSComons;
import com.sms.dao.common.HibernateUtil;
import com.sms.input.KhachHangInputBean;
import com.sms.input.LoaiTheInputBean;
import com.sms.output.NhomSanPhamOutputBean;

public class LoaiTheDAO {
	
	public static LoaiTheDAO intances = new LoaiTheDAO();
	
	
	/**
	 * function insert
	 * 
	 */
	public int insert(LoaiTheInputBean inputBean){
		//session
		Session session = HibernateUtil.getSessionDAO();
		int cnt = 0; 
		Transaction tx = session.beginTransaction();
		//id
		int id = SMSComons.convertInt(this.getMaxId(inputBean.getPathJSP()));
		//sql 
		String hql = getSQLInsert(inputBean.getPathJSP());
		try {
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, (id + 1));
			query.setParameter(1, inputBean.getTenLoaiThe());
			query.setParameter(2, inputBean.getDiem());
			cnt = query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}
		return cnt;
	}
	
	/**
	 * function update 
	 * 
	 */
	public int update(LoaiTheInputBean inputBean){
		//session
		Session session = HibernateUtil.getSessionDAO();
		int cnt = 0; 
		Transaction tx = session.beginTransaction();
		//sql 
		String hql = getSQLUpdate(inputBean.getPathJSP());
		try {
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, inputBean.getTenLoaiThe());
			query.setParameter(1, inputBean.getDiem());
			query.setParameter(2, inputBean.getIdLoaiThe());
			cnt = query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}
		return cnt;
	}
	
	/**
	 * function delete 
	 * 
	 */
	public int deleteById(LoaiTheInputBean inputBean){
		//session
		Session session = HibernateUtil.getSessionDAO();
		int cnt = 0; 
		Transaction tx = session.beginTransaction();
		//sql 
		String hql = getSQlDeleteById(inputBean.getPathJSP());
		try {
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, inputBean.getIdLoaiThe());
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
	private String getMaxId(String pathJSP) {
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQlMaxId(pathJSP);
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
	 * @throws IOException 
	 */
	public List<LoaiTheOutputRowBean> getById(LoaiTheInputBean inputBean){
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQLById(inputBean.getPathJSP());
		List<LoaiTheOutputRowBean> lst = new ArrayList<>();
		LoaiTheOutputRowBean outputRowBean;
		try {
			Transaction tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, inputBean.getIdLoaiThe());
			List<Object[]> data = query.list();
			for (Object[] object : data) {
				outputRowBean = new LoaiTheOutputRowBean();
				outputRowBean.setIdLoaiThe(SMSComons.convertString(object[0]));
				outputRowBean.setTenLoaiThe(SMSComons.convertString(object[1]));
				outputRowBean.setDiem(SMSComons.convertString(object[2]));
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
	
	/**
	 * 
	 * 
	 * @return
	 * @throws IOException 
	 */
	public List<LoaiTheOutputRowBean> getAll(String pathJSP) {
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQLAll(pathJSP);
		List<LoaiTheOutputRowBean> lst = new ArrayList<>();
		LoaiTheOutputRowBean outputRowBean;
		try {
			Transaction tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(hql);
			List<Object[]> data = query.list();
			for (Object[] object : data) {
				outputRowBean = new LoaiTheOutputRowBean();
				outputRowBean.setIdLoaiThe(SMSComons.convertString(object[0]));
				outputRowBean.setTenLoaiThe(SMSComons.convertString(object[1]));
				outputRowBean.setDiem(SMSComons.convertString(object[2]));
				
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
	
	// ----------------------------------------------------------------------------------------------------------
	
	
	
	/**
	 * insert  product
	 * @return
	 */
	private String getSQLInsert(String pathJSP) {
		StringBuffer sb = new StringBuffer();
		String tableName = pathJSP+"_LOAITHE";
		sb.append("  INSERT INTO "+tableName+" (    ");
		sb.append("  		 ID_LOAITHE		       ");
		sb.append("  		,TEN_LOAITHE 	           ");
		sb.append("  		,DIEM         ");
		sb.append("  		)                  ");
		sb.append("  		VALUES (           ");
		sb.append("  		  ?                ");
		sb.append("  		 ,?                ");
		sb.append("  		 ,?                ");
		sb.append("  		)                  ");
		
		return sb.toString();
	}	
	
	/**
	 * update  product
	 * @return
	 */
	private String getSQLUpdate(String pathJSP) {
		StringBuffer sb = new StringBuffer();
		String tableName = pathJSP+"_LOAITHE";
		sb.append("  UPDATE "+tableName+"     		");
		sb.append("  		SET TEN_LOAITHE 	= ?	        ");
		sb.append("  		,DIEM 			= ?         			");
		sb.append("  		 WHERE ID_LOAITHE = ?        ");
		return sb.toString();
	}
	
	/**
	 * getSQlMaxIdStoreOwner
	 * @return
	 */
	private String getSQLAll(String pathJSP) {
		String tableName = pathJSP+"_LOAITHE";
		StringBuffer sb = new StringBuffer();
		sb.append("  SELECT                                 ");
		sb.append("   ID_LOAITHE		                            ");
		sb.append("  ,TEN_LOAITHE 	                            ");
		sb.append("  ,DIEM                            ");
		sb.append("  FROM "+tableName+"          	");
		return sb.toString();
	}
	
	/**
	 * getSQlMaxIdStoreOwner
	 * @return
	 */
	private String getSQLById(String pathJSP) {
		String tableName = pathJSP+"_LOAITHE";
		StringBuffer sb = new StringBuffer();
		sb.append("  SELECT                                 ");
		sb.append("   ID_LOAITHE		                            ");
		sb.append("  ,TEN_LOAITHE 	                            ");
		sb.append("  ,DIEM                            ");
		sb.append("  FROM "+tableName+"          			");
		sb.append("  WHERE ID_LOAITHE = ?          			");
		return sb.toString();
	}
	
	
	/**
	 * 
	 * @return
	 */
	private String getSQlMaxId(String pathJSP) {
		String tableName = pathJSP+"_LOAITHE";
		StringBuffer sb = new StringBuffer();
		sb.append("  SELECT MAX(ID_LOAITHE) ");
		sb.append("  FROM "+tableName+"  ");
		return sb.toString();
	}
	
	/**
	 * getSQlDeleteById
	 * @return
	 */
	private String getSQlDeleteById(String pathJSP) {
		String tableName = pathJSP+"_LOAITHE";
		StringBuffer sb = new StringBuffer();
		sb.append("  DELETE  ");
		sb.append("  FROM "+tableName+"  ");
		sb.append("  WHERE ID_LOAITHE = ?  ");
		return sb.toString();
	}
	

	// ----------------------------------------------------------------------------------------------------------

	
	public static void main(String[] args) {
		LoaiTheDAO cr = new LoaiTheDAO();
	}
}
