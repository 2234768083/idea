package com.bjsxt.controller;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends  HttpServlet {
	
	   @Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		   //解决中文乱码的操作
		   //req.setCharacterEncoding("utf-8");
		   //需要执行的方法的名称
		   String method = req.getParameter("method");
		   
		   //传递过来的对象
		   Class  clazz= this.getClass();
		  
		   try {
			   //使用反射的方式调用对象
			   Method method2 = clazz.getDeclaredMethod(method, HttpServletRequest.class,HttpServletResponse.class);
		        
			   method2.setAccessible(true);
			   
			   method2.invoke(this, req,resp);
		   
		   } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		   
	}
	

}
