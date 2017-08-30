package com.sms.Conversation;

import com.ibm.watson.developer_cloud.conversation.v1.ConversationService;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageRequest;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BVTService {
	public static void main(String[] args) {
		BufferedReader br = null;
		MessageResponse response = null;
		Map context = new HashMap();
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			while (true) {
				System.out.print("Enter something : ");
				String input = br.readLine();
				if ("q".equals(input)) {
					System.out.println("Exit!");
					System.exit(0);
				}
				response = conversationAPI(input, context);
				System.out.println("Watson Response:" + response.getText().get(0));
				context = response.getContext();
				System.out.println("context: "+context);
				System.out.println("———–");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static MessageResponse conversationAPI(String input, Map context) {
		ConversationService service = new ConversationService("2017-02-03");
		service.setUsernameAndPassword("e1332cd4-4e07-4956-aa3d-2d781c38ec65", "fomACdEhqTUf");
		MessageRequest newMessage = new MessageRequest.Builder().inputText(input).context(context).build();
		String workspaceId = "8bbe779a-aa58-41a7-ad34-a1b6ac453299";
		MessageResponse response = service.message(workspaceId, newMessage).execute();
		return response;
	}
}