package com.sist.exam02;

import java.io.FileWriter;

import com.sist.exam03.Student;

public class StudentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student lee = new Student("�̰ǿ�",100,100,100);
		
		//Student ��ü�� lee�� ������ ���Ϸ� ����ϰ� ����
		// - ���ڴ����� ��� (�̸�,����,����,������ ��� ���ڿ��� ����� ���ʷ� ���)
		// - ����Ʈ������ ���(��ü�� ��°�� ���)
		
		//���ڴ����� ���
		try {
		FileWriter fw = new FileWriter("c:/myData/lee.txt");
		
		//��ü�� �̸��� ���Ϸ� ���
		fw.write(lee.getName()+",");
		
		//��ü�� ���������� ���Ϸ� ���
		fw.write(lee.getKor()+",");

		//��ü�� ���������� ���Ϸ� ���
		fw.write(lee.getEng()+",");
		
		//��ü�� ���������� ���Ϸ� ���
		fw.write(lee.getMath()+"");
		
		//������ ����� �������� ������ �ݾ���
		fw.close();
		
		System.out.println("������ �����Ͽ����ϴ�");
		
		}catch(Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}
		
		
		
	}

}
