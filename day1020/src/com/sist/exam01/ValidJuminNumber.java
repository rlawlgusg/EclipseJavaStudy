package com.sist.exam01;
import java.util.Scanner;
public class ValidJuminNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jumin;
		Scanner sc = new Scanner(System.in);
		System.out.println("�ֹι�ȣ�� �Է��ϼ���(�������� �Է��ϼ���)");
		jumin = sc.next();
		
		int[]n = {2,3,4,5,6,7,0,8,9,2,3,4,5};
		//�ε����� 6��°�� ��꿡 �������� ����!
		//���ڿ��� ���̴� 14�� 
		//�ݺ������ؾ��ϴ� �ε����� 12
		int sum = 0;
		for(int i=0;i<jumin.length()-1;i++) {
			if(i != 6) {
			sum += Integer.parseInt(jumin.charAt(i)+"")*n[i]; //+""�ϸ� ���ڿ��� �ȴ�!
			}
		}
		
		sum = sum%11;
		sum = 11-sum;
		if(sum == 10) {
			sum = 0;
		}
		if(sum == 11) {
			sum = 1;
		}
		
		int ck = Integer.parseInt(jumin.charAt(13)+""); 
		// charAt�� �ٷ� ����ȯ �Ұ� +""�� �ٿ� ���ڿ��� ����� String���� ������� ���� 
		//charAt�� ����� char��.. char�� ���ڿ�(String)���� ����� ���Ͽ� ���� ""���� ������ 
		if(sum == ck) {
			System.out.println("�ùٸ� �ֹι�ȣ �Դϴ�");
		}else {
			System.out.println("�ùٸ� �ֹι�ȣ�� �ƴմϴ�");
		}
		
		
	}

}
