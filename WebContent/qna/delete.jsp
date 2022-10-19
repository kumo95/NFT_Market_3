<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnA 삭제 페이지</title>
<link rel="stylesheet" type="text/css" href="qna/style.css">
</head>
<body>
<h2>QnA 삭제 페이지</h2>
<div id="list">

<h4 align="center"><small>[QnA 삭제]</small></h4>
<form action="../deleteQna.do" method="post">
	<table class="list">
			<tr>
				<th>번호</th>
				<td>${qna.bno}</td>
			</tr>
			<tr>	
				<th>작성자</th>
				<td>${qna.userid}</td>
			</tr>
			<tr>	
				<th>내용</th>
				<td>${qna.content}</td>
			</tr>	
			<tr>	
				<th>파일</th>
				<td>${qna.files}</td>
			</tr>	
			<tr>	
				<th>조회수</th>
				<td>${qna.count}</td>
			</tr>		
			<tr>	
				<th>작성일</th>
				<td>${qna.writeDate}</td>
			</tr>
	</table>
	<input type="hidden" name="bno" value="${qna.bno}">
	<input type="submit" value="삭제">
	<input type="button" value="목록" onclick="location.href='qnaList.bdo'">
	</form>
</div>
</body>
</html>