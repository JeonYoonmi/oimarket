<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/myInfoBar.css">
<title>Insert title here</title>
</head>
<body>
<div id='barBody'>
	<div class='barBox' id='barProfile'><a class = "atag" href = "<%=request.getContextPath()%>/myProfile.do">프로필</a></div>
	<div class='barBox' id='barModify'><a class = "atag" href = "<%=request.getContextPath()%>/myInfoModify.do">내정보 수정</a></div>
</div>
</body>
</html>