package com.sms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STORE_OWNER")
public class StoreOwner {
	@Id
	@Column(name = "ID_STORE_OWNER", length = 6)
	private String idStoreOwner;

	@Column(name = "USERNAME", length = 8)
	private String username;

	@Column(name = "PASSWORD", length = 8)
	private String password;

	@Column(name = "ROLE")
	private String role;

	@Column(name = "FULLNAME")
	private String fullName;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "TELEPHONE")
	private String telephone;

	@Column(name = "EMAIL")
	private String email;

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

	public StoreOwner() {
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

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the deleteFlag
	 */
	public String getDeleteFlag() {
		return deleteFlag;
	}

	/**
	 * @param deleteFlag
	 *            the deleteFlag to set
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
	 * @param userInsert
	 *            the userInsert to set
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
	 * @param dateInsert
	 *            the dateInsert to set
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
	 * @param userUpdate
	 *            the userUpdate to set
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
	 * @param dateUpdate
	 *            the dateUpdate to set
	 */
	public void setDateUpdate(String dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName
	 *            the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone
	 *            the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}
