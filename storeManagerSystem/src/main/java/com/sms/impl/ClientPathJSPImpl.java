package com.sms.impl;

import org.springframework.web.client.RestTemplate;

import com.sms.common.SystemURL;
import com.sms.input.PathJSPInputBean;
import com.sms.output.PathJSPOutputBean;

public class ClientPathJSPImpl {
	RestTemplate rest = new RestTemplate();
	public static ClientPathJSPImpl intances = new ClientPathJSPImpl();

	/**
	 * get all category store
	 * @return
	 */
	public PathJSPOutputBean getPathJSP() {

		PathJSPOutputBean result = rest.getForObject(SystemURL.PATHJSP_GETPATHJSP, PathJSPOutputBean.class);
		return result;
	}

	/**
	 * get one category store by id
	 * @return
	 */
	public PathJSPOutputBean getPathJSPById(PathJSPInputBean request) {

		PathJSPOutputBean result = rest.postForObject(SystemURL.PATHJSP_GETPATHJSPBYID,request, PathJSPOutputBean.class);
		return result;
	}
	
	
}
