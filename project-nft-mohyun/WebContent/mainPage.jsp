<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="signUp.do">회원가입</a>
	<br>
	<c:if test="${control==null}">
		<a href="login.do">로그인</a>	
	</c:if>
	<c:if test="${control==1}">
		<a href="logout.do">로그아웃</a>	
		<a href="updateMember.do">개인정보변경</a> 
	</c:if>
</body>
</html>