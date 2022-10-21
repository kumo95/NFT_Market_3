<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>회원 목록</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css"
	rel="stylesheet">
<link href="styles.css" rel="stylesheet" type="text/css">
<script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js"
	crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="../index/css/header.css">
</head>
<jsp:include page="../header.jsp"/>
<body>
	<h4 align="center"><small>[관리자 회원 목록]</small></h4>
			<!-- <form action="deleteMember.do" method="post"> -->
	<table class="table table-hover">
		<thead class="thead-light">
			<tr>
				<th class="text-center" style="width:7%">이름</th>
				<th class="text-center" style="width:7%">아이디</th>
				<th class="text-center" style="width:8%">비밀번호</th>
				<th class="text-center" style="width:7%">생년월일</th>
				<th class="text-center" style="width:5%">성별</th>
				<th class="text-center" style="width:9%">이메일</th>
				<th class="text-center" style="width:10%">이메일 비번</th>
				<th class="text-center" style="width:5%">나라</th>
				<th class="text-center" style="width:15%">휴대번호</th>
				<th class="text-center" style="width:10%">email수신</th>
				<th class="text-center" style="width:10%">phone수신</th>
				<th class="text-center" style="width:10%">삭제</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="member" items="${memberList}">
			<tr>
				<td class="text-center" style="width:8%">${member.name}</td>
				<td class="text-center" style="width:7%">${member.userid}</td>
				<td class="text-center" style="width:8%">${member.idPwd}</td>
				<td class="text-center" style="width:7%">${member.birth}</td>
				<td class="text-center" style="width:5%">${member.gender}</td>
				<td class="text-center" style="width:9%">${member.e_wallet}</td>
				<td class="text-center" style="width:10%">${member.e_walletPwd}</td>
				<td class="text-center" style="width:5%">${member.nationPhone}</td>
				<td class="text-center" style="width:15%">${member.phone}</td>
				<td class="text-center" style="width:3%">${member.email_agree}</td>
				<td class="text-center" style="width:3%">${member.phone_agree}</td>
				<td>
					<a href="deleteMember.do?userid=${member.userid}">삭제</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>	
<jsp:include page="../footer.jsp"/>
</body>
</html>