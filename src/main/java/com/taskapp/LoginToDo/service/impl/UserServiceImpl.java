package com.taskapp.LoginToDo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskapp.LoginToDo.controller.bean.User;
import com.taskapp.LoginToDo.dao.UserDao;
import com.taskapp.LoginToDo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Override
	public User getUserByUserId(String userId) {
		User user = userDao.getUserById(userId);
		return user;
	}

	@Override
	public int createNewUser(User user) {
		int count = userDao.createNewUser(user);
        if (count == -1) {
        	return -1;
        }
        return count; 
    }
	

	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

}