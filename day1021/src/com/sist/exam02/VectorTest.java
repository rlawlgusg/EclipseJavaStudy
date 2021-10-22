package com.sist.exam02;

import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector list = new Vector();
		list.add("사과");
		list.add("수박");
		list.add("딸기");
		System.out.println(list);
		list.add("포도");
		list.add("사과");
		System.out.println(list);
	}

}
