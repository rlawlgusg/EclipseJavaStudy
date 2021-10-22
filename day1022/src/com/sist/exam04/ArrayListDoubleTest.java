package com.sist.exam04;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDoubleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Double> list = new ArrayList<Double>();
		list.add(0.1);
		list.add(0.2);
		list.add(0.3);
		list.add(0.4);
		list.add(0.5);
		list.add(0.6);
		list.add(0.7);
		list.add(0.8);
		list.add(0.9);
		list.add(1.0);
		//1번 인덱스 변수를 사용하는 보통의 for 루프
		for(int i = 0 ; i<list.size() ;i++) {
			System.out.printf("%.1f\t",list.get(i));
		}
		System.out.println();
		//2번 for-each 구문을 사용
		for(double n :list) {
			System.out.printf("%.1f\t",n);
		}
		System.out.println();
		//3번 Iterator 반복자 >>>>>>>다시 공부
		Iterator<Double> iter = list.iterator();
		while(iter.hasNext()) { //iter.hashNext 있으면 true, 없으면 false>while문 탈출
			System.out.printf("%.1f\t",iter.next());
		}
		
	}

}
/*
 **********************Iterator**************************
컬렉션 프레임워크에서 저장된 요소를 읽어오는 방법을 표준화하기 위한 역할(인터페이스)
Collection의 하위 컬렉션들이 소유 -> Iterator 타입의 객체를 반환하는 메소드를 이미 구현
List, Set계열에 구현(Map은 없음)
주로 읽기 전용으로 사용한다.
 */
