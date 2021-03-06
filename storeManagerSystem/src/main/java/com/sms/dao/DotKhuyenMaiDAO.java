package com.sms.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sms.OutputRows.DotKhuyenMaiOutputRowBean;
import com.sms.OutputRows.SanPhamOutputRowBean;
import com.sms.common.SMSComons;
import com.sms.dao.common.HibernateUtil;
import com.sms.input.DotKhuyenMaiInputBean;
import com.sms.output.SanPhamOutputBean;

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
	
	
	/**
	 * 
	 * 
	 * @return
	 * @throws IOException 
	 */
	public List<DotKhuyenMaiOutputRowBean> getDotKMApDung(String pathJSP, String ngayHienTai) {
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQLDotKMApDung(pathJSP, ngayHienTai);
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
	public List<SanPhamOutputRowBean> getSanPhamKM(String pathJSP, String id_DKM) {
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQLSanPhamKM(pathJSP, id_DKM);
		List<SanPhamOutputRowBean> lst = new ArrayList<>();
		SanPhamOutputRowBean outputRowBean;
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
				outputRowBean.setId_DKM(id_DKM);
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
	private String getSQLDotKMApDung(String pathJSP, String ngayHienTai) {
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
		sb.append("  WHERE   NGAY_BD <= '"+ ngayHienTai+ "'       	");
		sb.append("  AND     NGAY_KT >= '"+ ngayHienTai+ "'       	");
		return sb.toString();
	}
	
	private String getSQLSanPhamKM(String pathJSP, String id_DKM) {
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
		sb.append("  						,product.ID_DKM                                ");
		sb.append("     		FROM                                                                                       ");
		sb.append("     			"+tableName+" product                                                       ");
		sb.append("     		LEFT JOIN "+pathJSP+"_loai_sp loaiSP ON product.ID_LOAI_SP = loaiSP.ID_LOAI_SP        ");
		sb.append("     			) TEMP                                                                                 ");
		sb.append("     	) MAIN                                                                                         ");
		sb.append("     WHERE                                                                                              ");
		sb.append("     	MAIN.MAX_NGAY_TAO = MAIN.NGAY_TAO                                                              ");
		sb.append("     	and MAIN.ID_DKM = '" + id_DKM + "'");
		
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
		sb.append("  MA_DKM	  INT (255)           ");
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
