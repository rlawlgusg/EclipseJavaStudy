package com.sist.exam02;

public class ArrayAppend {

	public static void printArray(int []data) {
		for(int n:data) {
			System.out.printf("%5d",n);
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []data = {10,20,30,40};
		printArray(data);
		//�迭�� �ǵڿ� 50�� �߰��ϰ�����..
		//1.data�迭 ���������� �����迭�� ���� +1��ŭ �ٽ� �޸𸮸� Ȯ���ؾ���
		//2.data�迭�� ��Ҹ� ��� ���� Ȯ���� �迭�� �̵�
		//3.����Ȯ���� �迭�� �������� 50�� ���� 
		
		int []data2 = new int[data.length+1];
		for(int i=0;i<data.length;i++) {
			data2[i]=data[i];
		}
		data2[data2.length-1] = 50;
		data = data2;
		printArray(data2);
		
		//�迭�� �������� �߰�, ���� �۾��� ����� ��쿡�� ���ŷο�
		//�׷��� �÷��������ӿ�ũ�� �����!
	}

}