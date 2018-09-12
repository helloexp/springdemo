package com.kk;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kk.services.UserService;

public class TestUser {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		User user=(User) context.getBean("user");
		/*user.setId(1001);
		user.setName("Tom");
		user.setAge(20);*/
		
		System.out.println("配置文件提供的user信息--->"+user);
		UserService userService=(UserService) context.getBean("userService");
		
		user.setName("lisi");
		user.setAge(19);
		
//		userService.add(user);
		User user2=userService.select("tom");
		System.out.println(user2);
		
		
	}

}
