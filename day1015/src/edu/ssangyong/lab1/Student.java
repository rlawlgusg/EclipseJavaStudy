package edu.ssangyong.lab1;

public class Student extends Human {

	String major; //6번

	public Student() {
		System.out.println("자식클래스의 기본생성자 입니다");
	}

	public Student(String name, int age, String major) { //7번
		super(name, age);
		this.major = major;
		System.out.println("자식클래스의 매개변수 있는 생성자 입니다");
	}
	//8번
	public String getMajor() { 
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	//9번
	@Override
	public String toString() {
		return " 이름 : " + name + ", 나이 : " + age + ", 과목 : "+ major ;
	}
	//10번
	public static void main(String[] args) {
		Student student1 = new Student("명진", 21, "컴퓨터");
		Student student2 = new Student("미현", 22, "경영");
		Student student3 = new Student("용준", 24, "경제");
		
		System.out.println(student1);
		System.out.println(student2);
		System.out.println(student3); 
		
		//11번
		Student s1 = new Student();
		System.out.println(s1); 
		//부모클래스의 기본생성자 입니다
		//자식클래스의 기본생성자 입니다
		//이름 : null, 나이 : 0, 과목 : null
		
		Student s2 = new Student("홍길동",25,"컴퓨터");
		System.out.println(s2);
		//부모클래스의 매개변수 있는 생성자 입니다
		//자식클래스의 매개변수 있는 생성자 입니다
		//이름 : 홍길동, 나이 : 25, 과목 : 컴퓨터
	}

	@Override
	public String getProfession() {
		// TODO Auto-generated method stub
		return "학생";
	}
	

}
