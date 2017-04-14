package com.sms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STORE_INFO")
public class StoreInformation {

	@Id
	@Column(name = "ID_STORE_INFO", length = 6)
	private String idStoreInfo;

	@Column(name = "IDSTORE")
	private String idStore;

	@Column(name = "STORENAME")
	private String storeName;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "TELEPHONE")
	private String telephone;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "CATEGORY")
	private String category;

	@Column(name = "PATHJSP")
	private String pathJSP;

	@Column(name = "PATHIMAGE")
	private String pathImage;

	@Column(name = "IMAGEHEADER")
	private String ImageHeader;

	@Column(name = "IMAGEFOOTER")
	private String ImageFooter;

	public String getImageHeader() {
		return ImageHeader;
	}

	public void setImageHeader(String imageHeader) {
		ImageHeader = imageHeader;
	}

	public String getImageFooter() {
		return ImageFooter;
	}

	public void setImageFooter(String imageFooter) {
		ImageFooter = imageFooter;
	}

	public String getIdStoreInfo() {
		return idStoreInfo;
	}

	public void setIdStoreInfo(String idStoreInfo) {
		this.idStoreInfo = idStoreInfo;
	}

	public String getIdStore() {
		return idStore;
	}

	public void setIdStore(String idStore) {
		this.idStore = idStore;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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
