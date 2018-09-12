package com.kk.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.kk.User;
import com.kk.dao.UserDao;
import com.kk.util.ConnectUtil;

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
		Connection conn=ConnectUtil.getConnection();
		try {
			Statement stat=conn.createStatement();
			String sql="insert into User(name,age) values"+"('"+user.getName()+"',"+user.getAge()+")";
			
//			String sql="insert into User(name,age) values ('Tom',23)";
			System.out.println("执行的sql语句： "+sql);
			stat.executeUpdate(sql);
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("UserService 添加用户到数据库失败");
		}
		System.out.println("UserService added a user...");
	}
	
	
}
