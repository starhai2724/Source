package com.sms.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sms.OutputRows.PathJSPOutputRowBean;
import com.sms.common.SMSComons;
import com.sms.dao.common.HibernateUtil;
import com.sms.dao.common.InterfaceDAO;
import com.sms.inputs.PathJSPInputBean;
import com.sms.outputs.PathJSPOutputBean;

@SuppressWarnings("unchecked")
public class PathJSPDAO implements InterfaceDAO{

	public static PathJSPDAO intances = new PathJSPDAO();
	
	
	/**
	 * Mean get all category store
	 * 
	 * @return PathJSPOutputBean
	 */
	
	public PathJSPOutputBean getPathJSP(){
		//session
		Session session = HibernateUtil.getSessionDAO();
		
		//result 
		PathJSPOutputBean lstResult = new PathJSPOutputBean();
		Transaction tx = HibernateUtil.getSessionDAO().beginTransaction();
		//sql
		String hql = this.SQLGetPathJSP();
		PathJSPOutputRowBean rowBean;
		try {
			SQLQuery query = session.createSQLQuery(hql);
			List<Object[]> data = query.list();
			for (Object[] object : data) {
				rowBean = new PathJSPOutputRowBean();
				rowBean.setIdPathJSP(SMSComons.convertString(object[0]));
				rowBean.setPathJSP(SMSComons.convertString(object[1]));
				lstResult.getLst().add(rowBean);
			}
			tx.commit();
		} catch (HibernateException e) {
		} finally {
			session.close();
		}
		
		return lstResult;
	}
	
	/**
	 * Mean get  category store by Id 
	 * 
	 * @return PathJSPOutputBean
	 */
	
	public PathJSPOutputBean getPathJSPById(PathJSPInputBean inputBean){
		//session
		Session session = HibernateUtil.getSessionDAO();
		
		//result 
		PathJSPOutputBean lstResult = new PathJSPOutputBean();
		Transaction tx = HibernateUtil.getSessionDAO().beginTransaction();
		//sql
		String hql = this.SQLGetPathJSPById();
		PathJSPOutputRowBean rowBean;
		try {
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, inputBean.getIdStore());
			//excuse
			List<Object[]> data = query.list();
			for (Object[] object : data) {
				rowBean = new PathJSPOutputRowBean();
				rowBean.setIdPathJSP(SMSComons.convertString(object[0]));
				rowBean.setPathJSP(SMSComons.convertString(object[1]));
				lstResult.getLst().add(rowBean);
			}
			tx.commit();
		} catch (HibernateException e) {
		} finally {
			session.close();
		}
		
		return lstResult;
	}
	
	
	
	
	@Override
	public Object getObject() {
		return null;
	}

	@Override
	public List getObjects() {
		return null;
	}

	@Override
	public int addObject() {
		return 0;
	}

	@Override
	public int updateObject() {
		return 0;
	}

	private String SQLGetPathJSP(){
		StringBuffer sb = new StringBuffer();
	sb.append("   	SELECT                                     ");
	sb.append("       *                                        ");
	sb.append("   FROM                                         ");
	sb.append("       SYSTEM_CONTROL SC     ");
	sb.append("   WHERE                                        ");
	sb.append("       SC.DELETE_FLAG = '0'                     ");
		
		return sb.toString();
	}
	
	private String SQLGetPathJSPById(){
		StringBuffer sb = new StringBuffer();
		sb.append("    	SELECT                                                            ");
		sb.append("    	SC.PARAMETER_ID, SC.PARAMETER_TXT                                 ");
		sb.append("    FROM                                                               ");
		sb.append("    	store_info SI                                                     ");
		sb.append("    LEFT JOIN system_control SC ON SI.CATEGORY = SC.PARAMETER_ID       ");
		sb.append("    AND SC.DELETE_FLAG = '0'                                           ");
		sb.append("    WHERE                                                              ");
		sb.append("    	SI.ID_STORE = ?                                                  ");
		return sb.toString();
	}
	
	
	
}
