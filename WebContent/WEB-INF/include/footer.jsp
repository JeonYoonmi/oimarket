<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/footer.css">
</head>
<body>
<div id="footer">
	<img id="logo_black" src="<%= request.getContextPath() %>/images/logo2_black.png">
	<p id="fp1">
		사업자명 : 오이52<br>
		대표자명 : 전윤미<br>
		주소 : 대전광역시 중구 대흥동 500-5 406호
	</p>
	<p id="p2">
		<a href="<%=request.getContextPath()%>/goNoticeList.do">공지사항</a><br><br>
		<a href="">고객센터</a>
	</p>
</div>
</body>
</html>