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
			
			if(n.equals("����")) {
				try {
				
				System.out.println("�����մϴ�");
				
				int re = jfc.showSaveDialog(this);
				System.out.println(re);
				
				if(re == 0) {
				File file = jfc.getSelectedFile();
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
				oos.writeObject(file);
				oos.close();
				}
				}catch(Exception ex) {
					System.out.println("����ó��"+ex.getMessage());
				}			
			}else if(n.equals("����")) {
				try {
					System.out.println("������ ���ϴ�");
					int re = jfc.showOpenDialog(this);
					System.out.println(re);
					if(re == 0) {
					File file = jfc.getSelectedFile();
					ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
					ois.readObject();
					ois.close();
					}
				}catch(Exception ex) {
					System.out.println("���ܹ߻�:"+ex.getMessage());
				}
			}
		
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
	}

	
	

	
	
	
	

