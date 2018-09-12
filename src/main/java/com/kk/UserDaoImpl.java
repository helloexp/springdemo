package com.kk;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.kk.dao.UserDao;
import com.kk.util.ConnectUtil;

public class UserDaoImpl implements UserDao{

	public void add(User user) {
		Connection conn=ConnectUtil.getConnection();
		try {
			Statement stat=conn.createStatement();
			String sql="insert into User(name,age) values"+"('"+user.getName()+"',"+user.getAge()+")";
			
//			String sql="insert into User(name,age) values ('Tom',23)";
			System.out.println("执行的sql语句： "+sql);
			stat.executeUpdate(sql);
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("UserService 添加用户到数据库失败");
		}
		System.out.println("UserService 成功在数据库插入一条数据");
		
	}

	public User select(String userName) {
		Connection conn=ConnectUtil.getConnection();
		User user=null;
		try {
			Statement stat=conn.createStatement();
			String sql="select * from user where name="+"'"+userName+"'";
			System.out.println("执行的sql语句："+sql);
			
			ResultSet rs=stat.executeQuery(sql);
			if(rs.next()) {
				int id=rs.getInt(1);
				String name=rs.getString(2);
				int age=rs.getInt(3);
				
				user=new User();
				user.setId(id);
				user.setName(name);
				user.setAge(age);
				System.out.println("找到用户："+name);
			}
			
			return user;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	

}
