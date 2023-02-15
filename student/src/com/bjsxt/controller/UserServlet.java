package com.bjsxt.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bjsxt.service.AdminService;
import com.bjsxt.service.StudentService;
import com.bjsxt.service.TeacherService;
import com.bjsxt.service.impl.AdminServiceImpl;
import com.bjsxt.service.impl.StudentServiceImpl;
import com.bjsxt.service.impl.TeacherServiceImpl;

@WebServlet("/servlet/UserServlet")
public class UserServlet  extends  BaseServlet{

	
	/********退出操作**********/
	protected void loginOut(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		    //[1]把session对象注销
		     
		    req.getSession().invalidate();
		    
		    //req.getSession().removeAttribute("admin");
		 
		    //[2]跳转到登陆的页面
		    
		    resp.sendRedirect(req.getContextPath()+"/login.jsp");
		 
	}
	
	
	
	/********登录的操作*************/
	protected void login(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		    //[1]解决中文乱码（post）
		    req.setCharacterEncoding("utf-8");
		    
		    
		    
		    
		    //[2]接受前台的数据
		    String uid = req.getParameter("uid");
		    
		    String pwd =req.getParameter("pwd");
		    
		    //获得用户的角色
		    String role = req.getParameter("role");
		    
		    //把权限保存到session中
		    
		    req.getSession().setAttribute("role", role);
		    
		    
		    /******验证码 的校验************************/
		    
		    //获得系统产生的验证码
		     String  randStr= (String) req.getSession().getAttribute("randStr");
		    
		     //获得用户输入的验证码
		     String yzm = req.getParameter("yzm");
		    
		     if(yzm==null ||"".equals(yzm)||!yzm.equals(randStr)){
		    	 
		    	 req.setAttribute("msg", "验证码错误");
		    	 req.getRequestDispatcher("/login.jsp").forward(req, resp);
		         return;
		     }
		    
		    
		    
		    //[3]处理数据
		    
		    Object   user=null;
		    
		    if("admin".equals(role)){
		    	
		    	 AdminService  admins=new  AdminServiceImpl();
				    
		    	 user = admins.adminLogin(uid, pwd);
		    }else  if("teacher".equals(role)){
		    	
		    	TeacherService  teas=new  TeacherServiceImpl();
		    	
		    	user=teas.login(uid, pwd);
		    	
		    	
		    }else  if("student".equals(role)){
		    	
		    	StudentService  stus=new StudentServiceImpl();
		    	
		    	user = stus.login(uid, pwd);
		    	 
		    }
		    
		   
		    
		    
		    
		    //[4]做出响应
		    
		    if(user!=null){
		    	
		    	/*****使用session欢迎xx登陆******/
		    	
		    	//获得session对象
		    	HttpSession session = req.getSession();
		    	//把制定的内容存入到session
		    	session.setAttribute("admin", user);
		    	
		    	/******统计网站的访问人数************/
		    	
		    	 //获得全局的对象
		    	 ServletContext context = req.getServletContext();
		    	 
		    	 //获得之前已经登陆过的人数
		    	 
		    	 Integer   count= (Integer) context.getAttribute("count");
		    	
		    	  if(count==null){
		    		  
		    		  count=1;
		    	  }else {
		    		  
		    		  count++;
		    	  }
		    	 
		    	  context.setAttribute("count", count);
		    	 
		    	//重定向
		    	resp.sendRedirect(req.getContextPath()+"/index.html");
		    }else{
		    	
		    	req.setAttribute("msg", "账号和密码错误");
		    	req.getRequestDispatcher("/login.jsp").forward(req, resp);;
		    }
		  
		  
	}

}
