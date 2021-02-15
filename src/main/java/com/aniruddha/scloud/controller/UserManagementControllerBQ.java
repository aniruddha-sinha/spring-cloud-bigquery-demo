package com.aniruddha.scloud.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aniruddha.scloud.model.request.AddUserRequest;
import com.aniruddha.scloud.model.response.UserInsertResponse;
import com.aniruddha.scloud.service.UserManagementServiceBQ;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/apis")
public class UserManagementControllerBQ {

	@Autowired
	private UserManagementServiceBQ userManagementService;

	private Log log = LogFactory.getLog(UserManagementControllerBQ.class);
	@PostMapping("/users/add")
	@ApiOperation("Rest API to add User to BigQuery Table")
	public ResponseEntity<UserInsertResponse> addUser(@RequestBody AddUserRequest addUserRequest) {
		
		log.info("Entered User Management (BQ) Controller");
		
		return userManagementService.addUser(addUserRequest);
	}
}
