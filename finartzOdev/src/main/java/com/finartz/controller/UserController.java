package com.finartz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.finartz.beans.User;
import com.finartz.service.UserService;


@RestController
public class UserController {

	// getting the MongoTemplate Bean from Service.
	@Autowired
	private UserService userService;
	
	//This method lists users
	@RequestMapping(value = "/userList", method = { RequestMethod.GET })
	public List<User> listUsers() {
		return userService.getUsers();
	}

	//This method add user object to database
	@RequestMapping(value = "/addNewUser", method = { RequestMethod.POST })
	public String addUser(@RequestBody User user) {
		return userService.addNewUser(user);
	}

	//This method deletes user object from database
	@RequestMapping(value = "/deleteUser", method = { RequestMethod.DELETE })
	public String deleteUser(@RequestBody User user) {
		return userService.deleteUser(user);		
	}
	
}