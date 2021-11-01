package com.sist.tcp;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class TCPServerTest {

	public static void main(String[] args) {
		
		Random r = new Random();
		
		try {
			//1.서버소켓을 생성한다
			ServerSocket server = new ServerSocket(9001);
			
			//2.클라이언트의 접속을 무한대기상태로 기다림
			while(true) {
				//3.클라이언트의 접속을 수락
				//이메소드는 연결을 요청한 클라이언트 통신을 하기위한 소켓객체를 반환함
				//이러한 소켓을 데이터소켓이라고 함
				Socket socket = server.accept();
				System.out.println("클라이언트가 접속하였습니다");
				//4.데이터를 주고 받을 스트림을 생산
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();
				//5.스트림을 통해 데이터를 주고 받는다
				//요청한 클라이언트한테 10개의 정수를 난수로 만들어 내보내도록 해봄
				for(int i=1;i<=10;i++) {
					int n = r.nextInt(100);
					//0에서 100사이에 난수를 만들어
					System.out.println("서버가 난수 하나를 만들었습니다"+n);
					
					Thread.sleep(100);
					//0.1초 대기시간을 줌
					
					os.write(n);
					//그 난수를 클라이언트에게 출력함
					
					
					
				}
				System.out.println("클라이언트에게 데이터를 모두 내 보냈습니다");
			//6.사용했던 자원들을 닫아줌 
			is.close();
			os.close();
			socket.close();
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
	}

}
