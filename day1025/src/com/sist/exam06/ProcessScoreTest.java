package com.sist.exam06;

public class ProcessScoreTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			int []score = {50,50,50,50};
			int n = ProcessScore.score(score);
			//�޼ҵ� ȣ���ϴ� �ʿ��� ����ó���� �ؾ���
			System.out.println(n);
		}catch(IllegalScoreException e) {
			System.out.println("���ܹ߻� "+e.getMessage());
		}
	}



}
