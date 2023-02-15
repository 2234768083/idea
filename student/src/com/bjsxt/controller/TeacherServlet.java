package com.bjsxt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.entity.SCC;
import com.bjsxt.entity.Teacher;
import com.bjsxt.service.TeacherService;
import com.bjsxt.service.impl.TeacherServiceImpl;
import com.google.gson.Gson;

@WebServlet("/servlet/TeacherServlet")
public class TeacherServlet  extends  BaseServlet{
	
	
	/******老师查询课程的操作************/
	protected void sccFindAll(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		   resp.setContentType("text/html;charset=utf-8");
		
		  Teacher   tea=  (Teacher) req.getSession().getAttribute("admin");
		
		  int tno = tea.getTno();
		  
		  TeacherService  teas=new TeacherServiceImpl();
		  
		  List<SCC> list = teas.sccFindAll(tno);
		  
		  
		  Gson  gson=new  Gson();
		  
		  String json = gson.toJson(list);
		  
		  resp.getWriter().print(json);
		  
	}

}
