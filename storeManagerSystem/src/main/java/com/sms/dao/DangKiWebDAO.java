package com.sms.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sms.common.SMSComons;
import com.sms.dao.common.HibernateUtil;
import com.sms.form.DangKiWebForm;
import com.sms.input.DangKiWebInputBean;
import com.sms.input.QuenMatKhauInputBean;
import com.sms.input.SanPhamInputBean;
import com.sms.output.DangKiWebOutputBean;

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
			query.setParameter(0, id);
			// Username se duoc gan bang gia tri cua email
			query.setParameter(1, inputBean.getHinh1());
			query.setParameter(2, inputBean.getHinh2());
			query.setParameter(3, inputBean.getHinh3());
			query.setParameter(4, inputBean.getHinh4());
			query.setParameter(5, inputBean.getHinh5());
			
			query.setParameter(6, inputBean.getDiaChi());
			query.setParameter(7, inputBean.getLoaiKinhDoanh());
			query.setParameter(8, inputBean.getEmail());
			query.setParameter(9, "");
			query.setParameter(10, inputBean.getPathJSP());
			query.setParameter(11, inputBean.getTenWebSite());
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
	
	public DangKiWebOutputBean getDataByPathJSP(String pathJSP) {
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQlDataByPathJSP();
		DangKiWebOutputBean outPut = null;
		try {
			Transaction tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, pathJSP);
			List<Object[]> data = query.list();
			for (Object[] object : data) {
				outPut = new DangKiWebOutputBean();
				outPut.setIdCuaHang(SMSComons.convertString(object[0]));
				outPut.setHinh((byte[]) object[1]);
				outPut.setHinh1((byte[]) object[2]);
				outPut.setHinh2((byte[]) object[3]);
				outPut.setHinh3((byte[]) object[4]);
				outPut.setHinh4((byte[]) object[5]);
				outPut.setHinh5((byte[]) object[6]);
				outPut.setDiaChi(SMSComons.convertString(object[7]));
				outPut.setLoaiKinhDoanh(SMSComons.convertString(object[8]));
				outPut.setEmail(SMSComons.convertString(object[9]));
				outPut.setTenWebSite(SMSComons.convertString(object[10]));
				outPut.setDkGiaoHangFree(SMSComons.convertString(object[11]));
				outPut.setSdt(SMSComons.convertString(object[12]));
				outPut.setLinkFanpage(SMSComons.convertString(object[13]));
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
		return outPut;
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
	
	
	/**
	 * 
	 * 
	 * @return
	 */
	public String getAccount(String username, String password) {
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQlAccount();
		String result = "";
		try {
			Transaction tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, username);
			query.setParameter(1, password);
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
	
	
	public int update(DangKiWebInputBean inputBean){
		//session
		Session session = HibernateUtil.getSessionDAO();
		int cnt = 0; 
		Transaction tx = session.beginTransaction();
		//sql 
		String hql = getSQLUpdate();
		
		try {
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, inputBean.getTenWebSite());
			query.setParameter(1, inputBean.getDkGiaoHangFree());
			query.setParameter(2, inputBean.getSdt());
			query.setParameter(3, inputBean.getEmail());
			query.setParameter(4, inputBean.getDiaChi());
			query.setParameter(5, inputBean.getHinh1());
			query.setParameter(6, inputBean.getHinh2());
			query.setParameter(7, inputBean.getHinh3());
			query.setParameter(8, inputBean.getHinh4());
			query.setParameter(9, inputBean.getHinh5());
			query.setParameter(10, inputBean.getLinkFanpage());
			query.setParameter(11, inputBean.getPathJSP());
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
	
	public int updatePassword(QuenMatKhauInputBean inputBean){
		//session
		Session session = HibernateUtil.getSessionDAO();
		int cnt = 0; 
		Transaction tx = session.beginTransaction();
		//sql 
		String hql = getSQLUpdatePassword();
		try {
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, inputBean.getPassword());
			query.setParameter(1, inputBean.getEmail());
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
		sb.append("  		,IMAGEHEADER1      ");
		sb.append("  		,IMAGEHEADER2    	");
		sb.append("  		,IMAGEHEADER3    	");
		sb.append("  		,IMAGEHEADER4     	");
		sb.append("  		,IMAGEHEADER5   	");
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
	private String getSQlDataByPathJSP() {
		StringBuffer sb = new StringBuffer();
		sb.append(" 	SELECT                  ");
		sb.append("    ID_STORE 	                ");
		sb.append("   ,IMAGEHEADER               ");
		sb.append("   ,IMAGEHEADER1               ");
		sb.append("   ,IMAGEHEADER2               ");
		sb.append("   ,IMAGEHEADER3               ");
		sb.append("   ,IMAGEHEADER4               ");
		sb.append("   ,IMAGEHEADER5               ");
		sb.append("   ,ADDRESS 	                ");
		sb.append("   ,CATEGORY 	                ");
		sb.append("   ,EMAIL 		            ");
		sb.append("   ,STORENAME 	            ");
		sb.append("   ,DieuKienShipFree 	            ");
		sb.append("   ,TELEPHONE                 ");
		sb.append("   ,LINK_FANPAGE                 ");
		sb.append(" FROM                        ");
		sb.append(" 	STORE_INFO            ");
		sb.append(" WHERE                       ");
		sb.append(" 	PATHJSP = ?         ");
		return sb.toString();
	}
	
	private String getSQLUpdate() {
		StringBuffer sb = new StringBuffer();
		sb.append("  UPDATE  STORE_INFO     		        ");
		sb.append("  		SET STORENAME 		= ?	        ");
		sb.append("  		,DieuKienShipFree 	= ?         ");
		sb.append("  		,TELEPHONE 			= ?       	");
		sb.append("  		,EMAIL 				= ?      	");
		sb.append("  		,ADDRESS       		= ?  		");
		sb.append("  		,IMAGEHEADER1   = ?     ");
		sb.append("  		,IMAGEHEADER2  	= ?   	");
		sb.append("  		,IMAGEHEADER3  	= ?   	");
		sb.append("  		,IMAGEHEADER4  	= ?   	");
		sb.append("  		,IMAGEHEADER5  	= ?   	");
		sb.append("  		,LINK_FANPAGE  	= ?   	");
		sb.append("  		 WHERE PATHJSP  = ?        ");
		return sb.toString();

	}
	
	private String getSQLUpdatePassword() {
		StringBuffer sb = new StringBuffer();
		sb.append("  UPDATE  STORE_OWNER     		        ");
		sb.append("  		SET PASSWORD 		= ?	        ");
		sb.append("  		 WHERE EMAIL  = ?        ");
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
	
	
	/**
	 * 
	 * @return
	 */
	private String getSQlAccount() {
		StringBuffer sb = new StringBuffer();
		sb.append(" 	SELECT                  ");
		sb.append(" 	SO.USERNAME              ");
		sb.append(" FROM                        ");
		sb.append(" 	STORE_OWNER SO           ");
		sb.append(" WHERE                       ");
		sb.append(" 	SO.USERNAME = ?         ");
		sb.append(" AND SO.PASSWORD = ?         ");
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		DangKiWebInputBean inputBean = new DangKiWebInputBean();
		
//		DangKiWebDAO.intances.insertStoreInfo(inputBean);
	
		DangKiWebDAO.intances.getDataByPathJSP("haha_2");
	}
	
}
