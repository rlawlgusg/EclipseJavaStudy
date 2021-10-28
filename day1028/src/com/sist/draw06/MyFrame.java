package com.sist.draw06;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

//MyFrameŬ���� �ڽ��� JMenuItem�� ������ ���� �̺�Ʈó�� ����ڰ� �ǵ��� �ϱ� ���Ͽ�
//ActionListener�������̽��� �����ϵ��� ��
public class MyFrame extends JFrame implements ActionListener {
	private LinePanel lp;

	//������ ���ϸ�� ����� ���ϸ��� ������ �� �ֵ��� �ϴ� JFileChooser�� ��������� ������
	JFileChooser jfc;
	JColorChooser jcc;
	
	public MyFrame() {
		lp = new LinePanel();
		add(lp);
		
		//JFileChooser ��ü�� ������
		jfc = new JFileChooser("c:/myData");
		
		
		JMenuBar jmb = new JMenuBar();
		
		JMenu mn_file = new JMenu("����");
		JMenu mn_draw = new JMenu("�׸��� ����");
		JMenu mn_color = new JMenu("���� ����");
		
		JMenuItem file_new = new JMenuItem("������");
		JMenuItem file_open = new JMenuItem("����");
		JMenuItem file_save = new JMenuItem("����");
		
		JMenuItem draw_line = new JMenuItem("��");
		JMenuItem draw_rect = new JMenuItem("�簢��");
		JMenuItem draw_circle = new JMenuItem("��");
		
		JMenuItem color = new JMenuItem("����");
		
	
		mn_file.add(file_new);
		mn_file.add(file_open);
		mn_file.add(file_save);
		
		mn_draw.add(draw_line);
		mn_draw.add(draw_rect);
		mn_draw.add(draw_circle);
	
		mn_color.add(color);
		
		jmb.add(mn_file);
		jmb.add(mn_draw);
		jmb.add(mn_color);
		
		this.setJMenuBar(jmb);
	
		file_new.addActionListener(this);
		file_open.addActionListener(this);
		file_save.addActionListener(this);
	
		draw_line.addActionListener(this);
		draw_rect.addActionListener(this);
		draw_circle.addActionListener(this);
		
		color.addActionListener(this);
		
		setSize(600,400);
		setVisible(true);
		setTitle("�׸���");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		if(cmd.equals("����")) {
			try {
				System.out.println("�����մϴ�");
				int re = jfc.showSaveDialog(this);
				System.out.println(re);
				if(re == 0) {
				File file = jfc.getSelectedFile();
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
				oos.writeObject(lp.list);
				oos.close();
				}
			}catch(Exception ex) {
				System.out.println("���ܹ߻�:"+ex.getMessage());
			}
		}else if(cmd.equals("����")) {
			try {
				System.out.println("������ ���ϴ�");
				int re = jfc.showOpenDialog(this);
				System.out.println(re);
				if(re == 0) {
				File file = jfc.getSelectedFile();
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
				lp.list = (ArrayList<Graphicinfo>)ois.readObject();
				lp.repaint();
				ois.close();
				}
			}catch(Exception ex) {
				System.out.println("���ܹ߻�:"+ex.getMessage());
			}
		}else if(cmd.equals("������")) {
			try {
				//?????????????????
				File file = new File("c:/myData/�������.pan");
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
				//��ü�� ����� 
	
				oos.writeObject(lp.list);
				
				lp.repaint();

				oos.close();
		
				
			//	FileWriter fileWriter = new FileWriter("c:/myData/�������.txt",false);
			//	fileWriter.write(lp.repaint(null));
			//	fileWriter.close();
				
				
			}catch(Exception ex) {
				System.out.println("���ܹ߻�:"+ex.getMessage());
			}
		}else if(cmd.equals("��")) {
			lp.drawType = 0;
		}else if(cmd.equals("�簢��")) {
			lp.drawType = 1;
		}else if(cmd.equals("��")) {
			lp.drawType = 2;
		
		}else if(cmd.equals("����")) {
			jcc = new JColorChooser(); //�÷� ���̾�α׻���
			jcc.showDialog(this,"����", jcc.getColor());
			
			jcc.setColor(getForeground());
			
		}
		
		
		
	}
	
}

