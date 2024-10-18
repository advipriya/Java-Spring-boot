package com.taskapp.LoginToDo.dao;

import java.util.List;

import com.taskapp.LoginToDo.controller.bean.User;

public interface UserDao {

	User getUserById(String userId);
	
	int createNewUser(User user);
	
	List<User> getAllUsers();
	
}