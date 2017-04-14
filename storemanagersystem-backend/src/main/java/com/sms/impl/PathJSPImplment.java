package com.sms.impl;

import com.sms.dao.PathJSPDAO;
import com.sms.inputs.PathJSPInputBean;
import com.sms.outputs.PathJSPOutputBean;

public class PathJSPImplment {

	public static PathJSPImplment intances = new PathJSPImplment();
	
	/**
	 * mean 
	 * @return list category store
	 */
	public PathJSPOutputBean getPathJSP(){
		
		return PathJSPDAO.intances.getPathJSP();
	}
	
	/**
	 * mean 
	 * @return one category store
	 */
	public PathJSPOutputBean getPathJSPById(PathJSPInputBean inputBean){
		
		return PathJSPDAO.intances.getPathJSPById(inputBean);
	}
	
	
}
