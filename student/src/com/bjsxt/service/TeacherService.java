package com.bjsxt.service;

import java.util.List;

import com.bjsxt.entity.SCC;
import com.bjsxt.entity.Teacher;

public interface TeacherService {
	
	//��ʦ��¼�Ĳ���
	public  Teacher  login(String tname,String pwd);
	
	
	//��ʦ��ѯ�γ̵Ĳ���
	public   List<SCC>   sccFindAll(int tno);
 
}
