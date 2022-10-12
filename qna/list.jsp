<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1대1문의 목록</title>
</head>
<body>
<table class="list">
	<tr>
		<td colspan="7" style="border:white; text-align: right; padding: width:310px">
			<input type="button" value="글쓰기" onclick="location.href='../qnaWrite.do'">
			<!-- <a href="../qnaWrite.do">문의글쓰기</a> -->
		</td>
	</tr>
	<tr>
		<th>번호</th>
		<th>글쓴이</th>
		<th>제목</th>
		<th>내용</th>
		<th>사진</th>
		<th>작성일</th>
	</tr>
	<c:forEach var="qna" items="${qnaList}">
		<tr>
<%-- 			<td><c:out value="${qna.no}"/></td> --%>
			<td><c:out value="${qna.userid}"/></td>
			<td><c:out value="${qna.title}"/></td>
			<td><c:out value="${qna.content}"/></td>
			<td><c:out value="${qna.files}"/></td>
			<td><c:out value="${qna.writeDate}"/></td>
			<%-- <td><a href="deleteQna.do?no=${qna.no}">삭제</a></td> --%>
		</tr>
	</c:forEach>
</table>

 
</body>
</html>