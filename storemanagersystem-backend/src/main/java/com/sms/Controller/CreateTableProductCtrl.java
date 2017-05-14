package com.sms.Controller;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sms.dao.CreateTableProductDAO;

@Path("/tableProduct")
public class CreateTableProductCtrl {
	
	@Path("/create")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public boolean createTable(String pathJSP) {
		
		int cnt = CreateTableProductDAO.intances.createTableProduct(pathJSP);
		if(cnt == 1){
			return true;
		}
		return false;
	}
	
	
	
	@Path("/delete")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public boolean deleteTable(String pathJSP) {
		int cnt = CreateTableProductDAO.intances.deleteTableProduct(pathJSP);
		if(cnt == 1){
			return true;
		}
		return false;
	}
}
