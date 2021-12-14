<%@page import="com.sist.dao.GoodsDao"%>
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
%>
<jsp:useBean id="g" class="com.sist.vo.GoodsVo"/>
<jsp:useBean id="dao" class="com.sist.dao.GoodsDao"></jsp:useBean>
<jsp:setProperty property="*" name="g"/>
입력한 상품 정보는 다음과 같습니다 <hr>
<%=g %>
<%
	int re = dao.insertGoods(g);
	if(re == 1){
		out.print("상품을 등록하였습니다");	
	}else{
		out.print("상품등록에 실패하였습니다");
	}
%>
</body>
</html>