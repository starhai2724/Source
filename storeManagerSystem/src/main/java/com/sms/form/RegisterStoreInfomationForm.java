package com.sms.form;

import java.util.LinkedHashMap;
import java.util.Map;

public class RegisterStoreInfomationForm extends AbstractForm {

	// private String idStoreInfo;

	// private String idStore;

	private String storeName;

	private String domain;

	private String address;

	private String telephone;

	private String email;

	private Map<String, String> lstCategory = new LinkedHashMap<String, String>();

	private String pathJSP;

	private String pathImage;
	
	private String categoryed;
	

	public String getCategoryed() {
		return categoryed;
	}

	public void setCategoryed(String categoryed) {
		this.categoryed = categoryed;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public Map<String, String> getLstCategory() {
		return lstCategory;
	}

	public void setLstCategory(Map<String, String> lstCategory) {
		this.lstCategory = lstCategory;
	}

	public String getPathJSP() {
		return pathJSP;
	}

	public void setPathJSP(String pathJSP) {
		this.pathJSP = pathJSP;
	}

	public String getPathImage() {
		return pathImage;
	}

	public void setPathImage(String pathImage) {
		this.pathImage = pathImage;
	}

}
