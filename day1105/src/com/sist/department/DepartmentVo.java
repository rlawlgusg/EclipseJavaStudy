package com.sist.department;

public class DepartmentVo {
	
	private int no;
	private String name;
	private String site;
	
	public DepartmentVo(int no, String name, String site) {
		super();
		this.no = no;
		this.name = name;
		this.site = site;
	}

	public DepartmentVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}
	
	
	
	
	
}
