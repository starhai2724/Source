package com.sms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCT_CATEGORY")
public class ProductCategory {

	@Id
	@Column(name="ID_PRODUCT_CATEGORY")
	private String idProductCategory;
	
	@Column(name="ID_STORE")
	private String idStore;
	
	@Column(name="NAME_PRODUCT_CATEGORY")
	private String nameProductCategory;
	
	@Column(name = "DELETE_FLAG")
	private String deleteFlag;

	public String getIdProductCategory() {
		return idProductCategory;
	}

	public void setIdProductCategory(String idProductCategory) {
		this.idProductCategory = idProductCategory;
	}

	public String getIdStore() {
		return idStore;
	}

	public void setIdStore(String idStore) {
		this.idStore = idStore;
	}

	public String getNameProductCategory() {
		return nameProductCategory;
	}

	public void setNameProductCategory(String nameProductCategory) {
		this.nameProductCategory = nameProductCategory;
	}

	public String getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	
	
}
