package com.kk;

import java.sql.Connection;

import com.kk.bean.User;
import com.kk.services.UserService;
import com.kk.util.ConnectUtil;

public class TestMain {

	public static void main(String[] args) {
		Connection conn=ConnectUtil.getConnection();
		UserService userService=new UserService();
		User user=new User(1,"曹洪",28);
		userService.add(user);
	}

}
