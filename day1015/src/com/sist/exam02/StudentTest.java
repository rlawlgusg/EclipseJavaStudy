package com.sist.exam02;
import java.util.Scanner;
public class StudentTest {

	public static void main(String[] args) {
//				UnderGraduate underGraduate = new UnderGraduate("ȫ�浿", "20211234", "��ǻ�Ͱ���", 1, 24.0, "��۴�");
//				Graduate graduate = new Graduate("�̼���", "20211111", "�ΰ�����", 2, 15, "��������", 1);
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
			System.out.print("���� �ϼ��� 1:�кλ�, 2:���п���");
			choice = sc.nextInt();
			}while(choice !=1 && choice !=2); 
		
		System.out.print("�л��� �̸��� �Է��ϼ���: ");
		name = sc.next();
		System.out.print("�й��� �Է��ϼ���: ");
		number = sc.next();
	    System.out.print("�а��� �Է��ϼ���: ");
		major = sc.next();
		System.out.print("�г��� �Է��ϼ���: ");
		grade = sc.nextInt();
		System.out.print("�ʼ������� �Է��ϼ���: ");
		credit = sc.nextDouble();
		
		if(choice == 1) {
			String club;
			System.out.print("���Ƹ����� �Է��ϼ���: ");
			club = sc.next();
			s = new UnderGraduate(name, number, major, grade, credit, club);
		}else {
			String type;
			double rate;
			System.out.print("���� ������ �Է��ϼ���: ");
			type = sc.next();
			System.out.print("���б� ������ �Է��ϼ���: ");
			rate = sc.nextDouble();
			s = new Graduate(name, number, major, grade, credit, type, rate);
		}
		System.out.println(s);
	}

}
