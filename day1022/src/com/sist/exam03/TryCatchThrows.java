//throws�� ����ó���� ���� ��� 
//���ܸ� ���������� �̷�� ó��
//�޼ҵ� ����γ��� �ۼ� �޼ҵ忡�� ó������ ���� ���ܸ� ȣ���� ������ ���ѱ�
package com.sist.exam03;

class ThrowsTest{
	
	public static void test(String a,String b) throws NumberFormatException{
		int sum = Integer.parseInt(a)+Integer.parseInt(b);
		System.out.printf(a,b);
	} 
}

public class TryCatchThrows {

	public static void main(String[] args) {
	
		
		ThrowsTest test = new ThrowsTest();
		try {
			ThrowsTest.test("1", "��");
		}catch(NumberFormatException e) {
			System.out.println("�߸��� �Է°� �Դϴ�");
		}
		

	}

}
