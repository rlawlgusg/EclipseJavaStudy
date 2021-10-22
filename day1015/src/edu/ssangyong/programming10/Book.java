package edu.ssangyong.programming10;

import java.util.Objects;

public class Book {
	protected String number;
	protected String title;
	protected String author;
	protected int fee;
	
	public Book() {}

	public Book(String number, String title, String author) {
		this.number = number;
		this.title = title;
		this.author = author;
	}
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
//비교 대상인 Member 객체가 Object 자료형의 변수 obj에 전달 -> 다형성
//Member 객체가 Object 자료형 변수에 저장되면
//->접근 가능한 멤버 제한
//->원래의 Member 객체로 형변환 필요
//->(자식자료형클래스)부모자료형변수
//instanceof연산자 : 형변환이 가능한지 확인해주는 연산자, 형변환 하기 전에 무조건 사용, 결과값은 boolean값(true/false)
	
	@Override
	public boolean equals(Object obj) {
		boolean result=false; 
		if (obj instanceof Book) { 
	       Book b = (Book)obj; 
	       if(number.equals(b.number)) { 
	         result = true;
	       }
		} 
	     return result;
	}
	//equals()를 오버라이딩 하면 hashCode()도 오버라이딩 해야한다?
	public int hashCode() {
		return Objects.hash(number, title, author);
	}
	
	public int getLateFees(int latedate) {
		return fee*latedate; 
	}
	
	
}