package com.sms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STORE_INFO")
public class StoreInformation {

	@Id
	@Column(name = "ID_STORE", length=6)
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
	
	@Column(name = "IMAGEHEADER1")
	private String ImageHeader1;
	
	@Column(name = "IMAGEHEADER2")
	private String ImageHeader2;
	
	@Column(name = "IMAGEHEADER3")
	private String ImageHeader3;
	
	@Column(name = "IMAGEHEADER4")
	private String ImageHeader4;
	
	@Column(name = "IMAGEHEADER5")
	private String ImageHeader5;

	@Column(name = "IMAGEFOOTER")
	private String ImageFooter;
	
	@Column(name = "DieuKienShipFree")
	private String DieuKienShipFree;


	public String getDieuKienShipFree() {
		return DieuKienShipFree;
	}

	public void setDieuKienShipFree(String dieuKienShipFree) {
		DieuKienShipFree = dieuKienShipFree;
	}

	public String getImageHeader() {
		return ImageHeader;
	}

	public void setImageHeader(String imageHeader) {
		ImageHeader = imageHeader;
	}

	public String getImageHeader1() {
		return ImageHeader1;
	}

	public void setImageHeader1(String imageHeader1) {
		ImageHeader1 = imageHeader1;
	}

	public String getImageHeader2() {
		return ImageHeader2;
	}

	public void setImageHeader2(String imageHeader2) {
		ImageHeader2 = imageHeader2;
	}

	public String getImageHeader3() {
		return ImageHeader3;
	}

	public void setImageHeader3(String imageHeader3) {
		ImageHeader3 = imageHeader3;
	}

	public String getImageHeader4() {
		return ImageHeader4;
	}

	public void setImageHeader4(String imageHeader4) {
		ImageHeader4 = imageHeader4;
	}

	public String getImageHeader5() {
		return ImageHeader5;
	}

	public void setImageHeader5(String imageHeader5) {
		ImageHeader5 = imageHeader5;
	}

	public String getImageFooter() {
		return ImageFooter;
	}

	public void setImageFooter(String imageFooter) {
		ImageFooter = imageFooter;
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
