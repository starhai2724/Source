package com.sms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STORE")
public class Store {
	
	@Id
	@Column(name = "ID_STORE", length = 12)
	private String idStore;
	@Column(name = "ID_TYPE_STORE", length = 6)
	private String idTypeStore;
	@Column(name = "ID_GROUP_STORE", length = 6)
	private String idGroupStore;
	@Column(name = "ID_STORE_OWNER", length = 6)
	private String idStoreOwner;
	
	@Column(name = "DELETE_FLAG", length = 1)
	private String deleteFlag;
	
	@Column(name = "USERINSERT")
	private String userInsert;
	
	@Column(name = "DATEINSERT")
	private String dateInsert;
	
	@Column(name = "USERUPDATE")
	private String userUpdate;
	
	@Column(name = "DATEUPDATE")
	private String dateUpdate;
	
	public Store() {
	}

	/**
	 * @return the deleteFlag
	 */
	public String getDeleteFlag() {
		return deleteFlag;
	}

	/**
	 * @param deleteFlag the deleteFlag to set
	 */
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	/**
	 * @return the userInsert
	 */
	public String getUserInsert() {
		return userInsert;
	}

	/**
	 * @param userInsert the userInsert to set
	 */
	public void setUserInsert(String userInsert) {
		this.userInsert = userInsert;
	}

	/**
	 * @return the dateInsert
	 */
	public String getDateInsert() {
		return dateInsert;
	}

	/**
	 * @param dateInsert the dateInsert to set
	 */
	public void setDateInsert(String dateInsert) {
		this.dateInsert = dateInsert;
	}

	/**
	 * @return the userUpdate
	 */
	public String getUserUpdate() {
		return userUpdate;
	}

	/**
	 * @param userUpdate the userUpdate to set
	 */
	public void setUserUpdate(String userUpdate) {
		this.userUpdate = userUpdate;
	}

	/**
	 * @return the dateUpdate
	 */
	public String getDateUpdate() {
		return dateUpdate;
	}

	/**
	 * @param dateUpdate the dateUpdate to set
	 */
	public void setDateUpdate(String dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	/**
	 * @return the idStore
	 */
	public String getIdStore() {
		return idStore;
	}

	/**
	 * @param idStore
	 *            the idStore to set
	 */
	public void setIdStore(String idStore) {
		this.idStore = idStore;
	}

	/**
	 * @return the idTypeStore
	 */
	public String getIdTypeStore() {
		return idTypeStore;
	}

	/**
	 * @param idTypeStore
	 *            the idTypeStore to set
	 */
	public void setIdTypeStore(String idTypeStore) {
		this.idTypeStore = idTypeStore;
	}

	/**
	 * @return the idGroupStore
	 */
	public String getIdGroupStore() {
		return idGroupStore;
	}

	/**
	 * @param idGroupStore
	 *            the idGroupStore to set
	 */
	public void setIdGroupStore(String idGroupStore) {
		this.idGroupStore = idGroupStore;
	}

	/**
	 * @return the idStoreOwner
	 */
	public String getIdStoreOwner() {
		return idStoreOwner;
	}

	/**
	 * @param idStoreOwner
	 *            the idStoreOwner to set
	 */
	public void setIdStoreOwner(String idStoreOwner) {
		this.idStoreOwner = idStoreOwner;
	}

}
