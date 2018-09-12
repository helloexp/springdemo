package com.kk.ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kk.User;
import com.kk.services.UserService;

public class MainFrame extends JFrame implements ActionListener{
	/**
	 * 	对用户进行增删改查的UI界面
	 */
	private static final long serialVersionUID = 1L;
	ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
	JButton selectUser,addUser,updateUser,deleteUser,testUser,exitSys;
	JFrame jfMain;
	public static void main(String[] args) {
		new MainFrame().init();
	}
	
	public void init() {
		jfMain=new JFrame("学生信息管理系统 v1.0");
		jfMain.setLayout(new GridLayout(4, 3));
		jfMain.setSize(400, 300);
		selectUser=new JButton("查询学生");
		addUser=new JButton("添加学生");
		updateUser=new JButton("修改学生");
		deleteUser=new JButton("删除学生");
		testUser=new JButton("测试学生");
		exitSys=new JButton("退出系统");
		jfMain.add(selectUser);
		jfMain.add(addUser);
		jfMain.add(updateUser);
		jfMain.add(deleteUser);
		jfMain.add(testUser);
		jfMain.add(exitSys);
		
		selectUser.addActionListener(this);
		addUser.addActionListener(this);
		updateUser.addActionListener(this);
		deleteUser.addActionListener(this);
		testUser.addActionListener(this);
		exitSys.addActionListener(this);
		
		jfMain.setLocationRelativeTo(null);
		jfMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfMain.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		final UserService userService =(UserService) context.getBean("userService");
		final User user=(User) context.getBean("user");
		
		final JFrame jf=new JFrame("操作窗体");
		if(e.getSource()==addUser) {
			System.out.println("点击了添加学生按钮！");
			JLabel name=new JLabel("请输入用户名：");
			final JTextField getName=new JTextField(20);
			JLabel age=new JLabel("请输入年龄：");
			final JTextField getAge=new JTextField(20);
			JButton yes=new JButton("保存");
			JButton no=new JButton("取消");
			yes.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					System.out.println("添加"+getName.getText()+"成功");
					
					user.setName(getName.getText());
					user.setAge(Integer.parseInt(getAge.getText()));
					userService.add(user);
					jf.setVisible(false);
				}
			});
			no.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jf.setVisible(false);
				}
			});
			
			jf.setSize(300, 200);
			jf.setLayout(new GridLayout(3, 2));
			jf.add(name);
			jf.add(getName);
			jf.add(age);
			jf.add(getAge);
			jf.add(yes);
			jf.add(no);
			
			jf.setLocationRelativeTo(null);
			jf.setVisible(true);
		}else if(e.getSource()==selectUser) {
			System.out.println("点击了查询学生按钮！");
			
			
		}else if(e.getSource()==updateUser) {
			System.out.println("点击了修改学生按钮！");
		}else if(e.getSource()==deleteUser) {
			System.out.println("点击了删除学生按钮！");
		}else if(e.getSource()==testUser) {
			System.out.println("点击了测试学生按钮！");
		}else if(e.getSource()==exitSys) {
			System.out.println("点击了退出系统按钮！");
			jfMain.dispose();
			System.out.println("系统已经退出！！！");
		}
	}

}
