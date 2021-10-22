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
	
	System.out.print("계산할 도형을 선택하세요 1. 2차원 도형  2. 3차원 도형");
	type = sc.nextInt();
	if(type == 1){
		System.out.print("면적을 계산할 도형을 선택하세요 1.타원 2.사각형 3.삼각형");
		choice = sc.nextInt();
		
		if(choice == 1){
			System.out.print("반지름의 길이를 입력하세요: ");
			radius = sc.nextDouble();
			e = new Ellipse(radius);
			System.out.println("원의 면적은 "+e.getArea()+"입니다");

		}else if(choice == 2){
			System.out.print("가로의 길이를 입력하세요: ");
			width = sc.nextDouble();
			System.out.print("세로의 길이를 입력하세요: ");
			length = sc.nextDouble();
			r = new Rectangle(width, length);
			System.out.println("사각형의 면적은 "+r.getArea()+"입니다");
		
		}else if(choice == 3){
			System.out.print("가로의 길이를 입력하세요: ");
			width = sc.nextDouble();
			System.out.print("세로의 길이를 입력하세요: ");
			length = sc.nextDouble();
			t = new Triangle(width, length);
			System.out.println("삼각형의 면적은 "+t.getArea()+"입니다");
		}
	}else {
		
		System.out.print("체적을 계산할 도형을 선택하세요 1.구 2.직육면체 3.원기둥");
		choice = sc.nextInt();
		
		if(choice == 1){
			System.out.print("반지름의 길이를 입력하세요: ");
			radius = sc.nextDouble();
			s = new Shpere(radius);
			System.out.println("구의 체적은 "+s.getVolume()+"입니다");
			
		}else if(choice == 2){
			System.out.print("가로의 길이를 입력하세요: ");
			width = sc.nextDouble();
			System.out.print("세로의 길이를 입력하세요: ");
			length = sc.nextDouble();
			System.out.print("높이를 입력하세요: ");
			height = sc.nextDouble();
			c = new Cube(width, length, height);
			System.out.println("직육면체의 체적은 "+c.getVolume()+"입니다");
		
		}else if(choice == 3){
			System.out.print("반지름의 길이를 입력하세요: ");
			radius = sc.nextDouble();
			System.out.print("높이를 입력하세요: ");
			height = sc.nextDouble();
			l = new Cylinder(radius , height);
			System.out.println("원기둥의 체적은 "+l.getVolume()+"입니다");
		}
		}
	}
}	
	
 


