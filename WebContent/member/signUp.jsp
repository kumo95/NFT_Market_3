<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/sighUp.css" rel="stylesheet">
<title>회원가입 페이지</title>
<script type="text/javascript" src="script/member.js"></script>
</head>
<body>
	<div class="login-title">
		<h1 id="title-size">NFT Market</h1>
	</div>
	<form class="text-form" action="signUp.do" method="post" name="frm">
		<div class="signUp-form">
			아이디 (사이트 아이디)
			<div class="email-area">
				<input type="text" name="userid" class="text-area" value="${userid}"><br>
				<!-- 중복체크 수행여부 저장 변수  -->
				<input type="hidden" name="checkid" value="${userid}">
				<input type="button" value="중복 체크" onclick="checkId()"
					class="request-certification">			
				<br>
			</div>
			<c:if test="${color==0}">
				<p id="sameId" style="text-align:right;">${message}</p>
			</c:if>
			<c:if test="${color==-1}">
				<p id="sameId" style="text-align:right; color:red">${message}</p>
			</c:if>
			<c:if test="${color==1}">
				<p id="sameId" style="text-align:right; color:blue">${message}</p>
			</c:if>
			<br>
			비밀번호 <input type="password" name="idPwd" onchange="checkIdPwd()" class="text-area"><br>
			비밀번호 확인 <input type="password" name="idPwdCheck" onchange="checkIdPwd()" class="text-area"><br>
			<p id="checkIdPwd"></p>
		</div>
		<div class="signUp-form">
			이름 <input type="text" name="name" class="text-area"><br>
			생년월일 <input type="text" name="birth" class="text-area"
				placeholder="ex) 19990101"><br>
			성별 <br> <select name="gender">
				<option value="">선택</option>
				<option value="male">남성</option>
				<option value="female">여성</option>
			</select> <br>
		</div>
		<div class="signUp-form">
			이메일 (전자지갑 아이디)
			<div class="email-area">
				<input type="text" name="e_wallet" class="input-contact"> <input
					type="button" name="sendEmail" value="인증번호 받기"
					class="request-certification"><br>
			</div>
			<div class="email-area">
				<input type="text" name="emailCertification" class="input-contact"
					placeholder="인증번호를 입력하세요."> <input type="button"
					name="checkEmail" value="인증번호 확인" class="response-certification"><br>
			</div>
			서비스 및 이벤트에 대한 메일을 수신하겠습니까? <br>
			<div class="input-agree">
				<input type="radio" name="email_agree" value="1"> 동의 <input
					type="radio" name="email_agree" value="0"> 비동의
			</div>
			<br> 비밀번호 <input type="password" name="e_walletPwd" onchange="checkE_walletPwd()"
				class="text-area"><br> 비밀번호 확인 <input type="password"
				name="e_walletPwdCheck" onchange="checkE_walletPwd()" class="text-area"><br>
			<p id="checkE_walletPwd"></p>
		</div>
		<div class="signUp-form">
			휴대전화 <br> <select name="nationPhone">
				<option value="kor">대한민국 +82</option>
				<option value="tai">대만 +886</option>
				<option value="mal">말레이시아 +60</option>
				<option value="vie">베트남 +84</option>
				<option value="ind">인도네시아 +62</option>
				<option value="jap">일본 +81</option>
				<option value="chi">중국 +86</option>
			</select> <br>
			<div class="phone-area">
				<input type="text" name="phone" class="input-contact"
					placeholder="ex) 010-1234-5678"> <input type="button"
					name="sendPhone" value="인증번호 받기" class="request-certification"><br>
			</div>
			<div class="email-area">
				<input type="text" name="phoneCertification" class="input-contact"
					placeholder="인증번호를 입력하세요."> <input type="button"
					name="checkPhone" value="인증번호 확인" class="response-certification"><br>
			</div>
			문자정보 서비스를 이용하시겠습니까? <br>
			<div class="input-agree">
				<input type="radio" name="phone_agree" value="1"> 동의 <input
					type="radio" name="phone_agree" value="0"> 비동의
			</div>
			<input type="submit" value="회원가입" onclick="return checkSignUp()"
				class="submit-btn"><br>
		</div>
	</form>
</body>
</html>