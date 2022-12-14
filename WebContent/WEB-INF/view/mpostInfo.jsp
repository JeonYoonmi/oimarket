<%@page import="kr.co.oi.VO.ZzimVO"%>
<%@page import="kr.co.oi.VO.MemberVO"%>
<%@page import="kr.co.oi.VO.MpostImgVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.oi.VO.MpostVO"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/mpostinfo.css">
<title>Insert title here</title>

<%
	MemberVO vo = (MemberVO)session.getAttribute("memberVO");
	String mem_id = "no";
	if(vo!=null){
		mem_id = vo.getMem_id();
	}
	
	int chatcnt = (int)request.getAttribute("chatcnt");
	int zzimcnt = (int)request.getAttribute("zzimcnt");
	List<MpostImgVO> imgvoList = (List<MpostImgVO>)request.getAttribute("imgvo");
	List<Map<String, Object>> list = (List<Map<String, Object>>)request.getAttribute("mpost");
	
	String chk1 = "";
	String chk2 = "";
	String chk3 = "";
	String chk4 = "";
	String chk5 = "";
	String chk6 = "";
	String chk7 = "";
	String chk8 = "";
	String chk9 = "";
	String chk10 = "";
	String chk11 = "";
	String chk12 = "";
	String chk13 = "";
	String chk14 = "";
	String chk15 = "";
	String chk16 = "";

	for(int i=0; i<list.size(); i++){	
		
	if(list.get(0).get("CTG_CODE").equals("1")){
		chk1 = "selected";
		}else if(list.get(0).get("CTG_CODE").equals("2")){
			chk2 = "selected";
		}else if(list.get(0).get("CTG_CODE").equals("3")){
			chk3 = "selected";
		}else if(list.get(0).get("CTG_CODE").equals("4")){
			chk4 = "selected";
		}else if(list.get(0).get("CTG_CODE").equals("5")){
			chk5 = "selected";
		}else if(list.get(0).get("CTG_CODE").equals("6")){
			chk6 = "selected";
		}else if(list.get(0).get("CTG_CODE").equals("7")){
			chk7 = "selected";
		}else if(list.get(0).get("CTG_CODE").equals("8")){
			chk8 = "selected";
		}else if(list.get(0).get("CTG_CODE").equals("9")){
			chk9 = "selected";
		}else if(list.get(0).get("CTG_CODE").equals("10")){
			chk10 = "selected";
		}else if(list.get(0).get("CTG_CODE").equals("11")){
			chk11 = "selected";
		}else if(list.get(0).get("CTG_CODE").equals("12")){
			chk12 = "selected";
		}else if(list.get(0).get("CTG_CODE").equals("13")){
			chk13 = "selected";
		}else if(list.get(0).get("CTG_CODE").equals("14")){
			chk14 = "selected";
		}else if(list.get(0).get("CTG_CODE").equals("15")){
			chk15 = "selected";
		}else if(list.get(0).get("CTG_CODE").equals("16")){
			chk16 = "selected";
		}
	}
%>

<script>
$(function(){
	$.ajax({
		url : '/oimarket/checkZzim.do',
		data : { "mpost_code" : "<%= list.get(0).get("MPOST_CODE") %>",
				 "buyer_id" : "<%=mem_id %>"
				},
		type : 'post',
		success : function(res){
			if( res.zzim_code != null){
				$('#zzimbtn').attr('src', '<%= request.getContextPath() %>/images/zzim.png');
			}else{
				$('#zzimbtn').attr('src', '<%= request.getContextPath() %>/images/nozzim.png');
			}
		},
		error : function(xhr){
			alert("?????? : " + xhr.status);
		},
		dataType : 'json'
	})
	
	$('#zzimbtn').on('click', function(){
		if('<%=mem_id %>' == 'no'){
			alert("????????? ??? ?????????????????????.");
			return false;
		}
		if($('#zzimbtn').attr('src') == "<%= request.getContextPath() %>/images/nozzim.png"){
			$.ajax({
				url : '/oimarket/zzim.do',
				data : { "buyer_id" : "<%=mem_id %>",
						 "mpost_code" : "<%= list.get(0).get("MPOST_CODE") %>",
						 "seller_id" : "<%= list.get(0).get("SELLER_ID") %>",
						 "zzim_dlng" : "<%= list.get(0).get("MPOST_DLNG") %>"
						},
				type : 'get',
				success : function(res){
					$('#zzimbtn').attr('src', '<%= request.getContextPath() %>/images/zzim.png');
					zzim = parseInt($('#zzim').text().replace("?????? ", "").trim());
					$('#zzim').text("?????? " + (zzim+1));
				},
				error : function(xhr){
					alert("?????? : " + xhr.status);
				},
				dataType : 'text'
			})
			
		}else{
			$.ajax({
				url : '/oimarket/zzim.do',
				data : { "mpost_code" : "<%= list.get(0).get("MPOST_CODE") %>",
						 "buyer_id" : "<%=mem_id %>"
						},
				type : 'post',
				success : function(res){
					$('#zzimbtn').attr('src', '<%= request.getContextPath() %>/images/nozzim.png');
					zzim = parseInt($('#zzim').text().replace("?????? ", "").trim());
					$('#zzim').text("?????? " + (zzim-1));
				},
				error : function(xhr){
					alert("?????? : " + xhr.status);
				},
				dataType : 'text'
			})
			
			
		}
	})
	
	$('#chatbtn').on('click', function(){
		if('<%=mem_id %>' == '') {
			alert("????????? ??? ?????????????????????.");
			return false;
		}else{
			$.ajax({
				url : '/oimarket/chat/chatPage.do',
				data : { 'mpost_code' : '<%= list.get(0).get("MPOST_CODE") %>',
						 'seller_id' : '<%= list.get(0).get("SELLER_ID") %>',
						 'buyer_id' : '<%=mem_id %>'
						},
				type : 'post',
				success : function(res){
					$('#chatform').submit();
				},
				error : function(xhr){
					alert("?????? : " + xhr.status);
				},
				dataType : 'text'
			})
		}
		
	})
	
	$('#modify').on('click', function(){
		$.ajax({
			url : '/oimarket//modifyNdelete.do',
			data : { 'mpost_code' : '<%= list.get(0).get("MPOST_CODE") %>',
						 'mpost_title' : $('#mpostTitle').val(),
						 'mpost_ctg' : $('#ctgChoiceList option:selected').val(),
						 'mpost_price' : $('#mpostPrice').val(),
						 'mpost_cnt' : $('#mpostCnt').val()
					},
			type : 'post',
			success : function(res){
				$('#modifyModal').modal('hide');
				alert("????????? ?????????????????????.");
				$('#mpostCnt').val().replace(/\r/g, "").replace(/\n/g, "<br>");
			},
			error : function(xhr){
				alert("?????? : " + xhr.status);
			},
			dataType : 'text'
		})
	})
})

</script>
</head>
<jsp:include page="../include/header.jsp"></jsp:include>
<body>
<link rel="stylesheet" href="https://unpkg.com/swiper@8/swiper-bundle.min.css" />
<script src="https://unpkg.com/swiper@8/swiper-bundle.min.js"></script>
<br><br>
<%
	if(imgvoList != null && imgvoList.size() != 0){
		if(imgvoList.size() > 1){
%>
<!-- swiper start -->
<div class="swiper">
	<div class="swiper-wrapper">
	<%
	for(int i = 0; i < imgvoList.size(); i++){
		String id = "slide-" + i;
	%>
		<div class="swiper-slide">
			<img class="imgslide" src="<%= imgvoList.get(i).getMpostimg_url() %>">
		</div>
	<%} %>
	</div>
	<div class="swiper-pagination"></div>
	<div class="swiper-button-prev"></div>
	<div class="swiper-button-next"></div>
</div>
<script>
let swiper = new Swiper('.swiper', {
	direction: 'horizontal',
	loop: true,
	pagination: {
		el: '.swiper-pagination',
		clickable: true
	},
	navigation: {
		nextEl: '.swiper-button-next',
		prevEl: '.swiper-button-prev'
	}
});
</script>
<style>
.swiper {
	width: 600px; 
	height: 300px;
}
	
.swiper-button-next, .swiper-button-prev {
	color: var(--swiper-navigation-color,var(--green));
	}
	
.swiper-pagination-bullet-active {
	background-color: var(--swiper-pagination-color,var(--green));
}
</style>
<!-- swiper end -->
<%
		}else if(imgvoList.size() == 1){
%>
		<div id="imgsdiv">
			<img class="imgs" src="<%= imgvoList.get(0).getMpostimg_url() %>">
		</div>
<%

		}
	}else{
%>
		<div id="imgsdiv">
			<img class="imgs" src="<%= request.getContextPath() %>/images/noimage.png">
		</div>
<%
	}
%>
	<br><br>
	<hr>
	<div id="sellerinfo">
<%
 	if(list.get(0).get("MEM_URL") == null){
%>
		<img id="profile" src="<%= request.getContextPath() %>/images/default_profile.png">
		<p id="seller">
			<%= list.get(0).get("MEM_NICK") %><br>
			<%= list.get(0).get("MEM_ADDR1") %>
		</p>
<%
 	}else{
%>
		<img src=""><p><%= list.get(0).get("MEM_NICK") %><%= list.get(0).get("MEM_ADDR1") %></p>
<%
  	}
%>
	</div>
<%
	double temp = Double.parseDouble(String.valueOf(list.get(0).get("MEM_TEMP")));
	String color = "";
	String imgName = "";
	String fontColor = "";
	
	if(temp <= 32) {
		imgName = "under32.png";
		color = " bg-dark";
		fontColor = "#000033";
	}else if(temp <= 36.5) {
		imgName = "ok.png";
		fontColor = "blue";
	}else if(temp <= 40) {
		imgName = "good.png";
		color = " bg-success";
		fontColor = "green";
	}else if(temp <= 50) {
		imgName = "better.png";
		color = " bg-warning";
		fontColor = "orange";
	}else {
		imgName = "best.png";
		color = " bg-danger";
		fontColor = "red";
	}
%>
		<div id = "tempShow">
			<img id='tempImg' src='<%=request.getContextPath()%>/images/<%=imgName%>'>
			<p id='tempValue' style="color:<%=fontColor%>"><%=temp%>???</p>
			<div class="progress">
	   			<div class="progress-bar<%=color %>" style="width:<%=temp%>%"></div>
	 		</div>
		</div><br><hr>
		
	<div id="content">
		<h5 id="title"><%= list.get(0).get("MPOST_TITLE") %></h5>
		<p id="ctgnm"><%= list.get(0).get("CTG_NM") %></p>
<%
	String modify = "";
	if(list.get(0).get("MPOST_MDF") != null){
		modify = " (?????????)";
	}
%>
		<p id="time"><%= list.get(0).get("MPOST_CRT") %><%= modify %></p>
<%
		if(Integer.parseInt(String.valueOf(list.get(0).get("MPOST_DLNG"))) == 1){
%>
			<p id="price">?????? ??????</p>
<%
		}else{
%>
			<p id="price"><%= list.get(0).get("MPOST_PRICE") %>???</p>
<%		
		}

		String cnt = String.valueOf(list.get(0).get("MPOST_CNT"));
		cnt = cnt.replace("\n", "<br>");
		cnt = cnt.replace("\r", "");
%>
		<p><%= cnt %></p>
		<p id="zzim" class="res">?????? <%= zzimcnt %></p>
		<p class="res">?????? <%= chatcnt %></p>
		<p class="res">?????? <%= list.get(0).get("MPOST_HIT") %></p>
	</div>
<%
	if(mem_id.equals(list.get(0).get("SELLER_ID"))){
%>
		<div id="modifyNdelete">
			<a href="" data-toggle="modal" data-target="#modifyModal">??????</a><a href="<%= request.getContextPath() %>/modifyNdelete.do?mpost_code=<%= list.get(0).get("MPOST_CODE") %>">??????</a>
			</div>
<%
	}
%>
	<br>
	<input type="image" id="zzimbtn" src="<%= request.getContextPath() %>/images/nozzim.png">
	<input id="chatbtn" type="submit" class="btn btn-success" value="????????????">
	<form action="<%= request.getContextPath() %>/chat/chatPage.do" method="get" id="chatform">
		<input type="hidden">
	</form>
	<br><br>
	
	<!-- The Modal -->
	<div class="modal" id="modifyModal">
    <div class="modal-dialog">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">??? ??????</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
	        <div class="modal-body">
	          <label for="title">??? ??????</label>
				<input type="text" class="mpostwrite" id="mpostTitle" placeholder="????????? ??????????????????" name="mpost_title" value="<%= list.get(0).get("MPOST_TITLE") %>">
				<br><br>
				
				<label id="ctgChoice">???????????? ??????</label>
					<select name="ctg_code" id="ctgChoiceList">
						<option value="1" <%= chk1 %>>???????????????</option>
						<option value="2" <%= chk2 %>>????????????</option>
						<option value="3" <%= chk3 %>>??????/????????????</option>
						<option value="4" <%= chk4 %>>?????????</option>
						<option value="5" <%= chk5 %>>????????????</option>
						<option value="6" <%= chk6 %>>??????/????????????</option>
						<option value="7" <%= chk7 %>>?????????/??????</option>
						<option value="8" <%= chk8 %>>????????????</option>
						<option value="9" <%= chk9 %>>????????????</option>
						<option value="10" <%= chk10 %>>????????????/??????</option>
						<option value="11" <%= chk11 %>>??????/??????</option>
						<option value="12" <%= chk12 %>>??????/??????</option>
						<option value="13" <%= chk13 %>>??????????????????</option>
						<option value="14" <%= chk14 %>>??????/??????/??????</option>
						<option value="15" <%= chk15 %>>??????</option>
						<option value="16" <%= chk16 %>>??????</option>
					</select>
				<br><br>
				
				<label for="price">??????</label>
				<input type="text" class="mpostwrite" id="mpostPrice" placeholder="????????? ??????????????????" name="mpost_price" value="<%= list.get(0).get("MPOST_PRICE") %>">???
				<br><br>
				
				<label for="picture">????????? ??????</label>
				<input type="file" class="mpostwrite" name="mpost_images" accept='image/*' multiple>
				<br><br>
				
				<label for="content">????????? ??????</label>
				<textarea rows="10" cols="50" id="mpostCnt" name="mpost_cnt" placeholder="?????? ??? ???????????? ????????? ????????? ????????? ??? ?????????!"><%= list.get(0).get("MPOST_CNT") %></textarea>
				<br><br>
	        </div>
        
        <!-- Modal footer -->
        <div class="modal-footer">
          <button type="button" class="btn btn-success" data-dismiss="modal">??????</button>
          <input type="submit" id="modify" class="btn btn-success" value="??????">
        </div>
        
      </div>
    </div>
  </div>
</body>
<jsp:include page="../include/footer.jsp"></jsp:include>
</html>