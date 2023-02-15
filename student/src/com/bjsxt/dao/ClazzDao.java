package com.bjsxt.dao;

import java.util.List;

import com.bjsxt.entity.Clazz;

public interface ClazzDao {
	
	//查询所有的班级的信息
	public    List<Clazz>  selectAll();

}
