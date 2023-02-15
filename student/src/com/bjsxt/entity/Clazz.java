package com.bjsxt.entity;

public class Clazz {
	
    private int clazzno;
	
	private String cname;
	
	private String cteacher;
	
	private int  clazzroom;
	
	
	public Clazz() {
		super();
	}

	public Clazz(int clazzno, String cname, String cteacher, int clazzroom) {
		super();
		this.clazzno = clazzno;
		this.cname = cname;
		this.cteacher = cteacher;
		this.clazzroom = clazzroom;
	}

	public int getClazzno() {
		return clazzno;
	}

	public void setClazzno(int clazzno) {
		this.clazzno = clazzno;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCteacher() {
		return cteacher;
	}

	public void setCteacher(String cteacher) {
		this.cteacher = cteacher;
	}

	public int getClazzroom() {
		return clazzroom;
	}

	public void setClazzroom(int clazzroom) {
		this.clazzroom = clazzroom;
	}

	@Override
	public String toString() {
		return "Clazz [clazzno=" + clazzno + ", cname=" + cname + ", cteacher="
				+ cteacher + ", clazzroom=" + clazzroom + "]";
	}
	
}
