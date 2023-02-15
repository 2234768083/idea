package com.bjsxt.dao;

import java.util.List;

import com.bjsxt.entity.Student;

public interface StudentDao {
	
	//添加
	public   int   insert(Student  stu);
	
	//查询所有的操作
	public   List<Student> selectAll();
	
	//删除操作
	public   int   delete(int  sno);
	
	//查询单个操作
	public   Student  selectOne(int sno);

	//修改的操作
	public  int  update(Student  stu);
	
	//按条件查询学生的信息
	public   List<Student>  selectLike(int   clazzno,String sname);
	
	
	public   Student  selectOne2(String  sname,String pwd);
	
	
}
