package com.sist.exam02;
import java.util.Scanner;
public class StringBooleanPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name;
		Scanner sc = new Scanner(System.in);
		System.out.println("�̸��� �Է��ϼ���");
		name = sc.next();
		if(name.startsWith("��")) {
			System.out.println("�达�Դϴ�");
		}else {
			System.out.println("�达�� �ƴմϴ�");
		}
	}
}
