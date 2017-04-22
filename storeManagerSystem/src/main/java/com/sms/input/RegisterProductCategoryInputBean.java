package com.sms.input;

public class RegisterProductCategoryInputBean {
	
	private String idStore;
	
	private String idProductCategory;

	private String nameProductCategory;

	public String getIdProductCategory() {
		return idProductCategory;
	}

	public void setIdProductCategory(String idProductCategory) {
		this.idProductCategory = idProductCategory;
	}

	public String getNameProductCategory() {
		return nameProductCategory;
	}

	public void setNameProductCategory(String nameProductCategory) {
		this.nameProductCategory = nameProductCategory;
	}

	public String getIdStore() {
		return idStore;
	}

	public void setIdStore(String idStore) {
		this.idStore = idStore;
	}

}
