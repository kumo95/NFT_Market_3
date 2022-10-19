<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 상세페이지</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h4 align="center"><small>[공지사항 상세]</small></h4>
<table class="table table-bordered">
	<c:forEach var="notice" items="${noticeList}">
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
			<tr>	
				<td>
					<a href="noticetDetail.do?no=${notice.no}">목록</a>
				</td>
			</tr>			
	</c:forEach>
</table>
	<!-- <input type="button" value="목록" onclick="location.href='noticeList.do'"> -->
</body>
</html>