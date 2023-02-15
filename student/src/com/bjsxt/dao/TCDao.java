package com.bjsxt.dao;

import java.util.List;

import com.bjsxt.entity.Course;

public interface TCDao {
	
	//查询所有老师和课程的信息
	public  List<Course>  selectAll();
	
	//添加选课的操作
	public   int   inster(int cno,int  tno);
	
	//删除指定老师的课程
	public  int  delete(int cno,int tno);
	
	public  List<Course>  selectAll2(int  sno);

}
