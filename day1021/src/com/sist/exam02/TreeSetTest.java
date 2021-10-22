package com.sist.exam02;

import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeSet set = new TreeSet();
		set.add("»ç°ú");
		set.add("¼ö¹Ú");
		set.add("µþ±â");
		System.out.println(set);
		System.out.println(set.size());
		set.add("¹Ù³ª³ª");
		set.add("»ç°ú");
		set.add("±Ö");
		set.add("°¨");
		System.out.println(set);
		System.out.println(set.size());
		set.remove("µþ±â");
		System.out.println(set);
		System.out.println(set.size());
		
	}

}
