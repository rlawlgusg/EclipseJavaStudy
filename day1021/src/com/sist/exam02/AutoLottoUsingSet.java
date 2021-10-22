package com.sist.exam02;

import java.util.Random;
import java.util.TreeSet;

public class AutoLottoUsingSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeSet set = new TreeSet();
		Random r = new Random();
		
		while(set.size()<6) {
			set.add(r.nextInt(45)+1);
		}
		System.out.println(set);
	}

}
