//java UDPSender 192.168.0.42 안녕
//java UDPSender 192.168.0.42 반갑습니다

package com.sist.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSender {
	public static void main(String[] args) {
		
		String ip = args[0];
		String msg = args[1];
		
		//UDP방식에서 데이터를 주고 받기 위해서는 DatagramSocket이 필요함
		
		try {
			DatagramSocket socket = new DatagramSocket(9002);
			//목적지의 주소 ip를 갖고 InetAddress객체를 생성함
			InetAddress addr = InetAddress.getByName(ip);
			//전송하고자하는 문자열 msg를 byte의 배열로 만듬 
			byte[]data = msg.getBytes();
			//UDP방식의 데이터 전송단위 패킷을 생성
			DatagramPacket packet = new DatagramPacket(data, data.length,addr,9002);
			//DatagramSocket의 send메소드를 통해 데이터를 전송함
			socket.send(packet);
			
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
}
