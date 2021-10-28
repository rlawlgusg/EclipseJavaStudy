package com.sist.exam01;

import java.io.FileReader;

public class StudentTest {

	public static void main(String[] args) {
		
		//�ؽ�Ʈ ������ ������ ��ǻ�� �޸𸮷� �о� ���̱� ���Ͽ� FileReaderŬ������ �̿���
		//�� FileReader�� �����ڴ� ���ܸ� �������� 
		try {
		FileReader fr = new FileReader("c:/myData/student.txt");
		//���Ϸ� ���� �ѱ��ھ� �о���̴� �޼ҵ� : read() �о���� ������ �������� ��ȯ
		//������ ���� �����ϸ� -1�� ��ȯ
		//������ ������ �о���̵��� ��
			
		//�о���� ���ڵ��� ��Ƽ� ���ڿ��� ����� ���� ����
		//�ѹ��ھ� �о� ��� ���� �����ϱ� ���Ͽ� �ʱⰪ ""�� ������
		String str ="";
		
		int ch;//���Ϸ� ���� �ѱ��ھ� �о���̱� ���� ����
		while(true) {
			ch = fr.read(); //���Ϸ� ���� �ѱ��ڸ� �о����
			if(ch == -1) {	//������ ���� �����ϸ� �ݺ����� Ż����
				break;
			}
			
			//�о���� ������ ���ڰ��� �ٽ� ���ڷ� ����ȯ�Ͽ� ������ ������
			char data = (char)ch;
			System.out.print(data);
			
			//�о���� ���ڸ� ���ڿ� ���� str�� ������
			str = str+data;		
			
		}
	
		//������ ������ ��� �а��� �ݺ����� Ż����
		//������ ����� ������ ������ �ݾ� �־�� ��
		fr.close();
		
		//�ݺ����� Ż���ϸ� 
		//���ڿ����� str�� ������ ������ ��� �������
		System.out.println(str);
		
		//�� ���ڿ��� ������ ","�� �и���
		//StringŬ������ split�޼ҵ带 �̿��Ͽ� �и��غ�
		//split�� �и��� �����͵��� ���ڿ� �迭�� ��ȯ
		String []arr = str.split(",");
		//�и��� �����͸� ���� �ִ� �迭�� ù��° ��Ҵ� �̸���
		String name = arr[0]; 
		//�и��� �����͸� ���� �ִ� �迭�� �ι�° ��Ҵ� ��������
		//arr[1]�� String��.. �̰��� int�� ��ȯ�Ͽ� ���� kor�� ���� 
		int kor = Integer.parseInt(arr[1]);
		
		int eng = Integer.parseInt(arr[2]);
		int math = Integer.parseInt(arr[3]);
		
		int tot = kor+eng+math;
		int avg = tot/3;
		
		System.out.println("�̸�:"+name);
		System.out.println("����:"+kor);
		System.out.println("����:"+eng);
		System.out.println("����:"+math);
		System.out.println("����:"+tot);
		System.out.println("���:"+avg);
		
		}catch(Exception e) {
			//���ܰ� �߻��Ǹ� ���ܸ޼����� ����� 
			System.out.println("���ܹ߻� : "+e.getMessage());
		}				
	}
}
