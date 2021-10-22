package com.sist.exam02;

public class UnderGraduate extends Student {
	private String club;

	public UnderGraduate(String name, String number, String major, int grade, double credits, String club) {
		super(name, number, major, grade, credits);
		this.club = club;
	}

	public UnderGraduate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}

	@Override
	public String toString() {
		return "UnderGraduate [동아리명=" + club + ", 이름=" + name + ", 학번=" + number + ", 학과=" + major + ", 학년="
				+ grade + ", 이수 학점=" + credits + "]";
	}

	

	
	
}
