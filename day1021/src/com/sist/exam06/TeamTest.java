package com.sist.exam06;

import java.util.ArrayList;
import java.util.Scanner;

public class TeamTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<Double> list = new ArrayList<Double>();
		double score = 0;
		
		
		for(int i=0;i<10;i++) {
		System.out.printf("%d번째 심사위원 점수: ",i+1);
		score = sc.nextDouble();
			if(score>=0.0 && score<=10.0) {
				list.add(score);	
			}else {
				System.out.println("잘못된 입력입니다");
				break;
			}
		}
		for(int i=0;i<list.size();i++) {
			System.out.printf("%.1f점\t",list.get(i));
		}
		
		
		double max = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i) > max) {
				 max = list.get(i);
			 }
		double min = list.get(0);
		for (int j = 1; j < list.size(); j++) {
			if (list.get(j) < min) {
				min = list.get(j);
			}

		double sum = 0.0;
		
		list.remove(max);
		list.remove(min);
		
		for(double k : list){
			sum += k;
		}
		System.out.print("점수 합계: "+ sum);	//오류


} 
		  
	
		
		
	}
	}
}
