<%@page import="kr.co.oi.VO.MemberVO"%>
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
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/myPageHeader.css">
<title>마이 페이지</title>
<script>
	$(function() {
		$('#resbut').on('click', function() {
			$('#frEmail').val('');
		});
	});
	
</script>
</head>
<body>
<%
	Enumeration<String> sessionNames = session.getAttributeNames();
	MemberVO vo = (MemberVO) session.getAttribute("memberVO");
%>
<header>
<a href="<%=request.getContextPath()%>/main.jsp">
	<img id='realLogo' alt="" src="<%=request.getContextPath()%>/images/logo2.png">
</a>
</header>

<nav>
<div id='mpBarH'>
		<div class='profileBox'>
<%
	if(vo.getMem_url()==null){
%>
			<img class='profileImg' src="<%= request.getContextPath() %>/images/default_profile.png"><br>
<%
	}else{
%>
			<img class='profileImg' src='<%=request.getContextPath() %>/imgEx/englishCucumber.jpg'><br>

<%
	}
%>		
		</div>
		
		<div id='nickName'><%= vo.getMem_nick() %></div>
		<div id='addr'><%= vo.getMem_addr1() %></div>
		<br>
		
		<div id='pay'>
			<img id='logo' src='<%=request.getContextPath() %>/images/logo1.png'>
			<% if(vo.getMem_actno() == null) { %>
			<a href='' data-toggle="modal" data-target="#myModal1">오이페이로 거래해보세요!</a>
			<%}else { %>
			<a href='<%= request.getContextPath() %>/oiPay.do'>오이페이 포인트 <%=vo.getMem_bank_amt() %>원</a>
			<%}%>
		</div>
		<br>
	
		<p id='h3text'>MY</p>
		<div class='d5'><a href='<%= request.getContextPath() %>/myProfile.do'>내 정보</a></div>
		<div class='d5'><a href=''>거래 내역</a></div>
		<div class='d5'><a href='<%= request.getContextPath() %>/myDongSet.do'>동네 설정</a></div>
		<div class='d5'><a href=''>작성글/댓글</a></div>
		<div class='d5'><a href='<%= request.getContextPath() %>/rememberItrstCtg.do'>관심 카테고리 설정</a></div>
		<div class='d5'><a href='<%= request.getContextPath() %>/myAccountBook.do'>가계부</a></div>
		<br><br><br>
		
		<p id='h3text'>오이마켓</p>
		<div class='d5'><a href='<%=request.getContextPath()%>/goNoticeList.do'>공지사항</a></div>
		<div class='d5'><a href=''>고객센터</a></div>
		<div class='d5'>
			<%if(vo.getMem_event() == 0) { %>
			<a href="" data-toggle="modal" data-target="#myModal">친구초대</a></div>
			<%}else { %>
			<a href="" onclick="alert('이미 초대하셨습니다.이벤트 참여는 한 번만 가능합니다.');">친구초대</a></div>
			<%} %>
		<br><br>
		<br><br>
		<div class='d5'><a href='<%= request.getContextPath() %>/deleteMember.do'>탈퇴</a></div>
		
  <!-- Button to Open the Modal -->

  <!-- The Modal -->
  <div class="modal" id="myModal">
    <div class="modal-dialog">
      <div class="modal-content">
      
        
        <!-- Modal body -->
        <div class="modal-body">
        <form method="post" action="<%=request.getContextPath() %>/sendEmail.do">
        	<img id='logo2' src='<%=request.getContextPath() %>/images/logo2.png'>
        	<br>
          	<p id='modText'>홍보하고 포인트 3000원 받자!</p>
          	<br><br>
          	친구의 이메일을 입력해주세요!
          	<br><br>
          	<input type='text' id='frEmail' name='fremail'>
          	<br><br>
        
        
       
          <button type="button" class="btn btn-secondary" data-dismiss="modal" id='resbut'>취소</button>
          <input type="submit" class="btn btn-secondary" value="친구 초대하기"></form>
        </div>
        
      </div>
    </div>
  </div>
  
  <!-- The Modal -->
  <div class="modal" id="myModal1">
    <div class="modal-dialog">
      <div class="modal-content">
      
        
        <!-- Modal body -->
        <div class="modal-body">
        <form method="post" action="<%=request.getContextPath() %>/registerAccount.do">
        	<div class="container">
			  <h2>오이페이 계좌등록</h2>
			  <p>계좌 등록하고 편하게 결제하자!</p>
			    <div class="form-group">
			      <label for="sel1">은행</label>
			      <select class="form-control" id="sel1" name="sellist1">
			        <option>NH농협</option>
			        <option>KB국민</option>
			        <option>카카오뱅크</option>
			        <option>신한</option>
			        <option>우리</option>
			        <option>IBK기업</option>
			        <option>하나</option>
			        <option>새마을</option>
			        <option>토스뱅크</option>
			        <option>부산</option>
			        <option>대구</option>
			        <option>케이뱅크</option>
			        <option>신협</option>
			        <option>우체국</option>
			        <option>SC제일</option>
			        <option>경남</option>
			        <option>수협</option>
			        <option>광주</option>
			        <option>전북</option>
			        <option>저축은행</option>
			        <option>씨티</option>
			        <option>제주</option>
			        <option>KDB산업</option>
			        <option>SBI저축은행</option>
			        <option>산림조합</option>
			        <option>BOA</option>
			        <option>HSBC</option>
			        <option>중국</option>
			        <option>도이치</option>
			        <option>중국공상</option>
			        <option>JP모간</option>
			        <option>BNP파리바</option>
			        <option>중국건설</option>
			      </select><br>
			      <label for="sel1">계좌번호</label><br>
			      <input type='text' id='accountNum' name='accountNum'>
			      <br>
			      
			    </div>
			</div>
        
        
       
          <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
          <input type="submit" class="btn btn-secondary" value="등록하기"></form>
        </div>
        
      </div>
    </div>
  </div>
  
</div>
</nav>

<section>
	<div id='mpBarV'>
		<ul>
			<li><a href=''>거래내역</a></li>
			<li><a href='<%= request.getContextPath() %>/oiPay.do'>오이페이</a></li>
			<li><a href='myProfile.do'>내정보</a></li>
		</ul>
	</div>
</section>

<footer>
</footer>

</body>
</html>