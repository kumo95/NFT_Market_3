<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
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
<title>공지사항 목록</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h4 align="center"><small>[공지사항 목록]</small></h4>
	<table class="table table-bordered">
		<tr>
			<td>
				<a href="noticeWrite.do">공지사항 등록</a>
			</td>
		</tr>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>내용</th>
			<th>사진</th>
			<th>작성일</th>
			<th>관리</th>
		</tr>
		<c:forEach var="notice" items="${noticeList}">
			<tr>
				<td>${notice.no}</td>
				<td>${notice.title}</td>
				<td>${notice.content}</td>
				<td>${notice.files}</td>
				<td>${notice.writeDate}</td>
				<td><a href="deleteNotice.do?no=${notice.no}">삭제</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>