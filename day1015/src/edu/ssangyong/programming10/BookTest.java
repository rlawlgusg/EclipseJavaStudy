package edu.ssangyong.programming10;

public class BookTest {

	public static void main(String[] args) {
		Book b1 = new Book("1234","자바의 정석","남궁 성");
		Book b2 = new Book("1234","자바의 정석","남궁 성");
		Book b3 = new Book("2313","경제학원론","김대식");

		
		System.out.println(b1.equals(b2));//true
		System.out.println(b2.equals(b3));//false
		
		System.out.println(b1.hashCode());//iv가 같으면(true)
		System.out.println(b2.hashCode());//같은 값이 나오게 된다
		System.out.println(b3.hashCode());//다르다
		
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
