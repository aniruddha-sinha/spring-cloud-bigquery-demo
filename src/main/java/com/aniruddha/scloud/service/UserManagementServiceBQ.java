package com.aniruddha.scloud.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aniruddha.scloud.client.SpringCloudBQClient;
import com.aniruddha.scloud.model.request.AddUserRequest;
import com.aniruddha.scloud.model.response.UserInsertResponse;

@Service
public class UserManagementServiceBQ {

	@Autowired
	private SpringCloudBQClient client; 
	
	private Log log = LogFactory.getLog(UserManagementServiceBQ.class);
	
	public ResponseEntity<UserInsertResponse> addUser(AddUserRequest addUserRequest) {
		log.info("Entered User Management (BQ) Service");
		return client.addUser(addUserRequest);
	}
}
