package com.sist.echo03;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

public class TCPChatServer extends Thread{
	ArrayList<Socket> list = new ArrayList<Socket>(); //유저확인용
	Socket socket;
	byte []data = new byte[100];
	
	public TCPChatServer(Socket socket) {
		this.socket = socket;
		list.add(socket);
	}
	
	public void run() {
		System.out.println(socket.getLocalAddress()+"님이 접속하였습니다");
		try {
		InputStream is = socket.getInputStream();
		OutputStream os = socket.getOutputStream();
		while(true) {
			String msg = new String(data);
			System.out.println("수신된 데이터"+ msg.trim());
			
			os.write(data);

			Arrays.fill(data, (byte)0);
		}
		
		
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		
		
	}
	
	public static void main(String[] args) {
		
	
	try {
		ServerSocket server = new ServerSocket(9003);
		
		while(true) {
			Socket socket = server.accept(); //소켓서버에 접속시 socketuser에 접속자 정보할당
			Thread t = new TCPChatServer(socket);
			t.start();
		}
		
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
				
	
		
	}

}
