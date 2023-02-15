package com.bjsxt.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bjsxt.dao.SCDao;
import com.bjsxt.entity.Course;
import com.bjsxt.entity.SCC;
import com.bjsxt.entity.Teacher;
import com.bjsxt.util.DBUtil;

public class SCDaoImpl  implements SCDao{

	@Override
	public int insert(int sno, int cno, int tno) {
		
		String  sql="insert  into  t_sc(sno,cno,tno) values(?,?,?) ";
		
		Object  []  prams={sno,cno,tno};
		
		int  update= DBUtil.executeUpdate(sql, prams);
		
		DBUtil.closeAll();
		
		return update;
	}

	@Override
	public List<Course> selectMore(int sno) {
		
		String  sql="select *  from  t_course  cou    join   t_sc   sc   on   cou.cno=sc.cno join   t_teacher  tea  on  tea.tno=sc.tno   where   sc.sno=?";
		
		Object  []  prams={sno};
		
		ResultSet rs = DBUtil.executeQuery(sql, prams);
		
		List<Course>  list=new ArrayList<Course>();
		
		try {
			while(rs.next()){
				//获得课程的信息
				int  cno=rs.getInt("cno");
				
				String name=rs.getString("name");
				
                 int  credit=rs.getInt("credit");
                 
                 Date  periodstart=rs.getDate("periodstart");
                 
                 Date  periodend=rs.getDate("periodend");
				
				 Course  cou=new  Course(cno, name, credit, periodstart, periodend);
				
				 //获得老师的信息
				 int  tno=rs.getInt("tno");
				 
				 String  tname=rs.getString("tname");
				 
				 String  pwd=rs.getString("pwd");
				 
				 String  phone=rs.getString("phone");
				 
				 Date  hiredate=rs.getDate("hiredate");
				 
				 String remark=rs.getString("remark");
				 
				 Teacher  tea=new Teacher(tno, tname, pwd, phone, hiredate, remark);
				 
				 //把老师的对象放到学生中
				 cou.setTea(tea);
				
				  list.add(cou);
				
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
	public List<SCC> selectAll(int tno) {
		
		String  sql="select  *  from   t_student  stu   join  t_clazz  cla on   stu.clazzno=cla.clazzno"+

					" join   t_sc sc  on   stu.sno=sc.sno"+

					" join  t_course   cou  on  sc.cno=cou.cno"+

					" where  sc.tno=?";
		
		Object  [] prams={tno};
		
		ResultSet rs = DBUtil.executeQuery(sql, prams);
		
		List<SCC>  list=new ArrayList<SCC>();
		
		try {
			while(rs.next()){
				
				int  sno=rs.getInt("sno");
				
				String  sname=rs.getString("sname");
				
				int  cno=rs.getInt("cno");
				
				int clazzroom=rs.getInt("clazzroom");
					
				String  name=rs.getString("name");
				
				int  credit=rs.getInt("credit");
				
				int score=rs.getInt("score");
				
				SCC  scc=new SCC(sno, sname, clazzroom, cno, name, credit, score);
				
				list.add(scc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			DBUtil.closeAll();
		}
		
		
		return list;
	}

}
