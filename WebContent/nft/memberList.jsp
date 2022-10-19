<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<title>회원목록 - 관리자 페이지</title>
<!-- <link rel="style" type="text/css" href="css/member.css"> -->
</head>
<body>
<jsp:include page="header.jsp"/>
<h4 align="center"><small>[관리자 회원 목록]</small></h4>
<!-- <form action="deleteMember.do" method="post"> -->
	<table class="table table-bordered">
		<tr>
			<th>이름</th>
			<th>아이디</th>
			<th>비밀번호</th>	
			<th>생년월일</th>
			<th>성별</th>
			<th>이메일</th>
			<th>이메일 비밀번호</th>
			<th>국제번호</th>
			<th>휴대번호</th>
			<th>이메일 수신여부</th>
			<th>문자 수신여부</th>
			<th>관리</th>
		</tr>
			<c:forEach var="member" items="${memberList}">
				<tr>
					<td><c:out value="${member.name}"/></td>
					<td><c:out value="${member.userid}"/></td>
					<td><c:out value="${member.idPwd}"/></td>	
					<td><c:out value="${member.birth}"/></td>
					<td><c:out value="${member.gender}"/></td>
					<td><c:out value="${member.e_wallet}"/></td>
					<td><c:out value="${member.e_walletPwd}"/></td>
					<td><c:out value="${member.nationPhone}"/></td>
					<td><c:out value="${member.phone}"/></td>
					<td><c:out value="${member.email_agree}"/></td>
					<td><c:out value="${member.phone_agree}"/></td>
					<td>
						<a href="deleteMember.do?userid=${member.userid}">삭제</a>
					</td>
				</tr>
			</c:forEach>	
	</table> 	
<!-- </form>  --> 	
</body>
</html>