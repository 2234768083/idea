package com.bjsxt.dao;

import java.util.List;

import com.bjsxt.entity.Teacher;

public interface TeacherDao {
	
	//获得所有老师的信息
	public   List<Teacher>  selectAll();
	
	//老师登录功能操作
    public Teacher   selectOne(String tname,String pwd);

}
