package com.aniruddha.scloud.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aniruddha.scloud.model.User;
import com.aniruddha.scloud.service.UserServiceBQ;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/apis")
public class UserControllerBQ {

	@Autowired
	private UserServiceBQ userServiceBQ;

	private Log log = LogFactory.getLog(UserControllerBQ.class);
	
	@GetMapping("/users/list")
	@ApiOperation("Rest API to get the list of Users from BigQuery")
	public ResponseEntity<List<User>> getListOfUsers() {
		log.info("Entered User (BQ) Controller");
		return userServiceBQ.getListOfUsers();
	}
}
