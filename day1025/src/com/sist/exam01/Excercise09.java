package com.sist.exam01;

import java.util.ArrayList;
import java.util.Iterator;

public class Excercise09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Double> list = new ArrayList<Double>();
		list.add(3.4);
		list.add(2.7);
		list.add(5.5);
		//�ε��� ������ ����ϴ� ������ for ����
		for(int i=0;i<list.size();i++) {
			double data = list.get(i);
			System.out.println(data);
		}
		//for-each ���� ���
		for(double data:list) {
			System.out.println(data);
		}
		//Iterator(�ݺ���) ��� 
		//�����Ͱ� �ִ� ��ŭ �ݺ� �����ϱ� ���� Ŭ����
		//�� ����� ��ҿ� ���� �ݺ��ڸ� ������ ������ ��ȯ
		Iterator<Double> iter  =list.iterator();
		while(iter.hasNext()) {
			double data = iter.next();
			System.out.println(data);
		}
		
		
	}

}
