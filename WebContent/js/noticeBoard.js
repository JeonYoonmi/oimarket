/**
 * 
 */

listServer = function() {
	$.ajax({
		url : '/midPro/noticeList.do',
		type : 'get',
		success : function(res) {                  
			code = '<div class="container">';
  			code += '<div class="panel-group" id="accordion">';
	
			$.each(res, function(i, v) {
				 code += '<div class="panel panel-default">';
     			 code += '<div class="panel-heading">';
      			 code += '<h4 class="panel-title">';
        		 code += '<a data-toggle="collapse" data-parent="#accordion" href="#collapse' + v.notice_code + '"><span class="spanCode">'+ v.notice_code + '</span>&nbsp;&nbsp;&nbsp;' + v.notice_title + '</a>';
       			 code += '</h4>';
      		 	 code += '</div>';
      			 code += '<div id="collapse' + v.notice_code + '" class="panel-collapse collapse">';
      			 code += '<div class="panel-body">' + v.notice_cnt + '</div>';
     		     code += '</div>';
    			 code += '</div>';
			})
			
			code += '</div></div>';
			
			$('#d1').html(code);
		},
		error : function(xhr) {
			alert(xhr.status);
		},
		dataType : 'json'
	})
}