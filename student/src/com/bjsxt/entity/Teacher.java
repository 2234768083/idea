package com.bjsxt.entity;

import java.io.Serializable;
import java.util.Date;

public class Teacher implements Serializable {
	
	private int  tno;
	
	private String tname;
	
	private String pwd;
	
	private String phone;
	
	private Date hiredate;
	
	private String remark;
	
	
	
	
	public Teacher() {
		
	}
    
	
	public Teacher(int tno, String tname, String pwd, String phone,
			Date hiredate, String remark) {
		super();
		this.tno = tno;
		this.tname = tname;
		this.pwd = pwd;
		this.phone = phone;
		this.hiredate = hiredate;
		this.remark = remark;
	}



	public int getTno() {
		return tno;
	}


	public void setTno(int tno) {
		this.tno = tno;
	}


	public String getTname() {
		return tname;
	}


	public void setTname(String tname) {
		this.tname = tname;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public Date getHiredate() {
		return hiredate;
	}


	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}


	@Override
	public String toString() {
		return "teacher [tno=" + tno + ", tname=" + tname + ", pwd=" + pwd
				+ ", phone=" + phone + ", hiredate=" + hiredate + ", remark="
				+ remark + "]";
	}
	
	

	
	
	

}
