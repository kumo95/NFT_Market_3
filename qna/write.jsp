<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>1대1문의 게시판 글쓰기</title>
</head>
<body>

<!--  게시판 글쓰기 영역 시작 -->
<div align="center">
	<h3>[1대1문의 글쓰기]</h3>
	<!-- <form action="qnaWrite.do" method="post" enctype="multipart/form-data"> -->
	<form method="post" name="frm" enctype="multipart/form-data">
	<!-- enctype : 파일 첨부할때 필요한 속성 -->
		<table border="1">
			<tr>
				<th>작성자</th>
				<td><input type="text" name="userid"></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="15" cols="70" name="content" placeholder="내용을 입력하세요."></textarea></td>
			</tr>
			<tr>
				<th>파일 첨부</th>
				<td><input type="file" name="files"></td>
			</tr>
			<tr>
				<th>등록일자</th>
				<td><input type="text" name="writeDate" placeholder="2022-10-10"> (예시) 2022-10-10</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="등록">
					<input type="reset" value="취소" >
					<input type="button" value="목록" onclick="location.href='qnaList.do'">
				</td>
			</tr>
		</table>
	</form>
</div>

</body>
</html>	