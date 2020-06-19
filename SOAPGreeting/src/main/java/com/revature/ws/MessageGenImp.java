package com.revature.ws;

import javax.jws.WebService;

@WebService(endpointInterface = "com.revature.ws.MessageGen",
serviceName="messageGenService")
public class MessageGenImp implements MessageGen{

	public String getMessage() {
		
		return "To Infinity and Beyond...";
	}

}