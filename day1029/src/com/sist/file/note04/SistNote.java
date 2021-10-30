package com.sist.file.note04;

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
	String filename = "제목 없음";
	JTextArea jta;
	JFileChooser jfc;
	
	public SistNote() {
		jta = new JTextArea();
		jfc = new JFileChooser("c:/myData");
		
		JScrollPane jsp = new JScrollPane(jta);
		add(jsp);
		
		JMenuBar jmb = new JMenuBar();
		JMenu file = new JMenu("파일");
		JMenuItem file_new = new JMenuItem("새파일");
		JMenuItem file_open = new JMenuItem("열기");
		JMenuItem file_save = new JMenuItem("저장");
		JMenuItem file_save_as = new JMenuItem("다른이름으로 저장");
		file.add(file_new);
		file.add(file_open);
		file.add(file_save);
		file.add(file_save_as);
		jmb.add(file);
		this.setJMenuBar(jmb);

		file_new.addActionListener(this);
		file_open.addActionListener(this);
		file_save.addActionListener(this);
		file_save_as.addActionListener(this);
		
		setSize(800,600);
		setVisible(true);
		setTitle(filename);
	}
	
	//중복되니까 메소드 한번 만들어보자
		public void save_as() {
			int re = jfc.showSaveDialog(this);
			File file = jfc.getSelectedFile();//자기자신을 선택하는 건가?
			if(re == 0) {
				try {
					FileWriter fw = new FileWriter(file);
					filename = file.getName();
					fw.write(jta.getText());
					filename = filename.substring(0,filename.indexOf("."));
					setTitle(filename);
					fw.close();
					JOptionPane.showMessageDialog(this, "파일을 저장하였습니다");
				}catch(Exception ex) {
					System.out.println("예외발생"+ex.getMessage());
				}
			}
		}
		public void open() {
			try {	
			int re = jfc.showOpenDialog(this);
			File file = jfc.getSelectedFile();
			if(re == 0) {
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
			JOptionPane.showMessageDialog(this, "파일을 열었습니다");
			filename = filename.substring(0,filename.indexOf("."));
			setTitle(filename);
			fr.close();
			}
			}catch(Exception ex) {
				System.out.println("예외발생"+ex.getMessage());
			}
		}
		
		public void yesorno() {
			//showConfirmDialog() 사용자로부터 Yes/No 응답을 입력받는 다이얼로그
			int rs = JOptionPane.showConfirmDialog(this, "파일을 저장하시겠습니까?", "저장할거니", JOptionPane.YES_NO_OPTION);
			// ok누르면 0반환 no누르면 1반환함..
			if(rs == JOptionPane.YES_OPTION) {//저장 0반환
				save_as();
			}else if(rs == JOptionPane.NO_OPTION) {//저장 ㄴ 1을 반환함
				JOptionPane.showMessageDialog(this, "파일을 저장하지 않습니다");
			}else if(rs == JOptionPane.CLOSED_OPTION) {//그냥 닫은 경우 팝업종료는 -1을 반환
				JOptionPane.showMessageDialog(this, "저장프로그램을 종료하였습니다");
			}
		}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if(cmd.equals("새파일")) {
			yesorno();
			jta.setText("");
			setTitle("제목 없음");
		}else if(cmd.equals("열기")) {
			yesorno();
			open();
		}else if(cmd.equals("저장")) {
			try {
			File file = jfc.getSelectedFile();
			FileWriter fw = new FileWriter(file);
			fw.write(jta.getText());
			JOptionPane.showMessageDialog(this, "파일을 저장하였습니다");
			fw.close();
			}catch(Exception ex) {
				System.out.println("예외발생:"+ex.getMessage());
			}
		}else if(cmd.equals("다른이름으로 저장")) {
			save_as();
			}
		}
	}



