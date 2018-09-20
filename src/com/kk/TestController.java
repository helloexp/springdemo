package com.kk;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.kk.bean.User;
import com.kk.services.UserService;
import com.sun.glass.ui.CommonDialogs.Type;

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
	
	@RequestMapping("mvtest")
	public ModelAndView mvtest() {
		List<User> list=new ArrayList<>();
		ModelAndView mv=new ModelAndView("test");
		User zhangsan=new User(1001,"zhangsan",30);
		User lisi=new User(1002,"lisi",20);
		User zhaoliu=new User(1003,"zhaoliu",38);
		User wangwu=new User(1004,"wangwu",18);
		
		list.add(zhangsan);
		list.add(lisi);
		list.add(zhaoliu);
		list.add(wangwu);
		
		mv.addObject("list", list);
		mv.addObject("user", zhangsan);
		
		return mv;
	}
	
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public String upload(HttpServletRequest request) {
		MultipartHttpServletRequest mreq=(MultipartHttpServletRequest) request;
		MultipartFile file=mreq.getFile("filename");
		
		String filename=file.getOriginalFilename();
		System.out.println("上传文件名："+filename);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		try {
			String basepath=request.getSession().getServletContext().getRealPath("/")+"upload/";
			String randomFileName=sdf.format(new Date())+filename.substring(filename.lastIndexOf("."));
			String type=filename.substring(filename.lastIndexOf('.')+1, filename.length());
			type=type.toUpperCase();
			System.out.println("文件类型："+type);
			if(!(type.equals("JPG")||type.equals("GIF")||type.equals("PNG")||type.equals("JPEG"))) {
				request.setAttribute("msg", "文件类型错误，请重新选择");
				return "upload";
			}
			
			String fileTosave=basepath+randomFileName;
			
			System.out.println(fileTosave);
			FileOutputStream fos=new FileOutputStream(fileTosave);
			fos.write(file.getBytes());
			fos.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("msg", "文件："+filename+" 上传成功");
		return "upload";
	}
}
