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
import com.sms.input.LoaiSanPhamInputBean;
import com.sms.input.RegisterProductCategoryInputBean;
import com.sms.output.LoaiSanPhamOutputBean;

public class LoaiSanPhamDAO {
	
	public static LoaiSanPhamDAO intances = new LoaiSanPhamDAO();
	
	/**
	 * function mean create table product by pathJSP of store
	 * 
	 */
	public int createTable(String pathJSP){
		//session
		Session session = HibernateUtil.getSessionDAO();
		int cnt = 0; 
		Transaction tx = session.beginTransaction();
		//sql
		String hql = this.getSQLCreateTable(pathJSP);
		try {
			SQLQuery query = session.createSQLQuery(hql);
			cnt = query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			cnt = 1;
		} finally {
			session.close();
		}
		return cnt;
	}
	
	/**
	 * function mean detele table product by pathJSP of store
	 * 
	 */
	public int deleteTable(String pathJSP){
		//session
		Session session = HibernateUtil.getSessionDAO();
		int cnt = 0; 
		Transaction tx = session.beginTransaction();
		//sql
		String hql = this.getSQLDeleteTable(pathJSP);	
		try {
			SQLQuery query = session.createSQLQuery(hql);
			cnt = query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			cnt = 1;
		} finally {
			session.close();
		}
		return cnt;
	}
	
	/**
	 *  insert 
	 * 
	 */
	public int insert(RegisterProductCategoryInputBean inputBean){
		//session
		Session session = HibernateUtil.getSessionDAO();
		int cnt = 0; 
		//id
		int id = SMSComons.convertInt(getMaxIdProductCategory(inputBean.getPathJSP()));
		
		Transaction tx = session.beginTransaction();
		//sql
		String hql = this.getSQLInsert(inputBean.getPathJSP());	
		try {
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, (id+1));
			query.setParameter(1, inputBean.getNameProductCategory());
			cnt = query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}
		return cnt;
	}
	
	
	/**
	 *  update 
	 * 
	 */
	public int update(RegisterProductCategoryInputBean inputBean){
		//session
		Session session = HibernateUtil.getSessionDAO();
		int cnt = 0; 
		Transaction tx = session.beginTransaction();
		//sql
		String hql = this.getSQLUpdate(inputBean.getPathJSP());	
		try {
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, inputBean.getNameProductCategory());
			query.setParameter(1, inputBean.getIdProductCategory());
			cnt = query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}
		return cnt;
	}
	
	/**
	 *  delete 
	 * 
	 */
	public int delete(RegisterProductCategoryInputBean inputBean){
		//session
		Session session = HibernateUtil.getSessionDAO();
		int cnt = 0; 
		Transaction tx = session.beginTransaction();
		//sql
		String hql = this.getSQlDeleteById(inputBean.getPathJSP());	
		try {
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, inputBean.getIdProductCategory());
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
	
	public String getMaxIdProductCategory(String pathJSP) {
		Session session = HibernateUtil.getSessionDAO();
		String hql = getIdMax(pathJSP);
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
	public List<LoaiSanPhamOutputBean> getLoaiSP(LoaiSanPhamInputBean inputBean) {
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQLLoaiSanPham(inputBean.getPathJSP());
		List<LoaiSanPhamOutputBean> lst = new ArrayList<>();
		LoaiSanPhamOutputBean sanPhamOutputBean;
		try {
			Transaction tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(hql);
			List<Object[]> data = query.list();
			for (Object[] object : data) {
				sanPhamOutputBean = new LoaiSanPhamOutputBean();
				sanPhamOutputBean.setIdLoaiSP(SMSComons.convertString(object[0]));
				sanPhamOutputBean.setTenLoaiSP(SMSComons.convertString(object[1]));
				lst.add(sanPhamOutputBean);
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
	public List<LoaiSanPhamOutputBean> getLoaiSPById(LoaiSanPhamInputBean inputBean) {
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQLLoaiSanPhamById(inputBean.getPathJSP());
		List<LoaiSanPhamOutputBean> lst = new ArrayList<>();
		LoaiSanPhamOutputBean sanPhamOutputBean;
		try {
			Transaction tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, inputBean.getIdLoaiSP());
			List<Object[]> data = query.list();
			for (Object[] object : data) {
				sanPhamOutputBean = new LoaiSanPhamOutputBean();
				sanPhamOutputBean.setIdLoaiSP(SMSComons.convertString(object[0]));
				sanPhamOutputBean.setTenLoaiSP(SMSComons.convertString(object[1]));
				lst.add(sanPhamOutputBean);
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
	 * create table product 
	 * @return
	 */
	private String getSQLCreateTable(String pathJSP) {
		StringBuffer sb = new StringBuffer();
		String tableName = pathJSP+"_LOAI_SP";
		sb.append(" CREATE TABLE "+tableName+ " (        ");
		sb.append(" 		ID_LOAI_SP VARCHAR (6),      ");
		sb.append(" 		TEN_LOAI_SP VARCHAR (6)    ");
		sb.append(" 	)                                ");
		return sb.toString();
	}
	
	/**
	 * delete table product
	 * @return
	 */
	private String getSQLDeleteTable(String pathJSP) {
		StringBuffer sb = new StringBuffer();
		String tableName = pathJSP+"_LOAI_SP";
		sb.append("   DROP TABLE "+tableName+"            ");
		return sb.toString();
	}
	
	/**
	 * insert 
	 * @return
	 */
	private String getSQLInsert(String pathJSP) {
		StringBuffer sb = new StringBuffer();
		String tableName = pathJSP+"_LOAI_SP";
		sb.append("   INSERT INTO "+tableName+"            	");
		sb.append("   (ID_LOAI_SP, TEN_LOAI_SP)				");
		sb.append("	VALUES									");
		sb.append("	( ?            							");
		sb.append("	  ,?)            						");
		return sb.toString();
	}
	
	/**
	 * update 
	 * @return
	 */
	private String getSQLUpdate(String pathJSP) {
		StringBuffer sb = new StringBuffer();
		String tableName = pathJSP+"_LOAI_SP";
		sb.append("   UPDATE "+tableName+"        ");
		sb.append("   SET  TEN_LOAI_SP = ? 				");
		sb.append("	WHERE 	ID_LOAI_SP = ?				");
		return sb.toString();
	}
	
	
	/**
	 * create table product 
	 * @return
	 */
	private String getSQLLoaiSanPham(String pathJSP) {
		StringBuffer sb = new StringBuffer();
		String tableName = pathJSP+"_LOAI_SP";
		sb.append(" SELECT ID_LOAI_SP        ");
		sb.append(" 	   ,TEN_LOAI_SP        ");
		sb.append(" 		FROM "+tableName+"      ");
		return sb.toString();
	}
	/**
	 * create table product 
	 * @return
	 */
	private String getSQLLoaiSanPhamById(String pathJSP) {
		StringBuffer sb = new StringBuffer();
		String tableName = pathJSP+"_LOAI_SP";
		sb.append(" SELECT ID_LOAI_SP        ");
		sb.append(" 	   ,TEN_LOAI_SP        ");
		sb.append(" 		FROM "+tableName+"  LOAI_SP     ");
		sb.append(" 		WHERE LOAI_SP.ID_LOAI_SP = ?      ");
		return sb.toString();
	}
	/**
	 * 
	 * @param pathJSP
	 * @return
	 */
	
	private String getIdMax(String pathJSP){
		String tableName = pathJSP+"_LOAI_SP";
		StringBuffer sb = new StringBuffer();
		sb.append("  	SELECT                                      ");
		sb.append("      MAX(LOAI_SP.ID_LOAI_SP) AS IDMAX       	");
		sb.append("                                                 ");
		sb.append("  FROM "+tableName+"  LOAI_SP     				");
		
		return sb.toString();
	}
	
	/**
	 * getSQlDeleteById
	 * @return
	 */
	private String getSQlDeleteById(String pathJSP) {
		String tableName = pathJSP+"_LOAI_SP";
		StringBuffer sb = new StringBuffer();
		sb.append("  DELETE  ");
		sb.append("  FROM "+tableName+"  ");
		sb.append("  WHERE ID_LOAI_SP = ?  ");
		return sb.toString();
	}
	
	public static void main(String[] args) {
		LoaiSanPhamDAO loaiSanPhamDAO = new LoaiSanPhamDAO();
		LoaiSanPhamInputBean inputBean = new LoaiSanPhamInputBean();
		inputBean.setIdLoaiSP("3");
		inputBean.setPathJSP("cuahangthoitrang");
		
		loaiSanPhamDAO.getLoaiSPById(inputBean);
		
	}
	
}
