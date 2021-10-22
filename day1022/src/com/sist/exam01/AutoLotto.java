package com.sist.exam01;

import java.util.Random;
import java.util.TreeSet;

public class AutoLotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//로또 1개 1~45까지의 숫자가 중복되지 않도록 6개 선택
		
		TreeSet<Integer> lotto = new TreeSet<Integer>();
		Random r = new Random();
		
		while(lotto.size()<6) {
			lotto.add(r.nextInt(45)+1);
		}
		System.out.println(lotto);
		
	}

}
