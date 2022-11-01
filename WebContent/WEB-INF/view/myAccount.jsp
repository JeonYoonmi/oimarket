<%@page import="kr.co.oi.VO.MemberVO"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/myAccount.css">
<title>Insert title here</title>
</head>
<jsp:include page="../include/myPageHeader.jsp"></jsp:include>
<body>

<%
	Enumeration<String> sessionNames = session.getAttributeNames();
	MemberVO vo = (MemberVO)session.getAttribute("memberVO");
%>

<div id='realBody'>
<br><br><br>
	<h2>가계부</h2>
	<hr><br>
	
	<div id='banner'>
		<div class='profileBoxA'>
<%
	if(vo.getMem_url()==null){
%>
			<img class='profileImgA' src="images/default_profile.png"><br>
<%
	}else{
%>
			<img class='profileImgA' src='<%=request.getContextPath() %>/imgEx/englishCucumber.jpg'><br>

<%
	}
%>
		</div>
		<div id='nickA'>
			<label class='labelA'><%=vo.getMem_nick() %>님의</label><br>
			<label class='labelA'>오이 가계부</label>
		</div>
		<div id='allData'>
			<label class='labelA'>* 총 판매건수</label>
			<label class='labelA' id="putRight">10건</label>
			<br>
			<label class='labelA'>* 총 판매액</label>
			<label class='labelA' id="putRight">50,000원</label>
			<br>
		</div>
	</div>
	
	<div id='result'>
		<select id='month'></select>
		<div id='ment'>2022년 6월에는 이렇게 거래했어요</div>
		<div id='data'>
			<label class='labelA' id='firstLabel'>* 판매건수</label>
			<label class='labelA' id="putRight">10건</label>
			<br>
			<label class='labelA'>* 판매액</label>
			<label class='labelA' id="putRight">50,000원</label>
			<br>
		</div>
	</div>
</div>
</body>
</html>