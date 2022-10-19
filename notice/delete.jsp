<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<meta charset="UTF-8">

<title>공지사항 삭제 페이지</title>
<link rel="stylesheet" type="text/css" href="notice/style.css">
</head>
<body>
<jsp:include page="header.jsp"/>
	<h4 align="center"><small>[공지사항 삭제]</small></h4>
	<form action="../deletNotice.do" method="post">
		<table class="table table-bordered">
			<tr>
				<th>번호</th>
				<td>${notice.no}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${notice.title}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${notice.content}</td>
			</tr>
			<tr>
				<th>파일</th>
				<td>${notice.files}</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td>${notice.writeDate}</td>
			</tr>
		</table>
		<input type="hidden" name="no" value="${notice.no}"> 
		<input type="submit" value="삭제"> 
		<input type="button" value="목록" onclick="location.href='../noticeList.do'">
	</form>
</body>
</html>