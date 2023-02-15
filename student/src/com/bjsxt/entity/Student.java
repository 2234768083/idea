package com.bjsxt.entity;

import java.io.Serializable;
import java.util.Date;


public class Student implements Serializable{

	private int  sno;
	
	private  String  pwd;
	
	private  String sname;
	
	private   String  phone;
	
	private  String  gender;
	
	private   Date  birth;
	
	private  int  clazzno;
	
	private  String  remark;
	
	//解决方案一
	/*private   String   cname;
	
	private   String   cteacher;
	
	private   int   clazzroom;*/
	
	//解决方案二
	private  Clazz  clazz;

	
	

	public Clazz getClazz() {
		return clazz;
	}

	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}

	public Student() {
		super();
	}

	public Student(int sno, String pwd, String sname, String phone,
			String gender, Date birth, int clazzno, String remark) {
		super();
		this.sno = sno;
		this.pwd = pwd;
		this.sname = sname;
		this.phone = phone;
		this.gender = gender;
		this.birth = birth;
		this.clazzno = clazzno;
		this.remark = remark;
	}
	

	public int getSno() {
		return sno;
	}

   public void setSno(int sno) {
		this.sno = sno;
	}


	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}




	public String getPhone() {
		return phone;
	}




	public void setPhone(String phone) {
		this.phone = phone;
	}




	public String getGender() {
		return gender;
	}




	public void setGender(String gender) {
		this.gender = gender;
	}




	public Date getBirth() {
		return birth;
	}




	public void setBirth(Date birth) {
		this.birth = birth;
	}




	public int getClazzno() {
		return clazzno;
	}




	public void setClazzno(int clazzno) {
		this.clazzno = clazzno;
	}




	public String getRemark() {
		return remark;
	}




	public void setRemark(String remark) {
		this.remark = remark;
	}




	@Override
	public String toString() {
		return "Student [sno=" + sno + ", pwd=" + pwd + ", sname=" + sname
				+ ", phone=" + phone + ", gender=" + gender + ", birth="
				+ birth + ", clazzno=" + clazzno + ", remark=" + remark + "]";
	}
 }
