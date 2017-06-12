/*package com.sms.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sms.OutputRows.HoaDonOutputRowBean;
import com.sms.common.SMSComons;
import com.sms.dao.common.HibernateUtil;
import com.sms.input.HoaDonInputBean;

public class HoaDonDAO {	
	
	public static HoaDonDAO intances = new HoaDonDAO();
	
	*//**
	 * function mean create table product by pathJSP of store
	 * 
	 *//*
	public int createTable(String pathJSP){
		//session
		Session session = HibernateUtil.getSessionDAO();
		int cnt = 0; 
		Transaction tx = HibernateUtil.getSessionDAO().beginTransaction();
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
	
	*//**
	 * function mean detele table product by pathJSP of store
	 * 
	 *//*
	public int deleteTable(String pathJSP){
		//session
		Session session = HibernateUtil.getSessionDAO();
		int cnt = 0; 
		Transaction tx = HibernateUtil.getSessionDAO().beginTransaction();
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
	
	*//**
	 * function insert
	 * 
	 *//*
	public int insert(HoaDonInputBean inputBean){
		//session
		Session session = HibernateUtil.getSessionDAO();
		int cnt = 0; 
		Transaction tx = HibernateUtil.getSessionDAO().beginTransaction();
		//id
		int id = SMSComons.convertInt(this.getMaxId(inputBean.getPathJSP()));
		//sql 
		String hql = getSQLInsert(inputBean.getPathJSP());
		try {
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, (id + 1));
			query.setParameter(1, inputBean.getIdKhachHang());
			query.setParameter(2, inputBean.getNgayLap());
			query.setParameter(3, inputBean.getSoLuongSP());
			query.setParameter(4, inputBean.getDiemTichLuy());
			query.setParameter(5, inputBean.getTongDiemTichLuy());
			query.setParameter(6, inputBean.getTienKhuyenMai());
			query.setParameter(7, inputBean.getTongTien());
			cnt = query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}
		return cnt;
	}
	
	*//**
	 * function update 
	 * 
	 *//*
	public int update(HoaDonInputBean inputBean){
		//session
		Session session = HibernateUtil.getSessionDAO();
		int cnt = 0; 
		Transaction tx = HibernateUtil.getSessionDAO().beginTransaction();
		//sql 
		String hql = getSQLUpdate(inputBean.getPathJSP());
		try {
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, inputBean.getIdKhachHang());
			query.setParameter(1, inputBean.getNgayLap());
			query.setParameter(2, inputBean.getSoLuongSP());
			query.setParameter(3, inputBean.getDiemTichLuy());
			query.setParameter(4, inputBean.getTongDiemTichLuy());
			query.setParameter(5, inputBean.getTienKhuyenMai());
			query.setParameter(6, inputBean.getTongTien());
			query.setParameter(7, inputBean.getIdHoaDon());
			cnt = query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}
		return cnt;
	}
	
	*//**
	 * function delete 
	 * 
	 *//*
	public int deleteById(HoaDonInputBean inputBean){
		//session
		Session session = HibernateUtil.getSessionDAO();
		int cnt = 0; 
		Transaction tx = HibernateUtil.getSessionDAO().beginTransaction();
		//sql 
		String hql = getSQlDeleteById(inputBean.getPathJSP());
		try {
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, inputBean.getIdHoaDon());
			cnt = query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}
		return cnt;
	}
	
	
	*//**
	 * 
	 * 
	 * @return
	 *//*
	private String getMaxId(String pathJSP) {
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQlMaxId(pathJSP);
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
	*//**
	 * 
	 * 
	 * @return
	 * @throws IOException 
	 *//*
	public List<HoaDonOutputRowBean> getById(HoaDonInputBean inputBean){
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQLById(inputBean.getPathJSP());
		List<HoaDonOutputRowBean> lst = new ArrayList<>();
		HoaDonOutputRowBean outputRowBean;
		try {
			session.getTransaction().begin();
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, inputBean.getIdHoaDon());
			List<Object[]> data = query.list();
			for (Object[] object : data) {
				outputRowBean = new HoaDonOutputRowBean();
				outputRowBean.setIdHoaDon(SMSComons.convertString(object[0]));
				outputRowBean.setIdKhachHang(SMSComons.convertString(object[1]));
				outputRowBean.setNgayLap(SMSComons.convertString(object[2]));
				outputRowBean.setSoLuongSP(SMSComons.convertString(object[3]));
				outputRowBean.setDiemTichLuy(SMSComons.convertString(object[4]));
				outputRowBean.setTongDiemTichLuy(SMSComons.convertString(object[5]));
				outputRowBean.setTienKhuyenMai(SMSComons.convertString(object[6]));
				outputRowBean.setTongTien(SMSComons.convertString(object[7]));
				lst.add(outputRowBean);
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
		return lst;
	}
	
	*//**
	 * 
	 * 
	 * @return
	 * @throws IOException 
	 *//*
	public List<HoaDonOutputRowBean> getAll(String pathJSP) {
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQLAll(pathJSP);
		List<HoaDonOutputRowBean> lst = new ArrayList<>();
		HoaDonOutputRowBean outputRowBean;
		try {
			session.getTransaction().begin();
			SQLQuery query = session.createSQLQuery(hql);
			List<Object[]> data = query.list();
			for (Object[] object : data) {
				outputRowBean = new HoaDonOutputRowBean();
				outputRowBean.setIdHoaDon(SMSComons.convertString(object[0]));
				outputRowBean.setIdKhachHang(SMSComons.convertString(object[1]));
				outputRowBean.setNgayLap(SMSComons.convertString(object[2]));
				outputRowBean.setSoLuongSP(SMSComons.convertString(object[3]));
				outputRowBean.setDiemTichLuy(SMSComons.convertString(object[4]));
				outputRowBean.setTongDiemTichLuy(SMSComons.convertString(object[5]));
				outputRowBean.setTienKhuyenMai(SMSComons.convertString(object[6]));
				outputRowBean.setTongTien(SMSComons.convertString(object[7]));
				lst.add(outputRowBean);
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
		return lst;
	}
	
	// ----------------------------------------------------------------------------------------------------------
	
	
	
	*//**
	 * insert  product
	 * @return
	 *//*
	private String getSQLInsert(String pathJSP) {
		StringBuffer sb = new StringBuffer();
		String tableName = pathJSP+"_HOADON";
		sb.append("  INSERT INTO "+tableName+" (    ");
		sb.append("  		 ID_HOADON		       ");
		sb.append("  		,ID_KHACHHANG 	           ");
		sb.append("  		,NGAY_LAP         ");
		sb.append("  		,SO_LUONG_SP 	       ");
		sb.append("  		,DIEM_TICH_LUY 	       ");
		sb.append("  		,TONG_DIEM_TICH_LUY         ");
		sb.append("  		,TIEN_KHUYEN_MAI         ");
		sb.append("  		,TONG_TIEN         ");
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
		sb.append("  		)                  ");
		
		return sb.toString();
	}	
	
	*//**
	 * update  product
	 * @return
	 *//*
	private String getSQLUpdate(String pathJSP) {
		StringBuffer sb = new StringBuffer();
		String tableName = pathJSP+"_HOADON";
		sb.append("  UPDATE  "+tableName+"     		");
		sb.append("  		SET ID_KHACHHANG 	= ?	        ");
		sb.append("  		,SO_LUONG_SP 			= ?         			");
		sb.append("  		,DIEM_TICH_LUY 			= ?       			");
		sb.append("  		,TONG_DIEM_TICH_LUY 				= ?      	 			");
		sb.append("  		,TIEN_KHUYEN_MAI       		= ?  			");
		sb.append("  		,TONG_TIEN      = ?   		");
		sb.append("  		 WHERE ID_HOADON = ?        ");
		return sb.toString();
	}
	
	*//**
	 * 
	 * @return
	 *//*
	private String getSQLAll(String pathJSP) {
		String tableName = pathJSP+"_HOADON";
		StringBuffer sb = new StringBuffer();
		sb.append("  SELECT                                 ");
		sb.append("   ID_HOADON		                            ");
		sb.append("  ,ID_KHACHHANG 	                            ");
		sb.append("  ,NGAY_LAP                            ");
		sb.append("  ,SO_LUONG_SP                            ");
		sb.append("  ,DIEM_TICH_LUY 	                            ");
		sb.append("  ,TONG_DIEM_TICH_LUY 	                            ");
		sb.append("  ,TIEN_KHUYEN_MAI                                  ");
		sb.append("  ,TONG_TIEN                                 ");
		sb.append("  FROM "+tableName+"          	");
		return sb.toString();
	}
	
	*//**
	 * 
	 * @return
	 *//*
	private String getSQLById(String pathJSP) {
		String tableName = pathJSP+"_HOADON";
		StringBuffer sb = new StringBuffer();
		sb.append("  SELECT                                 ");
		sb.append("   ID_HOADON		                            ");
		sb.append("  ,ID_KHACHHANG 	                            ");
		sb.append("  ,NGAY_LAP                            ");
		sb.append("  ,SO_LUONG_SP                            ");
		sb.append("  ,DIEM_TICH_LUY 	                            ");
		sb.append("  ,TONG_DIEM_TICH_LUY 	                            ");
		sb.append("  ,TIEN_KHUYEN_MAI                                  ");
		sb.append("  ,TONG_TIEN                                 ");
		sb.append("  FROM "+tableName+"          			");
		sb.append("  WHERE ID_HOADON = ?          			");
		return sb.toString();
	}
	
	
	*//**
	 * 
	 * @return
	 *//*
	private String getSQlMaxId(String pathJSP) {
		String tableName = pathJSP+"_HOADON";
		StringBuffer sb = new StringBuffer();
		sb.append("  SELECT MAX(ID_HOADON) ");
		sb.append("  FROM "+tableName+"  ");
		return sb.toString();
	}
	
	*//**
	 * getSQlDeleteById
	 * @return
	 *//*
	private String getSQlDeleteById(String pathJSP) {
		String tableName = pathJSP+"_HOADON";
		StringBuffer sb = new StringBuffer();
		sb.append("  DELETE  ");
		sb.append("  FROM "+tableName+"  ");
		sb.append("  WHERE ID_HOADON = ?  ");
		return sb.toString();
	}
	

	
	*//**
	 * create table product 
	 * @return
	 *//*
	private String getSQLCreateTable(String pathJSP) {
		StringBuffer sb = new StringBuffer();
		String tableName = pathJSP+"_HOADON";
		sb.append(" CREATE TABLE "+tableName+ " (        ");
		sb.append("  ID_HOADON	VARCHAR (6)              ");
		sb.append(" ,ID_KHACHHANG	VARCHAR (6)              ");
		sb.append(" ,NGAY_LAP VARCHAR(8)                ");
		sb.append(" ,SO_LUONG_SP  VARCHAR(12)               ");
		sb.append(" ,DIEM_TICH_LUY VARCHAR(12)                 ");
		sb.append(" ,TONG_DIEM_TICH_LUY VARCHAR(12)            ");
		sb.append(" ,TIEN_KHUYEN_MAI VARCHAR(12)            ");
		sb.append(" ,TONG_TIEN VARCHAR(12)          ");
		sb.append(" 	)                                ");
		return sb.toString();
	}
	
	
	*//**
	 * delete table product
	 * @return
	 *//*
	private String getSQLDeleteTable(String pathJSP) {
		StringBuffer sb = new StringBuffer();
		String tableName = pathJSP+"_HOADON";
		sb.append("   DROP TABLE "+tableName+"            ");
		return sb.toString();
	}	
	public static void main(String[] args) {
//		HoaDonDAO cr = new HoaDonDAO();
//		cr.createTable("cuahangthoitrang");
	}
}
*/