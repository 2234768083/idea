package com.bjsxt.service;

import java.util.List;

import com.bjsxt.entity.Admin;
import com.bjsxt.entity.Clazz;
import com.bjsxt.entity.Course;
import com.bjsxt.entity.Student;
import com.bjsxt.entity.Teacher;

public interface AdminService {
	
	//管理员登陆操作
	public   Admin  adminLogin(String uid,String pwd);
	//管理员添加其他管理员
	public   int    adminRegister(Admin  admin);
	
	
	//管理员添加学生的操作
	public  int   stuRegister(Student stu);
	//管理员查询所有学生的操作
	public  List<Student>  stuFindAll();
	//管理员删除指定的学生
	public  int   stuRemove(int  sno);
	//管理员查询单个学生的操作
	public  Student  stuFindOne(int  sno);
    //管理员修改学生信息的操作
	public   int  stuChange(Student stu);
    //管理员按照条件查询学生的信息
	public  List<Student>  stuFindLike(int clazzno,String  sname);
	
	
	//管理员查询所有班级的信息
	public  List<Clazz>  claFindAll();
	
	//管理员查询所有课程和老师的信息
	public  List<Course>   tcFindAll();
	
	//管理员查询所有课程的信息
	public  List<Course>  couFindAll();
	
	//管理员查询所有老师的信息
	public  List<Teacher>  teaFindAll();
	
	//管理员给老师分配课程的操作
	public   int  tcRegister(int cno,int tno);
	
	//管理员删除老师的课程‘
	public   int   tcRemove(int cno,int tno);

	

}
