package com.sms.Controller;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sms.common.Status;
import com.sms.dao.RegisterProductCategoryDAO;
import com.sms.inputs.RegisterProductCategoryInputBean;
import com.sms.models.ResultObject;
import com.sms.outputs.RegisterProductCategoryOutputBean;

@Path("/RegisterProductCategory")
public class RegisterProductCategoryCtrl {

	@Path("/init")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public RegisterProductCategoryOutputBean getProductCategory(RegisterProductCategoryInputBean request){
		
		RegisterProductCategoryOutputBean categoryOutputBean = RegisterProductCategoryDAO.intances.getProductCategory(request);
		if(null != categoryOutputBean && categoryOutputBean.getLst().size()>0){
			return categoryOutputBean;
		}
		return null;
	}
	
	@Path("/insert")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public ResultObject insertProductCategory(RegisterProductCategoryInputBean request){
		ResultObject response = new ResultObject(Status.ERROR);
		System.out.println("id: "+request.getNameProductCategory());
		int result = RegisterProductCategoryDAO.intances.insertProdcutCategory(request);
		System.out.println("result: "+result);
		if(result == 0){
			response.setObj(result);
			response.setStatus(Status.SUCCESS);
		}
		return response;
	}
}
