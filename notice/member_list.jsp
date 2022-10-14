<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원들이 보는 공지사항 목록</title>
<link rel="stylesheet" type="text/css" href="notice/style.css">
</head>
<body>
<h3>[공지사항 목록]</h3>
	<table class="list">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>내용</th>
			<th>사진</th>
			<th>작성일</th>
		</tr>

		<c:forEach var="notice" items="${noticeList}">
			<tr>
				<td>${notice.no}</td>
				<td><a href="noticeDetail.do?no=${notice.title}"></a></td>
				<td>${notice.content}</td>
				<td>${notice.files}</td>
				<td>${notice.writeDate}</td>
		</c:forEach>
	</table>
</body>
</html>