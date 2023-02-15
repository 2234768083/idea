package com.bjsxt.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bjsxt.dao.ClazzDao;
import com.bjsxt.entity.Clazz;
import com.bjsxt.util.DBUtil;

public class ClazzDaoImpl implements ClazzDao {

	@Override
	public List<Clazz> selectAll() {
		
		  String  sql="select  *  from  t_clazz";
		  
		  Object  [] prams={};
		
		 ResultSet rs = DBUtil.executeQuery(sql, prams);
		  
		 List<Clazz>  list=new  ArrayList<Clazz>();
		 try {
			while(rs.next()){
				
				int  clazzno=rs.getInt("clazzno");
				
				String cname=rs.getString("cname");
				
				String  cteacher=rs.getString("cteacher");
				
				int  clazzroom=rs.getInt("clazzroom") ;
				
			  Clazz  clazz  =new  Clazz(clazzno, cname, cteacher, clazzroom);	 
			 
			   list.add(clazz);
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
