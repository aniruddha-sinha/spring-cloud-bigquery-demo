package com.aniruddha.scloud.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aniruddha.scloud.client.SpringCloudBQClient;
import com.aniruddha.scloud.model.response.User;

@Service
public class UserServiceBQ {

	@Autowired
	private SpringCloudBQClient client;
	
	private Log log = LogFactory.getLog(UserServiceBQ.class);
	
	public ResponseEntity<List<User>> getListOfUsers() {
		log.info("Entered getListOfUsers in UserServiceBQ");
		return client.getListOfUsers();
	}
	
	public ResponseEntity<User> getUserDetailsByEmailId(String email) {
		return client.getUserByEmail(email);
	}
}
