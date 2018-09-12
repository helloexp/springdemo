package com.kk.services;

import com.kk.User;
import com.kk.dao.UserDao;

public class UserService {
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void add(User user) {
		userDao.add(user);
	}
	
	public User select(String name) {
		return userDao.select(name);
	}
	
	
}
