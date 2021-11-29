package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sist.db.ConnectionProvider;
import com.sist.vo.PossibleReservationRoomVO;
import com.sist.vo.ReservationVO;

public class ReservationDAO {
	
	//�������̺� ���ڵ带 �߰��ϴ� �޼ҵ� ����
	public int insertReservation(ReservationVO r) {
		int re = -1;
		try {
			String sql = "insert into reservation(reservation_no, checkin, checkout, phone, total, count_guest, customer_no, room_no, eno)"
					+" values(?, ?, ?, ?, 0, ?, ?, ?, 1000)";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, r.getReservation_no());
			pstmt.setString(2, r.getCheckin());
			pstmt.setString(3, r.getCheckout());
			pstmt.setString(4, r.getPhone());
	//		pstmt.setInt(5, r.getTotal());
			pstmt.setInt(5, r.getCount_guest());
			pstmt.setInt(6, r.getCustomer_no());
			pstmt.setInt(7, r.getRoom_no());
			
			re = pstmt.executeUpdate();
			
			ConnectionProvider.close(conn, pstmt, null);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("���ܹ߻�:"+e.getMessage());
		}
		return re;
	}
	
	
	
	
	
	
	
	//���� ������ �� ����� ��ȯ�ϴ� �޼ҵ� ����
	public ArrayList<PossibleReservationRoomVO> listPossibleReservationRoom(){
		ArrayList<PossibleReservationRoomVO> list = new ArrayList<PossibleReservationRoomVO>();
		String sql = "select room_no, fee, room_type_name, room_state_name"
				+ " from room r, room_type t, room_state s"
				+ " where r.room_type_code = t.room_type_code and"
				+ " r.room_state_code = s.room_state_code and"
				+ " r.room_state_code = 1";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new PossibleReservationRoomVO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4)));
			}
			
			ConnectionProvider.close(conn, pstmt, rs);
			
			
			
		}catch(Exception e) {
			System.out.println("���ܹ߻�"+e.getMessage());
		}
		
		
		
		return list;	
	}
	
	
	
	
	
}
