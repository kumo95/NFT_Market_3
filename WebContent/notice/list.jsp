<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 목록</title>
<link rel="stylesheet" type="text/css" href="notice/style.css">
</head>
<body>
<div>
	<h3>[공지사항 목록]</h3>
	<table class="list">
		<tr>
			<td colspan="7" style="border:white; text-align: right; padding: width:310px">
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
</div>
</body>
</html>