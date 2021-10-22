package com.sist.eaxm03;

public class StringTestIndexOf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String data = new String("Returns the index within this string of the first occurrence of the specified character.");
		int index = data.indexOf("the");
		System.out.println(index);//8 공백 제외
		
		int index2 = data.indexOf("the", 9);
		System.out.println(index2);
		
		int index3 = data.indexOf("hello");
		System.out.println(index3);
		
		int index4 = data.indexOf('e');
		System.out.println(index4);

		int index5 = data.indexOf("e");
		System.out.println(index5);
		
	
	
	
		
	
	}
}
