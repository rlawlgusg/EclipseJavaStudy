package com.sist.eaxm03;

public class StringTestTrim {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String data = "   java   ";
		int n = data.length();
		System.out.println(n);
		String data2 = data.trim();
		int n2 = data2.length();
		System.out.println(n2);
		System.out.println("|"+data+"|");
		System.out.println("|"+data2+"|");
		data = data.trim();
		System.out.println("|"+data+"|");
		
	}
}
