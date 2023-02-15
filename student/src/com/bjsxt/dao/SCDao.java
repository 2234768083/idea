package com.bjsxt.dao;

import java.util.List;

import com.bjsxt.entity.Course;
import com.bjsxt.entity.SCC;

public interface SCDao {
	
	//学生选课的操作
	public   int  insert(int sno,int cno,int tno);
	
	//学生查询已选课程的信息
	public   List<Course>  selectMore(int  sno);
	
	//老师查询课程的操作
	public   List<SCC> selectAll(int tno);

}
