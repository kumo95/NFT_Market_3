<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/findIdPwd.css" rel="stylesheet">
<script type="text/javascript" src="script/member.js"></script>
<script type="text/javascript" src="script/mail.js"></script>
<title>아이디/비밀번호 찾기</title>
</head>
<%@ include file="../header.jsp" %>
<body>
	<div style="width: 1280px">
		<p id="content-title">아이디/비밀번호 찾기</p>
		<p id="content-title-info">* 회원가입시 등록한 정보를 입력하세요.</p>
		<hr>
	</div>
	<div class="total-content-divide">
		<form class="left-content-id" action="findId.do" method="post"
			name="frmFindId">
			<div>
				<h3 class="index-title">아이디 찾기</h3>
				<div class="info-area">
					<div class="content-divide">
						<div class="content-left">이름</div>
						<div class="content-right">
							<input type="text" name="name" value="${name}">
						</div>
					</div>
					<div class="content-divide">
						<div class="content-left">핸드폰</div>
						<div class="content-right">
							<input type="text" name="phone" value="${phone}">
						</div>
					</div>
					<div class="content-divide">
						<div class="content-left">이메일</div>
						<div class="content-right">
							<input type="text" name="e_wallet" value="${e_wallet}">
						</div>
					</div>
					<div class="content-divide">
						<div class="content-left">인증방식</div>
						<div class="content-right">
							<input type="radio" name="emailAgree" id="radio-phone-id"
								${(emailAgree=="0")?"checked":"" } value="0"><label
								for="radio-phone"> 핸드폰</label> <input type="radio"
								name="emailAgree" id="email-phone-id"
								${(emailAgree=="1")?"checked":"" } value="1"><label
								for="email-phone"> 이메일</label> <input type="button"
								name="sendEmail" onclick="findIdEmail()" id="receive-conf-id"
								value="인증번호 받기">
						</div>
					</div>
					<c:if test="${conMessage==0}">
						<p id="message"
							style="text-align: center; color: red; margin-bottom: 5px">회원
							정보를 확인하세요.</p>
					</c:if>
					<c:if test="${conMessage==1}">
						<p id="message"
							style="text-align: center; color: blue; margin-bottom: 5px">이메일에
							인증번호를 전송했습니다.</p>
					</c:if>
					<div class="content-divide">
						<div class="content-left">인증번호</div>
						<div class="content-right">
							<input type="hidden" name="key" value="${AuthenticationKey}">
							<input type="text" name="idConfNum" placeholder="인증번호를 입력하세요."><br>
						</div>
					</div>
					<div class="content-divide">
						<div class="content-left"></div>
						<div class="content-right">
							<input type="button" value="아이디 찾기" onclick="findIdCheck()">
						</div>
					</div>
				</div>
			</div>
		</form>
		<form class="right-content-pwd" action="findPwd.do" method="post"
			name="frmFindPwd">
			<div>
				<h3 class="index-title">비밀번호 찾기</h3>
				<div class="info-area">
					<div class="content-divide">
						<div class="content-left">아이디</div>
						<div class="content-right">
							<input type="text" name="userid" value="${userid}">
						</div>
					</div>
					<div class="content-divide">
						<div class="content-left">핸드폰</div>
						<div class="content-right">
							<input type="text" name="phone2" value="${phone2}">
						</div>
					</div>
					<div class="content-divide">
						<div class="content-left">이메일</div>
						<div class="content-right">
							<input type="text" name="e_wallet2" value="${e_wallet2}">
						</div>
					</div>
					<div class="content-divide">
						<div class="content-left">인증방식</div>
						<div class="content-right">
							<input type="radio" name="emailAgree2" id="radio-phone-pwd"
								${(emailAgree2=="0")?"checked":"" } value="0"><label
								for="radio-phone"> 핸드폰</label> <input type="radio"
								name="emailAgree2" id="email-phone-pwd"
								${(emailAgree2=="1")?"checked":"" } value="1"><label
								for="email-phone"> 이메일</label> <input type="button"
								name="sendEmail" onclick="findPwdEmail()" id="receive-conf-pwd"
								value="인증번호 받기">
						</div>
					</div>
					<c:if test="${conMessage==2}">
						<p id="message"
							style="text-align: center; color: red; margin-bottom: 5px">회원
							정보를 확인하세요.</p>
					</c:if>
					<c:if test="${conMessage==3}">
						<p id="message"
							style="text-align: center; color: blue; margin-bottom: 5px">이메일에
							인증번호를 전송했습니다.</p>
					</c:if>
					<div class="content-divide">
						<div class="content-left">인증번호</div>
						<div class="content-right">
							<input type="hidden" name="key" value="${AuthenticationKey}">
							<input type="text" name="pwdConfNum" placeholder="인증번호를 입력하세요."><br>
						</div>
					</div>
					<div class="content-divide">
						<div class="content-left"></div>
						<div class="content-right">
							<input type="button" value="비밀번호 찾기" onclick="findPwdCheck()">
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
<%@ include file="../footer.jsp" %>
</html>