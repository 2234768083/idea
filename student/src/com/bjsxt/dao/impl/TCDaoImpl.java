package com.bjsxt.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bjsxt.dao.TCDao;
import com.bjsxt.entity.Course;
import com.bjsxt.entity.Teacher;
import com.bjsxt.util.DBUtil;

public class TCDaoImpl implements TCDao{

	@Override
	public List<Course> selectAll() {
		
		String  sql="select  *  from  t_course   cou  left join  t_tc  tc on   cou.cno=tc.cno left join  t_teacher  tea  on   tc.tno=tea.tno";
		
		Object [] prams={};
		
		ResultSet rs = DBUtil.executeQuery(sql, prams);
		
		List<Course>  list=new  ArrayList<Course>();
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
	public int inster(int cno, int tno) {
		
		String  sql2="select  *  from  t_tc where  cno=? and tno=?";
		
		Object  [] prams2={cno,tno};
		
		
		ResultSet rs = DBUtil.executeQuery(sql2, prams2);
		
		
		try {
			if(rs.next()){
				
				return -5;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			DBUtil.closeAll();
		}
		
		
		String  sql="insert  into  t_tc   values(?,?)";
		
		Object [] prams={cno,tno};
		
		int  update= DBUtil.executeUpdate(sql, prams);
		
		DBUtil.closeAll();
		
		return update;
	}

	@Override
	public int delete(int cno, int tno) {
		String  sql="delete  from  t_tc   where  cno=?  and  tno=?";
		
		Object  []  prams={cno,tno};
		
		
	   int  update=	DBUtil.executeUpdate(sql, prams);
		
	   DBUtil.closeAll();
		return update;
	}

	@Override
	public List<Course> selectAll2(int  sno) {
		
		String  sql="select  *  from  t_course   cou   join  t_tc  tc on   cou.cno=tc.cno  join  t_teacher  tea  on   tc.tno=tea.tno "+

                    " where  cou.cno  not in( select cno  from  t_sc  where   sno=?)";
		
		Object [] prams={sno};
		
		ResultSet rs = DBUtil.executeQuery(sql, prams);
		
		List<Course>  list=new  ArrayList<Course>();
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

}
