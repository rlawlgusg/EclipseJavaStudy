package com.sist.exam06;

public class ProcessScoreTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			int []score = {50,50,50,50};
			int n = ProcessScore.score(score);
			//메소드 호출하는 쪽에서 예외처리를 해야함
			System.out.println(n);
		}catch(IllegalScoreException e) {
			System.out.println("예외발생 "+e.getMessage());
		}
	}



}
