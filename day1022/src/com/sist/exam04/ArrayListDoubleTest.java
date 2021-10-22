package com.sist.exam04;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDoubleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Double> list = new ArrayList<Double>();
		list.add(0.1);
		list.add(0.2);
		list.add(0.3);
		list.add(0.4);
		list.add(0.5);
		list.add(0.6);
		list.add(0.7);
		list.add(0.8);
		list.add(0.9);
		list.add(1.0);
		//1�� �ε��� ������ ����ϴ� ������ for ����
		for(int i = 0 ; i<list.size() ;i++) {
			System.out.printf("%.1f\t",list.get(i));
		}
		System.out.println();
		//2�� for-each ������ ���
		for(double n :list) {
			System.out.printf("%.1f\t",n);
		}
		System.out.println();
		//3�� Iterator �ݺ��� >>>>>>>�ٽ� ����
		Iterator<Double> iter = list.iterator();
		while(iter.hasNext()) { //iter.hashNext ������ true, ������ false>while�� Ż��
			System.out.printf("%.1f\t",iter.next());
		}
		
	}

}
/*
 **********************Iterator**************************
�÷��� �����ӿ�ũ���� ����� ��Ҹ� �о���� ����� ǥ��ȭ�ϱ� ���� ����(�������̽�)
Collection�� ���� �÷��ǵ��� ���� -> Iterator Ÿ���� ��ü�� ��ȯ�ϴ� �޼ҵ带 �̹� ����
List, Set�迭�� ����(Map�� ����)
�ַ� �б� �������� ����Ѵ�.
 */
