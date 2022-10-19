<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 글쓰기</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div align="center">
	<h4 align="center"><small>[공지사항 글쓰기]</small></h4>
	<form method="post" name="frm" enctype="multipart/form-data">
		<table class="table table-bordered">
			<tr>
				<th class="text-center">작성자</th>
				<td>관리자</td>
			</tr>
			<tr>
				<th class="text-center">제목</th>
				<td><input type="text" name="title" value="[공지]" class="form-control"></td>
			</tr>
			<tr>	
				<th class="text-center">내용</th>
				<td><textarea class="form-control" name="content" placeholder="내용을 입력하세요."></textarea></td>
			</tr>	
			<tr>	
				<th class="text-center">파일 첨부</th>
				<td><input type="file" name="files"></td>
			</tr>
			<tr>	
				<th class="text-center">등록일자</th>
				<td><input class="form-control" type="text" name="writeDate" placeholder="2022-10-13"></td>
			</tr>	
			
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="등록">
					<input type="reset" value="취소" >
					<input type="button" value="목록" onclick="location.href='noticeList.do'">
				</td>
			</tr>
		</table>
	
	</form>
</div>
</body>
</html>