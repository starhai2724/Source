package com.sms.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sms.OutputRows.RegisterProductCategoryOutputRowBean;
import com.sms.common.SMSComons;
import com.sms.dao.common.HibernateUtil;
import com.sms.domain.ProductCategory;
import com.sms.inputs.RegisterProductCategoryInputBean;
import com.sms.outputs.RegisterProductCategoryOutputBean;

public class RegisterProductCategoryDAO {

	public static RegisterProductCategoryDAO intances = new RegisterProductCategoryDAO();
	
	/**
	 * mean: get list product category
	 * @param inputBean
	 * @return
	 */
	public RegisterProductCategoryOutputBean getProductCategory(RegisterProductCategoryInputBean inputBean){
		RegisterProductCategoryOutputBean result = new RegisterProductCategoryOutputBean();
		Session session = HibernateUtil.getSessionDAO();
		String hql = getSQLSelectRegisterProductCategory();
		Transaction tx = session.beginTransaction();
		try {
			SQLQuery query = session.createSQLQuery(hql);
			query.setParameter(0, inputBean.getIdStore());
			List<Object[]> data = query.list();
			RegisterProductCategoryOutputRowBean outputRow;
			for (Object[] object : data) {
				outputRow = new RegisterProductCategoryOutputRowBean();
				outputRow.setIdProductCategory(SMSComons.convertString(object[0]));
				outputRow.setNameProductCategory(SMSComons.convertString(object[1]));
				result.getLst().add(outputRow);
			}
			tx.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
		
	}
	
	/**
	 * Insert ProductCategory
	 * 
	 */

	public int insertProdcutCategory(RegisterProductCategoryInputBean inputBean) {
		String idProductCategory = getMaxIdProductCategory();
		
		ProductCategory productCategory = new ProductCategory();
		if(null != idProductCategory && !"".equals(idProductCategory) ){
			productCategory.setIdProductCategory(String.valueOf((Integer.parseInt(idProductCategory)+1)));
		}else{
			productCategory.setIdProductCategory("01");
		}
		productCategory.setIdStore(inputBean.getIdStore());
		productCategory.setNameProductCategory(inputBean.getNameProductCategory());
		productCategory.setDeleteFlag("0");
		
		return HibernateUtil.insert(productCategory);
	}

	
	
	/**
	 * 
	 * 
	 * @return
	 */
	
	public String getMaxIdProductCategory() {
		Session session = HibernateUtil.getSessionDAO();
		String hql = getIdMax();
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
	
	
	
	
	//--------------------------------------------------------------------------------------------
	private String getSQLSelectRegisterProductCategory(){
		StringBuffer sb = new StringBuffer();
		sb.append(" 	SELECT                                         ");
		sb.append("     PC.ID_PRODUCT_CATEGORY,                        ");
		sb.append("     PC.NAME_PRODUCT_CATEGORY                       ");
		sb.append(" FROM                                               ");
		sb.append("     storesystemmanager.PRODUCT_CATEGORY PC         ");
		sb.append(" WHERE                                              ");
		sb.append("     PC.DELETE_FLAG = '0'                           ");
		sb.append("         AND PC.ID_STORE = ?                      ");
		
		return sb.toString();
	}
	
	private String getIdMax(){
		StringBuffer sb = new StringBuffer();
		sb.append("  	SELECT                                      ");
		sb.append("      MAX(PC.ID_PRODUCT_CATEGORY) AS IDMAX       ");
		sb.append("                                                 ");
		sb.append("  FROM                                           ");
		sb.append("      storesystemmanager.PRODUCT_CATEGORY PC     ");
		sb.append("  WHERE                                          ");
		sb.append("      PC.DELETE_FLAG = '0'                       ");
		sb.append("  	                                            ");
		
		return sb.toString();
	}
	
	
}
