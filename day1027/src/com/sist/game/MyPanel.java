package com.sist.game;

import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.event.*;
//적, 미사일, 우주선을 동시에(한꺼번에) 담을 수 있는 패널 클래스를 만듬 
//패널에 키보드가 눌러지는 이벤트를 처리하기 위하여 keyListener도 구현 
import java.util.ArrayList;
class MyPanel extends JPanel implements KeyListener {
	//적,미사일,우주선을 패널의 변수로 선언함 
	//Enermy enermy;
	
	//여러개의 적을 만들기 위하여 ArrayList를 만듬
	ArrayList<Enermy> enermyList;
	
	SpaceShip spaceship;
	Missile missile;
	//생성자에 즉, 패널이 생성되고 동시에 동작하여
	public MyPanel() {
		super();
		this.addKeyListener(this); //패널의 키보드 이벤트를 등록함
		this.requestFocus(); //패널의 키보드 요청을 설정함 A
		setFocusable(true);  //패널에 포커스를 설정 B
		
		enermyList = new ArrayList<Enermy>();
	
		enermyList.add(new Enermy("enermy.png"));
		enermyList.add(new Enermy("enermy.png"));
		enermyList.add(new Enermy("enermy.png"));
		enermyList.add(new Enermy("enermy.png"));
		enermyList.add(new Enermy("enermy.png"));
		

		spaceship = new SpaceShip("spaceship.png");//이미지파일명을 갖고 우주선 객체를 생성
		missile = new Missile("missile.png");//이미지파일명을 갖고 미사일 객체를 생성
		
	
		class MyThread extends Thread{  
			public void run(){	
				while(true) {	  
					missile.update();
					
					for(Enermy enermy : enermyList) {
						enermy.update();
						enermy.crush(missile);
					}

					repaint();
					
					try {Thread.sleep(50);}
					catch(InterruptedException e) {}
				}
			}
		}
		
		Thread t = new MyThread();
		//쓰레드를 가동 
		t.start();
	}
	
	public void paint(Graphics g) {  
		super.paint(g); 
		//여러개의 적이 담겨있는 리스트의 수만큼 반복하여 적을 다시 그려줌
		for(Enermy enermy : enermyList) {
			enermy.draw(g);
		}
		spaceship.draw(g);
		missile.draw(g);
	}	
	
	public void keyPressed(KeyEvent event) {
		spaceship.KeyPressed(event);  //눌러진 키보드이벤트의 정보를 우주선에게 전달함
		missile.KeyPressed(event, spaceship.x, spaceship.y);	
	}

	public void keyTyped(KeyEvent arg0) {}

	public void keyReleased(KeyEvent arg0) {}
}	
	