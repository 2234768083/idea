package com.bjsxt.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bjsxt.dao.CourseDao;
import com.bjsxt.entity.Course;
import com.bjsxt.util.DBUtil;

public class CourseDaoImpl  implements CourseDao{

	@Override
	public List<Course> selectAll() {
		
		String  sql="select  *  from t_course";
		
		Object [] prams={};
		
		ResultSet rs = DBUtil.executeQuery(sql, prams);
		
	    List<Course>  list=new  ArrayList<Course>();
		try {
			while(rs.next()){
				
				int cno=rs.getInt("cno");
				
				String name=rs.getString("name");
				
				int  credit=rs.getInt("credit");
				
				Date  periodstart=rs.getDate("periodstart");
				
				Date  periodend=rs.getDate("periodend");
			    
				Course  cou=new Course(cno, name, credit, periodstart, periodend);	
			
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
