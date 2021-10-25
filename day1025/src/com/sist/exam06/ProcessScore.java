package com.sist.exam06;

public class ProcessScore {

		public static int score(int []score) throws IllegalScoreException{
			int avg = 0;
			int sum = 0;
			for(int i=0;i<score.length;i++) {
				sum += score[i];
				if(score[i] < 0) {
					throw new IllegalScoreException("잘못된 값 입니다");
				}	
				avg = sum/score.length;
			}

			return avg;		
		
		}

}
