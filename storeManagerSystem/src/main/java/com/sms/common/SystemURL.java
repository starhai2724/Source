package com.sms.common;

public class SystemURL {
	private static String systemURL ="http://localhost:3000/systembackend/";
	
	public static final String CHECK_LOGIN=systemURL+"login/checklogin";
	
	/**StoreOwner 10.04.2017 Hai.NT(S)*/
	public static final String STOREOWNER_INSERT=systemURL+"storeOwner/insert";
	
	public static final String STOREOWNER_LIST=systemURL+"storeOwner/getStoreOwners";
	
	public static final String STOREOWNER_LIST_BY=systemURL+"storeOwner/getStoreOwnerBy";
	
	public static final String STOREOWNER_BY_ID=systemURL+"storeOwner/getStoreOwnerById";
	
	public static final String UPDATE_STOREOWNER_BY_ID=systemURL+"storeOwner/updateStoreOwnerById";
	
	public static final String DELETE_STOREOWNER_BY_ID=systemURL+"storeOwner/deleteStoreOwnerById";
	
	// check username exist
	public static final String GET_STOREOWNER_BY_USERNAME=systemURL+"storeOwner/getStoreOwnerByUsername";
	
	/**StoreOwner 10.04.2017 Hai.NT(E)*/
	
	
	/**PathJSP 10.04.2017 Hai.NT(S)*/
	//get all category store
	public static final String PATHJSP_GETPATHJSP = systemURL+"pathJSP/getPathJSP";
	
	//get one category store by id
	public static final String PATHJSP_GETPATHJSPBYID = systemURL+"pathJSP/getPathJSPById";
	
	/**PathJSP 10.04.2017 Hai.NT(E)*/
	
	
	/**Register user 20.04.2017 Hai.NT(S)*/
	public static final String REGISTERUSER_INSERT = systemURL+"RegisterUser/insert";
	
	public static final String CHECK_EXIST_DOMAIN = systemURL+"RegisterUser/checkExistDomain";
	
	/**Register user 20.04.2017 Hai.NT(E)*/
	
	
	/**Register product category 20.04.2017 Hai.NT(S)*/
	public static final String REGISTER_PRODUCT_CATEGORY_INIT = systemURL+"RegisterProductCategory/init";
	
	public static final String REGISTER_PRODUCT_CATEGORY_INSERT = systemURL+"RegisterProductCategory/insert";
	/**Register product category 20.04.2017 Hai.NT(E)*/
	
	/**Register product  22.05.2017 Hai.NT(S)*/
	public static final String GET_PRODUCTS = systemURL+"/product/getProducts";
	
//	public static final String REGISTER_PRODUCT_CATEGORY_INSERT = systemURL+"RegisterProductCategory/insert";
	/**Register product  22.05.2017 Hai.NT(E)*/
	
}
