<%@page import="com.sist.vo.GoodsVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.dao.GoodsDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <style type="text/css">
  	.container{
  		width: 100%;
  	}
  	
  	#cardList{
  		width: 100%;
  	}
  	
  	.card{
  		margin-bottom: 15px;
  	}
  	
  	@media all and (min-width:768px){
  		#cardList{
  			display: flex;
  			flex-wrap: wrap;
  			justify-content: space-between;
  		}
  		
  		.card{
  			width: 49%;
  		}
  	}
  	
  	@media all and (min-width:992px){
  		.card{
  			width: 33%;
  		}
  	}
  	
  	
  </style>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h2>상품 목록</h2>
	  <div id="cardList">
		<%
			GoodsDao dao = new GoodsDao();
			ArrayList<GoodsVO> list = dao.listDept();
			for(GoodsVO g:list){
				%>
					<div class="card" style="width: 320px">
						<img class="card-img-top" src="goods/<%=g.getFname() %>" style="width: 100%">
						<div class="card-body">
							<h4 class="card-title"><%=g.getName() %></h4>
							<p class="card-text"> 상품번호 : <%=g.getNo() %><br>
								가격 : <%= g.getPrice() %>0원<br>
								수량 : <%= g.getQty() %></p>
							<a href="#" class="btn btn-primary stretched-link">상품 구매</a>
						</div>
					</div>
				<%
			}
		%>
		</div>
	</div>
</body>
</html>



