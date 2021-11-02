package com.sist.tcp;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

//서버가 한번에 여러명의 클라이언트와 대화가 가능하도록(메아리) 하기 위하여 클라이언트와
//계속하여 대화를 주고받는 기능은 쓰레드로 구현함

class ServerThread extends Thread{
	
	//요청한 클라이언트와 연결된 소켓을 멤버변수로 선언
	Socket socket;
	
	//연결된 클라이언트와 데이터를 주고받을 스트림을 생성
	InputStream is;
	OutputStream os;

	//실제로 데이터가 담길 배열을 선언
	byte []data = new byte[100];
	
	//객체생성시 클라이언트와 연결된 소켓을 매개변수로 받아 멤버변수에 담고
	//스트림을 선언함
	public ServerThread(Socket socket) {
		this.socket = socket;
		try {
			is = this.socket.getInputStream();
			os = this.socket.getOutputStream();
			
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}	
	}
	
	public void run() {
		while(true) {
			try {
			//클라이언트로 부터 데이터를 수신함
			is.read(data);
			String msg = new String(data);
			System.out.println("수신된 데이터"+ msg.trim());
			
			//클라이언트로 부터 수신된 데이터를 그대로 메아리함
			os.write(data);
			
			//다음에 수신될 데이터를 위하여 배열을 깨끗히 비워줌
			Arrays.fill(data, (byte)0);
			}catch(Exception e) {
				System.out.println("예외발생:"+e.getMessage());
			}
		}		
	}
}

public class TCPChatServer {

	public static void main(String[] args) {
		//클라이언트로 부터 수신된 데이터를 담기 위한 byte의 배열을 만듬
		byte []data = new byte[100];
		
		try {
			//1.serverSocket을 통해 서버를 가동함
			ServerSocket server = new ServerSocket(9003);
			
			while(true) { //무한대기 상태로 클라이언트의 접속을 기다림 
				//클라이언트의 요청을 수락함
				Socket socket = server.accept();
				
				//연결된 클라이언트와 대화를 계속 주고받기 위한 쓰레드 객체를 생성하고 
				//쓰레드를 가동함 
				ServerThread thread = new ServerThread(socket);
				thread.start();
				
			
			}
			
			
		}catch(Exception e) {
			System.out.println("예외발생"+e.getMessage());
		}
	}

}
