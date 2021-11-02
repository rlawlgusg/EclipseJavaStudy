package com.sist.chat;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

//������ �ѹ��� �������� Ŭ���̾�Ʈ�� ��ȭ�� �����ϵ���(�޾Ƹ�) �ϱ� ���Ͽ� Ŭ���̾�Ʈ��
//����Ͽ� ��ȭ�� �ְ�޴� ����� ������� ������

class ServerThread extends Thread{
	
	//��û�� Ŭ���̾�Ʈ�� ����� ������ ��������� ����
	Socket socket;
	
	//����� Ŭ���̾�Ʈ�� �����͸� �ְ���� ��Ʈ���� ����
	InputStream is;
	OutputStream os;

	//������ �����Ͱ� ��� �迭�� ����
	byte []data = new byte[100];
	
	//��ü������ Ŭ���̾�Ʈ�� ����� ������ �Ű������� �޾� ��������� ���
	//��Ʈ���� ������
	public ServerThread(Socket socket) {
		this.socket = socket;
		try {
			is = this.socket.getInputStream();
			os = this.socket.getOutputStream();
			
		}catch(Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}	
	}
	
	public void run() {
		while(true) {
			try {
			//Ŭ���̾�Ʈ�� ���� �����͸� ������
			is.read(data);
			String msg = new String(data);
			System.out.println("���ŵ� ������"+ msg.trim());
			
			//Ŭ���̾�Ʈ�� ���� ���ŵ� �����͸� �״�� �޾Ƹ���
			//os.write(data);
			
			//������ ��� Ŭ���̾�Ʈ�鿡�� �����͸� ����ϰ� ���� 
			sendAll(data);
			
			//������ ���ŵ� �����͸� ���Ͽ� �迭�� ������ �����
			Arrays.fill(data, (byte)0);
			}catch(Exception e) {
				System.out.println("���ܹ߻�:"+e.getMessage());
			}//end catch
		}//end while		
	}//end run

	public void sendAll(byte[] data) throws Exception {
	//��� Ŭ���̾�Ʈ�� ��Ƶ� list�� ���� �����͸� �ϳ��� ������ ���� ���� �װ��� ServerThread�ڷ�����
		for(ServerThread t:ChatServer.list ) {
			//������ ServerThread���� ������ Ŭ���̾�Ʈ���� ������ ����� ���� ��Ʈ���� ����
			//�� ��Ʈ���� ���Ͽ� �����͸� ����� 
			t.os.write(data);
		}
	}
	
}//end class
public class ChatServer {
	
	//��û�� Ŭ���̾�Ʈ���� ��� ��Ƶα� ���� ArrayList�� ����
	//ArrayList�� ��� �ڷ���� ����� ��û�� �Ѹ��� Ŭ���̾�Ʈ�� ����Ͽ� ��ȭ�� �ְ� �޴� ���� ����ϴ� �������� ���������带 ����
	public static ArrayList<ServerThread> list = new ArrayList<ServerThread>();
	
	
	public static void main(String[] args) {
		//Ŭ���̾�Ʈ�� ���� ���ŵ� �����͸� ��� ���� byte�� �迭�� ����
		byte []data = new byte[100];
		
		try {
			//1.serverSocket�� ���� ������ ������
			ServerSocket server = new ServerSocket(9003);
			
			while(true) { //���Ѵ�� ���·� Ŭ���̾�Ʈ�� ������ ��ٸ� 
				//Ŭ���̾�Ʈ�� ��û�� ������
				Socket socket = server.accept();
				
				//����� Ŭ���̾�Ʈ�� ��ȭ�� ��� �ְ�ޱ� ���� ������ ��ü�� �����ϰ� 
				//�����带 ������ 
				ServerThread thread = new ServerThread(socket);
				thread.start();
				//������ ��� Ŭ���̾�Ʈ�� ����� ����ϴ� ��ü�� ��Ƶα� ���� ����Ʈ�� ����
				list.add(thread);
			
			}
			
			
		}catch(Exception e) {
			System.out.println("���ܹ߻�"+e.getMessage());
		}
	}

}
