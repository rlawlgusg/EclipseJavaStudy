package com.sist.note02;

import java.io.File;

public class FileDeleteTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//"c:/myData/�޸�.txt"������ �����ϴ� ���α׷��� �ۼ�
		File file = new File("c:/myData/�޸�.txt");
		file.delete();
		System.out.println("�����Ͽ����ϴ�");
	}

}
