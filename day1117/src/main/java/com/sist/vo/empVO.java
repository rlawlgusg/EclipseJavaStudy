package com.sist.vo;

import java.util.Date;

public class empVO {
	//직원들의 사원번호, 사원명, 입사일, 연봉, 주민번호, 아이디를 출력
	private int eno;
	private String ename;
	private Date hirdate;
	private int annualsalary;
	private String jumin;
	private String id;
	
	public empVO(int eno, String ename, Date hirdate, int annualsalary, String jumin, String id) {
		super();
		this.eno = eno;
		this.ename = ename;
		this.hirdate = hirdate;
		this.annualsalary = annualsalary;
		this.jumin = jumin;
		this.id = id;
	}
	public empVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Date getHirdate() {
		return hirdate;
	}
	public void setHirdate(Date hirdate) {
		this.hirdate = hirdate;
	}
	public int getAnnualsalary() {
		return annualsalary;
	}
	public void setAnnualsalary(int annualsalary) {
		this.annualsalary = annualsalary;
	}
	public String getJumin() {
		return jumin;
	}
	public void setJumin(String jumin) {
		this.jumin = jumin;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
