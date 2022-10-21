<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/updateMember.css" rel="stylesheet">
<script type="text/javascript" src="script/member.js"></script>
<title>개인정보 수정페이지</title>
</head>

<%@ include file="../header.jsp" %>
<body>
	<form action="updateMember.do" method="post" name="frm">
		<div class="main-content">
			<div id="content-title">회원정보 조회/수정</div>
			<hr>
			<div class="content-divide">
				<div class="content-left">아이디</div>
				<div class="content-right">
					<input type="text" name="userid" value="${loginUser.userid}" readonly>
				</div>
			</div>
			<hr>
			<div class="content-divide">
				<div class="content-left">비밀번호 변경 (아이디)</div>
				<div class="content-right">
					<div class="content-password">
						<table>
							<tr>
								<td>현재 비밀번호</td>
								<td>
								<input type="hidden" name="idPwdSess" value="${loginUser.idPwd}">
								<input type="password" name="idPwd"></td>

							</tr>
							<tr>
								<td>새 비밀번호</td>
								<td><input type="password" name="newIdPwd" onchange="updateIdPwd()"></td>
							</tr>
							<tr>
								<td>비밀번호 확인</td>
								<td><input type="password" name="newIdPwdCheck" onchange="updateIdPwd()"></td>
							</tr>
							<tr>
								<td></td>
								<td id="checkIdPwd"></td>
							</tr>
						</table>
						
					</div>
				</div>
			</div>
			<hr>
			<div class="content-divide">
				<div class="content-left">이름</div>
				<div class="content-right">
					<input type="text" name="name" value="${loginUser.name}" readonly>
				</div>
			</div>
			<hr>
			<div class="content-divide">
				<div class="content-left">이메일</div>
				<div class="content-right">
					<input type="text" name="e_wallet" value="${loginUser.e_wallet}" readonly>
				</div>
			</div>
			<hr>
			<div class="content-divide">
				<div class="content-left">비밀번호 변경 (이메일)</div>
				<div class="content-right">
					<div class="content-password">
						<table>
							<tr>
								<td>현재 비밀번호</td>
								<td>
								<input type="hidden" name="e_walletPwdSess" value="${loginUser.e_walletPwd}">
								<input type="password" name="e_walletPwd"></td>
							</tr>
							<tr>
								<td>새 비밀번호</td>
								<td><input type="password" name="newE_walletPwd" onchange="updateE_walletPwd()"></td>
							</tr>
							<tr>
								<td>비밀번호 확인</td>
								<td><input type="password" name="newE_walletPwdCheck" onchange="updateE_walletPwd()"></td>
							</tr>
							<tr>
								<td></td>
								<td id="checkE_walletPwd"></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
			<hr>
			<div class="content-divide">
				<div class="content-left">전화번호</div>
				<div class="content-right">
					<input type="text" name="phone" value="${loginUser.phone}">
				</div>
			</div>
			<hr>
			<div class="content-divide">
				<div class="content-left">정보 수신 여부</div>
				<div class="content-right">
					<div class="content-divide">
						<div class="content-agree-left">
							<div>* 서비스 및 이벤트에 대한 메일을 수신하겠습니까?</div>
							<br>
							<div>* 문자정보 서비스를 이용하시겠습니까?</div>
						</div>
						<div class="content-agree-right">
							<div>
								<!-- param.email_agree=="1" email_agree 매개변수에 1이 있을때 true -->
								<input type="radio" name="email_agree" ${(loginUser.email_agree=="1")?"checked":"" } value="1"> 동의 <input
									type="radio" name="email_agree" ${(loginUser.email_agree=="0")?"checked":"" } value="0"> 비동의
							</div>
							<br>
							<div>
								<input type="radio" name="phone_agree" ${(loginUser.phone_agree=="1")?"checked":"" } value="1"> 동의 <input
									type="radio" name="phone_agree" ${(loginUser.phone_agree=="0")?"checked":"" } value="0"> 비동의
							</div>
						</div>
					</div>
				</div>
			</div>
			<hr>
		</div>
		<div class="content-divide" id="button-area">
			<div class="content-left"></div>
			<div class="content-right">
				<input type="submit" value="개인정보수정" onclick="return checkUpdate()"> <input type="reset"
					value="취소">
			</div>
		</div>
	</form>
</body>
<%@ include file="../footer.jsp" %>
</html>