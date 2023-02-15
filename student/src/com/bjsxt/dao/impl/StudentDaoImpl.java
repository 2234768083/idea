package com.bjsxt.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bjsxt.dao.StudentDao;
import com.bjsxt.entity.Clazz;
import com.bjsxt.entity.Student;
import com.bjsxt.util.DBUtil;

public class StudentDaoImpl implements StudentDao{

	@Override
	public int insert(Student stu) {
		
		String  sql="insert  into   t_student  values(seq_stu.nextval,?,?,?,?,?,?,?)";
		
		Object [] prams={stu.getPwd(),stu.getSname(),stu.getPhone(),stu.getGender(),stu.getBirth(),stu.getClazzno(),stu.getRemark()};
		
		int  update= DBUtil.executeUpdate(sql, prams);
		
		DBUtil.closeAll();
		
		return update;
	}

	@Override
	public List<Student> selectAll() {
		
		String  sql="select  *  from  t_student  stu left  join  t_clazz  cla  on  stu.clazzno=cla.clazzno ";
		
		Object [] prams={};
		
		ResultSet rs = DBUtil.executeQuery(sql, prams);
		
		List<Student>  list=new ArrayList<Student>();
		try {
			while(rs.next()){
				 
				//学生的信息
				int  sno=rs.getInt("sno");
				 
				 String pwd=rs.getString("pwd");
				 
				 String sname=rs.getString("sname");
				 
				 String phone=rs.getString("phone");
				 
			    String  gender=rs.getString("gender").trim();
			    
			    Date  birth=rs.getDate("birth");
			    
			    int  clazzno=rs.getInt("clazzno");
			    		
				String  remark=rs.getString("remark");	
				
				
				//接受班级的信息
				
				String cname=rs.getString("cname");
				
				String cteacher=rs.getString("cteacher");
				
				int  clazzroom=rs.getInt("clazzroom");
				
				Clazz  clazz =new Clazz(clazzno, cname, cteacher, clazzroom);
				
				
				
				Student  stu=new  Student(sno, pwd, sname, phone, gender, birth, clazzno, remark);
			   
				//把班级的信息保存到学生对象中
				stu.setClazz(clazz);
				
				
				list.add(stu);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			DBUtil.closeAll();
		}
		
		return list;
	}

	@Override
	public int delete(int sno) {
		
		String  sql="delete  from  t_student  where  sno=?";
		
		Object [] prams={sno};
		
		int  update= DBUtil.executeUpdate(sql, prams);
		
		DBUtil.closeAll();
		
		return update;
	}

	@Override
	public Student selectOne(int sno) {
		
		String  sql="select  *  from t_student  where sno=?";
		
		Object  [] prams={sno};
		
		ResultSet rs = DBUtil.executeQuery(sql, prams);
		
		Student  stu=null;
		try {
			while(rs.next()){
				int  sno1=rs.getInt("sno");
				 
				 String pwd=rs.getString("pwd");
				 
				 String sname=rs.getString("sname");
				 
				 String phone=rs.getString("phone");
				 
			    String  gender=rs.getString("gender");
			    
			    Date  birth=rs.getDate("birth");
			    
			    int  clazzno=rs.getInt("clazzno");
			    		
				String  remark=rs.getString("remark");		 
				
			    stu=new  Student(sno1, pwd, sname, phone, gender, birth, clazzno, remark);
			   
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			DBUtil.closeAll();
		}
		
		return stu;
	}

	@Override
	public int update(Student stu) {
		
		  String  sql="update  t_student  set pwd=? ,sname=?,phone=?,gender=?,birth=?,clazzno=?,remark=? where  sno=?";
		  
		  Object [] prams={stu.getPwd(),stu.getSname(),stu.getPhone(),stu.getGender(),stu.getBirth(),stu.getClazzno(),stu.getRemark(),stu.getSno()};
		 
		  int  update=DBUtil.executeUpdate(sql, prams);
		
		  DBUtil.closeAll();
		   
		return  update;
	}

	@Override
	public List<Student> selectLike(int clazzno, String sname) {
		
		String  sql="select  *  from  t_student  stu left  join  t_clazz  cla  on  stu.clazzno=cla.clazzno  where 1=1";
		
		if(clazzno!=0){
			
			sql+=" and stu.clazzno="+clazzno;
		}
		
		if(sname!=null&&!"".equals(sname)){
			
			sql+=" and stu.sname like  '%"+sname+"%'";
		}
		
		System.out.println(sql);
		Object [] prams={};
		
		ResultSet rs = DBUtil.executeQuery(sql, prams);
		
		List<Student>  list=new  ArrayList<Student>();
		try {
			while(rs.next()){
				
				int  sno=rs.getInt("sno");
				 
				 String pwd=rs.getString("pwd");
				 
				 String sname1=rs.getString("sname");
				 
				 String phone=rs.getString("phone");
				 
			    String  gender=rs.getString("gender").trim();
			    
			    Date  birth=rs.getDate("birth");
			    
			    int  clazzno1=rs.getInt("clazzno");
			    		
				String  remark=rs.getString("remark");
				
				//接受班级的信息
				
				String cname=rs.getString("cname");
				
				String cteacher=rs.getString("cteacher");
				
				int  clazzroom=rs.getInt("clazzroom");
				
				Clazz  clazz =new Clazz(clazzno, cname, cteacher, clazzroom);
				
				
				Student  stu=new  Student(sno, pwd, sname1, phone, gender, birth, clazzno1, remark);
			   
				stu.setClazz(clazz);
				
				list.add(stu);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			DBUtil.closeAll();
		}
		
		return list;
	}

	@Override
	public Student selectOne2(String sname, String pwd) {
		

		
		String  sql="select  *  from t_student  where sname=?  and pwd=?";
		
		Object  [] prams={sname,pwd};
		
		ResultSet rs = DBUtil.executeQuery(sql, prams);
		
		Student  stu=null;
		try {
			while(rs.next()){
				int  sno1=rs.getInt("sno");
				 
				 String pwd1=rs.getString("pwd");
				 
				 String sname1=rs.getString("sname");
				 
				 String phone=rs.getString("phone");
				 
			    String  gender=rs.getString("gender");
			    
			    Date  birth=rs.getDate("birth");
			    
			    int  clazzno=rs.getInt("clazzno");
			    		
				String  remark=rs.getString("remark");		 
				
			    stu=new  Student(sno1, pwd1, sname1, phone, gender, birth, clazzno, remark);
			   
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			DBUtil.closeAll();
		}
		
		return stu;
	
		
		
	}

}
