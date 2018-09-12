package com.kk;

import java.sql.Connection;

import com.kk.util.ConnectUtil;

public class TestUtil {

	public static void main(String[] args) {
		Connection conn=ConnectUtil.getConnection();
		if(conn!=null) {
			System.out.println("成功获取到数据库连接");
		}else {
			System.out.println("获取数据库连接失败");
		}
	}

}
