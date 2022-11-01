insertInterstCtg = function(){
   $.ajax({
      url : '/midProject/insertItrstCtg.do',
      data : {"arr" : arr},
      type : 'post',
      success : function(res){
         alert("성공");
      },
      error : function(xhr){
         alert("상태 : " + xhr.status);
      },
      dataType : 'json'
   })
}