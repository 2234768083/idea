package com.bjsxt.service;

import java.util.List;

import com.bjsxt.entity.Course;
import com.bjsxt.entity.Student;

public interface StudentService {
	
	//学生登录的操作
	public    Student   login(String  sname,String pwd);
	
	//学生查看选课的列表
	public  List<Course>  tcFindAll(int  sno);
	
	//学生选课的操作
	public  int    scRegister(int  sno,int cno,int tno);
	
	//学生查询已经选择的课程信息
	public  List<Course>  scFindMore(int  sno);

}
