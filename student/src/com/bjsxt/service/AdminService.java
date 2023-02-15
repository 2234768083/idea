package com.bjsxt.service;

import java.util.List;

import com.bjsxt.entity.Admin;
import com.bjsxt.entity.Clazz;
import com.bjsxt.entity.Course;
import com.bjsxt.entity.Student;
import com.bjsxt.entity.Teacher;

public interface AdminService {
	
	//����Ա��½����
	public   Admin  adminLogin(String uid,String pwd);
	//����Ա�����������Ա
	public   int    adminRegister(Admin  admin);
	
	
	//����Ա���ѧ���Ĳ���
	public  int   stuRegister(Student stu);
	//����Ա��ѯ����ѧ���Ĳ���
	public  List<Student>  stuFindAll();
	//����Աɾ��ָ����ѧ��
	public  int   stuRemove(int  sno);
	//����Ա��ѯ����ѧ���Ĳ���
	public  Student  stuFindOne(int  sno);
    //����Ա�޸�ѧ����Ϣ�Ĳ���
	public   int  stuChange(Student stu);
    //����Ա����������ѯѧ������Ϣ
	public  List<Student>  stuFindLike(int clazzno,String  sname);
	
	
	//����Ա��ѯ���а༶����Ϣ
	public  List<Clazz>  claFindAll();
	
	//����Ա��ѯ���пγ̺���ʦ����Ϣ
	public  List<Course>   tcFindAll();
	
	//����Ա��ѯ���пγ̵���Ϣ
	public  List<Course>  couFindAll();
	
	//����Ա��ѯ������ʦ����Ϣ
	public  List<Teacher>  teaFindAll();
	
	//����Ա����ʦ����γ̵Ĳ���
	public   int  tcRegister(int cno,int tno);
	
	//����Աɾ����ʦ�Ŀγ̡�
	public   int   tcRemove(int cno,int tno);

	

}
