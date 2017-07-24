package com.sms.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sms.OutputRows.SanPhamOutputRowBean;
import com.sms.common.SMSComons;
import com.sms.dao.common.HibernateUtil;
import com.sms.input.SanPhamInputBean;
import com.sms.output.ImageOutputBean;
import com.sms.output.SanPhamOutputBean;

public class CreateTableProductDAO {
	
	public static CreateTableProductDAO intances = new CreateTableProductDAO();
	
	/**
	 * function mean create table product by pathJSP of store
	 * 
	 */
	public int createTableProduct(String pathJSP){
		//session
		Session session = HibernateUtil.getSessionDAO();
		int cnt = 0; 
		Transaction tx = session.beginTransaction();
		//sql
		String hql = this.getSQLCreateTableProduct(pathJSP);
		try {
			SQLQuery query = session.createSQLQuery(hql);
			cnt = query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			cnt = 1;
		} finally {
			session.flush();
			session.clear();
			session.close();
		}
		return cnt;
	}
	
	
	/**
	 * function mean detele table product by pathJSP of store
	 * 
	 */
	public int deleteTableProduct(String pathJSP){
		//session
		Session session = HibernateUtil.getSessionDAO();
		int cnt = 0; 
		Transaction tx = session.beginTransaction();
		//sql
		String hql = this.getSQLDeleteTableProduct(pathJSP);
		try {
			SQLQuery query = session.createSQLQuery(hql);
			cnt = query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			cnt = 0;
		} finally {
			session.flush();
			session.clear();
			session.close();
		}
		return cnt;
	}
	
	/**
	 * function insert
	 * 
	 */
	public int insert(SanPhamInputBean inputBean){
		//session
		Session session = HibernateUtil.getSessionDAO();
		int cnt = 0; 
		Transaction tx = session.beginTransaction();
		//sql 
		String hql = getSQLInsert(inputBean.getPathJSP());
		//SEQ
		int seq = SMSComons.convertInt(getMaxSEQ(inputBean.getPathJSP()));
		try {
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, inputBean.getIdSanPham());
			query.setParameter(1, inputBean.getTenSP());
			query.setParameter(2, inputBean.getIdCuaHang());
			query.setParameter(3, inputBean.getIdLoaiSP());
			query.setParameter(4, inputBean.getGiaMua());
			query.setParameter(5, inputBean.getGiaBan());
			query.setParameter(6, inputBean.getHinh());
			query.setParameter(7, inputBean.getMoTa());
			query.setParameter(8, inputBean.getTrangThai());
			query.setParameter(9, inputBean.getNgayTao());
			query.setParameter(10, inputBean.getNgayChinhSua());
			query.setParameter(11, (seq+1));
			query.setParameter(12, inputBean.getHinhChiTiet1());
			query.setParameter(13, inputBean.getHinhChiTiet2());
			query.setParameter(14, inputBean.getHinhChiTiet3());
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
	
	public int insertSPKM(SanPhamInputBean inputBean){
		//session
		Session session = HibernateUtil.getSessionDAO();
		int cnt = 0; 
		Transaction tx = session.beginTransaction();
		//sql 
		String hql = getSQLInsertSPKM(inputBean.getPathJSP());
		//SEQ
		int seq = SMSComons.convertInt(getMaxSEQ(inputBean.getPathJSP()));
		try {
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, inputBean.getIdSanPham());
			query.setParameter(1, inputBean.getTenSP());
			query.setParameter(2, inputBean.getIdCuaHang());
			query.setParameter(3, inputBean.getIdLoaiSP());
			query.setParameter(4, inputBean.getGiaMua());
			query.setParameter(5, inputBean.getGiaBan());
			query.setParameter(6, inputBean.getHinh());
			query.setParameter(7, inputBean.getMoTa());
			query.setParameter(8, inputBean.getTrangThai());
			query.setParameter(9, inputBean.getNgayTao());
			query.setParameter(10, inputBean.getNgayChinhSua());
			query.setParameter(11, inputBean.getGiaBanKM());
			query.setParameter(12, inputBean.getId_DKM());
			query.setParameter(13, (seq+1));
			query.setParameter(14, inputBean.getHinhChiTiet1());
			query.setParameter(15, inputBean.getHinhChiTiet2());
			query.setParameter(16, inputBean.getHinhChiTiet3());

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
	 * function update 
	 * 
	 */
	public int update(SanPhamInputBean inputBean){
		//session
		Session session = HibernateUtil.getSessionDAO();
		int cnt = 0; 
		Transaction tx = session.beginTransaction();
		//sql 
		String hql = getSQLUpdate(inputBean);
		int i = 0;
		try {
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(i++, inputBean.getTenSP());
			query.setParameter(i++, inputBean.getIdLoaiSP());
			query.setParameter(i++, inputBean.getGiaMua());
			query.setParameter(i++, inputBean.getGiaBan());
			if(inputBean.getHinh() != null){
				query.setParameter(i++, inputBean.getHinh());
			}
			query.setParameter(i++, inputBean.getMoTa());
			query.setParameter(i++, inputBean.getNgayChinhSua());
			if(inputBean.getHinhChiTiet1() != null && inputBean.getHinhChiTiet1().length > 0){
				query.setParameter(i++, inputBean.getHinhChiTiet1());
			}
			if(inputBean.getHinhChiTiet2() != null && inputBean.getHinhChiTiet2().length > 0){
				query.setParameter(i++, inputBean.getHinhChiTiet2());
			}
			if(inputBean.getHinhChiTiet3() != null && inputBean.getHinhChiTiet3().length > 0){
				query.setParameter(i++, inputBean.getHinhChiTiet3());
			}
			query.setParameter(i++, inputBean.getSEQ());
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
	
	public int update_SPKM(SanPhamInputBean inputBean){
		//session
		Session session = HibernateUtil.getSessionDAO();
		Transaction tx = session.beginTransaction();
		int cnt = 0; 
		//sql 
		String hql = getSQLUpdate_SPKM(inputBean);
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
	 * function delete 
	 * 
	 */
	public int deleteProductById(SanPhamInputBean inputBean){
		//session
		Session session = HibernateUtil.getSessionDAO();
		int cnt = 0; 
		Transaction tx = session.beginTransaction();
		//sql 
		String hql = getSQlDeleteById(inputBean.getPathJSP());
		try {
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, inputBean.getIdSanPham());
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
	 */
	private String getMaxSEQ(String pathJSP) {
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQlMaxSEQ(pathJSP);
		String result = "";
		try {
			Transaction tx =  session.beginTransaction();
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
	
	private String getLoai_SP(String pathJSP,String idLoaiSP) {
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQLLoaiSP(pathJSP,idLoaiSP);
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
	public SanPhamOutputBean getProductById(SanPhamInputBean inputBean){
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQLProductById(inputBean.getPathJSP());
		SanPhamOutputBean outputBean = new SanPhamOutputBean();
		SanPhamOutputRowBean outputRowBean = null;
		try {
			Transaction tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, inputBean.getSEQ());
			List<Object[]> data = query.list();
			for (Object[] object : data) {
				outputRowBean = new SanPhamOutputRowBean();
				outputRowBean.setIdSanPham(SMSComons.convertString(object[0]));
				outputRowBean.setTenSP(SMSComons.convertString(object[1]));
				outputRowBean.setIdCuaHang(SMSComons.convertString(object[2]));
				outputRowBean.setIdLoaiSP(SMSComons.convertString(object[3]));
				outputRowBean.setGiaMua(SMSComons.convertString(object[4]));
				outputRowBean.setGiaBan(SMSComons.convertString(object[5]));
				outputRowBean.setHinh((byte[]) object[6]);
				outputRowBean.setMoTa(SMSComons.convertString(object[7]));
				outputRowBean.setTrangThai(SMSComons.convertString(object[8]));
				outputRowBean.setNgayTao(SMSComons.convertString(object[9]));
				outputRowBean.setNgayChinhSua(SMSComons.convertString(object[10]));
				outputRowBean.setId_DKM(SMSComons.convertString(object[11]));
				outputRowBean.setSEQ(SMSComons.convertString(object[12]));
				outputRowBean.setHinhChiTiet1((byte[]) object[13]);
				outputRowBean.setHinhChiTiet2((byte[]) object[14]);
				outputRowBean.setHinhChiTiet3((byte[]) object[15]);
				outputBean.getLst().add(outputRowBean);
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
	public SanPhamOutputBean getProductBySEQ(SanPhamInputBean inputBean){
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQLProductBySEQ(inputBean.getPathJSP());
		SanPhamOutputBean outputBean = new SanPhamOutputBean();
		SanPhamOutputRowBean outputRowBean = null;
		try {
			Transaction tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, inputBean.getSEQ());
			List<Object[]> data = query.list();
			for (Object[] object : data) {
				outputRowBean = new SanPhamOutputRowBean();
				outputRowBean.setIdSanPham(SMSComons.convertString(object[0]));
				outputRowBean.setTenSP(SMSComons.convertString(object[1]));
				outputRowBean.setIdCuaHang(SMSComons.convertString(object[2]));
				outputRowBean.setIdLoaiSP(SMSComons.convertString(object[3]));
				outputRowBean.setGiaMua(SMSComons.convertString(object[4]));
				outputRowBean.setGiaBan(SMSComons.convertString(object[5]));
				outputRowBean.setHinh((byte[]) object[6]);
				outputRowBean.setMoTa(SMSComons.convertString(object[7]));
				outputRowBean.setTrangThai(SMSComons.convertString(object[8]));
				outputRowBean.setNgayTao(SMSComons.convertString(object[9]));
				outputRowBean.setNgayChinhSua(SMSComons.convertString(object[10]));
				outputRowBean.setId_DKM(SMSComons.convertString(object[11]));
				outputRowBean.setSEQ(SMSComons.convertString(object[12]));
				outputRowBean.setHinhChiTiet1((byte[]) object[13]);
				outputRowBean.setHinhChiTiet2((byte[]) object[14]);
				outputRowBean.setHinhChiTiet3((byte[]) object[15]);
				outputBean.getLst().add(outputRowBean);
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
	
	public List<SanPhamOutputRowBean> getProductByNgayTao(SanPhamInputBean inputBean){
		Session session = HibernateUtil.getSessionDAO();
		List<SanPhamOutputRowBean> lst = new ArrayList<>();
		String hql = getSQLProductByNgayTao(inputBean.getPathJSP(),inputBean.getNgayTao());
		SanPhamOutputRowBean outputRowBean = null;
		try {
			Transaction tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(hql);
			List<Object[]> data = query.list();
			for (Object[] object : data) {
				outputRowBean = new SanPhamOutputRowBean();
				outputRowBean.setIdSanPham(SMSComons.convertString(object[0]));
				outputRowBean.setTenSP(SMSComons.convertString(object[1]));
				outputRowBean.setIdCuaHang(SMSComons.convertString(object[2]));
				outputRowBean.setIdLoaiSP(SMSComons.convertString(object[3]));
				outputRowBean.setGiaMua(SMSComons.convertString(object[4]));
				outputRowBean.setGiaBan(SMSComons.convertString(object[5]));
				outputRowBean.setHinh((byte[]) object[6]);
				outputRowBean.setMoTa(SMSComons.convertString(object[7]));
				outputRowBean.setTrangThai(SMSComons.convertString(object[8]));
				outputRowBean.setNgayTao(SMSComons.convertString(object[9]));
				outputRowBean.setNgayChinhSua(SMSComons.convertString(object[10]));
				outputRowBean.setId_DKM(SMSComons.convertString(object[11]));
				outputRowBean.setSEQ(SMSComons.convertString(object[12]));
				outputRowBean.setHinhChiTiet1((byte[]) object[13]);
				outputRowBean.setHinhChiTiet2((byte[]) object[14]);
				outputRowBean.setHinhChiTiet3((byte[]) object[15]);
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
	public SanPhamOutputBean getProductById_GroupById(SanPhamInputBean inputBean){
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQLProductById_GroupById(inputBean.getPathJSP());
		SanPhamOutputBean outputBean = new SanPhamOutputBean();
		SanPhamOutputRowBean outputRowBean = null;
		try {
			Transaction tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, inputBean.getSEQ());
			List<Object[]> data = query.list();
			for (Object[] object : data) {
				outputRowBean = new SanPhamOutputRowBean();
				outputRowBean.setIdSanPham(SMSComons.convertString(object[0]));
				outputRowBean.setTenSP(SMSComons.convertString(object[1]));
				outputRowBean.setIdCuaHang(SMSComons.convertString(object[2]));
				outputRowBean.setIdLoaiSP(SMSComons.convertString(object[3]));
				outputRowBean.setGiaMua(SMSComons.convertString(object[4]));
				outputRowBean.setGiaBan(SMSComons.convertString(object[5]));
				outputRowBean.setHinh((byte[]) object[6]);
				outputRowBean.setMoTa(SMSComons.convertString(object[7]));
				outputRowBean.setTrangThai(SMSComons.convertString(object[8]));
				outputRowBean.setNgayTao(SMSComons.convertString(object[9]));
				outputRowBean.setNgayChinhSua(SMSComons.convertString(object[10]));
				outputRowBean.setId_DKM(SMSComons.convertString(object[11]));
				outputRowBean.setSEQ(SMSComons.convertString(object[12]));
				outputRowBean.setHinhChiTiet1((byte[]) object[13]);
				outputRowBean.setHinhChiTiet2((byte[]) object[14]);
				outputRowBean.setHinhChiTiet3((byte[]) object[15]);
				outputBean.getLst().add(outputRowBean);
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
	public SanPhamOutputBean getProductByList(String pathJSP, String listSEQ){
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQLProductByListId(pathJSP, listSEQ);
		SanPhamOutputBean outputBean = new SanPhamOutputBean();
		SanPhamOutputRowBean outputRowBean = null;
		try {
			Transaction tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(hql);
			List<Object[]> data = query.list();
			for (Object[] object : data) {
				outputRowBean = new SanPhamOutputRowBean();
				outputRowBean.setIdSanPham(SMSComons.convertString(object[0]));
				outputRowBean.setTenSP(SMSComons.convertString(object[1]));
				outputRowBean.setIdCuaHang(SMSComons.convertString(object[2]));
				outputRowBean.setIdLoaiSP(SMSComons.convertString(object[3]));
				outputRowBean.setGiaMua(SMSComons.convertString(object[4]));
				outputRowBean.setGiaBan(SMSComons.convertString(object[5]));
				outputRowBean.setHinh((byte[]) object[6]);
				outputRowBean.setMoTa(SMSComons.convertString(object[7]));
				outputRowBean.setTrangThai(SMSComons.convertString(object[8]));
				outputRowBean.setNgayTao(SMSComons.convertString(object[9]));
				outputRowBean.setNgayChinhSua(SMSComons.convertString(object[10]));
				outputRowBean.setSEQ(SMSComons.convertString(object[11]));
				outputRowBean.setGiaBanKM(SMSComons.convertString(object[12]));
				outputRowBean.setHinhChiTiet1((byte[]) object[13]);
				outputRowBean.setHinhChiTiet2((byte[]) object[14]);
				outputRowBean.setHinhChiTiet3((byte[]) object[15]);
				outputBean.getLst().add(outputRowBean);
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
	
	public SanPhamOutputBean getProductBysByNameProduct(String pathJSP, String name){
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQLProductByName(pathJSP, name);
		SanPhamOutputBean outputBean = new SanPhamOutputBean();
		SanPhamOutputRowBean outputRowBean = null;
		try {
			Transaction tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(hql);
			List<Object[]> data = query.list();
			for (Object[] object : data) {
				outputRowBean = new SanPhamOutputRowBean();
				outputRowBean.setIdSanPham(SMSComons.convertString(object[0]));
				outputRowBean.setTenSP(SMSComons.convertString(object[1]));
				outputRowBean.setIdCuaHang(SMSComons.convertString(object[2]));
				outputRowBean.setIdLoaiSP(SMSComons.convertString(object[3]));
				outputRowBean.setGiaMua(SMSComons.convertString(object[4]));
				outputRowBean.setGiaBan(SMSComons.convertString(object[5]));
				outputRowBean.setHinh((byte[]) object[6]);
				outputRowBean.setMoTa(SMSComons.convertString(object[7]));
				outputRowBean.setTrangThai(SMSComons.convertString(object[8]));
				outputRowBean.setNgayTao(SMSComons.convertString(object[9]));
				outputRowBean.setNgayChinhSua(SMSComons.convertString(object[10]));
				outputRowBean.setSEQ(SMSComons.convertString(object[11]));
				outputRowBean.setGiaBanKM(SMSComons.convertString(object[12]));
				outputBean.getLst().add(outputRowBean);
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
	
	
	public SanPhamOutputBean getProductByIdDKM(SanPhamInputBean inputBean){
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQLProductByIdDKM(inputBean.getPathJSP());
		SanPhamOutputBean outputBean = new SanPhamOutputBean();
		SanPhamOutputRowBean outputRowBean = null;
		try {
			Transaction tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, inputBean.getId_DKM());
			List<Object[]> data = query.list();
			for (Object[] object : data) {
				outputRowBean = new SanPhamOutputRowBean();
				outputRowBean.setIdSanPham(SMSComons.convertString(object[0]));
				outputRowBean.setTenSP(SMSComons.convertString(object[1]));
				outputRowBean.setIdLoaiSP(SMSComons.convertString(object[2]));
				outputRowBean.setGiaMua(SMSComons.convertString(object[3]));
				outputRowBean.setGiaBan(SMSComons.convertString(object[4]));
				outputRowBean.setGiaBanKM(SMSComons.convertString(object[5]));
				outputRowBean.setTenLoaiSP(SMSComons.convertString(object[6]));
				outputRowBean.setSEQ(SMSComons.convertString(object[7]));
				outputBean.getLst().add(outputRowBean);
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
	public SanPhamOutputBean getProducts(String pathJSP) {
		Session session = HibernateUtil.getSessionDAO();
		String hql = getAll(pathJSP);
		SanPhamOutputBean outputBean = new SanPhamOutputBean();
		SanPhamOutputRowBean outputRowBean = null;
		try {
			session.getTransaction().begin();
			SQLQuery query = session.createSQLQuery(hql);
			List<Object[]> data = query.list();
			for (Object[] object : data) {
				outputRowBean = new SanPhamOutputRowBean();
				outputRowBean.setIdSanPham(SMSComons.convertString(object[0]));
				outputRowBean.setTenSP(SMSComons.convertString(object[1]));
				outputRowBean.setIdCuaHang(SMSComons.convertString(object[2]));
				outputRowBean.setIdLoaiSP(SMSComons.convertString(object[3]));
				outputRowBean.setGiaMua(SMSComons.convertString(object[4]));
				outputRowBean.setGiaBan(SMSComons.convertString(object[5]));
				outputRowBean.setHinh((byte[]) object[6]);
				outputRowBean.setMoTa(SMSComons.convertString(object[7]));
				outputRowBean.setTrangThai(SMSComons.convertString(object[8]));
				outputRowBean.setNgayTao(SMSComons.convertString(object[9]));
				outputRowBean.setNgayChinhSua(SMSComons.convertString(object[10]));
				outputRowBean.setTenLoaiSP(SMSComons.convertString(object[11])+": "+SMSComons.convertString(object[12]));
				outputRowBean.setSEQ(SMSComons.convertString(object[13]));
				outputRowBean.setHinhChiTiet1((byte[]) object[14]);
				outputRowBean.setHinhChiTiet2((byte[]) object[15]);
				outputRowBean.setHinhChiTiet3((byte[]) object[16]);
				outputBean.getLst().add(outputRowBean);
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
		return outputBean;
	}
	
	

	/**
	 * 
	 * 
	 * @return
	 * @throws IOException 
	 */
	public SanPhamOutputBean getSanPhamApDung(String pathJSP) {
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQLSanPhamApDung(pathJSP);
		SanPhamOutputBean outputBean = new SanPhamOutputBean();
		SanPhamOutputRowBean outputRowBean = null;
		try {
			session.getTransaction().begin();
			SQLQuery query = session.createSQLQuery(hql);
			List<Object[]> data = query.list();
			for (Object[] object : data) {
				outputRowBean = new SanPhamOutputRowBean();
				outputRowBean.setIdSanPham(SMSComons.convertString(object[0]));
				outputRowBean.setTenSP(SMSComons.convertString(object[1]));
				outputRowBean.setIdCuaHang(SMSComons.convertString(object[2]));
				outputRowBean.setIdLoaiSP(SMSComons.convertString(object[3]));
				outputRowBean.setGiaMua(SMSComons.convertString(object[4]));
				outputRowBean.setGiaBan(SMSComons.convertString(object[5]));
				outputRowBean.setGiaBanKM(SMSComons.convertString(object[6]));
				outputRowBean.setHinh((byte[]) object[7]);
				outputRowBean.setMoTa(SMSComons.convertString(object[8]));
				outputRowBean.setTrangThai(SMSComons.convertString(object[9]));
				outputRowBean.setNgayTao(SMSComons.convertString(object[10]));
				outputRowBean.setNgayChinhSua(SMSComons.convertString(object[11]));
				outputRowBean.setTenLoaiSP(SMSComons.convertString(object[12]));
				outputRowBean.setSEQ(SMSComons.convertString(object[13]));
				outputRowBean.setHinhChiTiet1((byte[]) object[14]);
				outputRowBean.setHinhChiTiet2((byte[]) object[15]);
				outputRowBean.setHinhChiTiet3((byte[]) object[16]);
				outputBean.getLst().add(outputRowBean);
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
		return outputBean;
	}
	
	
	/**
	 * 
	 * 
	 * @return
	 * @throws IOException 
	 */
	public ImageOutputBean getImage(String pathJSP, String table, String SEQ) {
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQLImage(pathJSP);
		ImageOutputBean outputBean = new ImageOutputBean();
		try {
			Transaction tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, SEQ);
			List<Object[]> data = query.list();
			for (Object[] object : data) {
				outputBean.setId(SMSComons.convertString(object[0]));
				outputBean.setHinh((byte[]) object[1]);
				outputBean.setHinhChiTiet1((byte[]) object[2]);
				outputBean.setHinhChiTiet2((byte[]) object[3]);
				outputBean.setHinhChiTiet3((byte[]) object[4]);
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
	
	// ----------------------------------------------------------------------------------------------------------
	
	/**
	 * create table product 
	 * @return
	 */
	private String getSQLCreateTableProduct(String pathJSP) {
		StringBuffer sb = new StringBuffer();
		String tableName = pathJSP+"_PRODUCT";
		sb.append("  CREATE TABLE "+tableName+" (          ");
		sb.append("  		 SEQ		INT (6)            ");
		sb.append("  		,ID_SP		VARCHAR (6)            ");
		sb.append("  		,TEN_SP 	VARCHAR(255)           ");
		sb.append("  		,ID_CUAHANG VARCHAR(6)         ");
		sb.append("  		,ID_LOAI_SP VARCHAR(6)         ");
		sb.append("  		,GIA_MUA 	VARCHAR(12)           ");
		sb.append("  		,GIA_BAN 	VARCHAR(12)           ");
		sb.append("  		,ID_DKM 	VARCHAR(12)           ");
		sb.append("  		,GIA_BAN_KM VARCHAR(255)           ");
		sb.append("  		,HINH 		MEDIUMBLOB           		   ");
		sb.append("  		,MO_TA 		TEXT           		   ");
		sb.append("  		,TRANG_THAI VARCHAR(1)         ");
		sb.append("  		,NGAY_TAO 	VARCHAR(8)           ");
		sb.append("  		,NGAY_CHINH_SUA VARCHAR(8)     ");
		sb.append("  		,CHITIET_1 		MEDIUMBLOB           		   ");
		sb.append("  		,CHITIET_2 		MEDIUMBLOB           		   ");
		sb.append("  		,CHITIET_3 		MEDIUMBLOB           		   ");
		sb.append(")");
		return sb.toString();
	}
	
	/**
	 * delete table product
	 * @return
	 */
	private String getSQLDeleteTableProduct(String pathJSP) {
		StringBuffer sb = new StringBuffer();
		String tableName = pathJSP+"_PRODUCT";
		sb.append("   DROP TABLE "+tableName+"            ");
		return sb.toString();
	}	
	
	/**
	 * insert  product
	 * @return
	 */
	private String getSQLInsert(String pathJSP) {
		StringBuffer sb = new StringBuffer();
		String tableName = pathJSP+"_PRODUCT";
		sb.append("  INSERT INTO "+tableName+" (    ");
		sb.append("  		 ID_SP		       ");
		sb.append("  		,TEN_SP 	           ");
		sb.append("  		,ID_CUAHANG         ");
		sb.append("  		,ID_LOAI_SP         ");
		sb.append("  		,GIA_MUA 	       ");
		sb.append("  		,GIA_BAN 	       ");
		sb.append("  		,HINH         ");
		sb.append("  		,MO_TA         ");
		sb.append("  		,TRANG_THAI         ");
		sb.append("  		,NGAY_TAO 	       ");
		sb.append("  		,NGAY_CHINH_SUA     ");
		sb.append("  		,SEQ     			");
		sb.append("  		,CHITIET_1     			");
		sb.append("  		,CHITIET_2     			");
		sb.append("  		,CHITIET_3     			");
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
		sb.append("  		 ,?                ");
		sb.append("  		 ,?                ");
		sb.append("  		 ,?                ");
		sb.append("  		 ,?                ");
		sb.append("  		)                  ");
		return sb.toString();
	}	

	private String getSQLInsertSPKM(String pathJSP) {
		StringBuffer sb = new StringBuffer();
		String tableName = pathJSP+"_PRODUCT";
		sb.append("  INSERT INTO "+tableName+" (    ");
		sb.append("  		 ID_SP		       ");
		sb.append("  		,TEN_SP 	           ");
		sb.append("  		,ID_CUAHANG         ");
		sb.append("  		,ID_LOAI_SP         ");
		sb.append("  		,GIA_MUA 	       ");
		sb.append("  		,GIA_BAN 	       ");
		sb.append("  		,HINH         ");
		sb.append("  		,MO_TA         ");
		sb.append("  		,TRANG_THAI         ");
		sb.append("  		,NGAY_TAO 	       ");
		sb.append("  		,NGAY_CHINH_SUA     ");
		sb.append("  		,GIA_BAN_KM 	       ");
		sb.append("  		,ID_DKM     ");
		sb.append("  		,SEQ     ");
		sb.append("  		,CHITIET_1     ");
		sb.append("  		,CHITIET_2     ");
		sb.append("  		,CHITIET_3     ");
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
	private String getSQLUpdate(SanPhamInputBean inputBean) {
		StringBuffer sb = new StringBuffer();
		String tableName = inputBean.getPathJSP()+"_PRODUCT";
		sb.append("  UPDATE  "+tableName+"     ");
		sb.append("  		SET TEN_SP = ?	        ");
		sb.append("  		,ID_LOAI_SP = ?         ");
		sb.append("  		,GIA_MUA 	= ?       	");
		sb.append("  		,GIA_BAN 	= ?      	 ");
		if(inputBean.getHinh() != null  && inputBean.getHinh().length > 0){
			sb.append("  		,HINH       = ?  		");
		}
		sb.append("  		,MO_TA      = ?   		");
		sb.append("  		,NGAY_CHINH_SUA  = ?   	");
		if(inputBean.getHinhChiTiet1() != null && inputBean.getHinhChiTiet1().length > 0){
			sb.append("  		,CHITIET_1  = ?   	");
		}
		if(inputBean.getHinhChiTiet2() != null && inputBean.getHinhChiTiet2().length > 0){
			sb.append("  		,CHITIET_2  = ?   	");
		}
		if(inputBean.getHinhChiTiet3() != null && inputBean.getHinhChiTiet3().length > 0){
			sb.append("  		,CHITIET_3  = ?   	");
		}
		sb.append("  		 WHERE SEQ = ?        ");
		sb.append("  		 AND TRANG_THAI = '0'   ");
		return sb.toString();
	}
	
	/**
	 * getSQlMaxIdStoreOwner
	 * @return
	 */
	private String getAll(String pathJSP) {
		String tableName = pathJSP+"_PRODUCT";
		StringBuffer sb = new StringBuffer();
		sb.append("  SELECT                                 ");
		sb.append("   ID_SP		                            ");
		sb.append("  ,TEN_SP 	                            ");
		sb.append("  ,ID_CUAHANG                            ");
		sb.append("  ,product.ID_LOAI_SP                            ");
		sb.append("  ,GIA_MUA 	                            ");
		sb.append("  ,GIA_BAN 	                            ");
		sb.append("  ,HINH                                  ");
		sb.append("  ,MO_TA                                 ");
		sb.append("  ,TRANG_THAI                            ");
		sb.append("  ,NGAY_TAO 	                            ");
		sb.append("  ,NGAY_CHINH_SUA                        ");
		sb.append("  ,loaiSP.TEN_LOAI_SP                        	");
		sb.append("  ,NSP.TEN_NHOM_SP                        	");
		sb.append("  ,SEQ                        	");
		sb.append("  ,CHITIET_1                                ");
		sb.append("  ,CHITIET_2                                ");
		sb.append("  ,CHITIET_3                                ");
		sb.append("  FROM "+tableName+" product         	");
		sb.append("  INNER JOIN "+pathJSP+"_loai_sp loaiSP  ");
		sb.append("  ON product.ID_LOAI_SP = loaiSP.ID_LOAI_SP          			");
		sb.append("  INNER JOIN "+pathJSP+"_NHOM_SP NSP  ");
		sb.append("  ON NSP.ID_NHOM_SP = loaiSP.ID_NHOM_SP          			");
		sb.append("  WHERE ID_DKM IS NULL OR ID_DKM  = ''                       	");
		
		return sb.toString();
	}

	/**
	 * getSQlMaxIdStoreOwner
	 * @return
	 */
	private String getSQLSanPhamApDung(String pathJSP) {
		String tableName = pathJSP+"_PRODUCT";
		StringBuffer sb = new StringBuffer();
		sb.append("     	SELECT                                                                                         ");
		sb.append("     	*                                                                                              ");
		sb.append("     FROM                                                                                               ");
		sb.append("     	(                                                                                              ");
		sb.append("     		SELECT                                                                                     ");
		sb.append("     			*, (                                                                                   ");
		sb.append("     				SELECT                                                                             ");
		sb.append("     					MAX(NGAY_TAO)                                                                  ");
		sb.append("     				FROM                                                                               ");
		sb.append("     					"+tableName+" product_1                                             ");
		sb.append("     				WHERE                                                                              ");
		sb.append("     					product_1.ID_SP = TEMP.ID_SP                                                   ");
		sb.append("     			) MAX_NGAY_TAO                                                                         ");
		sb.append("     		FROM                                                                                       ");
		sb.append("     			(                                                                                      ");
		sb.append("     				SELECT                                                                             ");
		sb.append("     					product.ID_SP,                                                                 ");
		sb.append("     					product.TEN_SP,                                                                ");
		sb.append("     					product.ID_CUAHANG,                                                            ");
		sb.append("     					product.ID_LOAI_SP,                                                            ");
		sb.append("     					product.GIA_MUA,                                                               ");
		sb.append("     					product.GIA_BAN,                                                               ");
		sb.append("     					product.GIA_BAN_KM,                                                               ");
		sb.append("     					product.HINH,                                                                  ");
		sb.append("     					product.MO_TA,                                                                 ");
		sb.append("     					product.TRANG_THAI,                                                            ");
		sb.append("     					product.NGAY_TAO,                                                              ");
		sb.append("     					product.NGAY_CHINH_SUA,                                                        ");
		sb.append("     					loaiSP.TEN_LOAI_SP,                                                             ");
		sb.append("     					product.SEQ                                                             ");
		sb.append("  						,product.CHITIET_1                                ");
		sb.append("  						,product.CHITIET_2                                ");
		sb.append("  						,product.CHITIET_3                                ");
		sb.append("     		FROM                                                                                       ");
		sb.append("     			"+tableName+" product                                                       ");
		sb.append("     		LEFT JOIN "+pathJSP+"_loai_sp loaiSP ON product.ID_LOAI_SP = loaiSP.ID_LOAI_SP        ");
		sb.append("     			) TEMP                                                                                 ");
		sb.append("     	) MAIN                                                                                         ");
		sb.append("     WHERE                                                                                              ");
		sb.append("     	MAIN.MAX_NGAY_TAO = MAIN.NGAY_TAO                                                              ");
		
		return sb.toString();
	}

	
	/**
	 * get Image
	 * @return
	 */
	private String getSQLImage(String pathJSP) {
		String tableName = pathJSP+"_PRODUCT";
		StringBuffer sb = new StringBuffer();
		sb.append("  SELECT                                 ");
		sb.append("   ID_SP		                            ");
		sb.append("  ,HINH                                  ");
		sb.append("  ,CHITIET_1                                ");
		sb.append("  ,CHITIET_2                                ");
		sb.append("  ,CHITIET_3                                ");
		sb.append("  FROM "+tableName+" product         	");
		sb.append("  WHERE  product.SEQ = ?       			");
		return sb.toString();
	}

	
	/**
	 * getSQlMaxIdStoreOwner
	 * @return
	 */
	private String getSQLProductById(String pathJSP) {
		String tableName = pathJSP+"_PRODUCT";
		StringBuffer sb = new StringBuffer();
		sb.append("  SELECT                                 ");
		sb.append("   ID_SP		                            ");
		sb.append("  ,TEN_SP 	                            ");
		sb.append("  ,ID_CUAHANG                            ");
		sb.append("  ,ID_LOAI_SP                            ");
		sb.append("  ,GIA_MUA 	                            ");
		sb.append("  ,GIA_BAN 	                            ");
		sb.append("  ,HINH                                  ");
		sb.append("  ,MO_TA                                 ");
		sb.append("  ,TRANG_THAI                            ");
		sb.append("  ,NGAY_TAO 	                            ");
		sb.append("  ,NGAY_CHINH_SUA                        ");
		sb.append("  ,ID_DKM                                ");
		sb.append("  ,SEQ                                ");
		sb.append("  ,CHITIET_1                                ");
		sb.append("  ,CHITIET_2                                ");
		sb.append("  ,CHITIET_3                                ");
		sb.append("  FROM "+tableName+"          			");
		sb.append("  WHERE SEQ = ?          			");
		return sb.toString();
	}
	
	/**
	 * getSQlMaxIdStoreOwner
	 * @return
	 */
	private String getSQLProductBySEQ(String pathJSP) {
		String tableName = pathJSP+"_PRODUCT";
		StringBuffer sb = new StringBuffer();
		sb.append("  SELECT                                 ");
		sb.append("   ID_SP		                            ");
		sb.append("  ,TEN_SP 	                            ");
		sb.append("  ,ID_CUAHANG                            ");
		sb.append("  ,ID_LOAI_SP                            ");
		sb.append("  ,GIA_MUA 	                            ");
		sb.append("  ,GIA_BAN 	                            ");
		sb.append("  ,HINH                                  ");
		sb.append("  ,MO_TA                                 ");
		sb.append("  ,TRANG_THAI                            ");
		sb.append("  ,NGAY_TAO 	                            ");
		sb.append("  ,NGAY_CHINH_SUA                        ");
		sb.append("  ,ID_DKM                                ");
		sb.append("  ,SEQ                                ");
		sb.append("  ,CHITIET_1                                ");
		sb.append("  ,CHITIET_2                                ");
		sb.append("  ,CHITIET_3                                ");
		sb.append("  FROM "+tableName+"          			");
		sb.append("  WHERE SEQ = ?          			");
		return sb.toString();
	}
private String getSQLProductByNgayTao(String pathJSP,String ngayTao) {
		String tableName = pathJSP+"_PRODUCT";
		StringBuffer sb = new StringBuffer();
		sb.append("  SELECT                                 ");
		sb.append("   ID_SP		                            ");
		sb.append("  ,TEN_SP 	                            ");
		sb.append("  ,ID_CUAHANG                            ");
		sb.append("  ,ID_LOAI_SP                            ");
		sb.append("  ,GIA_MUA 	                            ");
		sb.append("  ,GIA_BAN 	                            ");
		sb.append("  ,HINH                                  ");
		sb.append("  ,MO_TA                                 ");
		sb.append("  ,TRANG_THAI                            ");
		sb.append("  ,NGAY_TAO 	                            ");
		sb.append("  ,NGAY_CHINH_SUA                        ");
		sb.append("  ,ID_DKM                                ");
		sb.append("  ,SEQ                                ");
		sb.append("  ,CHITIET_1                                ");
		sb.append("  ,CHITIET_2                                ");
		sb.append("  ,CHITIET_3                                ");
		sb.append("  FROM "+tableName+"          			");
		sb.append("  WHERE NGAY_TAO like '%" + ngayTao + "%'");
		return sb.toString();
	}

	/**
	 * getSQlMaxIdStoreOwner
	 * @return
	 */
	private String getSQLProductById_GroupById(String pathJSP) {
		String tableName = pathJSP+"_PRODUCT";
		StringBuffer sb = new StringBuffer();
		sb.append("  SELECT                                 ");
		sb.append("   ID_SP		                            ");
		sb.append("  ,TEN_SP 	                            ");
		sb.append("  ,ID_CUAHANG                            ");
		sb.append("  ,ID_LOAI_SP                            ");
		sb.append("  ,GIA_MUA 	                            ");
		sb.append("  ,GIA_BAN 	                            ");
		sb.append("  ,HINH                                  ");
		sb.append("  ,MO_TA                                 ");
		sb.append("  ,TRANG_THAI                            ");
		sb.append("  ,NGAY_TAO 	                            ");
		sb.append("  ,NGAY_CHINH_SUA                        ");
		sb.append("  ,ID_DKM                                ");
		sb.append("  ,SEQ                                ");
		sb.append("  ,CHITIET_1                                ");
		sb.append("  ,CHITIET_2                                ");
		sb.append("  ,CHITIET_3                                ");
		sb.append("  FROM "+tableName+"          			");
		sb.append("  WHERE SEQ = ?          			");
		sb.append("  GROUP BY  ID_SP          			");
		return sb.toString();
	}

	/**
	 * getSQlMaxIdStoreOwner
	 * @return
	 */
	private String getSQLProductByListId(String pathJSP, String listSEQ) {
		String tableName = pathJSP+"_PRODUCT";
		StringBuffer sb = new StringBuffer();
		sb.append("  SELECT                                 ");
		sb.append("   ID_SP		                            ");
		sb.append("  ,TEN_SP 	                            ");
		sb.append("  ,ID_CUAHANG                            ");
		sb.append("  ,ID_LOAI_SP                            ");
		sb.append("  ,GIA_MUA 	                            ");
		sb.append("  ,GIA_BAN 	                            ");
		sb.append("  ,HINH                                  ");
		sb.append("  ,MO_TA                                 ");
		sb.append("  ,TRANG_THAI                            ");
		sb.append("  ,NGAY_TAO 	                            ");
		sb.append("  ,NGAY_CHINH_SUA                        ");
		sb.append("  ,SEQ                                   ");
		sb.append("  ,GIA_BAN_KM                                   ");
		sb.append("  ,CHITIET_1                                ");
		sb.append("  ,CHITIET_2                                ");
		sb.append("  ,CHITIET_3                                ");
		sb.append("  FROM "+tableName+"          			");
		sb.append("  WHERE SEQ IN (" + listSEQ + ")        ");
		return sb.toString();
	}

	private String getSQLProductByName(String pathJSP, String name) {
		String tableName = pathJSP+"_PRODUCT";
		StringBuffer sb = new StringBuffer();
		sb.append("  SELECT                                 ");
		sb.append("   ID_SP		                            ");
		sb.append("  ,TEN_SP 	                            ");
		sb.append("  ,ID_CUAHANG                            ");
		sb.append("  ,ID_LOAI_SP                            ");
		sb.append("  ,GIA_MUA 	                            ");
		sb.append("  ,GIA_BAN 	                            ");
		sb.append("  ,HINH                                  ");
		sb.append("  ,MO_TA                                 ");
		sb.append("  ,TRANG_THAI                            ");
		sb.append("  ,NGAY_TAO 	                            ");
		sb.append("  ,NGAY_CHINH_SUA                        ");
		sb.append("  ,SEQ                                   ");
		sb.append("  ,GIA_BAN_KM                                   ");
		sb.append("  FROM "+tableName+"          			");
		sb.append("  WHERE TEN_SP like '%" + name + "%'        ");
		return sb.toString();
	}
	private String getSQLProductByIdDKM(String pathJSP) {
		String tableName = pathJSP+"_PRODUCT";
		StringBuffer sb = new StringBuffer();
		sb.append("  SELECT                                 ");
		sb.append("   ID_SP		                            ");
		sb.append("  ,TEN_SP 	                            ");
		sb.append("  ,product.ID_LOAI_SP                            ");
		sb.append("  ,GIA_MUA 	                            ");
		sb.append("  ,GIA_BAN 	                            ");
		sb.append("  ,GIA_BAN_KM 	                        ");
		sb.append("  ,TEN_LOAI_SP 	                        ");
		sb.append("  ,SEQ 	                        ");
		sb.append("  FROM "+tableName+"     product     	");
		sb.append("  INNER JOIN "+pathJSP+"_loai_sp loaiSP  ");
		sb.append("  ON product.ID_LOAI_SP = loaiSP.ID_LOAI_SP          			");
		sb.append("  WHERE ID_DKM = ?          			");
		return sb.toString();
	}
	
	private String getSQLUpdate_SPKM(SanPhamInputBean inputBean) {
		StringBuffer sb = new StringBuffer();
		String tableName = inputBean.getPathJSP() +"_PRODUCT";
		sb.append("  UPDATE  "+tableName+"     ");
		sb.append("  		SET GIA_BAN_KM = '" + inputBean.getGiaBanKM() + "' ");
		sb.append("  		,NGAY_CHINH_SUA  = '" + inputBean.getNgayChinhSua() + "' ");
		sb.append("  		 WHERE ID_DKM = '" + inputBean.getId_DKM() + "' ");
		sb.append("  		 AND SEQ = '"+inputBean.getSEQ()+"'   ");
		sb.append("  		 AND TRANG_THAI = '0'   ");
		return sb.toString();
	}
	
	/**
	 * getSQlMaxIdStoreOwner
	 * @return
	 */
	private String getSQlMaxSEQ(String pathJSP) {
		String tableName = pathJSP+"_PRODUCT";
		StringBuffer sb = new StringBuffer();
		sb.append("  SELECT MAX(SEQ) ");
		sb.append("  FROM "+tableName+"  ");
		return sb.toString();
	}
	
	private String getSQLLoaiSP(String pathJSP,String idLoaiSP) {
		String tableName = pathJSP+"_loai_sp";
		StringBuffer sb = new StringBuffer();
		sb.append("  SELECT TEN_LOAI_SP ");
		sb.append("  FROM "+tableName+"  ");
		sb.append("  WHERE ID_LOAI_SP = '" + idLoaiSP + "'");
		return sb.toString();
	}
	
	/**
	 * getSQlDeleteById
	 * @return
	 */
	private String getSQlDeleteById(String pathJSP) {
		String tableName = pathJSP+"_PRODUCT";
		StringBuffer sb = new StringBuffer();
		sb.append("  DELETE  ");
		sb.append("  FROM "+tableName+"  ");
		sb.append("  WHERE ID_SP = ?  ");
		return sb.toString();
	}
	
	
	
	
	
	public static void main(String[] args) throws IOException {
		CreateTableProductDAO cr = new CreateTableProductDAO();
		SanPhamInputBean in = new SanPhamInputBean();
		in.setIdSanPham("");
		in.setPathJSP("cuahangthoitrang");
		in.setId_DKM("1");
//		cr.getProductById(in);
//		cr.deleteProductById(in);
//		cr.getProductByIdDKM(in);
//		cr.getMaxId("cuahangthoitrang");
//		for(int i = 0; i < 3; i++ ){
//			cr.insertSPKM(in);
//		}
		
		cr.createTableProduct("abc");
		
		
		
		
	}
}
