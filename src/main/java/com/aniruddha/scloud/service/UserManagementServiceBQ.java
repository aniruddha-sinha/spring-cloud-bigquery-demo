package com.aniruddha.scloud.service;

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
	
	public ResponseEntity<UserInsertResponse> addUser(AddUserRequest addUserRequest) {
		return client.addUser(addUserRequest);
	}
}
