package com.sist.game;

import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.event.*;
//적, 미사일, 우주선을 동시에(한꺼번에) 담을 수 있는 패널 클래스를 만듬 
//패널에 키보드가 눌러지는 이벤트를 처리하기 위하여 keyListener도 구현 
class MyPanel extends JPanel implements KeyListener {
	//적,미사일,우주선을 패널의 변수로 선언함 
	Enermy enermy;
	SpaceShip spaceship;
	Missile missile;
	//생성자에 즉, 패널이 생성되고 동시에 동작하여
	public MyPanel() {
		super();
		this.addKeyListener(this); //패널의 키보드 이벤트를 등록함
		this.requestFocus(); //패널의 키보드 요청을 설정함 A
		setFocusable(true);  //패널에 포커스를 설정 B
		//패널은 화면구성요소중에 원래 키보드로부터 입력받아 들이는 용도가 아니기 때문에
		//키보드로부터 입력을 받아들이게 하려면 패널에 일단은 포커스를 설정해야함
		
		enermy = new Enermy("enermy.png"); //이미지파일명을 갖고 적 객체를 생성
		spaceship = new SpaceShip("spaceship.png");//이미지파일명을 갖고 우주선 객체를 생성
		missile = new Missile("missile.png");//이미지파일명을 갖고 미사일 객체를 생성
		
		//패널의 구성요소인 적,미사일,우주선이 서로 독립적으로(동시에,공평하게) 움직이도록 하기 위하여
		//멀티쓰레드를 구현 
		//적,미사일,우주선이 동시에(공평하게) 움직이게 하는 기능은 다른 곳에서는 쓸일이 없고
		//여기 이곳 패널에서만 필요함
		//이럴때에 클래스를 클래스안에 만들 수 있음 
		//이것을 inner class라고 함 
		class MyThread extends Thread{  //Thread클래스를 상속받아 멀티쓰레드를 구성
			public void run(){	//run을 오버라이딩하여 동시에 실행시킬 명령어(들)을 써줌
				while(true) {	//계속 반복하여 적,미사일,우주선이 움직이도록 하기위하여 while(true)를 이용
					enermy.update();  //적을 움직이도록 하기 위하여 적의 위치를 변경하는 메소드를 호출 
			//		spaceship.update(); //우주선을 움직이도록 하기 위하여 우주선의 위치를 변경하는 메소드를 호출
					//우주선은 키보드가 눌러진 방향으로 한번 움직이도록 되어 있음 그래서 호출하지 않아도 됌 
					missile.update();	////미사일을 움직이도록 하기 위하여 미사일의 위치를 변경하는 메소드를 호출
					
					//적이 미사일에 맞았는지 판별하여 없애는 메소드를 호출
					enermy.crush(missile);
					
					repaint();	//적,미사일,우주선의 변경된 위치에 다시 그리기 위한 요청을 함
								//화면에 그래픽을 그려주는 메소드는 paint메소드임 
								//사용자가 직접 paint를 호출할 수는 없고 repaint를 호출하여
								//paint를 동작시킬 수 있음 
					try {Thread.sleep(50);}
					catch(InterruptedException e) {}
				}
			}
		}
		//적,미사일,우주선이 서로 독립적으로 움직이도록 만든
		//멀티쓰레드 객체 MyThread를 생성
		Thread t = new MyThread();
		//쓰레드를 가동 
		t.start();
	}
	//적,미사일,우주선의 변경된 위치에 그래픽을 다시 그려줌
	//패널에 그래픽을 표현하기 위해서는 paint를 오버라이딩 해줌
	//매개변수로 전달받은 Graphics에 그래픽을 표현하기 위한 다양한 메소드들이 있음
	public void paint(Graphics g) {  
		super.paint(g); //그래픽을 그리기 위한 그래픽스의 g를 적에게 전달하여 다시 변경된 위치에 그리도록함
		//그래픽을 그리기 위한 그래픽스의 g를 적,우주선,미사일에 전달하여 변경된 위ㅣ에 그리도록 함
		enermy.draw(g); 
		spaceship.draw(g);
		missile.draw(g);
	}	
	//패널에서 키보드가 눌러지면
	public void keyPressed(KeyEvent event) {
		spaceship.KeyPressed(event);  //눌러진 키보드이벤트의 정보를 우주선에게 전달함
		missile.KeyPressed(event, spaceship.x, spaceship.y);	
		//눌러진 키보드이벤트의 정보와 우주선의 위치를 미사일에 전달함
	}

	public void keyTyped(KeyEvent arg0) {}

	public void keyReleased(KeyEvent arg0) {}
}	
	