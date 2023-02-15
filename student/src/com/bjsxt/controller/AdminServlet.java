package com.bjsxt.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.entity.Admin;
import com.bjsxt.entity.Clazz;
import com.bjsxt.entity.Course;
import com.bjsxt.entity.Student;
import com.bjsxt.entity.Teacher;
import com.bjsxt.service.AdminService;
import com.bjsxt.service.impl.AdminServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/servlet/AdminServlet")
public class AdminServlet  extends  BaseServlet{
	
	AdminService  admins=new  AdminServiceImpl();
	
	
	/**********管理员删除老师对应的课程*******************/
	protected void tcRemove(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
        int  cno=Integer.parseInt(req.getParameter("cno"));
		
		int tno =Integer.parseInt(req.getParameter("tno"));
		 
		int  update= admins.tcRemove(cno, tno);
		
		resp.getWriter().print(update);
		
	}
	
	/**********管理员给老师分配课程*******************/
	protected void tcRegister(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		 
		int  cno=Integer.parseInt(req.getParameter("cno"));
		
		int tno =Integer.parseInt(req.getParameter("tno"));

		int  update=  admins.tcRegister(cno, tno);
		
		
		resp.getWriter().print(update);
		
	}
	
	/**********管理员查询老师信息*******************/
	protected void teaFindAll(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		  
		   resp.setContentType("text/html;charset=utf-8");
		   
		   List<Teacher> teaList = admins.teaFindAll();
		   
		   Gson  gson=new Gson();
		   
		   String json = gson.toJson(teaList);
		   
		   resp.getWriter().print(json);
	}
	
	/**********管理员查询课程*******************/
	protected void couFindAll(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=utf-8");
		
		List<Course> coulist = admins.couFindAll();
		
          Gson   gson=new Gson();
          
          String json = gson.toJson(coulist);
          
          resp.getWriter().print(json);
		
	}
	
	/**********管理员查询课程和老师信息*******************/
	protected void tcFindAll(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		   resp.setContentType("text/html;charset=utf-8");
		
		   List<Course> tclist = admins.tcFindAll();
		
		   Gson  gson =new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		   
		   String json = gson.toJson(tclist);
		   
		  resp.getWriter().print(json);
		
	}
	
	/**********管理员班级信息的操作*******************/
	protected void claFindAll(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		List<Clazz> claList = admins.claFindAll();
		
		req.setAttribute("claList", claList);
		
		req.getRequestDispatcher("/files/studentRegister.jsp").forward(req, resp);
	}
	
	/**********管理员按条件查询学生操作*******************/
	protected void stuFindLike(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		 
		//【1】接受前台的数据
		 int  clazzno =Integer.parseInt(req.getParameter("clazzno"));
		 
		 String  sname =req.getParameter("sname");
		
		//【2】数据的处理
		 
		 //查询学生的信息
		 List<Student> list = admins.stuFindLike(clazzno, sname);
		 
		 //查询班级的信息
		 List<Clazz> claList = admins.claFindAll();
		
		//【3】做出响应
		 req.setAttribute("clazzno", clazzno);
		 req.setAttribute("sname", sname);
		 req.setAttribute("list", list); 
		 req.setAttribute("claList", claList);
		 req.getRequestDispatcher("/files/studentList.jsp").forward(req, resp);
		
		
		
	}
	
	/**********管理员修改学生操作*******************/
	protected void stuChange(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		    //【1】解决中文乱码
		     req.setCharacterEncoding("utf-8");
		    //【2】接受前台的数据
		    
		     int  sno=Integer.parseInt(req.getParameter("sno"));
		     
		     String pwd=req.getParameter("pwd");
		     
		     String sname=req.getParameter("sname");
		     
		     String phone=req.getParameter("phone");
		     
		     String gender=req.getParameter("gender");
		     
		     Date  birth=Date.valueOf(req.getParameter("birth"));
		     
		     int  clazzno=Integer.parseInt(req.getParameter("clazzno"));
		     
		     String remark=req.getParameter("remark");
		     
		     Student  stu=new  Student(sno, pwd, sname, phone, gender, birth, clazzno, remark);
		    //【3】处理数据
		     
		     
		     
		     int update = admins.stuChange(stu);
		
		    //【4】做出响应
		        
		     if(update>0){
		    	 
		    	 resp.sendRedirect(req.getContextPath()+"/servlet/AdminServlet?method=stuFindAll");
		     }
		}
	/*******管理员查询单个学生***********/
	protected void stuFindOne(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		    //【1】解决中文的乱码
		
		    //【2】接受前台的数据
		    int  sno=Integer.parseInt(req.getParameter("sno"));
		    
		    //【3】处理数据
		    AdminService  admins=new  AdminServiceImpl();
		    
		    //制定的学生的信息
		    Student stu = admins.stuFindOne(sno);
		    
		    //班级的信息
		    List<Clazz> claList = admins.claFindAll();
		    
		    
		    //【4】做出响应
		    if(stu!=null){
		    	
		    	req.setAttribute("claList", claList);
		    	req.setAttribute("stu", stu);
		    	req.getRequestDispatcher("/files/studentUpdate.jsp").forward(req, resp);
		    	
		    }
	}
	/*****管理员删除指定的学生操作*******/
	protected void stuRemove(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		    
		    //【1】解决中文的乱码
		    
		    //[2]接受前台的数据
		      int  sno=Integer.parseInt(req.getParameter("sno"));
		
		   //[3]处理数据
		      AdminService  admins=new  AdminServiceImpl();
		      
		      int update = admins.stuRemove(sno);
		
		   //【4】做出响应
		      
		      resp.sendRedirect(req.getContextPath()+"/servlet/AdminServlet?method=stuFindAll");
		}
	/**********管理员查询所有学生的操作*********/
	protected void stuFindAll(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		 //【1】乱码的解决
		   
		 //【2】接受前台的数据
		
		
		 //【3】处理数据
		AdminService  admins=new  AdminServiceImpl();
		//查询所有学生信息
		List<Student> list = admins.stuFindAll();
		
		//查询班级的信息
         List<Clazz> claList = admins.claFindAll();
         
         
		//【4】做出响应
		req.setAttribute("list", list);
		req.setAttribute("claList", claList);
		req.getRequestDispatcher("/files/studentList.jsp").forward(req, resp);
		
	}
	
	
	
	/***********管理员添加其他学生的操作**********/
	protected void stuRegister(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		  //【2】接受前台的数据
		   String   pwd=req.getParameter("pwd");
		   
		   String  sname=req.getParameter("sname");
		   
		   String phone=req.getParameter("phone");
		   
		   String  gender=req.getParameter("gender");
		   
		   Date  birth=Date.valueOf(req.getParameter("birth"));
		   
		   int  clazzno=Integer.parseInt(req.getParameter("clazzno"));
		   
		   String  remark=req.getParameter("remark");
				   
		   Student   stu=new  Student(0, pwd, sname, phone, gender, birth, clazzno, remark);
		  //【3】处理数据
		   AdminService  admins=new  AdminServiceImpl();
		   
		   int update = admins.stuRegister(stu);
		 //【4】做出响应
		  if(update>0){
			  
			  resp.sendRedirect(req.getContextPath()+"/servlet/AdminServlet?method=stuFindAll");
		  
		  }else {
			  
			  req.setAttribute("msg", "添加失败");
			  req.getRequestDispatcher("/files/studentRegister.jsp").forward(req, resp);
		  }
		
	}
	
	
	/********管理员添加其他管理员操作*********/
	protected void adminRegister(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		   //【1】解决中文乱码
		    req.setCharacterEncoding("utf-8");
		
		  //【2】接受前台的数据
		  
		 String userid = req.getParameter("uid");
		    
		 String  username=req.getParameter("uname");
		      
		 String password=req.getParameter("pwd");
		      
		 int  age=Integer.parseInt(req.getParameter("age"));
		      
		 float  score=Float.parseFloat(req.getParameter("score"));
		      
		 Date  enterdate=Date.valueOf(req.getParameter("enterdate"));
		      
		 String[] ho = req.getParameterValues("hobby");
		      //把数组转换成字符串
		 String hobby = Arrays.toString(ho);
		    
		      Admin   admin =new Admin(userid, username, password, age, score, enterdate, hobby);
		  //【3】处理数据
		      AdminService  admins=new  AdminServiceImpl();
		      
		      int update = admins.adminRegister(admin);
		
		  //【4】做出响应
		      
		      if(update>0){
		    	  
		    	  resp.sendRedirect(req.getContextPath()+"/files/right.html");
		    	  /* resp.getWriter().print("<");*/
		    	}else {
		    	  req.setAttribute("msg", "注册失败");
		    	  req.getRequestDispatcher("/files/adminRegister.jsp").forward(req, resp);
		      }
		
		
		
	}

	
	
	

}
