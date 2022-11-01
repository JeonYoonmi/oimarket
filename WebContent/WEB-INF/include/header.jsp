<%@page import="kr.co.oi.VO.MemberVO"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/header.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<div id="d1">
<%
	Enumeration<String> sessionNames = session.getAttributeNames();
	MemberVO vo = (MemberVO) session.getAttribute("memberVO");
	String memId = "";
	if(vo != null){
		memId = vo.getMem_id();
	}
	if(vo == null){
%>
		<a href=""><img align="bottom" id="d" src="<%= request.getContextPath() %>/images/logo1.png"></a>
		<a href="<%= request.getContextPath() %>/login.do">LOGIN</a><a href="<%= request.getContextPath() %>/join.do">JOIN</a>
		<a href="<%=request.getContextPath()%>/chat/chatPage.do">채팅</a><a href="">MY PAGE</a>
<%
	}else{
%>
		<a href=""><img align="bottom" id="d" src="<%= request.getContextPath() %>/images/logo1.png"></a>
		<a href="<%= request.getContextPath() %>/logout.do">LOGOUT</a>
		<a href="<%=request.getContextPath()%>/chat/chatPage.do">채팅</a><a href="<%= request.getContextPath() %>/mypage.do">MY PAGE</a><p id="p1"><%= vo.getMem_nick() %>님</p>
<%
		if(vo.getMem_url()==null){
%>
			<img id="user" src="<%= request.getContextPath() %>/images/default_profile.png">
<%
		}else{
%>
			<img id="user" src="">
<%	
		}
	}
%>
</div>

<div id="d2">
	<a href="<%= request.getContextPath() %>/main.jsp"><img id="logo" src="<%= request.getContextPath() %>/images/logo2.png"></a><br><br>
	<ul id="ctg">
		<li id="ctgname"><a href="<%= request.getContextPath() %>/mpostList.do"><img id="ctgimg" src="<%= request.getContextPath() %>/images/categories.png">카테고리</a><br>
			<ul id="list">
				<li><a href="<%= request.getContextPath() %>/mpostList.do?ctg=1">디지털기기</a></li>
				<li><a href="<%= request.getContextPath() %>/mpostList.do?ctg=2">생활가전</a></li>
				<li><a href="<%= request.getContextPath() %>/mpostList.do?ctg=3">가구/인테리어</a></li>
				<li><a href="<%= request.getContextPath() %>/mpostList.do?ctg=4">유아동</a></li>
				<li><a href="<%= request.getContextPath() %>/mpostList.do?ctg=5">유아도서</a></li>
				<li><a href="<%= request.getContextPath() %>/mpostList.do?ctg=6">생활/가공식품</a></li>
				<li><a href="<%= request.getContextPath() %>/mpostList.do?ctg=7">스포츠/레저</a></li>
				<li><a href="<%= request.getContextPath() %>/mpostList.do?ctg=8">여성잡화</a></li>
				<li><a href="<%= request.getContextPath() %>/mpostList.do?ctg=9">여성의류</a></li>
				<li><a href="<%= request.getContextPath() %>/mpostList.do?ctg=10">남성패션/잡화</a></li>
				<li><a href="<%= request.getContextPath() %>/mpostList.do?ctg=11">게임/취미</a></li>
				<li><a href="<%= request.getContextPath() %>/mpostList.do?ctg=12">뷰티/미용</a></li>
				<li><a href="<%= request.getContextPath() %>/mpostList.do?ctg=13">반려동물용품</a></li>
				<li><a href="<%= request.getContextPath() %>/mpostList.do?ctg=14">도서/티켓/음반</a></li>
				<li><a href="<%= request.getContextPath() %>/mpostList.do?ctg=15">식물</a></li>
				<li><a href="<%= request.getContextPath() %>/mpostList.do?ctg=16">기타</a></li>
			</ul>
		</li>
	</ul>
	
	<select id="s1">
		<option selected>전체</option>
		<option>매물</option>
		<option>동네</option>
		<option>닉네임</option>
	</select>
	<input type="text" id="text" name="word">
	<input id="send" type="image" src="<%= request.getContextPath() %>/images/search.png">
<script>
$(function(){
	$('.write').on('click', function(){
		if("<%= memId %>" == ""){
			alert("로그인 후 이용하실 수 있는 서비스 입니다.");
			return false;
		}
	})
})
</script>
	<ul id="write">
		<li id="writename"><p>+글쓰기</p>
			<ul id="writectg">
				<a class="write" href="<%= request.getContextPath() %>/mpostWrite.do"><li>매물</li></a>
				<a class="write" href=""><li>동네생활</li></a>
			</ul>
		</li>
	</ul>
	<br>
</div>

</body>
</html>