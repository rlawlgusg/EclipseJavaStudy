package com.sist.exam03;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		int sum=0;
		Scanner sc = new Scanner(System.in);
		
		for(int i=0;i<5;i++) {
		
		System.out.printf("%d��° �л��� ������ �Է��Ͻÿ�",i+1);
		list.add(sc.nextInt());
		sum += list.get(i);
		}
		double avg = (double)sum/list.size();
		
		for(int i=0;i<list.size();i++) {
			System.out.printf("%d�� �л��� ����:%d\n",i+1,list.get(i));
			
			
		}
			System.out.println();
		System.out.println("����:"+sum);
		System.out.printf("���: %.1f\n",avg);
		
		
		
	}

}
