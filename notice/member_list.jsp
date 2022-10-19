<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원들이 보는 공지사항 목록</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h4 align="center"><small>[공지사항 목록]</small></h4>
	<table class="table table-bordered">
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
				<td><a href="notice?no=${notice.no}">${notice.title}</a></td>
				<td>${notice.content}</td>
				<td>${notice.files}</td>
				<td>${notice.writeDate}</td>
		</c:forEach>
	</table>
</body>
</html>