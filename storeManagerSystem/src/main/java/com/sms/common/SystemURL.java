package com.sms.common;

public class SystemURL {
	private static String systemURL ="http://localhost:3000/systembackend/";
	
	public static final String CHECK_LOGIN=systemURL+"login/checklogin";
	
	public static final String STOREOWNER_INSERT=systemURL+"storeOwner/insert";
	
	public static final String STOREOWNER_LIST=systemURL+"storeOwner/getStoreOwners";
	
	public static final String STOREOWNER_LIST_BY=systemURL+"storeOwner/getStoreOwnerBy";
}
