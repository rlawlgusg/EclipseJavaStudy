package com.sist.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

public class Player {
	private static final String Player = null;
	//ī���� ���ڸ� map�� key����
	String []number = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
	//map�� �����
	HashMap<String, Integer> map = new HashMap<String, Integer>();
	//"2"�� ���� value�� ���� 2�� �� �׸��� 1�� ������ų���� 
		
	
	
	public TreeSet<Integer> pairList = new TreeSet<Integer>();
	//���� �̷�� ī������ ��� ���� ���� ����Ʈ�� ������ 
	//2,3,4,2,3,4,6 >> 2,3,4
	
	//������ �ϴ� ����ڰ� CardDeck�� ���� ī�带 �ϳ��� �����ͼ� ���� ����Ʈ�� ����
	private ArrayList<Card> list = new ArrayList<Card>();
	
	
	
	public Player() {
		int value =2;
		//ī���� ���� �迭��ŭ �ݺ�����
		for(int i=0;i<number.length;i++) {
			map.put(number[i], value++);//map�� key�� ī���� ���ڷ�, value�� 2���� 1�������� ��
		}
	}
	
	
	public int pairProcess(String Player) {
			int n = 0;
			for(int i=0;i<list.size();i++) {
				for(int j=i+1;j<list.size();j++) {
					//i��° ī���� ���ڿ� j��° ī���� ���ڰ� �������� �Ǻ�
					if(list.get(i).getNumber().equals(list.get(j).getNumber())) {
						//������ ī���� ����(���ڿ�)�� �ش��ϴ� ������ �����κ��� �̾ƿ� 
						n = map.get(list.get(i).getNumber());
						//���� �̷�� ���ڸ� pairList�� ����
						pairList.add(n);
					}
				}
		}
			Iterator<Integer> iter =  pairList.iterator();
			
			//pairList�� 3�� �϶� ū�� �ΰ��� �̾ƿ�������
			if(pairList.size()==3) { //���� �̷�� ī�尡 3���̸�
				System.out.println(Player + "�� ����� �Դϴ�");
				iter.next();		 //���ڰ� ���� ���� ī��� ����
				n = iter.next()+iter.next();//������ ���� �ΰ��� ���ϱ�
			}else if(pairList.size()==2){ //���� �̷�� ī�尡 2���̸�
				System.out.println(Player + "�� ����� �Դϴ�");
				n = iter.next()+iter.next(); //�ΰ��� ���� ����
			}else if(pairList.size()==1) { //���� �̷�� ī�尡 1���̸�
				System.out.println(Player + "�� ����� �Դϴ�");
				n = iter.next();		   //�� ���ڸ� ��ȯ
			}
				
			return n;
			
	}
	
	
	
	//ī�带 �Ű������� �޾Ƽ� ���� list�� ����
	public void getCard(Card card) {
		list.add(card);
	}
	//��������� �Ǻ��Ͽ�
	//���� �̰���� ó���Ϸ���
	//������� ���ڸ� ��ȯ�Ϸ�����
	//���ڰ� 2~10������ Integer.parseInt()�ϸ� ������ ����� �ִµ� ��������
	//�׷��� ī���� ���ڰ� "Jack",'Queen","King","Ace"�̷��͵��� Integer.parseInt�� ����
	//�׷��� "2"�� key�� �ϰ� 2�� value�� �ϴ� map�� ���� �޿� �����
	//"Jack"�̶�� key���� 11�̶�� value�� ���� 
	
	public String flush() {
		int flush =0;
		String s = "";
		for(int i=0;i<list.size();i++) {
			for(int j=i;j<list.size()-1;j++) {
				if(list.get(i).getSuit()==(list.get(j+1).getSuit())) { 
					//if(suit[0]==suit[1] && suit[1]==suit[2] &&
					 // suit[2] == suit[3] && suit[3]==suit[4])
					flush++;
					
					if(flush == 5) {
					s = list.get(i).getSuit();//5�����;� �Ǵµ� �� 4������ ������?
					return s;
					}
				}
			}
		}
		return s;
		
		
	}
	
	//���� ī�带 ��� �����
	public void showCards() {
		System.out.println(list);
	}
	



}

//�����: 2���� ���,���� 2�� ���� 
//��Ʈ����Ʈ: ���ڰ� �̾����� ī�� 5�� 5,4,3,2,A�� ���� ��Ʈ����Ʈ A,K,Q,J,10�� ���� ��Ʈ����Ʈ...?
//�÷���: ���̰� ���� ī�� 5�� 