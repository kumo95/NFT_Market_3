<-- 회원 삭제 관리자페이지 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 삭제 페이지</title>
</head>
<body>
	<div id="wrap" align="center">
		<h2>회원 삭제 - 관리자 페이지</h2>
		<form action="deleteMember.do" method="post">
			<table border="1">
				<tr>
					<th>이름</th>
					<th>아이디</th>
					<th>비밀번호</th>
					<th>생년월일</th>
					<th>성별</th>
					<th>이메일(전자지갑)</th>
					<th>이메일(전자지갑) 비밀번호</th>
					<th>국제번호</th>
					<th>휴대번호</th>
					<th>이메일 수신여부</th>
					<th>휴대폰 수신여부</th>
					<th>관리</th>
				</tr>
					<tr>
						<td>${member.name}</td>
						<td>${member.userid}</td>
						<td>${member.idPwd}</td>
						<td>${member.birth}</td>
						<td>${member.gender}</td>
						<td>${member.e_wallet}</td>
						<td>${member.e_walletPwd}</td>
						<td>${member.nationPhone}</td>
						<td>${member.phone}</td>
						<td>${member.email_agree}</td>
						<td>${member.phone_agree}</td>
					</tr>
			</table>
			<input type="hidden" name="userid" value="${member.userid}">
			<input type="submit" value="삭제">
			<input type="button" value="목록" onclick="memberList.do'">
		</form>
	</div>

</body>
</html>
