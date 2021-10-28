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
		
		JMenu file = new JMenu("파일");
		JMenu edit = new JMenu("편집");
		JMenu order = new JMenu("서식");
		JMenu see = new JMenu("보기");
		JMenu help = new JMenu("도움말");
		
		JMenuItem file_make = new JMenuItem("새로만들기");
		JMenuItem file_new = new JMenuItem("새창");
		JMenuItem file_open = new JMenuItem("열기");
		JMenuItem file_store = new JMenuItem("저장");
		JMenuItem edit_copy = new JMenuItem("복사");
		JMenuItem edit_paste = new JMenuItem("붙여넣기");
		JMenuItem order_font = new JMenuItem("글꼴");
		JMenuItem see_zoominout = new JMenuItem("확대/축소");
		JMenuItem help_help = new JMenuItem("도움말");
		
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
		
		
		JTextArea jTextArea = new JTextArea("메모",500,500);
		add(new JLabel("아무거나 써보세요"));
		add(new JScrollPane(jTextArea));
		
		setSize(700,700);
		setVisible(true);
		setTitle("이것은 메모장이다");
		
	}	
	
	
	
	
	
}
