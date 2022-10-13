<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="../css/findIdPwd.css" rel="stylesheet">
<title>아이디/비밀번호 찾기</title>
</head>
<body>

	<div>
		<h1 id="content-title">아이디/비밀번호 찾기</h1>
		<h5 id="content-title-info">* 회원가입시 등록한 정보를 입력하세요.</h5>
	</div>
	<hr>
	<div class="total-content-divide">
		<form class="left-content-id">
			<div>
				<h3 class="index-title">아이디 찾기</h3>
				<div class="info-area">
					<div class="content-divide">
						<div class="content-left">이름</div>
						<div class="content-right">
							<input type="text" name="name">
						</div>
					</div>
					<div class="content-divide">
						<div class="content-left">핸드폰</div>
						<div class="content-right">
							<input type="text" name="phone">
						</div>
					</div>
					<div class="content-divide">
						<div class="content-left">이메일</div>
						<div class="content-right">
							<input type="text" name="email">
						</div>
					</div>
					<div class="content-divide">
						<div class="content-left">인증방식</div>
						<div class="content-right">
							<input type="radio" name="mail-agree" id="radio-phone-id"><label
								for="radio-phone"> 핸드폰</label> <input type="radio"
								name="mail-agree" id="email-phone-id"><label
								for="email-phone"> 이메일</label> <input type="button"
								name="mail-agree" id="receive-conf-id" value="인증번호 받기">
						</div>
					</div>
					<div class="content-divide">
						<div class="content-left">인증번호</div>
						<div class="content-right">
							<input type="text" name="conf-num" placeholder="인증번호를 입력하세요."><br>
						</div>
					</div>
					<div class="content-divide">
						<div class="content-left"></div>
						<div class="content-right">
							<input type="submit" value="아이디 찾기">
						</div>
					</div>
				</div>
			</div>
		</form>
		<form class="right-content-pwd">
			<div>
				<h3 class="index-title">비밀번호 찾기</h3>
				<div class="info-area">
					<div class="content-divide">
						<div class="content-left">아이디</div>
						<div class="content-right">
							<input type="text" name="name">
						</div>
					</div>
					<div class="content-divide">
						<div class="content-left">핸드폰</div>
						<div class="content-right">
							<input type="text" name="phone">
						</div>
					</div>
					<div class="content-divide">
						<div class="content-left">이메일</div>
						<div class="content-right">
							<input type="text" name="email">
						</div>
					</div>
					<div class="content-divide">
						<div class="content-left">인증방식</div>
						<div class="content-right">
							<input type="radio" name="mail-agree" id="radio-phone-pwd"><label
								for="radio-phone"> 핸드폰</label> <input type="radio"
								name="mail-agree" id="email-phone-pwd"><label
								for="email-phone"> 이메일</label> <input type="button"
								name="mail-agree" id="receive-conf-pwd" value="인증번호 받기">
						</div>
					</div>
					<div class="content-divide">
						<div class="content-left">인증번호</div>
						<div class="content-right">
							<input type="text" name="conf-num" placeholder="인증번호를 입력하세요."><br>
						</div>
					</div>
					<div class="content-divide">
						<div class="content-left"></div>
						<div class="content-right">
							<input type="submit" value="비밀번호 찾기">
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>