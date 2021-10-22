package com.sist.eaxm03;

public class StringTestSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String data = "abcdefghijklmn";
		String data2 = data.substring(3, 8);
		String data3 = data.substring(8);
		System.out.println(data2);
		System.out.println(data3);
		
		String url = "https://docs.oracle.com/javase/8/docs/api/index.html";
		url.lastIndexOf("index.html");
//		System.out.println(url.lastIndexOf("index.html"));//42
//		System.out.println(url.substring(42));
		
		System.out.println(url.substring( url.lastIndexOf('/')+1));
		
		
		
	}
}
