package com.bjsxt.service;

import java.util.List;

import com.bjsxt.entity.SCC;
import com.bjsxt.entity.Teacher;

public interface TeacherService {
	
	//老师登录的操作
	public  Teacher  login(String tname,String pwd);
	
	
	//老师查询课程的操作
	public   List<SCC>   sccFindAll(int tno);
 
}
