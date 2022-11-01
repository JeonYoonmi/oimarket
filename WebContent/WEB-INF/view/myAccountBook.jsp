<%@page import="kr.co.oi.VO.MemberVO"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/myAccountBook.css">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/include/myPageHeader.jsp"></jsp:include>
</head>
<body>
<%
	Enumeration<String> sessionNames = session.getAttributeNames();
	MemberVO vo = (MemberVO) session.getAttribute("memberVO");
%>
<div id='realBody'>
<br><br>
	<h2>가계부</h2>
	<hr><br>
	
	<div id='banner'>
		<div class='profileBox1'>
	<%
			if(vo.getMem_url()==null){
	%>
				<img id="profileImg1" src="<%= request.getContextPath() %>/images/default_profile.png">
	<%
			}else{
	%>
				<img id="user" src="">
	<%	
			}
	%>
		</div>
		<div id='nick1'>
			<label><%= vo.getMem_nick() %>님의</label><br>
			<label>오이 가계부</label>
		</div>
		<div id='allData'>
			<label>* 총 판매건수</label>
			<label id="putRight">10건</label>
			<br>
			<label>* 총 판매액</label>
			<label id="putRight">50,000원</label>
			<br>
		</div>
	</div>
	
	<div id='result'>
		<select id='month'></select>
		<div id='ment'>2022년 6월에는 이렇게 거래했어요</div>
		<div id='data'>
			<label id='firstLabel'>* 판매건수</label>
			<label id="putRight">10건</label>
			<br>
			<label>* 판매액</label>
			<label id="putRight">50,000원</label>
			<br>
		</div>
	</div>
</div>
</body>
</html>