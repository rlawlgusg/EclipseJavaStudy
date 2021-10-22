package com.sist.exam02;

import java.util.Random;

public class AutoLottoUsingArray {
	public static void printArray(int []data) {
		for(int n:data) {
			System.out.print(n+"\t");
		}
	}
	public static boolean isAlready(int value,int last,int []arr) {
		boolean flag = false;
		for(int i=0;i<last;i++) {
			if(arr[i]== value) {
				flag = true;
				break;
			}
		}
		return flag;
	}
	public static void sortArray(int []arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[j]<arr[i]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//로또는 1~45까지 6개의 숫자를 선택(중복없이)
		int []n = new int[6];
		Random r = new Random();
		for(int i=0;i<n.length;) {
			int temp = r.nextInt(45)+1;
			if(isAlready(temp,i,n)==false) {
			n[i] = temp;
			i++;
			}
		}
		sortArray(n);
		printArray(n);
		
		
		
		
	}

}
