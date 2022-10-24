<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<script type="text/javascript" src="script/member.js"></script>
</head>
<body>
	<h2>아이디 찾기</h2>

	<form action="login.do" name="frm">
		아이디 : ${userid}입니다.
		<br>
		<br>
		<a href="login.do">로그인하기</a>
		<a href="findIdPwd.do">비밀번호 찾기</a>
	</form>

</body>
</html>