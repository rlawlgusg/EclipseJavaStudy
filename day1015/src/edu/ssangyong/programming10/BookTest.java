package edu.ssangyong.programming10;

public class BookTest {

	public static void main(String[] args) {
		Book b1 = new Book("1234","�ڹ��� ����","���� ��");
		Book b2 = new Book("1234","�ڹ��� ����","���� ��");
		Book b3 = new Book("2313","�����п���","����");

		
		System.out.println(b1.equals(b2));//true
		System.out.println(b2.equals(b3));//false
		
		System.out.println(b1.hashCode());//iv�� ������(true)
		System.out.println(b2.hashCode());//���� ���� ������ �ȴ�
		System.out.println(b3.hashCode());//�ٸ���
		
	    Novel n = new Novel();
	    System.out.println(n.getLateFees(1));//300
	    System.out.println(n.getLateFees(3));//900
	    
	    Poet p = new Poet();
	    System.out.println(p.getLateFees(1));//200
	    System.out.println(p.getLateFees(3));//600
	 
	    ScienceFiction s = new ScienceFiction();
	    System.out.println(s.getLateFees(1));//600
	    System.out.println(s.getLateFees(3));//1800
	   
	
	}

}
