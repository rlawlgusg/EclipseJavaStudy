package com.sist.exam02;

public class Graduate extends Student {
	private String type;
	private double rate;
	public Graduate(String name, String number, String major, int grade, double credits, String type, double rate) {
		super(name, number, major, grade, credits);
		this.type = type;
		this.rate = rate;
	}
	public Graduate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	@Override
	public String toString() {
		return "Graduate [조교 유형=" + type + ", 장학금 비율=" + rate + ", 이름=" + name + ", 학번=" + number + ", 학과="
				+ major + ", 학년=" + grade + ", 이수 학점=" + credits + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}
