package com.sist.exam07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class StringWordCount {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		ArrayList<String> list = new ArrayList<String>();
		System.out.print("문자열을 입력하세요:");
		String word = sc.nextLine();
		
		word.replace(".", "").replace(",", "").replace("/","").replace(";","").replace(":", "");
		word.split(" ");
		list.add(word);
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int cnt =0;
		for(int i=0;i<list.size();i++) {
			if(map.equals(list)) {
				map.put(list.get(i), map.get(cnt=i+1));
			}else {
				map.put(list.get(i), 1);
			}
		}
		System.out.println(map); //에러ㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓ미ㅏㅓ리어ㅣㄹ먿

		
		
	}

}
