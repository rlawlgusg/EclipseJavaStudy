package com.sist.exam03;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;

public class StudentTestObjectOutStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student lee = new Student("�̰ǿ�",100,100,100);
		
		//Student ��ü�� lee�� ������ ���Ϸ� ����ϰ� ����
		// - ���ڴ����� ��� (�̸�,����,����,������ ��� ���ڿ��� ����� ���ʷ� ���)
		// - ����Ʈ������ ���(��ü�� ��°�� ���)
		
		//����Ʈ����(��ü����)�� ���
		//
		try {
			//��ü������ ����ϱ� ���� ObjectOutputStream��ü�� ������ 
			//�̶� Ȯ���ڴ� txt������ �ƴϱ� ������ .txt�� ���� ����
			//���α׷��� ���ݿ� �µ��� �˸°� Ȯ���� �̸��� ������ 
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("c:/myData/lee.stu"));
			//��ü�� ����� 
			oos.writeObject(lee);
			//���� ����� �������� ������ �ݾ���
			oos.close();
			
			System.out.println("������ �����Ǿ����ϴ�");

		
		}catch(Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}
		
		
		
	}

}
