package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sist.vo.TheaterVO;
import com.sist.vo.bookvo;

public class theaterDAO {
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private String user = "c##sist";
	private String password = "sist";
	
	//�����̸��� �Ű������� ���޹޾� �ش������ ���ó�¥�� �� ������ ��ȯ�ϴ� �޼ҵ� ����
	public int getTotalByCinemaName(String cinemaName) {
		int total = 0;
		String sql = "select sum(count(*)*"
				+ "	(select ���� from �󿵰� where ����.�����ȣ = �󿵰�.�����ȣ and"
				+ "	����.�󿵰���ȣ = �󿵰�.�󿵰���ȣ)) total"
				+ "	from ����"
				+ "	where to_char(��¥,'yyyy/mm/dd') = to_char(sysdate,'yyyy/mm/dd') and"
				+ "	�����ȣ = (select �����ȣ from ���� where �����̸� = ?)"
				+ "	group by �����ȣ, �󿵰���ȣ"
				+ "	order by �����ȣ, �󿵰���ȣ";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cinemaName);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				total = rs.getInt(1);
			}
		
		}catch(Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch(Exception e) {}
		}	
		return total;
	}
	
	
	
	
	
	//�����̸��� �Ű������� ���޹޾� �� ���忡�� ���ó�¥�� ���ϴ�
	//�󿵰� �������� ArrayList�� ��� ��ȯ�ϴ� �޼ҵ� ���� 
	public ArrayList<TheaterVO> listTheater(String cinemaName){
		ArrayList<TheaterVO> list = new ArrayList<TheaterVO>();
		String sql = "select �󿵰�.�����ȣ, �󿵰�.�󿵰���ȣ, ��ȭ����, ����, �¼���  from �󿵰�, ����"
				+ " where (�󿵰�.�����ȣ, �󿵰�.�󿵰���ȣ) in (select distinct �����ȣ , �󿵰���ȣ"
				+ " from ����"
				+ " where to_char(��¥,'yyyy/mm/dd') = to_char(sysdate,'yyyy/mm/dd')) and"
				+ " �󿵰�.�����ȣ = ����.�����ȣ and"
				+ " �����̸� = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cinemaName);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new TheaterVO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
			}
					
		}catch(Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
				
			}catch(Exception e) {}
		}		
		return list;
	}


}
