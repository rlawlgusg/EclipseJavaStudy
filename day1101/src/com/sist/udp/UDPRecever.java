package com.sist.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;

public class UDPRecever {
	public static void main(String[] args) {
		//UDP ��Ŀ��� �����͸� �ְ� �ޱ� ���ؼ��� DatagramSocket�� �ʿ�
		//DatagramSocket(int port);
		
		try {
			DatagramSocket socket = new DatagramSocket(9002);
			//�������� �����͸� ������� byte�� �迭�� ����
			byte []data = new byte[100];
			
			//Sender�� �������� �����͸� �ޱ� ���Ͽ� DatagramPacket��ü�� ������
			DatagramPacket packet = new DatagramPacket(data, data.length);
			
			//Sender�� �������� �����͸� ��� �ޱ� ���Ͽ� ���ѹݺ������� ǥ����
			while(true) {
				//DatagramSocket�� receive�޼ҵ带 ���� �����͸� ����
				socket.receive(packet);
				
				//��¥�� �޾��� �����ʹ� byte�� �迭�� (��Ŷ�� ���鶧 �� �迭) data�� ���������
				//�̰��� String �����ڸ� �̿��Ͽ� ���ڿ��� ����
				String msg = new String(data);
				System.out.println("���ŵ� ������:"+msg);
				//������ ���ŵǴ� �����͸� ���Ͽ� data�� �������
				Arrays.fill(data,(byte)0);
				//������ �ݾ���
				socket.close();
			}
			
		}catch(Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}
		
		
	}
}
