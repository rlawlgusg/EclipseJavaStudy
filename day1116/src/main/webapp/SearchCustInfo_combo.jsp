<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.dao.CustomerinfoDAO"%>
<%@page import="com.sist.vo.CustomerInfoVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>고객 정보 확인</h2>
	<% 
	CustomerinfoDAO dao = new CustomerinfoDAO();
	ArrayList<String> name = dao.printCustName();
	%>
	
	
	<form action="SearchCustInfo.jsp" method="post">
	고객이름을 입력하세요  
	<select name="custName">
	<% for(String custName : name){
		%>
		<option value="<%=custName%>"><%=custName%></option>
		<% 
		
	}%>
	
	</select>
	
	
	<input type="submit" value="검색">
	<input type="reset" value="취소">
	</form>
	
	
	<% 
	request.setCharacterEncoding("euc-kr");
	if(request.getParameter("custName") != null){
		String custName = request.getParameter("custName");
	//	CustomerinfoDAO dao = new CustomerinfoDAO();
		ArrayList<CustomerInfoVO> list = dao.printCustInfo(custName);
		
		%>
		<table border="1">
		<tr>
		<td>극장이름</td>
		<td>상영관번호</td>
		<td>영화이름</td>
		<td>예약일</td>
		<td>좌석번호</td>
		<td>가격</td>
		</tr>
		
		<% 
		for(CustomerInfoVO c : list){
			%>
			<tr>
			<td><%=c.getCinemaName()%></td>
			<td><%=c.getCinemaNumber()%></td>
			<td><%=c.getTitle()%></td>
			<td><%=c.getReservation()%></td>
			<td><%=c.getSeatNumber()%></td>
			<td><%=c.getPrice()%></td>
			</tr>
				
			
			
			<% 
		}
		%>
		
		
		
		
		</table>
		<% 
		
	}
	
	
	
	%>
	
</body>
</html>