/*
 컬렉션 : 여러 객체를 담아 놓은것
 프레임워크 : 표준화, 정형화된 체계적인 프로그램 방식
 컬렉션 프레임워크 : 다수의 객체를 다루기 위한 표준화,정형화된 프로그래밍 방식
 컬렉션 프레임워크의 핵심 인터페이스
 1.List : 순서가 있는 데이터의 집합, 중복 가능 
 2.Set : 순서가 없는 데이터의 집합, 중복 불가
 3.Map : 순서가 없는 데이터의 집합, 중복(키 - 불가, 값 - 가능) 
 */



package com.sist.exam04;

import java.util.List;
import java.util.ArrayList;

public class CollectionFrameWorkPreview {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//List컬렉션의 메소드 예제
		List<String> list = new ArrayList<String>();
		list.add("홍길동");
		list.add("홍길동");
		list.add("홍길순");
		list.add("홍길순");
		list.add("홍길순");
		list.add("홍길분");
		list.add("홍길돈");
		list.add("홍길");
		
		System.out.println(list.size());//8
		
		list.add("김유신");
		list.add("김유신");
		list.add("유관순");
		list.add("이순신");
		
		System.out.println(list.size());//12
		//배열은 생성할 때 크기가 고정되고 사용 중에 크기를 변경할 수 없지만,
		//ArrayList는 객체들이 들어오면 자동적으로 저장 용량이 늘어남
		
	}

}
