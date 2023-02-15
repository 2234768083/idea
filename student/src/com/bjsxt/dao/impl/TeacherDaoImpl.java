package com.bjsxt.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bjsxt.dao.TeacherDao;
import com.bjsxt.entity.Teacher;
import com.bjsxt.util.DBUtil;

public class TeacherDaoImpl  implements TeacherDao{

	@Override
	public List<Teacher> selectAll() {
		
		String  sql="select  *  from  t_teacher";
		
		Object [] prams={};
		
		ResultSet rs = DBUtil.executeQuery(sql, prams);
		
		List<Teacher>  list=new ArrayList<Teacher>();
		try {
			while(rs.next()){
				
				int  tno=rs.getInt("tno");
				
				String  tname=rs.getString("tname");
				
				String pwd=rs.getString("pwd");
				
				String  phone=rs.getString("phone");
				
				Date hiredate=rs.getDate("hiredate");
				
				String  remark=rs.getString("remark");
			
				Teacher  tea=new Teacher(tno, tname, pwd, phone, hiredate, remark);
			
			   list.add(tea);
			
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
	public Teacher selectOne(String tname, String pwd) {
String  sql="select *  from t_teacher where tname=?  and pwd=?";
		
		Object [] prams={tname,pwd};
		
		ResultSet rs = DBUtil.executeQuery(sql, prams);
		
		Teacher  tea=null;
		try {
			while(rs.next()){
				  
				int tno = rs.getInt("tno");
			
				String  tname1=rs.getString("tname");
				
				String pwd1=rs.getString("pwd");
				
				String phone=rs.getString("phone");
				
				Date hiredate=rs.getDate("hiredate");
				
				String remark=rs.getString("remark");
				
			   tea=new Teacher(tno, tname, pwd, phone, hiredate, remark);
			    
		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeAll();
		}
		
		return tea;
	}

}
