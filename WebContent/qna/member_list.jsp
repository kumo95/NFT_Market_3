<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원들이 보는 QnA 리스트</title>
<link rel="stylesheet" type="text/css" href="qna/style.css">
</head>
<body>
<h2 align="center">[QnA 목록]</h2>
<div>	
	<table class="list">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>내용</th>
			<th>파일</th>
			<th>작성일</th>
		</tr>
		<!-- 게시글 목록 출력 -->
		<c:forEach var="qna" items="${qnaList}">
			<tr>
				<td>${qna.no}</td>
				<td><a href="qna?no=${qna.no}">${qna.title}</a></td>
				<td>${qna.content}</td>
				<td>${qna.files}</td>
				<td>${qna.writeDate}</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>