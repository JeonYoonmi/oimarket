<%@page import="kr.co.oi.VO.MemberVO"%>
<%@page import="kr.co.oi.VO.MpostVO"%>
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
<title>오이마켓 매물 게시판 글쓰기</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style>
label{
	display: inline-block;
	width : 120px;
	height : 30px;
	float: left;
	margin-right: 30px;
}

.mpostwrite{
	width: 500px;
	height: 35px;
}

h2{
	text-align: center;
}
hr{
	width: 60%;
}
br{
	clear: both;
}

#ctgChoiceList{
	height: 35px;
}

#mpostCnt{
	width: 500px;
}

#mpostForm{
	margin-left: 30%;
	display: inline-block;
	width: 700px;
}

</style>
<script>
</script>
</head>
<jsp:include page="/WEB-INF/include/header.jsp"></jsp:include>
<body>
	<br><br>
		<h2>중고거래 글쓰기</h2>
		<br>
		<hr>
		<br>
		<form id="mpostForm" action="<%=request.getContextPath()%>/mpostWrite.do" method="post">
			<label for="title">글 제목</label>
			<input type="text" class="mpostwrite" id="mpostTitle" placeholder="제목을 입력해주세요" name="mpost_title">
			<br><br>
			
			<label id="ctgChoice">카테고리 선택</label>
				<select name="ctg_code" id="ctgChoiceList">
					<option value="1">디지털기기</option>
					<option value="2">생활가전</option>
					<option value="3">가구/인테리어</option>
					<option value="4">유아동</option>
					<option value="5">유아도서</option>
					<option value="6">생활/가공식품</option>
					<option value="7">스포츠/레저</option>
					<option value="8">여성잡화</option>
					<option value="9">여성의류</option>
					<option value="10">남성패션/잡화</option>
					<option value="11">게임/취미</option>
					<option value="12">뷰티/미용</option>
					<option value="13">반려동물용품</option>
					<option value="14">도서/티켓/음반</option>
					<option value="15">식물</option>
					<option value="16">기타</option>
				</select>
			<br><br>
			
			<label for="price">가격</label>
			<input type="text" class="mpostwrite" id="mpostPrice" placeholder="가격을 입력해주세요" name="mpost_price">원
			<br><br>
			
			<label for="picture">첨부할 사진</label>
			<input type="file" class="mpostwrite" name="mpost_images" accept='image/*' multiple>
			<br><br>
			
			<label for="content" style="vertical-align: top;">게시글 내용</label>
			<textarea rows="10" cols="50" id="mpostCnt" name="mpost_cnt" placeholder="가품 및 판매금지 품목은 게시가 제한될 수 있어요!"></textarea>
			<br><br>
			
			<input type="submit" id="mpostCreate" class="btn btn-success" value="글 등록">
		</form>
	<br><br>
</body>
<jsp:include page="/WEB-INF/include/footer.jsp"></jsp:include>
</html>