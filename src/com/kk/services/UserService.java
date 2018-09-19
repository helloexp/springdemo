package com.kk.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kk.TestController;
import com.kk.bean.User;
import com.kk.dao.UserDao;
import com.kk.util.ConnectUtil;

public class UserService implements UserDao {
	private static String usernameTemp="";
	
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

	@Override
	public User selectByName(String username,String password) {
		usernameTemp=username;
		if(usernameTemp==null) {
			usernameTemp="";
		}
		System.out.println("前台传入的username"+username+"  "+password);
		Connection conn=ConnectUtil.getConnection();
		try {
			Statement stat=conn.createStatement();
			String sql="select * from user where name="+"'"+username+"'";
			System.out.println(sql);
			
			ResultSet rs=stat.executeQuery(sql);
			if(rs.next()) {
				int id=rs.getInt(1);
				String name=rs.getString(2);
				int age=rs.getInt(3);
				System.out.println(id+" "+name+" "+age);
				TestController.msg="  密码错误";
				if(password.equals((age+""))){
					return new User(id,name,age);
				}
			}else {
				if(usernameTemp.length()>0){
					TestController.msg="  用户名不存在";
				}else {
					TestController.msg="  用户名不能为空";
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
