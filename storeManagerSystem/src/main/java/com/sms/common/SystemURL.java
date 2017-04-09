package com.sms.common;

public class SystemURL {
	private static String systemURL ="http://localhost:3000/systembackend/";
	
	public static final String CHECK_LOGIN=systemURL+"login/checklogin";
	
	public static final String STOREOWNER_INSERT=systemURL+"storeOwner/insert";
	
	public static final String STOREOWNER_LIST=systemURL+"storeOwner/getStoreOwners";
	
	public static final String STOREOWNER_LIST_BY=systemURL+"storeOwner/getStoreOwnerBy";
	
	public static final String STOREOWNER_BY_ID=systemURL+"storeOwner/getStoreOwnerById";
	
	public static final String UPDATE_STOREOWNER_BY_ID=systemURL+"storeOwner/updateStoreOwnerById";
	
	public static final String DELETE_STOREOWNER_BY_ID=systemURL+"storeOwner/deleteStoreOwnerById";
	
	// check username exist
	public static final String GET_STOREOWNER_BY_USERNAME=systemURL+"storeOwner/getStoreOwnerByUsername";
}
