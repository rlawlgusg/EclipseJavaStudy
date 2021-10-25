package com.sist.exam01;

import java.util.ArrayList;
import java.util.Iterator;

public class Excercise09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Double> list = new ArrayList<Double>();
		list.add(3.4);
		list.add(2.7);
		list.add(5.5);
		//인덱스 변수를 사용하는 보통의 for 루프
		for(int i=0;i<list.size();i++) {
			double data = list.get(i);
			System.out.println(data);
		}
		//for-each 구문 사용
		for(double data:list) {
			System.out.println(data);
		}
		//Iterator(반복자) 사용 
		//데이터가 있는 만큼 반복 수행하기 위한 클래스
		//이 목록의 요소에 대한 반복자를 적절한 순서로 반환
		Iterator<Double> iter  =list.iterator();
		while(iter.hasNext()) {
			double data = iter.next();
			System.out.println(data);
		}
		
		
	}

}
