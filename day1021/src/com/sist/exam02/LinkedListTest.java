package com.sist.exam02;

import java.util.LinkedList;

public class LinkedListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList list = new LinkedList();
		list.add("사과");
		list.add("수박");
		list.add("딸기");
		System.out.println(list);
		list.add("포도");
		list.add("사과");
		System.out.println(list);
	}

}
