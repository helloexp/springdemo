package com.kk.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kk.bean.User;
import com.kk.dao.UserDao;
import com.kk.util.ConnectUtil;

public class UserService implements UserDao {
	
	@Override
	public void add(User user) {
		Connection conn=ConnectUtil.getConnection();
		
		try {
			Statement stat=conn.createStatement();
			String sql="insert into user(name,age) values"+"('"+user.getName()+"',"+user.getAge()+")";
			System.out.println("执行的添加语句："+sql);
			stat.executeUpdate(sql);
			
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<User> selectAll() {
		Connection conn=ConnectUtil.getConnection();
		List<User> user=new ArrayList<>();
		
		try {
			Statement stat=conn.createStatement();
			String sql="select * from user";
			System.out.println("执行的添加语句："+sql);
			ResultSet rs=stat.executeQuery(sql);
			while(rs.next()) {
				int id=rs.getInt(1);
				String name=rs.getString(2);
				int age=rs.getInt(3);
				user.add(new User(id, name, age));
			}
			
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}

}
