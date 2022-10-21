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
<title>관리자 페이지 메인</title>
<link
	href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css"
	rel="stylesheet" />
<link href="styles.css" rel="stylesheet" />
<script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js"
	crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed">
	<nav class="sb-topnav navbar navbar-expand navbar-light bg-light">
		<!-- Navbar Brand-->
		<a class="navbar-brand ps-3" href="index.html">NFTique 관리자</a>
		<!-- Sidebar Toggle-->
		<button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0"
			id="sidebarToggle" href="#!"></button>
		<!-- Navbar-->
	</nav>
	<div id="layoutSidenav">
		<div id="layoutSidenav_nav">
			<nav class="sb-sidenav accordion sb-sidenav-light"
				id="sidenavAccordion">
				<div class="sb-sidenav-menu">
					<div class="nav">

						<!-- Divider -->
						<hr class="sidebar-divider">

						<a class="nav-link" href="../memberList.do"> 회원관리 </a>
						<!-- Divider -->
						<hr class="sidebar-divider">

						<a class="nav-link" href="../nftList.do"> 상품관리 </a>
						<!-- Divider -->
						<hr class="sidebar-divider">

						<a class="nav-link" href="../noticeList.do"> 공지사항 관리 </a>
						<!-- Divider -->
						<hr class="sidebar-divider">

						<a class="nav-link" href="../qnaList.do"> QnA 관리 </a>

					</div>
				</div>
			</nav>
		</div>
	</div>