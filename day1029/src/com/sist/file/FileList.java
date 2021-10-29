package com.sist.file;

import java.io.File;
import java.io.FileReader;
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
	JList<String> list;
	JTextArea jta;
	String path = "c:/myData";
	public FileList() {
		
		//C:\javaStudy\day1025 이 경로에 있는 모든 파일목록으로 JListㄹ,ㄹ 만듬
		//디렉토리(폴더)도 파일객체로 만듬
		File dir = new File(path);
		
		//디렉토리안에 있는 모든 파일이름과 디렉토리이름의 목록을 배열로 갖고옴 
		String []arr = dir.list();
		
		//배열안의 내용으로 JList를 만듬 
		list = new JList<String>(arr);
		
		//JList에 이벤트를 등록함
		list.addMouseListener(this);
		
		JScrollPane jsp_list = new JScrollPane(list);
		
		jta = new JTextArea();
		JScrollPane jsp_area = new JScrollPane(jta);
		
		//삭제를 위한 버튼 만들기
		JButton btn_delete = new JButton("삭제");
		
		//JList를 담고 있는 jsp_list는 프레임의 왼쪽에 담음
		add(jsp_list,BorderLayout.WEST);
		
		//텍스트에어리어를 담고 있는 jsp_area는 프레임의 가운데에다 담음
		add(jsp_area,BorderLayout.CENTER);
		
		//삭제를 위한 버튼을 프레임의 아래쪽에 담음
		add(btn_delete,BorderLayout.SOUTH);
		
		//버튼에 대하여 이벤트를 등록함
		btn_delete.addActionListener(this);
		
		setSize(800,600);
		setVisible(true);
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		//JList에서 선택한 파일이름을 갖고옴!
		String fileName = list.getSelectedValue();
		System.out.println(fileName);
		try {
			//선택한 파일이름과, 파일이 있는 경로를 합쳐서 File객체 혹은 String으로 만들어
			//파일을 읽기 위한 스트림을 생성함
			FileReader fr = new FileReader(path+"/"+fileName);
			
			//파일의 내용을 모두 읽어와 누적하기 위한 문자열 변수를 만들고 ""으로 초기화함
			String data = "";
			
			//파일로 부터 한글자씩 읽어들이기 위한 변수를 선언함
			int ch;
			
			//반복문을 이용하여 파일의 내용을 모두 읽어 들임
			while(true) {
				//파일로 부터 한글자씩 읽어옴
				ch = fr.read();
				
				//파일의 끝에 도달하면 읽어온 값은 -1임, 그때 반복문을 탈출함
				if(ch == -1) {
					break;
				}
				//파일의 끝이 아니면 읽어온 문자를 data에 누적함
				data = data + (char)ch;
		
			}
			//현재 JList에서 선택한 파일의 내용을 다 읽어들이면 while을 탈출함
			//현재 선택한 파일의 모든 내용은 문자열 변수 data에 저장되어 있음
			//이것을 텍스트에어리어에 출력함 
			jta.setText(data);
			
			//사용한 파일을 닫아줌
			fr.close();
			
		}catch(Exception ex) {
			System.out.println("예외발생:"+ex.getMessage());
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
		//삭제하기 위하여 삭제할 파일의 File객체로 만듬
		
		File file = new File(path+"/"+list.getSelectedValue());
		//그 파일을 삭제함
		file.delete();
		//텍스트에어리어를 깨끗이 비워줌
		jta.setText("");
		
		JOptionPane.showMessageDialog(this, "선택한 파일을 삭제하였습니다");		
		
	}
}
