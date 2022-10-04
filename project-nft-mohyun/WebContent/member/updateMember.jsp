<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="../css/updateMember.css" rel="stylesheet">
<title>개인정보 수정페이지</title>
</head>
<body>
	<form action="updateMember.do">
		<div class="main-content">
			<div id="content-title">회원정보 조회/수정</div>
			<hr>
			<div class="content-divide">
				<div class="content-left">아이디</div>
				<div class="content-right">
					<input type="text" name="userid" value="${userid}" readonly>
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
								<td><input type="password" name="password"></td>
							</tr>
							<tr>
								<td>새 비밀번호</td>
								<td><input type="password" name="password"></td>
							</tr>
							<tr>
								<td>비밀번호 확인</td>
								<td><input type="password" name="password"></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
			<hr>
			<div class="content-divide">
				<div class="content-left">이름</div>
				<div class="content-right">
					<input type="text" name="name" value="${name}" readonly>
				</div>
			</div>
			<hr>
			<div class="content-divide">
				<div class="content-left">이메일</div>
				<div class="content-right">
					<input type="text" name="mail" value="${mail}" readonly>
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
								<td><input type="password" name="password"></td>
							</tr>
							<tr>
								<td>새 비밀번호</td>
								<td><input type="password" name="password"></td>
							</tr>
							<tr>
								<td>비밀번호 확인</td>
								<td><input type="password" name="password"></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
			<hr>
			<div class="content-divide">
				<div class="content-left">전화번호</div>
				<div class="content-right">
					<input type="text" name="phone" value="${phone}">
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
								<input type="radio" name="mail-agree"> 동의 <input
									type="radio" name="mail-agree"> 비동의
							</div>
							<br>
							<div>
								<input type="radio" name="phone-agree"> 동의 <input
									type="radio" name="phone-agree"> 비동의
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
				<input type="submit" value="개인정보수정"> <input type="reset"
					value="취소">
			</div>
		</div>
	</form>
</body>
</html>