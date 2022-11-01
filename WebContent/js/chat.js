/**
 * 현재 선택된 채팅방과 관련된 정보가 들어있는 객체
 *  .chatr_code : 채팅방 고유번호
 *	.mpost_code : 매물게시판 고유번호
 *	.seller_id : 판매자 아이디
 *	.buyer_id : 구매자 아이디
 *	.chatc_cont : 상대방에게 전달할 대화
 */
var chatRoomInfo = { };

/**
 * 약속 잡기에 사용될 정보가 들어있는 객체
 *  .chatr_code : 채팅방 고유번호
 *	.promise : 약속 일정 (형식 : YYYYMMDDHHMI)
 */
var sendData = { };


/* [채팅] 클릭 시 '채팅방' 목록 불러오는 함수 */
function loadChatRoom() {
	$.ajax({
		url : '/oimarket/chat/getChatRoom.do',
		type : 'post',
		data : {"id" : login_user_id},
		dataType : 'json',
		success : function(data) {
			var cont = '<ul id="ul_chatRoom" class="list-group">';
			if(data.sw == "ok") {
				/* 대화방 목록 생성 */
				$.each(data.roomList, function(i, v) {
					cont += '<li class="list-group-item d-flex justify-content-between '
						+ 'align-items-center li_chatRoom" id="' + v.chatr_code + '">';
					cont += '<img class="rounded-circle img_chatRoom" id="img_chatRoom_' + v.chatr_code + '"' +
									'src="../images/default_profile.png">'; // 프로필 사진
					cont += '<p class="p_chatRoom" id="p_chatRoom_id' + v.chatr_code + '"></p>'; // 상대방 아이디 
					cont += '<p class="p_chatRoom_lastChat" id="p_chatRoom_lastchat' + v.chatr_code + '"></p>'; // 마지막 대화 내용
					cont += '<span class="badge badge-primary badge-pill"' +
									'id="span_chatRoom_unread' + v.chatr_code + '"></span>'; // 읽지 않은 문자 수
					cont += '<input type="hidden" id="seller_id_' + v.chatr_code + '"' +
									' value="' + v.seller_id + '">';
					cont += '<input type="hidden" id="buyer_id_' + v.chatr_code + '"' +
									' value="' + v.buyer_id + '">';
					cont += '<input type="hidden" class="chatr_code"' +
									' value="' + v.chatr_code + '">';
												
					cont += '</li>';
				})
				cont += '</ul>';
				$('#div_dep3_2').html(cont);
				
				/* 채팅목록 상단 부분 숨기기 */
				hidePartnerInfo();
				
				/* 채팅방 목록에 최근 대화 표시 */
				$.each(data.lastChat, function(i, v) {
					$('#p_chatRoom_lastchat' + v.chatr_code).html(v.chatc_cnt);
				})
				
				/* 채팅방 목록에 읽은 않은 대화 수 표시 */
				$.each(data.unreadMap, function(i, v) {
					$('#span_chatRoom_unread' + v.CHATR_CODE).html(v.CHATC_CHECK);
				})
				
				/* 채팅방 목록에 상대방 아이디 및 프로필 사진 표시 */
				$.each(data.roomList, function(i, v) {
					if(v.seller_id == login_user_id) {// 상대방이 구매자
						$('#p_chatRoom_id' + v.chatr_code).html(v.buyer_id);
						// TODO : 프로필 사진 가져오기 구현
					}
					else { // 상대방이 판매자
						$('#p_chatRoom_id' + v.chatr_code).html(v.seller_id);
						// TODO : 프로필 사진 가져오기 구현
					}
				})
			}
			else {
				cont += "<p>대화중인 상대가 없습니다</p>";
				$('#div_dep3_2').html(cont);
			}			
		},
		error : function(xhr) {
			alert("채팅방 로드 에러 : " + xhr.status);
		}
	})
}

/* 채팅방 목록 중 클릭한 채팅방의 대화 목록을 가져와서 표시하는 함수 */
function loadChatContents(thisRoom) {
	$('.li_chatRoom').removeClass('active'); // 선택된 채팅방 음영 표시 초기화
	$(thisRoom).addClass('active'); // 현재 선택된 채팅방 음영 표시
	
	/* 현재 선택된 채팅방의 매물게시판 번호 가져오기 */
	chatRoomInfo.mpost_code = $(thisRoom).find('.chatr_code').val();
	
	var room_id = $(thisRoom).attr('id'); // 현재 선택된 채팅방의 번호 가져오기
	chatRoomInfo.chatr_code = room_id;
	console.log()
	$.ajax({
		url : '/oimarket/chat/getChatContents.do',
		type : 'post',
		data : {"roomId" : room_id},
		dataType : 'json',
		success : function(chatList) {
			showChatContents(chatList);
		},
		error : function(xhr) {
			alert("채팅내용 불러오기 에러 : " + xhr.status);
		}
		
	})
}

/* 채팅 보내기 전 아이디 세팅하기 */
function setIdBeforeChatting() {
	var temp_seller_id = $('#seller_id_' + chatRoomInfo.chatr_code).val();
	if(login_user_id == temp_seller_id) { // 내가 판매자라면
		chatRoomInfo.seller_id = login_user_id;
		chatRoomInfo.buyer_id = '';
	}
	else { // 내가 구매자라면
		chatRoomInfo.buyer_id = login_user_id;
		chatRoomInfo.seller_id = '';
	}
} 

/* 입력한 채팅 정보를 상대방에게 전달하고 DB에 저장하는 함수 */
function sendChatContent() {
	/* 입력한 채팅 내용 가져오기 */
	chatRoomInfo.chatc_cnt = $('#chat_content').val();
	$('#chat_content').val('');
	
	/* 상대방 아이디 가져오기 */
	setIdBeforeChatting();
	
	//chatRoomInfo.mem_id = login_user_id;
	console.log(chatRoomInfo);
	
	$.ajax({
		url : '/oimarket/chat/sendChatContent.do',
		type : 'get',
		data : chatRoomInfo,
		dataType : 'json',
		success : function(chatList) {
			showChatContents(chatList);
			$("#div_dep4_2").scrollTop($(document).height());
		},
		error : function(xhr) {
			alert("메시지 전송 에러 : " + xhr.status);
		}
	})
}

/* 선택한 채팅방의 채팅 내용을 화면에 출력하는 함수 */
function showChatContents(contents) {
	var cont = '';
	chatRoomInfo.mpost_code = contents.data[0].mpost_code;
				
	if(contents.sw == "ok") {
		cont += '<ul class="list-group list-group-flush">';
		$.each(contents.data, function(i, v) {
			if(typeof v.seller_id != 'undefined') { // 판매자일 경우
				if(v.seller_id == login_user_id) { // 판매자가 본인일 경우 : 우측에 표시
					cont += '<li class="list-group-item li_myChatContent"' 
						+ 'id="' + v.chatc_code + '">';
					cont += '<p>' + v.chatc_cnt + '</p>';
					cont += '</li>';
				}
				else { // 판매자가 상대방일 경우 : 좌측에 표시
					cont += '<li class="list-group-item li_yourChatContent"' 
						+ 'id="' + v.chatc_code + '">';
					cont += '<p>' + v.chatc_cnt + '</p>';
					cont += '</li>';
				}
			}
			else if(typeof v.buyer_id != 'undefined') { // 구매자일 경우
				if(v.buyer_id == login_user_id) {// 구매자가 본인일 경우 : 우측에 표시
					cont += '<li class="list-group-item li_myChatContent"' 
						+ 'id="' + v.chatc_code + '">';
					cont += '<p>' + v.chatc_cnt + '</p>';
					cont += '</li>';
				}
				else { // 구매자가 상대방일 경우 : 좌측에 표시
					cont += '<li class="list-group-item li_yourChatContent"' 
						+ 'id="' + v.chatc_code + '">';
					cont += '<p>' + v.chatc_cnt + '</p>';
					cont += '</li>';
				}
			}
		});
		cont += '</ul>';
	}
	else {
		cont += "<p>내용이 없습니다.</p>";
	}
	$('#div_dep4_2').html(cont);
	$("#div_dep4_2").scrollTop($(document).height());
}

/* 채팅 읽음 처리 */
function processChatRead(read) {
	var chatr_code = $(read).attr('id');
	$.ajax({
		url : '/oimarket/chat/processChatRead.do',
		type : 'post',
		data : {"chatr_code" : chatr_code, "mem_id" : login_user_id},
		dataType : 'json',
		success : function(data) {
			if(data.sw == "ok")
				$('#span_chatRoom_unread' + (chatr_code)).html(''); // 읽지 않은 문자 표시 삭제
		},
		error : function(xhr) {
			alert("조회수 읽음 처리 에러 : " + xhr.status);
		}
	})
}

/* 약속 일자 등록 */
function registerPromDate() {
	// 필요한 데이터
	$.ajax({
		url : '/oimarket/chat/registerPromDate.do',
		type : 'get',
		data : {'date' : today_date_time,
					'chatr_code' : chatRoomInfo.chatr_code},
		dataType : 'json',
		success : function(data) {
			alert('약속 일정을 등록하였습니다.');
		},
		error : function(xhr) {
			alert("약속잡기 등록 에러 : " + xhr.status);
		}
	})
}

/* 채팅 목록 클릭하면 나타나면 메뉴 숨기기 */
function hidePartnerInfo() {
	$('#img_profile').hide();
	$('#partner_nick').hide();
	$('#partner_temp').hide();
	$('#btn_prom').hide();
	$('#btn_depo').hide();
}
/* 채팅 목록 클릭하면 나타나면 메뉴 표시하기 */
function showPartnerInfo() {
	$('#img_profile').show();
	$('#partner_nick').show();
	$('#partner_temp').show();
	$('#btn_prom').show();
	$('#btn_depo').show();
}

/* [약속잡기] 버튼 클릭 시 */
function openPromiseModal() {
	if($('#prom_check').val() == "N") {
		var today = new Date();
		today.setHours(today.getHours() + 9);
		prom_date = today.toISOString().slice(0, 10); // YYYY-MM-DD
		prom_time = today.toISOString().slice(11, 16); // HH:MM
		$('#prom_date').val(prom_date);
		$('#prom_time').val(prom_time);
		
		$('#prom_date').attr('disabled', false);
		$('#prom_time').attr('disabled', false);
		
		$('#prom_register').show();
		$('#prom_modify').hide();
		$('#prom_delete').hide();
	}
	else {
		$('#prom_date').val(prom_date); // 등록 일정 표시
		$('#prom_time').val(prom_time); // 등록 일정 표시
		
		$('#prom_date').attr('disabled', true);
		$('#prom_time').attr('disabled', true);
		
		$('#prom_register').hide();
		$('#prom_modify').show();
		$('#prom_delete').show();
	}
}

/* 약속 등록 */
function registerPromise() {
	// 약속 등록 : 모달 끄기, 툴팁 생성하기, 등록 버튼 숨기고 삭제, 수정 버튼 생성
	prom_date = $('#prom_date').val();
	prom_time = $('#prom_time').val();
	str_prom_date = prom_date.replaceAll('-', '');
	str_prom_time = prom_time.replaceAll(':', '');
	
	sendData.chatr_code = chatRoomInfo.chatr_code; // 채팅방 코드
	sendData.promise = str_prom_date + str_prom_time; // 약속 일정(YYYYMMDDHHMI)
	
	$.ajax({
		url : '/oimarket/chat/registerPromise.do',
		type : 'get',
		data : sendData,
		dataType : 'json',
		success : function(data) {
			if(data.result == '1') { // 약속 등록 성공
				$('#modal_promise').modal('hide');
				$('#btn_prom').attr('title', $('#prom_date').val() + ' ' + $('#prom_time').val()); // tooltip 추가
				$('#prom_check').val("Y"); // 약속 등록 성공 표시
				
				$('#prom_date').attr('disabled', true); // 날짜 수정 불가능 설정
				$('#prom_time').attr('disabled', true); // 시간 수정 불가능 설정
			}
			else {
				alert('약속잡기 등록에 실패하였습니다.');
			}
		},
		error : function(xhr) {
			alert("약속잡기 등록 에러 : " + xhr.status);
		}
	})
}

/* [약속잡기]에서 [수정] 버튼 클릭 시 */
function openPromModify() {
	// 날짜/시간 활성화, 등록 버튼 show, 수정,삭제 버튼 hide 
	$('#prom_register').show();
	$('#prom_modify').hide();
	$('#prom_delete').hide();
	
	$('#prom_date').attr('disabled', false);
	$('#prom_time').attr('disabled', false);
}

/* 약속잡기에서 [삭제] 버튼 클릭 시 */
function deletePromise() {
	// DB 데이터 삭제
	sendData.chatr_code = chatRoomInfo.chatr_code; // 채팅방 코드
	$.ajax({
		url : '/oimarket/chat/deletePromise.do',
		type : 'get',
		data : sendData,
		dataType : 'json',
		success : function(data) {
			if(data.result == '1') {
				$('#btn_prom').attr('title', '등록된 일정이 없습니다.'); // tooltip 문구 수정
				$('#prom_check').val("N"); // 약속 등록 없음 표시
				$('#modal_promise').modal('hide');
				
				// date, time 활성화 + 현재시각 넣기, 등록 버튼 보이기
				$('#prom_register').show();
				
			}
			else {
				alert("등록된 약속 일정 삭제에 실패하였습니다.");
			}
		},
		error : function(xhr) {
			alert("약속잡기 삭제 에러 : " + xhr.status);
		}
	})
}

/* [약속잡기]에 툴팁 표시 */
function showRegisteredPromise() {
	chatr_code = chatRoomInfo.chatr_code;
	
	$.ajax({
		url : '/oimarket/chat/getRegisteredPromise.do',
		type : 'get',
		data : {'chatr_code' : chatr_code},
		dataType : 'json',
		success : function(data) {
			if(data.date != null) {
				$('#btn_prom').attr('title', data.date);
				$('#prom_check').val("Y"); // 등록된 약속 있음 표시
				prom_date = data.date.slice(0, 10);
				prom_time = data.date.slice(11, 16);
			}
			else {
				$('#btn_prom').attr('title', '등록된 일정이 없습니다.');
				$('#prom_check').val("N"); // 등록된 약속 없음 표시
			}
		},
		error : function(xhr) {
			alert("약속잡기 삭제 에러 : " + xhr.status);
		}
	})
}

/* 상대방 아이디 찾기 */
function getPartnerId() {
	var temp_seller_id = $('#seller_id_' + chatRoomInfo.chatr_code).val();
	if(login_user_id == temp_seller_id) { // 내가 판매자라면 구매자가 상대방
		return $('#buyer_id_' + chatRoomInfo.chatr_code).val();
	}
	else { // 내가 구매자라면 판매자가 상대방
		return $('#seller_id_' + chatRoomInfo.chatr_code).val();
	}
} 

/* 선택한 채팅방 상단에 상대방 정보 표시 */
function getPartnerInfo() {
	showPartnerInfo();
	
	/* 상대방 아이디 찾기 */
	var partner_id = getPartnerId();
	
	$.ajax({
		url : '/oimarket/chat/getMemberInfo.do',
		type : 'get',
		data : {'partner_id' : partner_id},
		dataType : 'json',
		success : function(data) {
			if(data.isExist == "Y") { // 사용자 존재 시
				// TODO : 프로필사진 표시
				$('#partner_nick').html(data.info.mem_nick);
				$('#partner_temp').html(data.info.mem_temp);	
			}
		},
		error : function(xhr) {
			alert("상대방 프로필 정보 표시 에러 : " + xhr.status);
		}
	})
}