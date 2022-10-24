<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<script type="text/javascript" src="script/member.js"></script>
</head>
<body>
	<h2>비밀번호 변경</h2>
	<form action="changePwd.do" name="frm" method="post">
		<div style="width: 500px; display: flex">
			<div style="width: 150px">새 비밀번호</div>
			<div style="width: 200px">
				<input type="password" name="idPwd" onchange="checkIdPwd()">
			</div>
		</div>
		<div style="width: 500px; display: flex">
			<div style="width: 150px">새 비밀번호 확인</div>
			<div>
				<input type="password" name="idPwdCheck" onchange="checkIdPwd()">
			</div>
		</div>

		<p id="checkIdPwd" style="width: 330px"></p>

		<br> <input type="hidden" name="userid" value="${userid}">
		<input type="submit" value="비밀번호 변경" onclick="return newPasswordCheck()"> <input type="button"
			value="뒤로가기" onclick="history.back(-1);">
	</form>

</body>
</html>