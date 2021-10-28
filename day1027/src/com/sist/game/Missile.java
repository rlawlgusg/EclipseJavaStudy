package com.sist.game;

import java.awt.event.KeyEvent;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Missile extends GraphicObject {
	
	//미사일이 발사 되었는지 판별하기 위한 변수
	boolean launched = false;
	
	//생성시에 이미지파일이름을 매개변수로 전달받아 
	public Missile(String name) {
		//부모의 생성자에게 전달함
		super(name);
		y = -200;
		// TODO Auto-generated constructor stub
	}
	
	public void update() {
		//만약에 미사일이 발사 되었다면 y좌표를 1씩 감소함
		if(launched) {
			y -= 10;
		}
		//미사일의 y좌표가 화면의 눈에 안보이는 영역이면 launched에 false를 설정
		if(y < -100) {
			launched = false;
		}
	}
	
	//키보드가 눌러지면 현재 우주선이 있는 위치 x,y 좌표에서 부터 출발하여
	//미사일을 발사시키기 위하여 KeyPressed메소드를 오버라이딩 함
	//여기 매개변수로 전달받는 keyevent event를 통해서 어떤 key가 눌러졌는지 알 수 있음
	//또 매개변수 x,y는 우주선의 x,y위치를 전달받음
	public void KeyPressed(KeyEvent event,int x,int y) {
		
		if(event.getKeyCode() == KeyEvent.VK_SPACE) {
			
			launched = true; //미사일을 발사시키기 위하여 launched에 true를 설정
			//미사일의 x,y좌표를 우주선의 x,y로 설정함 
			this.x = x;
			this.y = y;
			
			//미사일이 발사될때 소리도 나게함
			
			//소리파일 객체 생성
			File file = new File("LASER.WAV");
			try {
				//오디오 파일을 읽어오기 위한 준비
				Clip clip = AudioSystem.getClip();	
				//오디오 파일을 읽어옴
				clip.open(AudioSystem.getAudioInputStream(file));
				//오디오 파일을 재생 
				clip.start();
			}catch(Exception e) {}

			
			
		}
	}
}
