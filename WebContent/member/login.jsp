<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/loginPage.css" rel="stylesheet">
<script type="text/javascript" src="script/member.js"></script>
<title>로그인 페이지</title>
</head>
<body>
    <div class="login-title">
        <h1 id="login-size"><a href="main.do">NFTique</a></h1>
    </div>
    <div class="login-form">
        <form action="login.do" method="post" name="frm1">
            <input type="text" name="userId" class="text-area" placeholder="아이디"><br>
            <input type="password" name="idPwd" class="text-area" placeholder="비밀번호"><br>
            <input type="submit" value="로그인" onclick="return checkLogin()" class="submit-btn"><br>
        </form>
        <div class="links">
            <div>
                <a href="signUp.do">회원가입</a>
            </div>
            <div>
                <a href="findIdPwd.do">아이디/비밀번호 찾기</a>
            </div>
        </div>
    </div>
    <div class="login-form">
        <form method="post" name="frm2">
            <input type="submit" name="kakao-login" value="카카오 로그인" id="kakao-btn"><br>
            <input type="submit" name="naver-login" value="네이버 로그인" id="naver-btn"><br>
            <input type="submit" name="google-login" value="구글 로그인" id="google-btn"><br>
        </form>
    </div>
</body>
</html>