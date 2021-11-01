package com.sist.echo01;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class TCPChatServer {

	public static void main(String[] args) {
		//Ŭ���̾�Ʈ�� ���� ���ŵ� �����͸� ��� ���� byte�� �迭�� ����
		byte []data = new byte[100];
		
		try {
			//1.serverSocket�� ���� ������ ������
			ServerSocket server = new ServerSocket(9003);
			
			while(true) { //���Ѵ�� ���·� Ŭ���̾�Ʈ�� ������ ��ٸ� 
				//Ŭ���̾�Ʈ�� ��û�� ������
				Socket socket = server.accept();
				//���ϰ�ü�� ���ؼ� �����͸� �ְ���� ��Ʈ���� ����
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();
				
				//������ �� Ŭ���̾�Ʈ�� ����Ͽ� �����͸� �ְ� �ޱ� ���Ͽ� �ݺ����� �̿�
				while(true) {
					//Ŭ���̾�Ʈ�� ���� �����͸� ������
					//socket ���ú�
					String msg = new String(data);
					System.out.println("���ŵ� ������"+ msg.trim());
					
					//Ŭ���̾�Ʈ�� ���� ���ŵ� �����͸� �״�� �޾Ƹ���
					os.write(data);
					
					//������ ���ŵ� �����͸� ���Ͽ� �迭�� ������ �����
					Arrays.fill(data, (byte)0);
				}
			
			}
			
			
		}catch(Exception e) {
			System.out.println("���ܹ߻�"+e.getMessage());
		}
	}

}
