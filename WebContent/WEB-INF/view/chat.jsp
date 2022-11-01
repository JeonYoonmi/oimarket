<%@page import="kr.co.oi.VO.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="/WEB-INF/include/header.jsp"></jsp:include>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

<link rel="stylesheet" href="<%=request.getContextPath() %>/css/chat.css">
<script src="<%=request.getContextPath() %>/js/chat.js"></script>
</head>

<body>
<div id="div_dep1">
</div>

<div id="div_dep2">
	<div id="div_dep2_1">
		<img id="img_logo" src="<%=request.getContextPath() %>/images/logo1.png" alt="logo1.png">
	</div>
</div>

<div id="div_dep3">
	<div id="div_dep3_1">
		<span id="span_dep3_1">오이오이</span>
		<button type="button" id="btn_eval" class="btn btn-outline-success">평가하기</button>
	</div>
	<div id="div_dep3_2">
	</div>
</div>

<div id="div_dep4">
	<div id="div_dep4_1">
		<div id="div_dep4_1_1">
			<img src="<%=request.getContextPath() %>/images/default_profile.png" alt="프사" id="img_profile">
			<span id="partner_nick"></span>
			<span id="partner_temp"></span>
		</div>
		<button type="button" id="btn_prom" class="btn btn-outline-success"
			data-toggle="modal" data-target="#modal_promise">약속잡기</button>
		<button type="button" id="btn_depo" class="btn btn-outline-success">송금하기</button>
	</div>
	
	<div id="div_dep4_2">
	</div>
	
	<div id="div_dep4_3">
		<input type="text" class="form-control" id="chat_content" disabled>
		<input type="button" id="btn_send" value="전송" disabled>
	</div>
</div>


<!-- 약속잡기 모달 -->
<div class="modal" id="modal_promise">
  <div class="modal-dialog modal-lg modal-dialog-scrollable">
    <div class="modal-content">    
      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">약속잡기</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>
      <!-- Modal body -->
      <div class="modal-body">
        	<input type="date" id="prom_date">
        	<input type="time" id="prom_time">
        	<input type="hidden" id="prom_check" value="N">
        	<button type="button" id="prom_register" class="btn btn-success">등록</button>
        	<button type="button" id="prom_modify" class="btn btn-success">수정</button>
        	<button type="button" id="prom_delete" class="btn btn-success">삭제</button>
      </div>
      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>


<script>
<%
	MemberVO loginInfo = (MemberVO) session.getAttribute("memberVO");
	if(loginInfo == null) {
%>
		alert('로그인 후 이용 가능합니다.');
		location.href="<%=request.getContextPath()%>/login.do";
<%
	}
	else {
%>

	var login_user_id = "<%=loginInfo.getMem_id()%>";
	
<%
	}
%>

$(function() {
	loadChatRoom(login_user_id);
	
	/* 채팅방 목록 중 하나를 선택하여 클릭 시 */
	$(document).on('click', '.li_chatRoom', function() {
		$('#chat_content').prop('disabled', false);
		$('#btn_send').prop('disabled', false);
		
		
		processChatRead(this); // 채팅 읽음 처리
		loadChatContents(this); // 채팅 목록 표시
		showRegisteredPromise(); // 약속된 일정 툴팁으로 표시
		getPartnerInfo(); // 상대방 정보를 채팅방 상단에 표시
		
	 	//webSocket = new WebSocket("ws://localhost/oimarket/chat/webSocket");
	});
	
	/* 채팅 입력 후 전송 버튼 클릭 시 */
	$('#btn_send').on('click', function() {
	 	sendChatContent();
	})
	
	/* 채팅 입력창에서 Enter 키 입력 시 */
	$('#chat_content').on('keydown', function(key) {
		if(key.keyCode == 13) {// 엔터키
		  sendChatContent();
		}
	})
	
	/* 약속잡기 버튼 클릭 시 */
	$('#btn_prom').on('click', function() {
		openPromiseModal();
	})
	
	/* [약속잡기] modal 창에서 등록 버튼 클릭 시 */
	$('#prom_register').on('click', function() {		
		registerPromise();
	})
	
	/* [약속잡기] modal 창에서 [수정] 버튼 클릭 시 */
	$('#prom_modify').on('click', function() {
		openPromModify();
	})
	
	/* [약속잡기] modal 창에서 [삭제] 버튼 클릭 시 */
	$('#prom_delete').on('click', function() {
		deletePromise();
	})
})

</script>
<br>
</body>
</html>

<jsp:include page="/WEB-INF/include/footer.jsp"></jsp:include>