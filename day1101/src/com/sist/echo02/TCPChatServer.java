package com.sist.echo02;
//�ڵ带 �����Ͽ� UDP������� ����
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
		//Ŭ���̾�Ʈ�� ���� ���ŵ� �����͸� ��� ���� byte�� �迭�� ����
		
		try {
			DatagramSocket socket = new DatagramSocket(9003);
			
			while(true) { 
				byte []data = new byte[100];
				InetAddress addr = InetAddress.getByName("192.168.168.103");
				DatagramPacket packet = new DatagramPacket(data, data.length, addr ,9004);
				
				data = 
				String msg = new String(data);
				System.out.println("���ŵ� ������"+ msg.trim());

				
				os.write(data);
				
				Arrays.fill(data, (byte)0);
				
				socket.send(packet);
	
			
			}
			
			
		}catch(Exception e) {
			System.out.println("���ܹ߻�"+e.getMessage());
		}
	}

}
