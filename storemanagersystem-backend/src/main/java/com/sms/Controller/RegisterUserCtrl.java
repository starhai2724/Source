package com.sms.Controller;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sms.common.Status;
import com.sms.dao.RegisterUserDAO;
import com.sms.impl.RegisterUserImpl;
import com.sms.inputs.RegisterUserInputBean;
import com.sms.models.ResultObject;

@Path("/RegisterUser")
public class RegisterUserCtrl {

	/**
	 * insert registerUser
	 * @param request
	 * @return
	 */
	@Path("/insert")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public ResultObject insert(RegisterUserInputBean request) {
		ResultObject response = new ResultObject(Status.ERROR);
		int result = RegisterUserImpl.registerUserImpl.insertRegisterUser(request);
		if (result != 0) {
			response.setObj(result);
			response.setStatus(Status.SUCCESS);
		} else {
			response.setStatus(Status.ERROR);
		}

		return response;
	}
	
	@Path("/checkExistDomain")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public boolean checkDoamain(String domain){
		return  RegisterUserDAO.intances.checkExistDomain(domain);
	}
	
}
