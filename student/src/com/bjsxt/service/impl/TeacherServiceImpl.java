package com.bjsxt.service.impl;

import java.util.List;

import com.bjsxt.dao.SCDao;
import com.bjsxt.dao.TeacherDao;
import com.bjsxt.dao.impl.SCDaoImpl;
import com.bjsxt.dao.impl.TeacherDaoImpl;
import com.bjsxt.entity.SCC;
import com.bjsxt.entity.Teacher;
import com.bjsxt.service.TeacherService;

public class TeacherServiceImpl implements TeacherService {
   
	TeacherDao  teadao=new  TeacherDaoImpl();
	
	SCDao   scdao=new SCDaoImpl();
	
	@Override
	public Teacher login(String tname, String pwd) {
		// TODO Auto-generated method stub
		return teadao.selectOne(tname, pwd);
	}

	@Override
	public List<SCC> sccFindAll(int tno) {
		// TODO Auto-generated method stub
		return scdao.selectAll(tno);
	}
	

}
