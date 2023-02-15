package com.bjsxt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.entity.Course;
import com.bjsxt.entity.Student;
import com.bjsxt.service.StudentService;
import com.bjsxt.service.impl.StudentServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/servlet/StudentServlet")
public class StudentServlet extends BaseServlet {
	
	StudentService  stus=new  StudentServiceImpl();
	
	
	/******学生查看已选课程的操作************/
	protected void scFindMore(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		 resp.setContentType("text/html;charset=utf-8");
		
		 Student  stu= (Student) req.getSession().getAttribute("admin");
		 
		 int sno = stu.getSno();
		 
		 List<Course> scList = stus.scFindMore(sno);
		
		 Gson  gson=new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		 
		 String json = gson.toJson(scList);
		 
		 resp.getWriter().print(json);
		
	}
	
	/******学生选课的操作************/
	protected void scRgister(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		  
		//学生的编号
		Student  stu= (Student) req.getSession().getAttribute("admin");
		
		int sno = stu.getSno();
		
		//  1-2   2-2   3-4   5-6
		String[] delid = req.getParameterValues("delid");
		int  update=0;
	     for (String str : delid) {
		     //  [1,2]
	    	 String[] split = str.split("-");
	    	 
	    	 int  cno=Integer.parseInt(split[0]);
	    	 
	    	 int  tno=Integer.parseInt(split[1]);
	    	 
	    	update=  stus.scRegister(sno, cno, tno);
	     }
		
		 resp.getWriter().print(update);
		
		
	}
	
	/******学生查看选课列表信息************/
	protected void tcFindAll(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		   resp.setContentType("text/html;charset=utf-8");
		   
		 //学生的编号
			Student  stu= (Student) req.getSession().getAttribute("admin");
			
			int sno = stu.getSno();
		   
		   
		   List<Course> tcList = stus.tcFindAll(sno);
		   
		  Gson  gson=new  GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		
		  
		  String json = gson.toJson(tcList);
		  
		  resp.getWriter().print(json);
	}
	

}
