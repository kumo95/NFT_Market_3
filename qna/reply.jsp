<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>답글달기</title>
</head>
<body>
	<jsp:include page="header.jsp" />

	<c:forEach var="reply" items="${replyList}">
		<tr>
			<td>${reply.bno}</td>
<%-- 		<td>${reply.reply}</td> --%>
			<td><a href="reply?bno=${reply.bno}">${reply.reply}</a></td>
			<td><a href="reply?bno=${reply.bno}">${reply.replyer}</a></td>
			<td>${reply.replyDate}</td>
			<td>${reply.updateDate}</td>
			<td><a href="deleteQna.do?bno=${qna.bno}">삭제</a></td>
		</tr>
	</c:forEach>

</body>
</html>