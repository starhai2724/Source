package com.sms.Controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sms.common.Status;
import com.sms.common.StringUtils;
import com.sms.domain.StoreOwner;
import com.sms.impl.StoreOwnerImpl;
import com.sms.inputs.StoreOwnerInputBean;
import com.sms.models.ResultObject;
import com.sms.outputs.StoreOwnerOutputBean;
@Path("/storeOwner")
public class StoreOwnerController {

	@Path("/insert")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public ResultObject insert(StoreOwnerInputBean request) {
		ResultObject response = new ResultObject(Status.ERROR);
		StoreOwner result = StoreOwnerImpl.storeOwnerIml.insertStoreOwner(request);
		if (null != result) {
			response.setObj(result);
			response.setStatus(Status.SUCCESS);
		} else {
			response.setStatus(Status.ERROR);
		}

		return response;
	}

	@Path("/getStoreOwners")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ResultObject getStoreOwnsers() {
		ResultObject response = new ResultObject(Status.ERROR);
		List<StoreOwnerOutputBean> result = StoreOwnerImpl.storeOwnerIml.getStoreOwners();
		if (null != result && result.size() > 0 ) {
			response.setObj(result);
			response.setStatus(Status.SUCCESS);
		} else {
			response.setStatus(Status.ERROR);
		}

		return response;
	}
	
	@Path("/getStoreOwnerBy")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public ResultObject getStoreOwnserBy(StoreOwnerInputBean storeOwnerInputBean) {
		ResultObject response = new ResultObject(Status.ERROR);
		List<StoreOwnerOutputBean> result = StoreOwnerImpl.storeOwnerIml.getStoreOwnerBy(storeOwnerInputBean);
		if (null != result && result.size() > 0 ) {
			response.setObj(result);
			response.setStatus(Status.SUCCESS);
		} 
		return response;
	}
	
	
	@Path("/getStoreOwnerById")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public ResultObject getStoreOwnerById(String id){
		ResultObject response = new ResultObject(Status.ERROR);
		StoreOwnerOutputBean result = StoreOwnerImpl.storeOwnerIml.getStoreOwnerById(id);
		//validation
		if(!StringUtils.isEmpty(result.getIdStoreOwner())){
			response.setObj(result);
			response.setStatus(Status.SUCCESS);
		}
		return response;
	}
	
	
	
	@Path("/updateStoreOwnerById")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public ResultObject updateStoreOwner(StoreOwnerInputBean storeOwnerModel){
		
		ResultObject response = new ResultObject(Status.ERROR);
		
		int result = StoreOwnerImpl.storeOwnerIml.editStoreOwner(storeOwnerModel);
		if( result == 1){
			response.setObj(result);
			response.setStatus(Status.SUCCESS);
		}
		
		return response;
	}
	
	
	@Path("/deleteStoreOwnerById")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public ResultObject deleteStoreOwnerById(StoreOwnerInputBean  storeOwnerInputBean){
		
		ResultObject response = new ResultObject(Status.ERROR);
		
		int result = StoreOwnerImpl.storeOwnerIml.deteleStoreOwnerById(storeOwnerInputBean);
		if( result == 1){
			response.setObj(result);
			response.setStatus(Status.SUCCESS);
		}
		
		return response;
	}
	/**
	 * check username exist
	 * @param username
	 * @return
	 */
	
	@Path("/getStoreOwnerByUsername")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public ResultObject getStoreOwnerByUsername(String username){
		ResultObject response = new ResultObject(Status.ERROR);
		String result = StoreOwnerImpl.storeOwnerIml.getStoreOwnerByUsername(username);
		if(result.compareTo("0") == 1){
			response.setStatus(Status.CANCEL);
		}else if(result.compareTo("0") == 0){
			response.setStatus(Status.SUCCESS);
		}
		return response;
		
	}
	
	
}
