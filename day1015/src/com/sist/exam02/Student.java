package com.sist.exam02;

public class Student {
	protected String name;
	protected String number;
	protected String major;
	protected int grade;
	protected double credits;
	
	public Student(String name, String number, String major, int grade, double credits) {
		super();
		this.name = name;
		this.number = number;
		this.major = major;
		this.grade = grade;
		this.credits = credits;
	}

	public Student() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public double getCredits() {
		return credits;
	}

	public void setCredits(double credits) {
		this.credits = credits;
	}

	@Override//������̼� 
	public String toString() {
		return "Student [�̸�=" + name + ", �й�=" + number + ", �а�=" + major + ", �г�=" + grade + ", �̼� ����="
				+ credits + "]";
	}
	
	

}
