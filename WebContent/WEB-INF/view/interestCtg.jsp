<%@page import="kr.co.oi.VO.CategoryVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <link rel="stylesheet" href="css/interestCtg.css">
<title>Insert title here</title>
 <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script> 
  
   <script src = "../js/category.js"></script> 
  <script src = "../js/jquery.serializejson.min.js"></script>

<script type="text/javascript">


 $(function(){
 	$('#but').on('click', function(){
  		arr = [];
 		checkCount = $("input[name=ctg]:checked");
 		$(checkCount).each(function(){
 			arr.push($(this).val());
 		})
 		alert(arr); 
		
 		if(arr < 1){
 			alert("1개 이상 선택해주세요");
 		}else{
 			insertInterstCtg();
 		}
		
		
 	})
 	
/*   	$('.category').change(function(){
 		if($('.category').is(':checked')){
 			alert("체크박스 체크했음!");
 			//deleteInterstCtg();
 			
 		}
 	})  */
	
 	
 })
 

</script>
</head>
<jsp:include page="../include/myPageHeader.jsp"></jsp:include>
<body>
<% 
	List<CategoryVO> list = (List<CategoryVO>)request.getAttribute("listValue");
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
		
		if(list.get(i).getCtg_code().equals("1")){
			chk1 = "checked";
 		}else if(list.get(i).getCtg_code().equals("2")){
 			chk2 = "checked";
 		}else if(list.get(i).getCtg_code().equals("3")){
 			chk3 = "checked";
 		}else if(list.get(i).getCtg_code().equals("4")){
 			chk4 = "checked";
 		}else if(list.get(i).getCtg_code().equals("5")){
 			chk5 = "checked";
 		}else if(list.get(i).getCtg_code().equals("6")){
 			chk6 = "checked";
 		}else if(list.get(i).getCtg_code().equals("7")){
 			chk7 = "checked";
 		}else if(list.get(i).getCtg_code().equals("8")){
 			chk8 = "checked";
 		}else if(list.get(i).getCtg_code().equals("9")){
 			chk9 = "checked";
 		}else if(list.get(i).getCtg_code().equals("10")){
 			chk10 = "checked";
 		}else if(list.get(i).getCtg_code().equals("11")){
 			chk11 = "checked";
 		}else if(list.get(i).getCtg_code().equals("12")){
 			chk12 = "checked";
 		}else if(list.get(i).getCtg_code().equals("13")){
 			chk13 = "checked";
 		}else if(list.get(i).getCtg_code().equals("14")){
 			chk14 = "checked";
		}else if(list.get(i).getCtg_code().equals("15")){
			chk15 = "checked";
		}else if(list.get(i).getCtg_code().equals("16")){
			chk16 = "checked";
		}
	}
 	
 	
%>
<div id = "realBody">
<div id = "dparent">
	<br><br>
	<h2>관심카테고리 설정</h2>
	<hr>
	<div>
		<div id = "ctg1">
			<img class='ctgimg' alt="디지털기기.png" src="<%=request.getContextPath()%>/images/디지털기기.png"><br>
			<label class = "label"><input type = "checkbox" value="1" class = "category" name="ctg" <%= chk1 %> >디지털기기</label>
		</div>
		<div id = "ctg2">
			<img class='ctgimg' alt="생활가전.png" src="<%=request.getContextPath()%>/images/생활가전.png"><br>
			<label class = "label"><input type = "checkbox" value="2" class = "category" name="ctg" <%= chk2 %>>생활가전</label>
		</div>
		<div id = "ctg3">
			<img class='ctgimg' alt="가구인테리어.png" src="<%=request.getContextPath()%>/images/가구인테리어.png"><br>
			<label class = "label"><input type = "checkbox" value="3" class = "category" name="ctg" <%= chk3 %>>가구인테리어</label>
		</div>
		<div id = "ctg4">
			<img class='ctgimg' alt="유아동.png" src="<%=request.getContextPath()%>/images/유아동.png"><br>
			<label class = "label"><input type = "checkbox" value="4" class = "category" name="ctg" <%= chk4 %>>유아동</label>
		</div>
	</div>
	
	<div>
		<div id = "ctg5">
			<img class='ctgimg' alt="유아도서.png" src="<%=request.getContextPath()%>/images/유아도서.png"><br>
			<label class = "label"><input type = "checkbox" value="5" class = "category" name="ctg" <%= chk5 %>>유아도서</label>
		</div>
		<div id = "ctg6">
			<img class='ctgimg' alt="생활가공식품.png" src="<%=request.getContextPath()%>/images/생활가공식품.png"><br>
			<label class = "label"><input type = "checkbox" value="6" class = "category" name="ctg" <%= chk6 %>>생활가공식품</label>
		</div>
		<div id = "ctg7">
			<img class='ctgimg' alt="스포츠레저.png" src="<%=request.getContextPath()%>/images/스포츠레저.png"><br>
			<label class = "label"><input type = "checkbox" value="7" class = "category" name="ctg" <%= chk7 %>>스포츠레저</label>
		</div>
		<div id = "ctg8">
			<img class='ctgimg' alt="여성잡화.png" src="<%=request.getContextPath()%>/images/여성잡화.png"><br>
			<label class = "label"><input type = "checkbox" value="8" class = "category" name="ctg" <%= chk8 %>>여성잡화</label>
		</div>
	</div>
	
	<div>
		<div id = "ctg9">
			<img class='ctgimg' alt="여성의류.png" src="<%=request.getContextPath()%>/images/여성의류.png"><br>
			<label class = "label"><input type = "checkbox" value="9" class = "category" name="ctg" <%= chk9 %>>여성의류</label>
		</div>
		<div id = "ctg10">
			<img class='ctgimg' alt="남성패션잡화.png" src="<%=request.getContextPath()%>/images/남성패션잡화.png"><br>
			<label class = "label"><input type = "checkbox" value="10" class = "category" name="ctg" <%= chk10 %>>남성패션잡화</label>
		</div>
		<div id = "ctg11">
			<img class='ctgimg' alt="게임취미.png" src="<%=request.getContextPath()%>/images/게임취미.png"><br>
			<label class = "label"><input type = "checkbox" value="11" class = "category" name="ctg" <%= chk11 %>>게임취미</label>
		</div>
		<div id = "ctg12">
			<img class='ctgimg' alt="뷰티미용.png" src="<%=request.getContextPath()%>/images/뷰티미용.png"><br>
			<label class = "label"><input type = "checkbox" value="12" class = "category" name="ctg" <%= chk12 %>>뷰티미용</label>
		</div>
	</div>
	
	<div>
		<div id = "ctg13">
			<img class='ctgimg' alt="반려동물용품.png" src="<%=request.getContextPath()%>/images/반려동물용품.png"><br>
			<label class = "label"><input type = "checkbox" value="13" class = "category" name="ctg" <%= chk13 %>>반려동물용품</label>
		</div>
		<div id = "ctg14">
			<img class='ctgimg' alt="도서티켓음반.png" src="<%=request.getContextPath()%>/images/도서티켓음반.png"><br>
			<label class = "label"><input type = "checkbox" value="14" class = "category" name="ctg" <%= chk14 %>>도서티켓음반</label>
		</div>
		<div id = "ctg15">
			<img class='ctgimg' alt="식물.png" src="<%=request.getContextPath()%>/images/식물.png"><br>
			<label class = "label"><input type = "checkbox" value="15" class = "category" name="ctg" <%= chk15 %>>식물</label>
		</div>
		<div id = "ctg16">
			<img class='ctgimg' alt="기타중고물품.png" src="<%=request.getContextPath()%>/images/기타중고물품.png"><br>
			<label class = "label"><input type = "checkbox" value="16" class = "category" name="ctg" <%= chk16 %>>기타중고물품</label>
		</div>
	</div>
	<button type="button" class="btn btn-outline-success" id = "but">선택완료</button>
</div>
</div>
</body>
</html>