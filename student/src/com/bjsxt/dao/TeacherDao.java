package com.bjsxt.dao;

import java.util.List;

import com.bjsxt.entity.Teacher;

public interface TeacherDao {
	
	//���������ʦ����Ϣ
	public   List<Teacher>  selectAll();
	
	//��ʦ��¼���ܲ���
    public Teacher   selectOne(String tname,String pwd);

}
