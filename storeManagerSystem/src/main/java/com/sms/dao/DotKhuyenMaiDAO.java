package com.sms.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sms.OutputRows.DotKhuyenMaiOutputRowBean;
import com.sms.common.SMSComons;
import com.sms.dao.common.HibernateUtil;
import com.sms.input.DotKhuyenMaiInputBean;

public class DotKhuyenMaiDAO {
	
	public static DotKhuyenMaiDAO intances = new DotKhuyenMaiDAO();
	
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
		} finally {
			session.close();
		}
		return cnt;
	}
	
	/**
	 * function insert
	 * 
	 */
	public int insert(DotKhuyenMaiInputBean inputBean){
		//session
		Session session = HibernateUtil.getSessionDAO();
		int cnt = 0; 
		Transaction tx = session.beginTransaction();
		//id
		int maDKM = SMSComons.convertInt(this.getMaxId(inputBean.getPathJSP()));
		//sql 
		String hql = getSQLInsert(inputBean.getPathJSP());
		try {
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, (maDKM + 1));
			query.setParameter(1, inputBean.getTenDKM());
			query.setParameter(2, inputBean.getLoaiKM());
			query.setParameter(3, inputBean.getMucKM());
			query.setParameter(4, inputBean.getDonViKM());
			query.setParameter(5, inputBean.getNgayBD());
			query.setParameter(6, inputBean.getNgayKT());
			query.setParameter(7, inputBean.getMoTa());
			query.setParameter(8, inputBean.getDk_loaiThe());
			query.setParameter(9, inputBean.getDk_tongHD());
			query.setParameter(10, inputBean.getDk_tongSL());
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
	public int update(DotKhuyenMaiInputBean inputBean){
		//session
		Session session = HibernateUtil.getSessionDAO();
		int cnt = 0; 
		Transaction tx = session.beginTransaction();
		//sql 
		String hql = getSQLUpdate(inputBean.getPathJSP());
		try {
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, inputBean.getTenDKM());
			query.setParameter(1, inputBean.getLoaiKM());
			query.setParameter(2, inputBean.getMucKM());
			query.setParameter(3, inputBean.getDonViKM());
			query.setParameter(4, inputBean.getNgayBD());
			query.setParameter(5, inputBean.getNgayKT());
			query.setParameter(6, inputBean.getDk_loaiThe());
			query.setParameter(7, inputBean.getMoTa());
			query.setParameter(8, inputBean.getDk_tongHD());
			query.setParameter(9, inputBean.getDk_tongSL());
			query.setParameter(10, inputBean.getMaDKM());
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
	public int deleteById(DotKhuyenMaiInputBean inputBean){
		//session
		Session session = HibernateUtil.getSessionDAO();
		int cnt = 0; 
		Transaction tx = session.beginTransaction();
		//sql 
		String hql = getSQlDeleteById(inputBean.getPathJSP());
		try {
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, inputBean.getMaDKM());
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
	public List<DotKhuyenMaiOutputRowBean> getById(DotKhuyenMaiInputBean inputBean){
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQLById(inputBean.getPathJSP());
		List<DotKhuyenMaiOutputRowBean> lst = new ArrayList<>();
		DotKhuyenMaiOutputRowBean outputRowBean;
		try {
			Transaction tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, inputBean.getMaDKM());
			List<Object[]> data = query.list();
			for (Object[] object : data) {
				outputRowBean = new DotKhuyenMaiOutputRowBean();
				outputRowBean.setMaDKM(SMSComons.convertString(object[0]));
				outputRowBean.setTenDKM(SMSComons.convertString(object[1]));
				outputRowBean.setLoaiKM(SMSComons.convertString(object[2]));
				outputRowBean.setMucKM(SMSComons.convertString(object[3]));
				outputRowBean.setDonViKM(SMSComons.convertString(object[4]));
				outputRowBean.setNgayBD(SMSComons.convertString(object[5]));
				outputRowBean.setNgayKT(SMSComons.convertString(object[6]));
				outputRowBean.setMoTa(SMSComons.convertString(object[7]));
				outputRowBean.setDk_loaiThe(SMSComons.convertString(object[8]));
				outputRowBean.setDk_tongHD(SMSComons.convertString(object[9]));
				outputRowBean.setDk_tongSL(SMSComons.convertString(object[10]));
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
	public List<DotKhuyenMaiOutputRowBean> getAll(String pathJSP) {
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQLAll(pathJSP);
		List<DotKhuyenMaiOutputRowBean> lst = new ArrayList<>();
		DotKhuyenMaiOutputRowBean outputRowBean;
		try {
			Transaction tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(hql);
			List<Object[]> data = query.list();
			for (Object[] object : data) {
				outputRowBean = new DotKhuyenMaiOutputRowBean();
				outputRowBean.setMaDKM(SMSComons.convertString(object[0]));
				outputRowBean.setTenDKM(SMSComons.convertString(object[1]));
				outputRowBean.setLoaiKM(SMSComons.convertString(object[2]));
				outputRowBean.setMucKM(SMSComons.convertString(object[3]));
				outputRowBean.setDonViKM(SMSComons.convertString(object[4]));
				outputRowBean.setNgayBD(SMSComons.convertString(object[5]));
				outputRowBean.setNgayKT(SMSComons.convertString(object[6]));
				outputRowBean.setMoTa(SMSComons.convertString(object[7]));
				outputRowBean.setDk_loaiThe(SMSComons.convertString(object[8]));
				outputRowBean.setDk_tongHD(SMSComons.convertString(object[9]));
				outputRowBean.setDk_tongSL(SMSComons.convertString(object[10]));
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
		String tableName = pathJSP+"_DOTKHUYENMAI";
		sb.append("  INSERT INTO "+tableName+" (    ");
		sb.append("  		 MA_DKM		       ");
		sb.append("  		,TEN_DKM 	           ");
		sb.append("  		,LOAI_KM         ");
		sb.append("  		,MUC_KM 	       ");
		sb.append("  		,DON_VI_KM 	       ");
		sb.append("  		,NGAY_BD         ");
		sb.append("  		,NGAY_KT         ");
		sb.append("  		,MOTA         ");
		sb.append("  		,DK_LOAI_THE         ");
		sb.append("  		,DK_TONG_HD 	       ");
		sb.append("  		,DK_TONG_SL     ");
		sb.append("  		)                  ");
		sb.append("  		VALUES (           ");
		sb.append("  		  ?                ");
		sb.append("  		 ,?                ");
		sb.append("  		 ,?                ");
		sb.append("  		 ,?                ");
		sb.append("  		 ,?                ");
		sb.append("  		 ,?                ");
		sb.append("  		 ,?                ");
		sb.append("  		 ,?                ");
		sb.append("  		 ,?                ");
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
		String tableName = pathJSP + "_DOTKHUYENMAI";
		sb.append("  UPDATE  "+tableName+"     		");
		sb.append("  		SET TEN_DKM 	= ?	        ");
		sb.append("  		,LOAI_KM 			= ?         			");
		sb.append("  		,MUC_KM 			= ?       			");
		sb.append("  		,DON_VI_KM 				= ?      	 			");
		sb.append("  		,NGAY_BD       		= ?  			");
		sb.append("  		,NGAY_KT      = ?   		");
		sb.append("  		,MOTA    = ?        ");
		sb.append("  		,DK_LOAI_THE  		= ?   				");
		sb.append("  		,DK_TONG_HD  	= ?   	");
		sb.append("  		,DK_TONG_SL  	= ?   	");
		sb.append("  		 WHERE MA_DKM = ?        ");
		return sb.toString();
	}
	
	/**
	 * getSQlMaxIdStoreOwner
	 * @return
	 */
	private String getSQLAll(String pathJSP) {
		String tableName = pathJSP + "_DOTKHUYENMAI";
		StringBuffer sb = new StringBuffer();
		sb.append("  SELECT                                 ");
		sb.append("  		 MA_DKM		       ");
		sb.append("  		,TEN_DKM 	           ");
		sb.append("  		,LOAI_KM         ");
		sb.append("  		,MUC_KM 	       ");
		sb.append("  		,DON_VI_KM 	       ");
		sb.append("  		,NGAY_BD         ");
		sb.append("  		,NGAY_KT         ");
		sb.append("  		,MOTA         ");	
		sb.append("  		,DK_LOAI_THE         ");
		sb.append("  		,DK_TONG_HD 	       ");
		sb.append("  		,DK_TONG_SL     ");
		sb.append("  FROM "+tableName+"          	");
		return sb.toString();
	}
	
	/**
	 * getSQlMaxIdStoreOwner
	 * @return
	 */
	private String getSQLById(String pathJSP) {
		String tableName = pathJSP + "_DOTKHUYENMAI";
		StringBuffer sb = new StringBuffer();
		sb.append("  SELECT                                 ");
		sb.append("  		 MA_DKM		       ");
		sb.append("  		,TEN_DKM 	           ");
		sb.append("  		,LOAI_KM         ");
		sb.append("  		,MUC_KM 	       ");
		sb.append("  		,DON_VI_KM 	       ");
		sb.append("  		,NGAY_BD         ");
		sb.append("  		,NGAY_KT         ");
		sb.append("  		,MOTA         ");
		sb.append("  		,DK_LOAI_THE         ");
		sb.append("  		,DK_TONG_HD 	       ");
		sb.append("  		,DK_TONG_SL     ");
		sb.append("  FROM "+tableName+"          			");
		sb.append("  WHERE MA_DKM = ?          			");
		return sb.toString();
	}
	
	
	/**
	 * 
	 * @return
	 */
	private String getSQlMaxId(String pathJSP) {
		String tableName = pathJSP+"_DOTKHUYENMAI";
		StringBuffer sb = new StringBuffer();
		sb.append("  SELECT MAX(MA_DKM) ");
		sb.append("  FROM "+tableName+"  ");
		return sb.toString();
	}
	
	/**
	 * getSQlDeleteById
	 * @return
	 */
	private String getSQlDeleteById(String pathJSP) {
		String tableName = pathJSP+"_DOTKHUYENMAI";
		StringBuffer sb = new StringBuffer();
		sb.append("  DELETE  ");
		sb.append("  FROM "+tableName+"  ");
		sb.append("  WHERE MA_DKM = ?  ");
		return sb.toString();
	}
	

	// ----------------------------------------------------------------------------------------------------------

	
	/**
	 * create table product 
	 * @return
	 */
	private String getSQLCreateTable(String pathJSP) {
		StringBuffer sb = new StringBuffer();
		String tableName = pathJSP+"_DOTKHUYENMAI";
		sb.append(" CREATE TABLE "+tableName+ " (        ");
		sb.append("  MA_DKM	VARCHAR (255)           ");
		sb.append(" ,TEN_DKM	VARCHAR (255)           ");
		sb.append(" ,LOAI_KM 		VARCHAR(255)                  ");
		sb.append(" ,MUC_KM 		VARCHAR(255)                  ");
		sb.append(" ,DON_VI_KM 		VARCHAR(255)                     ");
		sb.append(" ,NGAY_BD 			VARCHAR(255)                     ");
		sb.append(" ,NGAY_KT  		VARCHAR(255)                  ");
		sb.append(" ,MOTA  		VARCHAR(255)                  ");
		sb.append(" ,DK_LOAI_THE 	VARCHAR(255)             ");
		sb.append(" ,DK_TONG_HD 		VARCHAR(255)                  ");
		sb.append(" ,DK_TONG_SL 		VARCHAR(255)                  ");
		sb.append(" 	)                                ");
		return sb.toString();
	}
	
	/**
	 * delete table product
	 * @return
	 */
	private String getSQLDeleteTable(String pathJSP) {
		StringBuffer sb = new StringBuffer();
		String tableName = pathJSP+"_DOTKHUYENMAI";
		sb.append("   DROP TABLE "+tableName+"            ");
		return sb.toString();
	}
	
	public static void main(String[] args) {
		DotKhuyenMaiDAO cr = new DotKhuyenMaiDAO();
		/*DotKhuyenMaiInputBean inputBean = new DotKhuyenMaiInputBean();
		inputBean.setMaDKM(outputRowBean.getMaDKM());
		inputBean.setTenDKM(outputRowBean.getTenDKM());
		inputBean.setLoaiKM(outputRowBean.getLoaiKM());
		inputBean.setNgayBD(outputRowBean.getNgayBD());
		inputBean.setMucGiamGia(outputRowBean.getMaDKM() + " " + outputRowBean.getDonViKM());
		inputBean.setDk_loaiThe(outputRowBean.getDk_loaiThe());
		inputBean.setDk_tongHD(outputRowBean.getDk_tongHD());
		inputBean.setDk_tongSL(outputRowBean.getDk_tongSL());ow.setNo(String.valueOf(cnt++));
		inputBean.setMaDKM(outputRowBean.getMaDKM());
		inputBean.setTenDKM(outputRowBean.getTenDKM());
		inputBean.setLoaiKM(outputRowBean.getLoaiKM());
		inputBean.setNgayBD(outputRowBean.getNgayBD());
		inputBean.setMucGiamGia(outputRowBean.getMaDKM() + " " + outputRowBean.getDonViKM());
		inputBean.setDk_loaiThe(outputRowBean.getDk_loaiThe());
		inputBean.setDk_tongHD(outputRowBean.getDk_tongHD());
		inputBean.setDk_tongSL(outputRowBean.getDk_tongSL());
		cr.insert("cuahangthoitrang");*/
		
//		List<DotKhuyenMaiOutputRowBean> lst =  cr.getAll("cuahangthoitrang");
//		System.out.println("size : " +lst.size());
		//cr.createTable("cuahangthoitrang");
		cr.createTable("cuahangthoitrang");
	}
}
