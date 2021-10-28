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

//MyFrame클래스 자신이 JMenuItem을 눌렀을 때에 이벤트처리 담당자가 되도록 하기 위하여
//ActionListener인터페이스를 구현하도록 함
public class MyFrame extends JFrame implements ActionListener {
	private LinePanel lp;

	//저장할 파일명과 열어올 파일명을 선택할 수 있도록 하는 JFileChooser를 멤버변수로 선언함
	JFileChooser jfc;
	JColorChooser jcc;
	
	public MyFrame() {
		lp = new LinePanel();
		add(lp);
		
		//JFileChooser 객체를 생성함
		jfc = new JFileChooser("c:/myData");
		
		
		JMenuBar jmb = new JMenuBar();
		
		JMenu mn_file = new JMenu("파일");
		JMenu mn_draw = new JMenu("그리기 도구");
		JMenu mn_color = new JMenu("색상 선택");
		
		JMenuItem file_new = new JMenuItem("새파일");
		JMenuItem file_open = new JMenuItem("열기");
		JMenuItem file_save = new JMenuItem("저장");
		
		JMenuItem draw_line = new JMenuItem("선");
		JMenuItem draw_rect = new JMenuItem("사각형");
		JMenuItem draw_circle = new JMenuItem("원");
		
		JMenuItem color = new JMenuItem("색상");
		
	
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
		setTitle("그림판");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		if(cmd.equals("저장")) {
			try {
				System.out.println("저장합니다");
				int re = jfc.showSaveDialog(this);
				System.out.println(re);
				if(re == 0) {
				File file = jfc.getSelectedFile();
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
				oos.writeObject(lp.list);
				oos.close();
				}
			}catch(Exception ex) {
				System.out.println("예외발생:"+ex.getMessage());
			}
		}else if(cmd.equals("열기")) {
			try {
				System.out.println("파일을 엽니다");
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
				System.out.println("예외발생:"+ex.getMessage());
			}
		}else if(cmd.equals("새파일")) {
			try {
				//?????????????????
				File file = new File("c:/myData/제목없음.pan");
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
				//객체를 출력함 
	
				oos.writeObject(lp.list);
				
				lp.repaint();

				oos.close();
		
				
			//	FileWriter fileWriter = new FileWriter("c:/myData/제목없음.txt",false);
			//	fileWriter.write(lp.repaint(null));
			//	fileWriter.close();
				
				
			}catch(Exception ex) {
				System.out.println("예외발생:"+ex.getMessage());
			}
		}else if(cmd.equals("선")) {
			lp.drawType = 0;
		}else if(cmd.equals("사각형")) {
			lp.drawType = 1;
		}else if(cmd.equals("원")) {
			lp.drawType = 2;
		
		}else if(cmd.equals("색상")) {
			jcc = new JColorChooser(); //컬러 다이얼로그생성
			jcc.showDialog(this,"색상", jcc.getColor());
			
			jcc.setColor(getForeground());
			
		}
		
		
		
	}
	
}

