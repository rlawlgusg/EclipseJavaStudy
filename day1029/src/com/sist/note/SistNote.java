package com.sist.note;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.util.ArrayList;

//�θ޴� ������,����,������ ������ �� �̺�Ʈó���� ���Ͽ� ActionListener�������̽��� �����ϵ��� ��!
public class SistNote extends JFrame implements ActionListener{
	String filename = "���� ����";
	//�޸����� �Է� �� ����� ���Ͽ� �������� ������ �Է��� �� �ִ� JTextArea�� ��������� ����
	JTextArea jta;
	
	//������ �����̸��� ����� �����̸��� �����ϱ� ���� JFileChooser�� ��������� ����
	JFileChooser jfc;
	//�����ڿ��� JTextArea��ü�� �����Ͽ� �����ӿ� ���� 
	public SistNote() {
		jta = new JTextArea();
		
		//JFileChooser ��ü�� ����
		jfc = new JFileChooser("c:/myData");
		
		//this.add(jta);
		//�ؽ�Ʈ���� �ٷ� �����ӿ� ������
		//ȭ���� ��� ���ڵ��� �Ⱥ���!
		//�׷��� �ؽ�Ʈ������ �ٷ� �����ӿ� ���� �ʰ� 
		//��ũ���� �ڵ����� ����� �ִ� JScrollPane���� ���μ� �����ӿ� ��ƾ���
		
		JScrollPane jsp = new JScrollPane(jta);
		this.add(jsp);
		
		JMenuBar jmb = new JMenuBar();
		JMenu file = new JMenu("����");
		JMenuItem file_new = new JMenuItem("������");
		JMenuItem file_open = new JMenuItem("����");
		JMenuItem file_save = new JMenuItem("����");
		
		file.add(file_new);
		file.add(file_open);
		file.add(file_save);
		
		jmb.add(file);
		this.setJMenuBar(jmb);
	
		//�θ޴�,������,����,���忡 ���Ͽ� �޴��� �������� � ���� �ϵ��� �̺�Ʈ�� ���
		//�Ű����� �̺�Ʈó����簴ü�� �����ؾ��ϴµ� �� Ŭ����(SistNote) �ڽ��� ó���ϵ��� �ϱ����Ͽ�
		//this�� ������
		file_new.addActionListener(this);
		file_open.addActionListener(this);
		file_save.addActionListener(this);
		
		//�������� ũ�⸦ �����ϰ�, �������� �����ֵ��� ������
		setSize(800,600);
		setVisible(true);
		setTitle(filename);
		/*
		jta.setText("�ȳ��ϼ���");
		try {
			Thread.sleep(3000);
		}catch(Exception e) {
			
		}
		jta.setText("");
		*/
	}
	//file_new, file_open, file_save� ���� ������ addActionListener�� �߱⶧����
	//actionPerformed�� ���Եȴ�
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//�޴��߿� ���� ���������� �ľ��ϱ� ���Ͽ�
		//ActionEvent�� getActionCommand�޼ҵ带 �̿��Ͽ�
		//������ �޴��� ���ڸ� ������
		String cmd = e.getActionCommand();
		if(cmd.equals("������")) {
			jta.setText("");
			setTitle("���� ����");
		}else if(cmd.equals("����")) {
			try {
				//���� �޴��� ������ ��� �ִ� ������� ������� �����ϱ� ����
				//���̾�α׸� ��� 
			int re = jfc.showOpenDialog(this);
			//���̾�α׿��� ��Ҹ� ������ �ʰ� ���⸦ ������ ���� ������ ������ �о����
			//ó���� �ϵ��� ��
			if(re == 0) {
			//���̾�α׿��� ������ ���������� ������
			File file = jfc.getSelectedFile();
			//�� ������ ������ ��ǻ�͸޸𸮷� �о���̱� ���� ��Ʈ���� ���� 
			FileReader fr = new FileReader(file); 
			//������ ��� ������ ��� ���� ���ڿ� ������ ���� 
			//���Ϸ� ���� �ѱ��ھ� �о�ͼ� �����ϱ� ���Ͽ� ""���� �ʱ�ȭ����
			String data ="";
			//���Ϸ� ���� �ѱ��ھ� �б� ���� ������ ����
			int ch;
			//�ݺ����� �̿��Ͽ� ������ ���� �ƴҵ��� �ѱ��ھ� �о����
			while(true) {
				//���Ϸκ��� �ѱ��ھ� �о���� 
				//���ڿ� �ش��ϴ� �������� ��ȯ��
				//���� ���̻� �о���� ������ ���� ������ ���� �����ϸ� -1�� ��ȯ��
				ch = fr.read();
				//���Ϸκ��� ���̻� �о���� ������ ������ �ݺ����� Ż����
				if(ch == -1) {
					break;
				}
				//������ ���� �ƴ϶�� �о���� ������ ���ڸ� �ٽ� ���ڷ� ��ȯ�Ͽ� 
				//���ڿ� ���� data�� ������
				data = data + (char)ch;
			}
			//������ ������ ��� �о���� �������� while�� Ż��
			//while�� Ż���������� ������ ��� ������ String���� data�� ����� ����
			//data�� ������ �ؽ�Ʈ ����� ������
			jta.setText(data);
			//������ �о�Դٰ� �޼����� �����
			JOptionPane.showMessageDialog(this, "������ �������ϴ�");
			//������ �����̸����� ����ǥ������ ������
			//filename = file.getName();
			//String []arr = filename.split(".");
			//filename = arr[0];
			//split�޼ҵ�� .���� �и��� �� �����
			
			filename = filename.substring(0,filename.indexOf("."));
			setTitle(filename);
			fr.close();
			}
			}catch(Exception ex) {
				System.out.println("���ܹ߻�"+ex.getMessage());
			}
			
		}else if(cmd.equals("����")) {
			//���� �޴��� ������ ��� ������̸��� ������ ������ �����ϵ��� ���̾�α׸� ���
			//�Ű����� this�� �� ���̾�α׸� � ������������ ���������� ������ 
			//���� �� ������ SistNote�� ����� �ǹ̷� ��ü�ڽ��� �ǹ��ϴ� this�� ����
			//showSaveDialog���� ����ڴ� ������ ���� ���� �ְ� ��Ҹ� ���� ���� ����
			//��Ҹ� �����µ� ���������ϴ� ��ɾ ó���ϸ� ���
			//�׷��� �� �޼ҵ�� ������ ������ 0�� ��ȯ�ϰ� ��Ҹ� ������ 1�� ��ȯ
			//�� ��ȯ�ϴ� ���� ������ ��� �� ���� ���� �� ���� ��ó���� �ٸ��� �� �� ����
			int re = jfc.showSaveDialog(this);
			//�����ϱ� ���̾�α׿� ������ �������� ���� ������ ���� ��ɾ���� �����ϵ��� �� 
			if(re == 0) {
				//���̾�α׿��� ������ ������ ������ �о��
				File file = jfc.getSelectedFile();
				//�� ������ ���Ͽ� TextArea�� ������ ������ ����ϱ� ���� Stream�� ����
				//���� ������ ����� ���� Writer�� �ļ��� FileWriter�� �̿�
				//����°� ���õ� ��� �����ڿ� �޼ҵ���� ���ܸ� �����ϰ� ����
				//�� ���ܵ��� RuntimeException�� �ļյ��� �ƴϱ� ������ 
				//����ڰ� �ݵ�� ����ó���� �ؾ��� 
				try {
					FileWriter fw = new FileWriter(file);
					
					//���Ϸ� �ؽ�Ʈ�������� ������ �����
					//�ؽ�Ʈ���� ������ ������ �о�ͼ� ���Ϸ� ����� 
					fw.write(jta.getText());
					filename = file.getName();
					//String []arr = filename.split(".");
					//filename = arr[0];
					//setTitle(filename);	
					//������ ����� �������Ƿ� ������ �ݾ���
					filename = filename.substring(0,filename.indexOf("."));
					setTitle(filename);
			
					fw.close();
					//��������� �˷��� ������ �ֿܼ� ������� ���� ���̾�α׸� ��� 
					JOptionPane.showMessageDialog(this, "���Ϸ� �����Ͽ����ϴ�");
				}catch(Exception ex) {//���ܺ����̸��� �̺�Ʈ�����̸��� �ٸ��� ��������
					System.out.println("���ܹ߻�"+ex.getMessage());
					//���ܰ� �߻��ϸ� ���ܸ޼����� ����Ͽ� 
					//�޼����� �ľ��Ͽ� ������ �ذ��ϵ��� �� 
				}
				
				
				
				
				
				
			}
		}
	}
}
