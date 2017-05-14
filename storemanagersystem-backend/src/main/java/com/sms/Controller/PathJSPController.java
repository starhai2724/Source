package com.sms.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sms.common.Status;
import com.sms.impl.PathJSPImplment;
import com.sms.inputs.PathJSPInputBean;
import com.sms.models.ResultObject;
import com.sms.outputs.PathJSPOutputBean;

@Path("pathJSP")
public class PathJSPController {

	@Path("/getPathJSP")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public PathJSPOutputBean getPathJSP() {
		//get category store
		PathJSPOutputBean result = PathJSPImplment.intances.getPathJSP();
		return result;
	}
	
	@Path("/getPathJSPById")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public PathJSPOutputBean getPathJSPById(PathJSPInputBean request) {
		//get category store
		PathJSPOutputBean result = PathJSPImplment.intances.getPathJSPById(request);
		
		return result;
	}
	
	
	
}
