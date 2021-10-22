package com.sist.exam01;

import java.util.HashMap;
import java.util.Scanner;

public class DictionaryTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//단어별 빈도수를 위한 map을 만들때는 
		//단어(key)순으로 정렬이 되도록 위하여 TreeMap
		//그런데 지금 사전의 경우는 굳이 정렬할 필요는 없음 HashMap
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("tiger", "호랑이");
		map.put("lion", "사자");
		map.put("apple", "사과");
		
		Scanner sc = new Scanner(System.in);
		String eng,kor;
		
		while(true) {
		System.out.print("찾고자 하는 단어를 입력하세요");
		eng = sc.next();
		kor = map.get(eng);
		if(kor !=null) {
		System.out.println(kor);
		}else {
			System.out.println("등록된 단어가 아닙니다");
		}
	}	
}

}
