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
	<h2>비밀번호 찾기</h2>
	<form action="changePwd.do" name="frm" method="post">
		<div style="width: 350px">
			새 비밀번호 : <input type="password" name="idPwd" onchange="checkIdPwd()"><br>
			새 비밀번호 확인 : <input type="password" name="idPwdCheck"
				onchange="checkIdPwd()">
			<p id="checkIdPwd"></p>
		</div>
		</div>
		<br> <input type="hidden" name="userid" value="${userid}">
		<input type="submit" value="비밀번호 변경">
	</form>

</body>
</html>