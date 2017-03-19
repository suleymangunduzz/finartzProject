package com.finartz.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.finartz.beans.User;


//We use Component annotation because our service is not in the default package

@Component
public class UserServiceImpl implements UserService{

	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	
	//for Spring dependency for database
	//We use autowired annotation for mongodb.
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public String addNewUser(User user) {
		try {
			mongoTemplate.save(user);
			
			logger.info("User has been created");
		} catch (Exception e) {
			logger.error("User has not been created: " + e.getMessage());
		}
		
		return "user added";
	}

	@Override
	public String deleteUser(User user) {
		try {
			mongoTemplate.remove(user);
			
			logger.info("User has been deleted");
		} catch (Exception e) {
			logger.error("User has not been deleted: " + e.getMessage());
		}
		return "deleted";
	}

	@Override
	public List<User> getUsers() {
		return mongoTemplate.find(new Query(), User.class);
	}

}