package com.sist.exam02;
public class LoginBoard implements SistAction
{
	public void pro() 
	{
		System.out.println("로그인 하였습니다");
	}
}

//왜 SistAction의 후손이 되게 해야 합니까?
//서비스 요청에 따른 일처리 메소드를 하나로 통일 시키기 위함
//그렇지 않으면 만약 각각의 서비스명에 따른 일처리 하는 메소드가 제각각 다르다면 처리하기가 복잡함