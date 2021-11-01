package com.sist.echo03;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

public class TCPChatServer extends Thread{
	ArrayList<Socket> list = new ArrayList<Socket>(); //����Ȯ�ο�
	Socket socket;
	byte []data = new byte[100];
	
	public TCPChatServer(Socket socket) {
		this.socket = socket;
		list.add(socket);
	}
	
	public void run() {
		System.out.println(socket.getLocalAddress()+"���� �����Ͽ����ϴ�");
		try {
		InputStream is = socket.getInputStream();
		OutputStream os = socket.getOutputStream();
		while(true) {
			String msg = new String(data);
			System.out.println("���ŵ� ������"+ msg.trim());
			
			os.write(data);

			Arrays.fill(data, (byte)0);
		}
		
		
		}catch(Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}
		
		
	}
	
	public static void main(String[] args) {
		
	
	try {
		ServerSocket server = new ServerSocket(9003);
		
		while(true) {
			Socket socket = server.accept(); //���ϼ����� ���ӽ� socketuser�� ������ �����Ҵ�
			Thread t = new TCPChatServer(socket);
			t.start();
		}
		
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
				
	
		
	}

}
