/**
 * 
 */

idCheck = function(){
	
	$.ajax({
			url : '/oimarket/idCheck.do',
			type : 'post',
			data : { "id" : id },
			success : function(res){
				if(res == "ok"){
					$('#id').css('border-color', 'blue');
					alert("사용가능한 아이디입니다.");
				}else{
					$('#id').css('border-color', 'red');
					alert("ID중복 - 사용불가능한 아이디입니다.");
				}
			},
			error : function(xhr){
				alert("상태 : " + xhr.status);
			},
			dataType : 'json'
		})
}

nickCheck = function(){
	$.ajax({
			url : '/oimarket/nickCheck.do',
			type : 'post',
			data : { "nick" : nick },
			success : function(res){
				if(res == "ok"){
					$('#id').css('border-color', 'blue');
					alert("사용가능한 닉네임입니다.");
				}else{
					$('#id').css('border-color', 'red');
					alert("닉네임중복 - 사용불가능한 닉네임입니다.");
				}
			},
			error : function(xhr){
				alert("상태 : " + xhr.status);
			},
			dataType : 'json'
		})
}

