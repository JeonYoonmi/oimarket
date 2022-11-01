<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kr">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="http://dapi.kakao.com/v2/maps/sdk.js?appkey=dc7fb702e8ef3d6da27b4e8079e3a893&libraries=services"></script>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/join.css">
<script src="js/join.js"></script>
<title>Insert title here</title>
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
			
			$('#addr').val(addr);
		}
	};
	geocoder.coord2Address(coord.getLng(), coord.getLat(), callback);
}


$(function(){
	$('.idchk').on('click', function(){
		id = $('#id').val().trim();
		
		if(id.length<1){
			alert("아이디를 입력하세요.");
			return false;
		}
		
		if(id.length<4 || id.length>12){
			alert("아이디 길이는 4 ~ 12자 사이로 해주세요.");
		}
		
		idreg = /^[a-z][a-zA-Z0-9]{3,11}$/;
		
		if(!(idreg.test(id))){
			alert("아이디 형식 오류 입니다.");
			return false;
		}
		
		idCheck();
	})
	
	$('#pass').on('keyup', function(){
		pass = $(this).val().trim();
		passreg = /^[a-z][a-zA-Z0-9]{7,14}$/;
		
			if(!(passreg.test(pass))){
				$(this).css('outline', '1px solid red');
				return false;
			}else{
				$(this).css('outline', '1px solid blue');
			}
	})
	
	$('#passchk').on('keyup', function(){
		passchk = $(this).val().trim();
		if(pass!=passchk){
			$(this).css('outline', '1px solid red');
			return false;
		}else{
			$(this).css('outline', '1px solid blue');
		}
	})
	
	$('#tel').on('keyup', function(){
		tel = $(this).val().trim();
		telreg = /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/;
		
		if(!(telreg.test(tel))){
			$(this).css('outline', '1px solid red');
			return false;
		}else{
			$(this).css('outline', '1px solid blue');
		}
		
	})
	
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
	
	$('.nickchk').on('click', function(){
		nickCheck();
	})
	
	$('#mail').on('keyup', function(){
		mail = $(this).val().trim();
		mailreg = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		
		if(!(mailreg.test(mail))){
			$(this).css('outline', '1px solid red');
			return false;
		}else{
			$(this).css('outline', '1px solid blue');
		}
	})
	
	$('.addrbtn').on('click', function(){
		getMyCurLatLon();
	}) 
	
})
</script>

</head>
<body>
	<h1 id="jointitle">회원가입</h1>
	<hr><br>
	<form id="joinform" action="join.do" method="post">
		<label class="joinlabel" for="id">아이디</label>
		<input type="text" id="id" class="jointext" name="id" placeholder="아이디를 입력해주세요">
		<input type="button" value="중복 검사" class="btn btn-success idchk"><br>
		
		<label class="joinlabel" for="pass">비밀번호</label>
		<input type="text" id="pass" class="jointext" name="pass" placeholder="비밀번호를 입력해주세요"><br>
		
		<label class="joinlabel" for="passchk">비밀번호 확인</label>
		<input type="text" id="passchk" class="jointext" name="passchk" placeholder="비밀번호를 입력해주세요"><br>
		
		<label class="joinlabel" for="tel">전화번호</label>
		<input type="text" id="tel" class="jointext" name="tel" placeholder="전화번호를 입력해주세요"><br>
		
		<label class="joinlabel" for="nick">닉네임</label>
		<input type="text" id="nick" class="jointext" name="nickname" placeholder="닉네임를 입력해주세요">
		<input type="button" value="중복 검사" class="btn btn-success nickchk"><br>
		
		<label class=joinlabel for="mail">이메일</label>
		<input type="text" id="mail" class="jointext" name="mail" placeholder="이메일를 입력해주세요"><br>
		
		<label class="joinlabel" for="addr">주소</label>
		<input type="text" id="addr" class="jointext" name="addr" placeholder="주소를 입력해주세요" readonly>
		<input type="button" value="현재위치 검색"  class="btn btn-success addrbtn"><br><br>
		
		<input type="submit" value="가입하기" class="btn btn-success" id="joinBtn">
	</form>
</body>
</html>