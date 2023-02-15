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
	
	
	/**********����Աɾ����ʦ��Ӧ�Ŀγ�*******************/
	protected void tcRemove(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
        int  cno=Integer.parseInt(req.getParameter("cno"));
		
		int tno =Integer.parseInt(req.getParameter("tno"));
		 
		int  update= admins.tcRemove(cno, tno);
		
		resp.getWriter().print(update);
		
	}
	
	/**********����Ա����ʦ����γ�*******************/
	protected void tcRegister(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		 
		int  cno=Integer.parseInt(req.getParameter("cno"));
		
		int tno =Integer.parseInt(req.getParameter("tno"));

		int  update=  admins.tcRegister(cno, tno);
		
		
		resp.getWriter().print(update);
		
	}
	
	/**********����Ա��ѯ��ʦ��Ϣ*******************/
	protected void teaFindAll(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		  
		   resp.setContentType("text/html;charset=utf-8");
		   
		   List<Teacher> teaList = admins.teaFindAll();
		   
		   Gson  gson=new Gson();
		   
		   String json = gson.toJson(teaList);
		   
		   resp.getWriter().print(json);
	}
	
	/**********����Ա��ѯ�γ�*******************/
	protected void couFindAll(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=utf-8");
		
		List<Course> coulist = admins.couFindAll();
		
          Gson   gson=new Gson();
          
          String json = gson.toJson(coulist);
          
          resp.getWriter().print(json);
		
	}
	
	/**********����Ա��ѯ�γ̺���ʦ��Ϣ*******************/
	protected void tcFindAll(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		   resp.setContentType("text/html;charset=utf-8");
		
		   List<Course> tclist = admins.tcFindAll();
		
		   Gson  gson =new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		   
		   String json = gson.toJson(tclist);
		   
		  resp.getWriter().print(json);
		
	}
	
	/**********����Ա�༶��Ϣ�Ĳ���*******************/
	protected void claFindAll(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		List<Clazz> claList = admins.claFindAll();
		
		req.setAttribute("claList", claList);
		
		req.getRequestDispatcher("/files/studentRegister.jsp").forward(req, resp);
	}
	
	/**********����Ա��������ѯѧ������*******************/
	protected void stuFindLike(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		 
		//��1������ǰ̨������
		 int  clazzno =Integer.parseInt(req.getParameter("clazzno"));
		 
		 String  sname =req.getParameter("sname");
		
		//��2�����ݵĴ���
		 
		 //��ѯѧ������Ϣ
		 List<Student> list = admins.stuFindLike(clazzno, sname);
		 
		 //��ѯ�༶����Ϣ
		 List<Clazz> claList = admins.claFindAll();
		
		//��3��������Ӧ
		 req.setAttribute("clazzno", clazzno);
		 req.setAttribute("sname", sname);
		 req.setAttribute("list", list); 
		 req.setAttribute("claList", claList);
		 req.getRequestDispatcher("/files/studentList.jsp").forward(req, resp);
		
		
		
	}
	
	/**********����Ա�޸�ѧ������*******************/
	protected void stuChange(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		    //��1�������������
		     req.setCharacterEncoding("utf-8");
		    //��2������ǰ̨������
		    
		     int  sno=Integer.parseInt(req.getParameter("sno"));
		     
		     String pwd=req.getParameter("pwd");
		     
		     String sname=req.getParameter("sname");
		     
		     String phone=req.getParameter("phone");
		     
		     String gender=req.getParameter("gender");
		     
		     Date  birth=Date.valueOf(req.getParameter("birth"));
		     
		     int  clazzno=Integer.parseInt(req.getParameter("clazzno"));
		     
		     String remark=req.getParameter("remark");
		     
		     Student  stu=new  Student(sno, pwd, sname, phone, gender, birth, clazzno, remark);
		    //��3����������
		     
		     
		     
		     int update = admins.stuChange(stu);
		
		    //��4��������Ӧ
		        
		     if(update>0){
		    	 
		    	 resp.sendRedirect(req.getContextPath()+"/servlet/AdminServlet?method=stuFindAll");
		     }
		}
	/*******����Ա��ѯ����ѧ��***********/
	protected void stuFindOne(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		    //��1��������ĵ�����
		
		    //��2������ǰ̨������
		    int  sno=Integer.parseInt(req.getParameter("sno"));
		    
		    //��3����������
		    AdminService  admins=new  AdminServiceImpl();
		    
		    //�ƶ���ѧ������Ϣ
		    Student stu = admins.stuFindOne(sno);
		    
		    //�༶����Ϣ
		    List<Clazz> claList = admins.claFindAll();
		    
		    
		    //��4��������Ӧ
		    if(stu!=null){
		    	
		    	req.setAttribute("claList", claList);
		    	req.setAttribute("stu", stu);
		    	req.getRequestDispatcher("/files/studentUpdate.jsp").forward(req, resp);
		    	
		    }
	}
	/*****����Աɾ��ָ����ѧ������*******/
	protected void stuRemove(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		    
		    //��1��������ĵ�����
		    
		    //[2]����ǰ̨������
		      int  sno=Integer.parseInt(req.getParameter("sno"));
		
		   //[3]��������
		      AdminService  admins=new  AdminServiceImpl();
		      
		      int update = admins.stuRemove(sno);
		
		   //��4��������Ӧ
		      
		      resp.sendRedirect(req.getContextPath()+"/servlet/AdminServlet?method=stuFindAll");
		}
	/**********����Ա��ѯ����ѧ���Ĳ���*********/
	protected void stuFindAll(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		 //��1������Ľ��
		   
		 //��2������ǰ̨������
		
		
		 //��3����������
		AdminService  admins=new  AdminServiceImpl();
		//��ѯ����ѧ����Ϣ
		List<Student> list = admins.stuFindAll();
		
		//��ѯ�༶����Ϣ
         List<Clazz> claList = admins.claFindAll();
         
         
		//��4��������Ӧ
		req.setAttribute("list", list);
		req.setAttribute("claList", claList);
		req.getRequestDispatcher("/files/studentList.jsp").forward(req, resp);
		
	}
	
	
	
	/***********����Ա�������ѧ���Ĳ���**********/
	protected void stuRegister(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		  //��2������ǰ̨������
		   String   pwd=req.getParameter("pwd");
		   
		   String  sname=req.getParameter("sname");
		   
		   String phone=req.getParameter("phone");
		   
		   String  gender=req.getParameter("gender");
		   
		   Date  birth=Date.valueOf(req.getParameter("birth"));
		   
		   int  clazzno=Integer.parseInt(req.getParameter("clazzno"));
		   
		   String  remark=req.getParameter("remark");
				   
		   Student   stu=new  Student(0, pwd, sname, phone, gender, birth, clazzno, remark);
		  //��3����������
		   AdminService  admins=new  AdminServiceImpl();
		   
		   int update = admins.stuRegister(stu);
		 //��4��������Ӧ
		  if(update>0){
			  
			  resp.sendRedirect(req.getContextPath()+"/servlet/AdminServlet?method=stuFindAll");
		  
		  }else {
			  
			  req.setAttribute("msg", "���ʧ��");
			  req.getRequestDispatcher("/files/studentRegister.jsp").forward(req, resp);
		  }
		
	}
	
	
	/********����Ա�����������Ա����*********/
	protected void adminRegister(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		   //��1�������������
		    req.setCharacterEncoding("utf-8");
		
		  //��2������ǰ̨������
		  
		 String userid = req.getParameter("uid");
		    
		 String  username=req.getParameter("uname");
		      
		 String password=req.getParameter("pwd");
		      
		 int  age=Integer.parseInt(req.getParameter("age"));
		      
		 float  score=Float.parseFloat(req.getParameter("score"));
		      
		 Date  enterdate=Date.valueOf(req.getParameter("enterdate"));
		      
		 String[] ho = req.getParameterValues("hobby");
		      //������ת�����ַ���
		 String hobby = Arrays.toString(ho);
		    
		      Admin   admin =new Admin(userid, username, password, age, score, enterdate, hobby);
		  //��3����������
		      AdminService  admins=new  AdminServiceImpl();
		      
		      int update = admins.adminRegister(admin);
		
		  //��4��������Ӧ
		      
		      if(update>0){
		    	  
		    	  resp.sendRedirect(req.getContextPath()+"/files/right.html");
		    	  /* resp.getWriter().print("<");*/
		    	}else {
		    	  req.setAttribute("msg", "ע��ʧ��");
		    	  req.getRequestDispatcher("/files/adminRegister.jsp").forward(req, resp);
		      }
		
		
		
	}

	
	
	

}
