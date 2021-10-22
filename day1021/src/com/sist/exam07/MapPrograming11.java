package com.sist.exam07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.sist.exam04.Student;

public class MapPrograming11 {
	public static Scanner sc = new Scanner(System.in);
	
	
	public static void printMenu() {
		System.out.print("1.�߰� 2.�˻� 3.���� 0.����");
		System.out.print("�޴��� �����ϼ��� :");
	}
	
	public static void insertWord(HashMap<String, String> map){
		System.out.println("�ܾ �Է��ϼ���");
		String word = sc.next();
		System.out.println("�ܾ��� ������ �Է��ϼ���");
		String explain = sc.next();
		map.put(word, explain);	
	}
	public static void searchWord(HashMap<String, String> map) {
		System.out.println("�˻��� �ܾ �Է��ϼ���");
		String word = sc.next();
		map.get(word);
		
		
			if(map.get(word).equals(word)) {
				map.get(word);
			}
				if(map.get(word) != null) {
					System.out.println(map.get(word));
				}else {
					System.out.println("ã�����ϴ� "+word+"�� �����ϴ�");
				}	
	}	
	
	public static void deleteWord(HashMap<String, String> map) {
		System.out.println("������ �ܾ �Է��ϼ���");
		String word = sc.next();
		map.get(word);
		int cnt = map.size();
		map.remove(word);
		
			
			if(cnt > map.size()) {	
				System.out.println(word +"�� �����Ͽ����ϴ�");
			}else {
				System.out.println("�����Ϸ��� �ܾ� "+word+"�� �����ϴ�");
			}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("apple", "���");
		map.put("banana", "�ٳ���");
		map.put("orange", "������");
		map.put("mango", "����");
		map.put("strawberry", "����");
		
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
