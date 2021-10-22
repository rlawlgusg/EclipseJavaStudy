package edu.ssangyong.programming10;

public class Novel extends Book {
	
	
	@Override
	public int getLateFees(int latedate) {
			super.fee=300;
		return fee*latedate;
	}
	
}
