package com.kk.dao;

import com.kk.User;

public interface UserDao {
	void add(User user);
	User select(String name);
}
