package com.sist.exam07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.sist.exam04.Student;

public class MapPrograming11 {
	public static Scanner sc = new Scanner(System.in);
	
	
	public static void printMenu() {
		System.out.print("1.추가 2.검색 3.삭제 0.종료");
		System.out.print("메뉴를 선택하세요 :");
	}
	
	public static void insertWord(HashMap<String, String> map){
		System.out.println("단어를 입력하세요");
		String word = sc.next();
		System.out.println("단어의 설명을 입력하세요");
		String explain = sc.next();
		map.put(word, explain);	
	}
	public static void searchWord(HashMap<String, String> map) {
		System.out.println("검색할 단어를 입력하세요");
		String word = sc.next();
		map.get(word);
		
		
			if(map.get(word).equals(word)) {
				map.get(word);
			}
				if(map.get(word) != null) {
					System.out.println(map.get(word));
				}else {
					System.out.println("찾고자하는 "+word+"는 없습니다");
				}	
	}	
	
	public static void deleteWord(HashMap<String, String> map) {
		System.out.println("삭제할 단어를 입력하세요");
		String word = sc.next();
		map.get(word);
		int cnt = map.size();
		map.remove(word);
		
			
			if(cnt > map.size()) {	
				System.out.println(word +"를 삭제하였습니다");
			}else {
				System.out.println("삭제하려는 단어 "+word+"는 없습니다");
			}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("apple", "사과");
		map.put("banana", "바나나");
		map.put("orange", "오렌지");
		map.put("mango", "망고");
		map.put("strawberry", "딸기");
		
		while(true) {
		printMenu();
		int answer = sc.nextInt();
		if(answer == 0 ) {
			break;
		}
		
		switch(answer) {
			case 1: insertWord(map); break;
			case 2: searchWord(map); break;
			case 3: deleteWord(map); break;
			
		}	
			
		}
		
		
		
	}

}
