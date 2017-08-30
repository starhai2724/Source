package com.sms.Conversation;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;

import com.google.gson.annotations.JsonAdapter;
import com.ibm.watson.developer_cloud.conversation.v1.ConversationService;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageRequest;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;

@Path("/converastion")
public class DemoController {

	MessageResponse response = null;
	/**
	 * insert registerUser
	 * @param request
	 * @return
	 */
	@Path("/v1")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public String insert(String req) {
//		req = "bye";
		System.out.println("req: "+req);
		Map context = new HashMap();
//		MessageResponse response = conversationAPI(req, context);
		response = BVTService.conversationAPI(req, context);
		context = response.getContext();
		System.out.println("Watson Response:" + response.getText().get(0));
		context = response.getContext();
		System.out.println("———–");
//		return response.getText().get(0).toString();
		return "{\"success\":\""+response.getText().get(0).toString()+"\"}";
	}
	public static void main(String[] args) {
		DemoController controller = new DemoController();
		controller.insert("bye");
//		controller.insert("bye");
	}
	
}
