package com.sist.exam01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class DictionaryTestMenu {
	public static Scanner sc = new Scanner(System.in);	
	public static String eng,kor;
	//메뉴 출력을 위한 메소드
	public static void printMenu() {
		System.out.println("1.단어등록 2.단어검색 3.모두출력 4.단어삭제 0.종료");
		System.out.print("메뉴를 선택하세요");
	}
	//단어 등록을 위한 메소드
	public static void insertWord(HashMap<String, String> map) {
		System.out.println("새로운 단어를 등록합니다");
		System.out.print("영어단어를 입력하세요");
		eng = sc.next();
		System.out.print("한국어 뜻을 입력하세요");
		sc.nextLine();//입력버퍼의 내용을 지워줌
		kor = sc.nextLine(); //
		map.put(eng, kor);
		System.out.println("새로운 단어를 등록하였습니다");
	}
	
	//단어 검색을 위한 메소드
	public static void searchWord(HashMap<String, String> map) {
		System.out.println("영어단어를 검색합니다");
		System.out.println("찾고자 하는 단어를 입력하세요");
		eng = sc.next();
		kor = map.get(eng);
		
		if(kor != null) {
			System.out.printf("검색한 단어 %s의 뜻은 %s입니다\n",eng,kor);
		}else {
			System.out.printf("찾고자 하는 단어 %s는 등록되어 있지 않습니다\n",eng);
		}
			
		
		
	}
	//모두 출력을 위한 메소드
	public static void printAll(HashMap<String, String> map) {
		System.out.println("영어\t한국어");
		System.out.println();
		Iterator<String> eng_list =map.keySet().iterator();
		while(eng_list.hasNext()) {
			eng = eng_list.next();
			kor = map.get(eng);
			System.out.println(eng+"\t"+kor);
		}
	
	}
	//단어 삭제를 위한 메소드
	public static void deleteWord(HashMap<String, String> map) {
		System.out.println("단어를 삭제합니다");
		System.out.println("삭제할 영어단어를 입력하세요");
		eng = sc.next();
		kor = map.remove(eng);
		if(kor != null) {
			System.out.printf("영어단어 %s를 사전에서 삭제하였습니다\n",eng);
		}else {
			System.out.printf("삭제하려는 영어단어 %s는 사전에 없습니다\n",eng);
		}
	}
	
	
	
	public static void main(String[] args) {
		
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("tiger", "호랑이");
		map.put("lion", "사자");
		map.put("apple", "사과");
		
		Scanner sc = new Scanner(System.in);
		String eng,kor;
		int menu=-1;
		while(menu !=0) {
			printMenu();
			menu = sc.nextInt();
			switch(menu) {
				case 1:insertWord(map);break;
				case 2:searchWord(map);break;
				case 3:printAll(map);break;
				case 4:deleteWord(map);break;
		
		}
		
	}	System.out.println("프로그램을 종료합니다");
}

}
//sc.next()와 sc.nextLine()은 동작방식이 다름!
//next()는 입력 구분을 스페이스, tap, 엔터로 구분
//nextLine()은 엔터로만 구분
//그래서 이것을 같이 사용할 때는 문제가 발생됌
//우리가 키보드로 부터 입력하는 모든 것들은 "입력버퍼"를 통하여 변수에 대입됌
//next()와 nextLine()을 같이 사용할 때에는 입력버퍼의 내용을 지워주고 사용해야함
//입력버퍼의 내용을 지워주기 위해서는 nextLine()을 한번더 사용!
