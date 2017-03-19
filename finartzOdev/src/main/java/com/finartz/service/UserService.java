package com.finartz.service;

import java.util.List;

import com.finartz.beans.User;

//This interface shows us the methods which we can use to add,delete and list users.
//And We use this interface with UserService class

public interface UserService {

	String addNewUser(User user);
	String deleteUser(User user);
	List<User> getUsers();
	
}