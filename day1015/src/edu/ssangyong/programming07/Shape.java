package edu.ssangyong.programming07;

import java.util.Scanner;

public abstract class Shape {
	public static void main(String []args){
		Ellipse e;
		Rectangle r;
		Triangle t;
		
		Shpere s;
		Cube c;
		Cylinder l;
		
	
	Scanner sc = new Scanner(System.in);
	
	int type;
	int choice;
	double length;
	double width;
	double height;
	double radius;
	
	System.out.print("����� ������ �����ϼ��� 1. 2���� ����  2. 3���� ����");
	type = sc.nextInt();
	if(type == 1){
		System.out.print("������ ����� ������ �����ϼ��� 1.Ÿ�� 2.�簢�� 3.�ﰢ��");
		choice = sc.nextInt();
		
		if(choice == 1){
			System.out.print("�������� ���̸� �Է��ϼ���: ");
			radius = sc.nextDouble();
			e = new Ellipse(radius);
			System.out.println("���� ������ "+e.getArea()+"�Դϴ�");

		}else if(choice == 2){
			System.out.print("������ ���̸� �Է��ϼ���: ");
			width = sc.nextDouble();
			System.out.print("������ ���̸� �Է��ϼ���: ");
			length = sc.nextDouble();
			r = new Rectangle(width, length);
			System.out.println("�簢���� ������ "+r.getArea()+"�Դϴ�");
		
		}else if(choice == 3){
			System.out.print("������ ���̸� �Է��ϼ���: ");
			width = sc.nextDouble();
			System.out.print("������ ���̸� �Է��ϼ���: ");
			length = sc.nextDouble();
			t = new Triangle(width, length);
			System.out.println("�ﰢ���� ������ "+t.getArea()+"�Դϴ�");
		}
	}else {
		
		System.out.print("ü���� ����� ������ �����ϼ��� 1.�� 2.������ü 3.�����");
		choice = sc.nextInt();
		
		if(choice == 1){
			System.out.print("�������� ���̸� �Է��ϼ���: ");
			radius = sc.nextDouble();
			s = new Shpere(radius);
			System.out.println("���� ü���� "+s.getVolume()+"�Դϴ�");
			
		}else if(choice == 2){
			System.out.print("������ ���̸� �Է��ϼ���: ");
			width = sc.nextDouble();
			System.out.print("������ ���̸� �Է��ϼ���: ");
			length = sc.nextDouble();
			System.out.print("���̸� �Է��ϼ���: ");
			height = sc.nextDouble();
			c = new Cube(width, length, height);
			System.out.println("������ü�� ü���� "+c.getVolume()+"�Դϴ�");
		
		}else if(choice == 3){
			System.out.print("�������� ���̸� �Է��ϼ���: ");
			radius = sc.nextDouble();
			System.out.print("���̸� �Է��ϼ���: ");
			height = sc.nextDouble();
			l = new Cylinder(radius , height);
			System.out.println("������� ü���� "+l.getVolume()+"�Դϴ�");
		}
		}
	}
}	
	
 


