<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 글쓰기</title>
<link rel="stylesheet" type="text/css" href="notice/style.css">
</head>
<body>
<div align="center">
	<h3>[공지사항 글쓰기]</h3>
	<form method="post" name="frm" enctype="multipart/form-data">
		<table class="list">
			<tr>
				<th scope="row">제목</th>
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
				<td><input type="text" name="writeDate" placeholder="2022-10-13"> (예시) 2022-10-13</td>
			</tr>	
			
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="등록">
					<input type="reset" value="취소" >
					<input type="button" value="목록" onclick="location.href='noticeList.do'"/>
				</td>
			</tr>
		</table>
	
	</form>
</div>
</body>
</html>