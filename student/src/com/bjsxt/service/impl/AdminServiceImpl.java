package com.bjsxt.service.impl;

import java.util.List;

import com.bjsxt.dao.AdminDao;
import com.bjsxt.dao.ClazzDao;
import com.bjsxt.dao.CourseDao;
import com.bjsxt.dao.StudentDao;
import com.bjsxt.dao.TCDao;
import com.bjsxt.dao.TeacherDao;
import com.bjsxt.dao.impl.AdminDaoImpl;
import com.bjsxt.dao.impl.ClazzDaoImpl;
import com.bjsxt.dao.impl.CourseDaoImpl;
import com.bjsxt.dao.impl.StudentDaoImpl;
import com.bjsxt.dao.impl.TCDaoImpl;
import com.bjsxt.dao.impl.TeacherDaoImpl;
import com.bjsxt.entity.Admin;
import com.bjsxt.entity.Clazz;
import com.bjsxt.entity.Course;
import com.bjsxt.entity.Student;
import com.bjsxt.entity.Teacher;
import com.bjsxt.service.AdminService;

public class AdminServiceImpl implements AdminService {

	AdminDao  admindao=new  AdminDaoImpl();
	
	StudentDao   studao=new  StudentDaoImpl();
	
	ClazzDao   cladao=new  ClazzDaoImpl();
	
	TCDao   tcdao=new  TCDaoImpl();
	
	CourseDao  coudao=new  CourseDaoImpl();
	
	TeacherDao  teadao=new  TeacherDaoImpl();
	
	@Override
	public Admin adminLogin(String uid,String pwd) {
		// TODO Auto-generated method stub
		return admindao.selectOne(uid, pwd);
	}

	@Override
	public int adminRegister(Admin admin) {
		// TODO Auto-generated method stub
		return admindao.insert(admin);
	}

	@Override
	public int stuRegister(Student stu) {
		// TODO Auto-generated method stub
		return studao.insert(stu);
	}

	@Override
	public List<Student> stuFindAll() {
		// TODO Auto-generated method stub
		return studao.selectAll();
	}

	@Override
	public int stuRemove(int sno) {
		// TODO Auto-generated method stub
		return studao.delete(sno);
	}

	@Override
	public Student stuFindOne(int sno) {
		// TODO Auto-generated method stub
		return studao.selectOne(sno);
	}

	@Override
	public int stuChange(Student stu) {
		// TODO Auto-generated method stub
		return studao.update(stu);
	}

	@Override
	public List<Student> stuFindLike(int clazzno, String sname) {
		// TODO Auto-generated method stub
		return studao.selectLike(clazzno, sname);
	}

	@Override
	public List<Clazz> claFindAll() {
		// TODO Auto-generated method stub
		return cladao.selectAll();
	}

	@Override
	public List<Course> tcFindAll() {
		// TODO Auto-generated method stub
		return tcdao.selectAll();
	}

	@Override
	public List<Course> couFindAll() {
		// TODO Auto-generated method stub
		return coudao.selectAll();
	}

	@Override
	public List<Teacher> teaFindAll() {
		// TODO Auto-generated method stub
		return teadao.selectAll();
	}

	@Override
	public int tcRegister(int cno, int tno) {
		// TODO Auto-generated method stub
		return tcdao.inster(cno, tno);
	}

	@Override
	public int tcRemove(int cno, int tno) {
		// TODO Auto-generated method stub
		return tcdao.delete(cno, tno);
	}

}
