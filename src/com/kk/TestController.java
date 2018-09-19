package com.kk;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kk.bean.User;
import com.kk.services.UserService;

@Controller
@RequestMapping("/test")
public class TestController {
	public static String msg="";
	private UserService userServivce;
	
	@RequestMapping("/selectAll")
	public String test(HttpServletRequest request) {
		UserService userService=new UserService();
		List<User> list=userService.selectAll();
		
		int ageSum=0,ageAve;
		int index=0;
		for (User user : list) {
			index+=1;
			ageSum+=user.getAge();
		}
		ageAve=ageSum/index;
		
//		User user1=new User(1,"zhangsan",18);
//		User user2=new User(2,"lisi",19);
//		User user3=new User(1,"Tom",20);
//		
//		list.add(user1);
//		list.add(user2);
//		list.add(user3);
		request.setAttribute("users", list);
		request.setAttribute("ageSum", ageSum);
		request.setAttribute("ageAve", ageAve);
		return "success";
	}
	
	@RequestMapping("/add")
	public String add(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		userServivce=new UserService();
		int id=0;
		try {
			id =Integer.parseInt(request.getParameter("id"));
		}catch(NumberFormatException e){
			e.printStackTrace();
			request.setAttribute("msg", "没有给参数赋值");
			return "result";
		}
		byte[] b=request.getParameter("name").getBytes("utf-8");
		
		String name=new String(b,"utf-8");
		int age =Integer.parseInt(request.getParameter("age"));
		
		userServivce.add(new User(id,name,age));
		System.out.println("添加用户："+id+" "+name+" "+age);
		return "result";
	}
	
	@RequestMapping("/login")
//	public String login(@RequestParam("username") String username,@RequestParam("password")String password,Model model) {
	public String login(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		System.out.println(username+"    "+password);
		String msg="error";
		try {
			if("".equals(username)) {
				msg="用户名不能为空";
				return "login";
			}
		}catch(Exception e) {
			e.printStackTrace();
			msg="error";
			return "login";
		}
		
		UserService userService=new UserService();
		User user=userService.selectByName(username, password);
		System.out.println(user);
		if(user==null) {
			msg="登录失败，请重新登录"+this.msg;
		}else {
			msg="登录成功，恭喜"+username;
		}
		request.setAttribute("msg", msg);
		
		
		return "login";
	}
}
