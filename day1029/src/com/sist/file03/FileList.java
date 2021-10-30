package com.sist.file03;

import java.io.File;
import java.io.FileReader;
import java.util.Vector;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.FileChooserUI;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionListener;

public class FileList extends JFrame implements MouseListener,ActionListener{
	JList<Vector<String>> list;
	JTextArea jta;
	String path = "c:/myData";
	
	//JList�� �����͸� ���� ���͸� ������
	Vector vector;
	
	public FileList() {
		
		//���͸� ������
		vector = new Vector<String>();
		
		//C:\javaStudy\day1025 �� ��ο� �ִ� ��� ���ϸ������ JList��,�� ����
		//���丮(����)�� ���ϰ�ü�� ����
		File dir = new File(path);
		
		//���丮�ȿ� �ִ� ��� �����̸��� ���丮�̸��� ����� �迭�� ������ 
		String []arr = dir.list();
		
		//���丮�� ���ϸ���� ���Ϳ� ����
		for(String str : arr) {
			vector.add(str);
		}
		
		//������ �������� JList�� ���� 
		list = new JList<Vector<String>>(vector);
		
		//JList�� �̺�Ʈ�� �����
		list.addMouseListener(this);
		
		JScrollPane jsp_list = new JScrollPane(list);
		
		jta = new JTextArea();
		JScrollPane jsp_area = new JScrollPane(jta);
		
		//������ ���� ��ư �����
		JButton btn_delete = new JButton("����");
		
		//JList�� ��� �ִ� jsp_list�� �������� ���ʿ� ����
		add(jsp_list,BorderLayout.WEST);
		
		//�ؽ�Ʈ���� ��� �ִ� jsp_area�� �������� ������� ����
		add(jsp_area,BorderLayout.CENTER);
		
		//������ ���� ��ư�� �������� �Ʒ��ʿ� ����
		add(btn_delete,BorderLayout.SOUTH);
		
		//��ư�� ���Ͽ� �̺�Ʈ�� �����
		btn_delete.addActionListener(this);
		
		setSize(800,600);
		setVisible(true);
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		//JList���� ������ �����̸��� ������!
		int idx = list.getSelectedIndex();
		String fileName = (String)vector.get(idx);
		
		System.out.println(fileName);
		try {
			//������ �����̸���, ������ �ִ� ��θ� ���ļ� File��ü Ȥ�� String���� �����
			//������ �б� ���� ��Ʈ���� ������
			FileReader fr = new FileReader(path+"/"+fileName);
			
			//������ ������ ��� �о�� �����ϱ� ���� ���ڿ� ������ ����� ""���� �ʱ�ȭ��
			String data = "";
			
			//���Ϸ� ���� �ѱ��ھ� �о���̱� ���� ������ ������
			int ch;
			
			//�ݺ����� �̿��Ͽ� ������ ������ ��� �о� ����
			while(true) {
				//���Ϸ� ���� �ѱ��ھ� �о��
				ch = fr.read();
				
				//������ ���� �����ϸ� �о�� ���� -1��, �׶� �ݺ����� Ż����
				if(ch == -1) {
					break;
				}
				//������ ���� �ƴϸ� �о�� ���ڸ� data�� ������
				data = data + (char)ch;
		
			}
			//���� JList���� ������ ������ ������ �� �о���̸� while�� Ż����
			//���� ������ ������ ��� ������ ���ڿ� ���� data�� ����Ǿ� ����
			//�̰��� �ؽ�Ʈ���� ����� 
			jta.setText(data);
			
			//����� ������ �ݾ���
			fr.close();
			
		}catch(Exception ex) {
			System.out.println("���ܹ߻�:"+ex.getMessage());
		}
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//�����ϱ� ���Ͽ� ������ ������ File��ü�� ����
		
		File file = new File(path+"/"+list.getSelectedValue());
		//�� ������ ������
		file.delete();
		//�ؽ�Ʈ���� ������ �����
		jta.setText("");
		
		//c:/myData ������ ���ϸ�� �ٽ� �о�ͼ� Vector�� ������ �ٲٰ�
		//JList�� �ٽ� �׸����� ��û��
		File dir = new File(path);
		String []arr = dir.list();
		
		//���͸� ������ ����� �ٽ� �о�� ���� ����� �����
		vector.clear();
		for(String f : arr) {
			vector.add(f);
		}
		
		//JList�� ����� �ٲ� ������ �������� �ٽ� �׷��ֵ��� ��û�ؾ� ��
		list.updateUI();
		
		JOptionPane.showMessageDialog(this, "������ ������ �����Ͽ����ϴ�");		
		
	}
}