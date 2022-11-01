<%@page import="kr.co.oi.VO.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="css/dongSet.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
  
  <script src="http://dapi.kakao.com/v2/maps/sdk.js?appkey=dc7fb702e8ef3d6da27b4e8079e3a893&libraries=services"></script>

<script type="text/javascript">
$(document).ready(function(){
	
	var radio = $('input[name="choice"]');
	radio.change(function(){
		var chkVal = $('input[name="choice"]:checked').val();
		$(document.getElementById('imageChange')).attr("src","<%=request.getContextPath()%>/images/" + chkVal + ".png");
	})
	
	
})
</script>
</head>
<jsp:include page="/WEB-INF/include/myPageHeader.jsp"></jsp:include>
<body>
<%
	MemberVO vo = (MemberVO)session.getAttribute("memberVO");
	String addr2 = vo.getMem_addr2();
	if(addr2 == null) {
		addr2 = "+";
	}
%>
<div id='realBody'>
<div id = "dparent">
	<br><br>
	<h2>동네 설정</h2>
	<hr><br>
	<div id = "whole">
	<div id = "butSet">
		<button type="button" class="btn btn-secondary" id="modifyBut" class = "but"><p class = "plus"><%=vo.getMem_addr1() %></p></button>
		<button type="button" class="btn btn-secondary" id="plusBut" class = "but"><p class = "plus"><%=addr2 %></p></button>
	</div>
	<div id = "under">
		<img id = "imageChange" src = "<%=request.getContextPath()%>/images/동네설정4단계.png">
		<div id = "pparent">
			<br>
			<p class = "pradio"><input type = "radio" name = "choice" value="동네설정1단계"><input type = "text" placeholder="1단계 :같은 동에서만 거래할래요!" readonly></p><br>
			<p class = "pradio"><input type = "radio" name = "choice" value="동네설정2단계"><input type = "text" placeholder="2단계 :같은 구/군에서만 거래할래요!" readonly></p><br>
			<p class = "pradio"><input type = "radio" name = "choice" value="동네설정3단계"><input type = "text" placeholder="3단계 :같은 시에서만 거래할래요!" readonly></p><br>
			<p class = "pradio"><input type = "radio" name = "choice" value="동네설정4단계"  checked="checked"><input type = "text" placeholder="4단계 :어디든 상관없어요!" readonly></p>
		</div>
		<button type="button" class="btn btn-outline-success" id = "done">선택완료</button>
		</div>
	</div>
</div>
</div>
</body>
</html>