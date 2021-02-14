package com.aniruddha.scloud.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.aniruddha.scloud.model.User;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.FieldValueList;
import com.google.cloud.bigquery.JobException;
import com.google.cloud.bigquery.QueryJobConfiguration;

@Component
public class SpringCloudBQClient {

	@Autowired
	private BigQuery bigQuery;

	private Log log = LogFactory.getLog(SpringCloudBQClient.class);

	public ResponseEntity<List<User>> getListOfUsers() {
		QueryJobConfiguration queryConfig = QueryJobConfiguration.newBuilder(QueryConstants.FETCH_USERS_QUERY).build();
		return fetchUsers(queryConfig);
	}

	public ResponseEntity<User> getUserByEmail(String emailId) {
		final String fetchUsersByEmail = String.format(QueryConstants.FETCH_USER_BY_EMAIL, emailId);
		QueryJobConfiguration queryConfig = QueryJobConfiguration.newBuilder(fetchUsersByEmail).build();
		return ResponseEntity.ok(fetchUsers(queryConfig).getBody().get(0));
	}

	private ResponseEntity<List<User>> fetchUsers(QueryJobConfiguration queryConfig) {
		User user = null;
		List<User> userList = null;
		try {
			userList = new ArrayList<>();
			for (FieldValueList row : bigQuery.query(queryConfig).iterateAll()) {
				user = new User();

				user.setUserId(Integer.valueOf(row.get("user_id").getStringValue()));
				user.setUserName(row.get("user_name").getStringValue());
				user.setEmail(row.get("email").getStringValue());
				user.setMobileNumber(row.get("mobile_number").getStringValue());
				user.setFaxNumber(row.get("fax_number").getStringValue());
				user.setIsEmailValid(row.get("is_email_valid").getBooleanValue());
				user.setIsMobileValid(row.get("is_mobile_valid").getBooleanValue());
				user.setUserStatus(row.get("user_status").getStringValue());
				// add user to the list
				userList.add(user);
			}

		} catch (JobException | InterruptedException e) {
			log.error("Error Encountered while Fetching Users: " + e.getMessage());
		}

		if (Objects.isNull(userList)) {
			log.warn("Warning! The user Objects is null; Potential Error Scenario");
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(userList);
		}
	}

	static class QueryConstants {
		static final String FETCH_USERS_QUERY = "SELECT * FROM User.User";
		static final String FETCH_USER_BY_EMAIL = "SELECT * FROM User.User where email = \'%s\'";
	}
}
