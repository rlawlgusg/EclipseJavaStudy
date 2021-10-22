package com.sist.exam02;
import java.util.Scanner;
public class StudentTest {

	public static void main(String[] args) {
//				UnderGraduate underGraduate = new UnderGraduate("홍길동", "20211234", "컴퓨터공학", 1, 24.0, "방송댄스");
//				Graduate graduate = new Graduate("이순신", "20211111", "인공지능", 2, 15, "연구조교", 1);
//				System.out.println(underGraduate);
//				System.out.println(graduate);
		
	
		
		Student s;
		Scanner sc = new Scanner(System.in);
		int choice;
		String name;
		String number;
		String major;
		int grade;
		double credit;
		
		do{
			System.out.print("선택 하세요 1:학부생, 2:대학원생");
			choice = sc.nextInt();
			}while(choice !=1 && choice !=2); 
		
		System.out.print("학생의 이름을 입력하세요: ");
		name = sc.next();
		System.out.print("학번을 입력하세요: ");
		number = sc.next();
	    System.out.print("학과를 입력하세요: ");
		major = sc.next();
		System.out.print("학년을 입력하세요: ");
		grade = sc.nextInt();
		System.out.print("필수학점을 입력하세요: ");
		credit = sc.nextDouble();
		
		if(choice == 1) {
			String club;
			System.out.print("동아리명을 입력하세요: ");
			club = sc.next();
			s = new UnderGraduate(name, number, major, grade, credit, club);
		}else {
			String type;
			double rate;
			System.out.print("조교 유형을 입력하세요: ");
			type = sc.next();
			System.out.print("장학금 비율을 입력하세요: ");
			rate = sc.nextDouble();
			s = new Graduate(name, number, major, grade, credit, type, rate);
		}
		System.out.println(s);
	}

}
