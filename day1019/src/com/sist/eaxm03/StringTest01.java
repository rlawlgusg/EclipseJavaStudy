package com.sist.eaxm03;

public class StringTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String data = new String("안녕하세요");
		String data2 = "안녕하세요";
		System.out.println(data);
		System.out.println(data2);
		
		byte[]arr = data.getBytes();
		for(byte b :arr) {
			System.out.println(b);
		}
		
		String result = new String(arr);
		System.out.println(result);
		//네트워크 통신이나 파일로 자료를 저장할 때 문자열 데이터를 byte형으로 변환하여 전송함
		//전송받은 byte형의 배열을 다시 String으로 만들기 위해서 byte배열을 매개변수로 갖는 
		//String의 생성자를 이용함 
		//그리고 String 데이터를 byte으로 변환하기 위해서 getBytes()메소드를 이용함
		
	}

}
