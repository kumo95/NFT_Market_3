<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>헤더</title>
<link rel="stylesheet" type="text/css" href="index/css/header.css">
</head>
<body>
<!-- Header-->
		<!-- Navigation-->
	<header class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container px-4 px-lg-5">
			<a class="navbar-brand" href="mainPage.jsp">NFTique</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
					<li class="nav-item"><a class="nav-link" href="productList.do">상품</a></li>
				<c:if test="${control==null}">
					<li class="nav-item"><a class="nav-link" href="login.do">창조</a></li>
				</c:if>
				<c:if test="${control==1}">
					<li class="nav-item"><a class="nav-link" href="regist.do">창조</a></li>
				</c:if>
					
					<li class="nav-item"><a class="nav-link" href="#!">커뮤니티</a></li>
					<li class="nav-item"><a class="nav-link" href="#!">고객센터</a></li>
					
				<c:if test="${control==null}">
					<li class="nav-item"><a class="nav-link" href="login.do">마이페이지</a></li>
				</c:if>
				<c:if test="${control==1}">
					<li class="nav-item"><a class="nav-link" href="myPage.do">마이페이지</a></li>
				</c:if>
					
				</ul>
				<form class="d-flex">
						<a href="signUp.do"><button class="btn btn" type="button">회원가입</button></a>
					<c:if test="${control==null}">
						<a href="login.do"><button class="btn btn" type="button">로그인</button></a>
					</c:if>
					<c:if test="${control==1}">
						<a href="logout.do"><button class="btn btn" type="button">로그아웃</button></a>
						<a href="updateMember.do"><button class="btn btn" type="button">개인정보변경</button></a>
					</c:if>
				</form>
			</div>
		</div>
	</header>
</body>
</html>