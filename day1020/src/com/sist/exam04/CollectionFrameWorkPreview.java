/*
 �÷��� : ���� ��ü�� ��� ������
 �����ӿ�ũ : ǥ��ȭ, ����ȭ�� ü������ ���α׷� ���
 �÷��� �����ӿ�ũ : �ټ��� ��ü�� �ٷ�� ���� ǥ��ȭ,����ȭ�� ���α׷��� ���
 �÷��� �����ӿ�ũ�� �ٽ� �������̽�
 1.List : ������ �ִ� �������� ����, �ߺ� ���� 
 2.Set : ������ ���� �������� ����, �ߺ� �Ұ�
 3.Map : ������ ���� �������� ����, �ߺ�(Ű - �Ұ�, �� - ����) 
 */



package com.sist.exam04;

import java.util.List;
import java.util.ArrayList;

public class CollectionFrameWorkPreview {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//List�÷����� �޼ҵ� ����
		List<String> list = new ArrayList<String>();
		list.add("ȫ�浿");
		list.add("ȫ�浿");
		list.add("ȫ���");
		list.add("ȫ���");
		list.add("ȫ���");
		list.add("ȫ���");
		list.add("ȫ�海");
		list.add("ȫ��");
		
		System.out.println(list.size());//8
		
		list.add("������");
		list.add("������");
		list.add("������");
		list.add("�̼���");
		
		System.out.println(list.size());//12
		//�迭�� ������ �� ũ�Ⱑ �����ǰ� ��� �߿� ũ�⸦ ������ �� ������,
		//ArrayList�� ��ü���� ������ �ڵ������� ���� �뷮�� �þ
		
	}

}
