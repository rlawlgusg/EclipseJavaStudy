//finally : try- catch���� �Բ� �����ؾ��ϸ� try-catch���� ���� �������� ��ġ
//����ó���� �߻����θ� ���� ������ �����ϵ��� �ϴ� ����
//try��Ͽ��� ���ܰ� �߻��ϸ� ���� ���� ��, catch������� �̵��Ͽ� ����ó�� �ڵ带 ����
//�� �Ŀ� finally����� �ڵ带 ������ 
//try, catch��Ͽ��� return���� ����ϴ��� finally����� �׻� ����ȴ�

package com.sist.exam03;

public class  TryCatchFinally
{
	public static void main(String[] args) 
	{
		try{
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		int result = a/b;
		System.out.println("���: "+result);
		}catch(Exception e){
			System.out.println("�ι�°���� 0�� �ƴ� �ΰ��� ���ڸ� ������ �ּ���");
		}finally {
			System.out.println("����� �ٽ� �����մϴ�");
			System.out.println("�������� ������ ����Ǿ���ϴ� �޼ҵ�!!");
		}

	
	}
}

