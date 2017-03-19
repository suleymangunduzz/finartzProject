package com.finartz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;


//You can use this class for testing the project without connecting to database.

@Component
public class ContextListener implements ApplicationListener<ContextRefreshedEvent> {


	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
	
		/*
		 * The classes that implements ApplicationListener runs when Spring Context is initialized.
		 * 
		 * */
		
		
		/*mongoTemplate.dropCollection(User.class);
		
		User user = new User("Enes Altınkaya","1837183");
		mongoTemplate.save(user);
	
		user = new User("Süleyman","3891273");
		mongoTemplate.save(user);
		
		user = new User("Osman Kaya","23091023");
		mongoTemplate.save(user);*/
	
	}

}