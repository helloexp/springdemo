package com.kk.dao;

import java.util.List;

import com.kk.bean.User;

public interface UserDao {
	void add(User user);
	List<User> selectAll();
}
