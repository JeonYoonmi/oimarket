<%@page import="kr.co.oi.VO.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
 <script src = "<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script> 
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<!--   <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script> -->
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<!--   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script> -->
<script src="http://dapi.kakao.com/v2/maps/sdk.js?appkey=dc7fb702e8ef3d6da27b4e8079e3a893&libraries=services"></script>
 
  <script src="<%=request.getContextPath()%>/js/join.js"></script>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/myInfoModify.css">

<script>
var varLat;
var varLon;

/* 내가 위치한 곳의 위도, 경도 구하기 */
function getMyCurLatLon() {
	if(navigator.geolocation) { // Geolocation API 엑세스 가능 여부 확인
		/* 위치 정보 얻기 */
		navigator.geolocation.getCurrentPosition(function(pos) {
			varLat = pos.coords.latitude;
			varLon = pos.coords.longitude;
			getAddrByLatLon();
		})
	}
}

/* 카카오 API를 이용하여 위도/경도로 주소 구하기 */
function getAddrByLatLon() {
	// 주소-좌표 변환 객체를 생성
	var geocoder = new kakao.maps.services.Geocoder();
	var coord = new kakao.maps.LatLng(varLat, varLon);
	
	var callback = function(result, status) {
		if(status == kakao.maps.services.Status.OK) {
			// 결과가 result 변수에 담기고 이것을 이용
			console.log(result);
			
			var dep1 = result[0].address.region_1depth_name;
			var dep2 = result[0].address.region_2depth_name;
			var dep3 = result[0].address.region_3depth_name;
			
			addr = dep1 + " " + dep2 + " " + dep3;
			console.log(addr);
			$('#addr1').val(addr);
		}
	};
	geocoder.coord2Address(coord.getLng(), coord.getLat(), callback);
}

function updateMyinfo(){
	
	mem_pw = $('#pw').val();
	mem_pw2 = $('#pwcheck').val();
	mem_tel = $('#tel').val();
	mem_nick = $('#nick').val();
	mem_email = $('#email').val();
	mem_addr1 = $('#addr1').val();
	
	if(mem_pw == mem_pw2){
		
		
		$.ajax({
			type : 'get',
			url : "myInfoUpdate.do",
			data : {
				"mem_pw" : mem_pw,
				"mem_tel" : mem_tel,
				"mem_nick" : mem_nick,
				"mem_email" : mem_email,
				"mem_addr1" : mem_addr1
			},
			dataType : "text",
			success : function(res){
				alert("성공");
			},
			error : function(xhr){
				alert("상태 : " + xhr.status);
			}
		})
	}else{
		alert("비밀번호가 서로 다릅니다.")
	}
	
}
$(function(){
	$('#nick').on('keyup', function(){
		nick = $(this).val().trim();
		nickreg = /^(?=.*[a-zA-Z0-9가-힣])[a-zA-Z0-9가-힣]{2,16}$/;
		
		if(!(nickreg.test(nick))){
			$(this).css('outline', '1px solid red');
			return false;
		}else{
			$(this).css('outline', '1px solid blue');
		}
	})
	
	$('#butCheck').on('click', function(){
		nickCheck();
	})
	
	$('#but').on('click', function(){
		getMyCurLatLon();
	}) 
	
	//전송하기
	$('#but2').on('click', function(){
		updateMyinfo();
	})
	

})
</script>
</head>
<jsp:include page="/WEB-INF/include/myPageHeader.jsp"></jsp:include>
<jsp:include page="/WEB-INF/include/myInfoBar.jsp"></jsp:include>
<body>
<%
	MemberVO vo = (MemberVO)session.getAttribute("memberVO");
%>
<div id='realBody'>
<div id= "whole">
<div id ="profileimg">
	<img id = "memImage" alt="루피.png" src="<%= request.getContextPath() %>/images/루피.png"><br><br>
	<button type="button" class="btn btn-secondary" id="modifyBut">사진 변경</button>
</div>

<div id = "divParent">
	<div class = "total"><label class = "ptitle">비밀번호</label><input type = "password" class = "input" id = "pw" placeholder="비밀번호를 입력해주세요."></div><br>
 	<div class = "total"><label class = "ptitle">비밀번호 확인</label><input type = "password" class = "input" id = "pwcheck" placeholder="비밀번호를 한번 더 입력해주세요."></div><br>
 	<div class = "total"><label class = "ptitle">전화번호</label><input type = "text" class = "input" id="tel" value="<%=vo.getMem_tel()%>"></div><br>
	<div class = "total"><label class = "ptitle" for = "nick">닉네임</label><input type = "text" class = "input" id = "nick" value = "<%=vo.getMem_nick()%>">
	<button id = "butCheck" type="button" class="btn btn-outline-success">중복 검사</button>
	</div>
	<br>
	<div class = "total"><label class = "ptitle">이메일</label><input type = "email" class = "input" id = "email" value = "<%=vo.getMem_email()%>"></div><br>
	<div class = "total"><label class = "ptitle">주소</label>	
		<input type = "text" id = "addr1" class = "input" value="<%=vo.getMem_addr1()%>">
<!-- 		<input type="text" id="addr" class="jointext" name="addr" placeholder="주소를 입력해주세요">  -->
		<input id = "but" type="button" value="현재위치 검색"  class="btn btn-success addrbtn">
	</div><br><br><br>
	<div class = "total"><button type="button" class="btn btn-secondary" id="but2">수정하기</button></div><br><br>
	
</div>
</div>
</div>
</body>
</html>