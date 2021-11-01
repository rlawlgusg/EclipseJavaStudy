package com.sist.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;

public class UDPRecever {
	public static void main(String[] args) {
		//UDP 방식에서 데이터를 주고 받기 위해서는 DatagramSocket이 필요
		//DatagramSocket(int port);
		
		try {
			DatagramSocket socket = new DatagramSocket(9002);
			//보내오는 데이터를 담기위한 byte의 배열을 만듬
			byte []data = new byte[100];
			
			//Sender가 보내오는 데이터를 받기 위하여 DatagramPacket객체를 생성함
			DatagramPacket packet = new DatagramPacket(data, data.length);
			
			//Sender가 보내오는 데이터를 계속 받기 위하여 무한반복문으로 표현함
			while(true) {
				//DatagramSocket의 receive메소드를 통해 데이터를 받음
				socket.receive(packet);
				
				//진짜로 받아진 데이터는 byte의 배열인 (패킷을 만들때 준 배열) data에 담아져있음
				//이것을 String 생성자를 이용하여 문자열로 만듬
				String msg = new String(data);
				System.out.println("수신된 데이터:"+msg);
				//다음에 수신되는 데이터를 위하여 data를 비워야함
				Arrays.fill(data,(byte)0);
				//소켓을 닫아줌
				socket.close();
			}
			
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		
		
	}
}
