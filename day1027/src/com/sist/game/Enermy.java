package com.sist.game;

import java.io.File;
import java.util.Random;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Enermy extends GraphicObject {
	
	
	
	//적이 x축으로 움직이는 간격을 위한 변수
	//맨처음에는 오른쪽끝에서 왼쪽으로 움직이도록 하기 위하여 음수를 설정
	//int dx = -10;
	//int dy = 10;
	
	//적의 이동경로를 난수로 만듬
	int dx;
	int dy;
	
	//생성시에 적으로 표현할 그래픽 파일이름을 매개변수로 전달받아 부모클래스의 생성자에게 전달함
	public Enermy(String name) {
		super(name);
		
	//맨처음에 프로그램 실행하였을때에 적의 위치를 오른쪽 상단에 위치시키기 위하여
	//x = 500, y = 0 으로 설정함 
	//	x = 500;
	//	y = 0;
		Random r = new Random();
	//맨처음에 적의 위치도 난수로 설정함
		x = r.nextInt(500);
		y = r.nextInt(300);
		
	//적의 이동경로값을 생성시에 난수로 만듬
	//이동하는 최소값:
	//이동하는 최대값:
	//어떤 난수를 만들어서 90으로 나눈 나머지에 10을 더함
		
		dx = r.nextInt() % 90; 
		dy = r.nextInt() % 90; 
		
		//x축으로 끝에 도달했으면 부호를 바꿔줌
		if(x<0 || x>500) {
			dx = dx*-1;
		}
		//y축으로 끝에 도달했으면 부호를 바꿔줌
		if(y<0 || y>=300) {
			dy = dy*-1;
		}
		
		/*
		if(dx>=0) {
			dx += 10;
		}else {
			dx -= 10;
		}
		if(dy>=0) {
			dy += 10;
		}else {
			dy -= 10;
		}
		*/
		
		System.out.println("x"+dx);
		System.out.println("y"+dy);
	}
	

	public void update() {
		//x좌표를 dx만큼 변경시킴
		x += dx;
		y += dy;
		
		//만약 왼쪽끝에 도달하면 오른쪽으로 이동시키기 위하여 dx를 양수로 만듬
		if(x < 0) {
			dx = +10;
		}
		//만약 오른쪽 끝에 도달하면 다시 왼쪽으로 이동시키기 위하여 dx를 음수로 만듬
		if(x > 500) {
			dx = -10;
		}
		
		if(y >= 400) {
			dy = -10;
		}
		
		if(y < 0) {
			dy = +10;
		}
	}
		//적이 미사일에 맞았는지 판별하는 메소드
		
		public void crush(Missile missile){
			//적이 미사일에 맞았는지 판별
			if(missile.x >= x && missile.x <= x+74 && missile.y >= y && missile.y<=y+73){
				System.out.println("적이 맞았어요!");
				File file = new File("EXPLODE.WAV");
				try {
					//오디오 파일을 읽어오기 위한 준비
					Clip clip = AudioSystem.getClip();	
					//오디오 파일을 읽어옴
					clip.open(AudioSystem.getAudioInputStream(file));
					//오디오 파일을 재생 
					clip.start();
				}catch(Exception e) {}
				
				
				
				
				
				
				
				y = -1000;
			}
		
		
		
		}

		
		
	
	
}
