package com.sist.exam03;

public class StringBufferTestAppend {

	public static void pro(String str) {
		System.out.println(str);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer data = new StringBuffer("hello");
		String msg = "java";
		int year = 2021;
		boolean flag = true;
		
		data.append("/");
		data.append(msg);
		data.append("/");
		data.append(year);
		data.append("/");
		data.append(flag);
		
		pro(String.valueOf(data));
		
		System.out.println(data);
		
		
		
		
	}

}
