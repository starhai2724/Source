package com.sms.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sms.OutputRows.ChiTietHoaDonOutputRowBean;
import com.sms.OutputRows.KhachHangOutputRowBean;
import com.sms.common.SMSComons;
import com.sms.dao.common.HibernateUtil;
import com.sms.input.ChiTietDatHangInputBean;
import com.sms.input.DatHangInputBean;
import com.sms.input.KhachHangInputBean;
import com.sms.input.SanPhamInputBean;
import com.sms.output.ChiTietDatHangOutputBean;
import com.sms.output.DanhSachCuaHangOuputBean;
import com.sms.output.DatHangOutputBean;
import com.sms.output.DatHangOutputRowBean;
import com.sms.output.KhoHangOutBean;

public class KhoHangDAO {
	
	public static KhoHangDAO intances = new KhoHangDAO();
	
	/**
	 * function mean create table product by pathJSP of store
	 * 
	 */
	public int createTableDonHang(String pathJSP){
		//session
		Session session = HibernateUtil.getSessionDAO();
		int cnt = 0; 
		Transaction tx = session.beginTransaction();
		//sql
		String hql = this.getSQLCreateTableDonHang(pathJSP);
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
	 * function mean create table product by pathJSP of store
	 * 
	 */
	public int createTableChiTietDonHang(String pathJSP){
		//session
		Session session = HibernateUtil.getSessionDAO();
		int cnt = 0; 
		Transaction tx = session.beginTransaction();
		//sql
		String hql = this.getSQLCreateTableChiTietDonHang(pathJSP);
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
	 * function mean create table product by pathJSP of store
	 * 
	 */
	public int createTableKhoHang(String pathJSP){
		//session
		Session session = HibernateUtil.getSessionDAO();
		int cnt = 0; 
		Transaction tx = session.beginTransaction();
		//sql
		String hql = this.getSQLCreateTableKhoHang(pathJSP);
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
	 * function mean create table product by pathJSP of store
	 * 
	 */
	public int createTable(String pathJSP){
		int cnt = 0;
		try {
			cnt = createTableDonHang(pathJSP);
			
			cnt = createTableChiTietDonHang(pathJSP);
			
			cnt = createTableKhoHang(pathJSP);
			
		} catch (Exception e) {
			cnt = 1;
		}
		return cnt;
	}
	
	/**
	 * 
	 * 
	 * @return
	 * @throws IOException 
	 */
	public DatHangOutputBean getAll(String pathJSP) {
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQLDatHang(pathJSP);
		DatHangOutputBean outputBean = new DatHangOutputBean();
		List<DatHangOutputRowBean> lst = outputBean.getDatHangOutputRowBeans();
		DatHangOutputRowBean outputRowBean;
		try {
			Transaction tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(hql);
			List<Object[]> data = query.list();
			for (Object[] object : data) {
				outputRowBean = new DatHangOutputRowBean();
				outputRowBean.setIdDonHang(SMSComons.convertString(object[0]));
				outputRowBean.setSoLuong(SMSComons.convertString(object[1]));
				outputRowBean.setThanhTien(SMSComons.convertString(object[2]));
				outputRowBean.setNgayDatHang(SMSComons.convertString(object[3]));
				outputRowBean.setNgayNhanHang(SMSComons.convertString(object[4]));
				outputRowBean.setTrangThai(SMSComons.convertString(object[5]));
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
		return outputBean;
	}
	/**
	 * 
	 * 
	 * @return
	 * @throws IOException 
	 */
	public DatHangOutputBean getAllByPathJSPAndTrangThai(String pathJSP, String trangThai) {
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQLDatHangByPathJSP(pathJSP);
		DatHangOutputBean outputBean = new DatHangOutputBean();
		List<DatHangOutputRowBean> lst = outputBean.getDatHangOutputRowBeans();
		DatHangOutputRowBean outputRowBean;
		try {
			Transaction tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, pathJSP);
			query.setParameter(1, trangThai);
			List<Object[]> data = query.list();
			for (Object[] object : data) {
				outputRowBean = new DatHangOutputRowBean();
				outputRowBean.setIdDonHang(SMSComons.convertString(object[0]));
				outputRowBean.setSoLuong(SMSComons.convertString(object[1]));
				outputRowBean.setThanhTien(SMSComons.convertString(object[2]));
				outputRowBean.setNgayDatHang(SMSComons.convertString(object[3]));
				outputRowBean.setNgayNhanHang(SMSComons.convertString(object[4]));
				outputRowBean.setTrangThai(SMSComons.convertString(object[5]));
				outputRowBean.setTenCuaHang(SMSComons.convertString(object[6]));
				outputRowBean.setDiaChiCH(SMSComons.convertString(object[7]));
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
		return outputBean;
	}
	
	/**
	 * 
	 * 
	 * @return
	 * @throws IOException 
	 */
	public List<KhoHangOutBean> getAllKhoHang(String pathJSP) {
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQLKhoHang(pathJSP);
		List<KhoHangOutBean> lst = new ArrayList<>();
		KhoHangOutBean outputRowBean;
		try {
			Transaction tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(hql);
			List<Object[]> data = query.list();
			for (Object[] object : data) {
				outputRowBean = new KhoHangOutBean();
				outputRowBean.setIdSanPham(SMSComons.convertString(object[0]));
				outputRowBean.setSoLuong(SMSComons.convertString(object[1]));
				outputRowBean.setTenSp(SMSComons.convertString(object[2]));
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
	public KhoHangOutBean getAllKhoHangByIdSanPham(String pathJSP, String id) {
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQLKhoHangByIdSanPham(pathJSP);
		KhoHangOutBean outputRowBean = null;
		try {
			Transaction tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, id);
			List<Object[]> data = query.list();
			for (Object[] object : data) {
				outputRowBean = new KhoHangOutBean();
				outputRowBean.setIdSanPham(SMSComons.convertString(object[0]));
				outputRowBean.setSoLuong(SMSComons.convertString(object[1]));
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
		return outputRowBean;
	}
	
	
	/**
	 * 
	 * 
	 * @return
	 * @throws IOException 
	 */
	public KhoHangOutBean getAllKhoHangBySEQ(String pathJSP, String id) {
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQLKhoHangBySEQ(pathJSP);
		KhoHangOutBean outputRowBean = null;
		try {
			Transaction tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, id);
			List<Object[]> data = query.list();
			for (Object[] object : data) {
				outputRowBean = new KhoHangOutBean();
				outputRowBean.setIdSanPham(SMSComons.convertString(object[0]));
				outputRowBean.setSoLuong(SMSComons.convertString(object[1]));
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
		return outputRowBean;
	}
	
	/**
	 * function insert
	 * 
	 */
	public int updateKhoHang(String pathJSP, String id, String sl){
		//session
		Session session = HibernateUtil.getSessionDAO();
		int cnt = 0; 
		Transaction tx = session.beginTransaction();
		//sql 
		String hql = getSQLUpdateKhoHang(pathJSP);
		
		try {
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, sl);
			query.setParameter(1, id);
			
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
	public int insertKhoHang(String pathJSP, String id, String sl){
		//session
		Session session = HibernateUtil.getSessionDAO();
		int cnt = 0; 
		Transaction tx = session.beginTransaction();
		//sql 
		String hql = getSQLInsertKhoHang(pathJSP);
		
		try {
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, sl);
			query.setParameter(1, id);
			
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
	public int deleteKhoHangByIdSP(String pathJSP, String idSP){
		//session
		Session session = HibernateUtil.getSessionDAO();
		int cnt = 0; 
		Transaction tx = session.beginTransaction();
		//sql 
		String hql = getSQlDeleteKhoHangByIdSP(pathJSP);
		try {
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, idSP);
			cnt = query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
		} finally {
			session.flush();
			session.clear();
			session.close();
		}
		return cnt;
	}
	
	
	/**
	 * 
	 * 
	 * @return
	 * @throws IOException 
	 */
	public List<DanhSachCuaHangOuputBean> getDanhSachCuaHang() {
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQLDanhSachCuaHang();
		List<DanhSachCuaHangOuputBean> lst = new ArrayList<>();
		DanhSachCuaHangOuputBean outputRowBean;
		try {
			Transaction tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(hql);
			List<Object[]> data = query.list();
			for (Object[] object : data) {
				outputRowBean = new DanhSachCuaHangOuputBean();
				outputRowBean.setIdStore(SMSComons.convertString(object[0]));
				outputRowBean.setTenCuaHang(SMSComons.convertString(object[1]));
				outputRowBean.setPathJSP(SMSComons.convertString(object[2]));
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
	public List<ChiTietDatHangOutputBean> getChiTietHDonHangByIdDonHang(String pathJSP, String id) {
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQLChiTietHDonHangByIdDonHang(pathJSP);
		List<ChiTietDatHangOutputBean> chiTietDatHangOutputBeans = new ArrayList<>();
		ChiTietDatHangOutputBean outputRowBean;
		try{
			Transaction tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, id);
			List<Object[]> data = query.list();
			for (Object[] object : data) {
				outputRowBean = new ChiTietDatHangOutputBean();
				outputRowBean.setIdDotHang(SMSComons.convertString(object[0]));
				outputRowBean.setIdSanPham(SMSComons.convertString(object[1]));
				outputRowBean.setTenSanPham(SMSComons.convertString(object[2]));
				outputRowBean.setSoLuongNhap(SMSComons.convertString(object[3]));
				outputRowBean.setGiaNhap(SMSComons.convertString(object[4]));
				outputRowBean.setDiaChi(SMSComons.convertString(object[6]));
				outputRowBean.setSEQ(SMSComons.convertString(object[7]));
				
				chiTietDatHangOutputBeans.add(outputRowBean);
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
		return chiTietDatHangOutputBeans;
	}
	
	/**
	 * 
	 * 
	 * @return
	 * @throws IOException 
	 */
	public List<ChiTietDatHangOutputBean> getChiTietHDonHangByIdDonHangAndIdSanPham(String pathJSP, String id, String idSP) {
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQLChiTietHDonHangByIdDonHangAndIdSP(pathJSP);
		List<ChiTietDatHangOutputBean> chiTietDatHangOutputBeans = new ArrayList<>();
		ChiTietDatHangOutputBean outputRowBean;
		try{
			Transaction tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, id);
			query.setParameter(1, idSP);
			List<Object[]> data = query.list();
			for (Object[] object : data) {
				outputRowBean = new ChiTietDatHangOutputBean();
				outputRowBean.setIdDotHang(SMSComons.convertString(object[0]));
				outputRowBean.setIdSanPham(SMSComons.convertString(object[1]));
				outputRowBean.setTenSanPham(SMSComons.convertString(object[2]));
				outputRowBean.setSoLuongNhap(SMSComons.convertString(object[3]));
				outputRowBean.setGiaNhap(SMSComons.convertString(object[4]));
				outputRowBean.setDiaChi(SMSComons.convertString(object[6]));
				
				chiTietDatHangOutputBeans.add(outputRowBean);
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
		return chiTietDatHangOutputBeans;
	}
	
	/**
	 * function insert
	 * 
	 */
	public int insertDonHang(DatHangInputBean inputBean){
		//session
		Session session = HibernateUtil.getSessionDAO();
		int cnt = 0; 
		Transaction tx = session.beginTransaction();
		//id
		int idDonHang = SMSComons.convertInt(this.getMaxIdDonHang(inputBean.getPathJSP()));
		//sql 
		String hql = getSQLInsert(inputBean.getPathJSP());
		try {
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, (idDonHang + 1));
			query.setParameter(1, inputBean.getSoLuong());
			query.setParameter(2, inputBean.getThanhTien());
			query.setParameter(3, inputBean.getNgayDatHang());
			query.setParameter(4, inputBean.getNgayNhanHang());
			query.setParameter(5, inputBean.getTrangThai());
			
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
	public int updateDonHang(DatHangInputBean inputBean){
		//session
		Session session = HibernateUtil.getSessionDAO();
		int cnt = 0; 
		Transaction tx = session.beginTransaction();
		//sql 
		String hql = getSQLUpdate(inputBean.getPathJSP());
		
		try {
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, inputBean.getSoLuong());
			query.setParameter(1, inputBean.getThanhTien());
			query.setParameter(2, inputBean.getNgayNhanHang());
			query.setParameter(3, inputBean.getTrangThai());
			query.setParameter(4, inputBean.getIdDonHang());
			
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
	public int updateDonHang_XacNhan(DatHangInputBean inputBean){
		//session
		Session session = HibernateUtil.getSessionDAO();
		int cnt = 0; 
		Transaction tx = session.beginTransaction();
		//sql 
		String hql = getSQLUpdate_XacNhan(inputBean.getPathJSP());
		try {
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, inputBean.getTrangThai());
			query.setParameter(1, inputBean.getNgayNhanHang());
			query.setParameter(2, inputBean.getIdDonHang());
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
	public int insertChiTietDonHang(ChiTietDatHangInputBean inputBean){
		//session
		Session session = HibernateUtil.getSessionDAO();
		int cnt = 0; 
		Transaction tx = session.beginTransaction();
		//sql 
		String hql = getSQLInsertChiTietDonHang(inputBean.getPathJSP());
		try {
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, inputBean.getIdDotHang());
			query.setParameter(1, inputBean.getIdSanPham());
			query.setParameter(2, inputBean.getSoLuongNhap());
			query.setParameter(3, inputBean.getGiaNhap());
			query.setParameter(4, "0");
			query.setParameter(5, inputBean.getDiaChi());
			
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
	public int updateChiTietDonHang(ChiTietDatHangInputBean inputBean){
		//session
		Session session = HibernateUtil.getSessionDAO();
		int cnt = 0; 
		Transaction tx = session.beginTransaction();
		//sql 
		String hql = getSQLUpdateChiTietDonHang(inputBean.getPathJSP());
		try {
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, inputBean.getSoLuongNhap());
			query.setParameter(1, inputBean.getGiaNhap());
			query.setParameter(2, inputBean.getDiaChi());
			query.setParameter(3, inputBean.getIdDotHang());
			query.setParameter(4, inputBean.getIdSanPham());
			
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
	public String getMaxIdDonHang(String pathJSP) {
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQlMaxIdDonHang(pathJSP);
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
	 * function delete 
	 * 
	 */
	public int deleteByIdDonHang(String pathJSP,  String id){
		//session
		Session session = HibernateUtil.getSessionDAO();
		int cnt = 0; 
		Transaction tx = session.beginTransaction();
		//sql 
		String hql = getSQlDeleteByIdDonHang(pathJSP);
		try {
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, id);
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
	public int deleteChiTietDonHangByIdDonHang(String pathJSP,  String id){
		//session
		Session session = HibernateUtil.getSessionDAO();
		int cnt = 0; 
		Transaction tx = session.beginTransaction();
		//sql 
		String hql = getSQlDeleteChiTietDonHang(pathJSP);
		try {
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, id);
			cnt = query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}
		return cnt;
	}
	//------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * create table product 
	 * @return
	 */
	private String getSQLCreateTableDonHang(String pathJSP) {
		StringBuffer sb = new StringBuffer();
		String tableName = pathJSP+"_DONHANG";
		sb.append(" CREATE TABLE "+tableName+ " (        ");
		sb.append("  ID_DONHANG	INT (6)           ");
		sb.append(" ,SO_LUONG	VARCHAR (255)         ");
		sb.append(" ,THANH_TIEN	VARCHAR (255)         ");
		sb.append(" ,NGAY_DH	VARCHAR (255)         ");
		sb.append(" ,NGAY_NHAN	VARCHAR (255)         ");
		sb.append(" ,TRANG_THAI 		VARCHAR(6)                  ");
		sb.append(" 	)                                ");
		return sb.toString();
	}
	
	/**
	 * create table product 
	 * @return
	 */
	private String getSQLCreateTableChiTietDonHang(String pathJSP) {
		StringBuffer sb = new StringBuffer();
		String tableName = pathJSP+"_CHITIETDONHANG";
		sb.append(" CREATE TABLE "+tableName+ " (        ");
		sb.append("  ID_DONHANG	    INT (6)           ");
		sb.append(" ,ID_SANPHAM	    VARCHAR (12)         ");
		sb.append(" ,SL_NHAP 		VARCHAR(12)                  ");
		sb.append(" ,GIA_NHAP 		VARCHAR(12)                  ");
		sb.append(" ,SL_SP_KHO 		VARCHAR(12)                  ");
		sb.append(" ,DIA_CHI 		VARCHAR(255)                  ");
		sb.append(" 	)                                ");
		return sb.toString();
	}
	
	/**
	 * create table product 
	 * @return
	 */
	private String getSQLCreateTableKhoHang(String pathJSP) {
		StringBuffer sb = new StringBuffer();
		String tableName = pathJSP+"_KHOHANG";
		sb.append(" CREATE TABLE "+tableName+ " (        ");
		sb.append("  ID_SP	    	VARCHAR (12)           ");
		sb.append(" ,SO_LUONG	    VARCHAR (12)         ");
		sb.append(" 	)                                ");
		return sb.toString();
	}
	
	/**
	 * getSQlMaxIdStoreOwner
	 * @return
	 */
	private String getSQLDatHang(String pathJSP) {
		String tableName = pathJSP+"_DONHANG";
		StringBuffer sb = new StringBuffer();
		sb.append("  SELECT                                 ");
		sb.append("   ID_DONHANG		                            ");
		sb.append("  ,SO_LUONG 	                            ");
		sb.append("  ,THANH_TIEN                            ");
		sb.append("  ,NGAY_DH                            ");
		sb.append("  ,NGAY_NHAN 	                            ");
		sb.append("  ,TRANG_THAI                                  ");
		sb.append("  FROM "+tableName+"          	");
		sb.append(" ORDER BY NGAY_DH DESC                         ");
		return sb.toString();
	}
	
	/**
	 * getSQlMaxIdStoreOwner
	 * @return
	 */
	private String getSQLDatHangByPathJSP(String pathJSP) {
		String tableName = pathJSP+"_DONHANG";
		StringBuffer sb = new StringBuffer();                  
		sb.append(" SELECT                                     ");
		sb.append("  DONHANG.ID_DONHANG		                   ");
		sb.append(" ,DONHANG.SO_LUONG 	                       ");
		sb.append(" ,DONHANG.THANH_TIEN                        ");
		sb.append(" ,DONHANG.NGAY_DH                           ");
		sb.append(" ,DONHANG.NGAY_NHAN 	                       ");
		sb.append(" ,DONHANG.TRANG_THAI                        ");
		sb.append(" ,SI.STORENAME                              ");
		sb.append(" ,SI.ADDRESS                                ");
		sb.append(" FROM "+tableName+ " DONHANG      ");
		sb.append(" INNER JOIN store_info SI                   ");
		sb.append(" ON SI.PATHJSP = ?                         ");
		sb.append(" WHERE  DONHANG.TRANG_THAI = ?                         ");
		sb.append(" ORDER BY DONHANG.NGAY_DH DESC                         ");
		return sb.toString();
	}
	
	/**
	 * insert  product
	 * @return
	 */
	private String getSQLInsertChiTietDonHang(String pathJSP) {
		StringBuffer sb = new StringBuffer();
		String tableName = pathJSP+"_CHITIETDONHANG";
		sb.append("  INSERT INTO "+tableName+" (    ");
		sb.append("  		 ID_DONHANG		       ");
		sb.append("  		,ID_SANPHAM 	           ");
		sb.append("  		,SL_NHAP         ");
		sb.append("  		,GIA_NHAP 	       ");
		sb.append("  		,SL_SP_KHO 	       ");
		sb.append("  		,DIA_CHI         ");
		sb.append("  		)                  ");
		sb.append("  		VALUES (           ");
		sb.append("  		  ?                ");
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
	private String getSQLUpdateChiTietDonHang(String pathJSP) {
		StringBuffer sb = new StringBuffer();
		String tableName = pathJSP+"_CHITIETDONHANG";
		sb.append("  UPDATE  "+tableName+"     		");
		sb.append("  		SET SL_NHAP 	= ?	        ");
		sb.append("  		,GIA_NHAP 			= ?       			");
		sb.append("  		,DIA_CHI 				= ?      	 			");
		sb.append("  		 WHERE ID_DONHANG = ?        ");
		sb.append("  		 AND ID_SANPHAM = ?        ");
		return sb.toString();
	}
	
	
	/**
	 * insert  product
	 * @return
	 */
	private String getSQLInsert(String pathJSP) {
		StringBuffer sb = new StringBuffer();
		String tableName = pathJSP+"_DONHANG";
		sb.append("  INSERT INTO "+tableName+" (    ");
		sb.append("  		 ID_DONHANG		       ");
		sb.append("  		,SO_LUONG 	           ");
		sb.append("  		,THANH_TIEN         ");
		sb.append("  		,NGAY_DH 	       ");
		sb.append("  		,NGAY_NHAN 	       ");
		sb.append("  		,TRANG_THAI         ");
		sb.append("  		)                  ");
		sb.append("  		VALUES (           ");
		sb.append("  		  ?                ");
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
		String tableName = pathJSP+"_DONHANG";
		sb.append("  UPDATE  "+tableName+"     		");
		sb.append("  		SET SO_LUONG 	= ?	        ");
		sb.append("  		,THANH_TIEN 			= ?         			");
		sb.append("  		,NGAY_NHAN 			= ?       			");
		sb.append("  		,TRANG_THAI 				= ?      	 			");
		sb.append("  		 WHERE ID_DONHANG = ?        ");
		return sb.toString();
	}
	
	/**
	 * update  product
	 * @return
	 */
	private String getSQLUpdate_XacNhan(String pathJSP) {
		StringBuffer sb = new StringBuffer();
		String tableName = pathJSP+"_DONHANG";
		sb.append("  UPDATE  "+tableName+"     		");
		sb.append("  		SET TRANG_THAI 	= ?	        ");
		sb.append("  		, NGAY_NHAN 	= ?	        ");
		sb.append("  		 WHERE ID_DONHANG = ?        ");
		return sb.toString();
	}
	
	/**
	 * insert  product
	 * @return
	 */
	private String getSQLChiTietHDonHangByIdDonHang(String pathJSP) {
		StringBuffer sb = new StringBuffer();
		String tableName = pathJSP+"_CHITIETDONHANG";                                                         
		sb.append("  	SELECT                                                                             ");
		sb.append("  	CTDH.ID_DONHANG,                                                                   ");
		sb.append("  	CTDH.ID_SANPHAM,                                                                   ");
		sb.append("  	PRODUCT.TEN_SP,                                                                    ");
		sb.append("  	CTDH.SL_NHAP,                                                                      ");
		sb.append("  	CTDH.GIA_NHAP,                                                                     ");
		sb.append("  	CTDH.SL_SP_KHO,                                                                    ");
		sb.append("  	CTDH.DIA_CHI,                                                                      ");
		sb.append("  	PRODUCT.SEQ                                                                      ");
		sb.append("  FROM                                                                                  ");
		sb.append("  	" + tableName+ " CTDH                                               ");
		sb.append("  LEFT JOIN "+pathJSP+"_product PRODUCT ON CTDH.ID_SANPHAM = PRODUCT.ID_SP            ");
		sb.append("  WHERE                                                                                 ");
		sb.append("  	CTDH.ID_DONHANG = ?                                                               ");
		sb.append("  GROUP BY CTDH.ID_SANPHAM                                                               ");
	return sb.toString();
	}	
	
	/**
	 * insert  product
	 * @return
	 */
	private String getSQLChiTietHDonHangByIdDonHangAndIdSP(String pathJSP) {
		StringBuffer sb = new StringBuffer();
		String tableName = pathJSP+"_CHITIETDONHANG";                                                         
		sb.append("  	SELECT                                                                             ");
		sb.append("  	CTDH.ID_DONHANG,                                                                   ");
		sb.append("  	CTDH.ID_SANPHAM,                                                                   ");
		sb.append("  	PRODUCT.TEN_SP,                                                                    ");
		sb.append("  	CTDH.SL_NHAP,                                                                      ");
		sb.append("  	CTDH.GIA_NHAP,                                                                     ");
		sb.append("  	CTDH.SL_SP_KHO,                                                                    ");
		sb.append("  	CTDH.DIA_CHI                                                                       ");
		sb.append("  FROM                                                                                  ");
		sb.append("  	" + tableName+ " CTDH                                               ");
		sb.append("  LEFT JOIN "+pathJSP+"_product PRODUCT ON CTDH.ID_SANPHAM = PRODUCT.ID_SP            ");
		sb.append("  WHERE                                                                                 ");
		sb.append("  	CTDH.ID_DONHANG = ?      AND   CTDH.ID_SANPHAM = ?                                                       ");
		return sb.toString();
	}	
	
	/**
	 * insert  product
	 * @return
	 */
	private String getSQLKhoHang(String pathJSP) {
		StringBuffer sb = new StringBuffer();
		String tableName = pathJSP+"_KHOHANG";                                                         
		sb.append("  	SELECT                                                                             ");
		sb.append("  	KHOHANG.ID_SP,                                                                   ");
		sb.append("  	KHOHANG.SO_LUONG,                                                                   ");
		sb.append("  	PRODUCT.TEN_SP                                                                ");
		sb.append("  FROM                                                                                  ");
		sb.append("  	" + tableName+ "      KHOHANG                                          ");
		sb.append("  LEFT JOIN "+pathJSP+"_product PRODUCT ON KHOHANG.ID_SP = PRODUCT.ID_SP            ");
		return sb.toString();
	}
	
	/**
	 * insert  product
	 * @return
	 */
	private String getSQLUpdateKhoHang(String pathJSP) {
		StringBuffer sb = new StringBuffer();
		String tableName = pathJSP+"_KHOHANG";
		sb.append("  UPDATE  "+tableName+"     		");
		sb.append("  		SET SO_LUONG 	= ?	        ");
		sb.append("  		 WHERE ID_SP = ?        ");
		return sb.toString();
	}
	
	/**
	 * insert  product
	 * @return
	 */
	private String getSQLKhoHangByIdSanPham(String pathJSP) {
		StringBuffer sb = new StringBuffer();
		String tableName = pathJSP+"_KHOHANG";                                                         
		sb.append("  	SELECT                                                                             ");
		sb.append("  	KHOHANG.ID_SP,                                                                   ");
		sb.append("  	KHOHANG.SO_LUONG                                                                   ");
		sb.append("  FROM                                                                                  ");
		sb.append("  	" + tableName+ "      KHOHANG                                          ");
		sb.append("  WHERE KHOHANG.ID_SP = ?            ");
		return sb.toString();
	}
	
	/**
	 * insert  product
	 * @return
	 */
	private String getSQLKhoHangBySEQ(String pathJSP) {
		StringBuffer sb = new StringBuffer();
		String tableName = pathJSP+"_KHOHANG";                                                         
		sb.append("  	SELECT                                                                             ");
		sb.append("  	KHOHANG.ID_SP,                                                                   ");
		sb.append("  	KHOHANG.SO_LUONG                                                                   ");
		sb.append("  FROM                                                                                  ");
		sb.append("  	" + tableName+ "      KHOHANG                                          ");
		sb.append("  INNER JOIN "+pathJSP+"_product PRODUCT ON KHOHANG.ID_SP = PRODUCT.ID_SP            ");
		sb.append("  WHERE PRODUCT.SEQ = ?            ");
		return sb.toString();
	}
	
	/**
	 * insert  product
	 * @return
	 */
	private String getSQLInsertKhoHang(String pathJSP) {
		StringBuffer sb = new StringBuffer();
		String tableName = pathJSP+"_KHOHANG";
		sb.append("  INSERT INTO "+tableName+" (    ");
		sb.append("  		 ID_SP		       ");
		sb.append("  		,SO_LUONG 	           ");
		sb.append("  		)                  ");
		sb.append("  		VALUES (           ");
		sb.append("  		  ?                ");
		sb.append("  		 ,?                ");
		sb.append("  		)                  ");
		return sb.toString();
	}
	
	/**
	 * getSQlDeleteById
	 * @return
	 */
	private String getSQlDeleteKhoHangByIdSP(String pathJSP) {
		String tableName = pathJSP+"_KHOHANG";
		StringBuffer sb = new StringBuffer();
		sb.append("  DELETE  ");
		sb.append("  FROM "+tableName+"  ");
		sb.append("  WHERE ID_SP = ?  ");
		return sb.toString();
	}
	
	/**
	 * insert  product
	 * @return
	 */
	private String getSQLDanhSachCuaHang() {
		StringBuffer sb = new StringBuffer();
		sb.append(" 	SELECT               ");
		sb.append(" 	SI.ID_STORE,         ");
		sb.append(" 	SI.STORENAME,        ");
		sb.append(" 	SI.PATHJSP           ");
		sb.append(" FROM                     ");
		sb.append(" 	store_info SI        ");
		return sb.toString();
	}
	
	
	/**
	 * getSQlDeleteById
	 * @return
	 */
	private String getSQlDeleteByIdDonHang(String pathJSP) {
		String tableName = pathJSP+"_DONHANG";
		StringBuffer sb = new StringBuffer();
		sb.append("  DELETE  ");
		sb.append("  FROM "+tableName+"  ");
		sb.append("  WHERE                                                                                 ");
		sb.append("  	ID_DONHANG = ?   ");
		return sb.toString();
	}
	
	/**
	 * getSQlDeleteById
	 * @return
	 */
	private String getSQlDeleteChiTietDonHang(String pathJSP) {
		String tableName = pathJSP+"_CHITIETDONHANG";
		StringBuffer sb = new StringBuffer();
		sb.append("  DELETE  ");
		sb.append("  FROM "+tableName+"   ");
		sb.append("  WHERE                                                                                 ");
		sb.append("  	ID_DONHANG = ?   ");
		return sb.toString();
	}
	
	/**
	 * 
	 * @return
	 */
	private String getSQlMaxIdDonHang(String pathJSP) {
		String tableName = pathJSP+"_DONHANG";
		StringBuffer sb = new StringBuffer();
		sb.append("  SELECT MAX(ID_DONHANG) ");
		sb.append("  FROM "+tableName+"  ");
		return sb.toString();
	}
	
}
