<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>공지사항 글쓰기</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css"
	rel="stylesheet" />
<link href="styles.css" rel="stylesheet" type="text/css">
<script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js"
	crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="../index/css/header.css">		
</head>
<body>
<jsp:include page="../header.jsp"/>
	<h4 align="center"><small>[공지사항 글쓰기]</small></h4>
			<form action="noticeWrite.do" method="post" name="frm" enctype="multipart/form-data">
				<table class="table table-bordered">
					<tr>
						<th class="text-center">작성자</th>
						<td>[관리자]</td>
					</tr>
					<tr>
						<th class="text-center">제목</th>
						<td><input type="text" name="title" value="[공지]" class="form-control"></td>
					</tr>
					<tr>
						<th class="text-center">내용</th>
						<td><textarea class="form-control" name="content"
								placeholder="내용을 입력하세요."></textarea></td>
					</tr>
					<tr>
						<th class="text-center">파일 첨부</th>
						<td><input type="file" name="files"></td>
					</tr>
					<tr>
						<th class="text-center">등록일자</th>
						<td><input class="form-control" type="text" name="writeDate"
							placeholder="2022-10-13"></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<input type="submit" value="등록"> 
							<input type="reset" value="취소"> 
							<input type="button" value="목록" onclick="location.href='noticeList.do'">
						</td>
					</tr>
				</table>
			</form>
<jsp:include page="../footer.jsp"/>
</body>
</html>