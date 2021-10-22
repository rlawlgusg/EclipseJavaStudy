package edu.ssangyong.programming10;

public class Poet extends Book {

	@Override
	public int getLateFees(int latedate) {
		super.fee = 200;
		return fee*latedate;
	}
	
	
}
