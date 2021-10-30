package com.sist.note03;

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

public class SistNote extends JFrame implements ActionListener{
	String filename = "���� ����";
	JTextArea jta;
	JFileChooser jfc;
	
	public SistNote() {
		jta = new JTextArea();
		jfc = new JFileChooser("c:/myData");
		
		JScrollPane jsp = new JScrollPane(jta);
		add(jsp);
		
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

		file_new.addActionListener(this);
		file_open.addActionListener(this);
		file_save.addActionListener(this);
		
		setSize(800,600);
		setVisible(true);
		setTitle(filename);
	}
	
	//�ߺ��Ǵϱ� �޼ҵ� �ѹ� ������
		public void save() {
			int re = jfc.showSaveDialog(this);
			File file = jfc.getSelectedFile();//�ڱ��ڽ��� �����ϴ� �ǰ�?
			if(re == 0) {
				try {
					FileWriter fw = new FileWriter(file);
					filename = file.getName();
					fw.write(jta.getText());
					filename = filename.substring(0,filename.indexOf("."));
					setTitle(filename);
					fw.close();
					JOptionPane.showMessageDialog(this, "������ �����Ͽ����ϴ�");
				}catch(Exception ex) {
					System.out.println("���ܹ߻�"+ex.getMessage());
				}
			}
		}
		public void open() {
			try {	
			int re = jfc.showOpenDialog(this);
			if(re == 0) {
			File file = jfc.getSelectedFile();
			FileReader fr = new FileReader(file); 
			filename = file.getName();
			String data ="";
			int ch;
			while(true) {
				ch = fr.read();
				if(ch == -1) {
					break;
				}
				data = data + (char)ch;
			}

			jta.setText(data);
			JOptionPane.showMessageDialog(this, "������ �������ϴ�");
			filename = filename.substring(0,filename.indexOf("."));
			setTitle(filename);
			fr.close();
			}
			}catch(Exception ex) {
				System.out.println("���ܹ߻�"+ex.getMessage());
			}
		}
		
		public void yesorno() {
			//showConfirmDialog() ����ڷκ��� Yes/No ������ �Է¹޴� ���̾�α�
			int rs = JOptionPane.showConfirmDialog(this, "�����Ͻðڽ��ϱ�?", "�����ҰŴ�", JOptionPane.YES_NO_OPTION);
			// ok������ 0��ȯ no������ 1��ȯ��..
			if(rs == JOptionPane.YES_OPTION) {//���� 0��ȯ
				save();
			}else if(rs == JOptionPane.NO_OPTION) {//���� �� 1�� ��ȯ��
				JOptionPane.showMessageDialog(this, "������ �������� �ʽ��ϴ�");
			}else if(rs == JOptionPane.CLOSED_OPTION) {//�׳� ���� ��� �˾������ -1�� ��ȯ
				JOptionPane.showMessageDialog(this, "�������α׷��� �����Ͽ����ϴ�");
			}
		}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if(cmd.equals("������")) {
			yesorno();
			jta.setText("");
			setTitle("���� ����");
			
			
		}else if(cmd.equals("����")) {
			yesorno();
			open();
			
		}else if(cmd.equals("����")) {
			save();
			}
		}
	}



