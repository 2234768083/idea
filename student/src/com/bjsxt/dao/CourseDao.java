package com.bjsxt.dao;

import java.util.List;

import com.bjsxt.entity.Course;

public interface CourseDao {
	
	//查询所有课程的信息
	public  List<Course>  selectAll();

}
