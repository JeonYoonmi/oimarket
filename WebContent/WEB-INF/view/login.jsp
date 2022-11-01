<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/login.css">
<title>로그인</title>
</head>
<body>
<h1 id="logintitle">로그인</h1>
<hr><br>
<%
	String id = "";
	String chk = "";
	Cookie[] cookieArr = request.getCookies();
	if(cookieArr!=null){
		for(Cookie cookie : cookieArr){
			if(cookie.getName().equals("memId")){
				id = cookie.getValue();
				chk = "checked";
			}
		}
		
	}
%>
<div class="container">
		<form id="loginform" action="<%= request.getContextPath() %>/login.do" method="post">
			<label class="loginlabel">아이디</label>
			<input type="text" class="logintext" name="id" placeholder="아이디를 입력해주세요" value="<%= id %>"><br>
			
			<label class="loginlabel">비밀번호</label>
			<input type="text" class="logintext" name="pass" placeholder="비밀번호를 입력해주세요"><br>
			<p id="chk"><input type="checkbox" name="remember" <%= chk %>> ID 기억하기</p><br>
			
			<input type="submit" value="로그인" class="btn btn-success loginBtn" id="loginBtn"><br>
		</form>
		<input type="submit" value="회원가입" class="btn btn-outline-success loginBtn" id="joinBtn" onclick="location.href='join.do'">
	</div>
</body>
</html>