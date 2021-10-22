package com.sist.exam01;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class WordCountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String data;
		System.out.print("������ �Է��ϼ���:");
		data = sc.nextLine();//���鹮�ڵ� �Է¹ޱ� ���Ͽ� nextLine���
		//System.out.println(data);
		StringTokenizer st = new StringTokenizer(data);
		//�Է¹����� ���鹮�ڷ� �и�
		TreeMap<String, Integer> map = new TreeMap<String, Integer>();
		//�ܾ key�� �ϰ� �󵵼��� value�� �Ͽ� �����ϱ� ���� map�� ���� 
		while(st.hasMoreElements()) { //�Է¹������� ���� �и��� �ܾŭ �ݺ� 
			String word = st.nextToken(); //�и��� �ܾ �ϳ��� ������ ����� 
			Integer cnt = map.get(word);//map���� ���� �ܾ��� �󵵼��� ������� ������ 1 ������ null
			if(cnt == null) { //���࿡ �� �ܾ map�� ���ٸ� 
				map.put(word, 1); //�󵵼��� 1�� �����Ͽ� map�� �߰� 
			}else { //�׷��� �ʴٸ�(�̹� �� �ܾ map�� �ִٸ�)
				map.put(word, cnt+1); //�� �󵵼��� +1�� ������ �ٽ� ����
			}
		}
		
		//System.out.println(map);
	
		//map�� �ִ� ��� key����� set���� ��ȯ��
		//map�� �ִ� �ڷḸŭ �ݺ������ϱ� ���ؼ� map�� ��� Ű ����� �о�� 
		Set<String> KeyList = map.keySet();
		//set��ü���� �ݺ����� �ϱ� ���� ����� ����...�׷���
		//set�� �ڷḦ �ϳ��� ������ ���� ���� ���Ͽ� Iterator�� ��������
		Iterator<String> iter = KeyList.iterator();
		
		while(iter.hasNext()) { 
		//�ܾ �󵵼��� ��� �ִ� map�� key����� ����ִ� iterateor�� �����Ͱ� �ִ� ��ŭ �ݺ�����
			String word = iter.next(); //iterator�κ��� �����͸� �������� �ܾ��� �� �ܾ�� map�� key
			int cnt = map.get(word); //map���κ��� �� �ܾ�(key)�� �󵵼�(value)�� ������ 
			System.out.printf("%20s %d\n",word,cnt); //��� 
		}
	}

}
