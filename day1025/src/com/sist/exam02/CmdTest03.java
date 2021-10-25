package com.sist.exam02;
//import java.util.Scanner;
import java.util.HashMap;
import java.io.FileReader;
import java.util.Properties;
import java.util.Set;
import java.util.Iterator; //꼭

class CmdTest03
{
	

	public static void main(String[] args) throws Exception
	{
		//사용자가 요청하는 서비스명을 key로 하고 일처리담당 객체를 value로 담기 위한 map을 생성 
		HashMap<String, SistAction>map = new HashMap<String, SistAction>();
		//서비스명과 일처리담당 클래스명이 있는 파일객체를 생성함
		FileReader fr = new FileReader("sist.properties");
		//파일의 내용을 key와 value로 관리하기 위한 객체를 생성함
		Properties prop = new Properties();
		//파일의 내용을 읽어들임
		prop.load(fr);
		//프로퍼티 파일로 부터 key목록(서비스명)을 반복자 객체로 생성함 
		Iterator iter = prop.keySet().iterator();
		//key가 있는 만큼 반복 실행함
		while(iter.hasNext()){
			//key를 하나씩 끄집어내어옴(서비스명)
			String cmd = (String) iter.next();
			//key에 해당하는 value를 끄집어내어옴(value = 일처리 담당하는 클래스이름)
			String clsName = (String)prop.get(cmd);
			//System.out.println(cmd+","+clsName);
			//문자열로 되어 있는 클래스이름에 해당하는 객체를 생성함
			SistAction obj = (SistAction) Class.forName(clsName).newInstance();
			//사용자가 요청할 서비스명과 일처리 담당을 하는 객체를 key와 value로 하여 map에 등록함
			map.put(cmd,obj);
		}



//		Set keyList = prop.keySet();
//		System.out.println(keyList);
		//map.put("insert.do",new InsertBoard());
		//map.put("list.do",new ListBoard());
		//map.put("update.do",new UpdateBoard());
		//map.put("delete.do",new DeleteBoard());
		
		//매번 새로운 서비스가 추가될때마다 코드를 변경해야 하는데 별도의 설정파일을 만들어 코드의 변경없이
		//새로운 서비스를 등록하도록 해 봄..

		//프로그램 실행시에 전달되는 매개변수를 url변수에 저장함
		String url = args[0];
		//url로부터 서비스명을 잘라 변수에 저장함
		String cmd = url.substring(url.lastIndexOf("/")+1);
		//map으로 부터 서비스명에 해당하는 일처리 담당객체를 뽑아옴
		SistAction action = map.get(cmd);
		//일처리를 위한 메소드를 호출함
		action.pro();

//sist.properties에는 공백이 있으면 절대 안됌!
		
	}
}
