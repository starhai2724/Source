package com.sms.Controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sms.common.Status;
import com.sms.domain.StoreOwner;
import com.sms.impl.StoreOwnerImpl;
import com.sms.models.ResultObject;
import com.sms.models.StoreOwnerModel;
@Path("/storeOwner")
public class StoreOwnerController {

	@Path("/insert")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public ResultObject insert(StoreOwnerModel request) {
		ResultObject response = new ResultObject(Status.ERROR);
		StoreOwnerModel model = (StoreOwnerModel) request;
		System.out.println(model.getFullName());
		StoreOwner result = StoreOwnerImpl.storeOwnerIml.insertStoreOwner(request);
		System.out.println("abc ");
		if (null != result) {
			System.out.println("fullname: "+result.getFullName());
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
		List<StoreOwnerModel> result = StoreOwnerImpl.storeOwnerIml.getStoreOwners();
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
	public ResultObject getStoreOwnserBy(StoreOwnerModel storeOwnerModel) {
		ResultObject response = new ResultObject(Status.ERROR);
		List<StoreOwnerModel> result = StoreOwnerImpl.storeOwnerIml.getStoreOwnerBy(storeOwnerModel);
		if (null != result && result.size() > 0 ) {
			response.setObj(result);
			response.setStatus(Status.SUCCESS);
		} else {
			response.setStatus(Status.ERROR);
		}
		
		return response;
	}
	
	
}
