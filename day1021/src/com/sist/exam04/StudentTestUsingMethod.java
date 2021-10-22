package com.sist.exam04;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentTestUsingMethod {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void printMenu() {
		System.out.print("1.추가 2.검색 3.삭제 4.모두출력 5.모두삭제 0.종료");
		System.out.print("메뉴를 선택하세요 :");
	}
	
	public static void insertStudent(ArrayList<Student> list) {
		String name, addr,phone;
		System.out.println("학생의 이름을 입력하세요");
		name = sc.next();
		System.out.println("학생의 주소를 입력하세요");
		addr = sc.next();
		System.out.println("학생의 전화번호를 입력하세요");
		phone = sc.next();
		list.add(new Student(name,addr,phone));
	}
	
	public static void searchStudent(ArrayList<Student> list) {
		String name;
		System.out.println("검색할 학생의 이름을 입력하시오");
		name = sc.next();
		Student searchstudent = null;
		
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getName().equals(name)) {
				searchstudent = list.get(i);
			}
		}
				if(searchstudent != null) {
					System.out.println(searchstudent);
				}else {
					System.out.println("찾고자하는 학생 "+name+"은 없습니다");
				}
		}
	
	public static void deleteStudent(ArrayList<Student> list) {
		String name;
		System.out.println("삭제할 학생의 이름을 입력하세요");
		name = sc.next();
		int i;
		int cnt = list.size(); 
		// 리스트를 삭제하면 리스트의 크가거 변경되기 때문에 삭제하기 전 리스트의 크기를 미리 변수에 저장 
		for(i=0;i<list.size();i++) {
			if(list.get(i).getName().equals(name)) {
				list.remove(i);
				break;
			}
		}
		if(i < cnt) {
			System.out.println(name +"학생의 데이터를 삭제하였습니다");
		}else {
			System.out.println("삭제하려는 학생"+name+"은 없습니다");
		}
		
	}
	
	public static void allPrintStudent(ArrayList<Student> list) {
		if(list.isEmpty()) {
			System.out.println("데이터가 없습니다");
		}else {
			for(Student student : list) {
				System.out.println(student);
			}
		}
	}
	
	private static void allDeleteStudent(ArrayList<Student> list) {
		list.clear();
		System.out.println("데이터를 모두 삭제하였습니다");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Student> list = new ArrayList<Student>();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			printMenu();
			int menu = sc.nextInt();
			if(menu == 0 ) {
				break;
			}
			
			switch(menu) {
				case 1: insertStudent(list); break;
				case 2: searchStudent(list); break;
				case 3: deleteStudent(list); break;
				case 4: allPrintStudent(list); break;
				case 5: allDeleteStudent(list); break;
			}
		}
	}
}
//main메소드안에 모든 복잡한 일처리를 다 집어넣게 되면 가독성(readability)가 떨어짐
//각각의 구체적인 일처리들은 메소드에게 맞기고 main메소드에서는 해당 메소드를 호출해 줌으로써
//가독성(readability)를 높일 수 있음 
