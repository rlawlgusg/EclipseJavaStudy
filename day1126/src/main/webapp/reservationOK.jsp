<%@page import="com.sist.dao.ReservationDAO"%>
<%@page import="com.sist.vo.ReservationVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	request.setCharacterEncoding("euc-kr");
	try{
		//int reservation_no = Integer.parseInt(request.getParameter("reservation_no"));
		String checkin = request.getParameter("checkin");
		String checkout = request.getParameter("checkout");
		String phone = request.getParameter("phone");
		int count_guest = Integer.parseInt(request.getParameter("count_guest"));
		int customer_no = Integer.parseInt(request.getParameter("customer_no"));
		int room_no = Integer.parseInt(request.getParameter("room_no"));
		System.out.print("checkin"+checkin);
		ReservationVO r = new ReservationVO(0, checkin, checkout, phone, 0, count_guest, customer_no, room_no, 0);
		ReservationDAO dao = new ReservationDAO();
		int re = dao.insertReservation(r);
		if(re == 1){
			out.print("예약성공");
		}else{
			out.print("예약실패");
		}
		
		
	}catch(Exception e){
		System.out.println("예외발생:"+e.getMessage());
	}
	
	
	
	
	%>
</body>
</html>