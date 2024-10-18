package com.taskapp.LoginToDo.service;

import org.springframework.stereotype.Service;

import java.util.List;

import com.taskapp.LoginToDo.controller.bean.User;
//@Service
public interface UserService {

	User getUserByUserId(String userId);
	
	int createNewUser(User user);
	
	List<User> getAllUsers();
	
}