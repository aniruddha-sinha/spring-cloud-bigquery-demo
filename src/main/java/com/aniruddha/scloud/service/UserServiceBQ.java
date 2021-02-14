package com.aniruddha.scloud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aniruddha.scloud.client.SpringCloudBQClient;
import com.aniruddha.scloud.model.User;

@Service
public class UserServiceBQ {

	@Autowired
	private SpringCloudBQClient client;
	
	public ResponseEntity<List<User>> getListOfUsers() {
		return client.getListOfUsers();
	}
}
