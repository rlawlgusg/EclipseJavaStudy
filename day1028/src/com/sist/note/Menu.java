package com.sist.note;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Menu extends JFrame {
		
	public Menu() {
		JMenuBar jmb = new JMenuBar();
		
		JMenu file = new JMenu("����");
		JMenu edit = new JMenu("����");
		JMenu order = new JMenu("����");
		JMenu see = new JMenu("����");
		JMenu help = new JMenu("����");
		
		JMenuItem file_make = new JMenuItem("���θ����");
		JMenuItem file_new = new JMenuItem("��â");
		JMenuItem file_open = new JMenuItem("����");
		JMenuItem file_store = new JMenuItem("����");
		JMenuItem edit_copy = new JMenuItem("����");
		JMenuItem edit_paste = new JMenuItem("�ٿ��ֱ�");
		JMenuItem order_font = new JMenuItem("�۲�");
		JMenuItem see_zoominout = new JMenuItem("Ȯ��/���");
		JMenuItem help_help = new JMenuItem("����");
		
		file.add(file_make);
		file.add(file_new);
		file.add(file_open);
		file.add(file_store);
		edit.add(edit_copy);
		edit.add(edit_paste);
		order.add(order_font);
		see.add(see_zoominout);
		help.add(help_help);
		
		jmb.add(file);
		jmb.add(edit);
		jmb.add(order);
		jmb.add(see);
		jmb.add(help);
		
		this.setJMenuBar(jmb);
		
		
		JTextArea jTextArea = new JTextArea("�޸�",500,500);
		add(new JLabel("�ƹ��ų� �Ẹ����"));
		add(new JScrollPane(jTextArea));
		
		setSize(700,700);
		setVisible(true);
		setTitle("�̰��� �޸����̴�");
		
	}	
	
	
	
	
	
}
