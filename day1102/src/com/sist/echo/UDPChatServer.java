package com.sist.echo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;

public class UDPChatServer {
	
	//UDP������� �����͸� �ְ� �ޱ� ���� DatagramSocket�� DatagramPacket�� ��������� ����
	DatagramSocket socket;
	DatagramPacket packet;
	
	public UDPChatServer() {
		try {
		socket = new DatagramSocket(9005);
		
		//Ŭ���̾�Ʈ�� ���� ���ŵǴ� �����͸� ������� byte���� �迭�� packet�� ����
		byte []data = new byte[100];
		packet = new DatagramPacket(data, data.length);
		
		//���Ѵ�� ���·� Ŭ���̾�Ʈ�� ������ �����͸� �״�� �޾Ƹ�
		while(true) {
			
			//Ŭ���̾�Ʈ�� ���� �����͸� ������
			//�޾ƿö��� �������� InetAddress�� ������� 
			socket.receive(packet);
			
			//Ŭ���̾�Ʈ�� ������ �����͸� ����غ�
			String msg = new String(data);
			System.out.println("���ŵ� ������"+msg.trim());
			
			//��Ŷ�ȿ� ��� ������ ���� InetAddress�� Ȯ���غ�
			InetAddress addr = packet.getAddress();
			System.out.println("������ ���� �ּ�"+addr);
			
			//�� ��Ŷ�� �״�� �޾Ƹ���
			socket.send(packet);
			
			//���� �����͸� �����ϵ��� �迭�� ������ ������
			Arrays.fill(data, (byte)0);
			
		}
			
		}catch(Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}
	

	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
