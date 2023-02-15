package com.bjsxt.service.impl;

import java.util.List;

import com.bjsxt.dao.SCDao;
import com.bjsxt.dao.StudentDao;
import com.bjsxt.dao.TCDao;
import com.bjsxt.dao.impl.SCDaoImpl;
import com.bjsxt.dao.impl.StudentDaoImpl;
import com.bjsxt.dao.impl.TCDaoImpl;
import com.bjsxt.entity.Course;
import com.bjsxt.entity.Student;
import com.bjsxt.service.StudentService;

public class StudentServiceImpl implements StudentService {

	StudentDao  studao=new  StudentDaoImpl();
	
	TCDao  tcdao=new  TCDaoImpl();
	
	SCDao  scdao=new  SCDaoImpl();
	
	@Override
	public Student login(String sname, String pwd) {
		// TODO Auto-generated method stub
		return studao.selectOne2(sname, pwd);
	}

	@Override
	public List<Course> tcFindAll(int  sno) {
		// TODO Auto-generated method stub
		return tcdao.selectAll2(sno);
	}

	@Override
	public int scRegister(int sno, int cno, int tno) {
		// TODO Auto-generated method stub
		return scdao.insert(sno, cno, tno);
	}

	@Override
	public List<Course> scFindMore(int sno) {
		// TODO Auto-generated method stub
		return scdao.selectMore(sno);
	}

}
