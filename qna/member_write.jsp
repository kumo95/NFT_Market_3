<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<title>QnA 작성 페이지</title>
</head>
<body>
<jsp:include page="header.jsp"/>
	<h4 align="center"><small>[1대1문의 하기]</small></h4>
	<!-- <form action="../qnaWrite.do" method="post"  name="frm" enctype="multipart/form-data"> -->
	<form method="post" name="frm" enctype="multipart/form-data">
		<!-- 답변글 처리 페이지로 자료를 전달 -->
		<table class="table table-bordered">
			<tr>
				<th class="text-center">작성자</th>
				<td><input type="text" name="userid" class="form-control"></td>
			</tr>
			<tr>
				<th class="text-center">제목</th>
				<td><input type="text" name="title" class="form-control"></td>
			</tr>
			<tr>
				<th class="text-center">내용</th>
				<td><textarea class="form-control" placeholder="내용을 입력하세요."></textarea></td>
			</tr>
			<tr>
				<th class="text-center">파일</th>
				<td><input type="file" name="files"></td>
			</tr>
			
			<!-- form에서 사용자로부터 입력 받지 않고 데이터를 넘김 -->
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="등록">
					<input type="reset" value="취소" >
					<input type="button" value="목록" onclick="location.href='../qnaList.do'">
				</td>
			</tr>

		</table>
	</form>
</body>
</html>