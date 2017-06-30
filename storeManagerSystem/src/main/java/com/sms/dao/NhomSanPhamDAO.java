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
import com.sms.input.NhomSanPhamInputBean;
import com.sms.input.RegisterProductCategoryInputBean;
import com.sms.output.LoaiSanPhamOutputBean;
import com.sms.output.NhomSanPhamOutputBean;

public class NhomSanPhamDAO {
	
	public static NhomSanPhamDAO intances = new NhomSanPhamDAO();
	
	/**
	 * function mean create table product by pathJSP of store
	 * 
	 */
	public int createTable_NhomSP(String pathJSP){
		//session
		Session session = HibernateUtil.getSessionDAO();
		int cnt = 0; 
		Transaction tx = session.beginTransaction();
		//sql
		String hql = this.getSQLCreateTable_NhomSP(pathJSP);
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
	
	public int createTable_LSP(String pathJSP){
		//session
		Session session = HibernateUtil.getSessionDAO();
		int cnt = 0; 
		Transaction tx = session.beginTransaction();
		//sql
		String hql = this.getSQLCreateTable_LSP(pathJSP);
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
	public int insertNhomSP(RegisterProductCategoryInputBean inputBean){
		//session
		Session session = HibernateUtil.getSessionDAO();
		int cnt = 0; 
		//id
		int id = SMSComons.convertInt(getMaxIdProductCategory(inputBean.getPathJSP()));
		
		Transaction tx = session.beginTransaction();
		//sql
		String hql = this.getSQLInsertNhomSP(inputBean.getPathJSP());	
		try {
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, (id+1));
			query.setParameter(1, inputBean.getTenNhomSP());
			cnt = query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}
		return cnt;
	}
	
	public int insertLoaiSP(RegisterProductCategoryInputBean inputBean){
		//session
		Session session = HibernateUtil.getSessionDAO();
		int cnt = 0; 
		//id
		int id = SMSComons.convertInt(getMaxIdLSP(inputBean.getPathJSP()));
		System.out.println("maxID : " + id);
		Transaction tx = session.beginTransaction();
		//sql
		String hql = this.getSQLInsertLoaiSP(inputBean.getPathJSP());	
		try {
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, (id+1));
			query.setParameter(1, inputBean.getTenLoaiSP());
			query.setParameter(2, inputBean.getIdNhomSP());
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
	public int updateNhomSP(RegisterProductCategoryInputBean inputBean){
		//session
		Session session = HibernateUtil.getSessionDAO();
		int cnt = 0; 
		Transaction tx = session.beginTransaction();
		//sql
		String hql = this.getSQLUpdateNhomSP(inputBean.getPathJSP());	
		try {
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, inputBean.getTenNhomSP());
			query.setParameter(1, inputBean.getIdNhomSP());
			cnt = query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}
		return cnt;
	}
	
	public int updateLoaiSP(RegisterProductCategoryInputBean inputBean){
		//session
		Session session = HibernateUtil.getSessionDAO();
		int cnt = 0; 
		Transaction tx = session.beginTransaction();
		//sql
		String hql = this.getSQLUpdateLoaiSP(inputBean.getPathJSP());	
		try {
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, inputBean.getTenLoaiSP());
			query.setParameter(1, inputBean.getIdLoaiSP());
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
			query.setParameter(0, inputBean.getIdNhomSP());
			cnt = query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}
		return cnt;
	}
	
	public int deleteLoaiSP(RegisterProductCategoryInputBean inputBean){
		//session
		Session session = HibernateUtil.getSessionDAO();
		int cnt = 0; 
		Transaction tx = session.beginTransaction();
		//sql
		String hql = this.getSQlDeleteByIdLoaiSP(inputBean.getPathJSP());	
		try {
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, inputBean.getIdLoaiSP());
			cnt = query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}
		return cnt;
	}
	
	public int deleteLoaiSPByIdNhomSP(RegisterProductCategoryInputBean inputBean){
		//session
		Session session = HibernateUtil.getSessionDAO();
		int cnt = 0; 
		Transaction tx = session.beginTransaction();
		//sql
		String hql = this.getSQlDeleteByIdNhomSP(inputBean.getPathJSP());	
		try {
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, inputBean.getIdNhomSP());
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
	
	public String getMaxIdLSP(String pathJSP) {
		Session session = HibernateUtil.getSessionDAO();
		String hql = getIdMaxLSP(pathJSP);
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
	public List<NhomSanPhamOutputBean> getNhomSP(NhomSanPhamInputBean inputBean) {
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQLNhomSanPham(inputBean.getPathJSP());
		List<NhomSanPhamOutputBean> lst = new ArrayList<>();
		NhomSanPhamOutputBean sanPhamOutputBean;
		try {
			Transaction tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(hql);
			List<Object[]> data = query.list();
			for (Object[] object : data) {
				sanPhamOutputBean = new NhomSanPhamOutputBean();
				sanPhamOutputBean.setIdNhomSP(SMSComons.convertString(object[0]));
				sanPhamOutputBean.setTenNhomSP(SMSComons.convertString(object[1]));
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
	public List<LoaiSanPhamOutputBean> getNhomSPAndLoaiSP(LoaiSanPhamInputBean inputBean) {
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQLNhomSanPhamAndLoaiSP(inputBean.getPathJSP());
		List<LoaiSanPhamOutputBean> lst = new ArrayList<>();
		LoaiSanPhamOutputBean loaiSanPhamOutputBean;
		try {
			Transaction tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(hql);
			List<Object[]> data = query.list();
			for (Object[] object : data) {
				loaiSanPhamOutputBean = new LoaiSanPhamOutputBean();
				loaiSanPhamOutputBean.setIdLoaiSP(SMSComons.convertString(object[0]));
				loaiSanPhamOutputBean.setTenLoaiSP(SMSComons.convertString(object[2])+": "+SMSComons.convertString(object[1]));
				lst.add(loaiSanPhamOutputBean);
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
	public List<NhomSanPhamOutputBean> getNhomSPById(NhomSanPhamInputBean inputBean) {
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQLNhomSanPhamById(inputBean.getPathJSP());
		List<NhomSanPhamOutputBean> lst = new ArrayList<>();
		NhomSanPhamOutputBean sanPhamOutputBean;
		try {
			Transaction tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, inputBean.getIdNhomSP());
			List<Object[]> data = query.list();
			for (Object[] object : data) {
				sanPhamOutputBean = new NhomSanPhamOutputBean();
				sanPhamOutputBean.setIdNhomSP(SMSComons.convertString(object[0]));
				sanPhamOutputBean.setTenNhomSP(SMSComons.convertString(object[1]));
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
				sanPhamOutputBean.setIdNhomSP(SMSComons.convertString(object[2]));
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
	
	public List<LoaiSanPhamOutputBean> getLoaiSPByIdNhomSP(LoaiSanPhamInputBean inputBean) {
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQLLSPByIdNhomSP(inputBean.getPathJSP());
		List<LoaiSanPhamOutputBean> lst = new ArrayList<>();
		LoaiSanPhamOutputBean loaiSPOutput;
		try {
			Transaction tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, inputBean.getIdNhomSP());
			List<Object[]> data = query.list();
			for (Object[] object : data) {
				loaiSPOutput = new LoaiSanPhamOutputBean();
				loaiSPOutput.setIdLoaiSP(SMSComons.convertString(object[0]));
				loaiSPOutput.setTenLoaiSP(SMSComons.convertString(object[1]));
				loaiSPOutput.setIdNhomSP(SMSComons.convertString(object[2]));
				lst.add(loaiSPOutput);
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
	private String getSQLCreateTable_NhomSP(String pathJSP) {
		StringBuffer sb = new StringBuffer();
		String tableName = pathJSP+"_NHOM_SP";
		sb.append(" CREATE TABLE "+tableName+ " (        ");
		sb.append(" 		ID_NHOM_SP VARCHAR (6),      ");
		sb.append(" 		TEN_NHOM_SP VARCHAR (255)    ");
		sb.append(" 	)                                ");
		return sb.toString();
	}
	
	private String getSQLCreateTable_LSP(String pathJSP) {
		StringBuffer sb = new StringBuffer();
		String tableName = pathJSP+"_LOAI_SP";
		sb.append(" CREATE TABLE "+tableName+ " (        ");
		sb.append(" 		ID_LOAI_SP VARCHAR (6)      ");
		sb.append(" 		,TEN_LOAI_SP VARCHAR (255)    ");
		sb.append(" 		,ID_NHOM_SP VARCHAR (6)      ");
		sb.append(" 	)                                ");
		return sb.toString();
	}
	
	
	/**
	 * delete table product
	 * @return
	 */
	private String getSQLDeleteTable(String pathJSP) {
		StringBuffer sb = new StringBuffer();
		String tableName = pathJSP+"_NHOM_SP";
		sb.append("   DROP TABLE "+tableName+"            ");
		return sb.toString();
	}
	
	/**
	 * insert 
	 * @return
	 */
	private String getSQLInsertNhomSP(String pathJSP) {
		StringBuffer sb = new StringBuffer();
		String tableName = pathJSP+"_NHOM_SP";
		sb.append("   INSERT INTO "+tableName+"            	");
		sb.append("   (ID_NHOM_SP, TEN_NHOM_SP)				");
		sb.append("	VALUES									");
		sb.append("	( ?            							");
		sb.append("	  ,?)            						");
		return sb.toString();
	}
	
	private String getSQLInsertLoaiSP(String pathJSP) {
		StringBuffer sb = new StringBuffer();
		String tableName = pathJSP+"_LOAI_SP";
		sb.append("   INSERT INTO "+tableName+"            	");
		sb.append("   (ID_LOAI_SP, TEN_LOAI_SP, ID_NHOM_SP)	");
		sb.append("	VALUES									");
		sb.append("	( ?            							");
		sb.append("	  ,?            						");
		sb.append("	  ,?)            						");
		return sb.toString();
	}
	
	/**
	 * update 
	 * @return
	 */
	private String getSQLUpdateNhomSP(String pathJSP) {
		StringBuffer sb = new StringBuffer();
		String tableName = pathJSP+"_NHOM_SP";
		sb.append("   UPDATE "+tableName+"        ");
		sb.append("   SET  TEN_NHOM_SP = ? 				");
		sb.append("	WHERE 	ID_NHOM_SP = ?				");
		return sb.toString();
	}
	
	private String getSQLUpdateLoaiSP(String pathJSP) {
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
	private String getSQLNhomSanPham(String pathJSP) {
		StringBuffer sb = new StringBuffer();
		String tableName = pathJSP+"_NHOM_SP";
		sb.append(" SELECT ID_NHOM_SP        ");
		sb.append(" 	   ,TEN_NHOM_SP        ");
		sb.append(" 		FROM "+tableName+"      ");
		return sb.toString();
	}
	
	/**
	 * create table product 
	 * @return
	 */
	private String getSQLNhomSanPhamAndLoaiSP(String pathJSP) {
		StringBuffer sb = new StringBuffer();
		String tableName = pathJSP+"_LOAI_SP";
		sb.append(" SELECT  LSP.ID_LOAI_SP        ");
		sb.append(" 	   ,LSP.TEN_LOAI_SP        ");
		sb.append(" 	   ,NSP.TEN_NHOM_SP        ");
		sb.append(" 		FROM "+tableName+"  LSP    ");
		sb.append(" 		INNER JOIN "+pathJSP+"_NHOM_SP NSP      ");
		sb.append(" 		ON NSP.ID_NHOM_SP =  LSP.ID_NHOM_SP     ");
		
		return sb.toString();
	}
	/**
	 * create table product 
	 * @return
	 */
	private String getSQLNhomSanPhamById(String pathJSP) {
		StringBuffer sb = new StringBuffer();
		String tableName = pathJSP+"_NHOM_SP";
		sb.append(" SELECT ID_NHOM_SP        ");
		sb.append(" 	   ,TEN_NHOM_SP        ");
		sb.append(" 		FROM "+tableName+"  NHOM_SP     ");
		sb.append(" 		WHERE NHOM_SP.ID_NHOM_SP = ?      ");
		return sb.toString();
	}
	
	private String getSQLLoaiSanPhamById(String pathJSP) {
		StringBuffer sb = new StringBuffer();
		String tableName = pathJSP+"_LOAI_SP";
		sb.append(" SELECT ID_LOAI_SP        ");
		sb.append(" 	   ,TEN_LOAI_SP        ");
		sb.append(" 	   ,ID_NHOM_SP        ");
		sb.append(" 		FROM "+tableName+"  LOAI_SP     ");
		sb.append(" 		WHERE LOAI_SP.ID_LOAI_SP = ?      ");
		return sb.toString();
	}
	
	
	private String getSQLLSPByIdNhomSP(String pathJSP) {
		StringBuffer sb = new StringBuffer();
		String tableName = pathJSP+"_LOAI_SP";
		sb.append(" SELECT ID_LOAI_SP        ");
		sb.append(" 	   ,TEN_LOAI_SP        ");
		sb.append(" 	   ,ID_NHOM_SP        ");
		sb.append(" 		FROM "+tableName+"  LOAI_SP     ");
		sb.append(" 		WHERE LOAI_SP.ID_NHOM_SP = ?      ");
		return sb.toString();
	}
	/**
	 * 
	 * @param pathJSP
	 * @return
	 */
	
	private String getIdMax(String pathJSP){
		String tableName = pathJSP+"_NHOM_SP";
		StringBuffer sb = new StringBuffer();
		sb.append("  	SELECT                                      ");
		sb.append("      MAX(NHOM_SP.ID_NHOM_SP) AS IDMAX       	");
		sb.append("                                                 ");
		sb.append("  FROM "+tableName+"  NHOM_SP     				");
		
		return sb.toString();
	}
	
	private String getIdMaxLSP(String pathJSP){
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
		String tableName = pathJSP+"_NHOM_SP";
		StringBuffer sb = new StringBuffer();
		sb.append("  DELETE  ");
		sb.append("  FROM "+tableName+"  ");
		sb.append("  WHERE ID_NHOM_SP = ?  ");
		return sb.toString();
	}
	
	private String getSQlDeleteByIdLoaiSP(String pathJSP) {
		String tableName = pathJSP+"_LOAI_SP";
		StringBuffer sb = new StringBuffer();
		sb.append("  DELETE  ");
		sb.append("  FROM "+tableName+"  ");
		sb.append("  WHERE ID_LOAI_SP = ?  ");
		return sb.toString();
	}
	
	private String getSQlDeleteByIdNhomSP(String pathJSP) {
		String tableName = pathJSP+"_LOAI_SP";
		StringBuffer sb = new StringBuffer();
		sb.append("  DELETE  ");
		sb.append("  FROM "+tableName+"  ");
		sb.append("  WHERE ID_NHOM_SP = ?  ");
		return sb.toString();
	}
	
	public static void main(String[] args) {
		NhomSanPhamDAO loaiSanPhamDAO = new NhomSanPhamDAO();
		NhomSanPhamInputBean inputBean = new NhomSanPhamInputBean();
		inputBean.setIdNhomSP("3");
		inputBean.setPathJSP("cuahangthoitrang");
		
//		loaiSanPhamDAO.getNhomSPById(inputBean);
		loaiSanPhamDAO.createTable_NhomSP(inputBean.getPathJSP());
		loaiSanPhamDAO.createTable_LSP(inputBean.getPathJSP());
		
	}
	
}
