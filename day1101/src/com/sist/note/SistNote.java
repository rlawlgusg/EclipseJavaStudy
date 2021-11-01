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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.util.ArrayList;

//�θ޴� ������,����,������ ������ �� �̺�Ʈó���� ���Ͽ� ActionListener�������̽��� �����ϵ��� ��!
public class SistNote extends JFrame implements ActionListener,KeyListener{
	String filename = "���� ����";
	
	//�̹� ���ϸ��� ���� ��� ����� �ʰ� �� ���Ͽ� �����ϵ��� �ϱ� ���Ͽ� File��ü�� ��������� ����
	File file;
	
	//�޸����� �Է� �� ����� ���Ͽ� �������� ������ �Է��� �� �ִ� JTextArea�� ��������� ����
	JTextArea jta;
	
	//������ �����̸��� ����� �����̸��� �����ϱ� ���� JFileChooser�� ��������� ����
	JFileChooser jfc;
	
	//�޸����� ������ ����� ������ �ִ��� ���¸� �����ϱ� ���� ������ ����
	boolean isNew;
	
	//�����ڿ��� JTextArea��ü�� �����Ͽ� �����ӿ� ���� 
	public SistNote() {
		jta = new JTextArea();
		
		//isNew�� �⺻���� false�� ����
		isNew = false;
		
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
	
		//�ؽ�Ʈ���� Ű�̺�Ʈ�� �����
		jta.addKeyListener(this);
		
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
			if(isNew = true) {
			int re = JOptionPane.showConfirmDialog(this,"�����Ͻðڽ��ϱ�?");
			System.out.println(re);
			switch(re) {
			case 0 : saveFile();
			case 1 : jta.setText("");
					filename = "���� ����";
					setTitle("filename"); 
					isNew = false;
					file = null;
					break;
			case 2 : return;
			}
			}else {
				jta.setText("");
				filename = "���� ����";
				setTitle("filename"); 
				isNew = false;
				file = null;
			}
			
			
		}else if(cmd.equals("����")) {
			try {
				//���� �޴��� ������ ��� �ִ� ������� ������� �����ϱ� ����
				//���̾�α׸� ��� 
			int re = jfc.showOpenDialog(this);
			//���̾�α׿��� ��Ҹ� ������ �ʰ� ���⸦ ������ ���� ������ ������ �о����
			//ó���� �ϵ��� ��
			if(re == 0) {
			//���̾�α׿��� ������ ���������� ������
			//����� ������ ������� ���Ͽ� ����!
			file = jfc.getSelectedFile();
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
			isNew = false;
		
		}else if(cmd.equals("����")) {
			saveFile();
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		isNew = true;
	}
	public void saveFile() {
		//���� �޴��� ������ ��� ������̸��� ������ ������ �����ϵ��� ���̾�α׸� ���
		//�Ű����� this�� �� ���̾�α׸� � ������������ ���������� ������ 
		//���� �� ������ SistNote�� ����� �ǹ̷� ��ü�ڽ��� �ǹ��ϴ� this�� ����
		//showSaveDialog���� ����ڴ� ������ ���� ���� �ְ� ��Ҹ� ���� ���� ����
		//��Ҹ� �����µ� ���������ϴ� ��ɾ ó���ϸ� ���
		//�׷��� �� �޼ҵ�� ������ ������ 0�� ��ȯ�ϰ� ��Ҹ� ������ 1�� ��ȯ
		//�� ��ȯ�ϴ� ���� ������ ��� �� ���� ���� �� ���� ��ó���� �ٸ��� �� �� ����
		
		//�̹� ������ ���ٸ� ������ �����ϱ� ���� ���̾�α׸� ���� 
		//�̹� ������ �ִٸ� �� �̸����� �����ϵ��� ��
		int re = 0;
		//�̹� �����̸��� �ִ� ���¿��� File�� null�� �ƴ� ���¿��� ������ ������ ������ �����ؾ���
		//�׷��� ���� �� ó�� ������ �����ϸ� File�� null���¿��� ������ ������
		//������ �����ϴ� ���̾�α׿��� ��Ҹ� ������ �ʰ� ������ ���������� �����ϵ��� ó���ؾ���
		//�̰��� ���ÿ� ó���ϱ� ���Ͽ� re�� �⺻�� 0�� ����
		//�׷��� �̹� ������ ������ ������ if�� ������ �ʾƼ� re�� �״�� 0�� ����
		//���� ������ ���� ���¸� ������ if�� ������ 
		//����� ���̾�α׿��� ��Ҹ� ������ re=1�� �Ǹ�
		//�ڿ� ����ó���� ����
		if(file == null) {
		re = jfc.showSaveDialog(this);
		if(re == 0 ) {
			File file = jfc.getSelectedFile();
		}
		}
		
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
				isNew = false;
			}catch(Exception ex) {//���ܺ����̸��� �̺�Ʈ�����̸��� �ٸ��� ��������
				System.out.println("���ܹ߻�"+ex.getMessage());
				//���ܰ� �߻��ϸ� ���ܸ޼����� ����Ͽ� 
				//�޼����� �ľ��Ͽ� ������ �ذ��ϵ��� �� 
			}
			
		
		}
	}
	
}
