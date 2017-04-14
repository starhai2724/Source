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
	public ResultObject getPathJSP() {
		ResultObject response = new ResultObject(Status.ERROR);
		//get category store
		PathJSPOutputBean result = PathJSPImplment.intances.getPathJSP();
		
		if (null != result && result.getLst() != null && result.getLst().size() > 0) {
			response.setObj(result);
			response.setStatus(Status.SUCCESS);
		} else {
			response.setStatus(Status.ERROR);
		}

		return response;
	}
	
	@Path("/getPathJSPById")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public ResultObject getPathJSPById(PathJSPInputBean request) {
		ResultObject response = new ResultObject(Status.ERROR);
		//get category store
		PathJSPOutputBean result = PathJSPImplment.intances.getPathJSPById(request);
		
		if (null != result && result.getLst() != null && result.getLst().size() > 0) {
			response.setObj(result);
			response.setStatus(Status.SUCCESS);
		} else {
			response.setStatus(Status.ERROR);
		}

		return response;
	}
	
	
	
}
