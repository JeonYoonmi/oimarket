<%@page import="kr.co.oi.VO.MemberVO"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/deleteMember.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<jsp:include page="../include/myPageHeader.jsp"></jsp:include>
<body>
<%
	Enumeration<String> sessionNames = session.getAttributeNames();
	MemberVO vo = (MemberVO) session.getAttribute("memberVO");
%>
<script>
$(function(){
	$('#deleteBtn').on('click', function(){
		id = "<%= vo.getMem_id() %>";
		pass = "<%= vo.getMem_pw() %>";
		if( id != $('#id').val() || pass != $('#pass').val()){
			alert("아이디 또는 비밀번호가 틀렸습니다.");
		}else{
			$.ajax({
				url : '/oimarket/deleteMember.do',
				data : { "id" : id,
						 "pass" : pass},
				type : 'post',
				success : function(res){
					if(res == "ok"){
						alert("탈퇴되었습니다.");
						location.href = '<%= request.getContextPath() %>/logout.do';
					}else{
						alert("탈퇴처리 실패되었습니다.");
						 $('#id').val("");
						 $('#pass').val("");
					}
					
				},
				error : function(xhr){
					alert("상태  : " + xhr.status);
				}
			})
		}
	})
})
</script>
<div id="realBody">
	<div class="container" >
	<br><br>
	<h2>회원 탈퇴</h2>
	<hr><br>
	<p class="pull gr">
		<%= vo.getMem_nick() %>님..<br>
		<%= vo.getMem_bank_amt() %>포인트가 남았는데 탈퇴 할거임?
	</p>
	<div id="dmd">
	<div id="first">
		<img id="img" src="<%=request.getContextPath() %>/images/슬픈오이포메.png">
	</div>
	<div id="second">
		<br><br><br><br><br><br><br><br>
		<label class="deletelabel" for="id">아이디</label>
		<input type="text" class="deletetext" id="id" name="id" placeholder="아이디를 입력해주세요."><br>
		
		<label class="deletelabel" for="pass">비밀번호</label>
		<input type="text"  class="deletetext" id="pass" name="pass" placeholder="비밀번호를 입력해주세요."><br><br>
		
		<input type="button" class="btn btn-success" id="deleteBtn" value="탈퇴하기">
	</div>
	<br>
	</div>
	</div>
</div>
</body>
</html>