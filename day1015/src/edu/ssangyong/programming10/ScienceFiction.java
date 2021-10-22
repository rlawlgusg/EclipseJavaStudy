package edu.ssangyong.programming10;

public class ScienceFiction extends Book {

	@Override
	public int getLateFees(int latedate) {
		super.fee = 600;
		return fee*latedate;
	}

		
}
