<%@page import="kr.co.oi.VO.MemberVO"%>
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
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/myProfile.css">
<title>Insert title here</title>
</head>
<jsp:include page="/WEB-INF/include/myPageHeader.jsp"></jsp:include>
<jsp:include page="/WEB-INF/include/myInfoBar.jsp"></jsp:include>
<body>
<%
	MemberVO vo = (MemberVO)session.getAttribute("memberVO");
	String color = "";
	String imgName = "";
	String fontColor = "";
	double temp = vo.getMem_temp();
	
	if(temp <= 32) {
		imgName = "under32.png";
		color = " bg-dark";
		fontColor = "#000033";
	}else if(temp <= 36.5) {
		imgName = "ok.png";
		fontColor = "blue";
	}else if(temp <= 40) {
		imgName = "good.png";
		color = " bg-success";
		fontColor = "green";
	}else if(temp <= 50) {
		imgName = "better.png";
		color = " bg-warning";
		fontColor = "orange";
	}else {
		imgName = "best.png";
		color = " bg-danger";
		fontColor = "red";
	}
%>


<div id='realBody'>
	<div id = "dchild">
		<div id = "mannerTemp">
			<div id = "mannerLeft">
				<span id = "sp1">매너온도</span><br>
				<span id = "sp2">(첫 온도 36.5℃)</span>
			</div>
			<div id = "tempShow">
				<img id='tempImg' src='<%=request.getContextPath()%>/images/<%=imgName%>'>
				<p id='tempValue' style="color:<%=fontColor%>"><%=vo.getMem_temp()%>℃</p>
				<div class="progress">
	    			<div class="progress-bar<%=color %>" style="width:<%=vo.getMem_temp()%>%"></div>
	  			</div>
			</div>
		</div>
		<div id = "evaluation">
			<div id = "evaLeft">받은 매너 평가</div>
			<div id = "evaRight">
				<div class = "circle">5</div>
				<div class = "eva">친절하고 매너가 좋아요!</div>
			</div>
		</div>
		<div id = "review">
			<div id = "revLeft">받은 거래 후기</div>
				<div class = "reviewCnt">
					<img id = "imgCircle" src = "<%= request.getContextPath() %>/images/루피.png" alt = "루피.png">
					<div id = "total">
						<p id = "memId">오이오이</p>
						<p id = "memDong">중구 오류동</p>
					</div>
					<p id = "memCnt">좋은 제품 감사합니다~</p>
				</div>
		</div>
	</div>
</div>
</body>
</html>