<%@page import="kr.co.oi.VO.MpostVO"%>
<%@page import="kr.co.oi.VO.MpostImgVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<title>Insert title here</title>
<style>
#allmpost{
	margin: 0px auto;
	width: 1010px;
}
.mpost{
	width: 250px;
	height: 400px;
	border: 1px solid gray;
	text-align: center;
	float: left;
}

.mpost:hover{
	cursor: pointer;
}

.imgs{
	width: 250px;
	height: 250px;
}

.imgs img{
	width: 90%;
	height: 90%;
	border-radius: 5px;
}

br{
	clear: both;
}

#ctgtb{
	margin: 20px auto;
	border-collapse: collapse;
}

td{
	width: 130px;
	text-align: center;
	font-weight: bold;
	padding: 3px;
}
</style>
<script>
$(function(){
	$('.mpost').on('click', function(){
		var mpost_code = $(this).attr("id");
		$("#mpost_code").val(mpost_code);
		
		$("#f1").submit();
		
	}) 
	
})

</script>
</head>
<jsp:include page="../include/header.jsp"></jsp:include>
<body>
<br><br>
	<div id="realbody">
	<table border="1" id="ctgtb">
		<tr>
			<td colspan="2"><a href="<%= request.getContextPath() %>/mpostList.do">전체 보기</a></td>
			<td><a href="<%= request.getContextPath() %>/mpostList.do?ctg=1">디지털기기</a></td>
			<td><a href="<%= request.getContextPath() %>/mpostList.do?ctg=2">생활가전</a></td>
			<td><a href="<%= request.getContextPath() %>/mpostList.do?ctg=3">가구/인테리어</a></td>
			<td><a href="<%= request.getContextPath() %>/mpostList.do?ctg=4">유아동</a></td>
			<td><a href="<%= request.getContextPath() %>/mpostList.do?ctg=5">유아도서</a></td>
			<td><a href="<%= request.getContextPath() %>/mpostList.do?ctg=6">생활/가공식품</a></td>
			<td><a href="<%= request.getContextPath() %>/mpostList.do?ctg=7">스포츠/레저</a></td>
		</tr>
		<tr>
			<td><a href="<%= request.getContextPath() %>/mpostList.do?ctg=8">여성잡화</a></td>
			<td><a href="<%= request.getContextPath() %>/mpostList.do?ctg=9">여성의류</a></td>
			<td><a href="<%= request.getContextPath() %>/mpostList.do?ctg=10">남성패션/잡화</a></td>
			<td><a href="<%= request.getContextPath() %>/mpostList.do?ctg=11">게임/취미</a></td>
			<td><a href="<%= request.getContextPath() %>/mpostList.do?ctg=12">뷰티/미용</a></td>
			<td><a href="<%= request.getContextPath() %>/mpostList.do?ctg=13">반려동물용품</a></td>
			<td><a href="<%= request.getContextPath() %>/mpostList.do?ctg=14">도서/티켓/음반</a></td>
			<td><a href="<%= request.getContextPath() %>/mpostList.do?ctg=15">식물</a></td>
			<td><a href="<%= request.getContextPath() %>/mpostList.do?ctg=16">기타</a></td>
		</tr>
	</table><br>
	<div id="allmpost">
	<%
		List<Map<String, Object>> list = (List<Map<String, Object>>)request.getAttribute("mpostList");
		
	
		for(int i=0; i<list.size(); i++){
			list.get(i).get("MPOSTIMG_URL");
	%>
		<div id="<%= list.get(i).get("MPOST_CODE") %>" class="mpost">
	<%
			if(list.get(i).get("MPOSTIMG_URL") != null){
	%>
			<p class="imgs"><img src="<%= list.get(i).get("MPOSTIMG_URL") %>"></p>
	<%
			}else{
	%>
			<p class="imgs"><img src="<%= request.getContextPath() %>/images/noimage.png"></p>
	<%
			}
	%>
			<p><%= list.get(i).get("MPOST_TITLE") %></p>
			<p><%= list.get(i).get("MPOST_ADDR") %></p>
<%
			if(Integer.parseInt(String.valueOf(list.get(i).get("MPOST_DLNG"))) == 1){
%>
				<p id="price">거래 완료</p>
<%
			}else{
%>
				<p id="price"><%= list.get(i).get("MPOST_PRICE") %>원</p>
<%		
			}
%>
		</div>
		
	<%
			if((i+1) % 4 == 0) {
	%>
				<br>
	<%
			}
		}
	%>
	</div>
	</div>
	<form action='<%= request.getContextPath() %>/mpostInfo.do' method='get' id='f1'>
			<input type="hidden" name="mpost_code" id="mpost_code">
		</form>
	<br><br>
</body>
<jsp:include page="../include/footer.jsp"></jsp:include>
</html>