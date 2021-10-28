package com.sist.note;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JPanel;

import com.sist.draw06.Graphicinfo;

public class Note extends JPanel implements ActionListener{
	Menu menu = new Menu();
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser jfc = new JFileChooser("c:/myData");
		String n = e.getActionCommand();
			
			if(n.equals("저장")) {
				try {
				
				System.out.println("저장합니다");
				
				int re = jfc.showSaveDialog(this);
				System.out.println(re);
				
				if(re == 0) {
				File file = jfc.getSelectedFile();
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
				oos.writeObject(file);
				oos.close();
				}
				}catch(Exception ex) {
					System.out.println("예외처리"+ex.getMessage());
				}			
			}else if(n.equals("열기")) {
				try {
					System.out.println("파일을 엽니다");
					int re = jfc.showOpenDialog(this);
					System.out.println(re);
					if(re == 0) {
					File file = jfc.getSelectedFile();
					ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
					ois.readObject();
					ois.close();
					}
				}catch(Exception ex) {
					System.out.println("예외발생:"+ex.getMessage());
				}
			}
		
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
	}

	
	

	
	
	
	

