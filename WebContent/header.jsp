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
	<header class="nft-header">
		<div class="header-area">
			<div class="title-area">
				<a href="main.do">NFTique</a>
			</div>
			<div class="list-area">
				<c:if test="${control==1}">
					<a href="productList.do">상품</a>
					<a href="regist.do">창조</a>
					<a href="community.do">커뮤니티</a>
					<a href="cs.do">고객센터</a>
					<a href="myPage.do">마이페이지</a>
					<c:if test="${loginUser.userid == 'admin'}">
						<a href="admin.do">관리자페이지</a>
					</c:if>
				</c:if>
				<c:if test="${control==null}">
					<a href="productList.do">상품</a>
					<a href="login.do">창조</a>
					<a href="community.do">커뮤니티</a>
					<a href="cs.do">고객센터</a>
					<a href="login.do">마이페이지</a>
				</c:if>
			</div>
			<div class="login-area">
				<c:if test="${control==null}">
					<a href="signUp.do">회원가입</a>
					<a href="login.do">로그인</a>
				</c:if>
				<c:if test="${control==1}">
					<a href="updateMember.do">개인정보변경</a>
					<a href="logout.do">로그아웃</a>
				</c:if>
			</div>
		</div>
	</header>
</body>
</html>