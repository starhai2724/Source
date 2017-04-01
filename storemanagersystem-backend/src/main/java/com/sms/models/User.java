package com.sms.models;

public class User {
	private String store_cd;
	private String username;
	private String password;
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
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
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the store_cd
	 */
	public String getStore_cd() {
		return store_cd;
	}
	/**
	 * @param store_cd the store_cd to set
	 */
	public void setStore_cd(String store_cd) {
		this.store_cd = store_cd;
	}


}
