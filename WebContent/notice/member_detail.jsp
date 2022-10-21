<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 상세페이지</title>
<link rel="stylesheet" type="text/css" href="notice/style.css">
</head>
<body>
<form action="noticeDetail.do" method="post">
	<table class="list">
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
	<input type="button" value="목록" onclick="location.href='noticeList.do'">
</form>
</body>
</html>
