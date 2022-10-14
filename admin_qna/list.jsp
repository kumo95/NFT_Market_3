<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1대1문의 목록</title>
<link rel="stylesheet" type="text/css" href="admin_qna/style.css">
</head>
<body>
<h2 align="center">1대1문의 목록</h2>
<div>	
	<table class="list" align="center" border="1" width="80%">
		<tr height="10" align="center" bgcolor="lightgreen">
			<th>번호</th>
			<th>작성자</th>
			<th>이메일</th>
			<th>비밀번호</th>
			<th>제목</th>
			<th>내용</th>
			<th>파일</th>
			<th>작성일</th>
			<th>관리</th>
		</tr>
		<!-- 게시글 목록 출력 -->
		<c:forEach var="qna" items="${qnaList}">
			<tr>
				<td>${qna.no}</td>
				<td>${qna.userid}</td>
				<td>${qna.email}</td>
				<td>${qna.pass}</td>
				<td>${qna.title}</td>
				<td>${qna.content}</td>
				<td>${qna.files}</td>
				<td>${qna.writeDate}</td>
				<td><a href="deleteQna.do?no=${qna.no}">삭제</a></td>
			</tr>
		</c:forEach>
	</table>
</div>
 
</body>
</html>