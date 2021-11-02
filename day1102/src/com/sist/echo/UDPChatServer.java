package com.sist.echo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;

public class UDPChatServer {
	
	//UDP방식으로 데이터를 주고 받기 위한 DatagramSocket과 DatagramPacket을 멤버변수로 선언
	DatagramSocket socket;
	DatagramPacket packet;
	
	public UDPChatServer() {
		try {
		socket = new DatagramSocket(9005);
		
		//클라이언트로 부터 수신되는 데이터를 담기위한 byte형의 배열과 packet을 생성
		byte []data = new byte[100];
		packet = new DatagramPacket(data, data.length);
		
		//무한대기 상태로 클라이언트가 보내온 데이터를 그대로 메아리
		while(true) {
			
			//클라이언트로 부터 데이터를 수신함
			//받아올때는 보낸측의 InetAddress가 담겨있음 
			socket.receive(packet);
			
			//클라이언트가 보내온 데이터를 출력해봄
			String msg = new String(data);
			System.out.println("수신된 데이터"+msg.trim());
			
			//패킷안에 담긴 보내온 측의 InetAddress를 확인해봄
			InetAddress addr = packet.getAddress();
			System.out.println("보내온 측의 주소"+addr);
			
			//그 패킷을 그대로 메아리함
			socket.send(packet);
			
			//다음 데이터를 수신하도록 배열을 깨끗히 지워줌
			Arrays.fill(data, (byte)0);
			
		}
			
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	

	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
