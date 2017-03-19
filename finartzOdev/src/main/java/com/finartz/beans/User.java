package com.finartz.beans;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


//User class provides some informations which will use for mongodb database.

//Document tag for Bean
@Document
public class User {

	//@Id means that is the primary key of this object.
	@Id
	private String id;

	private String name;
	private String phone;
	
	public User(){
		
	}

	public User(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "UsersBean [name=" + name + ", phone=" + phone + "]";
	}
}