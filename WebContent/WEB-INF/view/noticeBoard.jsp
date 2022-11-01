<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="<%= request.getContextPath() %>/js/noticeBoard.js"></script>
<script src="<%= request.getContextPath() %>/js/jquery.serializejson.min.js"></script>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/noticeBoard.css">
<title>Insert title here</title>
</head>

<script>	
	$(function () {
		listServer();
	})
</script>

<body>
	<a href="<%=request.getContextPath()%>/main.jsp">
		<img id='realLogo' alt="" src="<%=request.getContextPath()%>/images/logo2.png">
	</a><br>
	
	<img id='pome' src="<%=request.getContextPath() %>/images/오이포메1.png">
	<h1 id='noticeTitle'>공지사항</h1>
	<br><br><br><br>
	
	<div id="d1"></div>
	<br><br><br><br>
<jsp:include page="../include/footer.jsp"></jsp:include>	
</body>
</html>