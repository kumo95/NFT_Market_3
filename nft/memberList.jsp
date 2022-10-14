<!-- 회원 목록 관리자페이지 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록 - 관리자 페이지</title>
<link rel="style" type="text/css" href="css/member.css">
</head>
<body>
<h2>회원목록조회 - 관리자 페이지</h2>
<!-- <form action="deleteMember.do" method="post"> -->

	<table border="1">
		<tr>
			<th>이름</th>
			<th>아이디</th>
			<th>비밀번호</th>	
			<th>생년월일</th>
			<th>성별</th>
			<th>이메일(전자지갑 아이디)</th>
			<th>이메일(전자지갑 아이디) 비밀번호</th>
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
