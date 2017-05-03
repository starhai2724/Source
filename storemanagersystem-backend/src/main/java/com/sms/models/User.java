package com.sms.models;

public class User {
	private String store_cd;
	private String URLStore;
	private String username;
	private String password;
	private String role;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getURLStore() {
		return URLStore;
	}
	public void setURLStore(String uRLStore) {
		URLStore = uRLStore;
	}


}
