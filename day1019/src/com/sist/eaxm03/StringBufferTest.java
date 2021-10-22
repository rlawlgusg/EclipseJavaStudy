package com.sist.eaxm03;

public class StringBufferTest {

	public static void pro(String str) {
		System.out.println("처리하는 문자열은 "+str+"입니다");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer data = new StringBuffer("hello");
		data.append("korea");
		System.out.println(data);
		
		//A의 data와 B의 data는 같은 메모리를 참조함
		//StringBuffer의 내용을 바꾸더라도 새로운 메모리를 만들지 않고
		//기존 객체의 내용이 변경됌
		//따라서 원하는 문자열 처리에는 StringBuffer 혹은 StringBuilder를
		//사용하는 것이 좋음!!!!
		
		pro(new String(data));
		//String r = new String(data);
		//pro(r);
		
		//그런데 만약 이렇게 처리된 StringBuffer를 매개변수로 전달하여
		//어떤 메소드를 사용할 때에는 다시 String으로 변환해야 하는 경우가 많음
		//문자열을 매개변수로 받아 처리하는 대부분의 메소드는 String으로 받도록 되어있는 것이 일반적!
		
		//pro(data);
		//pro메소드는 String을 매개변수로 갖기 때문에 StringBuffer를 전달불가
		
		//이와 같이 어떤 메소드를 호출하기 위하여 StringBuffer를 String을 바꾸어야 하는 경우가 많음
		//이를 위하여 String의 생성자 중에 StringBuffer를 매개변수로 갖는 생성자를 이용함
	}

}
