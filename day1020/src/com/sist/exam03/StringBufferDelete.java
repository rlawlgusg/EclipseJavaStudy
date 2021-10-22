package com.sist.exam03;

public class StringBufferDelete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer data = new StringBuffer("hello java");
		data.deleteCharAt(5);
		System.out.println(data);
		
		data.delete(3, 5);
		System.out.println(data);
		
	}

}
