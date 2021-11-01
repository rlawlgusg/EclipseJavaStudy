package com.sist.echo02;
//코드를 복사하여 UDP방식으로 수정
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class TCPChatServer {

	public static void main(String[] args) {
		//클라이언트로 부터 수신된 데이터를 담기 위한 byte의 배열을 만듬
		
		try {
			DatagramSocket socket = new DatagramSocket(9003);
			
			while(true) { 
				byte []data = new byte[100];
				InetAddress addr = InetAddress.getByName("192.168.168.103");
				DatagramPacket packet = new DatagramPacket(data, data.length, addr ,9004);
				
				data = 
				String msg = new String(data);
				System.out.println("수신된 데이터"+ msg.trim());

				
				os.write(data);
				
				Arrays.fill(data, (byte)0);
				
				socket.send(packet);
	
			
			}
			
			
		}catch(Exception e) {
			System.out.println("예외발생"+e.getMessage());
		}
	}

}
