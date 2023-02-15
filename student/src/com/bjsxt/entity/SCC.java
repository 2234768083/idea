package com.bjsxt.entity;

public class SCC {
	
	
	//学生表
    private int  sno;
	
	private  String sname;
	
	//班级表
	private int  clazzroom;
	
	//课程表
    private int cno;
	
	private String name;
	
	private int credit;
	
	//得分
	private  int score;

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getClazzroom() {
		return clazzroom;
	}

	public void setClazzroom(int clazzroom) {
		this.clazzroom = clazzroom;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "SCC [sno=" + sno + ", sname=" + sname + ", clazzroom="
				+ clazzroom + ", cno=" + cno + ", name=" + name + ", credit="
				+ credit + ", score=" + score + "]";
	}

	public SCC(int sno, String sname, int clazzroom, int cno, String name,
			int credit, int score) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.clazzroom = clazzroom;
		this.cno = cno;
		this.name = name;
		this.credit = credit;
		this.score = score;
	}

	public SCC() {
		super();
	}
	
	
	

}
