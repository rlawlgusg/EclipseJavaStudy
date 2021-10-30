package com.sist.draw;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import java.awt.Color;
public class LinePanel extends JPanel implements MouseListener{
	 int x1 = 0;
	 int y1 = 0;
	 int x2 = 0;
	 int y2 = 0;
	 int drawType; 
	Color drawColor;
	
	//사용자가 그린 선들을 담기 위한 리스트를 선언
	ArrayList<Graphicinfo> list;
	
	
	//생성자에서 마우스 이벤트를 등록
	public LinePanel() {
		
		list = new ArrayList<Graphicinfo>();
		//this의 의미는 마우스이벤트가 발생하였을때 이벤트처리 담당객체가 자신이라는 의미
		addMouseListener(this);
	}
	
	
	
	@Override
	protected void paintComponent(Graphics g) {
		//부모의 paintComponent를 요청하여 화면을 깨끗이 지워줌 
		super.paintComponent(g);
		//System.out.println("다시그려줍니다");
		//g.drawLine(x1,y1,x2,y2);
	
		//리스트에 담긴 모든 선을 그려줌
		for(Graphicinfo info: list) {
			x1 = info.getX1();
			y1 = info.getY1();		
			x2 = info.getX2();
			y2 = info.getY2();		
			int width = x2- x1;
			int height = y2 - y1;
			
			g.setColor(info.getDrawColor());
			
			
			switch(info.getDrawType()) {
			case 0 : g.drawLine(x1,y1,x2,y2); break;
			case 1 : g.drawRect(x1,y1,width,height); break;
			case 2 : g.drawOval(x1,y1,width,height); break;
			
			}
		}
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		x1 = e.getX();
		y1 = e.getY();
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		x2 = e.getX();
		y2 = e.getY();
		//하나의 선이 완성될때에 리스트 선의 시작점x, 시작점y, 끝점x, 끝점y를 갖고있는
		//Graphicinfo객체를 생성하여 리스트에 담음 
		list.add(new Graphicinfo(x1, y1, x2, y2, drawType,drawColor));
		repaint();
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}