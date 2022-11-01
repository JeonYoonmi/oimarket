<%@page import="kr.co.oi.VO.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/myOiPay.css">
<title>Insert title here</title>
</head>
<jsp:include page="/WEB-INF/include/myPageHeader.jsp"></jsp:include>
<body>
<%
	MemberVO vo = (MemberVO)session.getAttribute("memberVO");
%>

<div id='realBody'>
<div id='banner1'>
		<div id='banner2'>
			<img id='logo1' src='<%=request.getContextPath() %>/images/logo1.png'>
			<div id='banner3'>
				보유포인트<br><br>
				<a id='balance' href=''><%=vo.getMem_bank_amt() %>원</a>
			</div>
		</div>
		<input type="button" value="충전하기"><br>
		<input type="button" value="인출하기">
	</div>
	
	<div class='list'>
		<div id='imgDiv'><img src='<%=request.getContextPath() %>/images/plus.png'></div>
		<div id='resultDiv'>
		<p id='date'>2022.06.08</p>
		<p id='money'>+10000원</p>
		</div>
		<p id='pclear'></p>
	</div>
	
	<div class='list'>
		<div id='imgDiv'><img src='<%=request.getContextPath() %>/images/minus.png'></div>
		<div id='resultDiv'>
		<p id='date'>2022.06.08</p>
		<p id='money'>+10000원</p>
		</div>
		<p id='pclear'></p>
	</div>
	
	<div class='list'>
		<div id='imgDiv'><img src='<%=request.getContextPath() %>/images/plusbypay.png'></div>
		<div id='resultDiv'>
		<p id='date'>2022.06.08</p>
		<p id='money'>+10000원</p>
		</div>
		<p id='pclear'></p>
	</div>
</div>
</body>
</html>