package com.sist.draw;

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
import java.awt.Color;
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
		jcc = new JColorChooser();
		
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
		
		JMenuItem color_red = new JMenuItem("����");
		JMenuItem color_blue = new JMenuItem("�Ķ�");
		JMenuItem color_green = new JMenuItem("�ʷ�");
		JMenuItem color_other = new JMenuItem("�ٸ�����");
		
	
		mn_file.add(file_new);
		mn_file.add(file_open);
		mn_file.add(file_save);
		
		mn_draw.add(draw_line);
		mn_draw.add(draw_rect);
		mn_draw.add(draw_circle);
	
		mn_color.add(color_red);
		mn_color.add(color_blue);
		mn_color.add(color_green);
		mn_color.add(color_other);
		
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
		
		color_red.addActionListener(this);
		color_blue.addActionListener(this);
		color_green.addActionListener(this);
		color_other.addActionListener(this);
		
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
				//����ڰ� �׸� �׷����� ����ִ� ����Ʈ�� ��� ����
				lp.list.clear();
				//�׷����� �׸��� �ǳ��� �ٽ� �׸� 
				lp.repaint();
						
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
			lp.drawColor = Color.RED;
		}else if(cmd.equals("�Ķ�")) {
			lp.drawColor = Color.BLUE;
		}else if(cmd.equals("�ʷ�")) {
			lp.drawColor = Color.GREEN;
		}else if(cmd.equals("�ٸ�����")) {
			//�ٸ������� �����ϵ��� JColorChooser ���̾�α׸� ���
			Color color = jcc.showDialog(this, "����", Color.RED);
			if(color != null) {
				lp.drawColor = color;
			}
		
		}
		
		
		
	}
	
}

