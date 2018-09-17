package com.kk;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kk.bean.User;
import com.kk.services.UserService;

@Controller
@RequestMapping("/test")
public class TestController {
	private UserService userServivce;
	
	@RequestMapping("/selectAll")
	public String test(HttpServletRequest request) {
		UserService userService=new UserService();
		List<User> list=userService.selectAll();
		
//		User user1=new User(1,"zhangsan",18);
//		User user2=new User(2,"lisi",19);
//		User user3=new User(1,"Tom",20);
//		
//		list.add(user1);
//		list.add(user2);
//		list.add(user3);
		request.setAttribute("users", list);
		return "success";
	}
	
	@RequestMapping("/add")
	public String add(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		userServivce=new UserService();
		
		int id =Integer.parseInt(request.getParameter("id"));
		byte[] b=request.getParameter("name").getBytes("utf-8");
		
		String name=new String(b,"utf-8");
		int age =Integer.parseInt(request.getParameter("age"));
		
		userServivce.add(new User(id,name,age));
		System.out.println("添加用户："+id+" "+name+" "+age);
		return "result";
	}
}
