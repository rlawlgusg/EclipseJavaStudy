package com.sist.exam02;

import java.util.HashSet;

public class HashSetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//HashSet은 중복만 안하도록 관리, 순서는 지마음대로
		HashSet data = new HashSet();
		data.add("사과");
		data.add("포도");
		data.add("수박");
		data.add("귤");
		System.out.println(data);
		data.add("오렌지");
		data.add("사과");
		System.out.println(data);
	}

}
