package edu.ssangyong.lab1;

public class Student extends Human {

	String major; //6��

	public Student() {
		System.out.println("�ڽ�Ŭ������ �⺻������ �Դϴ�");
	}

	public Student(String name, int age, String major) { //7��
		super(name, age);
		this.major = major;
		System.out.println("�ڽ�Ŭ������ �Ű����� �ִ� ������ �Դϴ�");
	}
	//8��
	public String getMajor() { 
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	//9��
	@Override
	public String toString() {
		return " �̸� : " + name + ", ���� : " + age + ", ���� : "+ major ;
	}
	//10��
	public static void main(String[] args) {
		Student student1 = new Student("����", 21, "��ǻ��");
		Student student2 = new Student("����", 22, "�濵");
		Student student3 = new Student("����", 24, "����");
		
		System.out.println(student1);
		System.out.println(student2);
		System.out.println(student3); 
		
		//11��
		Student s1 = new Student();
		System.out.println(s1); 
		//�θ�Ŭ������ �⺻������ �Դϴ�
		//�ڽ�Ŭ������ �⺻������ �Դϴ�
		//�̸� : null, ���� : 0, ���� : null
		
		Student s2 = new Student("ȫ�浿",25,"��ǻ��");
		System.out.println(s2);
		//�θ�Ŭ������ �Ű����� �ִ� ������ �Դϴ�
		//�ڽ�Ŭ������ �Ű����� �ִ� ������ �Դϴ�
		//�̸� : ȫ�浿, ���� : 25, ���� : ��ǻ��
	}

	@Override
	public String getProfession() {
		// TODO Auto-generated method stub
		return "�л�";
	}
	

}
